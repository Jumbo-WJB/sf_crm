package com.shufensoft.crm.biz.service.contactCustomer.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.adapter.WXAdapter;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.constant.SmsConstant;
import com.shufensoft.crm.biz.dao.defined.marketActivity.MarketRecordsDAO;
import com.shufensoft.crm.biz.dao.generation.marketActivity.MarketActivityMapper;
import com.shufensoft.crm.biz.dao.generation.marketActivity.MarketRecordsMapper;
import com.shufensoft.crm.biz.dao.generation.reply.WxMediaMapper;
import com.shufensoft.crm.biz.dao.generation.seller.MarketPackageMapper;
import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.defined.marketActivity.MarketRecordsDO;
import com.shufensoft.crm.biz.domain.defined.trade.TradeDO;
import com.shufensoft.crm.biz.domain.defined.user.UserDO;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketActivity;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketActivityExample;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecords;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecordsExample;
import com.shufensoft.crm.biz.domain.generation.reply.WxMedia;
import com.shufensoft.crm.biz.domain.generation.seller.MarketPackage;
import com.shufensoft.crm.biz.domain.generation.seller.MarketPackageExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.send.SendWxArticles;
import com.shufensoft.crm.biz.domain.generation.send.SendWxMessage;
import com.shufensoft.crm.biz.domain.generation.send.WxUploadNews;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.helper.DatasourceHelper;
import com.shufensoft.crm.biz.service.contactCustomer.MarketActivityService;
import com.shufensoft.crm.biz.service.market.MarkBizService;
import com.shufensoft.crm.biz.service.market.MarketService;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.biz.service.send.vo.SmsVO;
import com.shufensoft.crm.biz.service.trade.TradeService;
import com.shufensoft.crm.biz.service.trade.vo.TradeVO;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.MarketActivityVO;
import com.shufensoft.crm.biz.vo.MarketPackageVO;
import com.shufensoft.crm.biz.vo.MarketRecordsVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.runner.BizRunner;
import com.shufensoft.crm.common.runner.executor.BizExecutor;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.PropertyReader;
import com.shufensoft.crm.common.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yuyuchi yuyc@shufensoft.com
 * @ProjectName: sf-crm 
 * @Description: 营销活动服务实现类
 * @date 2015/6/15 21:24
 */
@Service(value = "marketActivityService")
public class MarketActivityServiceImpl implements MarketActivityService {

    @Autowired
    private MarketActivityMapper marketActivityMapper;

    @Autowired
    private MarketRecordsDAO marketRecordsDAO;

    @Autowired
    private MarketRecordsMapper marketRecordsMapper;

    @Autowired
    private SendService sendService;

    @Autowired
    private UserService userService;

    @Autowired
    private MarketPackageMapper marketPackageMapper;

    @Autowired
    private TradeService tradeService;

    @Autowired
    private MarketService marketService;

    @Autowired
    private MarkBizService markBizService;

    @Autowired
    private WxMediaMapper wxMediaMapper;

    private static String WEB_URL = PropertyReader.getValue("crm.web.url");

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(MarketActivityServiceImpl.class);


    @Override
    public PageInfo queryMarketingList(MarketActivityVO marketActivityVO, Integer pageNum, Integer length) {
        if (marketActivityVO.getSellerId() == null) {
            throw new ServiceException("sellerId Can't be null");
        }

        MarketActivityExample example = new MarketActivityExample();
        MarketActivityExample.Criteria criteria = example.createCriteria();

        criteria.andSellerIdEqualTo(marketActivityVO.getSellerId());
        if (StringUtils.isNotBlank(marketActivityVO.getType())) {
            criteria.andTypeEqualTo(marketActivityVO.getType());
        }

        PageHelper.startPage(pageNum, length);
        List<MarketActivity> list = marketActivityMapper.selectByExample(example);
        for (MarketActivity activity : list) {
            activity.setSuccessRate(markBizService.sendSucRate(marketActivityVO.getSellerId(),
                    marketActivityVO.getType(), activity.getActivityId()));
            if ("email".equals(marketActivityVO.getType())) {
                activity.setOpenRate(markBizService.sendEmailOpenRate(marketActivityVO.getSellerId(),
                        marketActivityVO.getType(), activity.getActivityId()));
            }
        }

        return new PageInfo(list);
    }

