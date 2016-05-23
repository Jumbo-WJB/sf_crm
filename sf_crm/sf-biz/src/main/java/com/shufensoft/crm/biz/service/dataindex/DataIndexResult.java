package com.shufensoft.crm.biz.service.dataindex;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-31 10:46  
 */
public class DataIndexResult {

    /**
     * 如果是数据类型，如果没有合法的数据结果，就为"-1"
     */
    private Object result;

    private boolean isSuccess = false;

    private String msg = null;

    public DataIndexResult(String msg, boolean isSuccess) {
        this.msg = msg;
        this.isSuccess = isSuccess;
    }

    public DataIndexResult(Object result) {
        this.isSuccess = true;
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMsg() {
        return msg;
    }

}
