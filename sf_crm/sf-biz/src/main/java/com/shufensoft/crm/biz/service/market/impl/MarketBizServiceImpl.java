package com.shufensoft.crm.biz.service.market.impl;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.marketActivity.MarketRecordsMapper;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecords;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecordsExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.market.MarkBizService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/9/14 下午9:28  
 */
@Service
public class MarketBizServiceImpl implements MarkBizService {

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(MarketBizServiceImpl.class);


    @Autowired
    private MarketRecordsMapper marketRecordsMapper;




    /**
     * 更新营销明细状态
     *
     * @param activityId
     */
    @Transactional
    public void updateMarketRecords(Long sellerId, Long activityId, String mobile, String status) {
        MarketRecordsExample marketRecordsExample = new MarketRecordsExample();
        MarketRecordsExample.Criteria criteria = marketRecordsExample.createCriteria();
        criteria.andActivityIdEqualTo(activityId);

        criteria.andMobileEqualTo(mobile);
        criteria.andSellerIdEqualTo(sellerId);

        MarketRecords marketRecords = new MarketRecords();
        marketRecords.setIsSuccess(status);

        marketRecordsMapper.updateByExampleSelective(marketRecords, marketRecordsExample);

    }


    /**
     * 营销活动的邮件打开率
     *
     * @param sellerId   商户ID
     * @param type       类型
     * @param activityId 营销活动ID
     * @return
     */
    @Override
    public float sendEmailOpenRate(Long sellerId, String type, Long activityId) {
        int count = sendCount(sellerId, type, activityId);

        int openNum = sendSucOrOpenNum(sellerId, "email", DaoConstant.MarketSendStatus.ISOPEND, activityId);

        BigDecimal sucRate = null;
        try {
            BigDecimal b1 = new BigDecimal(String.valueOf(count));
            BigDecimal b2 = new BigDecimal(String.valueOf(openNum));
            if (b2.compareTo(new BigDecimal("0")) == 1) {
                sucRate = b2.divide(b1, 2, RoundingMode.HALF_DOWN);
            } else {
                sucRate = new BigDecimal("0");
            }

        } catch (Exception e) {
            logger.error("sendSucRate is error.");
        }

        return sucRate.floatValue() * 100;
    }

    /**
     * 商户邮件总打开率
     *
     * @param sellerId 商户ID
     * @param type     类型
     * @return
     */
    @Transactional
    public float sendEmailOpenRate(Long sellerId, String type) {
        int count = sendCount(sellerId, type);

        int openNum = sendSucOrOpenNum(sellerId, "email", DaoConstant.MarketSendStatus.ISOPEND, null);

        BigDecimal sucRate = null;
        try {
            BigDecimal b1 = new BigDecimal(String.valueOf(count));
            BigDecimal b2 = new BigDecimal(String.valueOf(openNum));
            if (b2.compareTo(new BigDecimal("0")) == 1) {
                sucRate = b2.divide(b1, 2, RoundingMode.HALF_DOWN);
            } else {
                sucRate = new BigDecimal("0");
            }

        } catch (Exception e) {
            logger.error("sendSucRate is error.");
        }

        return sucRate.floatValue();
    }


    /**
     * 营销活动发送成功率
     *
     * @param sellerId   商户ID
     * @param type       发送类型
     * @param activityId 营销ID
     * @return
     */
    public float sendSucRate(Long sellerId, String type, Long activityId) {

        int count = sendCount(sellerId, type, activityId);

        int suc = sendSucOrOpenNum(sellerId, type, DaoConstant.MarketSendStatus.SUCCESS, activityId);
        BigDecimal sucRate = null;
        try {
            BigDecimal b1 = new BigDecimal(String.valueOf(count));
            BigDecimal b2 = new BigDecimal(String.valueOf(suc));
            if (b2.compareTo(new BigDecimal("0")) == 1) {
                sucRate = b2.divide(b1, 2, RoundingMode.HALF_DOWN);
            } else {
                sucRate = new BigDecimal("0");
            }

        } catch (Exception e) {
            logger.error("sendSucRate is error.");
        }

        return sucRate.floatValue() * 100;
    }

