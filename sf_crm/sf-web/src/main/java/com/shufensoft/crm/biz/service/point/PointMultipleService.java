package com.shufensoft.crm.biz.service.point;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.adapter.WXAdapter;
import com.shufensoft.crm.biz.dao.defined.point.PointDAO;
import com.shufensoft.crm.biz.dao.defined.point.PointMessageQueryDAO;
import com.shufensoft.crm.biz.dao.defined.point.PointObtainDetailDAO;
import com.shufensoft.crm.biz.dao.defined.point.SignPointQueryDAO;
import com.shufensoft.crm.biz.domain.defined.point.PointDetailDO;
import com.shufensoft.crm.biz.domain.defined.point.PointMultipleDO;
import com.shufensoft.crm.biz.domain.defined.point.SignInPointQueryDO;
import com.shufensoft.crm.biz.domain.generation.send.SendWxMessage;
import com.shufensoft.crm.biz.vo.PointDetailVO;
import com.shufensoft.crm.biz.vo.PointMultipleDetailVO;
import com.shufensoft.crm.common.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/25 下午9:23  
 */
@Service
public class PointMultipleService {

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(PointMultipleService.class);

    @Autowired
    private PointDAO pointDAO;

    @Autowired
    private PointObtainDetailDAO pointObtainDetailDAO;

    @Autowired
    private PointMessageQueryDAO pointMessageQueryDAO;

    @Autowired
    private SignPointQueryDAO signPointQueryDAO;

    /**
     * 分页查询用户积分明细综合信息
     *
     * @param pointMultipleDetailVO
     * @param start                 开始页
     * @param pageSize              每页条数
     * @return
     */
    public PageInfo queryPointMultipleDetail(PointMultipleDetailVO pointMultipleDetailVO, Integer start, Integer pageSize) {
        PointMultipleDO pointMultipleDO = new PointMultipleDO();
        if (StringUtils.isNotEmpty(pointMultipleDetailVO.getName())) {
            pointMultipleDO.setName(pointMultipleDetailVO.getName());
        }
        if (StringUtils.isNotEmpty(pointMultipleDetailVO.getObtainMethod())) {
            pointMultipleDO.setObtainMethod(pointMultipleDetailVO.getObtainMethod());
        }
        if (StringUtils.isNotEmpty(pointMultipleDetailVO.getExchangMethod())) {
            pointMultipleDO.setExchangMethod(pointMultipleDetailVO.getExchangMethod());
        }
        if (null != pointMultipleDetailVO.getObtainStartDate()) {
            pointMultipleDO.setObtainStartDate(pointMultipleDetailVO.getObtainStartDate());
        }
        if (null != pointMultipleDetailVO.getObtainEndDate()) {
            pointMultipleDO.setObtainEndDate(pointMultipleDetailVO.getObtainEndDate());
        }

        pointMultipleDO.setSellerId(pointMultipleDetailVO.getSellerId());

        List<PointMultipleDO> pointMultipleDOList = new ArrayList<PointMultipleDO>();
        PageHelper.startPage(start, pageSize);
        try {
            pointMultipleDOList = pointDAO.selectUserPointDetails(pointMultipleDO);
        } catch (Exception e) {
            logger.error("queryPointMultipleDetail error.", e);
        }


        return new PageInfo(pointMultipleDOList);
    }

