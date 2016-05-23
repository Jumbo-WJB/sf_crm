package com.shufensoft.crm.biz.service.onlineMessage.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.dao.generation.onlineMessage.OnlineMessageMapper;
import com.shufensoft.crm.biz.domain.generation.onlineMessage.OnlineMessage;
import com.shufensoft.crm.biz.domain.generation.onlineMessage.OnlineMessageExample;
import com.shufensoft.crm.biz.service.onlineMessage.OnlineMessageService;
import com.shufensoft.crm.biz.vo.OnlineMessageVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>官网信息服务类
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/8/19  
 */
@Service(value = "onlineMessageService")
public class OnlineMessageServiceImpl implements OnlineMessageService {

    @Autowired
    private OnlineMessageMapper onlineMessageMapper;

    @Override
    public boolean insertOrUpdateMessage(OnlineMessageVO onlineMessageVO) {

        AssertsUtil.notNull(onlineMessageVO,"onlineMessageVO");

        OnlineMessage message = (OnlineMessage)BeanCopierUtils.copyProperties(onlineMessageVO,OnlineMessage.class);

        if (message.getId() != null){
            onlineMessageMapper.updateByPrimaryKeySelective(message);
        }else{
            onlineMessageMapper.insertSelective(message);
        }

        return true;
    }

    @Override
    public PageInfo queryMessage(OnlineMessageVO onlineMessageVO, Integer pageNum, Integer length) {

        OnlineMessageExample example = new OnlineMessageExample();
        OnlineMessageExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(onlineMessageVO.getName())){
            criteria.andNameLike(onlineMessageVO.getName());
        }
        if (StringUtils.isNotBlank(onlineMessageVO.getMobile())){
            criteria.andMobileEqualTo(onlineMessageVO.getMobile());
        }
        if (StringUtils.isNotBlank(onlineMessageVO.getAddress())){
            criteria.andAddressLike(onlineMessageVO.getAddress());
        }

        PageHelper.startPage(pageNum, length);
        List<OnlineMessage> list = onlineMessageMapper.selectByExample(example);

        return new PageInfo(list);
    }
}