    /**
     * 商户发送总成功率
     *
     * @param sellerId 商户ID
     * @param type     发送类型
     * @return
     */
    public float sendSucRate(Long sellerId, String type) {

        return sendSucRate(sellerId, type, null);
    }


    public int sendSucOrOpenNum(Long sellerId, String type, String status, Long activityId) {
        MarketRecordsExample marketRecordsExample = new MarketRecordsExample();
        MarketRecordsExample.Criteria criteria = marketRecordsExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andIsSuccessEqualTo(status);
        if (activityId != null) {
            criteria.andActivityIdEqualTo(activityId);
        }

        if ("sms".equals(type)) {
            criteria.andTypeEqualTo("sms");
        } else if ("email".equals(type)) {
            criteria.andTypeEqualTo("email");
        } else {
            throw new ServiceException("type is invalid.");
        }

        int sucNum = 0;
        List<MarketRecords> marketRecordsList = marketRecordsMapper.selectByExample(marketRecordsExample);
        if (marketRecordsList != null && !marketRecordsList.isEmpty()) {
            sucNum = marketRecordsList.size();
        } else {
            sucNum = 0;
        }

        return sucNum;

    }


    /**
     * 营销活动的发送总数
     *
     * @param sellerId   商户ID
     * @param type       邮件、短信
     * @param activityId 营销活动ID
     * @return
     */
    public int sendCount(Long sellerId, String type, Long activityId) {
        MarketRecordsExample marketRecordsExample = new MarketRecordsExample();
        MarketRecordsExample.Criteria criteria = marketRecordsExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        if (activityId != null) {
            criteria.andActivityIdEqualTo(activityId);
        }

        if ("sms".equals(type)) {
            criteria.andTypeEqualTo("sms");
        } else if ("email".equals(type)) {
            criteria.andTypeEqualTo("email");
        } else {
            throw new ServiceException("type is invalid.");
        }
        int sucNum = 0;
        List<MarketRecords> marketRecordsList = marketRecordsMapper.selectByExample(marketRecordsExample);
        if (marketRecordsList != null && !marketRecordsList.isEmpty()) {
            sucNum = marketRecordsList.size();
        } else {
            sucNum = 0;
        }

        return sucNum;

    }

    /**
     * 商户的发送总数
     *
     * @param sellerId 商户ID
     * @param type     短信、邮件
     * @return
     */
    public int sendCount(Long sellerId, String type) {
        return sendCount(sellerId, type, null);

    }





    /**
     * 处理邮件内容
     *
     * @param content
     * @return
     */
    public String handleMailContent(String content) {

        ResourceBundle bundle = PropertyResourceBundle.getBundle("config");
        String webUrl = bundle.getString("crm.web.url");
        String url[] = webUrl.split("/");

        String name = "/" + url[3];

        return content.replaceAll(name, webUrl) + "<a href=\"[UNSUBSCRIBE_URL]\">取消订阅</a>";

    }


    /**
     * 更新营销明细状态
     *
     * @param activityId
     */
    public void updateMailMarketRecords(Long sellerId, Long activityId, String email, String type, String status) {
        MarketRecordsExample marketRecordsExample = new MarketRecordsExample();
        MarketRecordsExample.Criteria criteria = marketRecordsExample.createCriteria();
        criteria.andActivityIdEqualTo(activityId);

        criteria.andEmailEqualTo(email);
        criteria.andSellerIdEqualTo(sellerId);

        MarketRecords marketRecords = new MarketRecords();
        if (DaoConstant.MarketStatusType.ISSUCCESS.equals(type)) {
            marketRecords.setIsSuccess(status);
        } else if (DaoConstant.MarketStatusType.ISOPEN.equals(type)) {
            marketRecords.setIsOpen(status);
        } else {
            throw new ServiceException("type is error.");
        }


        marketRecordsMapper.updateByExampleSelective(marketRecords, marketRecordsExample);

    }
}