    /**
     * 获取积分获取明细
     *
     * @param pointObtainDetailVO
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo queryPointObtainDetail(PointDetailVO pointObtainDetailVO, Integer start, Integer pageSize) {
        PointDetailDO pointDetailDO = new PointDetailDO();
        if (StringUtils.isNotEmpty(pointObtainDetailVO.getUserId())) {
            pointDetailDO.setUserId(pointObtainDetailVO.getUserId());
        }

        pointDetailDO.setSellerId(pointObtainDetailVO.getSellerId());
        List<PointDetailDO> pointDetailDOList = new ArrayList<PointDetailDO>();
        PageHelper.startPage(start, pageSize);
        try {
            pointDetailDOList = pointObtainDetailDAO.selectPointObtainDetails(pointDetailDO);
        } catch (Exception e) {
            logger.error("queryPointObtainDetail error.", e);
        }

        return new PageInfo(pointDetailDOList);
    }

    /**
     * 向用户发送微信信息
     *
     * @param sendWxMessage
     * @return
     */
    public int sendWxMessageToUser(SendWxMessage sendWxMessage) {

        int code = -1;
        try {
            sendWxMessage.setSellerId(sendWxMessage.getSellerId());
            WXAdapter.sendUserMssage(sendWxMessage);
            code = 0;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return code;
    }

    /**
     * 获取积分兑换明细
     *
     * @param pointObtainDetailVO
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo queryPointExchangenDetail(PointDetailVO pointObtainDetailVO, Integer start, Integer pageSize) {
        PointDetailDO pointDetailDO = new PointDetailDO();
        if (StringUtils.isNotEmpty(pointObtainDetailVO.getUserId())) {
            pointDetailDO.setUserId(pointObtainDetailVO.getUserId());
        }
        List<PointDetailDO> pointDetailDOList = new ArrayList<PointDetailDO>();
        pointDetailDO.setSellerId(pointObtainDetailVO.getSellerId());
        PageHelper.startPage(start, pageSize);
        try {
            pointDetailDOList = pointObtainDetailDAO.selectPointExchangeDetails(pointDetailDO);
        } catch (Exception e) {
            logger.error("queryPointExchangenDetail error.", e);
        }

        return new PageInfo(pointDetailDOList);
    }


//    /**
//     * 分页查询用户查询积分记录
//     *
//     * @param wxMessageQueryVO
//     * @param start
//     * @param pageSize
//     * @return
//     */
//    public PageInfo queryPointQueryServiceDetail(WXMessageQueryVO wxMessageQueryVO, Integer start, Integer pageSize) {
//        PointMessageQueryDO pointMessageQueryDO = new PointMessageQueryDO();
//        if (StringUtils.isNotEmpty(wxMessageQueryVO.getWxNickName())) {
//            pointMessageQueryDO.setWxNickName(wxMessageQueryVO.getWxNickName());
//        }
//        if (StringUtils.isNotEmpty(wxMessageQueryVO.getBizType())) {
//            pointMessageQueryDO.setBizType(wxMessageQueryVO.getBizType());
//        }
//        if (StringUtils.isNotEmpty(wxMessageQueryVO.getMobile())) {
//            pointMessageQueryDO.setMobile(wxMessageQueryVO.getMobile());
//        }
//
//
//        PageHelper.startPage(start, pageSize);
//        List<PointMessageQueryDO> pointMessageQueryDOList = pointMessageQueryDAO.selectUserPointMessageQuery(pointMessageQueryDO);
//        return new PageInfo(pointMessageQueryDOList);
//    }


    /**
     * 分页查询签到积分明细
     *
     * @param orderBy  排序关键字
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo querySignPointDetail(Long sellerId, String orderBy, Integer start, Integer pageSize) {
        SignInPointQueryDO signInPointQueryDO = new SignInPointQueryDO();
        if (StringUtils.isNotEmpty(orderBy)) {
            signInPointQueryDO.setOrderBy(orderBy);
        }
        List<SignInPointQueryDO> pointQueryDOList = new ArrayList<SignInPointQueryDO>();

        signInPointQueryDO.setSellerId(sellerId);

        PageHelper.startPage(start, pageSize);
        try {
            pointQueryDOList = signPointQueryDAO.selectSignPointDetail(signInPointQueryDO);
        } catch (Exception e) {
            logger.error("querySignPointDetail error.", e);
        }

        return new PageInfo(pointQueryDOList);
    }


}
