package com.shufensoft.crm.job.oauth;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.job.inter.IAccessTokenService;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.SyncJob;
import com.shufensoft.crm.job.context.JobContext;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/22  
 */
public class RefreshTokenJob extends SyncJob {

    private static IAccessTokenService iAccessTokenService= null;

    static{
        iAccessTokenService = (IAccessTokenService) SpringContextUtil.getBean("accessTokenService");
    }

    @Override
    public void execute(JobContext jobContext) {

        String nowDate = DateUtil.getCurrentDateToStr();
        System.out.println("京东淘宝 refreshAccessToken: " + nowDate);

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();

        iAccessTokenService.refreshTokenByShop(sellerConfigInfo);

    }

    @Override
    public String jobName() {
        return JobConstant.JobName.TOKEN_REFRESH_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

}
