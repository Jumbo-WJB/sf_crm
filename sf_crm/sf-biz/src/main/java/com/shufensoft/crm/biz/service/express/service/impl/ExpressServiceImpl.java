package com.shufensoft.crm.biz.service.express.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.adapter.ShowApiAdapter;
import com.shufensoft.crm.biz.adapter.jsonObj.TransitStepInfoJsonObj;
import com.shufensoft.crm.biz.cache.LstOfValCache;
import com.shufensoft.crm.biz.cache.RedisCache;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.express.ExpressDAO;
import com.shufensoft.crm.biz.dao.defined.trade.OrderTaoBaoDAO;
import com.shufensoft.crm.biz.dao.defined.user.UserDAO;
import com.shufensoft.crm.biz.dao.generation.express.ExpressInfoMapper;
import com.shufensoft.crm.biz.dao.generation.trade.OrderJDMapper;
import com.shufensoft.crm.biz.dao.generation.trade.OrderTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.trade.OrderYZMapper;
import com.shufensoft.crm.biz.domain.defined.express.ExpressJsonDO;
import com.shufensoft.crm.biz.domain.defined.express.ExpressMessageQueryDO;
import com.shufensoft.crm.biz.domain.defined.trade.OrderTaoBaoDO;
import com.shufensoft.crm.biz.domain.defined.user.UserDO;
import com.shufensoft.crm.biz.domain.generation.express.ExpressInfo;
import com.shufensoft.crm.biz.domain.generation.express.ExpressInfoExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBao;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.express.service.ExpressService;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import com.shufensoft.crm.biz.service.express.vo.OrderVO;
import com.shufensoft.crm.biz.service.express.vo.TransitStepVO;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.YouZanTradeService;
import com.shufensoft.crm.biz.service.trade.vo.LogisticsTraceYZVO;
import com.shufensoft.crm.biz.service.trade.vo.TransitStepInfoVO;
import com.shufensoft.crm.biz.vo.WXMessageQueryVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author lisen  lisen@suniusoft.com
 *  @date 15/7/02 上午8:49  
 */
@Service
public class ExpressServiceImpl implements ExpressService{
    @Autowired
    private ExpressDAO expressDAO;
    @Autowired
    private OrderTaoBaoDAO orderTaoBaoDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OrderTaoBaoMapper orderTaoBaoMapper;
    @Autowired
    private OrderJDMapper orderJDMapper;
    @Autowired
    private OrderYZMapper orderYZMapper;
    @Autowired
    private ExpressInfoMapper expressInfoMapper;
    @Autowired
    private YouZanTradeService youZanTradeService;

    private static ShowApiAdapter showApiAdapter = new ShowApiAdapter();

    @Autowired
    private JdTradeService jdTradeService;


    private static final String TYPE = "EXPRESS";
    /**
     *  分页查询快递查询服务
     * @param wxMessageQueryVO
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo queryExpressDetail(WXMessageQueryVO wxMessageQueryVO, Integer start, Integer pageSize) {

        ExpressMessageQueryDO expressMessageQueryDO = new ExpressMessageQueryDO();

        if (StringUtils.isNotEmpty(wxMessageQueryVO.getWxNickName())){
            expressMessageQueryDO.setWxNickName(wxMessageQueryVO.getWxNickName());
        }

        if (StringUtils.isNotEmpty(wxMessageQueryVO.getBizType())){
            expressMessageQueryDO.setBizType(wxMessageQueryVO.getBizType());
        }

        if (StringUtils.isNotEmpty(wxMessageQueryVO.getMobile())){
            expressMessageQueryDO.setMobile(wxMessageQueryVO.getMobile());
        }

        PageHelper.startPage(start, pageSize);
        List<ExpressMessageQueryDO> expressMessageQueryDOList = expressDAO.selectExpressList(expressMessageQueryDO);

        return new PageInfo(expressMessageQueryDOList);
    }

    /**
     * 根据订单号从第三方快递接口获取最新的快递信息
     * 并且存入到数据库当中
     * @param wxMessageQueryVO
     * @param start
     * @param pageSize
     * @return
     */
    public void getExpressDetailsAndUpdate(WXMessageQueryVO wxMessageQueryVO, Integer start, Integer pageSize) {

        ExpressMessageQueryDO expressMessageQueryDO = new ExpressMessageQueryDO();

        if (StringUtils.isNotEmpty(wxMessageQueryVO.getWxNickName())){
            expressMessageQueryDO.setWxNickName(wxMessageQueryVO.getWxNickName());
        }

        if (StringUtils.isNotEmpty(wxMessageQueryVO.getBizType())){
            expressMessageQueryDO.setBizType(wxMessageQueryVO.getBizType());
        }

        if (StringUtils.isNotEmpty(wxMessageQueryVO.getMobile())){
            expressMessageQueryDO.setMobile(wxMessageQueryVO.getMobile());
        }

        PageHelper.startPage(start, pageSize);

        List<UserDO> allIdsList = expressDAO.selectAllAboutId(expressMessageQueryDO);

        PageInfo pageInfo = new PageInfo(allIdsList);

    }


