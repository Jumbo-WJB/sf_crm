package com.shufensoft.crm.common.email.response;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 基础响应类
 *  @author zoujian  zojujian@shufensoft.com
 *  @date 2015/5/25 22:39  
 */

public class BaseResponse {


    /**
     * 错误码
     */
    @Setter
    @Getter
    private String errorCode;

    /**
     * 错误消息
     */
    @Setter
    @Getter
    private String errorMessage;

    /**
     * 返回结果
     */
    @Setter
    @Getter
    private Object resultInfo_tmp;

    /**
     * 返回结果
     */
    @Setter
    @Getter
    private Map resultInfo;

    /**
     * 返回json结果
     */
    @Setter
    @Getter
    private String resultJson;


    /**
     * 分页查询记录总数
     */
    @Setter
    @Getter
    private Integer totalResults;

    private String getFieldNameKey(String key) {
        String[] column_nameArr = StringUtils.split(key, "_");
        int length = column_nameArr.length;
        StringBuffer buffer = new StringBuffer(column_nameArr[0]);
        if (length > 1) {
            for (int i = 1; i < column_nameArr.length; i++) {
                buffer.append(StringUtils.capitalize(column_nameArr[i]));
            }
        }
        return buffer.toString();
    }

}
