package com.shufensoft.crm.ruleEngine;

import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.exception.UserRemindException;
import com.shufensoft.crm.biz.service.hongbao.HongBaoObtainService;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.vo.HBPoolVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.enums.HBObtainStatus;
import com.shufensoft.crm.ruleEngine.context.RuleContext;
import com.shufensoft.crm.ruleEngine.infoUnit.binding.InfoUnitServiceBinding;
import com.shufensoft.crm.ruleEngine.infoUnit.service.HBInfoUnitService;
import com.shufensoft.crm.ruleEngine.result.EngineResult;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 红包规则引擎
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/21  
 */
public class HBRuleEngine extends RuleEngine {

    private static final Logger logger = Logger.getLogger(HBRuleEngine.class);

    private static HongbaoService hongbaoService;

    private static TaoBaoTradeService taoBaoTradeService;

    private static HongBaoObtainService hongBaoObtainService;


    static {

        /**
         * 红包服务初始化
         */
        hongbaoService = (HongbaoService) SpringContextUtil.getBean("hongbaoService");

        /**
         * 淘宝交易服务初始化
         */
        taoBaoTradeService = (TaoBaoTradeService) SpringContextUtil.getBean("taoBaoTradeService");

        /**
         * 红包领用服务初始化
         */
        hongBaoObtainService = (HongBaoObtainService) SpringContextUtil.getBean("hongBaoObtainService");

        /**
         * 信息元服务绑定对象初始化
         */
        List<InfoUnitServiceBinding> infoUnitServiceBindings = new ArrayList<InfoUnitServiceBinding>();
        infoUnitServiceBindings.add(new InfoUnitServiceBinding(HBInfoUnitService.class, "getUserHBObtainTime",
                UserVO.class, "limitObtainTime"));
        infoUnitServiceBindings.add(new InfoUnitServiceBinding(HBInfoUnitService.class, "getTaobaoOrJdCommentCount",
                UserVO.class, "taobaoOrJdCommentCount"));
        infoUnitServiceBindings.add(new InfoUnitServiceBinding(HBInfoUnitService.class, "getPerPostTimeCount",
                UserVO.class, "perPostTimeCount"));
        infoUnitServiceBindings.add(new InfoUnitServiceBinding(HBInfoUnitService.class, "getAvailablePointAmount",
                UserVO.class, "availablePointAmount"));
        infoUnitServiceBindings.add(new InfoUnitServiceBinding(HBInfoUnitService.class, "getMaxContentLength",
                UserVO.class, "maxContentLength"));
        setInfoUnitServiceBindings(infoUnitServiceBindings);
    }

    public HBRuleEngine(RuleContext ruleContext) {
        this.ruleContext = ruleContext;
    }


