package com.shufensoft.crm.biz.dao.defined.express;

import com.shufensoft.crm.biz.domain.defined.express.ExpressInfoDO;
import com.shufensoft.crm.biz.domain.defined.express.ExpressMessageQueryDO;
import com.shufensoft.crm.biz.domain.defined.point.UserWxMessageDO;
import com.shufensoft.crm.biz.domain.defined.user.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author lisen  lisen@suniusoft.com
 *  @date 15/7/02 上午8:49  
 */
@Repository
public interface ExpressDAO {
    public List<ExpressMessageQueryDO> selectExpressList(ExpressMessageQueryDO expressMessageQueryDO);
    //从user表中查询出user_id_taobao, user_id_jd, user_id_yz
    public List<UserDO> selectAllAboutId(ExpressMessageQueryDO expressMessageQueryDO);
    //更新快递信息
    void updateExpressMessagesByUserId(UserWxMessageDO userWxMessageDO);
    //根据user_id_tb来查询出user_id
    Long findUserIdByUserIdTb(Long UserIdTb);
    //根据userId查询 user_id_taobao, user_id_jd, user_id_yz
    UserDO selectIdsByUserId(Long userId);

    //把快递信息插入表中
    int insertExpressInfo(ExpressInfoDO expressInfoDO);

    //更新快递信息
    int updateExpressInfo(ExpressInfoDO expressInfoDO);

    //从express_info表中通过user_id来获取物流信息
    ArrayList<ExpressInfoDO> selectExpressInfosByUserId(@Param("userId") Long userId);

    //根据用户id和运单号来查询
    ExpressInfoDO selectExpressWithUserIdAndmailNo(@Param("userId")Long userId, @Param("mailNo")String mailNo);

}
