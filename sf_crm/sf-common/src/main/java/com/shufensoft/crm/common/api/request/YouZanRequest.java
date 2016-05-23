package com.shufensoft.crm.common.api.request;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 口袋通请求类
 *  @author litu  litu@shufensoft.com
 *  @date 2015/4/16 18:47  
 */
public class YouZanRequest extends ApiRequest{

    public YouZanRequest(){
        headerMap = new HashMap<String, String>();
        headerMap.put("User-Agent", "KdtApiSdk Client v0.1");
    }

    /**
     * 文件上传路径
     */
    @Setter@Getter
    private List<String> filePaths;
    /**
     * 文件类型，如
     */
    @Setter@Getter
    private String fileKey;


}
