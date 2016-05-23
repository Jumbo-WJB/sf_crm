package com.shufensoft.crm.biz.adapter;

import com.shufensoft.crm.biz.adapter.jsonObj.LogisticsTraceYZJsonObj;
import com.shufensoft.crm.biz.adapter.jsonObj.TransitStepInfoJsonObj;
import com.shufensoft.crm.biz.adapter.jsonObj.UserYZjsonObj;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import com.shufensoft.crm.biz.service.express.vo.TransitStepVO;
import com.shufensoft.crm.common.api.client.YouZanApiClient;
import com.shufensoft.crm.common.api.enums.KdtApiEnums;
import com.shufensoft.crm.common.api.exception.YouZanApiException;
import com.shufensoft.crm.common.api.request.YouZanRequest;
import com.shufensoft.crm.common.api.response.YouZanRespone;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.JSONUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 *  @ProjectName: sf-crm  
 *  @Description:有赞adpter
 *  @author litu  litu@shufensoft.com
 *  @date 2015/4/23 15:22  
 */
public class YouZanAdapter {

    private static final Logger logger = Logger.getLogger(YouZanAdapter.class);

    /**
     * 有赞交易数据拉取
     *
     * @param sellerShop
     * @param pageNo
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
    public YouZanRespone pullYouZanTrade(SellerShop sellerShop, Long pageNo, Long pageSize, Date startDate, Date endDate) {

        AssertsUtil.notNull(sellerShop, "sellerShop");

        YouZanRequest kdtRequest = new YouZanRequest();

        try {

            String appId = sellerShop.getShopAppId();
            String appSecret = sellerShop.getShopAppSecret();
            YouZanApiClient youZanApiClient = new YouZanApiClient(appId, appSecret);

            Map<String, String> params = new HashMap<String, String>();
            params.put("start_update", DateUtil.getDateToString(startDate));
            params.put("end_update", DateUtil.getDateToString(endDate));
            params.put("page_no", String.valueOf(pageNo));
            params.put("page_size", String.valueOf(pageSize));
            params.put("use_has_next", "true");
            kdtRequest.setParames(params);
            kdtRequest.setApi(KdtApiEnums.TRADES_SOLD_GET.getCode());
            YouZanRespone kdtRespone = youZanApiClient.doGet(kdtRequest);

            if (kdtRespone != null) {
                if ("0".equals(kdtRespone.getErrorCode())) {
                    return kdtRespone;
                }
                logger.error("execute " + kdtRequest.getApi() + " error,errorMsg:"
                        + (kdtRespone.getErrorMessage() == null ? "" : kdtRespone.getErrorMessage()));

                throw new YouZanApiException(kdtRequest.getApi(), kdtRespone.getErrorCode(),
                        kdtRespone.getErrorMessage());
            }

        } catch (Exception e) {

            logger.error("YouZanAdapter.pullYouZanTrade", e);
            throw new YouZanApiException(kdtRequest.getApi(), e.getMessage(), e);
        }

        return null;

    }

    /**
     * 有赞物流信息查询
     * @param sellerShop
     * @param tid
     * @return
     */
    public ExpressDetailVO queryYouZanLogisticsTrace(SellerShop sellerShop, String tid) {

        AssertsUtil.notNull(sellerShop, "sellerShop");
        AssertsUtil.notNull(tid, "tid");

        YouZanRequest kdtRequest = new YouZanRequest();

        try {

            String appId = sellerShop.getShopAppId();
            String appSecret = sellerShop.getShopAppSecret();
            YouZanApiClient youZanApiClient = new YouZanApiClient(appId, appSecret);

            Map<String, String> params = new HashMap<String, String>();
            params.put("tid", String.valueOf(tid));
            kdtRequest.setParames(params);
            kdtRequest.setApi(KdtApiEnums.LOGISTICS_TRACE_SEARCH.getCode());
            YouZanRespone kdtRespone = youZanApiClient.doGet(kdtRequest);

            if (kdtRespone != null) {

                if ("0".equals(kdtRespone.getErrorCode())) {
                    String userJson = kdtRespone.getResultJson();
                    LogisticsTraceYZJsonObj logisticsTraceYZJsonObj = (LogisticsTraceYZJsonObj) JSONUtils.parseToObject(userJson, LogisticsTraceYZJsonObj.class);
                    return logisticsTraceYZToExpressDetail(logisticsTraceYZJsonObj);
                }
                if ("50000".equals(kdtRespone.getErrorCode())) {
                    logger.info("execute " + kdtRequest.getApi() + " result:"
                            + (kdtRespone.getErrorMessage() == null ? "" : kdtRespone.getErrorMessage()));
                    return null;
                }

                logger.error("execute " + kdtRequest.getApi() + " error,errorMsg:"
                        + (kdtRespone.getErrorMessage() == null ? "" : kdtRespone.getErrorMessage()));

                throw new YouZanApiException(kdtRequest.getApi(), kdtRespone.getErrorCode(),
                        kdtRespone.getErrorMessage());
            }

        } catch (Exception e) {

            logger.error("YouZanAdapter.queryYouZanUser", e);
            throw new YouZanApiException(kdtRequest.getApi(), e.getMessage(), e);
        }

        return null;

    }

