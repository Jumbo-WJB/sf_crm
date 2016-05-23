package com.shufensoft.crm.biz.dao.defined.user;

import com.shufensoft.crm.biz.domain.defined.user.UserAccountDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 用户账户接口
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/6/16 15:51  
 */
@Repository
public interface UserAccountDAO {
    /**
     * 获取用户账户用户信息
     * @param userAccountDO
     * @return
     */
    List<UserAccountDO> selectUserAccountWithUser(UserAccountDO userAccountDO);

    /**
     * 获取用户账户互动信息
     * @param userAccountDO
     * @return
     */
    List<UserAccountDO>  selectUserAccountInteraction(UserAccountDO userAccountDO);

}
