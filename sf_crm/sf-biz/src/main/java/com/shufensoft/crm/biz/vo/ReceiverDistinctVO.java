package com.shufensoft.crm.biz.vo;

import lombok.Data;

import java.util.Date;

/**
 *  收件人区分的VO
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-24 19:33  
 */
@Data
public class ReceiverDistinctVO implements Comparable<ReceiverDistinctVO> {

    private long userIdTb;

    private long userIdJd;

    private long userIdYz;

    /**
     * 订单创建时间
     */
    private Date created;

    private String receiverName;

    private String receiverAddress;

    private String receiverMobile;

    private String receiverCountry;

    private String receiverState;

    private String receiverCity;

    private int cnt = 1;

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(userIdTb);
        buf.append(receiverName);
        buf.append(receiverAddress);
        buf.append(receiverMobile);
        return buf.toString();
    }

    @Override
    public int compareTo(ReceiverDistinctVO vo) {
        if(this.cnt > vo.getCnt()) {
            return 1;
        } else if(this.cnt < vo.getCnt()) {
            return -1;
        } else {
            if(this.created.after(vo.getCreated())) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
