package com.shufensoft.crm.biz.service.birthday;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/27  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestBirthdayHb {
    @Autowired
    private BirthdayService birthdayService;
    @Test
    public void testUpdateStateAboutHb() {
        DBContextHolder.setDataSourceKey("1");
        birthdayService.updateStateAboutHb(1L,2768561695L,3209554940L);
    }

}
