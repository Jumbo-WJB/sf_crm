package com.shufensoft.crm.biz.domain.defined.trade;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.common.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *  @ProjectName: sf-crm 
 *  @Description: <p>平台交易DO</p>
 *  @author litu  litu@suniusoft.com
 *  @date 2015/6/20  
 */
@ToString
public class TradeDO{

    /**交易id*/
    @Getter@Setter
    private Long  tid;

    /**店铺id**/
    @Getter@Setter
    private Long shopId;

    /**收货人id*/
    @Getter@Setter
    private Long receiverId;

    /**收货人姓名*/
    @Getter@Setter
    private String receiverName;

    /**订单状态*/
    @Getter@Setter
    private String status;

    /**买家昵称*/
    @Getter@Setter
    private String buyerNick;

    /**手机号码*/
    @Getter@Setter
    private String mobile;

    /**省份*/
    @Getter@Setter
    private String province;

    /**城市*/
    @Getter@Setter
    private String city;

    /**下单时间*/
    @Getter@Setter
    private Date created;

    /**价格*/
    @Getter@Setter
    private BigDecimal price;

    /**订单来源*/
    @Getter@Setter
    private String tradeSource;

    /**查询关键字*/
    @Getter@Setter
    private String keyword;

    @Getter@Setter
    private BigDecimal minPrice;

    @Getter@Setter
    private BigDecimal maxPrice;

    @Getter@Setter
    private String orderClause;

    /**是否有手机号*/
    @Getter@Setter
    private String hasMobile;

    @Getter@Setter
    private Long sellerId;

    @Getter@Setter
    private List<Long> shopIdList;

    /**店铺名称**/
    private String shopName;

    /**
     * 获取店铺信息
     */

    public void setShopName(String shopName){
        String shopType = null;
        if (StringUtils.isNotBlank(shopName)){
            this.shopName = shopName;
        }else{
            if (shopId != null && shopId != 0){
                SellerShop shop = SellerConfigCache.getSellerShop(String.valueOf(sellerId),String.valueOf(shopId));
                if (shop != null){
                    if ("TB".equals(shop.getShopType())){
                        shopType = "淘宝";
                    }else if ("TMALL".equals(shop.getShopType())){
                        shopType = "天猫";
                    }else if ("JD".equals(shop.getShopType())){
                        shopType = "京东";
                    }else if ("YZ".equals(shop.getShopType())){
                        shopType = "有赞";
                    }else if ("WX".equals(shop.getShopType())){
                        shopType = "微信";
                    }
                    this.shopName = shop.getShopName()+"("+ shopType +")";
                }
            }
        }
    }

    public String getShopName(){
        return this.shopName;
    }
}
