package com.shufensoft.crm.biz.service.oauth.vo;

import lombok.Data;
import lombok.ToString;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * 淘宝access_token
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/19  
 */
@Data
@ToString
public class TaoBaoAccessTokenVO {

    private String w2_expires_in;

    private String taobao_user_id;

    private String taobao_user_nick;

    private Long w1_expires_in;

    private Long re_expires_in;

    private Long r2_expires_in;

    private Long expires_in;

    private String token_type;

    private String refresh_token;

    private String access_token;

    private String r1_expires_in;

}
