package com.shufensoft.crm.biz.adapter;

import com.alibaba.fastjson.JSONObject;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.domain.order.ItemInfo;
import com.jd.open.api.sdk.domain.order.OrderResult;
import com.jd.open.api.sdk.domain.order.OrderSearchInfo;
import com.jd.open.api.sdk.domain.ware.PopCommentSafService.PopCommentJosVo;
import com.jd.open.api.sdk.request.etms.EtmsTraceGetRequest;
import com.jd.open.api.sdk.request.ware.ClubPopVendercommentsGetRequest;
import com.jd.open.api.sdk.response.etms.EtmsTraceGetResponse;
import com.jd.open.api.sdk.response.etms.TraceApiDto;
import com.jd.open.api.sdk.response.order.OrderSearchResponse;
import com.jd.open.api.sdk.response.seller.SellerVenderInfoGetResponse;
import com.jd.open.api.sdk.response.seller.VenderInfoResult;
import com.jd.open.api.sdk.response.ware.ClubPopVendercommentsGetResponse;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.comment.CommentJD;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverJD;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.ItemInfoJD;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.service.trade.vo.TraceApiDtoVO;
import com.shufensoft.crm.biz.vo.AccessTokenVo;
import com.shufensoft.crm.common.api.client.JDClient;
import com.shufensoft.crm.common.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lin on 2015/6/13.
 */
public class JDAdapter {

    private static Logger logger = Logger.getLogger(JDAdapter.class);

    private static JDClient jdClient = new JDClient();


    /**
     *  京东接口api
     * */
    private final static String JD_BASE_URI = "https://api.jd.com/routerjson";

    /**
     * 京东获取accessToken, refreshToken接口 URL
     * */
    private final static String JD_ACCESS_TOKEN_URL = "https://oauth.jd.com/oauth/token";

    /**
     * 通过京东API调用解析返回结果
     * @modifer litu  litu@shufensoft.com  
     * @param appKey
     * @param appSecret
     * @param accessToken
     * @param startDate
     * @param endDate
     * @param page
     * @param pageSize
     * @return
     */
    public List<OrderJD> syncOrderByDateAndAppKey(String appKey,String appSecret, String accessToken,
                                                  Date startDate, Date endDate,int page,int pageSize){

        List<OrderJD> list = new ArrayList<OrderJD>();
        try {

            if(page ==0){
                page =1;
            }

            if(pageSize == 0){
                pageSize = 40;
            }

            OrderSearchResponse response = jdClient.getOrderJDBySearch(appKey, appSecret, accessToken, startDate, endDate, page, pageSize);
            OrderResult result = response.getOrderInfoResult();
            if(result != null) {
                List<OrderSearchInfo> returnList = result.getOrderInfoList();

                for (OrderSearchInfo order : returnList) {

                    OrderJD orderJD = (OrderJD) BeanCopierUtils.copyProperties(order, OrderJD.class);
                    AssertsUtil.notNull(orderJD, "OrderJD");

                    if (StringUtils.isNotBlank(order.getFreightPrice())) {
                        orderJD.setFreightPrice(new BigDecimal(order.getFreightPrice()));
                    }

                    if (StringUtils.isNotBlank(order.getOrderTotalPrice())) {
                        orderJD.setOrderTotalPrice(new BigDecimal(order.getOrderTotalPrice()));
                    }

                    if (StringUtils.isNotBlank(order.getOrderPayment())) {
                        orderJD.setOrderPayment(new BigDecimal(order.getOrderPayment()));
                    }

                    if (StringUtils.isNotBlank(order.getSellerDiscount())) {
                        orderJD.setSellerDiscount(new BigDecimal(order.getSellerDiscount()));
                    }

                    if (StringUtils.isNotBlank(order.getOrderSellerPrice())) {
                        orderJD.setOrderSellerPrice(new BigDecimal(order.getOrderSellerPrice()));
                    }

                    if (StringUtils.isNotBlank(order.getOrderStartTime())) {
                        orderJD.setOrderStartTime(DateUtil.strToDate(order.getOrderStartTime()));
                    }

                    if (StringUtils.isNotBlank(order.getOrderEndTime())) {
                        orderJD.setOrderEndTime(DateUtil.strToDate(order.getOrderEndTime()));
                    }


                    if (StringUtils.isNotBlank(order.getPaymentConfirmTime())) {
                        orderJD.setPaymentConfirmTime(DateUtil.strToDate(order.getPaymentConfirmTime()));
                    }
                    if (StringUtils.isNotBlank(order.getModified())) {
                        orderJD.setModified(DateUtil.strToDate(order.getModified()));
                    }

                    List<ItemInfo> itemInfoList = order.getItemInfoList(); //填充商品信息
                    AssertsUtil.check(!CollectionUtils.isEmpty(itemInfoList), "itemInfoList is empty");
                    List<ItemInfoJD> infoList = new ArrayList<ItemInfoJD>();
                    for (ItemInfo info : itemInfoList) {

                        ItemInfoJD itemInfo = (ItemInfoJD) BeanCopierUtils.copyProperties(info, ItemInfoJD.class);
                        AssertsUtil.notNull(itemInfo, "itemInfo");
                        String gifPoint = info.getGiftPoint();
                        if (StringUtils.isNotBlank(gifPoint)) {
                            itemInfo.setGiftPoint(Integer.parseInt(gifPoint));
                        }

                        String itemTotal = info.getItemTotal();
                        if (StringUtils.isNotBlank(itemTotal)) {
                            itemInfo.setItemTotal(Integer.parseInt(itemTotal));
                        }

                        infoList.add(itemInfo);
                    }

                    ReceiverJD rjd = (ReceiverJD) BeanCopierUtils.copyProperties(order.getConsigneeInfo(), ReceiverJD.class);                                //填充收件人信息

                    orderJD.setReceiverJD(rjd);
                    orderJD.setItemInfoJDList(infoList);
                    list.add(orderJD);
                }
            }
        }catch(Exception e){

            logger.error(e.getMessage(),e);

            throw new RuntimeException(e);

        }

        return list;

    }



