package com.shufensoft.crm.biz.service.birthday.impl;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.birthday.BirthdayDAO;
import com.shufensoft.crm.biz.dao.generation.birthday.UserBirthdayConfigMapper;
import com.shufensoft.crm.biz.dao.generation.present.PresentMapper;
import com.shufensoft.crm.biz.dao.generation.recordsActivity.ActivityRecordsMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.domain.defined.birthday.BirthdayDO;
import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfig;
import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfigExample;
import com.shufensoft.crm.biz.domain.generation.present.Present;
import com.shufensoft.crm.biz.domain.generation.present.PresentExample;
import com.shufensoft.crm.biz.domain.generation.recordsActivity.ActivityRecords;
import com.shufensoft.crm.biz.domain.generation.recordsActivity.ActivityRecordsExample;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserExample;
import com.shufensoft.crm.biz.service.birthday.MobileBirthdayService;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/20  
 */
@Service("mobileBirthdayService")
public class MobileBirthdayServiceImpl implements MobileBirthdayService{
    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(MobileBirthdayServiceImpl.class);

    @Autowired
    private BirthdayDAO birthdayDAO;
    @Autowired
    private PresentMapper presentMapper;
    @Autowired
    private ActivityRecordsMapper activityRecordsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IPointService iPointService;
    @Autowired
    private UserBirthdayConfigMapper userBirthdayConfigMapper;


    /**
     * 根据user_id查询出这个用户参加的所有生日活动，包括历史的活动
     * @param userId
     * @return
     */
    public List<BirthdayDO> findFrontBirthdayData(Long sellerId, Long userId) {
        List<BirthdayDO> list = new ArrayList<BirthdayDO>();
        list = birthdayDAO.selectFrontData(sellerId, userId);
        return list;
    }

