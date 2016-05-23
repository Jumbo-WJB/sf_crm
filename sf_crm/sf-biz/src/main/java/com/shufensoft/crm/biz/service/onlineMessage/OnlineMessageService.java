package com.shufensoft.crm.biz.service.onlineMessage;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.vo.OnlineMessageVO;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/8/19  
 */
public interface OnlineMessageService {

    /**
     * 提交官网客户留言信息
     * @param onlineMessageVO
     * @return
     */
    public boolean insertOrUpdateMessage(OnlineMessageVO onlineMessageVO);

    /**
     * 查询留言信息
     * @param onlineMessageVO
     * @param pageNum
     * @param length
     * @return
     */
    public PageInfo queryMessage(OnlineMessageVO onlineMessageVO, Integer pageNum, Integer length);
}