    /**
     * 查询京东快递
     * @author litu  litu@shufensoft.com  
     * @param sellerShop
     * @param waybillCode
     * @return
     */
    public List<TraceApiDtoVO> queryEtmsTrace(SellerShop sellerShop, String waybillCode){

        AssertsUtil.notBlank(waybillCode,"waybillCode is null");
        AssertsUtil.notNull(sellerShop,"sellerShop is null");
        AssertsUtil.notBlank(sellerShop.getShopAccessToken(),"shopAccessToken is null");
        AssertsUtil.notBlank(sellerShop.getShopAppId(),"shopAppId is null");
        AssertsUtil.notBlank(sellerShop.getShopAppSecret(),"shopAppSecret is null");

        List<TraceApiDto> traceApiDtos  = null;
        try {

            JdClient client=new DefaultJdClient(JD_BASE_URI,sellerShop.getShopAccessToken(),
                    sellerShop.getShopAppId(),sellerShop.getShopAppSecret());

            EtmsTraceGetRequest request=new EtmsTraceGetRequest();
            request.setWaybillCode(waybillCode);

            EtmsTraceGetResponse response=client.execute(request);

            traceApiDtos = response.getTraceApiDtos();
            if(StringUtils.isNotBlank(response.getZhDesc())){
                throw new RuntimeException(response.getZhDesc());
            }

            if(CollectionUtils.isEmpty(traceApiDtos)){
                return null;
            }

        }catch(Exception e){
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }

        return BeanCopierUtils.copyListProperties(traceApiDtos,TraceApiDtoVO.class);
    }

    /**
     * 通过京东API调用解析返回结果
     * @author litu  litu@shufensoft.com  
     * @param sellerShop
     * @param orderId
     * @return
     */
    public List<CommentJD> syncCommentJDByOrderId(SellerShop sellerShop, String orderId){

        AssertsUtil.notBlank(orderId,"orderId is null");
        AssertsUtil.notNull(sellerShop,"sellerConfigInfo is null");

        List<CommentJD> commentJDs = null;
        try {

            JdClient client=new DefaultJdClient(JD_BASE_URI,sellerShop.getShopAccessToken(),
                    sellerShop.getShopAppId(),sellerShop.getShopAppSecret());

            ClubPopVendercommentsGetRequest request=new ClubPopVendercommentsGetRequest();

            request.setOrderIds(orderId);

            ClubPopVendercommentsGetResponse response = client.execute(request);

            List<PopCommentJosVo> popCommentJosVos  = response.getComments();

            if(CollectionUtils.isEmpty(popCommentJosVos)){
                return commentJDs;
            }
            commentJDs = new ArrayList<CommentJD>();
            for(PopCommentJosVo popCommentJosVo : popCommentJosVos){
                CommentJD commentJD = (CommentJD)BeanCopierUtils.copyProperties(popCommentJosVo,CommentJD.class);
                commentJD.setJdCommentId(popCommentJosVo.getCommentId());
                commentJD.setScore(popCommentJosVo.getScore());
                commentJD.setReplyCount(popCommentJosVo.getReplyCount());
                commentJD.setUsefulCount(popCommentJosVo.getUsefulCount());
                commentJDs.add(commentJD);
            }

        }catch(Exception e){
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }

        return commentJDs;
    }

