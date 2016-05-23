package com.shufensoft.crm.biz.service.pointmall.vo;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-06-03 14:05  
 */
public class PropValueName {

    private long pid;

    private List<Long> vidList;

    private String propName;

    private List<String> valueNameList;

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

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public List<String> getValueNameList() {
        return valueNameList;
    }

    public void setValueNameList(List<String> valueNameList) {
        this.valueNameList = valueNameList;
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

        buf.append(":" + propName + ":");

        for(int i=0; i<valueNameList.size(); i++) {
            buf.append(valueNameList.get(i));
            if(i != valueNameList.size() - 1) {
                // 不是最后一个都加上逗号
                buf.append(",");
            }
        }

        return buf.toString();
    }
}
