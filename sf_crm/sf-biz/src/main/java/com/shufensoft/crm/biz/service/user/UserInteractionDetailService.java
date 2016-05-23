package com.shufensoft.crm.biz.service.user;

import com.shufensoft.crm.biz.dao.generation.user.UserInteractionDetailMapper;
import com.shufensoft.crm.biz.domain.generation.user.UserInteractionDetail;
import com.shufensoft.crm.biz.domain.generation.user.UserInteractionDetailExample;
import com.shufensoft.crm.biz.service.user.vo.UserInteractionDetailVO;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>用户互动</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/14  
 */
@Service
public class UserInteractionDetailService {
    private static final Logger logger = Logger.getLogger(UserInteractionDetailService.class);

    @Autowired
    private UserInteractionDetailMapper userInteractionDetailMapper;

    public  int countUserInteractionDetail(Long  sellerId,UserInteractionDetailVO userInteractionDetailVO){
        UserInteractionDetailExample userInteractionDetailExample=new  UserInteractionDetailExample();
        UserInteractionDetailExample.Criteria criteria=userInteractionDetailExample.createCriteria();
       if(userInteractionDetailVO.getStartDate()!=null){
           criteria.andInteractionTimeGreaterThanOrEqualTo(userInteractionDetailVO.getStartDate());
       }
       if(userInteractionDetailVO.getEndDate()!=null){
           criteria.andInteractionTimeLessThanOrEqualTo(userInteractionDetailVO.getEndDate());
       }
       if(userInteractionDetailVO.getUserId()!=null){
           criteria.andUserIdEqualTo(userInteractionDetailVO.getUserId());
       }
       if(sellerId!=null){
           criteria.andSellerIdEqualTo(sellerId);
       }
      return   userInteractionDetailMapper.countByExample(userInteractionDetailExample);
    }

    /**
     * 保存用户互动信息
     * @param userInteractionDetailVO
     * @return
     */
    public boolean saveUserInteractionDetail(UserInteractionDetailVO userInteractionDetailVO){

        UserInteractionDetail userInteractionDetail = new UserInteractionDetail();

        BeanCopierUtils.copyProperties(userInteractionDetailVO, userInteractionDetail);

        userInteractionDetailMapper.insert(userInteractionDetail);

        return true;
    }

}
