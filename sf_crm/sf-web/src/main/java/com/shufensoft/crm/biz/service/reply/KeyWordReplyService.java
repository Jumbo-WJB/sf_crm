package com.shufensoft.crm.biz.service.reply;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant.KeyWordBizType;
import com.shufensoft.crm.biz.constant.DaoConstant.MatchType;
import com.shufensoft.crm.biz.dao.generation.reply.KeyWordReplyConfigMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserWxMessageMapper;
import com.shufensoft.crm.biz.domain.generation.reply.KeyWordReplyConfig;
import com.shufensoft.crm.biz.domain.generation.reply.KeyWordReplyConfigExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.reply.helper.KeywordReplyHelper;
import com.shufensoft.crm.biz.vo.KeyWordReplyConfigVO;
import com.shufensoft.crm.common.constant.Constant;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.PropertyReader;
import com.shufensoft.crm.web.controller.wechat.constant.WXConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                关键字回复服务类
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/3  
 */
@Service
public class KeyWordReplyService {

    @Autowired
    private KeyWordReplyConfigMapper keyWordReplyConfigMapper;

    @Autowired
    private UserWxMessageMapper userWxMessageMapper;

    private static String WEB_URL = PropertyReader.getValue("crm.web.url");

    private static String POINT_MALL_URL = "/mobile/pointmall";

    private static String SHAKE_URL = "/mobile/doShake";

    private static String VALIDATE_URL = "/mobile/identify";

    private static String HB_RECEIVE_URL = "/mobile/hongbao/receive";

    private static String EXPRESS_URL = "/mobile/express";

    private static String BIRTHDAY_URL = "/mobile/birthday";

    private static String DEFAULT_GUIDE_HEAD = "很抱歉，{pet_name}还在成长中，如果有不周到的地方还请您见谅~我一定会加把劲继续努力哒。您可以换个问法，输入以下关键字再试试：\r\n";

    /**
     * 新增或更新关键字回复配置,如果是更新返回更新之前的对象；如果是新增返回null
     *
     * @param keyWordReplyConfigVO
     * @return
     */
    public KeyWordReplyConfigVO saveOrUpdateKeyWordReplyConfig(KeyWordReplyConfigVO keyWordReplyConfigVO) {

        AssertsUtil.notNull(keyWordReplyConfigVO, "keyWordReplyConfigVO");
        AssertsUtil.notBlank(keyWordReplyConfigVO.getBizType(), "bizType");
        AssertsUtil.notNull(keyWordReplyConfigVO.getSellerId(), "sellerId");

        KeyWordReplyConfig keyWordReplyConfig = (KeyWordReplyConfig) BeanCopierUtils.copyProperties(keyWordReplyConfigVO, KeyWordReplyConfig.class);

        KeyWordReplyConfigExample keyWordReplyConfigExample = new KeyWordReplyConfigExample();
        KeyWordReplyConfigExample.Criteria criteria = keyWordReplyConfigExample.createCriteria();

        criteria.andSellerIdEqualTo(keyWordReplyConfigVO.getSellerId());

        if (keyWordReplyConfig.getId() != null) {
            criteria.andIdEqualTo(keyWordReplyConfig.getId());
        }

        if (keyWordReplyConfig.getId() == null && StringUtils.isNotBlank(keyWordReplyConfig.getBizType())) {
            criteria.andBizTypeEqualTo(keyWordReplyConfig.getBizType());
        }

        if (keyWordReplyConfig.getId() == null && keyWordReplyConfig.getBizId() != null) {
            criteria.andBizIdEqualTo(keyWordReplyConfig.getBizId());
        }

        List<KeyWordReplyConfig> keyWordReplyConfigVOs = keyWordReplyConfigMapper.selectByExample(keyWordReplyConfigExample);

        if (CollectionUtils.isEmpty(keyWordReplyConfigVOs)) {

            keyWordReplyConfigMapper.insert(keyWordReplyConfig);
            return null;
        }

        keyWordReplyConfig.setId(keyWordReplyConfigVOs.get(0).getId());
        keyWordReplyConfigMapper.updateByPrimaryKeySelective(keyWordReplyConfig);

        return (KeyWordReplyConfigVO) BeanCopierUtils.copyProperties(keyWordReplyConfigVOs.get(0), KeyWordReplyConfigVO.class);

    }