    /**
     * 外部快递对象对象转化成内部快递对象
     *
     * @param logisticsTraceYZJsonObj
     * @return
     */
    private ExpressDetailVO logisticsTraceYZToExpressDetail(LogisticsTraceYZJsonObj logisticsTraceYZJsonObj) throws Exception {

        if (logisticsTraceYZJsonObj == null) {
            return null;
        }

        ExpressDetailVO expressDetailVO = new ExpressDetailVO();
        expressDetailVO.setExpressCompany(logisticsTraceYZJsonObj.getCompany_name());
        expressDetailVO.setInvoiceNo(logisticsTraceYZJsonObj.getOut_sid());
        expressDetailVO.setStatus(logisticsTraceYZJsonObj.getStatus());

        if (!CollectionUtils.isEmpty(logisticsTraceYZJsonObj.getTrace_list())) {

            List<TransitStepVO> transitStepVOs = new ArrayList<TransitStepVO>();
            for (TransitStepInfoJsonObj transitStepInfoJsonObj : logisticsTraceYZJsonObj.getTrace_list()) {

                TransitStepVO transitStepVO = (TransitStepVO) BeanCopierUtils.
                        copyHumpFieldProperties(transitStepInfoJsonObj, TransitStepVO.class);

                transitStepVOs.add(transitStepVO);
            }

            expressDetailVO.setTransitStepVOs(transitStepVOs);
        }

        return expressDetailVO;

    }


    /**
     * 有赞用户数据查询
     * @param wxUserId
     * @return
     */
    public UserYZjsonObj queryYouZanUser(SellerShop sellerShop, Long wxUserId) {

        AssertsUtil.notNull(sellerShop, "sellerShop");
        AssertsUtil.notNull(wxUserId, "wxUserId");

        YouZanRequest kdtRequest = new YouZanRequest();

        try {

            String appId = sellerShop.getShopAppId();
            String appSecret = sellerShop.getShopAppSecret();
            YouZanApiClient youZanApiClient = new YouZanApiClient(appId, appSecret);

            Map<String, String> params = new HashMap<String, String>();
            params.put("user_id", String.valueOf(wxUserId));
            params.put("fields", "user_id,weixin_openid,nick,avatar,follow_time,sex,province,city,tags");
            kdtRequest.setParames(params);
            kdtRequest.setApi(KdtApiEnums.USER_WEIXIN_FOLLOWER_GET.getCode());
            YouZanRespone kdtRespone = youZanApiClient.doGet(kdtRequest);

            if (kdtRespone != null) {

                if ("0".equals(kdtRespone.getErrorCode())) {
                    String userJson = kdtRespone.getResultJson();

                    return (UserYZjsonObj) JSONUtils.parseToObject(userJson, UserYZjsonObj.class);
                }

                logger.error("execute " + kdtRequest.getApi() + " error,errorMsg:"
                        + (kdtRespone.getErrorMessage() == null ? "" : kdtRespone.getErrorMessage()));

                throw new YouZanApiException(kdtRequest.getApi(), kdtRespone.getErrorCode(),
                        kdtRespone.getErrorMessage());
            }

        } catch (Exception e) {

            logger.error("YouZanAdapter.queryYouZanUser", e);
            throw new YouZanApiException(kdtRequest.getApi(), e.getMessage(), e);
        }

        return null;

    }
}
