package com.shufensoft.crm.biz.domain.generation.send;

import com.shufensoft.crm.biz.domain.generation.reply.WxMedia;
import lombok.Data;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>上传图文消息素材
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/10/10  
 */
@Data
public class WxUploadNews {

    /**
     * 商家id
     */
    private Long sellerId;

    /**
     * 多图文消息
     */
    private List<WxMedia> wxMediaList;

}
