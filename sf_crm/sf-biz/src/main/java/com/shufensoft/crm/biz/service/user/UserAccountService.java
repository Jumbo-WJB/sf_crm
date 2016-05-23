package com.shufensoft.crm.biz.service.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.dao.defined.user.UserAccountDAO;
import com.shufensoft.crm.biz.dao.generation.user.UserAccountMapper;
import com.shufensoft.crm.biz.domain.defined.user.UserAccountDO;
import com.shufensoft.crm.biz.domain.generation.user.UserAccount;
import com.shufensoft.crm.biz.domain.generation.user.UserAccountExample;
import com.shufensoft.crm.biz.vo.UserAccountVO;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/6/11 23:54  
 */
@Service
public class UserAccountService {

    @Autowired
    UserAccountMapper userAccountMapper;


    @Autowired
    UserAccountDAO userAccountDAO;


    /**
     * 分页查询红包账户明细
     * @return
     */
    public PageInfo queryUserAccounts(UserAccountVO userAccountVO,Integer pageNum,Integer length,String  sortContent,Long sellerId){

         UserAccountDO   userAccountDO=new UserAccountDO();
         BeanCopierUtils.copyProperties(userAccountVO,userAccountDO);

        if(sellerId!=null){
            userAccountDO.setSellerId(sellerId);
        }

        if(StringUtils.isNotBlank(sortContent)){
            userAccountDO.setOrderByClause(sortContent);
        }else{
            userAccountDO.setOrderByClause(" gmt_modified desc ");
        }

        PageHelper.startPage(pageNum, length);
        List<UserAccountDO> userAccounts=userAccountDAO.selectUserAccountWithUser(userAccountDO);

        return new PageInfo(userAccounts);
    }


    /**
     * 查询用户账户明细
     * @param userAccountVO
     * @return
     */
    public List<UserAccount> queryHBAccountList(UserAccountVO userAccountVO,Long  sellerId){

        UserAccountExample userAccountExample =new UserAccountExample();
        UserAccountExample.Criteria criteria=userAccountExample.createCriteria();
        if(userAccountVO.getUserId()>0){
            criteria.andUserIdEqualTo(userAccountVO.getUserId());
        }
        if(userAccountVO.getStartDate()!=null){
            criteria.andHbcashDateGreaterThanOrEqualTo(userAccountVO.getStartDate());
        }
        if(userAccountVO.getEndDate()!=null){
            criteria.andHbcashDateLessThanOrEqualTo(userAccountVO.getEndDate());
        }
        if(sellerId!=null){
            criteria.andSellerIdEqualTo(sellerId);
        }
        List<UserAccount> userAccounts=userAccountMapper.selectByExample(userAccountExample);
         return  userAccounts;

    }

    /**
     * 获取用户账务信息
     * @param userAccountDO
     * @return
     */
   public   List<UserAccountDO> getUserAccountWithUser(UserAccountDO  userAccountDO,Long sellerId){
       if(sellerId!=null){
           userAccountDO.setSellerId(sellerId);
       }
       List<UserAccountDO> userAccounts=userAccountDAO.selectUserAccountWithUser(userAccountDO);
       return CollectionUtils.isEmpty(userAccounts)?new ArrayList<UserAccountDO>():userAccounts;
   }

    /**
     * 获取用户账户排名信息
     * @param userAccountDO
     * @return
     */
    public List<UserAccountDO>  selectUserAccountInteraction(UserAccountDO  userAccountDO,Integer pageNum,Integer length,Long sellerId){
        if(sellerId!=null){
            userAccountDO.setSellerId(sellerId);
        }
        PageHelper.startPage(pageNum, length);
        List<UserAccountDO> userAccounts=userAccountDAO.selectUserAccountInteraction(userAccountDO);
        return CollectionUtils.isEmpty(userAccounts)?new ArrayList<UserAccountDO>():userAccounts;
    }

    /**
     *
     * */
    public UserAccount findUserAccountByUserId(Long sellerId,Long userId){
        UserAccountExample userAccountExample = new UserAccountExample();
        userAccountExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId);
        List<UserAccount> userAccounts = userAccountMapper.selectByExample(userAccountExample);
        if(!CollectionUtils.isEmpty(userAccounts)){
            return userAccounts.get(0);
        }
        return null;
    }


}
