package com.shufensoft.crm.biz.domain.generation.email;

import lombok.Data;

import java.util.List;

/**
 * Created by apple on 15/6/16.
 */
@Data
public class SubscribersReslutInfo {

    private String code;

    private List<SubscribersErrorInfo> subscribersErrorInfoList;
}
