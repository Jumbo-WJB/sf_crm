package com.shufensoft.crm.biz.service.express.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author lisen  lisen@suniusoft.com
 *  @date 15/7/01 下午10:12  
 */
@Data
public class ExpressDetailVO implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -8098452976629871723L;

    /**
     * 运单号
     */
    private String invoiceNo;

    /**
     * 快递公司
     */
    private String expressCompany;

    /**
     * show api -1 待查询 0 查询异常 1 暂无记录 2 在途中
     * 3 派送中 4 已签收 5 用户拒签 6 疑难件
     * 7 无效单 8 超时单 9 签收失败 10 退回
     */
    private String status;

    /**
     * 物流信息
     */
    private List<TransitStepVO> transitStepVOs;
}
