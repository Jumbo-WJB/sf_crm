package com.shufensoft.crm.biz.service.user;

import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverTaoBao;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserTaoBao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  @ProjectName: sf-crm
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-09 17:46  
 */
@Service
public class OnePersonCalculator {

    /**
     * 计算淘宝用户，微信用户为同一人的概率
     *
     * @param user
     * @param taobaoUser
     * @return
     */
    public double calTaobaoWx(User user, UserTaoBao taobaoUser, List<ReceiverTaoBao> taobaoReceivers) {
        List<Double> listProbability = new ArrayList<Double>();

        double probability = calTbBuyerNickWxNick(taobaoUser.getBuyerNick(), user.getWxNickName());
        listProbability.add(probability);
        probability = calTbAlipayAccountWxMobile(taobaoUser.getBuyerAlipayNo(), user.getMobile());
        listProbability.add(probability);

        for(ReceiverTaoBao taobaoReceiver : taobaoReceivers) {
            probability = calTbReceiverMobileWxMobile(taobaoReceiver.getReceiverMobile(), user.getMobile());
            listProbability.add(probability);
            probability = calTbReceiverNameWxNick(taobaoReceiver.getReceiverName(), user.getWxNickName());
            listProbability.add(probability);
            probability = calTbReceiverCityWxCity(taobaoReceiver.getReceiverCity(), user.getCity());
            listProbability.add(probability);
        }

        double result = cal(listProbability);

        return result;
    }

    /**
     * 同人概率的计算项：淘宝买家昵称，微信昵称
     *
     * @param tbBuyerNick 淘宝买家昵称
     * @param wxNick 微信昵称
     * @return 同人概率
     */
    private double calTbBuyerNickWxNick(String tbBuyerNick, String wxNick) {
        if(tbBuyerNick == null || wxNick == null) {
            return 0d;
        }

        if(tbBuyerNick.equals(wxNick)) {
            return 0.2d;
        }

        return 0d;
    }

    /**
     * 同人概率的计算项：收件人手机号，微信手机号
     *
     * @param tbReceiverMobile 淘宝收件人手机号
     * @param wxMobile 微信手机号
     * @return 同人概率
     */
    private double calTbReceiverMobileWxMobile(String tbReceiverMobile, String wxMobile) {
        if(tbReceiverMobile == null || wxMobile == null) {
            return 0d;
        }

        if(tbReceiverMobile.equals(wxMobile)) {
            return 0.9d;
        }

        return 0d;
    }

    /**
     * 同人概率的计算项：淘宝支付宝账号，微信手机号
     *
     * @param tbAlipayAccount 支付宝账号
     * @param wxMobile 微信手机号
     * @return 同人概率
     */
    private double calTbAlipayAccountWxMobile(String tbAlipayAccount, String wxMobile) {
        if(tbAlipayAccount == null || wxMobile == null) {
            return 0d;
        }

        if(tbAlipayAccount.equals(wxMobile)) {
            return 0.99d;
        }

        return 0d;
    }

    /**
     * 同人概率的计算项：淘宝收件人姓名，微信昵称
     *
     * @param tbReceiverName 淘宝收件人姓名
     * @param wxNick 微信昵称
     * @return 同人概率
     */
    private double calTbReceiverNameWxNick(String tbReceiverName, String wxNick) {
        if(tbReceiverName == null || wxNick == null) {
            return 0d;
        }

        if(tbReceiverName.equals(wxNick)) {
            return 0.5d;
        }

        return 0d;
    }

    /**
     * 同人概率的计算项：淘宝收件人城市，微信城市
     *
     * @param tbReceiverCity 淘宝收件人城市
     * @param wxCity 微信城市
     * @return 同人概率
     */
    private double calTbReceiverCityWxCity(String tbReceiverCity, String wxCity) {
        if(tbReceiverCity == null || wxCity == null) {
            return 0d;
        }

        if(tbReceiverCity.equals(wxCity)) {
            return 0.001d;
        }

        return 0d;
    }

    /**
     * 计算同人概率
     *
     * @param probabilities 计算项概率数组
     * @return 同人概率
     */
    private double cal(List<Double> probabilities) {
        double tmp = 1d;
        for(double probability : probabilities) {
            tmp = tmp * (1 - probability);
        }

        return 1 - tmp;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setCity("杭州市");
        user.setMobile("15867165117");
        user.setWxNickName("陈强");
        UserTaoBao taobaoUser = new UserTaoBao();
        taobaoUser.setBuyerAlipayNo("zxkl_hot@hotmail.com");
        taobaoUser.setBuyerNick("johnsoncqq");
        List<ReceiverTaoBao> taobaoReceivers = new ArrayList<ReceiverTaoBao>();
        ReceiverTaoBao receiverTaoBao = new ReceiverTaoBao();
        receiverTaoBao.setReceiverMobile("15867165117");
        receiverTaoBao.setReceiverCity("杭州市");
        receiverTaoBao.setReceiverName("陈强");
        taobaoReceivers.add(receiverTaoBao);
        OnePersonCalculator calculator = new OnePersonCalculator();
        double probability = calculator.calTaobaoWx(user, taobaoUser, taobaoReceivers);
        System.out.println("probability: " + probability);

    }

}
