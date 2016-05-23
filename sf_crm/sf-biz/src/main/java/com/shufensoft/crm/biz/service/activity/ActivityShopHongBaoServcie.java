package com.shufensoft.crm.biz.service.activity;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.defined.shoppingHongbao.ActivityGoodsDo;
import com.shufensoft.crm.biz.domain.generation.activity.Activity;
import com.shufensoft.crm.biz.domain.generation.activity.ActivityGoods;
import com.shufensoft.crm.biz.vo.ActivityGoodsVo;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p></p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/10/9  
 */
public interface ActivityShopHongBaoServcie {

    /**
     * 创建购物红包活动
     * */
    public void createShoppingHongbaoActivity(Activity activity, ActivityGoods activityGoods);
    /**
     * 根据活动id获取活动商品详细信息
     * @param activityId
     * @return
     */
    public ActivityGoods  getActivityGoodsByActivityId(Long sellerId,Long  activityId);

    /**
     *  分页查找商户购物红包活动
     * */
    public PageInfo queryActivityGoodsDatasByPage(ActivityGoodsVo activityGoodsVo, Integer start, Integer length);

    /**
     *  查找商户购物红包活动
     * */
    public List<ActivityGoodsDo> queryActivityGoodsDatas(ActivityGoodsDo activityGoodsDo);

    /**
     * create or update
     * */
    public void saveOrUpdateHongbaoActivity(Activity activity, ActivityGoods activityGoods);

    /**
     * delete
     * */
    public int delete(Long sellerId, Long activityGoodsId);




}
