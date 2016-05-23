package com.shufensoft.crm.biz.adapter.jsonObj;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/30  
 */
@Data
@ToString
public class ShowapiResBodyJsonObj {
    /**
     * 快递配送信息
     */
    private List<ShowApiDataJsonObj> data;

    /**
     * 公司英文
     */
    private String expSpellName;

    private String yunda;

    /**
     * 快递单号
     */
    private String mailNo;

    private String ord;

    private String ret_code;

    /**
     * -1 待查询 0 查询异常 1 暂无记录 2 在途中
     * 3 派送中 4 已签收 5 用户拒签 6 疑难件
     * 7 无效单 8 超时单 9 签收失败 10 退回
     */
    private String status;

    /**
     * 更新时间
     */
    private String update;
}
