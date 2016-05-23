package com.shufensoft.crm.biz.service.activity.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.dao.defined.shoppingHongbao.ShoppingHongbaoDao;
import com.shufensoft.crm.biz.dao.generation.activity.ActivityGoodsMapper;
import com.shufensoft.crm.biz.dao.generation.activity.ActivityMapper;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallFansDo;
import com.shufensoft.crm.biz.domain.defined.shoppingHongbao.ActivityGoodsDo;
import com.shufensoft.crm.biz.domain.generation.activity.Activity;
import com.shufensoft.crm.biz.domain.generation.activity.ActivityExample;
import com.shufensoft.crm.biz.domain.generation.activity.ActivityGoods;
import com.shufensoft.crm.biz.domain.generation.activity.ActivityGoodsExample;
import com.shufensoft.crm.biz.service.activity.ActivityShopHongBaoServcie;
import com.shufensoft.crm.biz.vo.ActivityGoodsVo;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p></p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/10/9  
 */
@Service(value = "activityShopHongBaoServcie")
public class ActivityShopHongBaoServcieImpl implements ActivityShopHongBaoServcie {

    @Autowired
    private ActivityGoodsMapper activityGoodsMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ShoppingHongbaoDao shoppingHongbaoDao;

    @Override
    public ActivityGoods getActivityGoodsByActivityId(Long sellerId,Long activityId) {
        ActivityGoodsExample activityGoodsExample = new ActivityGoodsExample();
        activityGoodsExample.createCriteria().andActivityGoodsIdEqualTo(activityId).andSellerIdEqualTo(sellerId);
        List<ActivityGoods> activityGoodsList = activityGoodsMapper.selectByExample(activityGoodsExample);
        return activityGoodsList.isEmpty() ? new ActivityGoods() : activityGoodsList.get(0);
    }

    /**
     * 分页查找商户购物红包活动
     *
     * @param activityGoodsVo
     * @param start
     * @param length
     */
    @Override
    public PageInfo queryActivityGoodsDatasByPage(ActivityGoodsVo activityGoodsVo, Integer start, Integer length) {
        ActivityGoodsDo activityGoodsDo = (ActivityGoodsDo)BeanCopierUtils.copyProperties(activityGoodsVo, ActivityGoodsDo.class);
        PageHelper.startPage(start, length);
        List<ActivityGoodsDo> activityGoodsDos = queryActivityGoodsDatas(activityGoodsDo);
        return new PageInfo(activityGoodsDos);
    }

    /**
     * 查找商户购物红包活动
     *
     * @param activityGoodsDo
     */
    @Override
    public List<ActivityGoodsDo> queryActivityGoodsDatas(ActivityGoodsDo activityGoodsDo) {
        return shoppingHongbaoDao.findActivityGoods(activityGoodsDo);
    }

    /**
     * create or update
     *
     * @param activity
     * @param activityGoods
     */
    @Override
    @Transactional
    public void saveOrUpdateHongbaoActivity(Activity activity, ActivityGoods activityGoods) {
        if(activity.getActivityId() != null){
            ActivityExample activityExample = new ActivityExample();
            activityExample.createCriteria().andSellerIdEqualTo(activity.getSellerId()).andActivityIdEqualTo(activity.getActivityId());
            activityMapper.updateByExampleSelective(activity, activityExample);
        }else{
            activityMapper.insertSelective(activity);
        }

        activityGoods.setActivityId(activity.getActivityId());
        if(activityGoods.getActivityGoodsId() != null){
            ActivityGoodsExample activityGoodsExample = new ActivityGoodsExample();
            activityGoodsExample.createCriteria().andSellerIdEqualTo(activityGoods.getSellerId()).andActivityGoodsIdEqualTo(activityGoods.getActivityGoodsId());
            activityGoodsMapper.updateByExampleSelective(activityGoods, activityGoodsExample);
        }else{
            activityGoodsMapper.insertSelective(activityGoods);
        }
    }

    /**
     * delete
     *
     * @param sellerId
     * @param activityGoodsId
     */
    @Override
    @Transactional
    public int delete(Long sellerId, Long activityGoodsId) {
        int num = 0;
        ActivityGoodsExample activityGoodsExample = new ActivityGoodsExample();
        activityGoodsExample.createCriteria().andSellerIdEqualTo(sellerId).andActivityGoodsIdEqualTo(activityGoodsId);

        List<ActivityGoods> list = activityGoodsMapper.selectByExample(activityGoodsExample);
        if(!CollectionUtils.isEmpty(list)){
            ActivityGoods activityGoods = list.get(0);

            ActivityExample activityExample = new ActivityExample();
            activityExample.createCriteria().andSellerIdEqualTo(sellerId).andActivityIdEqualTo(activityGoods.getActivityId());

            num += activityMapper.deleteByExample(activityExample);

            num += activityGoodsMapper.deleteByPrimaryKey(activityGoods.getId());
        }
        return num;
    }

    @Override
    @Transactional
    public void createShoppingHongbaoActivity(Activity activity, ActivityGoods activityGoods) {
        activityMapper.insertSelective(activity);
        activityGoods.setActivityId(activity.getActivityId());
        activityGoodsMapper.insertSelective(activityGoods);
    }

}
