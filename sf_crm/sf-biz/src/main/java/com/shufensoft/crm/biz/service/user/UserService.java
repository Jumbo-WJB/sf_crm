package com.shufensoft.crm.biz.service.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.reply.WXMessageQueryDAO;
import com.shufensoft.crm.biz.dao.defined.user.UserContributionModelDAO;
import com.shufensoft.crm.biz.dao.defined.user.UserDAO;
import com.shufensoft.crm.biz.dao.generation.user.UserAccountMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserPortraitMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserWxMessageMapper;
import com.shufensoft.crm.biz.domain.defined.user.ContributionModelDO;
import com.shufensoft.crm.biz.domain.defined.user.UserDO;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverJD;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverTaoBao;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverYZ;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.user.*;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.user.vo.ContributionModelVO;
import com.shufensoft.crm.biz.service.user.vo.UserPortraitVO;
import com.shufensoft.crm.biz.service.wx.WXService;
import com.shufensoft.crm.biz.vo.ReceiverDistinctVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-24 16:02  
 */
@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPortraitMapper userPortraitMapper;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserContributionModelDAO userContributionModelDAO;

    @Autowired
    private OnePersonService onePersonService;

    @Autowired
    private WXService wXService;

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private UserWxMessageMapper userWxMessageMapper;

    @Autowired
    private WXMessageQueryDAO wxMessageQueryDAO;

    /**
     * 插入或者更新用户
     *
     * @param userVO
     * @return
     */
    public boolean insertOrUpdateUserAndPortrait(UserVO userVO) {

        AssertsUtil.notNull(userVO, "userVO");
        AssertsUtil.check(userVO.getSellerId() != null && userVO.getSellerId() > 0, "sellerId 非法");

        User user = (User) BeanCopierUtils.copyProperties(userVO, User.class);
        UserPortraitVO userPortraitVO = userVO.getUserPortraitVO();

        if (userPortraitVO != null) {
            insertOrUpdateUserPortait(userPortraitVO);
            user.setUserPortraitId(userPortraitVO.getUserPortraitId());
        }

        List<User> userList = null;
        if (StringUtils.isNotBlank(userVO.getWxOpenid()) || userVO.getUserId() != null) {

            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria().andSellerIdEqualTo(userVO.getSellerId());
            if (StringUtils.isNotBlank(userVO.getWxOpenid())) {
                criteria.andWxOpenidEqualTo(user.getWxOpenid());
            }

            if (userVO.getUserId() != null) {
                criteria.andUserIdEqualTo(user.getUserId());
            }

            userList = userMapper.selectByExample(userExample);
        }

        if (CollectionUtils.isEmpty(userList)) {
            userMapper.insertSelective(user);
            userVO.setId(user.getId());
            userVO.setUserId(user.getUserId());
            return true;
        }

        User userDb = userList.get(0);
        userVO.setId(userDb.getId());
        userVO.setUserId(userDb.getUserId());
        user.setUserId(userDb.getUserId());
        user.setId(userDb.getId());

        if (user.getUserPortraitId() == null) {
            user.setUserPortraitId(userDb.getUserPortraitId());
        }

        return userMapper.updateByPrimaryKeySelective(user) > 0;

    }

    /**
     * 插入或者更新用户画像
     *
     * @param userPortraitVO
     * @return
     */
    public boolean insertOrUpdateUserPortait(UserPortraitVO userPortraitVO) {

        AssertsUtil.notNull(userPortraitVO, "userPortraitVO");
        AssertsUtil.check(userPortraitVO.getSellerId() != null && userPortraitVO.getSellerId() > 0, "sellerId 非法");

        List<UserPortrait> userPortraitList = null;

        UserPortrait userPortrait = (UserPortrait) BeanCopierUtils.copyProperties(userPortraitVO, UserPortrait.class);

        if (userPortrait.getId() != null || userPortrait.getUserPortraitId() != null) {

            UserPortraitExample userPortraitExample = new UserPortraitExample();
            UserPortraitExample.Criteria criteria = userPortraitExample.createCriteria()
                    .andSellerIdEqualTo(userPortrait.getSellerId());

            if (userPortrait.getUserPortraitId() != null) {
                criteria.andUserPortraitIdEqualTo(userPortrait.getUserPortraitId());
            }

            if (userPortrait.getId() != null) {
                criteria.andIdEqualTo(userPortrait.getId());
            }

            userPortraitList = userPortraitMapper.selectByExample(userPortraitExample);
        }


        if (CollectionUtils.isEmpty(userPortraitList)) {
            userPortraitMapper.insertSelective(userPortrait);
            userPortraitVO.setId(userPortrait.getId());
            userPortraitVO.setUserPortraitId(userPortrait.getUserPortraitId());
            return true;
        }

        UserPortrait userPortraitUpdate = userPortraitList.get(0);
        userPortrait.setId(userPortraitUpdate.getId());
        userPortraitVO.setId(userPortrait.getId());
        userPortraitVO.setUserPortraitId(userPortrait.getUserPortraitId());

        return userPortraitMapper.updateByPrimaryKeySelective(userPortrait) > 0;

    }

    /**
     * @param source       如:TB、JD、YZ等，如果该参数为空，指所有平台
     * @param startContribution
     * @param endContribution
     * @return
     * @author litu  2015-07-15  15:23:00
     * 获取用户贡献度模型(各个平台)
     */
    public ContributionModelVO getUserContributionModelFromPlatform(String source, BigDecimal startContribution, BigDecimal endContribution, Long sellerId) {

        if (startContribution == null && endContribution == null) {
            throw new ServiceException("startContribution and endContribution Can't be null at the same time");
        }
        if (StringUtils.isBlank(source)) {
            throw new ServiceException("firstSource Can't be null");
        }
        if (sellerId == null) {
            throw new ServiceException("sellerId Can't be null");
        }

        List<ContributionModelDO> contributionModelDOs = userContributionModelDAO.queryUserContributionModel(source, startContribution, endContribution, sellerId);

        if (CollectionUtils.isEmpty(contributionModelDOs)) {
            return null;
        }

        contributionModelDOs.get(0).setSource(source);

        return (ContributionModelVO) BeanCopierUtils.copyProperties(contributionModelDOs.get(0), ContributionModelVO.class);

    }


    public List<UserPortrait> getUserPortraitByUserPortaitId(Long userPortaitID) {
        UserPortraitExample userPortraitExample = new UserPortraitExample();
        UserPortraitExample.Criteria criteria = userPortraitExample.createCriteria();
        criteria.andUserPortraitIdEqualTo(userPortaitID);
        List<UserPortrait> userPortraits = userPortraitMapper.selectByExample(userPortraitExample);
        return userPortraits;
    }


    /**
     * 用户绑定信息
     *
     * @param sellerId
     * @param wxOpenId
     * @param name
     * @param mobile
     * @param email
     * @return
     */
    public boolean personBound(long sellerId, String wxOpenId, String name, String mobile, String email) {
        if (sellerId <= 0 || StringUtils.isEmpty(wxOpenId) || (StringUtils.isEmpty(name) && StringUtils.isEmpty(mobile)
                && StringUtils.isEmpty(email))) {
            logger.error("illegal argument");
            return false;
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andWxOpenidEqualTo(wxOpenId).andSellerIdEqualTo(sellerId);

        User userUp = new User();
        userUp.setSellerId(sellerId);
        userUp.setWxOpenid(wxOpenId);
        if (!StringUtils.isEmpty(name)) {
            userUp.setName(name);
        }
        if (!StringUtils.isEmpty(mobile)) {
            userUp.setMobile(mobile);
        }
        if (!StringUtils.isEmpty(email)) {
            userUp.setEmail(email);
        }
        userUp.setIsVerify(DaoConstant.IsVerify.YES);

        // 把绑定的用户信息写入DB
        int updateCnt = userMapper.updateByExampleSelective(userUp, userExample);

        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList) || userList.size() > 1) {
            logger.error("user not found: " + wxOpenId);
            return false;
        }

        User userDb = userList.get(0);
        List<ReceiverTaoBao> receiverTaoBaoList = onePersonService.getOnePersonTbList(sellerId, userDb.getUserId());
        if (CollectionUtils.isEmpty(receiverTaoBaoList)) {
            logger.error("receiverTaoBao not found: " + userDb.getUserId());
            return false;
        }

        Long userIdTb = calMainReceiver4Tb(receiverTaoBaoList).getUserIdTb();
        userUp.setUserIdTb(userIdTb);

        return updateCnt > 0;
    }

    /**
     * 计算主收件人
     *
     * @param receiverTaoBaoList
     * @return
     */
    public ReceiverDistinctVO calMainReceiver4Tb(List<ReceiverTaoBao> receiverTaoBaoList) {
        if (CollectionUtils.isEmpty(receiverTaoBaoList)) {
            return null;
        }

        if (receiverTaoBaoList.size() == 1) {
            ReceiverTaoBao receiverTaoBao = receiverTaoBaoList.get(0);
            ReceiverDistinctVO vo = new ReceiverDistinctVO();
            vo.setUserIdTb(receiverTaoBao.getUserIdTb());
            vo.setReceiverName(receiverTaoBao.getReceiverName());
            vo.setReceiverAddress(receiverTaoBao.getReceiverAddress());
            vo.setReceiverMobile(receiverTaoBao.getReceiverMobile());
            vo.setCreated(receiverTaoBao.getCreated());
            vo.setReceiverCountry(receiverTaoBao.getReceiverCountry());
            vo.setReceiverState(receiverTaoBao.getReceiverState());
            vo.setReceiverCity(receiverTaoBao.getReceiverCity());
            return vo;
        }

        List<ReceiverDistinctVO> receiverDistinctVOList = new ArrayList<ReceiverDistinctVO>();
        for (ReceiverTaoBao receiverTaoBao : receiverTaoBaoList) {
            ReceiverDistinctVO vo = new ReceiverDistinctVO();
            vo.setUserIdTb(receiverTaoBao.getUserIdTb());
            vo.setReceiverName(receiverTaoBao.getReceiverName());
            vo.setReceiverAddress(receiverTaoBao.getReceiverAddress());
            vo.setReceiverMobile(receiverTaoBao.getReceiverMobile());
            vo.setCreated(receiverTaoBao.getCreated());
            vo.setReceiverCountry(receiverTaoBao.getReceiverCountry());
            vo.setReceiverState(receiverTaoBao.getReceiverState());
            vo.setReceiverCity(receiverTaoBao.getReceiverCity());

            boolean hasSame = false;
            for (ReceiverDistinctVO receiverDistinctVO : receiverDistinctVOList) {
                if (receiverDistinctVO.toString().equals(vo.toString())) {
                    hasSame = true;
                    // 重复的收件人增加计数cnt
                    receiverDistinctVO.setCnt(receiverDistinctVO.getCnt() + 1);
                    // 取创建时间最大的收件人
                    if (receiverDistinctVO.getCreated().before(vo.getCreated())) {
                        receiverDistinctVO.setCreated(vo.getCreated());
                    }
                }
            }

            if (!hasSame) {
                receiverDistinctVOList.add(vo);
            }
        }

        // 按照收件人次数，收件人最近时间排序
        Collections.sort(receiverDistinctVOList);

        return receiverDistinctVOList.get(0);
    }

    /**
     * 计算主收件人
     *
     * @param receiverYZList
     * @return
     */
    public ReceiverDistinctVO calMainReceiver4YZ(List<ReceiverYZ> receiverYZList) {

        if (CollectionUtils.isEmpty(receiverYZList)) {
            return null;
        }

        if (receiverYZList.size() == 1) {
            ReceiverYZ receiverYZ = receiverYZList.get(0);
            ReceiverDistinctVO vo = new ReceiverDistinctVO();
            vo.setUserIdYz(receiverYZ.getUserIdYz());
            vo.setReceiverName(receiverYZ.getReceiverName());
            vo.setReceiverAddress(receiverYZ.getReceiverAddress());
            vo.setReceiverMobile(receiverYZ.getReceiverMobile());
            vo.setCreated(receiverYZ.getCreated());
            vo.setReceiverState(receiverYZ.getReceiverState());
            vo.setReceiverCity(receiverYZ.getReceiverCity());
            return vo;
        }

        List<ReceiverDistinctVO> receiverDistinctVOList = new ArrayList<ReceiverDistinctVO>();

        for (ReceiverYZ receiverYZ : receiverYZList) {

            ReceiverDistinctVO vo = new ReceiverDistinctVO();

            vo.setUserIdYz(receiverYZ.getUserIdYz());
            vo.setReceiverName(receiverYZ.getReceiverName());
            vo.setReceiverAddress(receiverYZ.getReceiverAddress());
            vo.setReceiverMobile(receiverYZ.getReceiverMobile());
            vo.setCreated(receiverYZ.getCreated());
            vo.setReceiverState(receiverYZ.getReceiverState());
            vo.setReceiverCity(receiverYZ.getReceiverCity());

            boolean hasSame = false;
            for (ReceiverDistinctVO receiverDistinctVO : receiverDistinctVOList) {
                if (receiverDistinctVO.toString().equals(vo.toString())) {
                    hasSame = true;
                    // 重复的收件人增加计数cnt
                    receiverDistinctVO.setCnt(receiverDistinctVO.getCnt() + 1);
                    // 取创建时间最大的收件人
                    if (receiverDistinctVO.getCreated().before(vo.getCreated())) {
                        receiverDistinctVO.setCreated(vo.getCreated());
                    }
                }
            }

            if (!hasSame) {
                receiverDistinctVOList.add(vo);
            }
        }

        // 按照收件人次数，收件人最近时间排序
        Collections.sort(receiverDistinctVOList);

        return receiverDistinctVOList.get(0);
    }

    /**
     * 计算主收件人
     *
     * @param receiverJDList
     * @return
     */
    public ReceiverDistinctVO calMainReceiver4Jd(List<ReceiverJD> receiverJDList) {
        if (CollectionUtils.isEmpty(receiverJDList)) {
            return null;
        }

        if (receiverJDList.size() == 1) {
            ReceiverJD receiverJD = receiverJDList.get(0);
            ReceiverDistinctVO vo = new ReceiverDistinctVO();
            vo.setUserIdJd(receiverJD.getUserIdJd());
            vo.setReceiverName(receiverJD.getFullname());
            vo.setReceiverAddress(receiverJD.getFullAddress());
            vo.setReceiverMobile(receiverJD.getMobile());
            vo.setCreated(receiverJD.getCreated());
            vo.setReceiverState(receiverJD.getProvince());
            vo.setReceiverCity(receiverJD.getCity());
            return vo;
        }

        List<ReceiverDistinctVO> receiverDistinctVOList = new ArrayList<ReceiverDistinctVO>();
        for (ReceiverJD receiverJD : receiverJDList) {
            ReceiverDistinctVO vo = new ReceiverDistinctVO();
            vo.setUserIdJd(receiverJD.getUserIdJd());
            vo.setReceiverName(receiverJD.getFullname());
            vo.setReceiverAddress(receiverJD.getFullAddress());
            vo.setReceiverMobile(receiverJD.getMobile());
            vo.setCreated(receiverJD.getCreated());
            vo.setReceiverState(receiverJD.getProvince());
            vo.setReceiverCity(receiverJD.getCity());

            boolean hasSame = false;
            for (ReceiverDistinctVO receiverDistinctVO : receiverDistinctVOList) {
                if (receiverDistinctVO.toString().equals(vo.toString())) {
                    hasSame = true;
                    // 重复的收件人增加计数cnt
                    receiverDistinctVO.setCnt(receiverDistinctVO.getCnt() + 1);
                    // 取创建时间最大的收件人
                    if (receiverDistinctVO.getCreated().before(vo.getCreated())) {
                        receiverDistinctVO.setCreated(vo.getCreated());
                    }
                }
            }

            if (!hasSame) {
                receiverDistinctVOList.add(vo);
            }
        }

        // 按照收件人次数，收件人最近时间排序
        Collections.sort(receiverDistinctVOList);

        return receiverDistinctVOList.get(0);
    }

    /**
     * 分页查询营销客户
     *
     * @param userVO
     * @param pageNum
     * @param length
     * @return
     */
    public PageInfo queryUserWithPortrait(UserVO userVO, Integer pageNum, Integer length) {

        if (userVO.getSellerId() == null) {
            throw new ServiceException("sellerId Can't be null");
        }

        UserDO userInstance = new UserDO();

        userInstance.setSellerId(userVO.getSellerId());
        /**
         * 增加查询条件：关键词
         */
        if (StringUtils.isNotBlank(userVO.getKeyword())) {
            userInstance.setKeyword(userVO.getKeyword());
        }
        /**
         * 增加查询条件：客户类别
         */
        if (StringUtils.isNotBlank(userVO.getUserType())) {
            userInstance.setIsOldUser(userVO.getUserType());
        }

        /**
         *  增加查询条件：购买金额
         */
        if (StringUtils.isNotBlank(userVO.getMinPrice()) && StringUtils.isNotBlank(userVO.getMaxPrice())) {
            userInstance.setMinPriceNum(new BigDecimal(userVO.getMinPrice()).multiply(new BigDecimal(100)).longValue());
            userInstance.setMaxPriceNum(new BigDecimal(userVO.getMaxPrice()).multiply(new BigDecimal(100)).longValue());
        }
        /**
         * 增加查询条件：购买次数区间 如  “1-2”
         */
        if (StringUtils.isNotBlank(userVO.getPurchaseNum())) {
            String interval = userVO.getPurchaseNum();
            String[] args = interval.split("-");
            if (args[0] != null || args[0].equals("")) {
                userInstance.setMinQuantity(Integer.parseInt(args[0]));
            }
            if (args.length > 1) {
                userInstance.setMaxQuantity(Integer.parseInt(args[1]));
            }
        }
        /**
         * 是否领取过红包
         */
        if (StringUtils.isNotBlank(userVO.getIsReceive())) {
            userInstance.setIsReceivedHb(userVO.getIsReceive());
        }
        /**
         * 积分区间 如“0-1000”
         */
        if (StringUtils.isNotBlank(userVO.getIntegralString())) {
            String integral = userVO.getIntegralString();
            String[] args = integral.split("-");
            if (args[0] != null || args[0].equals("")) {
                userInstance.setMinInteg(Integer.parseInt(args[0]));
            }
            if (args.length > 1) {
                userInstance.setMaxInteg(Integer.parseInt(args[1]));
            }
        }
        /**
         * 互动次数区间 如 “1-5次”
         */
        if (StringUtils.isNotBlank(userVO.getActionTimes())) {
            String actionTimes = userVO.getActionTimes();
            String[] args = actionTimes.split("-");
            if (args[0] != null || args[0].equals("")) {
                userInstance.setMinInteractionsTimes(Integer.parseInt(args[0]));
            }
            if (args.length > 1) {
                userInstance.setMaxInteractionsTimes(Integer.parseInt(args[1]));
            }
        }
        if (StringUtils.isNotBlank(userVO.getHasMobile())) {
            userInstance.setHasMobile(userVO.getHasMobile());
        }
        if (StringUtils.isNotBlank(userVO.getHasEmail())) {
            userInstance.setHasEmail(userVO.getHasEmail());
        }
        /**购买时间间隔 */
        if (StringUtils.isNotBlank(userVO.getTime())) {
            int day = Integer.parseInt(userVO.getTime()); // 7天，30天等
            Long nowTime = new Date().getTime();
            Long dayMill = day * 24 * 60 * 60 * 1000L;
            Long result = nowTime - dayMill;
            userInstance.setLastPurchaseDate(new Date(result));
        }
        /**用户姓名*/
        if (StringUtils.isNotBlank(userVO.getName())) {
            userInstance.setName(userVO.getName());
        }
        /**第一次来源*/
        if (StringUtils.isNotBlank(userVO.getFirstSource())) {
            userInstance.setFirstSource(userVO.getFirstSource());
        }
        /**来源*/
        if (StringUtils.isNotBlank(userVO.getSource())) {
            userInstance.setSource(userVO.getSource());
        }

        /**贡献度开始*/
        if (StringUtils.isNotBlank(userVO.getStartContribution()) && !userVO.getStartContribution().equals("null")) {
            userInstance.setStartContributionNum(new BigDecimal(userVO.getStartContribution()));
        }

        /**贡献度开始*/
        if (StringUtils.isNotBlank(userVO.getEndContribution()) && !userVO.getEndContribution().equals("null")) {
            userInstance.setEndContributionNum(new BigDecimal(userVO.getEndContribution()));
        }

        /**排序条件*/
        if (StringUtils.isNotBlank(userVO.getOrderClause())) {
            userInstance.setOrderClause(userVO.getOrderClause());
        }

        /**是否是成功购买的客户*/
        if (StringUtils.isNotBlank(userVO.getIsSuccessCustom())) {
            userInstance.setIsSuccessCustom(userVO.getIsSuccessCustom());
        }

        /**邮箱选择（字符串）*/
        if (StringUtils.isNotBlank(userVO.getEmailType())) {
            userInstance.setEmailType(userVO.getEmailType());
            String str = userVO.getEmailType();
            if (str.indexOf("qq") > -1) {
                userInstance.setEqq("@qq.com");
            }
            if (str.indexOf("163") > -1) {
                userInstance.setE163("@163.com");
            }
            if (str.indexOf("yahoo") > -1) {
                userInstance.setEyahoo("@yahoo.com");
            }
            if (str.indexOf("126") > -1) {
                userInstance.setE126("@126.com");
            }
        }

        PageHelper.startPage(pageNum, length);
        List users;
        try {
            users = userDAO.selectUserWithPortrait(userInstance);
        } catch (Exception e) {
            throw new ServiceException("查询用户及画像异常" + e);
        }
        return new PageInfo(users);
    }

    /**
     * 获取手机号不为空或邮箱不为空的用户数量
     *
     * @return
     */
    public Integer getUserCount(String param, Long sellerId) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        if ("sms".equals(param)) {
            criteria.andMobileIsNotNull();
            criteria.andMobileNotEqualTo("");
        } else if ("email".equals(param)) {
            criteria.andEmailIsNotNull();
            criteria.andEmailNotEqualTo("");
        }
        return userMapper.countByExample(example);
    }

    /**
     * 根据查询条件获取用户列表
     *
     * @param userVO
     * @return
     */
    public List<User> getUserList(UserVO userVO) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        if (StringUtils.isNotBlank(userVO.getWxNickName())) {
            criteria.andWxNickNameLike(userVO.getWxNickName());
        }
        if (StringUtils.isNotBlank(userVO.getMobile())) {
            criteria.andMobileEqualTo(userVO.getMobile());
        }
        if (StringUtils.isNotBlank(userVO.getIsVerify())) {
            criteria.andIsVerifyEqualTo(userVO.getIsVerify());
        }
        if (StringUtils.isNotBlank(userVO.getWxOpenid())) {
            criteria.andWxOpenidEqualTo(userVO.getWxOpenid());
        }
