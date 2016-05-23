package com.shufensoft.crm.biz.service.contactCustomer;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketActivity;
import com.shufensoft.crm.biz.vo.MarketActivityVO;
import com.shufensoft.crm.biz.vo.MarketPackageVO;
import com.shufensoft.crm.biz.vo.MarketRecordsVO;
import com.shufensoft.crm.biz.vo.UserVO;

import java.util.List;


/**
 *  @ProjectName: sf-crm 
 *  @Description: 营销活动服务接口
 *  @author yuyuchi yuyc@shufensoft.com
 *  @date 2015/6/15
 */
public interface MarketActivityService {

    /**分页查询营销活动列表 */
    public PageInfo queryMarketingList(MarketActivityVO marketActivityVO, Integer pageNum, Integer length);

    /**保存或更新营销活动**/
    public MarketActivity saveOrUpdateActivity(MarketActivityVO marketActivityVO);

    /**
     * 分页查询营销活动明细(此处为联合查询)
     * @param marketRecordsVO
     * @param pageNum
     * @param length
     * @return
     */
    public PageInfo queryMarketActivity(MarketRecordsVO marketRecordsVO, Integer pageNum, Integer length);

    /**
     * 发送营销活动并保存营销记录
     */
    public Boolean sendMarketing(UserVO userVO,MarketActivityVO marketActivityVO);

    /**
     * 通过activityId查找营销活动
     */
    public List<MarketActivity> findActivity(Long activityId, Long sellerId);

    /**
     * 保存营销编辑
     */
    public int saveEdit(MarketActivityVO marketActivityVO);

    /**
     * 根据活动id删除活动
     * @param activityId
     * @return
     */
    public Boolean deleteActivity(Long activityId,Long sellerId);

    /**
     * 查询账户套餐
     */
    public PageInfo queryMarketPackage(MarketPackageVO marketPackageVO, Integer pageNum, Integer length);

    /**
     * 发送微信群发活动,群发接口发送
     */
    public void sendWxMass(MarketActivityVO marketActivityVO);

    /**
     * 发送微信活动，客服接口发送
     */
    public void sendWxCustom(MarketActivityVO marketActivityVO);

    /**
     * 查询本月商家群发微信消息的次数
     */
    public Integer countMonthWxMassTimes(Long sellerId);
}
