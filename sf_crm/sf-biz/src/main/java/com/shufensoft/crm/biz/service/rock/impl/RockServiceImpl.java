package com.shufensoft.crm.biz.service.rock.impl;


import com.github.pagehelper.PageHelper;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.point.PointObtainMapper;
import com.shufensoft.crm.biz.dao.generation.shake.ShakeDetailMapper;
import com.shufensoft.crm.biz.dao.generation.shake.ShakeObtainMapper;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.point.PointObtain;
import com.shufensoft.crm.biz.domain.generation.point.PointObtainExample;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoods;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeDetail;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeDetailExample;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeObtain;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeObtainExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.hongbao.HongBaoBizService;
import com.shufensoft.crm.biz.service.hongbao.helper.PointHelper;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.pointmall.face.MallGoodsService;
import com.shufensoft.crm.biz.service.rock.RockService;
import com.shufensoft.crm.biz.service.rock.vo.RockConfigVO;
import com.shufensoft.crm.common.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/8 下午2:56  
 */
@Service(value = "rockService")
public class RockServiceImpl implements RockService {

    /**
     * 规则配置Mapper
     */
    @Autowired
    private ShakeDetailMapper shakeDetailMapper;

    @Autowired
    private IPointService pointService;


    @Autowired
    private PointObtainMapper pointObtainMapper;

    @Autowired
    private ShakeObtainMapper shakeObtainMapper;

    @Autowired
    private MallGoodsService mallGoodsService;


    @Autowired
    private HongBaoBizService hongBaoBizService;



    private static final Logger logger = Logger.getLogger(RockServiceImpl.class);

    @Transactional
    public void saveOrUpdateRockConfig(RockConfigVO rockConfigVO) {


        try {

            ShakeDetail rockDetail = new ShakeDetail();
            BeanCopierUtils.copyProperties(rockConfigVO, rockDetail);

            if (rockConfigVO.getHbPoolId() != null) {
                int code = hongBaoBizService.updateHbObtainStatusByHbPollId(rockConfigVO.getSellerId(), rockConfigVO.getHbPoolId(), DaoConstant.HBPoolStatus.USING);

                if (1 != code) {
                    logger.info("saveOrUpdateRockConfig 更新红包池状态失败。");
                    throw new ServiceException("更新红包池状态失败.");
                }
            }

            List<ShakeDetail> rockDetailList = null;
            ShakeDetailExample rockDetailExample = new ShakeDetailExample();

            if (rockConfigVO.getId() != null) {

                rockDetailExample.createCriteria().andIdEqualTo(rockConfigVO.getId()).andSellerIdEqualTo(rockConfigVO.getSellerId());
                rockDetailList = shakeDetailMapper.selectByExample(rockDetailExample);
            }

            Long rockId = null;
            if (rockDetailList != null && !rockDetailList.isEmpty()) {

                setGoodsInfo(rockConfigVO, rockDetail);

                shakeDetailMapper.updateByExampleSelective(rockDetail, rockDetailExample);
                pointService.deletePointObtain(rockConfigVO.getSellerId(), Long.valueOf(rockDetailList.get(0).getRockId()));

                rockId = Long.valueOf(rockDetailList.get(0).getRockId());

            } else {
                rockDetail.setCreateTime(new Date());
                rockDetail.setRockId(DateConvertUtils.dateToStrSerial(new Date()) + CommonUtil.getRandomCode(10, 99));
                rockDetail.setSellerId(rockConfigVO.getSellerId());
                rockDetail.setStatus("Y");

                setGoodsInfo(rockConfigVO, rockDetail);

                shakeDetailMapper.insertSelective(rockDetail);

                rockId = Long.valueOf(rockDetail.getRockId());

            }

            // 初始化积分获取明细
            if (rockConfigVO.getGetPointNum() != null) {

                for (int i = 1; i <= rockConfigVO.getGetPointNum(); i++) {

                    if (rockConfigVO.getPointIntervalMin() != null && rockConfigVO.getPointIntervalMax() != null) {
                        Integer code = CommonUtil.getRandomCode(rockConfigVO.getPointIntervalMin(), rockConfigVO.getPointIntervalMax());

                        pointService.createPointObtain(rockConfigVO.getSellerId(), Long.valueOf(0), Long.valueOf(code), DaoConstant.PointObtainMethod.SHAKE, rockId);
                    }
                }
            }

        } catch (Exception e) {

            throw new ServiceException("RockService.saveOrUpdateRockConfig() is error.", e);

        }

    }


