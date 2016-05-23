package com.shufensoft.crm.biz.dao.defined.shoppingHongbao;

import com.shufensoft.crm.biz.domain.defined.shoppingHongbao.ActivityGoodsDo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/10/10  
 */
@Repository
public interface ShoppingHongbaoDao {

    /**
     *
     * */
    public List<ActivityGoodsDo> findActivityGoods(ActivityGoodsDo activityGoodsDo);
}
