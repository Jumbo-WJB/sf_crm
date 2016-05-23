package com.shufensoft.crm.biz.service.express.service;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import com.shufensoft.crm.biz.service.express.vo.OrderVO;
import com.shufensoft.crm.biz.vo.WXMessageQueryVO;

/**
 * Created by Administrator on 2015/7/1.
 */
public interface ExpressService {

    //分页查询快递查询服务
    public PageInfo queryExpressDetail(WXMessageQueryVO wxMessageQueryVO, Integer start, Integer pageSize);


    /**
     * 根据订单号从第三方快递接口获取最新的快递信息
     * @param wxMessageQueryVO
     * @param start
     * @param pageSize
     */
    public void getExpressDetailsAndUpdate(WXMessageQueryVO wxMessageQueryVO, Integer start, Integer pageSize);

    /**
     * 快递查询
     * @param sellerId
     * @param orderVO
     * @return
     */
    public ExpressDetailVO findCommentExpressInfo(Long sellerId, Long userId, OrderVO orderVO);
    
}
