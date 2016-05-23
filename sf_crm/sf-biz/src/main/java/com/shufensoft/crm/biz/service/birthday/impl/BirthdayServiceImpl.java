package com.shufensoft.crm.biz.service.birthday.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.birthday.BirthdayDAO;
import com.shufensoft.crm.biz.dao.defined.birthday.BirthdayReminderDAO;
import com.shufensoft.crm.biz.dao.defined.present.PresentDAO;
import com.shufensoft.crm.biz.dao.defined.user.UserDAO;
import com.shufensoft.crm.biz.dao.generation.birthday.UserBirthdayConfigMapper;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBPoolMapper;
import com.shufensoft.crm.biz.dao.generation.pointmall.MallGoodsMapper;
import com.shufensoft.crm.biz.dao.generation.present.PresentMapper;
import com.shufensoft.crm.biz.dao.generation.recordsActivity.ActivityRecordsMapper;
import com.shufensoft.crm.biz.domain.defined.birthday.BirthdayActivityDetailsDO;
import com.shufensoft.crm.biz.domain.defined.birthday.BirthdayDO;
import com.shufensoft.crm.biz.domain.defined.birthday.UserBirthdayReminderDO;
import com.shufensoft.crm.biz.domain.defined.user.UserDO;
import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfig;
import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfigExample;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPool;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPoolExample;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoods;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoodsExample;
import com.shufensoft.crm.biz.domain.generation.present.Present;
import com.shufensoft.crm.biz.domain.generation.present.PresentExample;
import com.shufensoft.crm.biz.domain.generation.recordsActivity.ActivityRecords;
import com.shufensoft.crm.biz.domain.generation.recordsActivity.ActivityRecordsExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.birthday.BirthdayService;
import com.shufensoft.crm.biz.service.birthday.vo.BirthdayConfigVO;
import com.shufensoft.crm.biz.service.birthday.vo.UserBirthdayReminderVO;
import com.shufensoft.crm.biz.vo.HBPoolVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/10  
 */
@Service("birthdayService")
public class BirthdayServiceImpl implements BirthdayService {
    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(BirthdayServiceImpl.class);

    @Autowired
    private UserBirthdayConfigMapper userBirthdayConfigMapper;
    @Autowired
    private BirthdayDAO birthdayDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PresentMapper presentMapper;
    @Autowired
    private PresentDAO presentDAO;
    @Autowired
    private ActivityRecordsMapper activityRecordsMapper;
    @Autowired
    private HBPoolMapper hBPoolMapper;
    @Autowired
    private MallGoodsMapper mallGoodsMapper;
    @Autowired
    private BirthdayReminderDAO birthdayReminderDAO;

    /**
     * 保存生日设置的信息
     *
     * @param birthdayConfigVO
     */
    @Transactional
    @Override
    public void saveInfo(BirthdayConfigVO birthdayConfigVO) throws Exception {

        UserBirthdayConfig uc = new UserBirthdayConfig();
        BeanCopierUtils.copyProperties(birthdayConfigVO, uc);
        uc.setStatus(DaoConstant.BirthdayConfig.ACTIVITY_UNSTART); //设置默认值，未开始，前端领奖的时候会进行更新的
        userBirthdayConfigMapper.insertSelective(uc);

        long birthdayActivityId = 0L;
        birthdayActivityId = birthdayDAO.selectBirthdayActivityId(uc.getId());

        /**
         * 选择出符合开始日期和结束日期条件的所有用户(分页处理)
         */
        if (DaoConstant.BirthdayConfig.SEND_AUTO.equals(birthdayConfigVO.getSendTarget())) {

            int start = 1;
            List<UserDO> betweenFans = new ArrayList<UserDO>();

            while (true) {

                PageHelper.startPage(start, 40);
                betweenFans = userDAO.selectUserIdsBetweenStartAndEnd(birthdayConfigVO.getSellerId(),
                                                    birthdayConfigVO.getStartTime(), birthdayConfigVO.getEndTime());

                if (CollectionUtils.isEmpty(betweenFans)) {
                    break;
                }

                String userIds = "";

                for (UserDO userDO : betweenFans) {
                    userIds = userIds + userDO.getUserId() + ",";
                }

                birthdayConfigVO.setManualTarget(userIds);

                /**
                 * 初始化礼物信息
                 */
                sendTarget(birthdayActivityId, birthdayConfigVO);
                start++;
            }

            return;
        }

        /**
         * 初始化礼物信息
         */
        sendTarget(birthdayActivityId, birthdayConfigVO);

    }