    private void setGoodsInfo(RockConfigVO rockConfigVO, ShakeDetail rockDetail) {
        String goodsId = "";

        String goodsName = "";
        if (StringUtils.isNotEmpty(rockConfigVO.getGoodsId_1())) {
            goodsId = goodsId + rockConfigVO.getGoodsId_1() + "&";
        }

        if (StringUtils.isNotEmpty(rockConfigVO.getGoodsId_2())) {
            goodsId = goodsId + rockConfigVO.getGoodsId_2() + "&";
        }

        if (StringUtils.isNotEmpty(rockConfigVO.getGoodsId_3())) {
            goodsId = goodsId + rockConfigVO.getGoodsId_3() + "&";
        }

        if (StringUtils.isNotEmpty(rockConfigVO.getGoodsId_4())) {
            goodsId = goodsId + rockConfigVO.getGoodsId_4() + "&";
        }

        if (StringUtils.isNotEmpty(rockConfigVO.getGoodsId_5())) {
            goodsId = goodsId + rockConfigVO.getGoodsId_5();
        }


        if (StringUtils.isNotEmpty(rockConfigVO.getGoodsName_1())) {
            goodsName = goodsName + rockConfigVO.getGoodsName_1() + "&";
        }

        if (StringUtils.isNotEmpty(rockConfigVO.getGoodsName_2())) {
            goodsName = goodsName + rockConfigVO.getGoodsName_2() + "&";
        }

        if (StringUtils.isNotEmpty(rockConfigVO.getGoodsName_2())) {
            goodsName = goodsName + rockConfigVO.getGoodsName_2() + "&";
        }

        if (StringUtils.isNotEmpty(rockConfigVO.getGoodsName_2())) {
            goodsName = goodsName + rockConfigVO.getGoodsName_2() + "&";
        }

        if (StringUtils.isNotEmpty(rockConfigVO.getGoodsName_2())) {
            goodsName = goodsName + rockConfigVO.getGoodsName_2();
        }

        rockDetail.setGoodsId(goodsId);
        rockDetail.setGoodsName(goodsName);
    }

    /**
     * 摇一摇积分领取过期处理
     */
    @Transactional
    public void shakeExpired(Long sellerId) {

        ShakeObtainExample shakeObtainExample = new ShakeObtainExample();
        ShakeObtainExample.Criteria criteria = shakeObtainExample.createCriteria();
        criteria.andShakeDateLessThanOrEqualTo(DateUtil.getExpiredMinute(-30));
        criteria.andRockTypeEqualTo(DaoConstant.ShakeBizType.SHAKE_POINT);
        criteria.andShakeStatusEqualTo(DaoConstant.ShakeObtainStatus.TO_RECEIVE);
        criteria.andSellerIdEqualTo(sellerId);
        List<ShakeObtain> shakeObtainList = shakeObtainMapper.selectByExample(shakeObtainExample);

        for (ShakeObtain shakeObtain : shakeObtainList) {

            PointObtainExample pointObtainExample = new PointObtainExample();
            pointObtainExample.createCriteria().andIdEqualTo(shakeObtain.getObtainId());
            PointObtain pointObtain = new PointObtain();
            pointObtain.setUserId(Long.valueOf(0));


            int pointCode = pointObtainMapper.updateByExampleSelective(pointObtain, pointObtainExample);


            shakeObtain.setShakeStatus(DaoConstant.ShakeObtainStatus.EXPIRED);


            int shakeCode = shakeObtainMapper.updateByPrimaryKey(shakeObtain);

            if (pointCode != 1 || shakeCode != 1) {

                throw new ServiceException("摇一摇更新过期积分异常。");
            }

            /**
             * 更新积分领取数量
             */
            PointHelper.incrementPointNum(shakeObtain.getRockId());

        }

    }

    /**
     * 根据类型和rockid查询摇一摇配置
     *
     * @param sellerId
     * @param rockId
     * @return
     */
    public ShakeDetail queryShakeConfig(Long sellerId, String rockId) {

        //@todo 1、根据rockID查询摇一摇配置
        ShakeDetailExample rockDetailExample = new ShakeDetailExample();
        rockDetailExample.createCriteria().andRockIdEqualTo(rockId).andSellerIdEqualTo(sellerId);
        List<ShakeDetail> rockDetailList = shakeDetailMapper.selectByExample(rockDetailExample);
        if (rockDetailList == null || rockDetailList.isEmpty()) {
            throw new ServiceException("未找到摇一摇活动配置。");
        }

        ShakeDetail rockDetail = rockDetailList.get(0);


        return rockDetail;

    }

