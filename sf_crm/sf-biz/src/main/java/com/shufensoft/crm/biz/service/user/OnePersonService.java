package com.shufensoft.crm.biz.service.user;

import com.shufensoft.crm.biz.dao.generation.receiver.ReceiverTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserTaoBaoMapper;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverTaoBao;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverTaoBaoExample;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserExample;
import com.shufensoft.crm.biz.domain.generation.user.UserTaoBao;
import com.shufensoft.crm.biz.domain.generation.user.UserTaoBaoExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  @ProjectName: sf-crm
 *  @Description: 同人模型服务类
 *  @author chenqiang chenqiang@shufensoft.com
 *  @date 2015/5/7 13:15  
 */
@Service
public class OnePersonService {

    /**
     * 同人概率边界
     */
    private static final Double PROBABILITY = 0.95d;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserTaoBaoMapper userTaoBaoMapper;

    @Autowired
    ReceiverTaoBaoMapper receiverTaoBaoMapper;

    @Autowired
    OnePersonCalculator onePersonCalculator;

    /**
     * 计算微信用户与淘宝用户为同一人的概率
     *
     * @param sellerId 商家ID
     * @param userId 微信用户ID
     * @param tbUserId 淘宝用户ID
     * @return 是否为同人
     */
    public Boolean isOnePersonWxTb(long sellerId, long userId, long tbUserId) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId).andSellerIdEqualTo(sellerId);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.size() != 1) {
            return Boolean.FALSE;
        }

        User user = users.get(0);

        UserTaoBaoExample userTaoBaoExample = new UserTaoBaoExample();
        userTaoBaoExample.createCriteria().andUserIdTbEqualTo(tbUserId);
        List<UserTaoBao> taobaoUsers = userTaoBaoMapper.selectByExample(userTaoBaoExample);
        if(taobaoUsers == null || taobaoUsers.size() != 1) {
            return Boolean.FALSE;
        }

        UserTaoBao taobaoUser = taobaoUsers.get(0);

        ReceiverTaoBaoExample receiverTaoBaoExample = new ReceiverTaoBaoExample();
        receiverTaoBaoExample.createCriteria().andUserIdTbEqualTo(taobaoUser.getUserIdTb());
        List<ReceiverTaoBao> taobaoReceivers = receiverTaoBaoMapper.selectByExample(receiverTaoBaoExample);
        if(CollectionUtils.isEmpty(taobaoReceivers)) {
            return Boolean.FALSE;
        }

        double probability = onePersonCalculator.calTaobaoWx(user, taobaoUser, taobaoReceivers);
        if(probability >= PROBABILITY) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public Boolean isOnePersonWxJd(long sellerId, long userId, long jdUserId) {

        return Boolean.FALSE;
    }

    /**
     * 判断user表中的用户，是否有淘宝表中的用户为同一人
     *
     * @param sellerId
     * @param openid
     * @return
     */
    public Boolean hasOnePerson(long sellerId, String openid) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andWxOpenidEqualTo(openid).andSellerIdEqualTo(sellerId);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.size() != 1) {
            return Boolean.FALSE;
        }

        User user = users.get(0);
        if(user == null || StringUtils.isEmpty(user.getMobile())) {
            return Boolean.FALSE;
        }

        // 找淘宝收件人中是否有相同手机号的人
        ReceiverTaoBaoExample receiverTaoBaoExample = new ReceiverTaoBaoExample();
        receiverTaoBaoExample.createCriteria().andReceiverMobileEqualTo(user.getMobile());
        List<ReceiverTaoBao> taobaoReceivers = receiverTaoBaoMapper.selectByExample(receiverTaoBaoExample);
        if(CollectionUtils.isEmpty(taobaoReceivers)) {
            return Boolean.FALSE;
        }

        for(ReceiverTaoBao taobaoReceiver : taobaoReceivers) {
            Boolean isOnePerson = isOnePersonWxTb(sellerId, user.getUserId(), taobaoReceiver.getUserIdTb());

            if(isOnePerson) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    /**
     * 找到与user表中的用户为同一人的淘宝收件人表中的用户
     *
     * @param sellerId
     * @param userId
     * @return
     */
    public ReceiverTaoBao getOnePersonTb(long sellerId, long userId) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId).andSellerIdEqualTo(sellerId);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.size() != 1) {
            return null;
        }

        User user = users.get(0);
        if(user == null || StringUtils.isEmpty(user.getMobile())) {
            return null;
        }

        // 找淘宝收件人中是否有相同手机号的人
        ReceiverTaoBaoExample receiverTaoBaoExample = new ReceiverTaoBaoExample();
        receiverTaoBaoExample.createCriteria().andReceiverMobileEqualTo(user.getMobile());
        List<ReceiverTaoBao> taobaoReceivers = receiverTaoBaoMapper.selectByExample(receiverTaoBaoExample);
        if(CollectionUtils.isEmpty(taobaoReceivers)) {
            return null;
        }

        for(ReceiverTaoBao taobaoReceiver : taobaoReceivers) {
            Boolean isOnePerson = isOnePersonWxTb(sellerId, userId, taobaoReceiver.getUserIdTb());

            if(isOnePerson) {
                return taobaoReceiver;
            }
        }

        return null;
    }

    /**
     * 找到与user表中的用户为同一人的淘宝收件人表中的用户列表（不去重），用来做主收人计算等
     *
     * @param sellerId
     * @param userId
     * @return
     */
    public List<ReceiverTaoBao> getOnePersonTbList(long sellerId, long userId) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId).andSellerIdEqualTo(sellerId);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.size() != 1) {
            return null;
        }

        User user = users.get(0);
        if(user == null || StringUtils.isEmpty(user.getMobile())) {
            return null;
        }

        // 找淘宝收件人中是否有相同手机号的人
        ReceiverTaoBaoExample receiverTaoBaoExample = new ReceiverTaoBaoExample();
        receiverTaoBaoExample.createCriteria().andReceiverMobileEqualTo(user.getMobile());
        List<ReceiverTaoBao> taobaoReceivers = receiverTaoBaoMapper.selectByExample(receiverTaoBaoExample);
        if(CollectionUtils.isEmpty(taobaoReceivers)) {
            return null;
        }

        List<ReceiverTaoBao> receiverTaoBaoList = new ArrayList<ReceiverTaoBao>();
        for(ReceiverTaoBao taobaoReceiver : taobaoReceivers) {
            Boolean isOnePerson = isOnePersonWxTb(sellerId, userId, taobaoReceiver.getUserIdTb());

            if(isOnePerson) {
                receiverTaoBaoList.add(taobaoReceiver);
            }
        }

        return receiverTaoBaoList;
    }

}
