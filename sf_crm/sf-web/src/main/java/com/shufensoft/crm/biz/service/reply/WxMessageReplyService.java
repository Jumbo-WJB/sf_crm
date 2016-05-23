package com.shufensoft.crm.biz.service.reply;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.dao.defined.reply.WXMessageQueryDAO;
import com.shufensoft.crm.biz.domain.defined.reply.WXMessageQueryDO;
import com.shufensoft.crm.biz.vo.WXMessageQueryVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/27 下午4:32  
 */
@Service
public class WxMessageReplyService {

    /**
     * 微信互动回复信息查询DAO
     */
    @Autowired
    private WXMessageQueryDAO wxMessageQueryDAO;

    /**
     * 分页查询用户微信互动回复信息查询记录
     * @param wxMessageQueryVO
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo queryUserWXMessageQueryServiceDetail(WXMessageQueryVO wxMessageQueryVO,Integer start,Integer pageSize){

        AssertsUtil.notNull(wxMessageQueryVO,"wxMessageQueryVO");
        AssertsUtil.notNull(start,"start");
        AssertsUtil.notNull(pageSize,"pageSize");


        WXMessageQueryDO wxMessageQueryDO = new WXMessageQueryDO();

        if (StringUtils.isNotEmpty(wxMessageQueryVO.getWxNickName())){
            wxMessageQueryDO.setWxNickName(wxMessageQueryVO.getWxNickName());
        }

        if (StringUtils.isNotEmpty(wxMessageQueryVO.getBizType())){
            wxMessageQueryDO.setBizType(wxMessageQueryVO.getBizType());
        }

        if (StringUtils.isNotEmpty(wxMessageQueryVO.getMobile())){
            wxMessageQueryDO.setMobile(wxMessageQueryVO.getMobile());
        }

        if ("1".equals(wxMessageQueryVO.getToSend())){
            wxMessageQueryDO.setCreateTime(DateUtil.getNDayStartTime(1));
        }

        wxMessageQueryDO.setSellerId(wxMessageQueryVO.getSellerId());

        PageHelper.startPage(start, pageSize);

        List<WXMessageQueryDO> wxMessageQueryDOList = new ArrayList<WXMessageQueryDO>();
        try{
            wxMessageQueryDOList = wxMessageQueryDAO.selectUserWXMessageQuery(wxMessageQueryDO);
        } catch (Exception e){
            e.printStackTrace();
        }

        return new PageInfo(wxMessageQueryDOList);
    }
}