    /**
     * 获取30分钟有效期内待领的摇一摇奖品
     *
     * @param userId 用户ID
     * @return
     */
    private List<ShakeObtain> getToShakeObtainIdList(Long sellerId, Long userId) {
        ShakeObtainExample shakeObtainExample = new ShakeObtainExample();
        ShakeObtainExample.Criteria criteria = shakeObtainExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andShakeDateLessThan(DateUtil.getExpiredMinute(-30));
        criteria.andSellerIdEqualTo(sellerId);

        List<ShakeObtain> shakeObtainList = shakeObtainMapper.selectByExample(shakeObtainExample);

        if (shakeObtainList != null && !shakeObtainList.isEmpty()) {
            return shakeObtainList;
        }

        return null;
    }

    /**
     * 领取摇一摇礼物，有效期30分钟之内的，过期不领取。
     *
     * @param sellerId
     * @param userId
     * @return
     */
    public int obtainShake(Long sellerId, Long userId) {

        int code = -1;
        try {
            List<ShakeObtain> shakeObtainList = getToShakeObtainIdList(sellerId, userId);
            if (shakeObtainList != null && !shakeObtainList.isEmpty()) {
                for (ShakeObtain shakeObtain : shakeObtainList) {

                    // 领取
                    obtainPoint(sellerId, userId, shakeObtain.getRockType(), shakeObtain.getObtainId());
                }

                return shakeObtainList.size();
            }
        } catch (Exception e) {

            logger.error("obtainShake error.");
        }


        return code;

    }


    /**
     * 过期更新状态
     *
     * @param rockId 摇一摇ID
     */
    public void shakeEnd(Long sellerId, String rockId) {
        ShakeDetailExample shakeDetailExample = new ShakeDetailExample();
        shakeDetailExample.createCriteria().andStatusEqualTo("Y").andRockIdEqualTo(rockId).andSellerIdEqualTo(sellerId);
        List<ShakeDetail> shakeDetails = shakeDetailMapper.selectByExample(shakeDetailExample);

        if (shakeDetails != null && !shakeDetails.isEmpty()) {

            ShakeDetail shakeDetail = new ShakeDetail();
            shakeDetail.setStatus("N");

            shakeDetailMapper.updateByExampleSelective(shakeDetail, shakeDetailExample);
        }

    }

    /**
     * 查检是否还可以摇积分
     *
     * @param userId      用户ID
     * @param rockId      摇一摇活动ID
     * @param getPointNum 每人摇一摇的次数限制
     * @return
     */
    public boolean isObtailPoint(Long sellerId, Long userId, Long rockId, Long getPointNum) {

        List<PointObtain> pointObtainList = getPointObtainByMethodId(sellerId, rockId, userId);

        if (pointObtainList != null && !pointObtainList.isEmpty()) {

            if (getPointNum >= pointObtainList.size()) {

                return false;
            } else {

                return true;
            }
        } else {

            return true;
        }
    }


    /**
     * 根据摇一摇ID，获取可抽取积分的人数
     *
     * @param rockId 摇一摇活动ID
     * @return 数量
     */
    public int queryPointCountByRockId(Long sellerId, Long rockId) {
        List<PointObtain> pointObtainList = getPointObtainByMethodId(sellerId, rockId, null);
        if (pointObtainList != null && !pointObtainList.isEmpty()) {
            return pointObtainList.size();
        }
        return 0;
    }


    public List<PointObtain> getPointObtainByMethodId(Long sellerId, Long rockId, Long userId) {
        PointObtainExample pointObtainExample = new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        } else {
            criteria.andUserIdEqualTo(Long.valueOf(0));
        }
        criteria.andObtainMethodIdEqualTo(rockId);
        criteria.andSellerIdEqualTo(sellerId);

