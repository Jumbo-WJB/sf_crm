package com.shufensoft.crm.biz.service.birthday;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.defined.birthday.BirthdayDO;
import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfig;
import com.shufensoft.crm.biz.service.birthday.vo.BirthdayConfigVO;
import com.shufensoft.crm.biz.service.birthday.vo.UserBirthdayReminderVO;
import com.shufensoft.crm.biz.vo.HBPoolVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/9  
 */

public interface BirthdayService {

    public void saveInfo(BirthdayConfigVO birthdayConfigVO) throws Exception;

    public PageInfo findBirthdayGifts(BirthdayConfigVO birthdayConfigVO, Integer pageNum, Integer length);

    public String discountSign();

    public PageInfo findBirthdayFans(String timebucket, Integer pageNum, Integer length);

    public PageInfo findAllFans(Integer pageNum, Integer length);

    public PageInfo findBirthdayList(BirthdayDO birthdayDO, Integer pageNum, Integer length);

    public String updateSatausByBirthdayId(Long birthdayId, String status);

    /**
     * 更新过期的生日活动状态为"过期"状态
     */
    public void updateStatusOfExpired();

    /**
     * 初始化生日活动状态
     * @param sellerId
     */
    public void initStartStatus(Long sellerId);

    /**
     * 生日活动配置页面开始时间要显示的默认值
     * @return 字符串形式的日期
     */
    public String findMaxEndTime();

    /**
     * 生日活动配置保存后，后端校验开始时间和结束时间
     * @return 数据库中最大的结束时间
     */
    public Date caculateMaxEndTime();

    /**
     * 校验前端传过来的日期时间
     * @param birthdayConfigVO 前端参数
     * @return 校验后的信息
     */
    public String verifyFrontData(BirthdayConfigVO birthdayConfigVO);

    public PageInfo findBirthdayDetails(Long sellerId, Long birthdayId, Integer pageNum, Integer length);

    /**
     * 编辑生日配置信息
     * @param sellerId
     * @param birthdayActivityId
     * @return
     */
    public UserBirthdayConfig editBirthdayConfigInfo(Long sellerId, Long birthdayActivityId);

    public List<BirthdayConfigVO> findAllBirthdayActivityConfigInfos();

    public void editInfo(BirthdayConfigVO birthdayConfigVO);

    /**
     * 根据生日时间获取生日礼物领取的用户
     * @param birthdayDate
     * @param start
     * @param pageSize
     * @return
     */
    public List<UserBirthdayReminderVO> getBirthdayReminder(Long sellerId, Date birthdayDate,Long birthdayActivityId, Integer start, Integer pageSize);

    /**
     * 后台生日配置页面
     * 手动选择在一段时间内的用户
     * 赠送对象 : 手动选择
     * @param birthdayConfigVO
     * @param pageNum
     * @param length
     * @return
     */
    public PageInfo findManualFans(BirthdayConfigVO birthdayConfigVO,Integer pageNum, Integer length);

    /**
     * 根据类型分页查询红包活动列表
     * @param hbPoolVO
     * @param pageNum
     * @param length
     * @return
     */
    public PageInfo queryHBPoolsByType(HBPoolVO hbPoolVO, Integer pageNum, Integer length);

    /**
     * 校验红包数量是否大于等于过生日的人数
     *
     * @param birthdayConfigVO 前台生日配置
     * @return
     */
    public boolean verifysurplus(BirthdayConfigVO birthdayConfigVO);

    /**
     *  校验生日礼物数量是否大于等于过生日的人数
     * @param birthdayConfigVO 前台生日配置
     * @return
     */
    public Long verifyGiftsGoodsNum(BirthdayConfigVO birthdayConfigVO);

    /**
     *  选择生日红包的时候查询
     *  要过生日的人数，在前台
     *  要提示给用户看
     * @param birthdayConfigVO
     * @return Long 参加活动的人数
     */
    public int activityPeoples(BirthdayConfigVO birthdayConfigVO);
    @Transactional
    public void updateBirthdayAboutState(Long userId, Long birthdayActivityId);

    public void updatePresentState(Long userId, Long birthdayActivityId);

    public void updateStateAboutHb(Long sellerId, Long userId, Long hbPoolId);

    /**
     * 处理生日列表编辑页面，编辑后更新
     * @param birthdayConfigVO 前台传来的数据对象
     */
    public void editPageUpdateInfo(BirthdayConfigVO birthdayConfigVO);

    /**
     * 手动选择的人数
     * @param birthdayConfigVO
     * @return
     */
    public int manualSelectPersons(BirthdayConfigVO birthdayConfigVO);

    /**
     * 验前端传到后台的红包池ID是否被用过
     * @description  一个生日活动配置一个生日红包，如果这个生日红包被别的生日活动用过。就不能再被使用了
     * @param birthdayConfigVO
     * @return
     */
    public boolean verifyIsRedPackageSelected(BirthdayConfigVO birthdayConfigVO);
}