    //重写 查找一个用户user_id下的所有订单
    public Map<String, Object> findAllOrders(UserDO userDO) {
        Map<String, Object> ordersMap = new HashMap<String,Object>();
        //通过user_id_tb从order_taobao表中找到快递单号(invoice_no)，订单号(oid)
        List<OrderTaoBaoDO> taobaoOrdersList = orderTaoBaoDAO.selectOrderTaoBaoWithUserIdTaoBao(userDO.getUserIdTb());
        // TODO  暂时先不管京东的订单
        //根据user表中的user_id_jd从order_jd表中找到订单号(order_id)
        //List<OrderJDDO> jdOrdersList = orderJDDAO.findOrderIdsByUserIdJd(userDO.getUserIdJd());
        //TODO  暂时先不管有赞的订单
        //根据user表中的user_id_yz从order_yz表中找到订单号(tid)
        //List<OrderYZDO> tidsList= orderYZDAO.findTidsByUserIdYz(userDO.getUserIdYz());
        //把user_id也put进去，后面的方法要用到
        ordersMap.put("userId", userDO.getUserId());

        //把所有的订单都存到ordersMap中
        ordersMap.put("taobao", taobaoOrdersList);
        //ordersMap.put("jd", jdOrdersList);
        //ordersMap.put("yz", tidsList);

        return ordersMap;

    }


    /**
     * 根据订单id查询出物流信息
     * @param sellerId
     * @param orderVO
     * @return
     */
    @Override
    public ExpressDetailVO findCommentExpressInfo(Long sellerId, Long userId, OrderVO orderVO) {

        AssertsUtil.notNull(orderVO,"orderVO");

        AssertsUtil.notNull(sellerId, "sellerId");

        AssertsUtil.notBlank(orderVO.getOrderFrom(), "OrderFrom");

        /**
         * 从有赞快递接口查询快递
         */
        if(DaoConstant.TradeSource.YZ.equals(orderVO.getOrderFrom())){

            SellerShop sellerShop = SellerConfigCache.getSellerShop(String.valueOf(sellerId),String.valueOf(orderVO.getShopId()));

           return youZanTradeService.queryYouZanLogisticsTrace(sellerShop, orderVO.getTradeId());

        }

        /**
         * 从京东快递接口查询快递
         */
       if(DaoConstant.Express.LOGISTICS_NAME_JD.equals(orderVO.getLogisticsCompany())){

           SellerShop sellerShop = SellerConfigCache.getSellerShop(String.valueOf(sellerId),String.valueOf(orderVO.getShopId()));

           return jdTradeService.queryEtmsTrace(sellerShop, orderVO.getInvoiceNo());

       }

        /**
         * 从易源接口查询快递
         */
        String companyCode = LstOfValCache.getLOV(TYPE, orderVO.getLogisticsCompany()).getValue();
        String key ="express_" + orderVO.getInvoiceNo()+"_" + companyCode;

        if(RedisCache.get(key) != null) {

           return (ExpressDetailVO)RedisCache.get(key);

        }

        ExpressDetailVO expressDetailVO = showApiAdapter.expressQuery(orderVO.getInvoiceNo(),companyCode);
        expressDetailVO.setExpressCompany(orderVO.getLogisticsCompany());

        List<TransitStepVO> transitStepVOList = expressDetailVO.getTransitStepVOs();//物流信息

        if(CollectionUtils.isEmpty(transitStepVOList)) {
            return null;
        }
        /**
         * 物流信息数据库流水记录
         */
        insertOrUpdateExpressInfo(expressDetailVO, sellerId, userId);

        RedisCache.put(key, expressDetailVO);
        RedisCache.expire(key, 3600L); //缓存时间
        return expressDetailVO;

    }

