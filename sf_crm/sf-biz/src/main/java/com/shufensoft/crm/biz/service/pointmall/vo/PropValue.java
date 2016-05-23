package com.shufensoft.crm.biz.service.pointmall.vo;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-06-03 13:56  
 */
public class PropValue {

    private long pid;

    private List<Long> vidList;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public List<Long> getVidList() {
        return vidList;
    }

    public void setVidList(List<Long> vidList) {
        this.vidList = vidList;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(pid + ":");
        for(int i=0; i<vidList.size(); i++) {
            buf.append(vidList.get(i));
            if(i != vidList.size() - 1) {
                // 不是最后一个都加上逗号
                buf.append(",");
            }
        }

        return buf.toString();
    }
}