    @Override
    public MarketActivity saveOrUpdateActivity(MarketActivityVO marketActivityVO) {

        if (marketActivityVO.getSellerId() == null) {
            throw new ServiceException("sellerId Can't be null");
        }

        MarketActivity activity = new MarketActivity();
        try {
            BeanCopierUtils.copyProperties(marketActivityVO, activity);
        } catch (Exception e) {
            throw new ServiceException("MarketActivityServiceImpl.saveOrUpdateActivity ", e);
        }

        if (marketActivityVO.getActivityId() != null) {
            marketActivityMapper.updateByPrimaryKeySelective(activity);
        } else {
            marketActivityMapper.insertSelective(activity);
        }

        List<MarketRecords> recordList = marketActivityVO.getRecordsList();

        if (recordList != null && !recordList.isEmpty()){
            for (MarketRecords record : recordList){
                record.setActivityId(activity.getActivityId());
                marketRecordsMapper.insertSelective(record);
            }
        }

        return activity;
    }

    @Override
    public PageInfo queryMarketActivity(MarketRecordsVO marketRecordsVO, Integer pageNum, Integer length) {

        if (marketRecordsVO.getSellerId() == null) {
            throw new ServiceException("sellerId Can't be null");
        }

        MarketRecordsDO mrd = new MarketRecordsDO();
        mrd.setSellerId(marketRecordsVO.getSellerId());
        if (StringUtils.isNotBlank(marketRecordsVO.getType())) {
            mrd.setType(marketRecordsVO.getType());
        }
        if (StringUtils.isNotBlank(marketRecordsVO.getActivityTitle())) {
            mrd.setActivityTitle(marketRecordsVO.getActivityTitle());
        }
        if (StringUtils.isNotBlank(marketRecordsVO.getIsSuccess())) {
            mrd.setIsSuccess(marketRecordsVO.getIsSuccess());
        }
        if (marketRecordsVO.getStartTime() != null && marketRecordsVO.getEndTime() != null) {
            mrd.setStartTime(marketRecordsVO.getStartTime());
            mrd.setEndTime(marketRecordsVO.getEndTime());
        }
        if (marketRecordsVO.getActivityId() != null) {
            mrd.setActivityId(marketRecordsVO.getActivityId());
        }

        PageHelper.startPage(pageNum, length);
        List<MarketRecordsDO> list = marketRecordsDAO.queryActivity(mrd);

        return new PageInfo(list);
    }


