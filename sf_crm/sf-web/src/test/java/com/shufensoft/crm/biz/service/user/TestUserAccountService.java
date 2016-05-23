package com.shufensoft.crm.biz.service.user;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.defined.user.UserAccountDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-07-19 10:10  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUserAccountService {

    @Autowired
    private UserAccountService userAccountService;

    @Test
    public void selectUserAccountInteraction() {
        DBContextHolder.setDataSourceKey("1");
        UserAccountDO  userAccountDO=new UserAccountDO();
        userAccountDO.setUserId(3841236825l);
        List<UserAccountDO> userAccountDOList = userAccountService.selectUserAccountInteraction(userAccountDO,1,20,Long.valueOf(1));

    }

}
