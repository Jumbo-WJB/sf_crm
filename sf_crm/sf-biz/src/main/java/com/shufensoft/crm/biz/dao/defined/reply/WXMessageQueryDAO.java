package com.shufensoft.crm.biz.dao.defined.reply;

import com.shufensoft.crm.biz.domain.defined.reply.WXMessageQueryDO;
import com.shufensoft.crm.biz.domain.generation.user.UserWxMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/30 上午7:25  
 */
@Repository
public interface WXMessageQueryDAO {

    /**
     * 查询用户微信互动查询记录
     * @param wxMessageQueryDO
     * @return
     */
    public List<WXMessageQueryDO> selectUserWXMessageQuery(WXMessageQueryDO wxMessageQueryDO);

    public List<UserWxMessage> queryWxInteractiveUser(Long sellerId);

    /**
     * 统计48小时内有过微信互动的用户数量
     * @param sellerId
     * @return
     */
    public Integer countWxInteractiveUser(Long sellerId);
}
