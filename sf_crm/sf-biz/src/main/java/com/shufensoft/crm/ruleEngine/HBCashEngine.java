package com.shufensoft.crm.ruleEngine;

import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.exception.UserRemindException;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.vo.UserAccountVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.ruleEngine.context.RuleContext;
import com.shufensoft.crm.ruleEngine.domain.RuleExpression;
import com.shufensoft.crm.ruleEngine.infoUnit.binding.InfoUnitServiceBinding;
import com.shufensoft.crm.ruleEngine.infoUnit.service.HBInfoUnitService;
import com.shufensoft.crm.ruleEngine.result.EngineResult;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 红包提现规则引擎
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/6/11 16:47  
 */
public class HBCashEngine extends RuleEngine {

    private static final Logger logger = Logger.getLogger(HBCashEngine.class);

    private static HongbaoService hongbaoService;



    public HBCashEngine() {

    }

    public HBCashEngine(RuleContext ruleContext) {
        this.ruleContext = ruleContext;
    }

    static {

        /**
         * 红包服务初始化
         */
        hongbaoService = (HongbaoService) SpringContextUtil.getBean("hongbaoService");

        /**
         * 信息元服务绑定对象初始化
         */
        List<InfoUnitServiceBinding> infoUnitServiceBindings = new ArrayList<InfoUnitServiceBinding>();
        infoUnitServiceBindings.add(new InfoUnitServiceBinding(HBInfoUnitService.class, "getCachCountPerMonth",
                UserVO.class,"cachCountPerMonth"));//添加每月提现数量
//        infoUnitServiceBindings.add(new InfoUnitServiceBinding(HBInfoUnitService.class, "getHbCurrentCashAmount",
//                UserVO.class,"hbCurrentCashAmount"));
        setInfoUnitServiceBindings(infoUnitServiceBindings);
    }

    @Override
    public void initRuleResultExecute(List<Object> initRuleResultList) {

    }

    @Override
    public EngineResult execute() {
        EngineResult engineResult = new EngineResult();
        engineResult.setErrorCode(EngineResult.ErrorCode.SYS_ERROR);
        long  hbCurrentCashAmount=0;
        try{
            /**
             * 获取实际对象user对象和用户账户对象
             **/
            User user = (User) ruleContext.getFactObj(User.class);
            if (user == null || user.getUserId() == null) {
                engineResult.setErrorMessage("HBRuleEngine.execute error,errorMsg:userObj or userId is null");
                logger.error("HBRuleEngine.execute error,errorMsg:userObj or userId is null");
                return engineResult;

               }

            /**
             * 判断用户领用过一块钱的红包
             */
            UserVO userVO=new UserVO();
            userVO.setUserId(user.getUserId());
            if(Long.valueOf(ruleContext.getActionValue())==100&&hongbaoService.getCachCountOneAmmount(userVO,ruleContext.getSellerId())>=1){

                engineResult.setErrorCode(EngineResult.ErrorCode.RULE_VERIFY_ERROR);
                engineResult.setErrorMessage("亲,您已经领用过一块钱的红包,请选择其它面额红包!");
                return engineResult;

            }

            /**
             * 执行红包提现业务
             **/
            hongbaoService.cashHongBao(user,Long.valueOf(ruleContext.getActionValue()),ruleContext.getActionType(),ruleContext.getSellerId());

        }catch (UserRemindException e){

            engineResult.setErrorCode(EngineResult.ErrorCode.RULE_VERIFY_ERROR);
            logger.error("HBCashEngine.execute error,errorMsg:"+(e.getMessage()==null?e.toString():e.getMessage()),e);
            engineResult.setErrorMessage(e.getMessage());
            return engineResult;

        }catch (Exception e){

            logger.error("HBCashEngine.execute error,errorMsg:" + (e.getMessage() == null ? e.toString() : e.getMessage()), e);
            engineResult.setErrorMessage("HBCashEngine.execute error,errorMsg:hbPool or hbPoolId is null"+(e.getMessage()==null?e.toString():e.getMessage()));
            return engineResult;

        }
        engineResult.setErrorCode(EngineResult.ErrorCode.SUCCESS);
        engineResult.setResult(hbCurrentCashAmount);
        return engineResult;
    }

    public Long getHbCurrentCashAmount(UserAccountVO userAccountVO){
        //获取当前用户提现金额
        Long  hbCurrentCashAmount= userAccountVO.getHbCurrentCashAmount();
        List<RuleExpression> ruleExpressions = ruleContext.getRule().getRuleExpressions();//获取规则表达
        Long  cashAmount = Long.valueOf(0);
        for( RuleExpression ruleExpression: ruleExpressions){
            if("{}".equals(ruleExpression.getOperator())){
                String  expectation_value=ruleExpression.getExpectation_value();//获取期望值
                String[] str=expectation_value.split(",");
                for(String  ammout:str){
                    String[] array=ammout.split("/");
                    if( hbCurrentCashAmount.toString().compareTo(array[0])>=0){
                        cashAmount=Long.valueOf(array[0]);
                    }
                }
            }
        }
        return cashAmount;
    }
}