    /**
     * 执行规则运算
     */
    @Override
    public EngineResult execute() {

        EngineResult engineResult = new EngineResult();
        engineResult.setErrorCode(EngineResult.ErrorCode.SYS_ERROR);

        long engineResultValue = 0;

        try {

            /**
             * 获取实际对象user对象
             **/

            User user = (User) ruleContext.getFactObj(User.class);
            if (!"hbPraiseBound".equals(ruleContext.getActionType())&&(user == null || user.getUserId() == null)) {
                engineResult.setErrorMessage("HBRuleEngine.execute error,errorMsg:userObj or userId is null");
                logger.error("HBRuleEngine.execute error,errorMsg:userObj or userId is null");
                return engineResult;
            }

            /**
             * 当执行动作为拆红包时
             */
            if ("dismantle".equals(ruleContext.getActionType())) {

                if (ruleContext.getRuleObjId() == null) {
                    engineResult.setErrorMessage("HBRuleEngine.execute error,errorMsg:hbPool or hbPoolId is null");
                    logger.error("HBRuleEngine.execute error,errorMsg:hbPool or hbPoolId is null");
                    return engineResult;
                }

                engineResultValue = hongbaoService.dismantleOtherHongBao(ruleContext.getRuleActionId(), user.getUserId(), ruleContext.getRuleObjId(), ruleContext.getBusinessType(),ruleContext.getSellerId());

                engineResult.setErrorCode(EngineResult.ErrorCode.SUCCESS);
                engineResult.setResult(engineResultValue);

                return engineResult;
            }

            /**
             * 执行红包领取业务,返回红包领取金额
             **/
            if ("pointExchangeBound".equals(ruleContext.getActionType())) {
                hongBaoObtainService.fixExchangeHongbao(user.getUserId(), Long.valueOf(ruleContext.getActionValue()),ruleContext.getSellerId());
            } else if ("hbPraiseBound".equals(ruleContext.getActionType())) {
                UserVO userVO = (UserVO) ruleContext.getFactObj(UserVO.class);
                hongBaoObtainService.fixPraiseHongbao(userVO,ruleContext.getRuleObjId(),ruleContext.getSellerId());
            } else {
                engineResultValue = hongbaoService.receiveHongBao(ruleContext.getRuleObjId(), user.getUserId(), ruleContext.getActionValue(),ruleContext.getSellerId(),ruleContext.getBusinessType());
            }

        } catch (UserRemindException e) {

            engineResult.setErrorCode(EngineResult.ErrorCode.RULE_VERIFY_ERROR);
            logger.error("HBRuleEngine.execute error,errorMsg:" + (e.getMessage() == null ? e.toString() : e.getMessage()), e);
            engineResult.setErrorMessage(e.getMessage().substring(e.getMessage().indexOf("UserRemindException:") + "UserRemindException:".length(), e.getMessage().length()));
            return engineResult;

        } catch (Exception e) {

            logger.error("HBRuleEngine.execute error,errorMsg:" + (e.getMessage() == null ? e.toString() : e.getMessage()), e);
            engineResult.setErrorMessage("HBRuleEngine.execute error,errorMsg:hbPool or hbPoolId is null" + (e.getMessage() == null ? e.toString() : e.getMessage()));
            return engineResult;

        }

        engineResult.setErrorCode(EngineResult.ErrorCode.SUCCESS);
        engineResult.setResult(engineResultValue);

        return engineResult;
    }

    /**
     * 执行初始化规则结果
     */
    @Override
    public void initRuleResultExecute(List<Object> initRuleResultList) {

        long poolId = ruleContext.getRuleObjId();
        AssertsUtil.notNull(poolId, "poolId");

        HBPoolVO hbPoolVO = hongbaoService.getHBPoolVOByPoolId(poolId,ruleContext.getSellerId());
        AssertsUtil.notNull(hbPoolVO, "hbPoolVO");
        String hbPoolName = hbPoolVO.getName();
        long totalAmount = 0;

        for (Object obj : initRuleResultList) {

            HBObtain hbObtain = new HBObtain();
            hbObtain.setPoolId(ruleContext.getRuleObjId());//设置关联对象id
            hbObtain.setPoolName(hbPoolName);
            Map<String, Object> mp = (Map<String, Object>) obj;
            hbObtain.setAmountRange(mp.get("ammout_range").toString());
            totalAmount += Long.valueOf(mp.get("value").toString());
            hbObtain.setHongbaoType(hbPoolVO.getType());
            hbObtain.setAmount(Long.valueOf(mp.get("value").toString()));//存储金额单位为分
            hbObtain.setStatus(HBObtainStatus.TORECEIVE.getCode());//设置红包状态为待领取
            hbObtain.setSellerId(ruleContext.getSellerId());
            hongbaoService.insertObtain(hbObtain);//插入红包领用记录
        }

        /**
         * 更新红包总金额
         */
        hbPoolVO.setTotalAmount(totalAmount);
        hongbaoService.updateHBPoolBySelective(hbPoolVO);

    }


}
