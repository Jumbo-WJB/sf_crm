package com.shufensoft.crm.biz.service.user;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-07-19 10:10  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUserBoundService {

    @Autowired
    private UserBoundService userBoundService;

//    INSERT INTO user(gmt_created, gmt_modified, created_by, modified_by, is_deleted,
//                     user_id, seller_id, first_source, wx_openid, wx_nick_name, sex, city, country, province,
//                     wx_subscribe, wx_headimgurl, wx_subscribe_time, is_old_user, brand_fans, is_verify)
//    VALUES (now(), now(), 'sys', 'sys', '0',
//            12768550233, 1, 'WX', 'openId', 'johnsoncqq', '男', 'hz', 'china', 'zhejiang',
//            '0', '', now(), '0', '0', '0');

    private static final Long userId = 3822260532L;

    @Test
    public void testBindWithTbId() {
        long sellerId = 1;
        String mobile = "18057138887";
        String tbId = "";
        String jdId = "";

        DBContextHolder.setDataSourceKey("1");
        UserBoundResponse userBoundResponse = userBoundService.bind(sellerId, userId, mobile, tbId, jdId);
        if(userBoundResponse.isSuccess()) {
            System.out.println("success");
        } else {
            System.out.println(userBoundResponse.getErrorCode() + ": " + userBoundResponse.getErrorMsg());
        }
    }

    @Test
    public void testBindWithJdId() {
        long sellerId = 1;
        String openId = "openId2";
        String mobile = "18108448648";
        String tbId = "";
        String jdId = "wdlgbysknixiqb";

        DBContextHolder.setDataSourceKey("1");
        UserBoundResponse userBoundResponse = userBoundService.bind(sellerId, userId, mobile, tbId, jdId);
        if(userBoundResponse.isSuccess()) {
            System.out.println("success");
        } else {
            System.out.println(userBoundResponse.getErrorCode() + ": " + userBoundResponse.getErrorMsg());
        }
    }

    @Test
    public void testBindWithTbMobile() {
        long sellerId = 1;
        String openId = "openId3";
        String mobile = "13488962735";
        String tbId = "";
        String jdId = "";

        DBContextHolder.setDataSourceKey("1");
        UserBoundResponse userBoundResponse = userBoundService.bind(sellerId, userId, mobile, tbId, jdId);
        if(userBoundResponse.isSuccess()) {
            System.out.println("success");
        } else {
            System.out.println(userBoundResponse.getErrorCode() + ": " + userBoundResponse.getErrorMsg());
        }
    }

    @Test
    public void testBindWithTbMobile2() {
        long sellerId = 1;
        String openId = "openId4";
        String mobile = "13488962735";
        String tbId = "";
        String jdId = "";

        DBContextHolder.setDataSourceKey("1");
        UserBoundResponse userBoundResponse = userBoundService.bind(sellerId, userId, mobile, tbId, jdId);
        if(userBoundResponse.isSuccess()) {
            System.out.println("success");
        } else {
            System.out.println(userBoundResponse.getErrorCode() + ": " + userBoundResponse.getErrorMsg());
        }
    }

    @Test
    public void testBindWithAlipayMobile() {
        long sellerId = 1;
        String openId = "openId6";
        String mobile = "18057138887";
        String tbId = "";
        String jdId = "";

        DBContextHolder.setDataSourceKey("1");
        UserBoundResponse userBoundResponse = userBoundService.bind(sellerId, userId, mobile, tbId, jdId);
        if(userBoundResponse.isSuccess()) {
            System.out.println("success");
        } else {
            System.out.println(userBoundResponse.getErrorCode() + ": " + userBoundResponse.getErrorMsg());
        }
    }

    @Test
    public void testBindWithJdMobile() {
        long sellerId = 1;
        String openId = "openId7";
        String mobile = "18108448648";
        String tbId = "";
        String jdId = "";

        DBContextHolder.setDataSourceKey("1");
        UserBoundResponse userBoundResponse = userBoundService.bind(sellerId, userId, mobile, tbId, jdId);
        if(userBoundResponse.isSuccess()) {
            System.out.println("success");
        } else {
            System.out.println(userBoundResponse.getErrorCode() + ": " + userBoundResponse.getErrorMsg());
        }
    }

}
