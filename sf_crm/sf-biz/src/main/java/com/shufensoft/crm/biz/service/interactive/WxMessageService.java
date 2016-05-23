package com.shufensoft.crm.biz.service.interactive;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.user.UserWxMessageMapper;
import com.shufensoft.crm.biz.domain.generation.user.UserWxMessage;
import com.shufensoft.crm.biz.domain.generation.user.UserWxMessageExample;
import com.shufensoft.crm.common.utils.AssertsUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 微信互动-信息交互
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/28 下午3:52  
 */
@Service
public class WxMessageService {

    /**
     * 用户微信信息交互Mapper
     */
    @Autowired
    private UserWxMessageMapper userWxMessageMapper;

    public void insertWXMessage(UserWxMessage userWxMessage){
        userWxMessageMapper.insert(userWxMessage);
    }

    /**
     * 保存或更新
     * @param userWxMessage
     * @return
     */
    public boolean saveOrUpdateWXMessage(UserWxMessage userWxMessage){

        AssertsUtil.notBlank(userWxMessage.getMsgId(),"msgId");
        AssertsUtil.notBlank(userWxMessage.getSendType(),"sendType");

        UserWxMessageExample userWxMessageExample = new UserWxMessageExample();

        if(StringUtils.isNotBlank(userWxMessage.getMsgId()) && DaoConstant.UserWXMessageSendType.
                FROM_CUSTOM.equals(userWxMessage.getSendType())){

            userWxMessageExample.createCriteria().andMsgIdEqualTo(userWxMessage.getMsgId())
                    .andSendTypeEqualTo(userWxMessage.getSendType());
            List<UserWxMessage> userWxMessages = userWxMessageMapper.selectByExample(userWxMessageExample);

            if(!CollectionUtils.isEmpty(userWxMessages)){
                userWxMessage.setId(userWxMessages.get(0).getId());
                return userWxMessageMapper.updateByPrimaryKeySelective(userWxMessage)>0;
            }


        }

        userWxMessageMapper.insert(userWxMessage);

        return true;

    }
}
