package com.shufensoft.crm.polySpire.adapter;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.PropertyReader;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TraderatesGetRequest;
import com.taobao.api.response.TraderatesGetResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *               淘宝adpter
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
public class TaoBaoAdapter {

    private static final Logger logger = Logger.getLogger(TaoBaoAdapter.class);

    public static String TAOBAO_API_URI_KEY = "taobao.api.url";

    public static String taobaoApiUri = PropertyReader.getValue(TAOBAO_API_URI_KEY);


    /**
     * 拉取淘宝评价信息
     *
     * @param sellerId
     * @param tid
     * @param pageNo
     * @param pageSize
     * @return
     */
    public TraderatesGetResponse pullTaoBaoTradeRate(Long sellerId, Long shopId, Long tid, Long pageNo, Long pageSize, Date startDate, Date endDate) {


        AssertsUtil.notNull(sellerId, "sellerId");

        if (pageNo == null || pageNo == 0) {
            pageNo = 1L;
        }

        if (pageSize == null || pageSize == 0) {
            pageSize = 40L;
        }

        SellerShop sellerShop = SellerConfigCache.getSellerShop(String.valueOf(sellerId), String.valueOf(shopId));
        TaobaoClient client = new DefaultTaobaoClient(taobaoApiUri, sellerShop.getShopAppId(),
                sellerShop.getShopAppSecret());

        TraderatesGetRequest req = new TraderatesGetRequest();
        req.setFields("tid,oid,role,nick,result,created,rated_nick,item_title,item_price,content," +
                "reply,num_iid,valid_score");
        req.setRateType("get");
        req.setRole("buyer");
        req.setPageNo(pageNo);
        req.setPageSize(pageSize);
        req.setStartDate(startDate);
        req.setEndDate(endDate);
        req.setTid(tid);
        req.setUseHasNext(true);

        TraderatesGetResponse response;

        try {

            response = client.execute(req, sellerShop.getShopAccessToken());

        } catch (ApiException e) {

            logger.error("execute trade rates Get Request error,errorMsg:"
                    + (e.getMessage() == null ? "" : e.getMessage()), e);
            throw new RuntimeException("execute trade rates Get Request error,errorMsg:"
                    + (e.getMessage() == null ? "" : e.getMessage()), e);

        }

        if (StringUtils.isNotBlank(response.getErrorCode())) {
            logger.error("execute trade rates Get Request error,subCode:" + response.getSubCode() + "errorMsg:"
                    + (response.getMsg() == null ? "" : response.getMsg()) + " subMsg:" + (response.getMsg() == null ? "" : response.getSubMsg()));
            throw new RuntimeException("execute trade rates Get Request error,subCode:" + response.getSubCode() + "errorMsg:"
                    + (response.getMsg() == null ? "" : response.getMsg()) + " subMsg:" + (response.getMsg() == null ? "" : response.getSubMsg()));
        }

        return response;

    }


}