        return pointObtainMapper.selectByExample(pointObtainExample);
    }

    /**
     * 摇一摇动作
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     * @param type     摇一摇类型
     * @param rockId   摇一摇活动ID
     * @param isObtain 是否领取，Y:领取，N：待领取
     * @return
     */
    @Transactional
    public Long doShake(Long sellerId, Long userId, String type, Long rockId, String isObtain) {


        Long code = -1l;


        try {

            if (DaoConstant.ShakeBizType.SHAKE_POINT.equals(type)) {

                // 绑定积分，返回记录ID
                Long obtainId = pointService.updatePointObtain(sellerId, userId, rockId, isObtain);

                // 如果绑定成功，记摇一摇记录
                if (obtainId != -1) {

                    insertShakeObtain(sellerId, userId, type, rockId, obtainId, isObtain);

                    return obtainId;
                }

            }
        } catch (Exception e) {

            throw new ServiceException("摇一摇异常,回退。");
        }

        return code;
    }


    /**
     * 根据获取明细ID更新摇一摇领出记录
     *
     * @param pointObtainId 获取明细ID，积分表ID、红包表ID、礼表ID
     * @param type          point/hongbao/gift
     * @param resultValue   结果：如礼物名称、积分数、现金数
     * @return
     */
    @Override
    public int updateShakeObtain(Long sellerId, Long pointObtainId, String type, String resultValue) {

        int code = -1;

        try {

            ShakeObtainExample shakeObtainExample = new ShakeObtainExample();
            ShakeObtainExample.Criteria criteria = shakeObtainExample.createCriteria();
            criteria.andObtainIdEqualTo(pointObtainId);
            criteria.andSellerIdEqualTo(sellerId);
            ShakeObtain shakeObtain = new ShakeObtain();
            shakeObtain.setShakeStatus(DaoConstant.ShakeObtainStatus.RECEIVED);

            if (DaoConstant.ShakeBizType.SHAKE_POINT.equals(type)) {

                shakeObtain.setRockResult(resultValue + "积分");
            } else if (DaoConstant.ShakeBizType.SHAKE_HB.equals(type)) {

                shakeObtain.setRockResult(resultValue + "元现金红包");
            } else if (DaoConstant.ShakeBizType.SHAKE_GIFT.equals(type)) {

                shakeObtain.setRockResult(resultValue);
            }

            code = shakeObtainMapper.updateByExampleSelective(shakeObtain, shakeObtainExample);

        } catch (Exception e) {

            logger.error("RockService.updateShakeObtain() is error.", e);
        }


        return code;


    }

    /**
     * 插入摇一摇活动领取记录
     *
     * @param userId   用户ID
     * @param type     摇一摇类型， 积分：POINT,红包：HB，礼物：GIFT
     * @param rockId   摇一摇活动ID
     * @param obtainId 摇到的结果ID
     * @param isObtain 是否领取 toReceive:待领取，received:已领取
     */
    @Transactional
    public void insertShakeObtain(Long sellerId, Long userId, String type, Long rockId, Long obtainId, String isObtain) {
        ShakeDetailExample rockDetailExample = new ShakeDetailExample();
        rockDetailExample.createCriteria().andRockIdEqualTo(String.valueOf(rockId)).andSellerIdEqualTo(sellerId);

        List<ShakeDetail> rockDetailList = shakeDetailMapper.selectByExample(rockDetailExample);

        if (rockDetailList != null && !rockDetailList.isEmpty()) {

            ShakeDetail rockDetail = rockDetailList.get(0);
            ShakeObtain shakeObtain = new ShakeObtain();
            shakeObtain.setUserId(userId);
            shakeObtain.setRockType(type);
            shakeObtain.setRockId(rockId);
            shakeObtain.setObtainId(obtainId);

            shakeObtain.setRockResult(getObtainValueByObtainIdAndType(sellerId, type, obtainId));

            shakeObtain.setRockTitle(rockDetail.getRockTitle());
            shakeObtain.setShakeStatus(isObtain);
            shakeObtain.setShakeDate(new Date());


            try {

                shakeObtainMapper.insert(shakeObtain);
            } catch (Exception e) {

                throw new ServiceException("插入摇一摇记录表失败，回退");
            }

        }


    }


    /**
     * 根据摇一摇获取Id查询结果
     *
     * @param sellerId 商户ID
     * @param type     类型
     * @param obtainId 获取ID
     * @return
     */
    public String getObtainValueByObtainIdAndType(Long sellerId, String type, Long obtainId) {

        if (DaoConstant.ShakeBizType.SHAKE_POINT.equals(type)) {

            PointObtain pointObtain = pointService.getPointObtainByObtainId(sellerId, obtainId);

            if (pointObtain != null) {
                return pointObtain.getAmount() + "积分";
            }

        } else if (DaoConstant.ShakeBizType.SHAKE_HB.equals(type)) {

            HBObtain hbObtain = hongBaoBizService.findHBObtainByObtainId(obtainId, sellerId);

            if (hbObtain != null) {

                return CommonUtil.longDivide(Long.valueOf(hbObtain.getAmount()), Long.valueOf(100)).toString() + "元现金红包";
            }
        } else if (DaoConstant.ShakeBizType.SHAKE_GIFT.equals(type)) {

            MallGoods mallGoods = mallGoodsService.getMailGoodsByGoodsId(sellerId, obtainId);

            if (mallGoods != null) {
                return mallGoods.getTitle();
            }

        }

        return null;
    }


    /**
     * 是否已领取摇一摇积分
     *
     * @param userId
     * @param pointObtainid
     * @return
     */
    public boolean isObtainShakePoint(Long sellerId, Long userId, Long pointObtainid) {

        PointObtainExample pointObtainExample = new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andIdEqualTo(pointObtainid);
        criteria.andStatusEqualTo(DaoConstant.Status.VALID);

        List<PointObtain> pointObtainList = pointObtainMapper.selectByExample(pointObtainExample);

        if (pointObtainList != null && !pointObtainList.isEmpty()) {

            return true;
        }

        return false;
    }


    @Transactional
    private Long obtainPoint(Long sellerId, Long userId, String type, Long pointObtainId) {

        // 更新积分获取明细表状态为领用,返回领取的积分值
        Long ammount = pointService.updatePointObtain(sellerId, pointObtainId);

        // 更新摇一遥领用表记录为领用
        int code = updateShakeObtain(sellerId, pointObtainId, type, String.valueOf(ammount));

        if (ammount == -1 || code == -1) {

            throw new ServiceException("摇一摇领取异常，回退");
        }

        // 更新用户帐户的积分总数
        int accountCode = pointService.updateUserAccountPoint(sellerId, userId, ammount, "OBTAIN");

        if (accountCode != 1) {

            throw new ServiceException("更新用户帐户表信息失败，回退。");
        }

        return ammount;
    }


    /**
     * 领取摇一摇
     *
     * @param pointObtainId 积分获取ID
     * @return 返回积分数
     */
    public Long doUserObtainShake(Long sellerId, Long userId, Long pointObtainId, String type) {

        Long ammount = -1l;

        try {

            if (DaoConstant.ShakeBizType.SHAKE_POINT.equals(type)) {

                ammount = obtainPoint(sellerId, userId, type, pointObtainId);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }


        return ammount;

    }

    @Override
    public List<ShakeDetail> getShakeDetailList(Long sellerId, Integer pageNum, Integer length) {

        ShakeDetailExample shakeDetailExample = new ShakeDetailExample();
        shakeDetailExample.setOrderByClause(" gmt_modified  desc ");
        shakeDetailExample.createCriteria().andSellerIdEqualTo(sellerId);


        if (pageNum != null && length != null)
            PageHelper.startPage(pageNum, length);

        List<ShakeDetail> shakeDetails = shakeDetailMapper.selectByExample(shakeDetailExample);

        return !CollectionUtils.isEmpty(shakeDetails) ? shakeDetails : new ArrayList<ShakeDetail>();
    }

    @Override
    public List<ShakeObtain> getShakeObtainList(ShakeObtain shakeObtain, Integer pageNum, Integer length) {

        ShakeObtainExample shakeObtainExample = new ShakeObtainExample();
        ShakeObtainExample.Criteria criteria = shakeObtainExample.createCriteria();
        shakeObtainExample.setOrderByClause(" gmt_modified desc ");


        if (shakeObtain.getUserId() != null) {
            criteria.andUserIdEqualTo(shakeObtain.getUserId());
        }

        criteria.andSellerIdEqualTo(shakeObtain.getSellerId());

        if (pageNum != null && length != null)
            PageHelper.startPage(pageNum, length);

        List<ShakeObtain> shakeObtains = shakeObtainMapper.selectByExample(shakeObtainExample);

        return !CollectionUtils.isEmpty(shakeObtains) ? shakeObtains : new ArrayList<ShakeObtain>();
    }


    /**
     * 根据红包池ID查询RockId
     *
     * @param sellerId 商户ID
     * @param hbPollId 红包池ID
     * @return
     */
    public String getRockIdByHbPollId(Long sellerId, Long hbPollId) {
        ShakeDetailExample shakeDetailExample = new ShakeDetailExample();
        ShakeDetailExample.Criteria criteria = shakeDetailExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andHbPoolIdEqualTo(hbPollId);

        List<ShakeDetail> shakeDetailList = shakeDetailMapper.selectByExample(shakeDetailExample);

        if (CollectionUtils.isEmpty(shakeDetailList)) {
            return null;
        }

        return shakeDetailList.get(0).getRockId();
    }


}