    /**
     * 参数manualTarget是前台穿过来的手动选择用户的id，要进行字符串处理
     * @param birthdayActivityId  生日活动ID
     * @param birthdayConfigVO 前台生日配置信息
     */
    private void sendTarget(Long birthdayActivityId, BirthdayConfigVO birthdayConfigVO) {

        AssertsUtil.notBlank(birthdayConfigVO.getManualTarget(), "ManualTarget is blank");

        String targetArray[] = birthdayConfigVO.getManualTarget().trim().split(",");

        for (int i = 0; i < targetArray.length; i++) {

            if(StringUtils.isBlank(targetArray[i])){
                continue;
            }

            /**
             * 初始化用户礼物信息
             */
            Present present = new Present();
            Long userId = Long.parseLong(targetArray[i]);
            present.setBirthdayAcivityId(birthdayActivityId);
            present.setPresentType(birthdayConfigVO.getCareType());
            present.setPresentName(birthdayConfigVO.getTitle());
            present.setPresentSource(DaoConstant.GiftSource.BIRTHDAY);
            present.setSellerId(birthdayConfigVO.getSellerId());
            present.setUserId(userId);

            if (DaoConstant.BirthdayConfig.BIRTHDAY_HONGBAO.equals(birthdayConfigVO.getCareType())) {
                present.setHbPoolId(birthdayConfigVO.getPoolId());
            }

            if (DaoConstant.BirthdayConfig.BIRTHDAY_GIFTS.equals(birthdayConfigVO.getCareType())) {
                present.setGoodsId(birthdayConfigVO.getGoodsId());
            }

            if (DaoConstant.BirthdayConfig.BIRTHDAY_POINTS.equals(birthdayConfigVO.getCareType())) {
                present.setAmount(birthdayConfigVO.getPoints());
            }

            if (DaoConstant.BirthdayConfig.BIRTHDAY_DISCOUNT.equals(birthdayConfigVO.getCareType())) {
                present.setDiscount(birthdayConfigVO.getDiscount());
                present.setPresentPassword(birthdayConfigVO.getSecretPassword());
            }

            presentMapper.insertSelective(present);

            /**
             * 保存活动记录
             */
            ActivityRecords ar = new ActivityRecords();
            ar.setActivityId(birthdayActivityId);
            ar.setActivityName(birthdayConfigVO.getTitle());
            ar.setSellerId(birthdayConfigVO.getSellerId());
            ar.setUserId(userId);
            ar.setActivityType(DaoConstant.GiftSource.BIRTHDAY);
            activityRecordsMapper.insertSelective(ar);

        }

    }

    /**
     * 校验红包数量是否大于等于过生日的人数
     *
     * @param birthdayConfigVO 前台生日配置
     * @return
     */
    @Override
    public boolean verifysurplus(BirthdayConfigVO birthdayConfigVO) {
        boolean flag = false;

        AssertsUtil.notNull(birthdayConfigVO.getSurplus(), "hb counts ");

        if (DaoConstant.BirthdayConfig.SEND_AUTO.equals(birthdayConfigVO.getSendTarget())) {

            List<UserDO> betweenFans = userDAO.selectUserIdsBetweenStartAndEnd(birthdayConfigVO.getSellerId(), birthdayConfigVO.getStartTime(),
                    birthdayConfigVO.getEndTime());

            if (birthdayConfigVO.getSurplus() >= betweenFans.size()) {
                flag = true;
            }

        }

        /**
         * 这个是创建生日活动和生日活动编辑共用的
         * 生日活动编辑的情况:赠送对象手动选择， manualTarget又是空的
         * 说明在编辑页面没有重新选择过生日的客户
         */
        if (DaoConstant.BirthdayConfig.SEND_MANUAL.equals(birthdayConfigVO.getSendTarget())) {

//            AssertsUtil.notBlank(birthdayConfigVO.getManualTarget(), "ManualTarget is blank");
            if(StringUtils.isEmpty(birthdayConfigVO.getManualTarget())) {
                PresentExample presentExample = new PresentExample();
                presentExample.createCriteria().andBirthdayAcivityIdEqualTo(birthdayConfigVO.getBirthdayActivityId());

                int counts = presentMapper.countByExample(presentExample);

                if(birthdayConfigVO.getSurplus() >= counts) {
                    flag = true;
                }
            } else {
                String targetArray[] = birthdayConfigVO.getManualTarget().trim().split(",");

                if (birthdayConfigVO.getSurplus() >= targetArray.length) {
                    flag = true;
                }

            }

        }
        return flag;

    }

    /**
     * 校验生日礼物数量是否大于等于过生日的人数
     * @param birthdayConfigVO 前台生日配置
     * @return
     */
    public Long verifyGiftsGoodsNum(BirthdayConfigVO birthdayConfigVO) {
        Long fans = 0L;
        AssertsUtil.notNull(birthdayConfigVO.getGoodsNum(), "birthday_gifts_counts ");

        if (DaoConstant.BirthdayConfig.SEND_AUTO.equals(birthdayConfigVO.getSendTarget())) {

            fans = userDAO.selectCountBetweenStartAndEnd(birthdayConfigVO.getSellerId(),
                                                birthdayConfigVO.getStartTime(), birthdayConfigVO.getEndTime());

            if (birthdayConfigVO.getGoodsNum() < fans) {
                return fans;
            }

        }

        if(DaoConstant.BirthdayConfig.SEND_MANUAL.equals(birthdayConfigVO.getSendTarget())) {

            String targetArray[] = birthdayConfigVO.getManualTarget().trim().split(",");

            fans = new Long(targetArray.length);

            if (birthdayConfigVO.getGoodsNum() < targetArray.length) {
                return fans;
            }

        }

        return fans;

    }



    /**
     *  选择生日红包的时候查询
     *  要过生日的人数，在前台
     *  要提示给用户看
     * @param birthdayConfigVO
     * @return Long 参加活动的人数
     */
    @Override
    public int activityPeoples(BirthdayConfigVO birthdayConfigVO) {
        List<UserDO> betweenFans = userDAO.selectUserIdsBetweenStartAndEnd(birthdayConfigVO.getSellerId(),
                                                birthdayConfigVO.getStartTime(), birthdayConfigVO.getEndTime());

        return betweenFans.size();
    }
    /**
     * 查询符合要求的生日礼物
     *
     * @return
     */
    @Override
    public PageInfo findBirthdayGifts(BirthdayConfigVO birthdayConfigVO, Integer pageNum, Integer length) {

        PageHelper.startPage(pageNum, length);

        MallGoodsExample example = new MallGoodsExample();
        MallGoodsExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(4L);//4代表的是"礼物"类商品
        criteria.andStatusEqualTo("onsale");
        criteria.andSellerIdEqualTo(birthdayConfigVO.getSellerId());

        if (!StringUtils.isBlank(birthdayConfigVO.getTitle())) {//生日礼物名称不为空时
            criteria.andTitleLike("'%" + birthdayConfigVO.getTitle() + "'%");

        }
        if (birthdayConfigVO.getStartDate() != null) {
            criteria.andGmtCreatedGreaterThanOrEqualTo(birthdayConfigVO.getStartDate());
        }
        if (birthdayConfigVO.getEndDate() != null) {
            criteria.andGmtCreatedGreaterThanOrEqualTo(birthdayConfigVO.getEndDate());
        }

        List<MallGoods> goodsList = new ArrayList<MallGoods>();
        goodsList = mallGoodsMapper.selectByExample(example);
        return new PageInfo(goodsList);
    }