//        if (StringUtils.isNotBlank(userVO.getTime())){
//            int day = Integer.parseInt(userVO.getTime()); // 7天，30天等
//            Long nowTime = new Date().getTime();
//            Long dayMill = day * 24* 60 * 60 * 1000L;
//            Long result = nowTime - dayMill;
//        }
        if (userVO.getSellerId() != null) {
            criteria.andSellerIdEqualTo(userVO.getSellerId());
        }
        if (StringUtils.isNotBlank(userVO.getIsReceive())) {
            criteria.andIsReceivedHbEqualTo(userVO.getIsReceive());
        }
        List<User> list;
        try {
            list = userMapper.selectByExample(userExample);
        } catch (Exception e) {
            throw new ServiceException("获取用户列表异常：" + e);
        }
        return list;
    }


    /**
     * 根据淘宝用户ID查询用户信息
     *
     * @param sellerId 商户ID
     * @param tbUserId 淘宝用户ID
     * @return
     */
    public User getUserByTbUserId(Long sellerId, Long tbUserId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andUserIdTbEqualTo(tbUserId);

        List<User> userList = userMapper.selectByExample(userExample);

        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);

        }

        return null;
    }

    /**
     * 根据京东用户ID查询用户信息
     *
     * @param sellerId 商户ID
     * @param jdUserId 京东用户ID
     * @return
     */
    public User getUserByJdUserId(Long sellerId, Long jdUserId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andUserIdJdEqualTo(jdUserId);

        List<User> userList = userMapper.selectByExample(userExample);

        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);

        }

        return null;
    }

    /**
     * 根据有赞用户ID查询用户信息
     *
     * @param sellerId 商户ID
     * @param yzUserId 京东用户ID
     * @return 用户信息
     */
    public User getUserByYzUserId(Long sellerId, Long yzUserId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andUserIdYzEqualTo(yzUserId);

        List<User> userList = userMapper.selectByExample(userExample);

        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);

        }

        return null;
    }

    /**
     * 根据userId查询用户
     *
     * @param userId
     * @return
     */
    public UserDO getUserAndPortrait(Long userId, Long sellerId) {
        UserDO userDO = new UserDO();
        userDO.setSellerId(sellerId);
        userDO.setUserId(userId);

        if (userDAO.selectUserWithPortrait(userDO).size() > 0) {
            return userDAO.selectUserWithPortrait(userDO).get(0);
        }
        return null;
    }


    /**
     * 根据sellerId, userId查询用户
     *
     * @param sellerId
     * @param userId
     * @return
     */
    public User findUserBySellerIdAndUserId(Long sellerId, Long userId) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId);

        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        }

        return null;
    }


    /**
     * 根据userId查找用户画像
     *
     * @param userId
     * @return
     */
    public UserPortrait findPortraitByUserId(Long userId, Long sellerId) {
        User user = findUserBySellerIdAndUserId(userId, sellerId);
        UserPortraitExample example = new UserPortraitExample();
        example.createCriteria().andUserPortraitIdEqualTo(user.getUserPortraitId());

        List<UserPortrait> list = userPortraitMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }

        return null;
    }


    /**
     * 根据openid查找用户
     *
     * @param openId
     * @return
     */
    public UserVO findUserByOpenId(Long sellerId, String openId) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andSellerIdEqualTo(sellerId).andWxOpenidEqualTo(openId);

        List<User> users = userMapper.selectByExample(userExample);
        if (!CollectionUtils.isEmpty(users)) {
            return (UserVO) BeanCopierUtils.copyProperties(users.get(0), UserVO.class);
        }

        return null;

    }


    /**
     * 根据userId判断是否是老用户
     *
     * @return
     */
    public boolean isOldUserByUserId(Long UserId, Long sellerId) {
        boolean result = false;

        UserDO userDO = getUserAndPortrait(UserId, sellerId);

        if (userDO != null) {

            if ("1".equals(userDO.getIsOldUser())) {
                result = true;
            }
        }
        return result;
    }


    /**
     * 根据openId判断是否是老客户
     *
     * @param openId
     * @return true/false
     */
    public boolean isOldUserByOpenId(Long sellerId, String openId) {

        boolean result = false;

        UserVO userVO = findUserByOpenId(sellerId, openId);

        if (userVO != null) {

            if ("1".equals(userVO.getIsOldUser())) {
                result = true;
            }
        }
        return result;

    }


    /**
     * 用户是否已关注
     *
     * @param userId
     * @return true/false
     */
    public boolean isSubscribeByUserId(Long userId, Long sellerId) {

        boolean result = false;

        User user = findUserBySellerIdAndUserId(sellerId, userId);

        if (user != null) {

            if ("1".equals(user.getWxSubscribe())) {
                result = true;
            }
        }
        return result;

    }

    /**
     * 用户是否已关注
     *
     * @param openId
     * @return true/false
     */
    public boolean isSubscribeByOpenId(Long sellerId, String openId) {

        boolean result = false;

        UserVO userVO = findUserByOpenId(sellerId, openId);

        if (userVO != null) {

            if ("1".equals(userVO.getWxSubscribe())) {
                result = true;
            }
        }
        return result;

    }

    /**
     * 用户是否已验证
     *
     * @param openId
     * @return true/false
     */
    public boolean isVerify(Long sellerId, String openId) {

        boolean result = false;

        UserVO userVO = findUserByOpenId(sellerId, openId);

        if (userVO != null) {

            if ("1".equals(userVO.getIsVerify())) {
                result = true;
            }
        }
        return result;

    }

    /**
     * 根据userID查询用户是否已验证
     *
     * @param userId 用户ID
     * @return true/false
     */
    public boolean isVerify(Long userId, Long sellerId) {

        boolean result = false;

        User user = findUserBySellerIdAndUserId(userId, sellerId);

        if (user != null) {

            if ("1".equals(user.getIsVerify())) {

                result = true;
            }
        }
        return result;
    }


    /**
     * 根据微信授权创建用户信息
     *
     * @param sellerId
     * @param openId
     * @param accessToken
     */
    public UserVO createAndReturnWXUserToUser(String sellerId, String openId, String accessToken) {

        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId);

        UserVO userVO;
        try {

            userVO = wXService.getOuathUserInfo(openId, accessToken, sellerConfigInfo.getSellerId());

            if (userVO != null) {
                userVO.setFirstSource(DaoConstant.UserSource.WX);
                userVO.setSource(DaoConstant.UserSource.WX);
                userVO.setWxSubscribe("0");
                userVO.setSellerId(Long.valueOf(sellerId));
                UserPortraitVO userPortraitVO = new UserPortraitVO();
                userPortraitVO.setUserPortraitId(userVO.getUserPortraitId());
                userPortraitVO.setSellerId(Long.valueOf(sellerId));
                userVO.setUserPortraitVO(userPortraitVO);
                insertOrUpdateUserAndPortrait(userVO);
            }

        } catch (Exception e) {

            logger.error("createAndReturnWXUserToUser error ", e);
            throw new ServiceException("createAndReturnWXUserToUser error", e);

        }

        return userVO;
    }


    /**
     * 根据营销类型更新画像表中相关的发送统计信息
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     */
    public void updateUserPortrait(Long sellerId, Long userId, String type) {

        try {
            User user = findUserBySellerIdAndUserId(sellerId, Long.valueOf(userId));

            if (user != null) {

                UserPortraitExample userPortraitExample = new UserPortraitExample();
                UserPortraitExample.Criteria criteria = userPortraitExample.createCriteria();
                criteria.andUserPortraitIdEqualTo(user.getUserPortraitId());
                List<UserPortrait> userPortraitList = userPortraitMapper.selectByExample(userPortraitExample);
                if (userPortraitList != null && !userPortraitList.isEmpty()) {
                    UserPortrait userPortrait = userPortraitList.get(0);

                    if ("SMS".equals(type)) {
                        if (userPortrait.getSmsAcceptNumber() == null) {
                            userPortrait.setSmsAcceptNumber(1);
                        } else {
                            userPortrait.setSmsAcceptNumberExpression("sms_accept_number + " + 1);
                        }

                    } else if ("MAIL".equals(type)) {

                        if (userPortrait.getSmsAcceptNumber() == null) {
                            userPortrait.setEmailAcceptNumber(1);
                        } else {
                            userPortrait.setEmailAcceptNumberExpression("email_accept_number + " + 1);
                        }

                    }

                    userPortraitMapper.updateByPrimaryKeySelective(userPortrait);

                }
            }
        } catch (Exception e) {
            logger.error("UserService updateUserPortrait is error.", e);
        }


    }

    /**
     * 根据userId查询用户帐户信息
     *
     * @param userId 用户ID
     * @return 用户帐户信息
     */
    public UserAccount getUserPointCount(Long sellerId, Long userId) {

        UserAccountExample userAccountExample = new UserAccountExample();
        userAccountExample.createCriteria().andUserIdEqualTo(userId).andSellerIdEqualTo(sellerId);

        List<UserAccount> userAccountList = userAccountMapper.selectByExample(userAccountExample);

        UserAccount userAccount = null;

        if (userAccountList != null && !userAccountList.isEmpty()) {
            userAccount = userAccountList.get(0);

        }

        return userAccount;

    }


    /**
     * 查找
     *
     * @param userId
     * @return
     */
    public int findPortrait(Long userId, Long sellerId) {
        UserDO userDO = new UserDO();
        userDO.setSellerId(sellerId);
        userDO.setUserId(userId);
        userDO.setWithPortrait("1");

        List result;
        try {
            result = userDAO.selectUserWithPortrait(userDO);
        } catch (Exception e) {
            throw new ServiceException("查找用户画像异常：" + e);
        }

        if (result.size() > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 查找
     *
     * @param portraitId
     * @return
     */
    public UserDO findPortraitById(Long portraitId, Long sellerId) {
        UserDO userDO = new UserDO();
        userDO.setUserPortraitId(portraitId);
        userDO.setSellerId(sellerId);

        List<UserDO> result;
        try {
            result = userDAO.selectUserWithPortrait(userDO);
        } catch (Exception e) {
            throw new ServiceException("查找用户画像异常：" + e);
        }

        return result.get(0);
    }


    //查找有某个邮箱的用户
    public int findEmailUser(String str, Long sellerId) {
        UserDO userDO = new UserDO();
        userDO.setSellerId(sellerId);

        if (str.indexOf("qq") > -1) {
            userDO.setEqq("@qq.com");
        }
        if (str.indexOf("163") > -1) {
            userDO.setE163("@163.com");
        }
        if (str.indexOf("yahoo") > -1) {
            userDO.setEyahoo("@yahoo.com");
        }
        if (str.indexOf("126") > -1) {
            userDO.setE126("@126.com");
        }

        return userDAO.selectCount(userDO);
    }

    /**
     * 根据openID查询用户帐户信息
     *
     * @param opentID
     * @return
     */
    public Map<String, Object> getUserAccountInfo(String opentID) {

        Map<String, Object> objectMap = null;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andWxOpenidEqualTo(opentID);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && !userList.isEmpty()) {
            objectMap = new HashMap<String, Object>();
            User userInfo = userList.get(0);
            objectMap.put("user", userInfo);
            UserAccountExample userAccountExample = new UserAccountExample();
            userAccountExample.createCriteria().andUserIdEqualTo(userInfo.getUserId());
            List<UserAccount> userAccountList = userAccountMapper.selectByExample(userAccountExample);
            if (userAccountList != null && !userAccountList.isEmpty()) {
                objectMap.put("userAccount", userAccountList.get(0));
                return objectMap;
            }
        }
        return objectMap;
    }

    /**
     * 获取关注商家公众号的用户openId列表(群发接口使用)
     * @param userVO
     * @param pageNum
     * @param length
     * @return
     */
    public Map<String, List> getWxMassToUser(UserVO userVO, Integer pageNum, Integer length){

        if (userVO.getSellerId() == null) {
            logger.error("sellerId must not be null");
            return null;
        }

        List<String> toUser = new ArrayList<String>();
        List<Long> userIds = new ArrayList<Long>();

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(userVO.getSellerId());

        if (StringUtils.isNotBlank(userVO.getWxSubscribe())){
            criteria.andWxOpenidIsNotNull();
            criteria.andWxSubscribeEqualTo(userVO.getWxSubscribe());
        }

        PageHelper.startPage(pageNum, length);
        List<User> userList = userMapper.selectByExample(example);

        if (CollectionUtils.isEmpty(userList)){
            return null;
        }

        for (User user : userList){
            if (StringUtils.isNotBlank(user.getWxOpenid())){
                toUser.add(user.getWxOpenid());
                userIds.add(user.getUserId());
            }
        }

        Map<String, List> map = new HashMap<String, List>();
        map.put("toUser",toUser);
        map.put("userIdList",userIds);

        return map;
    }

    /**
     * 获取关注商家公众号的用户数量
     * @param sellerId
     * @return
     */
    public Integer getSubsribeUserCount(Long sellerId){

        AssertsUtil.notNull(sellerId,"sellerId");

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andWxOpenidIsNotNull();
        criteria.andWxSubscribeEqualTo("1");

        int count = userMapper.countByExample(example);

        return count;
    }

    /**
     * 获取48小时内所有互动过的用户openid列表（客服接口使用）
     * @param userVO
     * @param pageNum
     * @param length
     * @return
     */
    public Map<String, List> getWxCustomToUser(User userVO, Integer pageNum, Integer length){

        if (userVO.getSellerId() == null) {
            logger.error("sellerId must not be null");
            return null;
        }

        List<String> toUser = new ArrayList<String>();
        List<Long> userIds = new ArrayList<Long>();

        PageHelper.startPage(pageNum,length);
        List<UserWxMessage> list = wxMessageQueryDAO.queryWxInteractiveUser(userVO.getSellerId());

        if (CollectionUtils.isEmpty(list)){
            return null;
        }

        for (UserWxMessage wxMessage : list){
            if (StringUtils.isNotBlank(wxMessage.getWxOpenid())){
                toUser.add(wxMessage.getWxOpenid());
                userIds.add(wxMessage.getUserId());
            }
        }

        Map<String, List> map = new HashMap<String, List>();
        map.put("toUser",toUser);
        map.put("userIdList",userIds);

        return map;
    }

    /**
     * 获取48小时内所有互动过的用户数量
     * @param sellerId
     * @return
     */
    public Integer getInteractiveUserCount(Long sellerId){

        AssertsUtil.notNull(sellerId,"sellerId");

        return wxMessageQueryDAO.countWxInteractiveUser(sellerId);
    }

}
