package com.shufensoft.crm.biz.service.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.dao.defined.user.UserValidateDAO;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserValidateMapper;
import com.shufensoft.crm.biz.domain.defined.user.UserValidateDO;
import com.shufensoft.crm.biz.domain.generation.send.SendWxMessage;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserExample;
import com.shufensoft.crm.biz.domain.generation.user.UserValidate;
import com.shufensoft.crm.biz.domain.generation.user.UserValidateExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.point.PointMultipleService;
import com.shufensoft.crm.biz.service.reply.KeyWordReplyService;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.service.trade.YouZanTradeService;
import com.shufensoft.crm.biz.vo.UserValidateVO;
import com.shufensoft.crm.common.utils.StringUtils;
import com.shufensoft.crm.common.utils.exception.ExecelException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>客户验证服务层
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/6/29  
 */
@Service
public class UserValidateService {

    private static final Logger logger = Logger.getLogger(UserValidateService.class);

    @Autowired
    private UserValidateDAO userValidateDAO;

    @Autowired
    private UserValidateMapper userValidateMapper;

    @Autowired
    private PointMultipleService pointMultipleService;

    @Autowired
    private KeyWordReplyService keyWordReplyService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserBoundService userBoundService;

    @Autowired
    private TaoBaoTradeService taoBaoTradeService;

    @Autowired
    private JdTradeService jdTradeService;

    @Autowired
    private YouZanTradeService youZanTradeService;

    @Autowired
    private UserService userService;

    private final static String ErrorCode = "errCode";
    private final static String ErrorMsg = "errMsg";

    /**
     * 验证码失效时间 120秒
     */
    private final static Integer Expire_time = 120;

    /**
     * 分页查询用户验证信息
     *
     * @param userValidateVO
     * @param pageNum
     * @param length
     * @return
     */
    public PageInfo getValidationList(UserValidateVO userValidateVO, Integer pageNum, Integer length) {
        if (StringUtils.isBlank(userValidateVO.getSellerId())) {
            throw new ServiceException("sellerId Can't be null");
        }

        UserValidateDO userValidateDO = new UserValidateDO();
        userValidateDO.setSellerId(Long.valueOf(userValidateVO.getSellerId()));

        if (StringUtils.isNotBlank(userValidateVO.getWxNickName())) {
            userValidateDO.setWxNickName(userValidateVO.getWxNickName());
        }
        if (StringUtils.isNotBlank(userValidateVO.getMobile())) {
            userValidateDO.setMobile(userValidateVO.getMobile());
        }
        if (StringUtils.isNotBlank(userValidateVO.getTime())) {
            //获取客户端输入的天数
            int day = Integer.parseInt(userValidateVO.getTime());
            Long nowTime = new Date().getTime();
            Long dayMill = day * 24 * 60 * 60 * 1000L;
            Long result = nowTime - dayMill;
            userValidateDO.setValidateDate(new Date(result));
        }
        if (StringUtils.isNotBlank(userValidateVO.getResult())) {
            userValidateDO.setResult(userValidateVO.getResult());
        }

        PageHelper.startPage(pageNum, length);
        List<UserValidateDO> list;
        try {
            list = userValidateDAO.selectValidateResult(userValidateDO);
        } catch (Exception e) {
            throw new ServiceException("用户验证查询异常：" + e);
        }
        return new PageInfo(list);
    }

    /**
     * 更新验证信息表
     *
     * @param userValidateVO
     */
    public void insertOrUpdate(UserValidateVO userValidateVO) {
        UserValidate userValidate = new UserValidate();

        if (StringUtils.isNotBlank(userValidateVO.getMobile())) {
            userValidate.setMobile(userValidateVO.getMobile());
        }
        if (StringUtils.isNotBlank(userValidateVO.getCode())) {
            userValidate.setCode(userValidateVO.getCode());
        }
        userValidate.setValidateDate(new Date());//验证时间
        userValidate.setInvalidTime(Expire_time);//验证失效时间
        if (StringUtils.isNotBlank(userValidateVO.getResult())) {
            userValidate.setResult(userValidateVO.getResult());
        }
        if (StringUtils.isNotBlank(userValidateVO.getStatus())) {
            userValidate.setStatus(userValidate.getStatus());
        }

        if (userValidateVO.getUserId() != null) {
            Long userId = userValidateVO.getUserId();
            UserValidateExample example = new UserValidateExample();
            UserValidateExample.Criteria criteria = example.createCriteria();
            criteria.andSellerIdEqualTo(Long.valueOf(userValidateVO.getSellerId())).andUserIdEqualTo(userId);
            List list = userValidateMapper.selectByExample(example);
            try {
                if (CollectionUtils.isEmpty(list)) {
                    /**添加 */
                    userValidate.setUserId(userId);
                    userValidateMapper.insertSelective(userValidate);
                } else {
                    /**跟新*/
                    userValidateMapper.updateByExampleSelective(userValidate, example);
                }
            } catch (Exception e) {
                throw new ServiceException("更新用户验证记录表异常：" + e);
            }

        } else {
            logger.info("更新验证表失败");
        }

    }


