package com.shufensoft.crm.biz.service.express;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.dao.defined.order.OrderDAO;
import com.shufensoft.crm.biz.dao.defined.user.UserDAO;
import com.shufensoft.crm.biz.dao.defined.user.UserPortraitDAO;
import com.shufensoft.crm.biz.domain.defined.express.OrdersInfoDO;
import com.shufensoft.crm.biz.domain.defined.user.UserDO;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   手机端，我的快递service类
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/3  
 */
@Service
public class MobileExpressService {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserPortraitDAO userPortraitDAO;

    /**
     * 我的快递列表查询
     * @param userId
     * @return
     */
    public PageInfo findOrderList(Long sellerId, Long userId, int start, int pageNum) {

        PageHelper.startPage(start,pageNum);

        List<OrdersInfoDO> ordersList = orderDAO.selectOrdersByUserId(sellerId, userId);

        if(CollectionUtils.isEmpty(ordersList)){
            return null;
        }

        return new PageInfo(ordersList);

    }

    /**
     * 查找我的快递头部的信息
     *
     * @param userId
     * @param sellerId
     * @return
     */
    public Map<String, Object> findExpressHeadInfo(Long sellerId, Long userId) {

        Map<String, Object> datasMap = new HashMap<String, Object>();
        List tbOrderList = new ArrayList();

        Long rank = 0L; //排名
        Long OrderNums = 0L;
        Long tbOrderNums = orderDAO.selectTbOrderNum(sellerId, userId); //淘宝的订单数
        Long jdOrderNums = orderDAO.selectJdOrderNum(sellerId, userId); //京东的订单数
        Long yzOrderNums = orderDAO.selectYzOrderNum(sellerId, userId); //有赞的订单数量
        OrderNums = tbOrderNums + jdOrderNums + yzOrderNums; //累计购物订单数

        /**
         *  获取常用快递(现在暂时计算淘宝订单中常用的快递)
         */
        UserDO userDO = userDAO.selectIds(sellerId, userId);

        if (userDO != null) {
            if (userDO.getUserIdTb() != null) {
                tbOrderList = orderDAO.selectLogisticesGroup(userDO.getUserIdTb());
            }

            if (userDO.getUserPortraitId() != null) {
                rank = userPortraitDAO.rank(userDO.getUserPortraitId());
            }
            //累计购物金额
//            totalPurchaseAmount = userPortraitDAO.selectTotalPurchaseAmount(userDO.getUserPortraitId());
//            if(totalPurchaseAmount == null) {
//                totalPurchaseAmount = 0L;
//            }
        }


        //商家名称
        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(Long.toString(sellerId));

        if (CollectionUtils.isNotEmpty(tbOrderList)) {
            datasMap.put("often_express", tbOrderList.get(0));
        } else {
            datasMap.put("often_express", null);
        }

        Long onTheRoadNum = orderDAO.onTheRoadOrderNum(userId); //正在发货的数量
        datasMap.put("on_road", onTheRoadNum);
        //累计购物金额
//        datasMap.put("total_purchase_amount",totalPurchaseAmount);
        datasMap.put("rank", rank);
        datasMap.put("seller_name", sellerConfigInfo.getSellerName());
        datasMap.put("OrderNums", OrderNums);
        return datasMap;
    }
}
