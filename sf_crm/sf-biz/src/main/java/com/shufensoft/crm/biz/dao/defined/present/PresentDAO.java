package com.shufensoft.crm.biz.dao.defined.present;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/24  
 */
@Repository
public interface PresentDAO {
    //birthday_acivity_id 把相关数据进行逻辑删除
    int updateIsDeletedByBaId(@Param("birthdayActivityId") Long birthdayActivityId);
}
