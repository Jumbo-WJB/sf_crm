package com.shufensoft.crm.biz.service.dataindex;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-27 21:31  
 */
public abstract class DataIndex {

    /**
     * 数据指标名字
     */
    protected String name = null;

    /**
     * 数据指标描述
     */
    protected String description = null;

    /**
     * 数据指标数据源类型
     */
    protected List<DataTypeEnum> dataList;

    /**
     * 数据指标数据源来源平台
     */
    protected List<PlatformEnum> platformList;

    public abstract void setProperties();

    public abstract DataIndexResult computeWithData(RawData rawData);

    public abstract DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<DataTypeEnum> getDataList() {
        return dataList;
    }

    public List<PlatformEnum> getPlatformList() {
        return platformList;
    }

    public boolean checkData(RawData rawData) {
        setProperties();
        for(DataTypeEnum dataTypeEnum : dataList) {
            if(DataTypeEnum.TRADE_TB.equals(dataTypeEnum)) {
                if(rawData.getTradeTaoBaoList()  == null) {
                    return false;
                }
            }
            if(DataTypeEnum.TRADE_JD.equals(dataTypeEnum)) {
                if(rawData.getOrderJdList()  == null) {
                    return false;
                }
            }
        }

        return true;
    }

}
