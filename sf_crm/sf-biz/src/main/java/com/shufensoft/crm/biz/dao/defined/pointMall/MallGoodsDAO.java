package com.shufensoft.crm.biz.dao.defined.pointMall;

import com.shufensoft.crm.biz.domain.defined.pointMall.MallGoodsDo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/9  
 */
@Repository
public interface MallGoodsDAO {
    //查询出所有符合发送生日礼物的积分商城商品
    List<MallGoodsDo> selectBirthdayGifts();

    /**
     *  @param sellerId
     *  条件包括: sellerId, 排除礼物类目, saleStatus:在售状态, quantity:库存量大于0
     * */
    public List<MallGoodsDo> findMallGoodsByParams(Long sellerId);

    /**
     *  商品查询通用方法, 包括类目的过滤
     * */
    public List<MallGoodsDo> findMallGoodsByGoodsDo(MallGoodsDo mallGoodsDo);


}
