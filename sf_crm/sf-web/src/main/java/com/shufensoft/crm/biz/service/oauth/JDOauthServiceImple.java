package com.shufensoft.crm.biz.service.oauth;

import com.jd.open.api.sdk.response.seller.VenderInfoResult;
import com.shufensoft.crm.biz.adapter.JDAdapter;
import com.shufensoft.crm.biz.cache.LstOfValCache;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.permission.AdminUserMapper;
import com.shufensoft.crm.biz.dao.generation.permission.AdminUserRoleMapper;
import com.shufensoft.crm.biz.domain.generation.permission.AdminUser;
import com.shufensoft.crm.biz.domain.generation.permission.AdminUserExample;
import com.shufensoft.crm.biz.domain.generation.permission.AdminUserRole;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.oauth.imple.JDOauthServiceInter;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.Md5Encrypt;
import com.shufensoft.crm.common.utils.PropertyReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/8/28  
 */
@Service(value="jdOauthService")
public class JDOauthServiceImple implements JDOauthServiceInter{

    private Logger logger = Logger.getLogger(JDOauthServiceImple.class);

    private final static String JD_SERVICE_MARKET_ADMIN_USER_ROLE_TYPE = "JD_SERVICE_MARKET_ADMIN_USER_ROLE_TYPE";

    private final static String JD_SERVICE_MARKET_ADMIN_USER_ROLE_NAME = "JD_SERVICE_MARKET_ADMIN_USER_ROLE_NAME";

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminUserRoleMapper adminUserRoleMapper;

    /**
     * 1.获取accessToken
     * 2.创建商户信息, 店铺信息
     * 3.创建用户, 关联角色
     * 4.登录应用
     * */
     @Override
     @Transactional(rollbackFor = Exception.class)
     public AdminUser handleAuthorizeFromJDServiceMarket(String accessToken, String refreshToken, int expiresTime) throws Exception{
        AdminUser adminUser = null;
        String appKey = PropertyReader.getValue("crm.jd.app.key");
        String appSecret = PropertyReader.getValue("crm.jd.app.secret");
        VenderInfoResult venderInfoResult = JDAdapter.getJDVenderInfo(accessToken, appKey, appSecret);
         logger.info("venderInfoResult:   " + venderInfoResult);
        if(venderInfoResult != null){
            Long jdShopId = venderInfoResult.getShopId();
            String jdShopName = venderInfoResult.getShopName();
            SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(jdShopId));
            if(sellerConfigInfo == null){
                //创建商家信息
                sellerConfigInfo = new SellerConfigInfo();
                sellerConfigInfo.setSellerId(jdShopId);
                sellerConfigInfo.setSellerName(jdShopName);
                SellerConfigCache.put(String.valueOf(jdShopId), sellerConfigInfo);
                //创建店铺信息
                SellerShop sellerShop = new SellerShop();
                sellerShop.setSellerId(jdShopId);
                sellerShop.setShopId(jdShopId);
                sellerShop.setShopName(jdShopName);
                sellerShop.setShopType(DaoConstant.ShopType.JD);
                sellerShop.setShopAppId(appKey);
                sellerShop.setShopAppSecret(appSecret);
                sellerShop.setShopAccessToken(accessToken);
                sellerShop.setShopRefreshToken(refreshToken);
                Date expiresDate = DateUtil.operateDate(new Date(), 0, 0, 0, 0, 0, expiresTime);
                sellerShop.setShopTokenExpire(expiresDate);
                SellerConfigCache.putSellerShop(String.valueOf(jdShopId), sellerShop);
                //创建用户信息
                String initPwd = PropertyReader.getValue("admin.user.init.password");
                adminUser = new AdminUser();
                adminUser.setSellerId(jdShopId);
                adminUser.setUserName(jdShopName);
                adminUser.setPassword(Md5Encrypt.md5(initPwd));
                adminUser.setName(jdShopName);
                adminUserMapper.insertSelective(adminUser);
                //关联用户角色
                String roleIdStr = LstOfValCache.getValue(JD_SERVICE_MARKET_ADMIN_USER_ROLE_TYPE, JD_SERVICE_MARKET_ADMIN_USER_ROLE_NAME);
                AssertsUtil.notNull(roleIdStr, "roleId");
                AdminUserRole adminUserRole = new AdminUserRole();
                adminUserRole.setRoleId(Long.parseLong(roleIdStr));
                adminUserRole.setAdminUserId(adminUser.getAdminUserId());
                adminUserRoleMapper.insertSelective(adminUserRole);
            }else{
                AdminUserExample adminUserExample = new AdminUserExample();
                adminUserExample.createCriteria().andSellerIdEqualTo(jdShopId).andUserNameEqualTo(jdShopName);
                List<AdminUser> list = adminUserMapper.selectByExample(adminUserExample);
                if(!CollectionUtils.isEmpty(list)){
                    adminUser = list.get(0);
                }
            }
        }
        return adminUser;

    }


}
