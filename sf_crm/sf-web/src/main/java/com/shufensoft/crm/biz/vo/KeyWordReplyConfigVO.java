package com.shufensoft.crm.biz.vo;

import com.shufensoft.crm.biz.domain.generation.reply.KeyWordReplyConfig;
import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/3  
 */
@Data
public class KeyWordReplyConfigVO extends KeyWordReplyConfig {

    private String introduceWord;

    private String picUrl;

    private String url;

}
