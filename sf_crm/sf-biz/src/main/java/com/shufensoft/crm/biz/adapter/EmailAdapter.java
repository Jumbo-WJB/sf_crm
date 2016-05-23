package com.shufensoft.crm.biz.adapter;

import com.reasonablespread.service.*;
import com.shufensoft.crm.biz.domain.generation.email.CampaignOpens;
import com.shufensoft.crm.biz.domain.generation.email.CampaignSentstInfo;
import com.shufensoft.crm.biz.domain.generation.email.SubscribersErrorInfo;
import com.shufensoft.crm.biz.domain.generation.email.SubscribersReslutInfo;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.common.email.EmailClient;
import org.apache.axis.message.MessageElement;
import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by apple on 15/6/16.
 */
public class EmailAdapter {
    private static Logger logger = Logger.getLogger(EmailAdapter.class);

    public static int createCampaign(Campaign campaignar, String category, int interval) {
        List<String> categoryList = new ArrayList<String>();
        categoryList.add(category);
        return createCampaign(campaignar, categoryList, interval);
    }

    public static int createCampaign(Campaign campaignArgs, List<String> category, int interval) {

        int code = -1;
        String[] categoryArgs = (String[])category.toArray(new String[category.size()]);
        //String[] categoryArgs = new String[category.size()];


        try {
            return EmailClient.createCampaign(campaignArgs, categoryArgs, -1);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return code;
    }

    /**
     * 创建联系任务列表
     *
     * @param subscriptionName 列表名称
     * @param description      描述
     * @return 0：成功，-1：失败
     */
    public static String createSubscription(String subscriptionName, String description) {

        String resultCode = "-1";
        try {
            Boolean reBoolean = EmailClient.createSubscription(subscriptionName, description);
            if (true == reBoolean) {
                resultCode = "0";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return resultCode;
    }


    /**
     * 获取邮件回弹邮件
     * @param campaignId 邮件活动ID
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<CampaignSentstInfo> getCampaignBounces(int campaignId, Date startDate, Date endDate){
        List<CampaignSentstInfo> campaignSentstInfoList = new ArrayList<CampaignSentstInfo>();
        try{
            GetCampaignSentsResponseGetCampaignSentsResult result = EmailClient.getCampaignBounces(campaignId,startDate,endDate);

            if (result !=null){
                MessageElement[] messageElement = result.get_any();
                MessageElement element = messageElement[1];
                if (element != null) {
                    xmlResolve(element,campaignSentstInfoList);
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);

        }
        return campaignSentstInfoList;
    }

    /**
     * 获取邮件发送状态信息
     * @param campaignId 邮件活动ID
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<CampaignSentstInfo> getCampaignSents(int campaignId, Date startDate, Date endDate) {

        List<CampaignSentstInfo> campaignSentstInfoList = new ArrayList<CampaignSentstInfo>();
        try {
            GetCampaignSentsResponseGetCampaignSentsResult result = EmailClient.getCampaignSents(campaignId, startDate, endDate);

            if (result != null) {
                MessageElement[] messageElement = result.get_any();
                MessageElement element = messageElement[1];
                if (element != null) {
                    xmlResolve(element,campaignSentstInfoList);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return campaignSentstInfoList;
    }

    public static List<CampaignOpens> getCampaignOpens(int campaignId, Date startDate, Date endDate){

        List<CampaignOpens> campaignOpenses = new ArrayList<CampaignOpens>();
        try {
            GetCampaignOpensResponseGetCampaignOpensResult campaignOpensResults = EmailClient.getCampaignOpens(campaignId,startDate,endDate);

            if (campaignOpensResults !=null){
                MessageElement[] messageElement = campaignOpensResults.get_any();
                MessageElement element = messageElement[1];
                if (element != null) {
                    campaignOpensXmlResolve(element, campaignOpenses);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return campaignOpenses;

    }


    private static void xmlResolve(MessageElement element,List<CampaignSentstInfo> campaignSentstInfoList){
        NodeList nodeList = element.getElementsByTagName("Table");
        if (nodeList != null && 0 != nodeList.getLength()) {
            int nodeSize = nodeList.getLength();

            for (int i = 0; i < nodeSize; i++) {
                CampaignSentstInfo campaignSentstInfo = new CampaignSentstInfo();
                Node node = nodeList.item(i);

                NodeList nodeChildList = node.getChildNodes();
                if (nodeChildList != null && 0 != nodeChildList.getLength()) {
                    for (int j=0;j<nodeChildList.getLength();j++){
                        Node nodeInfo = nodeChildList.item(j);
                        if (nodeInfo.getNodeType() == Node.ELEMENT_NODE) {
                            if (nodeInfo.hasChildNodes()) {
                                String nodeName = nodeInfo.getNodeName();
                                String value = nodeInfo.getFirstChild().getNodeValue();
                                if ("subscriber_email".equals(nodeName)){
                                    campaignSentstInfo.setSubscriber_email(value);
                                }else if("isSuccess".equals(nodeName)){
                                    campaignSentstInfo.setIsSuccess(value);
                                }else if ("sending_status_time".equals(nodeName)){
                                    campaignSentstInfo.setSending_status_time(value);
                                }else{
                                    //
                                }
                            }
                        }
                    }

                }
                campaignSentstInfoList.add(campaignSentstInfo);

            }

        }
    }


    private static void campaignOpensXmlResolve(MessageElement element,List<CampaignOpens> CampaignOpensList){
        NodeList nodeList = element.getElementsByTagName("Table");
        if (nodeList != null && 0 != nodeList.getLength()) {
            int nodeSize = nodeList.getLength();

            for (int i = 0; i < nodeSize; i++) {
                CampaignOpens campaignOpens = new CampaignOpens();
                Node node = nodeList.item(i);

                NodeList nodeChildList = node.getChildNodes();
                if (nodeChildList != null && 0 != nodeChildList.getLength()) {
                    for (int j=0;j<nodeChildList.getLength();j++){
                        Node nodeInfo = nodeChildList.item(j);
                        if (nodeInfo.getNodeType() == Node.ELEMENT_NODE) {
                            if (nodeInfo.hasChildNodes()) {
                                String nodeName = nodeInfo.getNodeName();
                                String value = nodeInfo.getFirstChild().getNodeValue();
                                if ("subscriber_email".equals(nodeName)){
                                    campaignOpens.setSubscriber_email(value);
                                }else if("email_opening_time".equals(nodeName)){
                                    campaignOpens.setEmail_opening_time(value);
                                }else{
                                    //
                                }
                            }
                        }
                    }

                }
                CampaignOpensList.add(campaignOpens);

            }

        }
    }

    /**
     * 将邮件地址添加到联系人列表中
     *
     * @param subscriberList   邮件地址
     * @param subscriptionName 列表名称
     * @param doubleOptIn      on/off
     * @return
     */
    public static SubscribersReslutInfo addSubscribersByInfo(List<Subscriber> subscriberList, String subscriptionName, DoubleOptIn doubleOptIn) {

        SubscribersReslutInfo subscribersReslutInfo = new SubscribersReslutInfo();
        List<SubscribersErrorInfo> subscribersErrorInfoList = new ArrayList<SubscribersErrorInfo>();
        try {
            if (subscriberList != null && !subscriberList.isEmpty()) {

                Subscriber[] subscriberArgs = new Subscriber[subscriberList.size()];

                subscriberList.toArray(subscriberArgs);


                AddSubscribersByInfoResponseAddSubscribersByInfoResult result = EmailClient.addSubscribersByInfo(subscriberArgs, subscriptionName, doubleOptIn);
                if (result != null) {
                    MessageElement[] messageElement = result.get_any();
                    MessageElement element = messageElement[1];
                    if (element != null) {
                        NodeList nodeList = element.getElementsByTagName("Table1");
                        if (nodeList != null && 0 != nodeList.getLength()) {
                            int nodeSize = nodeList.getLength();
                            for (int i = 0; i < nodeSize; i++) {
                                Node node = nodeList.item(i);
                                SubscribersErrorInfo subscribersErrorInfo = new SubscribersErrorInfo();
                                Node nodeChild = node.getFirstChild();

                                subscribersErrorInfo.setEmail(nodeChild.getNodeValue());
                                nodeChild = node.getLastChild();
                                subscribersErrorInfo.setError(nodeChild.getNodeValue());

                                subscribersErrorInfoList.add(subscribersErrorInfo);
                            }
                            subscribersReslutInfo.setCode("-1");
                            subscribersReslutInfo.setSubscribersErrorInfoList(subscribersErrorInfoList);
                        } else {
                            subscribersReslutInfo.setCode("0");
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage());
        }

        return subscribersReslutInfo;

    }
}


