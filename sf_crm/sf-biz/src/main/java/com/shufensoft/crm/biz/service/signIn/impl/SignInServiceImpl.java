package com.shufensoft.crm.biz.service.signIn.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.signIn.SignInDAO;
import com.shufensoft.crm.biz.dao.generation.point.PointObtainMapper;
import com.shufensoft.crm.biz.domain.defined.sIgnIn.SignInDO;
import com.shufensoft.crm.biz.domain.generation.point.PointObtain;
import com.shufensoft.crm.biz.domain.generation.point.PointObtainExample;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.signIn.SignInService;
import com.shufensoft.crm.biz.service.signIn.vo.SignInVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/18 下午6:26  
 */
@Service
public class SignInServiceImpl implements SignInService {

    public static final Logger logger = Logger.getLogger(SignInServiceImpl.class);

    @Autowired
    private PointObtainMapper pointObtainMapper;

    @Autowired
    private IPointService pointService;

    @Autowired
    private SignInDAO signInDAO;




    /**
     * 今天是否已签到
     * @param userId 用户ID
     * @return true/false
     */
    @Override
    public boolean isSignIn(Long userId) {

        PointObtainExample pointObtainExample =  new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andGmtTransferBetween(DateUtil.getNDayStartTime(0),DateUtil.getNDayEndTime(0));
        criteria.andObtainMethodEqualTo(DaoConstant.PointObtainMethod.SIGN_IN);

        List<PointObtain> pointObtainList = pointObtainMapper.selectByExample(pointObtainExample);

        if (pointObtainList != null && !pointObtainList.isEmpty()){
            return true;
        }

        return false;
    }

    /**
     * 执行签到
     * @param sellerId
     * @param userId
     * @return
     */
    public int doSignIn(Long sellerId, Long userId){

        AssertsUtil.notNull(sellerId,"sellerId不能为空。");
        AssertsUtil.notNull(userId,"userId不能为空。");

        int code = -1;
        //Map<String, Object> returnMap = new HashMap<String,Object>();

        try{

            code = pointService.creteSignPoint(sellerId,userId);

        } catch (Exception e){

            logger.error("SignInService doSignIn error.",e);
        }

        return code;

    }




//    public List<SignInVO> queryTodayMysignInRank(Long userId){
//
//    }



    /**
     * 查询当月我的签到排名信息
     * @param userId 用户ID
     * @return
     */
    public SignInVO queryCurrentMonthMySignInRank(Long userId){

        AssertsUtil.notNull(userId,"userId");
        SignInVO signInVO = null;

        try{
            SignInDO signInDO = new SignInDO();

            signInDO.setObtainStartDate(DateUtil.getCurrentMonthStartTime());
            signInDO.setObtainEndDate(DateUtil.getCurrentMonthEndTime());
            signInDO.setUserId(userId);


            List<SignInDO> signInDOList = signInDAO.selectMySignInRank(signInDO);

            if (signInDOList ==null || signInDOList.isEmpty()){
                return null;
            }

            signInVO = new SignInVO();

            BeanCopierUtils.copyProperties(signInDOList.get(0),signInVO);

        } catch (Exception e){

            logger.error("SignInService queryCurrentMonthMySignInRank error",e);
        }

        return signInVO;
    }


    /**
     * 查看当天我的排名情况
     * @param userId
     * @return
     */
    public SignInVO queryCurrentDayMySignInRank(Long userId){
        AssertsUtil.notNull(userId,"userId");

        SignInVO signInVO = null;

        try{
            SignInDO signInDO = new SignInDO();

            signInDO.setUserId(userId);
            signInDO.setObtainStartDate(DateUtil.getNDayStartTime(0));
            signInDO.setObtainEndDate(DateUtil.getNDayEndTime(0));


            List<SignInDO> signInDOList = signInDAO.selectCurrentDayMySignInRank(signInDO);

            if (signInDOList==null || signInDOList.isEmpty()){
                return null;
            }

            signInVO = new SignInVO();

            BeanCopierUtils.copyProperties(signInDOList.get(0),signInVO);
        } catch (Exception e){

            logger.error("SignInService queryCurrentDayMySignInRank error",e);
        }


        return signInVO;

    }

    /**
     * 查询我总的签到排名信息
     * @param userId 用户ID
     * @return
     */
    public SignInVO queryTotalMySignInRank(Long userId){

        AssertsUtil.notNull(userId,"userId");

        SignInVO signInVO = null;

        try{

            SignInDO signInDO = new SignInDO();

            signInDO.setUserId(userId);


            List<SignInDO> signInDOList = signInDAO.selectMySignInRank(signInDO);

            if (signInDOList==null || signInDOList.isEmpty()){
                return null;
            }

            signInVO = new SignInVO();

            BeanCopierUtils.copyProperties(signInDOList.get(0),signInVO);

        }catch (Exception e){

            logger.error("SignInService queryTotalMySignInRank error",e);
        }


        return signInVO;
    }





    /**
     * 分页查询用户当天的签到排名记录
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo queryCurrentDaySignInRanking(Integer start,Integer pageSize){

        List<SignInDO> signInDOList = null;

        try{

            SignInDO signInDO = new SignInDO();

            signInDO.setObtainStartDate(DateUtil.getNDayStartTime(0));

            signInDO.setObtainEndDate(DateUtil.getNDayEndTime(0));



            PageHelper.startPage(start,pageSize);

            signInDOList = signInDAO.selectUserTodaySignInRanking(signInDO);

        }catch (Exception e){

            logger.error("SignInService queryCurrentDaySignInRanking error",e);
        }


        return new PageInfo(signInDOList);

    }


    /**
     * 查询用户当月的排名情况
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo queryCurrentMonthUserSignInRanking(Integer start,Integer pageSize){

        List<SignInDO> signInDOList = null;

        try{

            SignInDO signInDO = new SignInDO();
            signInDO.setObtainStartDate(DateUtil.getCurrentMonthStartTime());

            signInDO.setObtainEndDate(DateUtil.getCurrentMonthEndTime());


            PageHelper.startPage(start,pageSize);
            signInDOList = signInDAO.selectUserSignInRanking(signInDO);

        }catch (Exception e){

            logger.error("SignInService queryCurrentMonthUserSignInRanking error",e);
        }


        return new PageInfo(signInDOList);

    }



    /**
     * 查询用户总的的排名情况
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo queryTotalUserSignInRanking(Integer start,Integer pageSize){

        List<SignInDO> signInDOList = null;

        try{
            SignInDO signInDO = new SignInDO();

            PageHelper.startPage(start,pageSize);

            signInDOList = signInDAO.selectUserSignInRanking(signInDO);
        } catch (Exception e){

            logger.error("SignInService queryTotalUserSignInRanking error",e);
        }


        return new PageInfo(signInDOList);

    }



}
