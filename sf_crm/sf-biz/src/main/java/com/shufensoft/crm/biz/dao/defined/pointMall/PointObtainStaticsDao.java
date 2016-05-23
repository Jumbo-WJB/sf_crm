package com.shufensoft.crm.biz.dao.defined.pointMall;


import com.shufensoft.crm.biz.domain.defined.pointMall.PointObtainStaticsDo;
import org.springframework.stereotype.Repository;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/6  
 */
@Repository
public interface PointObtainStaticsDao {

    public PointObtainStaticsDo findPointObtainStaticsDosBySellerId(Long sellerId);

}
