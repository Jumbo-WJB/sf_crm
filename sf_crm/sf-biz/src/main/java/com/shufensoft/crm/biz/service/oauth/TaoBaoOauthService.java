package com.shufensoft.crm.biz.service.oauth;

import com.alibaba.fastjson.JSONObject;
import com.shufensoft.crm.biz.adapter.TaoBaoAdapter;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.dao.generation.seller.SellerConfigInfoMapper;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.oauth.vo.TaoBaoAccessTokenVO;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.common.api.enums.ApiErrorEnums;
import com.shufensoft.crm.common.api.response.TaoBaoResponse;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 淘宝授权service
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/19  
 */
@Service
public class TaoBaoOauthService {

    private static TaoBaoAdapter taoBaoAdapter = new TaoBaoAdapter();

    @Autowired
    SellerConfigInfoMapper sellerConfigInfoMapper;

    @Autowired
    private SendService sendService;
    /**
     * 获取token信息，并保存sellerConfgiInfo
     * @param code
     * @return
     */
    public TaoBaoAccessTokenVO getTokenAccess(String code, SellerShop sellerShop) {

        /**
         * 1.获取access_token
         */
        AssertsUtil.notNull(sellerShop,"sellerShop");
        TaoBaoAccessTokenVO taoBaoAccessTokenVO = taoBaoAdapter.getAccessToken(sellerShop.getShopType(),code,sellerShop.getShopAppId(),sellerShop.getShopAppSecret());
        AssertsUtil.notNull(taoBaoAccessTokenVO, "taoBaoAccessTokenVO");
        AssertsUtil.notBlank(taoBaoAccessTokenVO.getAccess_token(), "accessToken is null");

        /**
         * 2.更新商家配置
         */
        SellerShop sellerShopTmp = new SellerShop();
        sellerShopTmp.setSellerId(sellerShop.getSellerId());
        sellerShopTmp.setShopId(sellerShop.getShopId());
        sellerShopTmp.setShopAccessToken(taoBaoAccessTokenVO.getAccess_token());
        sellerShopTmp.setShopRefreshToken(taoBaoAccessTokenVO.getRefresh_token());

        Long expiresIn = taoBaoAccessTokenVO.getExpires_in();
        if(expiresIn != null){
            Date expiresDate = DateUtil.operateDate(new Date(), 0, 0, 0, 0, 0, taoBaoAccessTokenVO.getExpires_in().intValue());
            sellerShopTmp.setShopTokenExpire(expiresDate);
        }

        SellerConfigCache.putSellerShop(String.valueOf(sellerShopTmp.getSellerId()), sellerShopTmp);

        return taoBaoAccessTokenVO;
    }

    /**
     *
     * */
    public JSONObject refreshAccessToken(SellerShop sellerShop) {
        /**
         * 1.获取access_token
         */
        AssertsUtil.notNull(sellerShop, "sellerShop");
        JSONObject jsonObject = new JSONObject();
        TaoBaoResponse taoBaoResponse = taoBaoAdapter.getRefreshAccessToken(sellerShop);
        if (ApiErrorEnums.SUCCESS.getCode().equals(taoBaoResponse.getErrorCode())) {
            TaoBaoAccessTokenVO taoBaoAccessTokenVO = (TaoBaoAccessTokenVO) JSONUtils.parseToObject(taoBaoResponse.getResultJson(), TaoBaoAccessTokenVO.class);
            AssertsUtil.notNull(taoBaoAccessTokenVO, "taoBaoAccessTokenVO");
            AssertsUtil.notBlank(taoBaoAccessTokenVO.getAccess_token(), "accessToken is null");

            /**
             * 2.更新商家配置表
             */
            SellerShop sellerShopTmp = new SellerShop();
            sellerShopTmp.setSellerId(sellerShop.getSellerId());
            sellerShopTmp.setShopId(sellerShop.getShopId());
            sellerShopTmp.setShopAccessToken(taoBaoAccessTokenVO.getAccess_token());
            sellerShopTmp.setShopRefreshToken(taoBaoAccessTokenVO.getRefresh_token());

            Long expiresIn = taoBaoAccessTokenVO.getExpires_in();
            if (expiresIn != null) {
                Date expiresDate = DateUtil.operateDate(new Date(), 0, 0, 0, 0, 0, taoBaoAccessTokenVO.getExpires_in().intValue());
                sellerShopTmp.setShopTokenExpire(expiresDate);
            }

            SellerConfigCache.putSellerShop(String.valueOf(sellerShopTmp.getSellerId()), sellerShopTmp);
            jsonObject.put("resultCode", ApiErrorEnums.SUCCESS.getCode());
        } else {
            String errorMessage = taoBaoResponse.getErrorMessage();
            JSONObject json = JSONObject.parseObject(errorMessage);
            if (json != null) {
                jsonObject.put("resultCode", ApiErrorEnums.ERROR.getCode());
                jsonObject.put("resultInfo", json);
            }
        }
            return jsonObject;
        }


}
