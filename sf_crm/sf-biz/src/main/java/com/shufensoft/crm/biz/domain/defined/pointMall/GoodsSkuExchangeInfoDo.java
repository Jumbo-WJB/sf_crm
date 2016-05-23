package com.shufensoft.crm.biz.domain.defined.pointMall;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 *     sku 被兑换的人数
 *     goods 被兑换的人数
 * </p>
 *  @author: lin
 *  @date: 2015/7/5  
 */
@Data
public class GoodsSkuExchangeInfoDo {

    private Long skuId;

    private Long sellerId;

    private Long goodsId;

    private String title;

    private Long price;

    private Long point;

    private String imgsUrl;

    private Long exchangeCount;      //被兑换的人数

    private String propsName;

    private Long stockSize;    //库存量

    /** 是否虚拟商品 y是 n否 */
    private String isVirtual;

    /** 缩略图 */
    private String thumbnail;






}