    /**
     * 验证用户
     *
     * @param userValidateVO
     * @return
     */
    public Map<String, Object> userValidate(String sellerId, UserValidateVO userValidateVO) {

        Map<String, Object> map = Maps.newHashMap();

        Long userId = userValidateVO.getUserId();
        String code = userValidateVO.getCode();
        UserValidateExample example = new UserValidateExample();
        UserValidateExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(Long.valueOf(sellerId)).andUserIdEqualTo(userId);
        List<UserValidate> ValidateList = userValidateMapper.selectByExample(example);

        UserExample wxUserExample = new UserExample();
        wxUserExample.createCriteria().andSellerIdEqualTo(Long.valueOf(sellerId)).andUserIdEqualTo(userId);
        List<User> userList = userMapper.selectByExample(wxUserExample);
        User wxUser = userList.get(0);

        if ("1".equals(userValidateVO.getIsVerified())){
            /**该用户已经验证，无需验证码验证*/
            if (StringUtils.isBlank(userValidateVO.getTbBuyerNick()) && StringUtils.isBlank(userValidateVO.getJdPin()) && StringUtils.isBlank(userValidateVO.getYzBuyerNick())) {
                /** 此时不用整合，直接向user表插入生日字段*/
                if (userValidateVO.getBirthday() != null) {
                    wxUser.setBirthday(userValidateVO.getBirthday());
                } else {
                    map.put(ErrorCode, "-1");
                    map.put(ErrorMsg, "请填写您的生日信息");
                    return map;
                }
                userMapper.updateByExampleSelective(wxUser, wxUserExample);
                map.put(ErrorCode, "0");
                map.put(ErrorMsg, "生日绑定成功");
                return map;
            }
        } else {
            /**
             * 用户第一次验证
             * 1.手机验证码验证
             */
            if (CollectionUtils.isEmpty(ValidateList)) {
                map.put(ErrorCode, "-1");
                map.put(ErrorMsg, "请先获取验证码");
                return map;
            } else {
                UserValidate userValidate = ValidateList.get(0);
                Long now = new Date().getTime();
                Long createdTime = userValidate.getGmtModified().getTime();
                Long interval = Long.valueOf(userValidate.getInvalidTime());
                if (!userValidate.getCode().equals(code)) {
                    map.put(ErrorCode, "-1");
                    map.put(ErrorMsg, "验证码错误,请重新验证");
                    return map;
                }
                if (now - createdTime > (interval * 1000)) {
                    map.put(ErrorCode, "-1");
                    map.put(ErrorMsg, "验证码已失效，请重新验证");
                    return map;
                }
            }

            /***
             * 记录用户信息
             */
            wxUser.setMobile(userValidateVO.getMobile());
            wxUser.setIsVerify("1");
            if (userValidateVO.getBirthday() != null) {
                wxUser.setBirthday(userValidateVO.getBirthday());
            }
            userMapper.updateByExampleSelective(wxUser, wxUserExample);

            UserValidate record = ValidateList.get(0);
            record.setOpenid(wxUser.getWxOpenid());
            record.setResult("1");
            userValidateMapper.updateByExampleSelective(record, example);
        }


        /**
         * 2.同人模型整合
         */
        UserBoundResponse result;
        try {
            result = userBoundService.bind(Long.valueOf(sellerId), userValidateVO.getUserId(),
                    userValidateVO.getMobile(), userValidateVO.getTbBuyerNick(), userValidateVO.getJdPin());
        } catch (Exception e) {
            throw new ExecelException("用户绑定异常：" + e);
        }


        int errorCode = result.getErrorCode();

        if ("0".equals(errorCode)) {

            /**
             * 创建购物积分
             */
            createBuyPointByValidate(Long.valueOf(sellerId), wxUser.getUserId());

        }

        String errorMessage = "";
        if (errorCode == 1002){
            errorMessage = "不过根据您的淘宝账号未找到对应信息";
        }else if (errorCode == 1003){
            errorMessage = "不过根据您的京东账号未找到对应信息";
        }

        String userMessage;
        switch (errorCode) {
            default:
                userMessage = "亲，恭喜您认证成功了！";
        }
        userMessage = userMessage + errorMessage;

        /**
         * 认证成功后，微信公众向用户发送一条引导语信息
         */
        try {
            SendWxMessage message = new SendWxMessage();
            message.setSellerId(Long.valueOf(userValidateVO.getSellerId()));
            message.setTouser(wxUser.getWxOpenid());
            message.setMsgtype("text");
            /**引导语信息*/
            String content = (keyWordReplyService.queryKeyWordReplyConfigByType(Long.valueOf(sellerId), "guide")).getSuccessReplyContent();
            message.setContent(content);
            pointMultipleService.sendWxMessageToUser(message);
        } catch (Exception e) {
            logger.info("认证成功，公众号发送引导语信息失败：" + e);
        }

        map.put(ErrorCode, "0");
        map.put(ErrorMsg, userMessage);
        return map;
    }


    /**
     * 用户验证绑定后触发创建购物积分
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     */
    public void createBuyPointByValidate(Long sellerId, Long userId) {

        User user = userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), userId);

        if (user != null) {


            try {

                if (user.getUserIdTb() != null) {

                    taoBaoTradeService.createTaobaoBuyPointByUserIdTb(Long.valueOf(sellerId), user.getUserIdTb());

                    logger.info("用户:" + userId + "创建淘宝购物积分成功。");
                }

                if (user.getUserIdJd() != null) {

                    jdTradeService.createJdBuyPointByUserIdTb(Long.valueOf(sellerId), user.getUserIdJd());

                    logger.info("用户:" + userId + "创建京东购物积分成功。");
                }

                if (user.getUserIdYz() != null) {

                    youZanTradeService.createYzdBuyPointByUserIdYz(Long.valueOf(sellerId), user.getUserIdYz());

                    logger.info("用户:" + userId + "创建有赞购物积分成功。");
                }

            } catch (Exception e) {

                logger.error("用户绑定后处理创建购物积分失败。", e);
            }

        }


    }
}