    /**
     * 插入或者更新express_info 表
     * @param expressDetailVO
     * @param userId
     */
    private void insertOrUpdateExpressInfo(ExpressDetailVO expressDetailVO, Long sellerId, Long userId) {
        List<TransitStepVO> transitStepVOList = expressDetailVO.getTransitStepVOs();//物流信息
        StringBuffer sb = new StringBuffer();

        for(TransitStepVO tv : transitStepVOList) {
            sb.append(tv.getStatusTime() + ":");
            sb.append(tv.getStatusDesc() + ",");
        }

        ExpressInfo expressInfo = new ExpressInfo();
        expressInfo.setContext(sb.toString());
        expressInfo.setUserId(userId);
        expressInfo.setExpCompany(expressDetailVO.getExpressCompany());
        expressInfo.setMailNo(expressDetailVO.getInvoiceNo());
        expressInfo.setStatus(expressDetailVO.getStatus());

        ExpressInfoExample infoExample = new ExpressInfoExample();
        infoExample.createCriteria().andMailNoEqualTo(expressDetailVO.getInvoiceNo());
        infoExample.createCriteria().andSellerIdEqualTo(sellerId);
        int count = expressInfoMapper.countByExample(infoExample);
        if(count > 0) {
            int result = expressInfoMapper.updateByExampleSelective(expressInfo, infoExample);
            if(result == 0) {
                throw new ServiceException("ExpressService.insertOrUpdateExpressInfo() express_info更新失败");
            }
        } else {
            expressInfoMapper.insertSelective(expressInfo);
        }
    }
    /**
     * 处理从易源API返回的结果
     * 针对淘宝的订单
     * @param map
     * @param orderTaoBao
     * @return
     */
    private Map<String, Object> HandleJsonResult(Map map, OrderTaoBao orderTaoBao) {
        Map<String, Object> mapInfo = new HashMap<String, Object>();
        List<ExpressJsonDO> jsonList = new ArrayList<ExpressJsonDO>();
        String resError = (String)map.get("resError");
        if(StringUtils.isEmpty(resError.trim())) { //如果没有错误信息
            mapInfo.put("mailNo", (String)map.get("mailNo"));//快递单号
            mapInfo.put("express_company", orderTaoBao.getLogisticsCompany());//快递公司

            //快递物流信息jsson解析成对象
            String resData = (String)map.get("resData");
            JSONArray jarr = JSONArray.parseArray(resData);

            for(Iterator iterator= jarr.iterator() ; iterator.hasNext();) {
                JSONObject job  = (JSONObject)iterator.next();
                ExpressJsonDO expressJsonDO = new ExpressJsonDO();
                expressJsonDO.setTime(job.get("time").toString());
                expressJsonDO.setContext(job.get("context").toString());
                jsonList.add(expressJsonDO);
            }
            mapInfo.put("stream",jsonList);
            return mapInfo;
        } else {
            mapInfo.put("mailNo",null);
            mapInfo.put("express_company",orderTaoBao.getLogisticsCompany());
            mapInfo.put("stream",null);
            return mapInfo;
        }
    }

    /**
     * 处理从易源API返回的结果
     * 针对京东订单
     * @param map
     * @param orderJD
     * @return
     */
    private Map<String, Object> HandleJsonResult(Map map, OrderJD orderJD) {
        Map<String, Object> mapInfo = new HashMap<String, Object>();
        List<ExpressJsonDO> jsonList = new ArrayList<ExpressJsonDO>();
        String resError = (String)map.get("resError");
        if(StringUtils.isEmpty(resError.trim())) { //如果没有错误信息
            mapInfo.put("mailNo", (String)map.get("mailNo"));//快递单号
            mapInfo.put("express_company", orderJD.getLogisticsName());//快递公司

            //快递物流信息jsson解析成对象
            String resData = (String)map.get("resData");
            JSONArray jarr = JSONArray.parseArray(resData);
            for(Iterator iterator= jarr.iterator() ; iterator.hasNext();) {
                JSONObject job  = (JSONObject)iterator.next();
                ExpressJsonDO expressJsonDO = new ExpressJsonDO();
                expressJsonDO.setTime(job.get("time").toString());
                expressJsonDO.setContext(job.get("context").toString());
                jsonList.add(expressJsonDO);
            }
            mapInfo.put("stream",jsonList);
            return mapInfo;

        } else {
            mapInfo.put("mailNo",null);
            mapInfo.put("express_company",orderJD.getLogisticsName());
            mapInfo.put("stream",null);
            return mapInfo;
        }
    }



    //处理从有赞物流的结果

    /**
     * 处理从易源API返回的结果
     * 针对有赞订单
     * @param trace
     * @return
     */
    private Map<String, Object> HandleJsonResult(LogisticsTraceYZVO trace) {
        Map<String, Object> mapInfo = new HashMap<String, Object>();
        Map<String, Object> expressInfoMap = new HashMap<String, Object>();
        List<TransitStepInfoJsonObj>  jsonList = new ArrayList<TransitStepInfoJsonObj>();

        List<TransitStepInfoVO> traceList = trace.getTraceList();
        String jsonArrayStr = JSON.toJSONString(traceList, true);

        JSONArray jarr = JSONArray.parseArray(jsonArrayStr);
        for(Iterator iterator= jarr.iterator() ; iterator.hasNext();) {
            JSONObject job  = (JSONObject)iterator.next();
            TransitStepInfoJsonObj tsijo = new TransitStepInfoJsonObj();

            tsijo.setStatus_desc(job.get("status_desc").toString());

            String statusTimeStr = DateUtil.parseCSTTime(job.get("status_time").toString());
            tsijo.setTime(statusTimeStr);

            jsonList.add(tsijo);

        }
        mapInfo.put("stream", jsonList);
        mapInfo.put("mailNo", trace.getOutSid());//快递单号
        mapInfo.put("express_company", trace.getCompanyName());//快递公司

        return mapInfo;
    }

    //处理CST的时间格式
    private String parseCSTTime(String cstTime) {
        SimpleDateFormat cstFormater = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date dt = null;
        String formatStr = "";
        try {
            Date gpsUTCDate = cstFormater.parse(cstTime);
            formatStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(gpsUTCDate);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatStr;
    }

}
