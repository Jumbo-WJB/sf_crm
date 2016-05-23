package com.shufensoft.crm.biz.helper;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.common.utils.AssertsUtil;
import org.apache.commons.lang.math.NumberUtils;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/8/25  
 */
public class DatasourceHelper {

    /**
     * 设置数据源
     * @param sellerId
     */
    public static void setDatasource(String sellerId){

        AssertsUtil.notBlank(sellerId,"sellerId");
        AssertsUtil.check(NumberUtils.isNumber(sellerId),"sellerId is not Number");

        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId);
        AssertsUtil.notNull(sellerConfigInfo.getDatasourceId(),"DatasourceId is null ");

        DBContextHolder.setDataSourceKey(String.valueOf(sellerConfigInfo.getDatasourceId()));

    }
}
