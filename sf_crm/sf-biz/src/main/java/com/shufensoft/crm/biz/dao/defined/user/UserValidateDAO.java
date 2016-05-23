package com.shufensoft.crm.biz.dao.defined.user;

import com.shufensoft.crm.biz.domain.defined.user.UserValidateDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>用户验证dao层
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/6/29  
 */
@Repository
public interface UserValidateDAO {

    List<UserValidateDO> selectValidateResult(UserValidateDO userValidateDO);
}
