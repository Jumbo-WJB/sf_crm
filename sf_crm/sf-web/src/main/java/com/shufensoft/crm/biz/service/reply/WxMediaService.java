package com.shufensoft.crm.biz.service.reply;

import com.shufensoft.crm.biz.dao.generation.reply.WxMediaMapper;
import com.shufensoft.crm.biz.domain.generation.reply.WxMedia;
import com.shufensoft.crm.biz.vo.WxMediaVO;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/3  
 */
@Service
public class WxMediaService {

    /**
     * 根据获取id获取素材
     */
    @Autowired
    private WxMediaMapper wxMediaMapper;

    public WxMediaVO getWxMediaById(Long id){

        WxMedia wxMedia = wxMediaMapper.selectByPrimaryKey(id);

        return (WxMediaVO)BeanCopierUtils.copyProperties(wxMedia,WxMediaVO.class);

    }

}