    /**
     * @return
     */
    public String discountSign() {
        return null;
    }

    /**
     * 查询 本周粉丝、本月粉丝
     *
     * @param timebucket
     * @return
     */
    public PageInfo findBirthdayFans(String timebucket, Integer pageNum, Integer length) {
        List<UserDO> birthdayList = new ArrayList<UserDO>();
        PageHelper.startPage(pageNum, length);
        if ("week".equals(timebucket)) {
            birthdayList = userDAO.selectBirthdayOfFansWeek();
        } else {
            birthdayList = userDAO.selectBirthdayOfFansMonth();
        }
        return new PageInfo(birthdayList);
    }


    /**
     * 查询所有粉丝
     *
     * @param pageNum
     * @param length
     * @return
     */
    public PageInfo findAllFans(Integer pageNum, Integer length) {
        List<UserDO> fansList = new ArrayList<UserDO>();
        PageHelper.startPage(pageNum, length);
        fansList = userDAO.selectAllFans();
        return new PageInfo(fansList);
    }

    /**
     * 查询所有的生日活动
     *
     * @param pageNum
     * @param length
     * @return
     */
    @Override
    public PageInfo findBirthdayList(BirthdayDO birthdayDO, Integer pageNum, Integer length) {

        PageHelper.startPage(pageNum, length);

        UserBirthdayConfigExample userBirthdayConfigExample = new UserBirthdayConfigExample();
        UserBirthdayConfigExample.Criteria criteria = userBirthdayConfigExample.createCriteria();
        if(StringUtils.isNotEmpty(birthdayDO.getTitle())) {
            criteria.andTitleLike("%" + birthdayDO.getTitle() + "%");
        }
        if(StringUtils.isNotEmpty(birthdayDO.getStatus())) {
            criteria.andStatusEqualTo(birthdayDO.getStatus());
        }
        if(birthdayDO.getStartDate() != null) {
            criteria.andGmtCreatedGreaterThanOrEqualTo(birthdayDO.getStartDate());
        }
        if(birthdayDO.getEndDate() != null) {
            criteria.andGmtCreatedLessThanOrEqualTo(birthdayDO.getEndDate());
        }
        criteria.andSellerIdEqualTo(birthdayDO.getSellerId());
        userBirthdayConfigExample.setOrderByClause("end_time desc");

        List<UserBirthdayConfig> ubcList = new ArrayList<UserBirthdayConfig>();
        ubcList = userBirthdayConfigMapper.selectByExample(userBirthdayConfigExample);
        return new PageInfo(ubcList);
    }

    /**
     * 根据birthdayId把活动状态改变
     * @param birthdayActivityId
     */
    @Override
    public String updateSatausByBirthdayId(Long birthdayActivityId, String status) {
        String resultStatus = "";
        UserBirthdayConfig ubc = new UserBirthdayConfig();
        UserBirthdayConfigExample example = new UserBirthdayConfigExample();
        if (DaoConstant.BirthdayConfig.ACTIVITY_STOP.equals(status)) {

            ubc.setStatus(DaoConstant.BirthdayConfig.ACTIVITY_STOP);
            example.createCriteria().andBirthdayActivityIdEqualTo(birthdayActivityId);
            int flag = userBirthdayConfigMapper.updateByExampleSelective(ubc, example);
            if (flag > 0) {
                resultStatus = "开启";
            }

        }
        if (DaoConstant.BirthdayConfig.ACTIVITY_START.equals(status)) {

            ubc.setStatus(DaoConstant.BirthdayConfig.ACTIVITY_START);
            example.createCriteria().andBirthdayActivityIdEqualTo(birthdayActivityId);
            int flag = userBirthdayConfigMapper.updateByExampleSelective(ubc, example);
            if (flag > 0) {
                resultStatus = "暂停";
            }
        }
        return resultStatus;

    }

    /**
     * 更新过期的生日活动状态为"过期"
     */
    @Override
    public void updateStatusOfExpired() {
        try {
            birthdayDAO.updateAllExpired();
        } catch (Exception e) {
            logger.error(e);
            throw new ServiceException("更新过期生日活动状态失败");
        }
    }

    /**
     * 初始化生日活动状态
     * @param sellerId
     */
    @Override
    public void initStartStatus(Long sellerId) {
        Date today = DateUtil.getDateToDate(new Date());
        UserBirthdayConfig userBirthdayConfig = new UserBirthdayConfig();
        userBirthdayConfig.setStatus(DaoConstant.BirthdayConfig.ACTIVITY_START);

        UserBirthdayConfigExample ubcExample = new UserBirthdayConfigExample();
        ubcExample.createCriteria().andSellerIdEqualTo(sellerId)
                .andStartTimeLessThanOrEqualTo(today)
                .andEndTimeGreaterThanOrEqualTo(today)
                .andStatusNotEqualTo(DaoConstant.BirthdayConfig.ACTIVITY_STOP);

        userBirthdayConfigMapper.updateByExampleSelective(userBirthdayConfig, ubcExample);
    }