    /**
     * @param marketActivityVO
     * @return
     */
    @Transactional
    public MarketActivity addActivityInfo(MarketActivityVO marketActivityVO, Map<String, Object> map, MarketActivity marketActivity) {

        /**
         * 获得用户id，号码或邮箱
         */
        List<String> infoList = (List<String>) map.get("infoList");
        List<String> idList = (List<String>) map.get("idList");

        /**
         *  向market_activity表中添加数据
         */

        if (marketActivity == null) {
            marketActivity = new MarketActivity();
            BeanCopierUtils.copyProperties(marketActivityVO, marketActivity);

            marketActivity.setWxPersonCount(idList.size());
            marketActivity.setExecuteType(marketActivityVO.getExeTimeType());

            if ("0".equals(marketActivityVO.getExeTimeType())) {
                marketActivity.setExecuteTime(new Date());
            }


            try {
                marketActivityMapper.insertSelective(marketActivity);
                marketActivityVO.setActivityId(marketActivity.getActivityId());
                logger.info("保存成功一次");
            } catch (Exception e) {
                throw new ServiceException("保存营销活动失败");
            }
        } else {
            MarketActivityExample example = new MarketActivityExample();
            example.createCriteria().andActivityIdEqualTo(marketActivity.getActivityId()).andSellerIdEqualTo(marketActivity.getSellerId());
            List<MarketActivity> list = marketActivityMapper.selectByExample(example);
            MarketActivity activity = list.get(0);
            activity.setWxPersonCount(activity.getWxPersonCount() + idList.size());
            marketActivityMapper.updateByExampleSelective(activity, example);
        }

        if ("0".equals(marketActivityVO.getExeTimeType())) {
            if ("sms".equals(marketActivityVO.getType())) {
                sendSms(marketActivityVO, infoList);

            } else if ("email".equals(marketActivityVO.getType())) {
                sendEmail(marketActivityVO, infoList);
            }

            if (DaoConstant.MarketSendStatus.SUCCESS.equals(marketActivityVO.getIsSuccess())) {

                marketService.updateMarketActivity(marketActivity.getSellerId(), marketActivity.getActivityId(), DaoConstant.MarketSendStatus.SUCCESS);

            } else {
                marketService.updateMarketActivity(marketActivity.getSellerId(), marketActivity.getActivityId(), DaoConstant.MarketSendStatus.FAILED);

            }
        } else {
            marketService.updateMarketActivity(marketActivity.getSellerId(), marketActivity.getActivityId(), DaoConstant.MarketSendStatus.TOSEND);
            marketActivityVO.setIsSuccess(DaoConstant.MarketSendStatus.TOSEND);
        }


        try {
            //短信营销
            if ("sms".equals(marketActivityVO.getType())) {
                for (int i = 0; i < idList.size(); i++) {

                    /**如果成功，更新user_portrait表中的短信发送次数和周期*/
                    if (DaoConstant.MarketSendStatus.SUCCESS.equals(marketActivityVO.getIsSuccess())) {
                        userService.updateUserPortrait(marketActivity.getSellerId(), Long.valueOf(idList.get(i)), "SMS");
                    }

                    /**
                     * 保存营销记录
                     */
                    MarketRecords records = new MarketRecords();
                    records.setActivityId(marketActivity.getActivityId());
                    records.setSellerId(marketActivity.getSellerId());
                    records.setActivityTitle(marketActivityVO.getTitle());
                    records.setIsSuccess(marketActivityVO.getIsSuccess());
                    records.setType(marketActivityVO.getType());
                    records.setExecuteTime(marketActivityVO.getExecuteTime());
                    records.setIsOpen(DaoConstant.MarketSendStatus.UNOPEND);
                    if ("0".equals(marketActivityVO.getExeTimeType())) {
                        records.setExecuteTime(new Date());
                    }
                    records.setUserId(Long.parseLong(idList.get(i)));
                    records.setMobile(infoList.get(i));
                    records.setEmail("");
                    marketRecordsMapper.insertSelective(records);
                }
                //邮箱营销
            } else if ("email".equals(marketActivityVO.getType())) {
                for (int i = 0; i < idList.size(); i++) {
                    /**如果成功，更新user_portrait表中的邮件发送次数和周期*/
                    if (DaoConstant.MarketSendStatus.SUCCESS.equals(marketActivityVO.getIsSuccess())) {
                        userService.updateUserPortrait(marketActivity.getSellerId(), Long.valueOf(idList.get(i)), "MAIL");
                    }

                    /**
                     * 保存营销记录
                     */
                    MarketRecords records = new MarketRecords();
                    records.setActivityId(marketActivity.getActivityId());
                    records.setSellerId(marketActivity.getSellerId());
                    records.setActivityTitle(marketActivityVO.getTitle());
                    records.setIsSuccess(marketActivityVO.getIsSuccess());
                    records.setType(marketActivityVO.getType());
                    records.setExecuteTime(marketActivityVO.getExecuteTime());
                    records.setIsOpen(DaoConstant.MarketSendStatus.UNOPEND);
                    if ("0".equals(marketActivityVO.getExeTimeType())) {
                        records.setExecuteTime(new Date());
                    }
                    records.setUserId(Long.parseLong(idList.get(i)));
                    records.setMobile("");
                    records.setEmail(infoList.get(i));
                    marketRecordsMapper.insertSelective(records);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("保存营销明细失败");
        }
        return marketActivity;
    }

    @Override
    public List<MarketActivity> findActivity(Long activityId, Long sellerId) {
        MarketActivityExample example = new MarketActivityExample();
        MarketActivityExample.Criteria criteria = example.createCriteria();

        criteria.andSellerIdEqualTo(sellerId);
        if (activityId != null) {
            criteria.andActivityIdEqualTo(activityId);
        }
        List<MarketActivity> list;
        try {
            list = marketActivityMapper.selectByExample(example);
        } catch (Exception e) {
            throw new ServiceException("查找营销活动异常：" + e);
        }
        return list;
    }

    @Override
    public int saveEdit(MarketActivityVO marketActivityVO) {
        MarketActivity marketActivity = (MarketActivity) BeanCopierUtils.copyProperties(marketActivityVO, MarketActivity.class);
        MarketActivityExample example = new MarketActivityExample();
        MarketActivityExample.Criteria criteria = example.createCriteria();

        if (marketActivity.getActivityId() != null) {
            criteria.andActivityIdEqualTo(marketActivity.getActivityId());
        }

        int result;
        try {
            result = marketActivityMapper.updateByExampleSelective(marketActivity, example);
        } catch (Exception e) {
            throw new ServiceException("保存异常：" + e);
        }
        return result;
    }

    public Boolean deleteActivity(Long activityId, Long sellerId) {
        MarketActivityExample example = new MarketActivityExample();
        example.createCriteria().andSellerIdEqualTo(sellerId).andActivityIdEqualTo(activityId);

        List<MarketActivity> list = marketActivityMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }

        MarketActivity activity = list.get(0);
        if (DaoConstant.MarketSendStatus.TOSEND.equals(activity.getStatus())) {
            marketService.updateMarketActivity(sellerId, activityId, DaoConstant.MarketSendStatus.CANCEL);
        }
        marketActivityMapper.deleteByExample(example);
        return true;
    }

    @Override
    public PageInfo queryMarketPackage(MarketPackageVO marketPackageVO, Integer pageNum, Integer length) {
        MarketPackageExample example = new MarketPackageExample();
        MarketPackageExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(marketPackageVO.getPackageType())) {
            criteria.andPackageTypeEqualTo(marketPackageVO.getPackageType());
        }

        PageHelper.startPage(pageNum, length);
        List<MarketPackage> list = marketPackageMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            logger.info("营销套餐表为空");
        }
        return new PageInfo(list);
    }

    /**
     * 异步执行
     * 根据传入的营销方式type来选择发送的方式（短信，邮件，微信等）,并保存营销活动
     */
    public Boolean sendMarketing(UserVO userVO, MarketActivityVO marketActivityVO) {

        final MarketActivityVO marketVO = marketActivityVO;
        final UserVO userModel = userVO;
        final String dataSourceKey = DBContextHolder.getDataSourceKey();
        try {
            new BizRunner(new BizExecutor() {
                @Override
                public Boolean execute() {
                    DBContextHolder.setDataSourceKey(dataSourceKey);
                    String isAll = userModel.getIsSelectAll();
                    String userParams = userModel.getUserParams();
                    String type = marketVO.getType();
                    Map<String, Object> map = Maps.newHashMap();
                    /**如果全选，用户多是则分页处理*/
                    if (isAll.equals("1")) {
                        int start = 1;
                        int pageSize = 40;
                        MarketActivity marketActivity = null;
                        while (true) {
                            PageInfo pageInfo;
                            /**区分成功购买客户和潜在购买客户(潜在购买客户没有邮箱)*/
                            if ("1".equals(userModel.getIsSuccessCustom())) {
                                pageInfo = userService.queryUserWithPortrait(userModel, start, pageSize);
                            } else {
                                TradeVO tradeVO = new TradeVO();
                                tradeVO.setSellerId(userModel.getSellerId());
                                tradeVO.setKeyword(userModel.getKeyword());
                                tradeVO.setReceiverName(userModel.getName());
                                tradeVO.setTradeSource(userModel.getFirstSource());
                                tradeVO.setOrderClause(userModel.getOrderClause());
                                tradeVO.setHasMobile(userModel.getHasMobile());
                                tradeVO.setLastDays(StringUtils.isBlank(userModel.getTime()) ? null : Integer.valueOf(userModel.getTime()));
                                if (StringUtils.isNotBlank(userModel.getMaxPrice())) {
                                    tradeVO.setMaxPrice(new BigDecimal(userModel.getMaxPrice()));
                                }

                                if (StringUtils.isNotBlank(userModel.getMinPrice())) {
                                    tradeVO.setMinPrice(new BigDecimal(userModel.getMinPrice()));
                                }

                                pageInfo = tradeService.selectTradeFromAll(tradeVO, start, pageSize);
                            }

                            if (pageInfo == null) {
                                break;
                            }
                            List list = pageInfo.getList();
                            if (CollectionUtils.isEmpty(list)) {
                                break;
                            }
                            List<String> idList = new ArrayList<String>();
                            List<String> infoList = new ArrayList<String>();

                            List<String> paramsList = new ArrayList<String>();
                            if (StringUtils.isNotBlank(userParams)) {
                                paramsList = (List<String>) StringUtils.getInfoMap(userParams).get("infoList");
                            }

                            if ("sms".equals(type)) {

                                for (int i = 0; i < list.size(); i++) {
                                    if ("1".equals(userModel.getIsSuccessCustom())) {
                                        UserDO user = (UserDO) list.get(i);
                                        if (StringUtils.isNotBlank(user.getMobile()) && !infoList.contains(user.getMobile())
                                                && !paramsList.contains(user.getMobile())) {
                                            infoList.add(user.getMobile());
                                            idList.add(user.getUserId().toString());
                                        }
                                    } else {
                                        TradeDO trade = (TradeDO) list.get(i);
                                        if (StringUtils.isNotBlank(trade.getMobile()) && !infoList.contains(trade.getMobile())
                                                && !paramsList.contains(trade.getMobile())) {
                                            infoList.add(trade.getMobile());
                                            idList.add(trade.getTid().toString());
                                        }
                                    }
                                }
                                map.put("infoList", infoList);
                                map.put("idList", idList);

                            } else if ("email".equals(type)) {
                                for (int i = 0; i < list.size(); i++) {
                                    UserDO user = (UserDO) list.get(i);
                                    if (StringUtils.isNotBlank(user.getEmail()) && !infoList.contains(user.getEmail())
                                            && !paramsList.contains(user.getEmail())) {
                                        infoList.add(user.getEmail());
                                        idList.add(user.getUserId().toString());
                                    }
                                }
                                map.put("infoList", infoList);
                                map.put("idList", idList);
                            }

                            /**保存营销活动*/
                            marketVO.setContentType("text");
                            marketActivity = addActivityInfo(marketVO, map, marketActivity);
                            start++;
                        }
                    } else {
                        //用户手动选择用户
                        map = StringUtils.getInfoMap(userParams);
                        List<String> infoList = (List<String>) map.get("infoList");

                        marketVO.setContentType("text");
                        marketVO.setType(type);
                        addActivityInfo(marketVO, map, null);
                    }
                    return true;
                }
            }).start();
        } catch (Exception e) {
            throw new ServiceException("发送短信异常任务：" + e);
        }
        return true;
    }

    /**
     * 发送短信
     *
     * @param marketVO 参数
     * @param list     手机号列表
     */
    public void sendSms(MarketActivityVO marketVO, List<String> list) {

        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(marketVO.getSellerId()));

        SmsVO smsVO = new SmsVO();
        smsVO.setSellerId(String.valueOf(marketVO.getSellerId()));
        smsVO.setSaleType(marketVO.getTarget());
        smsVO.setTargetNumberList(list);
        smsVO.setSaleTitle(marketVO.getTitle());
        smsVO.setSendType("SMS");
        smsVO.setSendTime(marketVO.getExecuteTime());
        smsVO.setContent(marketVO.getContent());
        smsVO.setActivityId(marketVO.getActivityId());
        // 目前所有的营销的类型都为营销通道，签名用营销签名，后续如有不同这里做判断。
        smsVO.setPassage(DaoConstant.SmsSend.SEND_SALE);
        smsVO.setSign(sellerConfigInfo.getSmsSaleSign());
        smsVO.setFatigue(DaoConstant.SmsFatigueFlag.IS_FATIGUE);

        String smsReturns = sendService.smsSend(smsVO);
        //String smsReturns = "0";

        if (!SmsConstant.SEND_FAILED_CODE.equals(smsReturns)) {

            if (SmsConstant.ACCOUNT_ARREARS_CODE.equals(smsReturns)) {

                logger.info("邮件发送失败，帐户余额不足");

                marketVO.setIsSuccess(DaoConstant.MarketSendStatus.ACCOUNT_ARREARS);
            }else{
                logger.info("短信发送成功，共发送 " + list.size() + " 条");
                marketVO.setIsSuccess(DaoConstant.MarketSendStatus.SUCCESS);
            }

        } else {
            logger.info("短信发送失败");
            marketVO.setIsSuccess(DaoConstant.MarketSendStatus.FAILED);
        }
    }

    /**
     * 发送邮件
     *
     * @param marketVO 参数
     * @param list     邮件列表
     */
    public void sendEmail(MarketActivityVO marketVO, List<String> list) {


        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(marketVO.getSellerId()));

        SmsVO smsVO = new SmsVO();
        smsVO.setSellerId(String.valueOf(String.valueOf(marketVO.getSellerId())));
        smsVO.setSaleType(marketVO.getTarget());
        smsVO.setTargetNumberList(list);
        smsVO.setSaleTitle(marketVO.getTitle());
        smsVO.setSendType("MAIL");
        smsVO.setSendTime(marketVO.getExecuteTime());
        smsVO.setContent(marketVO.getContent());
        smsVO.setSubject(marketVO.getTitle());
        smsVO.setSign(sellerConfigInfo.getEmailSign());
        smsVO.setFrom(sellerConfigInfo.getEmail());
        smsVO.setFromName(sellerConfigInfo.getEmailFromName());
        smsVO.setActivityId(marketVO.getActivityId());
        String smsReturns = sendService.smsSend(smsVO);
        //String smsReturns = "0";
        if (!SmsConstant.SEND_FAILED_CODE.equals(smsReturns)) {

            if (SmsConstant.ACCOUNT_ARREARS_CODE.equals(smsReturns)) {

                logger.info("邮件发送失败，帐户余额不足");

                marketVO.setIsSuccess(DaoConstant.MarketSendStatus.ACCOUNT_ARREARS);
            }

            logger.info("邮件发送成功，共发送 " + list.size() + " 条");
            marketVO.setIsSuccess(DaoConstant.MarketSendStatus.SUCCESS);


        } else {

            logger.info("邮件发送失败");
            marketVO.setIsSuccess(DaoConstant.MarketSendStatus.FAILED);

        }


    }

    /**
     * 根据activityId查询待发送的营销明细
     *
     * @param activityId 营销ID
     * @return
     */
    private List<MarketRecords> getToSendMarketRecords(Long activityId) {
        MarketRecordsExample marketRecordsExample = new MarketRecordsExample();
        marketRecordsExample.createCriteria().andActivityIdEqualTo(activityId);

        return marketRecordsMapper.selectByExample(marketRecordsExample);
    }

    /**
     * 发送微信群发活动,群发接口发送
     * @param marketActivityVO
     * @return
     */
    @Override
    public void sendWxMass(final MarketActivityVO marketActivityVO) {

        /**
         * 1、首先，上传临时多媒体文件，获取thumbMediaId(此处上传的为缩略图)
         */
        String mediaId;
        try {
            mediaId = WXAdapter.getMediaInfo(marketActivityVO.getSellerId(),marketActivityVO.getWxMediaPath(),marketActivityVO.getWxMediaType());
        }catch (Exception e){
            logger.error("MarketActivityServiceImpl sendWxMass上传临时多媒体文件失败", e);
            throw new ServiceException("上传临时多媒体文件失败",e);
        }
        if (StringUtils.isBlank(mediaId)){
            throw new ServiceException("上传临时多媒体文件失败,mediaId为空");
        }

        /**
         * 2、上传图文消息素材（包括多图文和单图文）
         */
        List<WxMedia> wxMedias = new ArrayList<WxMedia>();
        WxMedia media = new WxMedia();
        media.setSellerId(marketActivityVO.getSellerId());
        media.setThumbMediaId(mediaId);
        media.setTitle(marketActivityVO.getTitle());
        media.setContentSourceUrl(marketActivityVO.getUrl());
        media.setContent(marketActivityVO.getContent());
        media.setDigest(marketActivityVO.getTitle());
        media.setShowCoverPic("1");
        wxMedias.add(media);

        WxUploadNews uploadNews = new WxUploadNews();
        uploadNews.setSellerId(marketActivityVO.getSellerId());
        uploadNews.setWxMediaList(wxMedias);

        final String newId;
        try {
            newId = WXAdapter.uploadNews(uploadNews);
            /**
             * 图文消息素材上传成功后，保存上传的图文信息到本地
             */
            for (WxMedia wxMedia : wxMedias){
                wxMediaMapper.insertSelective(wxMedia);
            }
        }catch (Exception e){
            logger.error("MarketActivityServiceImpl sendWxMass上传图文消息素材失败",e);
            throw new ServiceException("上传图文消息素材失败",e);
        }

        if (StringUtils.isBlank(newId)){
            throw new ServiceException("上传图文消息素材失败,mediaId为空");
        }

        /**
         * 3、使用对用户分组的群发，或对OpenID列表的群发，将图文消息群发出去
         * ,此处考虑到用户可能太多，使用异步线程执行发送任务
         */
        new BizRunner(new BizExecutor() {
            @Override
            public Boolean execute() {

                //异步线程需重新设置数据源
                DatasourceHelper.setDatasource(String.valueOf(marketActivityVO.getSellerId()));

                int start = 1;
                int pageSize = 50;
                UserVO userVO = new UserVO();
                userVO.setSellerId(marketActivityVO.getSellerId());
                userVO.setWxSubscribe("1");

                MarketActivity wxActivity = null;
                while (true){

                    /**
                     * 获取用户openid列表
                     */
                    Map<String, List> infoMap = userService.getWxMassToUser(userVO, start, pageSize);
                    if (infoMap == null){
                        break;
                    }

                    List<String> opendIdList = (List<String>)infoMap.get("toUser");

                    /**
                     * 根据openId列表群发图文消息
                     */
                    SendWxMessage wxMessage = new SendWxMessage();
                    wxMessage.setSellerId(marketActivityVO.getSellerId());
                    wxMessage.setSendType("mass");
                    wxMessage.setToUserList(opendIdList);
                    wxMessage.setMsgtype("mpnews");//图文
                    wxMessage.setMediaId(newId);
                    try {
                        WXAdapter.sendUserMssage(wxMessage);
                    }catch (Exception e){
                        logger.error("MarketActivityServiceImpl sendWxMass 群发失败",e);
                    }

                    /**
                     * 微信消息群发成功后，保存营销记录
                     */
                    if (wxActivity == null){
                        marketActivityVO.setContentType("single_image_text");
                        marketActivityVO.setWxMediaId(newId);
                        marketActivityVO.setWxSourceType(DaoConstant.WxMediaType.THUMB);
                        marketActivityVO.setWxPersonCount(opendIdList.size());
                        marketActivityVO.setExecuteTime(new Date());
                        marketActivityVO.setExecuteType("0");
                        marketActivityVO.setStatus(DaoConstant.MarketSendStatus.SUCCESS);
                        marketActivityVO.setWxSourceType(DaoConstant.WxMediaType.THUMB);
                    }else{
                        marketActivityVO.setWxPersonCount(wxActivity.getWxPersonCount()+opendIdList.size());
                        marketActivityVO.setId(wxActivity.getId());
                    }

                    List<Long> userIdList = (List<Long>)infoMap.get("userIdList");

                    List<MarketRecords> recordList = new ArrayList<MarketRecords>();
                    for (Long userId : userIdList){
                        MarketRecords record = new MarketRecords();
                        record.setUserId(userId);
                        record.setIsSuccess(DaoConstant.MarketSendStatus.SUCCESS);
                        record.setIsOpen(DaoConstant.MarketSendStatus.ISOPEND);
                        record.setActivityTitle(marketActivityVO.getTitle());
                        record.setSellerId(marketActivityVO.getSellerId());
                        record.setType("wx");
                        record.setExecuteTime(marketActivityVO.getExecuteTime());
                        recordList.add(record);
                    }
                    marketActivityVO.setRecordsList(recordList);

                    wxActivity = saveOrUpdateActivity(marketActivityVO);

                    start++;
                }
                return true;
            }
        }).start();
    }

    /**
     * 发送微信活动，客服接口发送
     * @param marketActivityVO
     */
    @Override
    public void sendWxCustom(final MarketActivityVO marketActivityVO) {

        /**
         * 此处考虑到用户可能太多，使用异步线程执行发送任务
         */
        new BizRunner(new BizExecutor() {
            @Override
            public Boolean execute() {

                //异步线程需重新设置数据源
                DatasourceHelper.setDatasource(String.valueOf(marketActivityVO.getSellerId()));

                int start = 1;
                int pageSize = 50;
                UserVO userVO = new UserVO();
                userVO.setSellerId(marketActivityVO.getSellerId());

                MarketActivity wxActivity = null;
                while (true){

                    /**
                     * 获取用户openid列表
                     */
                    Map<String, List> infoMap = userService.getWxCustomToUser(userVO,start,pageSize);
                    if (infoMap == null){
                        break;
                    }

                    List<String> opendIdList = (List<String>)infoMap.get("toUser");

                    for (String toUser : opendIdList){
                        SendWxMessage wxMessage = new SendWxMessage();
                        wxMessage.setSellerId(marketActivityVO.getSellerId());
                        wxMessage.setTouser(toUser);
                        wxMessage.setMsgtype("news");//图文
                        List<SendWxArticles> articlesList = new ArrayList<SendWxArticles>();
                        SendWxArticles articles = new SendWxArticles();
                        articles.setTitle(marketActivityVO.getTitle());
                        articles.setUrl(marketActivityVO.getUrl());
                        articles.setPicurl(WEB_URL+marketActivityVO.getWxMediaPath());
                        articles.setDescription(marketActivityVO.getContent());
                        articlesList.add(articles);
                        wxMessage.setSendWxArticlesList(articlesList);
                        try {
                            WXAdapter.sendUserMssage(wxMessage);
                        }catch (Exception e){
                            logger.error("MarketActivityServiceImpl sendWxCustom 调用客服接口发送图文消息失败",e);
                        }
                    }

                    /**
                     * 微信消息群发成功后，保存营销记录
                     */
                    if (wxActivity == null){
                        marketActivityVO.setContentType("single_image_text");
                        marketActivityVO.setWxSourceType(DaoConstant.WxMediaType.THUMB);
                        marketActivityVO.setWxPersonCount(opendIdList.size());
                        marketActivityVO.setExecuteTime(new Date());
                        marketActivityVO.setExecuteType("0");
                        marketActivityVO.setStatus(DaoConstant.MarketSendStatus.SUCCESS);
                        marketActivityVO.setWxSourceType(DaoConstant.WxMediaType.THUMB);
                    }else{
                        marketActivityVO.setWxPersonCount(wxActivity.getWxPersonCount()+opendIdList.size());
                        marketActivityVO.setId(wxActivity.getId());
                    }

                    List<Long> userIdList = (List<Long>)infoMap.get("userIdList");

                    List<MarketRecords> recordList = new ArrayList<MarketRecords>();
                    for (Long userId : userIdList){
                        MarketRecords record = new MarketRecords();
                        record.setUserId(userId);
                        record.setIsSuccess(DaoConstant.MarketSendStatus.SUCCESS);
                        record.setIsOpen(DaoConstant.MarketSendStatus.ISOPEND);
                        record.setActivityTitle(marketActivityVO.getTitle());
                        record.setSellerId(marketActivityVO.getSellerId());
                        record.setType("wx");
                        record.setExecuteTime(marketActivityVO.getExecuteTime());
                        recordList.add(record);
                    }
                    marketActivityVO.setRecordsList(recordList);

                    wxActivity = saveOrUpdateActivity(marketActivityVO);

                    start++;
                }
                return true;
            }
        }).start();
    }

    /**
     * 查询本月商家群发微信消息的次数
     * @param sellerId 商家id
     * @return
     */
    public Integer countMonthWxMassTimes(Long sellerId){

        AssertsUtil.notNull(sellerId,"sellerId");

        return marketRecordsDAO.countMonthWxMassTimes(sellerId);
    }

}
