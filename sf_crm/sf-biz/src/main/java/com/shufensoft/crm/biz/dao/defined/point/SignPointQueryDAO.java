package com.shufensoft.crm.biz.dao.defined.point;

import com.shufensoft.crm.biz.domain.defined.point.SignInPointQueryDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/4 下午3:28  
 */
@Repository
public interface SignPointQueryDAO {


    /**
     * 查询用户签到积分明细
     * @return
     */
    public List<SignInPointQueryDO> selectSignPointDetail(SignInPointQueryDO signInPointQueryDO);
}