    /**
     * 生日活动配置页面开始时间要显示的默认值
     * @return 字符串形式的日期
     */
    @Override
    public String findMaxEndTime() {
        BirthdayDO birthdayDO = birthdayDAO.selectMaxEndTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strResult = "";
        if (birthdayDO != null) {
            if (birthdayDO.getEndTime() != null) {
                Calendar calendar = Calendar.getInstance();
                String dateStr = sdf.format(birthdayDO.getEndTime());
                try {
                    Date dt = sdf.parse(dateStr);
                    calendar.setTime(dt);
                    calendar.add(Calendar.DAY_OF_YEAR, 1);
                    Date dateResult = calendar.getTime();
                    strResult = sdf.format(dateResult);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return strResult;
            } else {
                return sdf.format(new Date());
            }

        } else {
            return sdf.format(new Date());
        }
    }

    /**
     *  生日活动配置页面开始时间要显示的默认值
     * @return 数据库中最大的结束时间
     */
    public Date caculateMaxEndTime() {
        BirthdayDO birthdayDO = birthdayDAO.selectMaxEndTime();
        if(birthdayDO == null) {
            return null;
        }

        Date shortEndDate = DateUtil.convertNormalDateToShort(birthdayDO.getEndTime());
        return shortEndDate;
    }

    /**
     * 校验前端传过来的日期时间
     * @param birthdayConfigVO 前端参数
     * @return 校验后的信息
     */
    public String verifyFrontData(BirthdayConfigVO birthdayConfigVO) {
        String resultInfo = "";
        if(StringUtils.isBlank(birthdayConfigVO.getTitle())) {
            resultInfo = "生日活动标题不能为空";
            return resultInfo;
        }

        Date backEndTime = caculateMaxEndTime();
        Date frontStartTime = birthdayConfigVO.getStartTime();
        Date frontEndTime = birthdayConfigVO.getEndTime();

        if(backEndTime == null) {
            Date today = DateUtil.convertNormalDateToShort(new Date());
            if(frontEndTime.getTime() <  today.getTime()) {
                resultInfo = "开始时间不能小于默认值";
                return resultInfo;
            }
            return resultInfo;
        }

        if(frontStartTime.getTime() <= backEndTime.getTime()) {
            resultInfo = "开始时间不能小于默认值";
            return resultInfo;
        }

        if(frontEndTime == null) {
            resultInfo = "请选择结束时";
            return resultInfo;
        }

        if(frontStartTime.getTime() > frontEndTime.getTime()) {
            resultInfo = "结束时间要大于开始时间";
            return resultInfo;
        }

        return resultInfo;
    }
    /**
     * 生日互动列表中点击明细查询的内容
     *
     * @param birthdayId
     * @return
     */
    @Override
    public PageInfo findBirthdayDetails(Long sellerId, Long birthdayId, Integer pageNum, Integer length) {
        List<BirthdayActivityDetailsDO> giftsList = new ArrayList<BirthdayActivityDetailsDO>();
        PageHelper.startPage(pageNum, length);
        giftsList = birthdayDAO.selectDetailsByBirthdayActivityId(sellerId, birthdayId);
        return new PageInfo(giftsList);
    }

    /**
     * 编辑生日配置信息
     * @param sellerId
     * @param birthdayActivityId
     * @return
     */
    @Override
    public UserBirthdayConfig editBirthdayConfigInfo(Long sellerId, Long birthdayActivityId) {
        return birthdayDAO.selectBirthdayActivityInfoByBirthdayActivityId(sellerId, birthdayActivityId);
    }

    @Override
    public List<BirthdayConfigVO> findAllBirthdayActivityConfigInfos() {

        Date date = DateUtils.addDays(new Date(), -1);
        UserBirthdayConfigExample userBirthdayConfigExample = new UserBirthdayConfigExample();
        userBirthdayConfigExample.createCriteria().andRemindShortMessageEqualTo(1).
                andStartTimeLessThan(date).andEndTimeGreaterThan(date);
        List<UserBirthdayConfig> userBirthdayConfigs = userBirthdayConfigMapper.selectByExample(userBirthdayConfigExample);

        return (List<BirthdayConfigVO>) BeanCopierUtils.copyListProperties(userBirthdayConfigs, BirthdayConfigVO.class);
    }

    /**
     * 更新生日配置信息
     *
     * @param birthdayConfigVO
     */
    public void editInfo(BirthdayConfigVO birthdayConfigVO) {

        UserBirthdayConfig ubc = new UserBirthdayConfig();
        BeanCopierUtils.copyProperties(birthdayConfigVO, ubc);
        UserBirthdayConfigExample example = new UserBirthdayConfigExample();
        example.createCriteria()
                .andBirthdayActivityIdEqualTo(birthdayConfigVO.getBirthdayActivityId());
        userBirthdayConfigMapper.updateByExampleSelective(ubc, example);

        if (DaoConstant.BirthdayConfig.SEND_AUTO.equals(birthdayConfigVO.getSendTarget())) {

            presentDAO.updateIsDeletedByBaId(birthdayConfigVO.getBirthdayActivityId());

            List<UserDO> betweenFans = userDAO.selectBetweenStartAndEnd(birthdayConfigVO.getSellerId(),
                                        birthdayConfigVO.getStartTime(), birthdayConfigVO.getEndTime(),
                                        birthdayConfigVO.getLevel(), birthdayConfigVO.getBirthdayActivityId());

            for (UserDO userDO : betweenFans) {
                Present present = new Present();
                present.setBirthdayAcivityId(birthdayConfigVO.getBirthdayActivityId());
                present.setPresentType(birthdayConfigVO.getCareType());
                present.setPresentName(birthdayConfigVO.getTitle());
                present.setUserId(userDO.getUserId());

                if (DaoConstant.BirthdayConfig.BIRTHDAY_HONGBAO.equals(birthdayConfigVO.getCareType())) {
                    present.setHbPoolId(birthdayConfigVO.getPoolId());
                }

                if (DaoConstant.BirthdayConfig.BIRTHDAY_GIFTS.equals(birthdayConfigVO.getCareType())) {
                    present.setGoodsId(birthdayConfigVO.getGoodsId());
                }

                if (DaoConstant.BirthdayConfig.BIRTHDAY_POINTS.equals(birthdayConfigVO.getCareType())) {
                    present.setAmount(birthdayConfigVO.getPoints());
                }

                if (DaoConstant.BirthdayConfig.BIRTHDAY_DISCOUNT.equals(birthdayConfigVO.getCareType())) {
                    present.setDiscount(birthdayConfigVO.getDiscount());
                    present.setPresentPassword(birthdayConfigVO.getSecretPassword());
                }
                presentMapper.insertSelective(present);
            }
            //1.根据birthday_activity_id对activity_records进行逻辑删除
            ActivityRecords ar = new ActivityRecords();
            ActivityRecordsExample are = new ActivityRecordsExample();
            ar.setIsDeleted("1");
            are.createCriteria().andActivityIdEqualTo(birthdayConfigVO.getBirthdayActivityId());
            activityRecordsMapper.updateByExampleSelective(ar, are);


            for (UserDO userDO : betweenFans) {
                ar.setUserId(userDO.getUserId());
                ar.setActivityId(birthdayConfigVO.getBirthdayActivityId());
                ar.setActivityName(birthdayConfigVO.getTitle());
                ar.setActivityType("birthday");
                activityRecordsMapper.insertSelective(ar);
            }

        }
        //如果编辑页面赠送对象是手动的
        if (DaoConstant.BirthdayConfig.SEND_MANUAL.equals(birthdayConfigVO.getSendTarget())) {
            //根据birthday_activity_id把present表中已经绑定的数据进行逻辑删除
            presentDAO.updateIsDeletedByBaId(birthdayConfigVO.getBirthdayActivityId());
            if (birthdayConfigVO.getManualTarget().trim() != "" && birthdayConfigVO.getManualTarget().trim() != null) {
                String targetArray[] = birthdayConfigVO.getManualTarget().trim().split(",");
                for (int i = 0; i < targetArray.length; i++) {
                    Present present = new Present();
                    Long userId = Long.parseLong(targetArray[i]);
                    present.setBirthdayAcivityId(birthdayConfigVO.getBirthdayActivityId());
                    present.setPresentType(birthdayConfigVO.getCareType());
                    present.setPresentName(birthdayConfigVO.getTitle());
                    present.setPresentSource("birthday");
                    present.setUserId(userId);

                    if (DaoConstant.BirthdayConfig.BIRTHDAY_HONGBAO.equals(birthdayConfigVO.getCareType())) {
                        present.setHbPoolId(birthdayConfigVO.getPoolId());
                    }

                    if (DaoConstant.BirthdayConfig.BIRTHDAY_GIFTS.equals(birthdayConfigVO.getCareType())) {
                        present.setGoodsId(birthdayConfigVO.getGoodsId());
                    }

                    if (DaoConstant.BirthdayConfig.BIRTHDAY_POINTS.equals(birthdayConfigVO.getCareType())) {
                        present.setAmount(birthdayConfigVO.getPoints());
                    }

                    if (DaoConstant.BirthdayConfig.BIRTHDAY_DISCOUNT.equals(birthdayConfigVO.getCareType())) {
                        present.setDiscount(birthdayConfigVO.getDiscount());
                        present.setPresentPassword(birthdayConfigVO.getSecretPassword());
                    }
                    presentMapper.insertSelective(present);
                }

                ActivityRecords ar = new ActivityRecords();
                ActivityRecordsExample are = new ActivityRecordsExample();
                ar.setIsDeleted("1");
                are.createCriteria().andActivityIdEqualTo(birthdayConfigVO.getBirthdayActivityId());
                activityRecordsMapper.updateByExampleSelective(ar, are);

                for (int i = 0; i < targetArray.length; i++) {
                    Long userId = Long.parseLong(targetArray[i]);
                    ar.setUserId(userId);
                    ar.setActivityId(birthdayConfigVO.getBirthdayActivityId());
                    ar.setActivityName(birthdayConfigVO.getTitle());
                    ar.setActivityType("birthday");
                    activityRecordsMapper.insertSelective(ar);
                }
            }
        }

    }

    /**
     * 定时任务用到的，查询需要短信提醒的用户
     *
     * @param birthdayDate
     * @param birthdayActivityId
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<UserBirthdayReminderVO> getBirthdayReminder(Long sellerId, Date birthdayDate, Long birthdayActivityId, Integer start, Integer pageSize) {

        List<UserBirthdayReminderVO> remindedVOList;

        PageHelper.startPage(start, pageSize);
        List<UserBirthdayReminderDO> remindedDOList = birthdayReminderDAO.
                selectRemindedUser(sellerId, birthdayDate, birthdayActivityId);

        BeanCopierUtils.copyListProperties(remindedDOList, UserBirthdayReminderVO.class);

        remindedVOList = (List<UserBirthdayReminderVO>) BeanCopierUtils.
                copyListProperties(remindedDOList, BirthdayConfigVO.class);

        return remindedVOList;
    }

    /**
     * 后台生日配置页面
     * 手动选择在一段时间内的用户
     * 赠送对象 : 手动选择
     * @param birthdayConfigVO
     * @param pageNum
     * @param length
     * @return
     */
    @Override
    public PageInfo findManualFans(BirthdayConfigVO birthdayConfigVO, Integer pageNum, Integer length) {

        PageHelper.startPage(pageNum, length);

        List<UserDO> betweenFans = userDAO.selectBetweenStartAndEnd(birthdayConfigVO.getSellerId(),
                                            birthdayConfigVO.getStartTime(), birthdayConfigVO.getEndTime(),
                                            birthdayConfigVO.getLevel(),birthdayConfigVO.getBirthdayActivityId());

        return new PageInfo(betweenFans);
    }

    /**
     * 根据类型分页查询红包活动列表
     *
     * @param hbPoolVO
     * @param pageNum
     * @param length
     * @return
     */
    @Override
    public PageInfo queryHBPoolsByType(HBPoolVO hbPoolVO, Integer pageNum, Integer length) {
        HBPoolExample hbPoolExample = new HBPoolExample();
        HBPoolExample.Criteria criteria = hbPoolExample.createCriteria();
        List<HBPool> hbPools = new ArrayList<HBPool>();
        if (!org.apache.commons.lang.StringUtils.isBlank(hbPoolVO.getName())) {
            criteria.andNameLike("%" + hbPoolVO.getName() + "%");
        }
        criteria.andSellerIdEqualTo(hbPoolVO.getSellerId());
        //红包类型是生日
        if(hbPoolVO.getType() != null){
            if(DaoConstant.HongBaoType.BIRTHDAY.equals(hbPoolVO.getType())){
                criteria.andTypeEqualTo(DaoConstant.HongBaoType.BIRTHDAY);
            }else if(DaoConstant.HongBaoType.COMMON.equals(hbPoolVO.getType())){
                criteria.andTypeEqualTo(DaoConstant.HongBaoType.COMMON);
            }else if(DaoConstant.HongBaoType.POINT_EXCHANGE.equals(hbPoolVO.getType())){
                criteria.andTypeEqualTo(DaoConstant.HongBaoType.POINT_EXCHANGE);
            }else if(DaoConstant.HongBaoType.PRAISE.equals(hbPoolVO.getType())){
                criteria.andTypeEqualTo(DaoConstant.HongBaoType.PRAISE);
            }else if(DaoConstant.HongBaoType.SHAKE.equals(hbPoolVO.getType())){
                criteria.andTypeEqualTo(DaoConstant.HongBaoType.SHAKE);
            }
        }
        hbPoolExample.setOrderByClause("gmt_modified DESC");

        if (pageNum != null && length != null) {
            PageHelper.startPage(pageNum, length);
        }



        hbPools = hBPoolMapper.selectByExample(hbPoolExample);


        return new PageInfo(hbPools);
    }

    /**
     * 提供的接口，更新present表和activity_records表
     *
     * @param userId
     * @param birthdayActivityId
     */
    public void updateBirthdayAboutState(Long userId, Long birthdayActivityId) {
        //更新present表is_receive,expire_date字段
        Present present = new Present();
        PresentExample pExamplet = new PresentExample();
        present.setIsReceive(true);
        present.setExpireDate(DateUtil.getExpiredDay(7));//7天后过期
        pExamplet.createCriteria()
                .andUserIdEqualTo(userId)
                .andBirthdayAcivityIdEqualTo(birthdayActivityId);
        presentMapper.updateByExampleSelective(present, pExamplet);
        //更新activity_records表receive_date
        ActivityRecords activityRecords = new ActivityRecords();
        ActivityRecordsExample activityExample = new ActivityRecordsExample();
        activityRecords.setReceiveDate(new Date());
        activityExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andActivityIdEqualTo(birthdayActivityId);
        activityRecordsMapper.updateByExampleSelective(activityRecords, activityExample);
    }

    /**
     * 用户领生日红包后更新状态
     *
     * @param userId   用户id
     * @param hbPoolId 红包活动id
     */
    @Override
    @Transactional
    public void updateStateAboutHb(Long sellerId, Long userId, Long hbPoolId) {
        //根据userId和hbPoolId来更新present表中的is_receive和expire_date
        Present present = new Present();
        PresentExample pExample = new PresentExample();
        present.setIsReceive(true);
        present.setExpireDate(DateUtil.getExpiredDay(7));//7天后过期
        pExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andHbPoolIdEqualTo(hbPoolId);
        presentMapper.updateByExampleSelective(present, pExample);
        //更新activity_records表receive_date
        //根据userId和hbPoolId来查询出birthday_activiey_id
        PresentExample pExampleSelect = new PresentExample();
        pExampleSelect.createCriteria()
                .andSellerIdEqualTo(sellerId)
                .andUserIdEqualTo(userId)
                .andHbPoolIdEqualTo(hbPoolId);
        List<Present> pList = presentMapper.selectByExample(pExampleSelect);

        Present presentSelect = new Present();
        if (pList.size() > 0) {
            presentSelect = pList.get(0);
        }
        ActivityRecords activityRecords = new ActivityRecords();
        ActivityRecordsExample activityExample = new ActivityRecordsExample();
        activityRecords.setReceiveDate(new Date());
        activityExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andActivityIdEqualTo(presentSelect.getBirthdayAcivityId());
        activityRecordsMapper.updateByExampleSelective(activityRecords, activityExample);
    }

    /**
     * 编辑页面手动选择用户要显示已经选择过的用户
     * @param birthdayConfigVO 前台传来的数据对象
     */
    @Override
    @Transactional
    public void editPageUpdateInfo(BirthdayConfigVO birthdayConfigVO) {

        AssertsUtil.notNull(birthdayConfigVO.getBirthdayActivityId(), "birthdayActivityId not null");

        UserBirthdayConfig userBirthdayConfig = verifyNull(birthdayConfigVO);
//        BeanCopierUtils.copyProperties(birthdayConfigVO, userBirthdayConfig);

        UserBirthdayConfigExample userBirthdayConfigExample = new UserBirthdayConfigExample();
        userBirthdayConfigExample.createCriteria().andBirthdayActivityIdEqualTo(birthdayConfigVO.getBirthdayActivityId());

        userBirthdayConfigMapper.updateByExampleSelective(userBirthdayConfig, userBirthdayConfigExample);

        /**
         * 如果赠送对象是手动选择的，但是赠送对象的人又是空的，就说明
         * 赠送对象本身就是手动的，并且没有做修改就提交保存了,那就
         * 根据birthday_activity_id号更新相关数据
         */
        if(DaoConstant.BirthdayConfig.SEND_MANUAL.equals(birthdayConfigVO.getSendTarget()) &&
                StringUtils.isEmpty(birthdayConfigVO.getManualTarget())) {

            updateNoChangedOfManualTarget(birthdayConfigVO);

            return ;
        }

        /**
         * 把原来的present和activity_record表中记录的用户数据物理删除
         * 先删activity_record表，再删present表
         * 再选择出符合开始日期和结束日期条件的所有用户(分页处理)插入数据
         */
        logicDeleteActivityRecords(birthdayConfigVO);

        logicDeletePresent(birthdayConfigVO);


        if (DaoConstant.BirthdayConfig.SEND_AUTO.equals(birthdayConfigVO.getSendTarget())) {
            int start = 1;
            List<UserDO> betweenFans = new ArrayList <UserDO>();

            while(true) {
                PageHelper.startPage(start, 40);
                betweenFans = userDAO.selectUserIdsBetweenStartAndEnd(birthdayConfigVO.getSellerId(),
                                                    birthdayConfigVO.getStartTime(), birthdayConfigVO.getEndTime());

                if (CollectionUtils.isEmpty(betweenFans)) {
                    break;
                }

                String userIds = "";

                for (UserDO userDO : betweenFans) {
                    userIds = userIds + userDO.getUserId() + ",";
                }

                birthdayConfigVO.setManualTarget(userIds);
                /**
                 * 初始化礼物信息
                 */
                sendTarget(birthdayConfigVO.getBirthdayActivityId(), birthdayConfigVO);
                start++;

            }
            return ;
        }

        /**
         * 初始化礼物信息
         */
        sendTarget(birthdayConfigVO.getBirthdayActivityId(), birthdayConfigVO);

    }


    /**
     * 根据birthday_activity_id更新present表
     * 和activity_record表
     * @param birthdayConfigVO
     */
    private void updateNoChangedOfManualTarget(BirthdayConfigVO birthdayConfigVO) {
        Present present = new Present();
        present.setPresentType(birthdayConfigVO.getCareType());
        present.setPresentName(birthdayConfigVO.getTitle());
        present.setPresentSource(DaoConstant.GiftSource.BIRTHDAY);
        present.setDiscount(birthdayConfigVO.getDiscount());
        present.setPresentPassword(birthdayConfigVO.getSecretPassword());
        present.setGoodsId(birthdayConfigVO.getGoodsId());
        present.setHbPoolId(birthdayConfigVO.getPoolId());
        present.setAmount(birthdayConfigVO.getPoints());

        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andBirthdayAcivityIdEqualTo(birthdayConfigVO.getBirthdayActivityId());

        presentMapper.updateByExampleSelective(present, presentExample);

        int start = 1;
        List<Present> presentList = new ArrayList<Present>();
        while(true) {
            PageHelper.startPage(start, 40);

            presentExample = new PresentExample();
            presentExample.createCriteria().andSellerIdEqualTo(birthdayConfigVO.getSellerId());
            presentExample.createCriteria().andBirthdayAcivityIdEqualTo(birthdayConfigVO.getBirthdayActivityId());
            presentList = presentMapper.selectByExample(presentExample);

            if (CollectionUtils.isEmpty(presentList)) {
                break;
            }

            for(Present pre : presentList) {
                ActivityRecords activityRecords = new ActivityRecords();
                activityRecords.setActivityName(birthdayConfigVO.getTitle());
                activityRecords.setActivityType(DaoConstant.GiftSource.BIRTHDAY);

                ActivityRecordsExample activityRecordsExample = new ActivityRecordsExample();
                activityRecordsExample.createCriteria().andUserIdEqualTo(pre.getUserId());

                activityRecordsMapper.updateByExampleSelective(activityRecords, activityRecordsExample);
            }

            start++;
        }
    }

    /**
     * 将前台传过来的Long类型的NULL转化为0L
     * @param birthdayConfigVO
     * @return
     */
    private  UserBirthdayConfig verifyNull(BirthdayConfigVO birthdayConfigVO) {
        UserBirthdayConfig userBirthdayConfig = new UserBirthdayConfig();

        if(birthdayConfigVO.getPoolId() == null) {
            birthdayConfigVO.setPoolId(0L);
        }

        if(birthdayConfigVO.getGoodsId() == null) {
            birthdayConfigVO.setGoodsId(0L);
        }

        if(birthdayConfigVO.getPoints() == null) {
            birthdayConfigVO.setPoints(0L);
        }
        if(birthdayConfigVO.getDiscount() == null) {
            birthdayConfigVO.setDiscount(0.0);
        }
        BeanCopierUtils.copyProperties(birthdayConfigVO, userBirthdayConfig);
        return userBirthdayConfig;
    }
    /**
     *  根据user_id逻辑删除(分页删除)表activity_records中的数据
     * @param birthdayConfigVO 前端数据
     */
    private void logicDeleteActivityRecords(BirthdayConfigVO birthdayConfigVO) {
        int delStart = 1;
        List<Present> pListDel = new ArrayList<Present>();

        while(true) {
            PageHelper.startPage(delStart, 40);

            PresentExample presentExampleDel = new PresentExample();
            presentExampleDel.createCriteria().andSellerIdEqualTo(birthdayConfigVO.getSellerId());
            presentExampleDel.createCriteria().andBirthdayAcivityIdEqualTo(birthdayConfigVO.getBirthdayActivityId());
            pListDel = presentMapper.selectByExample(presentExampleDel);

            if(CollectionUtils.isEmpty(pListDel)) {
                break;
            }

            for(Present pDel : pListDel) {
                ActivityRecords activityRecordsDel = new ActivityRecords();
                activityRecordsDel.setIsDeleted(DaoConstant.IsDeleted.TRUE);

                ActivityRecordsExample activityRecordsExampleDel =  new ActivityRecordsExample();
                activityRecordsExampleDel.createCriteria().andUserIdEqualTo(pDel.getUserId());
                activityRecordsMapper.updateByExampleSelective(activityRecordsDel, activityRecordsExampleDel);
            }

            delStart ++;
        }
    }

    /**
     * 逻辑删除present表
     * @param birthdayConfigVO
     */
    private void logicDeletePresent(BirthdayConfigVO birthdayConfigVO) {
        Present present = new Present();
        present.setIsDeleted(DaoConstant.IsDeleted.TRUE);

        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andSellerIdEqualTo(birthdayConfigVO.getSellerId());
        presentExample.createCriteria().andBirthdayAcivityIdEqualTo(birthdayConfigVO.getBirthdayActivityId());

        /*int result = presentMapper.updateByExampleSelective(present, presentExample);
        if(result == 0) {
            throw new ServiceException("BirthdaySerivce.logicDeletePresent() 删除失败回滚");
        }*/
        try {
            presentMapper.updateByExampleSelective(present, presentExample);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 提供的接口，只更新present表的状态
     *
     * @param userId
     * @param birthdayActivityId
     */
    public void updatePresentState(Long userId, Long birthdayActivityId) {
        //更新present表is_receive,expire_date字段
        Present present = new Present();
        PresentExample pExamplet = new PresentExample();
        present.setIsReceive(true);
        present.setExpireDate(DateUtil.getExpiredDay(7));//7天后过期
        pExamplet.createCriteria()
                .andUserIdEqualTo(userId)
                .andBirthdayAcivityIdEqualTo(birthdayActivityId);
        presentMapper.updateByExampleSelective(present, pExamplet);
    }

    /**
     * 手动选择的人数
     * @param birthdayConfigVO
     * @return
     */
    public int manualSelectPersons(BirthdayConfigVO birthdayConfigVO) {

        String targetArray[] = birthdayConfigVO.getManualTarget().trim().split(",");

        return targetArray.length;

    }

    /**
     * 校验前端传到后台的红包池ID是否被用过
     *
     * @description  一个生日活动配置一个生日红包，如果这个生日红包被别的生日活动用过。就不能再被使用了
     * 这个方法是生日配置页面和生日编辑页面共同使用的
     * @param birthdayConfigVO
     * @return
     */
    public boolean verifyIsRedPackageSelected(BirthdayConfigVO birthdayConfigVO) {
        boolean flage = true;
        List<Present> present = new ArrayList<Present>();
        Long poolId = birthdayConfigVO.getPoolId();
        Long birthdayActivityId = birthdayConfigVO.getBirthdayActivityId();
        PresentExample presentExample = new PresentExample();

        //先进行生日编辑页面的校验
        /**
         * birthdayActivityId 有值，就是生日编辑页面进行校验
         */
        if(birthdayActivityId != null) {
            presentExample.createCriteria().andBirthdayAcivityIdEqualTo(birthdayActivityId)
                    .andHbPoolIdEqualTo(poolId);
            present = presentMapper.selectByExample(presentExample);

            /**
             * 如果有数据，说明在在生日编辑页面中又选择了相同的红包池,
             * 如果没有数据，说明在生日遍野页面中选择了新的红包池,
             * 那么就要判断新的红包池有没有用过
             */
            if(CollectionUtils.isEmpty(present)) {
                presentExample = new PresentExample();
                presentExample.createCriteria().andHbPoolIdEqualTo(poolId).
                        andPresentSourceEqualTo(DaoConstant.GiftSource.BIRTHDAY).
                        andSellerIdEqualTo(birthdayConfigVO.getSellerId()).
                        andPresentTypeEqualTo(DaoConstant.BirthdayConfig.BIRTHDAY_HONGBAO);

                present = presentMapper.selectByExample(presentExample);
                if(CollectionUtils.isEmpty(present)) {
                    flage =  false;
                    return flage;
                } else {
                    return flage;
                }

            } else {
                flage = false;
                return flage;
            }
        }

        presentExample = new PresentExample();
        presentExample.createCriteria().andHbPoolIdEqualTo(poolId).
                andPresentSourceEqualTo(DaoConstant.GiftSource.BIRTHDAY).
                andSellerIdEqualTo(birthdayConfigVO.getSellerId()).
                andPresentTypeEqualTo(DaoConstant.BirthdayConfig.BIRTHDAY_HONGBAO);

        present = presentMapper.selectByExample(presentExample);

        if(CollectionUtils.isEmpty(present)) {
            flage =  false;
        }

        return flage;
    }
}