    /**
     * 判断今天的时间大于生日活动结束时间的话，
     * 就把生日活动的状态更新为over
     * @param allActivityList
     */
    @Override
    public void initOverStatus(List<BirthdayDO> allActivityList) {

        for(BirthdayDO birthdayDO : allActivityList) {

            try {

                Date endTime = DateUtil.getDateToDate(birthdayDO.getEndTime());
                Date today = DateUtil.getDateToDate(new Date());
                if(today.getTime() > endTime.getTime()) {
                    UserBirthdayConfig ubc = new UserBirthdayConfig();
                    UserBirthdayConfigExample ubcExample = new UserBirthdayConfigExample();
                    ubc.setStatus(DaoConstant.BirthdayConfig.ACTIVITY_OVER);
                    ubcExample.createCriteria().andBirthdayActivityIdEqualTo(birthdayDO.getBirthdayActivityId());
                    userBirthdayConfigMapper.updateByExampleSelective(ubc, ubcExample);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 因为生日活动的状态默认是unstart,
     * 所以今天的时间如果大于等于开始时间，
     * 小于等于结束时间，就把状态更改为start
     *
     * @param allActivityList
     */
    @Override
    public void initStartStatus(List<BirthdayDO> allActivityList) {

        for(BirthdayDO birthdayDO : allActivityList) {

            Date startTime = DateUtil.getDateToDate(birthdayDO.getStartTime());
            Date endTime = DateUtil.getDateToDate(birthdayDO.getEndTime());
            Date today = DateUtil.getDateToDate(new Date());

            if(today.getTime() >= startTime.getTime() && today.getTime() <= endTime.getTime()) {
                UserBirthdayConfig ubc = new UserBirthdayConfig();
                UserBirthdayConfigExample ubcExample = new UserBirthdayConfigExample();
                ubc.setStatus(DaoConstant.BirthdayConfig.ACTIVITY_START);
                ubcExample.createCriteria().andBirthdayActivityIdEqualTo(birthdayDO.getBirthdayActivityId())
                            .andStatusNotEqualTo(DaoConstant.BirthdayConfig.ACTIVITY_STOP);
                userBirthdayConfigMapper.updateByExampleSelective(ubc, ubcExample);

            }

        }
    }

    /**
     *  过滤要显示的列表,筛选出今天时间(月日)大于等于生日时间(月日)
     * @param allActivityList
     * @return
     */
    @Override
    public List<BirthdayDO> screenActivityList(List<BirthdayDO> allActivityList) {
        List<BirthdayDO> result = new ArrayList<BirthdayDO>();
        for(BirthdayDO birthdayDO : allActivityList) {

            UserExample uExample = new UserExample();
            uExample.createCriteria().andUserIdEqualTo(birthdayDO.getUserId());
            List<User> uList = userMapper.selectByExample(uExample);

            User u = new User();

            if(CollectionUtils.isNotEmpty(uList)) {
                u = uList.get(0);
            }

            Date birthday = DateUtil.getDateToMdDate(u.getBirthday());
            Date today = DateUtil.getDateToMdDate(new Date());

            if(today.getTime() >= birthday.getTime()) {
                result.add(birthdayDO);
            }

        }
        return result;
    }
    /**
     * 手机端领生日积分
     * @param sellerId
     * @param userId
     * @param birthdayActivityId
     */
    @Override
    @Transactional
    public void receivePointsPrize(Long sellerId, Long userId, Long birthdayActivityId) {

        Present present = new Present();
        PresentExample pExample = new PresentExample();
        present.setIsReceive(true);
        present.setExpireDate(DateUtil.getExpiredDay(7));
        pExample.createCriteria().andUserIdEqualTo(userId)
                .andBirthdayAcivityIdEqualTo(birthdayActivityId);

        presentMapper.updateByExampleSelective(present,pExample);

        ActivityRecords ar = new ActivityRecords();
        ActivityRecordsExample are = new ActivityRecordsExample();
        ar.setReceiveDate(new Date());
        are.createCriteria().andUserIdEqualTo(userId);

        activityRecordsMapper.updateByExampleSelective(ar, are);

        ActivityRecordsExample example = new ActivityRecordsExample();
        example.createCriteria().andActivityIdEqualTo(birthdayActivityId);
        example.createCriteria().andSellerIdEqualTo(sellerId);
        List<ActivityRecords> activityList = activityRecordsMapper.selectByExample(example);

        ActivityRecords activityRecords = new ActivityRecords();

        if(CollectionUtils.isNotEmpty(activityList)) {
            activityRecords = activityList.get(0);
        }

        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andSellerIdEqualTo(sellerId)
                      .andBirthdayAcivityIdEqualTo(birthdayActivityId);

        List<Present> presentList= presentMapper.selectByExample(presentExample);

        if(CollectionUtils.isNotEmpty(presentList)) {
           present = presentList.get(0);
        }

        iPointService.insertPointObtain(sellerId,userId,present.getAmount(),
                activityRecords.getActivityType(),birthdayActivityId);
    }



    /**
     * 手机端领生日活动折扣
     * @param userId
     * @param birthdayActivityId
     */
    @Override
    public void receiveDiscountPrize(Long sellerId, Long userId, Long birthdayActivityId) {

        Present present = new Present();
        PresentExample pExample = new PresentExample();
        present.setIsReceive(true);
        present.setExpireDate(DateUtil.getExpiredDay(7));
        pExample.createCriteria().andUserIdEqualTo(userId)
                .andBirthdayAcivityIdEqualTo(birthdayActivityId);

        presentMapper.updateByExampleSelective(present,pExample);

        ActivityRecords ar = new ActivityRecords();
        ActivityRecordsExample are = new ActivityRecordsExample();
        ar.setReceiveDate(new Date());
        are.createCriteria().andUserIdEqualTo(userId);

        activityRecordsMapper.updateByExampleSelective(ar, are);
    }

    /**
     * 手机领生日活动礼物
     * @param userId
     * @param birthdayActivityId
     */
    @Override
    public void receiveGiftsPrize(Long userId, Long birthdayActivityId) {

        Present present = new Present();
        PresentExample pExample = new PresentExample();
        present.setIsReceive(true);
        present.setExpireDate(DateUtil.getExpiredDay(7));
        pExample.createCriteria().andUserIdEqualTo(userId)
                .andBirthdayAcivityIdEqualTo(birthdayActivityId);

        presentMapper.updateByExampleSelective(present,pExample);

        ActivityRecords ar = new ActivityRecords();
        ActivityRecordsExample are = new ActivityRecordsExample();
        ar.setReceiveDate(new Date());
        are.createCriteria().andUserIdEqualTo(userId);

        activityRecordsMapper.updateByExampleSelective(ar, are);
    }

    /**
     * 找出参加过的所有活动
     * @param userId
     * @return
     */
    @Override
    public List<UserBirthdayConfig> findAllBirthActivity(Long userId) {

        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andUserIdEqualTo(userId);
        List<Present> presentsList = presentMapper.selectByExample(presentExample);
        List<UserBirthdayConfig> userBirthdayConfigArrayList = new ArrayList<UserBirthdayConfig>();
        for(Present present : presentsList) {

            UserBirthdayConfigExample userBirthdayConfigExample = new UserBirthdayConfigExample();
            userBirthdayConfigExample.createCriteria().andBirthdayActivityIdEqualTo(present.getBirthdayAcivityId());
            List<UserBirthdayConfig> userBirthdayConfigList = userBirthdayConfigMapper.
                                                                            selectByExample(userBirthdayConfigExample);

            if(CollectionUtils.isNotEmpty(userBirthdayConfigList)) {
                UserBirthdayConfig userBirthdayConfig = userBirthdayConfigList.get(0);
                userBirthdayConfigArrayList.add(userBirthdayConfig);
            }
        }
        return userBirthdayConfigArrayList;
    }

    /**
     * 先判断活动有没有开始
     * @return
     */
    //TODO 暂时保留，这个是老的逻辑
    /*@Override
    public boolean verifyActivity(Long userId) {
        boolean flag = false;
        Date date = new Date();
        //直接得不到birthday_activity_id所以只能逆着推
        //根据userId从present 表中查找活动birthday_activity_id
        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andUserIdEqualTo(userId);
        List<Present> presentList = presentMapper.selectByExample(presentExample);
        for(Present present : presentList) {
            UserBirthdayConfigExample ucExample = new UserBirthdayConfigExample();
            ucExample.createCriteria()
                    .andStartTimeLessThanOrEqualTo(date) //开始时间小于等于今天的时间
                    .andEndTimeGreaterThanOrEqualTo(date) //结束时间要大于等于今天的时间
                    .andIsDeletedEqualTo("0")
                    .andBirthdayActivityIdEqualTo(present.getBirthdayAcivityId());
            List<UserBirthdayConfig> birthdayConfigList = userBirthdayConfigMapper.selectByExample(ucExample);
            //1.先判断今天是不是在当前(今年)活动时间内
            if(birthdayConfigList.size() > 0) {//在活动时间内
                flag = true;
            } else {  //不在活动时间内
                //不在当前活动时间的情况:
                //以往参加过的活动要显示出来,当前的时间大于以往的开始时间


                //2.如果不是在活动时间内，看今天的时间是不是过了活动时间，
                //过了活动时间就把status状态更新为过期,若在活动时间开始之前，就什么操作都不做
                UserBirthdayConfigExample ucExample2 = new UserBirthdayConfigExample();
                ucExample2.createCriteria().andBirthdayActivityIdEqualTo(present.getBirthdayAcivityId());
                List<UserBirthdayConfig> birthdayConfigList2 = userBirthdayConfigMapper.selectByExample(ucExample2);
                if(birthdayConfigList2.size() > 0) {
                    UserBirthdayConfig userBirthdayConfig = birthdayConfigList2.get(0);
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String dateStr1 = df.format(userBirthdayConfig.getStartTime());
                    String dateStr2 = df.format(userBirthdayConfig.getEndTime());
                    String dateStr3 = df.format(date);
                    try {
                        Date d1 = df.parse(dateStr1);
                        Date d2 = df.parse(dateStr2);
                        Date d3 = df.parse(dateStr3);

                        if(d1.getTime() > d3.getTime()) { //开始时间大于今天
                            flag = false;
                        }
                        if(d2.getTime() < d3.getTime()) { //结束时间小于今天
                            //更新user_birthday_config的status状态为over
                            UserBirthdayConfig userBirthdayConfig1 = new UserBirthdayConfig();
                            userBirthdayConfig1.setStatus("over");
                            UserBirthdayConfigExample ucExample3 = new UserBirthdayConfigExample();
                            ucExample3.createCriteria().andBirthdayActivityIdEqualTo(present.getBirthdayAcivityId());
                            userBirthdayConfigMapper.updateByExampleSelective(userBirthdayConfig1, ucExample3);
                        }
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return flag;
    }*/

    /**
     * 查找用户信息
     * @param sellerId
     * @param userId
     * @return
     */
    @Override
    public UserVO findUserMess(Long sellerId, Long userId) {

        UserVO uv = new UserVO();
        UserExample example = new UserExample();
        example.createCriteria().andSellerIdEqualTo(sellerId)
                                .andUserIdEqualTo(userId);
        List<User> list = userMapper.selectByExample(example);

        if(CollectionUtils.isNotEmpty(list)) {
            User user = list.get(0);
            BeanCopierUtils.copyProperties(user, uv);
        }

        return uv;

    }
}