    /**
     * 京东刷新 token 的接口地址
     *  https://oauth.jd.com/oauth/token?client_id=YOUR_CLIENT_ID&client_secret=YOUR_CLIENT_ID&grant_type=refresh_token&refresh_token=YOUR_REFRESH_TOKEN
     * */
    public static JSONObject freshJDAccessToken(SellerShop sellerShop) {

        String jsonStr = "";
        AccessTokenVo accessTokenVo = null;
        JSONObject json = null;
        try {
            if (sellerShop != null) {

                String appKey = sellerShop.getShopAppId();
                String appSecret = sellerShop.getShopAppSecret();
                String jdRefreshToken = sellerShop.getShopRefreshToken();
                String url = JD_ACCESS_TOKEN_URL + "?client_id=" + appKey + "&client_secret=" + appSecret + "&grant_type=refresh_token&refresh_token=" + jdRefreshToken;
                URL uri = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
                conn.setRequestProperty("Accept-Charset", "utf-8");
                conn.setRequestMethod("POST");
                InputStream is = conn.getInputStream();
                jsonStr = CommonUtil.inputStream2String(is, "gbk");
                is.close();
                json = JSONObject.parseObject(jsonStr);
                String returnCode = json.getString("code");

                if ("0".equals(returnCode)) {
                    String accessToken = json.getString("access_token");
                    String refreshToken = json.getString("refresh_token");
                    int expiresTime = Integer.parseInt(json.getString("expires_in"));

                    if (accessToken != null) {

                        SellerShop sellerShopTmp = new SellerShop();
                        sellerShopTmp.setShopAccessToken(accessToken);
                        sellerShopTmp.setShopRefreshToken(refreshToken);
                        Date expiresDate = DateUtil.operateDate(new Date(), 0, 0, 0, 0, 0, expiresTime);
                        sellerShopTmp.setShopTokenExpire(expiresDate);             //
                        sellerShopTmp.setShopId(sellerShop.getShopId());
                        sellerShopTmp.setSellerId(sellerShop.getSellerId());
                        SellerConfigCache.putSellerShop(String.valueOf(sellerShopTmp.getSellerId()),sellerShopTmp);

                        accessTokenVo = new AccessTokenVo();
                        accessTokenVo.setSellerId(sellerShop.getSellerId());
                        accessTokenVo.setExpiresTime(expiresTime);
                        accessTokenVo.setAccessToken(accessToken);
                        accessTokenVo.setRefreshToken(refreshToken);

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return json;
    }

    /**
     * 京东获取accessToken
     * */
    public static JSONObject getJdAccessToken(String code, String state) throws Exception{
        if(StringUtils.isNotBlank(code)){

            String appKey;
            String appSecret;
            String redirectUri = PropertyReader.getValue("jd.redirect.uri");
            String jsonStr;
            String url;
            if(StringUtils.isNotBlank(state)){
                String[] sellerInfo = state.split("_");
                SellerShop sellerShop = SellerConfigCache.getSellerShop(sellerInfo[0],sellerInfo[1]);
                AssertsUtil.notNull(sellerShop, "sellerShop");

                appKey = sellerShop.getShopAppId();
                appSecret = sellerShop.getShopAppSecret();
                url = JD_ACCESS_TOKEN_URL + "?grant_type=authorization_code&client_id=" + appKey
                        + "&client_secret=" + appSecret
                        + "&scope=read&redirect_uri=" + redirectUri
                        + "&code=" + code
                        + "&state=" + state;
            }else{
                appKey = PropertyReader.getValue("crm.jd.app.key");
                appSecret = PropertyReader.getValue("crm.jd.app.secret");
                url = JD_ACCESS_TOKEN_URL + "?grant_type=authorization_code&client_id=" + appKey
                        + "&client_secret=" + appSecret
                        + "&scope=read&redirect_uri=" + redirectUri
                        + "&code=" + code;
            }
            logger.info("url== :  " + url);
            URL uri = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestMethod("POST");
            InputStream is = conn.getInputStream();
            jsonStr = CommonUtil.inputStream2String(is, "GBK");
            is.close();
            JSONObject json = JSONObject.parseObject(jsonStr);
            if(json != null){
                return json;
            }
        }
        return null;
    }

    /**
     *  获取商家店铺名称
     * */
    public static String getShopName(String accessToken,String appKey,String appSecret) throws Exception{
        SellerVenderInfoGetResponse sellerVenderInfoGetResponse = jdClient.getSellerVenderInfoGetResponse(accessToken,appKey,appSecret);
        if(sellerVenderInfoGetResponse != null){
            return sellerVenderInfoGetResponse.getVenderInfoResult().getShopName();
        }
        return null;
    }

    /**
     * 获取JD商品基本信息
     * */
    public static VenderInfoResult getJDVenderInfo(String accessToken,String appKey,String appSecret) throws Exception{
        SellerVenderInfoGetResponse sellerVenderInfoGetResponse = jdClient.getSellerVenderInfoGetResponse(accessToken,appKey,appSecret);
        if(sellerVenderInfoGetResponse != null){
            logger.info("获取京东商户基本信息： " + sellerVenderInfoGetResponse.getCode() + "   " + sellerVenderInfoGetResponse.getMsg() + "  " + sellerVenderInfoGetResponse.getEnDesc());
            return sellerVenderInfoGetResponse.getVenderInfoResult();
        }
        return null;
    }



}
