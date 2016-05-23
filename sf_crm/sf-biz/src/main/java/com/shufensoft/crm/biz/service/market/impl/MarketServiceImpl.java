package com.shufensoft.crm.biz.service.market.impl;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.constant.SmsConstant;
import com.shufensoft.crm.biz.dao.generation.marketActivity.MarketActivityMapper;
import com.shufensoft.crm.biz.dao.generation.marketActivity.MarketRecordsMapper;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketActivity;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketActivityExample;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecords;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecordsExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.market.MarketService;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.biz.service.send.vo.SmsVO;
import com.shufensoft.crm.biz.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/8/12 下午9:22  
 */
@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketActivityMapper marketActivityMapper;

    @Autowired
    private MarketRecordsMapper marketRecordsMapper;

    @Autowired
    private SendService sendService;

    @Autowired
    private UserService userService;


    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(MarketServiceImpl.class);


    /**
     * 发送待发送状态下的短信
     */
    public void marketActivitySendEmail(Long sellerId) {

        List<MarketActivity> marketActivityList = getToSendMarketActivity(sellerId, "email");

        if (marketActivityList != null && !marketActivityList.isEmpty()) {
            for (MarketActivity marketActivity : marketActivityList) {
                SmsVO smsVO = new SmsVO();
                smsVO.setSellerId(String.valueOf(sellerId));
                smsVO.setSaleType(marketActivity.getTarget());

                smsVO.setSaleTitle(marketActivity.getTitle());
                smsVO.setSendType("MAIL");
                smsVO.setSendTime(marketActivity.getExecuteTime());
                smsVO.setContent(marketActivity.getContent());
                smsVO.setSubject(marketActivity.getTitle());

                SellerConfigInfo sellerConfig = SellerConfigCache.get(String.valueOf(sellerId));

                smsVO.setSign(sellerConfig.getEmailSign());
                smsVO.setFrom(sellerConfig.getEmail());
                smsVO.setFromName(sellerConfig.getEmailFromName());
                smsVO.setActivityId(marketActivity.getActivityId());


                List<String> targetNumberList = new ArrayList<String>();
                List<MarketRecords> marketRecordsList = getToSendMarketRecords(sellerId, marketActivity.getActivityId());
                if (marketRecordsList != null && !marketRecordsList.isEmpty()) {
                    for (MarketRecords marketRecords : marketRecordsList) {
                        targetNumberList.add(marketRecords.getMobile());
                    }
                    smsVO.setTargetNumberList(targetNumberList);
                }


                try {
                    String code = sendService.smsSend(smsVO);

                    if (!SmsConstant.SEND_FAILED_CODE.equals(code)) {

                        if (SmsConstant.ACCOUNT_ARREARS_CODE.equals(code)) {

                            updateMarketActivity(sellerId, marketActivity.getActivityId(), DaoConstant.MarketSendStatus.ACCOUNT_ARREARS);

                            updateMarrketRecords(sellerId, marketActivity.getActivityId(), "MAIL", DaoConstant.MarketSendStatus.ACCOUNT_ARREARS);
                        } else {
                            updateMarketActivity(sellerId, marketActivity.getActivityId(), DaoConstant.MarketSendStatus.SUCCESS);

                            updateMarrketRecords(sellerId, marketActivity.getActivityId(), "MAIL", DaoConstant.MarketSendStatus.SUCCESS);
                        }
                    } else {
                        updateMarketActivity(sellerId, marketActivity.getActivityId(), DaoConstant.MarketSendStatus.FAILED);

                        updateMarrketRecords(sellerId, marketActivity.getActivityId(), "MAIL", DaoConstant.MarketSendStatus.FAILED);
                    }


                } catch (Exception e) {

                    updateMarketActivity(sellerId, marketActivity.getActivityId(), DaoConstant.MarketSendStatus.FAILED);


                    updateMarrketRecords(sellerId, marketActivity.getActivityId(), "MAIL", DaoConstant.MarketSendStatus.FAILED);
                    logger.error("MarketActivitySerivce marketActivitySendSms is error.", e);
                }
            }
        }

    }

    /**
     * 发送待发送状态下的短信
     */
    public void marketActivitySendSms(Long sellerId) {

        List<MarketActivity> marketActivityList = getToSendMarketActivity(sellerId, "sms");

        if (marketActivityList != null && !marketActivityList.isEmpty()) {
            for (MarketActivity marketActivity : marketActivityList) {
                SmsVO smsVO = new SmsVO();
                smsVO.setSaleTitle(marketActivity.getTitle());
                smsVO.setSaleType(marketActivity.getTarget());
                smsVO.setContent(marketActivity.getContent());
                smsVO.setSendType("SMS");
                smsVO.setPassage(DaoConstant.SmsSend.SEND_SALE);

                smsVO.setSign(SellerConfigCache.get(String.valueOf(sellerId)).getSmsSaleSign());
                smsVO.setSellerId(String.valueOf(sellerId));
                smsVO.setActivityId(marketActivity.getActivityId());
                smsVO.setFatigue(DaoConstant.SmsFatigueFlag.IS_FATIGUE);

                List<String> targetNumberList = new ArrayList<String>();
                List<MarketRecords> marketRecordsList = getToSendMarketRecords(sellerId, marketActivity.getActivityId());
                if (marketRecordsList != null && !marketRecordsList.isEmpty()) {
                    for (MarketRecords marketRecords : marketRecordsList) {
                        targetNumberList.add(marketRecords.getMobile());
                    }
                    smsVO.setTargetNumberList(targetNumberList);
                }


                try {
                    String code = sendService.smsSend(smsVO);

                    if (!SmsConstant.SEND_FAILED_CODE.equals(code)) {


                        if (SmsConstant.ACCOUNT_ARREARS_CODE.equals(code)) {

                            updateMarketActivity(sellerId, marketActivity.getActivityId(), DaoConstant.MarketSendStatus.ACCOUNT_ARREARS);

                            updateMarrketRecords(sellerId, marketActivity.getActivityId(), "SMS", DaoConstant.MarketSendStatus.ACCOUNT_ARREARS);

                        } else {
                            updateMarketActivity(sellerId, marketActivity.getActivityId(), DaoConstant.MarketSendStatus.SUCCESS);

                            updateMarrketRecords(sellerId, marketActivity.getActivityId(), "SMS", DaoConstant.MarketSendStatus.SUCCESS);
                        }

                    } else {
                        updateMarketActivity(sellerId, marketActivity.getActivityId(), DaoConstant.MarketSendStatus.FAILED);

                        updateMarrketRecords(sellerId, marketActivity.getActivityId(), "SMS", DaoConstant.MarketSendStatus.FAILED);
                    }
                } catch (Exception e) {

                    updateMarketActivity(sellerId, marketActivity.getActivityId(), DaoConstant.MarketSendStatus.FAILED);

                    updateMarrketRecords(sellerId, marketActivity.getActivityId(), "SMS", DaoConstant.MarketSendStatus.FAILED);
                    logger.error("MarketActivitySerivce marketActivitySendSms is error.", e);
                }
            }
        }

    }


    /**
     * 更新营销表的状态。
     *
     * @param activityId
     * @param status
     */

    public void updateMarketActivity(Long sellerId, Long activityId, String status) {
        MarketActivityExample marketActivityExample = new MarketActivityExample();
        marketActivityExample.createCriteria().andActivityIdEqualTo(activityId).andSellerIdEqualTo(sellerId);

        MarketActivity marketActivity = new MarketActivity();
        marketActivity.setStatus(status);

        marketActivityMapper.updateByExampleSelective(marketActivity, marketActivityExample);

    }


    public void updateMarrketRecords(Long sellerId, Long activityId, String type, String status) {
        MarketRecordsExample recordsExample = new MarketRecordsExample();
        MarketRecordsExample.Criteria criteria = recordsExample.createCriteria();
        criteria.andActivityIdEqualTo(activityId);
        criteria.andSellerIdEqualTo(sellerId);

        List<MarketRecords> marketRecordsList = marketRecordsMapper.selectByExample(recordsExample);

        if (marketRecordsList != null && !marketRecordsList.isEmpty()) {
            for (MarketRecords marketRecords : marketRecordsList) {
                //if ("1".equals(status)) {
                marketRecords.setIsSuccess(status);
                marketRecordsMapper.updateByExampleSelective(marketRecords, recordsExample);

                if (DaoConstant.MarketSendStatus.SUCCESS.equals(status)) {
                    userService.updateUserPortrait(sellerId, marketRecords.getUserId(), type);

                }

            }
        }

    }


    /**
     * 查询定时发送的营销
     *
     * @param type
     * @return
     */
    public List<MarketActivity> getToSendMarketActivity(Long sellerId, String type) {
        MarketActivityExample marketActivityExample = new MarketActivityExample();
        MarketActivityExample.Criteria criteria = marketActivityExample.createCriteria();
        criteria.andExecuteTypeEqualTo("1");
        criteria.andExecuteTimeLessThanOrEqualTo(new Date());
        criteria.andTypeEqualTo(type);
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andStatusEqualTo(DaoConstant.MarketSendStatus.TOSEND);

        return marketActivityMapper.selectByExample(marketActivityExample);
    }


    /**
     * 根据activityId查询待发送的营销明细
     *
     * @param activityId 营销ID
     * @return
     */
    private List<MarketRecords> getToSendMarketRecords(Long sellerId, Long activityId) {
        MarketRecordsExample marketRecordsExample = new MarketRecordsExample();
        marketRecordsExample.createCriteria().andActivityIdEqualTo(activityId).andSellerIdEqualTo(sellerId);

        return marketRecordsMapper.selectByExample(marketRecordsExample);
    }


}