    /**
     * 根据bizId和type获取关键字回复配置
     *
     * @param bizId
     * @param type
     */
    public KeyWordReplyConfigVO queryKeyWordReplyConfigByTypeAndBizId(Long sellerId, Long bizId, String type) {

        AssertsUtil.notNull(sellerId, "sellerId");

        KeyWordReplyConfigExample keyWordReplyConfigExample = new KeyWordReplyConfigExample();
        KeyWordReplyConfigExample.Criteria criteria = keyWordReplyConfigExample.createCriteria();

        criteria.andBizTypeEqualTo(type);
        criteria.andSellerIdEqualTo(sellerId);

        if (bizId != null) {
            criteria.andBizIdEqualTo(bizId);
        }
        List<KeyWordReplyConfig> keyWordReplyConfigs = keyWordReplyConfigMapper.selectByExample(keyWordReplyConfigExample);

        List<KeyWordReplyConfigVO> keyWordReplyConfigVOs = null;
        try {
            keyWordReplyConfigVOs = BeanCopierUtils.copyListProperties(keyWordReplyConfigs, KeyWordReplyConfigVO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!CollectionUtils.isEmpty(keyWordReplyConfigVOs)) {
            return keyWordReplyConfigVOs.get(0);
        }

        return null;
    }

    /**
     * 根据type获取关键字回复配置
     *
     * @param type
     */
    public KeyWordReplyConfigVO queryKeyWordReplyConfigByType(Long sellerId,String type) {

        return queryKeyWordReplyConfigByTypeAndBizId(sellerId,null, type);

    }

    /**
     * 获取商家所有的关键字回复配置
     */
    public List<KeyWordReplyConfigVO> getAllKeyWordReplyConfig(Long sellerId) {

        KeyWordReplyConfigExample keyWordReplyConfigExample = new KeyWordReplyConfigExample();

        keyWordReplyConfigExample.createCriteria().andSellerIdEqualTo(sellerId);

        List<KeyWordReplyConfig> keyWordReplyConfigs =  keyWordReplyConfigMapper.selectByExample(keyWordReplyConfigExample);

        return BeanCopierUtils.copyListProperties(keyWordReplyConfigs,KeyWordReplyConfigVO.class);

    }

    /**
     * 根据bizType获取关键字回复配置
     *
     * @param bizType 业务类型
     * @return
     */
    public List<KeyWordReplyConfigVO> queryKeyWordConfigByBizType(Long sellerId, String bizType) {

        AssertsUtil.notNull(sellerId, "sellerId");
        AssertsUtil.notBlank(bizType, "bizType");

        KeyWordReplyConfigExample keyWordReplyConfigExample = new KeyWordReplyConfigExample();
        KeyWordReplyConfigExample.Criteria criteria = keyWordReplyConfigExample.createCriteria();
        criteria.andBizTypeEqualTo(bizType);
        criteria.andSellerIdEqualTo(sellerId);

        List<KeyWordReplyConfig> keyWordReplyConfigs = keyWordReplyConfigMapper.selectByExample(keyWordReplyConfigExample);

        return BeanCopierUtils.copyListProperties(keyWordReplyConfigs, KeyWordReplyConfigVO.class);

    }

    /**
     * 根据matchType和keyWord获取关键字回复配置
     *
     * @param matchType 匹配类型,0:模糊匹配;1:精确匹配
     * @param keyWord
     * @return
     */
    public List<KeyWordReplyConfigVO> queryKeyWordConfigByMatchTypeAndKeyWord(Long sellerId, String matchType, String keyWord) {

        AssertsUtil.notNull(sellerId, "sellerId");
        AssertsUtil.notBlank(matchType, "matchType");
        AssertsUtil.notBlank(keyWord, "keyWord");

        KeyWordReplyConfigExample keyWordReplyConfigExample = new KeyWordReplyConfigExample();
        KeyWordReplyConfigExample.Criteria criteria = keyWordReplyConfigExample.createCriteria();
        criteria.andMatchTypeEqualTo(matchType);
        criteria.andSellerIdEqualTo(sellerId);

        if (MatchType.PRECISE_MATCH.equals(matchType)) {
            criteria.andKeyWordEqualTo(keyWord);
        }

        if (MatchType.VAGUE_MATCH.equals(matchType)) {
            criteria.andKeyWordLike("%" + keyWord + "%");
        }

        List<KeyWordReplyConfig> keyWordReplyConfigs = keyWordReplyConfigMapper.selectByExample(keyWordReplyConfigExample);

        return BeanCopierUtils.copyListProperties(keyWordReplyConfigs, KeyWordReplyConfigVO.class);

    }

    /**
     * 根据keyWord获取关键字回复配置(模糊查询)
     *
     * @param keyWord
     * @return
     */
    public List<KeyWordReplyConfigVO> queryKeyWordConfigByKeyWord(Long sellerId , String keyWord) {

        AssertsUtil.notNull(sellerId, "sellerId");
        AssertsUtil.notBlank(keyWord, "keyWord");

        KeyWordReplyConfigExample keyWordReplyConfigExample = new KeyWordReplyConfigExample();
        KeyWordReplyConfigExample.Criteria criteria = keyWordReplyConfigExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andKeyWordLike("%" + keyWord + "%");

        List<KeyWordReplyConfig> keyWordReplyConfigs = keyWordReplyConfigMapper.selectByExample(keyWordReplyConfigExample);

        return BeanCopierUtils.copyListProperties(keyWordReplyConfigs, KeyWordReplyConfigVO.class);

    }

    /**
     * 查询获取关键字回复配置
     *
     * @return
     */
    public List<KeyWordReplyConfigVO> queryKeyWordConfig() {

        List<KeyWordReplyConfig> keyWordReplyConfigs = keyWordReplyConfigMapper.selectByExample(new KeyWordReplyConfigExample());

        return BeanCopierUtils.copyListProperties(keyWordReplyConfigs, KeyWordReplyConfigVO.class);

    }


    /**
     * 匹配关键字,匹配不到返回引导语
     *
     * @param text
     * @return
     */
    public KeyWordReplyConfigVO matchKeyWordReplyConfig(Long sellerId,String text) {

        List<KeyWordReplyConfigVO> keyWordReplyConfigVOList = queryKeyWordConfigByMatchTypeAndKeyWord(sellerId,MatchType.PRECISE_MATCH, text);
        KeyWordReplyConfigVO keyWordReplyConfigVO = null;

        if (!CollectionUtils.isEmpty(keyWordReplyConfigVOList)) {
            keyWordReplyConfigVO = keyWordReplyConfigVOList.get(0);
        }

        if (keyWordReplyConfigVO == null) {

            keyWordReplyConfigVOList = queryKeyWordConfigByKeyWord(sellerId,text);

            if (!CollectionUtils.isEmpty(keyWordReplyConfigVOList)) {

                String matchType = keyWordReplyConfigVOList.get(0).getMatchType();

                String keyWord = keyWordReplyConfigVOList.get(0).getSuccessReplyContent();

                if (MatchType.VAGUE_MATCH.equals(matchType) || isKeyWordConstainsText(text, keyWord)) {
                    keyWordReplyConfigVO = keyWordReplyConfigVOList.get(0);
                }


            }

        }

        if (keyWordReplyConfigVO == null) {

            keyWordReplyConfigVO = queryKeyWordReplyConfigByType(sellerId, KeyWordBizType.GUIDE);

        }

        return keyWordReplyConfigVO;

    }

    /**
     * 判断包含关系
     *
     * @param text
     * @param keyWord
     * @return
     */
    private boolean isKeyWordConstainsText(String text, String keyWord) {

        if (StringUtils.isBlank(text) || StringUtils.isBlank(keyWord)) {
            return false;
        }

        String[] keyWords = keyWord.split(Constant.Sign.VERTICAL);
        for (String str : keyWords) {
            if (text.equals(str)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 关键字配置
     * @param keywordVO
     * @return
     */
    public boolean saveKeyWord(KeyWordReplyConfigVO keywordVO) {

        /**
         *  1.保存当前编辑配置
         */
        keywordVO.setMsgType(KeywordReplyHelper.getMsgType(keywordVO));
        KeyWordReplyConfigVO oldKeyWordReplyConfigVO = saveOrUpdateKeyWordReplyConfig(keywordVO);

        /**
         *  2.保存引导语
         */

        KeyWordReplyConfigVO guideVO = queryKeyWordReplyConfigByType(keywordVO.getSellerId(),KeyWordBizType.GUIDE);

        KeyWordReplyConfigVO guide = new KeyWordReplyConfigVO();

        StringBuilder successReplyContentStringBuilder = new StringBuilder();

        guide.setKeyWord("引导语");
        guide.setMatchType(MatchType.VAGUE_MATCH);
        guide.setBizType(KeyWordBizType.GUIDE);
        guide.setMsgType(WXConstant.WXMeassgeType.TEXT);
        guide.setTitle("引导语");

        if (guideVO != null) {

            guide.setId(guideVO.getId());
            String successReplyContent = guideVO.getSuccessReplyContent();

            if (oldKeyWordReplyConfigVO != null) {

                /**
                 * 如果关键字配置之前保存过替换引导语中的说明
                 */
                successReplyContentStringBuilder.append(successReplyContent.replace(oldKeyWordReplyConfigVO.getKeyWord()

                        + ": " + oldKeyWordReplyConfigVO.getTitle() + "\r\n", keywordVO.getKeyWord() + ": "
                        + keywordVO.getTitle() + "\r\n"));

            } else {
                successReplyContentStringBuilder.append(successReplyContent).append(keywordVO.getKeyWord()).append(": ")
                        .append(keywordVO.getTitle()).append("\r\n");

            }

            guide.setSuccessReplyContent(successReplyContentStringBuilder.toString());

        } else {

            SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(keywordVO.getSellerId()));

            /**
             * 替换引导语头部宠物名称
             */
            String guideHead = DEFAULT_GUIDE_HEAD;
            if(StringUtils.isBlank(sellerConfigInfo.getSellerName())){
                guideHead = guideHead.replace("{pet_name}","小牛");
            }else{
                String petName = sellerConfigInfo.getSellerName().substring(0,1);
                guideHead = guideHead.replace("{pet_name}",petName==null?"小牛":"小"+petName);
            }

            successReplyContentStringBuilder.append(guideHead).append(keywordVO.getKeyWord()).append(": ")
                    .append(keywordVO.getTitle()).append("\r\n");

            guide.setSuccessReplyContent(successReplyContentStringBuilder.toString());

        }
        guide.setSellerId(keywordVO.getSellerId());
        saveOrUpdateKeyWordReplyConfig(guide);

        return true;

    }



    /**
     * 获得关键字回复配置表信息
     *
     * @param keyWordReplyConfigVO
     * @param pageNum
     * @param length
     * @return
     */
    public PageInfo getKeyWordList(KeyWordReplyConfigVO keyWordReplyConfigVO, Integer pageNum, Integer length) {

        KeyWordReplyConfigExample example = new KeyWordReplyConfigExample();
        KeyWordReplyConfigExample.Criteria criteria = example.createCriteria();

        criteria.andSellerIdEqualTo(keyWordReplyConfigVO.getSellerId());

        if (StringUtils.isNotBlank(keyWordReplyConfigVO.getTitle())) {
            criteria.andTitleLike(keyWordReplyConfigVO.getTitle());
        }

        if (StringUtils.isNotBlank(keyWordReplyConfigVO.getBizType())) {
            criteria.andBizTypeEqualTo(keyWordReplyConfigVO.getBizType());
        }

        PageHelper.startPage(pageNum, length);
        List<KeyWordReplyConfig> list = keyWordReplyConfigMapper.selectByExample(example);

        return new PageInfo(list);

    }

    public KeyWordReplyConfig getConfigById(Long id) {
        return keyWordReplyConfigMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除关键字配置
     * @param id
     * @return
     */
    public boolean deleteConfigById(Long sellerId,Long id) {

        AssertsUtil.notNull(id, "id");

        KeyWordReplyConfig keyWordReplyConfig = keyWordReplyConfigMapper.selectByPrimaryKey(id);

        AssertsUtil.notNull(keyWordReplyConfig, "keyWordReplyConfig is null");

        /**
         *  1.去掉引导语说明
         */

        KeyWordReplyConfigVO guideVO = queryKeyWordReplyConfigByType(sellerId,KeyWordBizType.GUIDE);

        if (guideVO != null) {

            List<KeyWordReplyConfigVO> keyWordReplyConfigVOs = getAllKeyWordReplyConfig(sellerId);

            if(keyWordReplyConfigVOs!=null && keyWordReplyConfigVOs.size() == 2){

                keyWordReplyConfigMapper.deleteByPrimaryKey(guideVO.getId());

            }else{

                /**
                 * 如果关键字配置之前保存过替换引导语中的说明
                 */

                String successReplyContent = guideVO.getSuccessReplyContent();
                successReplyContent = successReplyContent.replace(keyWordReplyConfig.getKeyWord() + ": " + keyWordReplyConfig.getTitle() + "\r\n", "");
                guideVO.setSuccessReplyContent(successReplyContent);
                guideVO.setSellerId(sellerId);
                saveOrUpdateKeyWordReplyConfig(guideVO);

            }

        }

        /**
         *  2.删除关键字配置
         */
        int result = keyWordReplyConfigMapper.deleteByPrimaryKey(id);

        if (result > 0) {
            return true;
        }

        return false;

    }

    /**
     * 根据关键字匹配相关业务
     * @param keyWord
     * @param sellerId
     * @param userId
     * @return
     */
    public KeyWordReplyConfigVO matchBizBykeyWord(String keyWord,Long sellerId,Long userId){

        AssertsUtil.notBlank(keyWord,"keyWord");
        AssertsUtil.notNull(sellerId, "sellerId");
        AssertsUtil.notNull(userId, "userId");

        KeyWordReplyConfigVO keyWordReplyConfigVO = matchKeyWordReplyConfig(sellerId,keyWord);

        if(keyWordReplyConfigVO == null){

            return null;

        }

        if(KeyWordBizType.SIGN_IN.equals(keyWordReplyConfigVO.getBizType())){

            keyWordReplyConfigVO.setSuccessReplyContent(KeywordReplyHelper.assembleSignInMessage(keyWordReplyConfigVO, sellerId,userId));

            return keyWordReplyConfigVO;
        }

        if(KeyWordBizType.EXPRESS_QUERY.equals(keyWordReplyConfigVO.getBizType())){
            keyWordReplyConfigVO.setPicUrl(WEB_URL+"/static/news/express.jpg");

            keyWordReplyConfigVO.setUrl(WEB_URL+EXPRESS_URL+"?sellerId="+sellerId+"&userId="+userId);

            return keyWordReplyConfigVO;
        }

        if(KeyWordBizType.POINT_EXCHANGE_GOODS.equals(keyWordReplyConfigVO.getBizType())){

            keyWordReplyConfigVO.setPicUrl(WEB_URL+"/static/news/pointMall.png");

            keyWordReplyConfigVO.setUrl(WEB_URL+POINT_MALL_URL+"?sellerId="+sellerId);

            return keyWordReplyConfigVO;

        }

        if(KeyWordBizType.RECEIVE_COMMON_HB.equals(keyWordReplyConfigVO.getBizType())){

            keyWordReplyConfigVO.setPicUrl(WEB_URL+"/static/news/hb.jpg");

            keyWordReplyConfigVO.setUrl(WEB_URL+HB_RECEIVE_URL+"?sellerId="+sellerId+"&userId="+userId
                    +"&hbPoolId="+keyWordReplyConfigVO.getBizId()+"&ruleType=HB_POOL&businessType=other");

            return keyWordReplyConfigVO;
        }

        if(KeyWordBizType.PRAISE_RECEIVE_HB.equals(keyWordReplyConfigVO.getBizType())){

            keyWordReplyConfigVO.setPicUrl(WEB_URL+"/static/news/praise.jpg");

            keyWordReplyConfigVO.setUrl(WEB_URL+HB_RECEIVE_URL+"?sellerId="+sellerId+"&userId="+userId
                    +"&hbPoolId="+keyWordReplyConfigVO.getBizId()+"&ruleType=HB_POOL&businessType=other");

            return keyWordReplyConfigVO;
        }

        if(KeyWordBizType.POINT_EXCHANGE_HB.equals(keyWordReplyConfigVO.getBizType())){

            keyWordReplyConfigVO.setPicUrl(WEB_URL+"/static/news/exchange_hb.jpg");

            keyWordReplyConfigVO.setUrl(WEB_URL+HB_RECEIVE_URL+"?sellerId="+sellerId+"&userId="+userId
                    +"&hbPoolId="+keyWordReplyConfigVO.getBizId()+"&ruleType=HB_POOL&businessType=point_exchange");

            return keyWordReplyConfigVO;
        }

        if(KeyWordBizType.BIRTHDAY.equals(keyWordReplyConfigVO.getBizType())){

            keyWordReplyConfigVO.setPicUrl(WEB_URL+"/static/news/birthday.jpg");

            keyWordReplyConfigVO.setUrl(WEB_URL+BIRTHDAY_URL+"?sellerId="+sellerId+"&userId="+userId);

            return keyWordReplyConfigVO;

        }

        if(KeyWordBizType.USER_VALIDATE.equals(keyWordReplyConfigVO.getBizType())){

            keyWordReplyConfigVO.setPicUrl(WEB_URL+"/static/news/user_validate.jpg");

            keyWordReplyConfigVO.setUrl(WEB_URL+VALIDATE_URL+"?sellerId="+sellerId+"&userId="+userId);

            return keyWordReplyConfigVO;

        }

        if(KeyWordBizType.SHAKE.equals(keyWordReplyConfigVO.getBizType())){

            keyWordReplyConfigVO.setPicUrl(WEB_URL+"/static/news/shake.jpg");

            keyWordReplyConfigVO.setUrl(WEB_URL+SHAKE_URL+"?sellerId="+sellerId+"&rockId="+keyWordReplyConfigVO.getBizId()+"&userId="+userId);

            return keyWordReplyConfigVO;
        }

        if(KeyWordBizType.POINT_QUERY.equals(keyWordReplyConfigVO.getBizType())){
            keyWordReplyConfigVO.setSuccessReplyContent(KeywordReplyHelper.assemblePointQuesryMessage(keyWordReplyConfigVO, sellerId,userId));

        }

        return keyWordReplyConfigVO;

    }

}
