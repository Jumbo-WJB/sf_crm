package com.shufensoft.crm.common.email;

import com.reasonablespread.service.*;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/4/19 14:05  
 *  @modifier litu  litu@shufensoft.com 2015/5/22 14:05
 *  
 */

public class EmailClient {


    private static final Logger logger =  Logger.getLogger(EmailClient.class);

    public static ServiceSoapProxy proxy = new ServiceSoapProxy();


    public static String loginEmail = "johnsoncqq@163.com";

    public static String password = "ab123456";


    /**
     *
     * @param campaignArgs 邮件计划内容
     * @param category 联系人列表
     * @param interval
     * @return
     * @throws Exception
     */
    public static int createCampaign(Campaign campaignArgs, String[] category, int interval) throws Exception {

        try{
            return proxy.createCampaign(loginEmail,password,campaignArgs,category,interval);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new Exception(e.getMessage());
        }
    }

    public static void GetCampaignSents(){
        try{
            Calendar cal3 = Calendar.getInstance();
            cal3.add(cal3.DATE, -1);

            GetCampaignSentsResponseGetCampaignSentsResult result = proxy.getCampaignSents("johnsoncqq@163.com", "ab123456", 114146, cal3,Calendar.getInstance());
            result.toString();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     *
     * 添加联系人到指定列表中
     * @param subscriberArgs  联系人信息
     * @param subscriptionName  列表名称
     * @param doubleOptIn  on,off
     * @return
     */
    public static AddSubscribersByInfoResponseAddSubscribersByInfoResult addSubscribersByInfo(Subscriber[] subscriberArgs, String subscriptionName,DoubleOptIn doubleOptIn) throws Exception {

        //boolean b = proxy.createSubscription("johnsoncqq@163.com","ab123456","008","test008");

        try{
            AddSubscribersByInfoResponseAddSubscribersByInfoResult result = proxy.addSubscribersByInfo(loginEmail, password, subscriberArgs, subscriptionName, doubleOptIn);
            if (result != null){

                return result;
            }
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new Exception(e.getMessage());
        }

        return null;
    }

    /**
     * 创建联系人列表
     * @param subscriptionName 列表名称
     * @param description 描述
     * @return true/false
     * @throws Exception
     */
    public static boolean createSubscription(String subscriptionName,String description) throws Exception {
        try{
            return proxy.createSubscription(loginEmail,password,subscriptionName,description);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new Exception(e.getMessage());
        }
    }


    /**
     * 获取被退回的邮件
     * @param campaignId 邮件活动ID
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public static GetCampaignSentsResponseGetCampaignSentsResult getCampaignBounces(int campaignId, Date startDate,Date endDate) throws Exception {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        try{
            return  proxy.getCampaignSents(loginEmail, password, campaignId,startCalendar, endCalendar);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 获取发送记录
     * @param campaignId
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public static GetCampaignSentsResponseGetCampaignSentsResult getCampaignSents(int campaignId,Date startDate,Date endDate) throws Exception {

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        try{
            return  proxy.getCampaignSents(loginEmail, password, campaignId,startCalendar, endCalendar);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new Exception(e.getMessage());
        }

    }

    /**
     * 获取是否打开的报告
     * @param campaignId
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public static GetCampaignOpensResponseGetCampaignOpensResult getCampaignOpens(int campaignId,Date startDate,Date endDate) throws Exception {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        try{
            return proxy.getCampaignOpens(loginEmail,password,campaignId,startCalendar,endCalendar);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new Exception(e.getMessage());
        }

    }

    public static void main(String[] args){

        Date date1 = null;
        Date date2 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1  = simpleDateFormat.parse("2015-06-15");
            date2  = simpleDateFormat.parse("2015-06-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            //EmailClient.getCampaignSents(114190,date1,date2);
            //GetCampaignSentsResponseGetCampaignSentsResult g = EmailClient.getCampaignBounces(114190,date1,date2);
            GetCampaignOpensResponseGetCampaignOpensResult g = EmailClient.getCampaignOpens(114961,date1,date2);
            g.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
