package com.shufensoft.crm.biz.domain.generation.user;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Domain
@Data
@ToString
public class UserPortrait {
    /** 自增主键 */
    private Long id;

    /** 创建时间 */
    private Date gmtCreated;

    /** 创建人 */
    private String createdBy;

    /** 修改时间 */
    private Date gmtModified;

    /** 修改人 */
    private String modifiedBy;

    /** 是否逻辑上被删除0:未删除1:删除 */
    private String isDeleted;

    /**  */
    private Long sellerId;

    /** 用户画像Id,作为@BizId */
    @BizId
    private Long userPortraitId;

    /**  用户活跃度，几颗星 */
    private Integer liveness;

    /** 用户贡献度，总分100 */
    private BigDecimal contribution;

    /** 累计购买金额 */
    private Long totalPurchaseAmount;

    /** 累计购买次数 */
    private Integer totalPurchaseTimes;

    /** 累计互动次数 */
    private Integer interactionsTimes;

    /** 累计签到次数 */
    private Integer signInTimes;

    /** 最后一次签到时间 */
    private Date lastSignInDate;

    /** 最后一次购买时间 */
    private Date lastPurchaseDate;

    /** 第一次购买时间 */
    private Date firstPurchaseDate;

    /** 最后一次购买金额 */
    private Long lastPurchaseAmount;

    /** 手机购买率 例:0.5 */
    private BigDecimal mobilePurchaseRate;

    /** 平均购买周期 */
    private BigDecimal purchaseAverageCycle;

    /** 平均购买金额 */
    private Long purchaseAverageAmount;

    /** 微信购买均价 */
    private Long wxPurchaseAverageAmount;

    /** 短信接收次数 */
    private Integer smsAcceptNumber;

    /** 短信接收周期，单位：天 */
    private Integer smsAcceptCircle;

    /** 邮件接收次数 */
    private Integer emailAcceptNumber;

    /** 邮件接收周期，单位：天 */
    private Integer emailAcceptCircle;

    /** 喜好 */
    private String fancy;

    /** 好评率 例0.5 */
    private BigDecimal goodsRate;

    /** 用户贡献度tb，总分100 */
    private BigDecimal contributionTmall;

    /** 淘宝贡献度 */
    private BigDecimal contributionTb;

    /** 用户贡献度jd，总分100 */
    private BigDecimal contributionJd;

    /** 用户贡献度yz，总分100 */
    private BigDecimal contributionYz;

    /** id属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String idExpression;

    /** 与 max(id) 映射**/
    private Long maxId;

    /** 与 min(id) 映射**/
    private Long minId;

    /** 与 avg(id) 映射**/
    private Long avgId;

    /** 与 count(id) 映射**/
    private Long countId;

    /** 与 count(distinctid) 映射**/
    private Long countDistinctId;

    /** 与 sum(id) 映射**/
    private Long sumId;

    /** gmtCreated属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtCreatedExpression;

    /** 与 max(gmtCreated) 映射**/
    private Long maxGmtCreated;

    /** 与 min(gmtCreated) 映射**/
    private Long minGmtCreated;

    /** 与 avg(gmtCreated) 映射**/
    private Long avgGmtCreated;

    /** 与 count(gmtCreated) 映射**/
    private Long countGmtCreated;

    /** 与 count(distinctgmtCreated) 映射**/
    private Long countDistinctGmtCreated;

    /** 与 sum(gmtCreated) 映射**/
    private Date sumGmtCreated;

    /** createdBy属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String createdByExpression;

    /** 与 max(createdBy) 映射**/
    private Long maxCreatedBy;

    /** 与 min(createdBy) 映射**/
    private Long minCreatedBy;

    /** 与 avg(createdBy) 映射**/
    private Long avgCreatedBy;

    /** 与 count(createdBy) 映射**/
    private Long countCreatedBy;

    /** 与 count(distinctcreatedBy) 映射**/
    private Long countDistinctCreatedBy;

    /** 与 sum(createdBy) 映射**/
    private String sumCreatedBy;

    /** gmtModified属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtModifiedExpression;

    /** 与 max(gmtModified) 映射**/
    private Long maxGmtModified;

    /** 与 min(gmtModified) 映射**/
    private Long minGmtModified;

    /** 与 avg(gmtModified) 映射**/
    private Long avgGmtModified;

    /** 与 count(gmtModified) 映射**/
    private Long countGmtModified;

    /** 与 count(distinctgmtModified) 映射**/
    private Long countDistinctGmtModified;

    /** 与 sum(gmtModified) 映射**/
    private Date sumGmtModified;

    /** modifiedBy属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String modifiedByExpression;

    /** 与 max(modifiedBy) 映射**/
    private Long maxModifiedBy;

    /** 与 min(modifiedBy) 映射**/
    private Long minModifiedBy;

    /** 与 avg(modifiedBy) 映射**/
    private Long avgModifiedBy;

    /** 与 count(modifiedBy) 映射**/
    private Long countModifiedBy;

    /** 与 count(distinctmodifiedBy) 映射**/
    private Long countDistinctModifiedBy;

    /** 与 sum(modifiedBy) 映射**/
    private String sumModifiedBy;

    /** isDeleted属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isDeletedExpression;

    /** 与 max(isDeleted) 映射**/
    private Long maxIsDeleted;

    /** 与 min(isDeleted) 映射**/
    private Long minIsDeleted;

    /** 与 avg(isDeleted) 映射**/
    private Long avgIsDeleted;

    /** 与 count(isDeleted) 映射**/
    private Long countIsDeleted;

    /** 与 count(distinctisDeleted) 映射**/
    private Long countDistinctIsDeleted;

    /** 与 sum(isDeleted) 映射**/
    private String sumIsDeleted;

    /** sellerId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerIdExpression;

    /** 与 max(sellerId) 映射**/
    private Long maxSellerId;

    /** 与 min(sellerId) 映射**/
    private Long minSellerId;

    /** 与 avg(sellerId) 映射**/
    private Long avgSellerId;

    /** 与 count(sellerId) 映射**/
    private Long countSellerId;

    /** 与 count(distinctsellerId) 映射**/
    private Long countDistinctSellerId;

    /** 与 sum(sellerId) 映射**/
    private Long sumSellerId;

    /** userPortraitId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userPortraitIdExpression;

    /** 与 max(userPortraitId) 映射**/
    private Long maxUserPortraitId;

    /** 与 min(userPortraitId) 映射**/
    private Long minUserPortraitId;

    /** 与 avg(userPortraitId) 映射**/
    private Long avgUserPortraitId;

    /** 与 count(userPortraitId) 映射**/
    private Long countUserPortraitId;

    /** 与 count(distinctuserPortraitId) 映射**/
    private Long countDistinctUserPortraitId;

    /** 与 sum(userPortraitId) 映射**/
    private Long sumUserPortraitId;

    /** liveness属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String livenessExpression;

    /** 与 max(liveness) 映射**/
    private Long maxLiveness;

    /** 与 min(liveness) 映射**/
    private Long minLiveness;

    /** 与 avg(liveness) 映射**/
    private Long avgLiveness;

    /** 与 count(liveness) 映射**/
    private Long countLiveness;

    /** 与 count(distinctliveness) 映射**/
    private Long countDistinctLiveness;

    /** 与 sum(liveness) 映射**/
    private Integer sumLiveness;

    /** contribution属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String contributionExpression;

    /** 与 max(contribution) 映射**/
    private Long maxContribution;

    /** 与 min(contribution) 映射**/
    private Long minContribution;

    /** 与 avg(contribution) 映射**/
    private Long avgContribution;

    /** 与 count(contribution) 映射**/
    private Long countContribution;

    /** 与 count(distinctcontribution) 映射**/
    private Long countDistinctContribution;

    /** 与 sum(contribution) 映射**/
    private BigDecimal sumContribution;

    /** totalPurchaseAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String totalPurchaseAmountExpression;

    /** 与 max(totalPurchaseAmount) 映射**/
    private Long maxTotalPurchaseAmount;

    /** 与 min(totalPurchaseAmount) 映射**/
    private Long minTotalPurchaseAmount;

    /** 与 avg(totalPurchaseAmount) 映射**/
    private Long avgTotalPurchaseAmount;

    /** 与 count(totalPurchaseAmount) 映射**/
    private Long countTotalPurchaseAmount;

    /** 与 count(distincttotalPurchaseAmount) 映射**/
    private Long countDistinctTotalPurchaseAmount;

    /** 与 sum(totalPurchaseAmount) 映射**/
    private Long sumTotalPurchaseAmount;

    /** totalPurchaseTimes属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String totalPurchaseTimesExpression;

    /** 与 max(totalPurchaseTimes) 映射**/
    private Long maxTotalPurchaseTimes;

    /** 与 min(totalPurchaseTimes) 映射**/
    private Long minTotalPurchaseTimes;

    /** 与 avg(totalPurchaseTimes) 映射**/
    private Long avgTotalPurchaseTimes;

    /** 与 count(totalPurchaseTimes) 映射**/
    private Long countTotalPurchaseTimes;

    /** 与 count(distincttotalPurchaseTimes) 映射**/
    private Long countDistinctTotalPurchaseTimes;

    /** 与 sum(totalPurchaseTimes) 映射**/
    private Integer sumTotalPurchaseTimes;

    /** interactionsTimes属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String interactionsTimesExpression;

    /** 与 max(interactionsTimes) 映射**/
    private Long maxInteractionsTimes;

    /** 与 min(interactionsTimes) 映射**/
    private Long minInteractionsTimes;

    /** 与 avg(interactionsTimes) 映射**/
    private Long avgInteractionsTimes;

    /** 与 count(interactionsTimes) 映射**/
    private Long countInteractionsTimes;

    /** 与 count(distinctinteractionsTimes) 映射**/
    private Long countDistinctInteractionsTimes;

    /** 与 sum(interactionsTimes) 映射**/
    private Integer sumInteractionsTimes;

    /** signInTimes属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String signInTimesExpression;

    /** 与 max(signInTimes) 映射**/
    private Long maxSignInTimes;

    /** 与 min(signInTimes) 映射**/
    private Long minSignInTimes;

    /** 与 avg(signInTimes) 映射**/
    private Long avgSignInTimes;

    /** 与 count(signInTimes) 映射**/
    private Long countSignInTimes;

    /** 与 count(distinctsignInTimes) 映射**/
    private Long countDistinctSignInTimes;

    /** 与 sum(signInTimes) 映射**/
    private Integer sumSignInTimes;

    /** lastSignInDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String lastSignInDateExpression;

    /** 与 max(lastSignInDate) 映射**/
    private Long maxLastSignInDate;

    /** 与 min(lastSignInDate) 映射**/
    private Long minLastSignInDate;

    /** 与 avg(lastSignInDate) 映射**/
    private Long avgLastSignInDate;

    /** 与 count(lastSignInDate) 映射**/
    private Long countLastSignInDate;

    /** 与 count(distinctlastSignInDate) 映射**/
    private Long countDistinctLastSignInDate;

    /** 与 sum(lastSignInDate) 映射**/
    private Date sumLastSignInDate;

    /** lastPurchaseDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String lastPurchaseDateExpression;

    /** 与 max(lastPurchaseDate) 映射**/
    private Long maxLastPurchaseDate;

    /** 与 min(lastPurchaseDate) 映射**/
    private Long minLastPurchaseDate;

    /** 与 avg(lastPurchaseDate) 映射**/
    private Long avgLastPurchaseDate;

    /** 与 count(lastPurchaseDate) 映射**/
    private Long countLastPurchaseDate;

    /** 与 count(distinctlastPurchaseDate) 映射**/
    private Long countDistinctLastPurchaseDate;

    /** 与 sum(lastPurchaseDate) 映射**/
    private Date sumLastPurchaseDate;

    /** firstPurchaseDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String firstPurchaseDateExpression;

    /** 与 max(firstPurchaseDate) 映射**/
    private Long maxFirstPurchaseDate;

    /** 与 min(firstPurchaseDate) 映射**/
    private Long minFirstPurchaseDate;

    /** 与 avg(firstPurchaseDate) 映射**/
    private Long avgFirstPurchaseDate;

    /** 与 count(firstPurchaseDate) 映射**/
    private Long countFirstPurchaseDate;

    /** 与 count(distinctfirstPurchaseDate) 映射**/
    private Long countDistinctFirstPurchaseDate;

    /** 与 sum(firstPurchaseDate) 映射**/
    private Date sumFirstPurchaseDate;

    /** lastPurchaseAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String lastPurchaseAmountExpression;

    /** 与 max(lastPurchaseAmount) 映射**/
    private Long maxLastPurchaseAmount;

    /** 与 min(lastPurchaseAmount) 映射**/
    private Long minLastPurchaseAmount;

    /** 与 avg(lastPurchaseAmount) 映射**/
    private Long avgLastPurchaseAmount;

    /** 与 count(lastPurchaseAmount) 映射**/
    private Long countLastPurchaseAmount;

    /** 与 count(distinctlastPurchaseAmount) 映射**/
    private Long countDistinctLastPurchaseAmount;

    /** 与 sum(lastPurchaseAmount) 映射**/
    private Long sumLastPurchaseAmount;

    /** mobilePurchaseRate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String mobilePurchaseRateExpression;

    /** 与 max(mobilePurchaseRate) 映射**/
    private Long maxMobilePurchaseRate;

    /** 与 min(mobilePurchaseRate) 映射**/
    private Long minMobilePurchaseRate;

    /** 与 avg(mobilePurchaseRate) 映射**/
    private Long avgMobilePurchaseRate;

    /** 与 count(mobilePurchaseRate) 映射**/
    private Long countMobilePurchaseRate;

    /** 与 count(distinctmobilePurchaseRate) 映射**/
    private Long countDistinctMobilePurchaseRate;

    /** 与 sum(mobilePurchaseRate) 映射**/
    private BigDecimal sumMobilePurchaseRate;

    /** purchaseAverageCycle属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String purchaseAverageCycleExpression;

    /** 与 max(purchaseAverageCycle) 映射**/
    private Long maxPurchaseAverageCycle;

    /** 与 min(purchaseAverageCycle) 映射**/
    private Long minPurchaseAverageCycle;

    /** 与 avg(purchaseAverageCycle) 映射**/
    private Long avgPurchaseAverageCycle;

    /** 与 count(purchaseAverageCycle) 映射**/
    private Long countPurchaseAverageCycle;

    /** 与 count(distinctpurchaseAverageCycle) 映射**/
    private Long countDistinctPurchaseAverageCycle;

    /** 与 sum(purchaseAverageCycle) 映射**/
    private BigDecimal sumPurchaseAverageCycle;

    /** purchaseAverageAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String purchaseAverageAmountExpression;

    /** 与 max(purchaseAverageAmount) 映射**/
    private Long maxPurchaseAverageAmount;

    /** 与 min(purchaseAverageAmount) 映射**/
    private Long minPurchaseAverageAmount;

    /** 与 avg(purchaseAverageAmount) 映射**/
    private Long avgPurchaseAverageAmount;

    /** 与 count(purchaseAverageAmount) 映射**/
    private Long countPurchaseAverageAmount;

    /** 与 count(distinctpurchaseAverageAmount) 映射**/
    private Long countDistinctPurchaseAverageAmount;

    /** 与 sum(purchaseAverageAmount) 映射**/
    private Long sumPurchaseAverageAmount;

    /** wxPurchaseAverageAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxPurchaseAverageAmountExpression;

    /** 与 max(wxPurchaseAverageAmount) 映射**/
    private Long maxWxPurchaseAverageAmount;

    /** 与 min(wxPurchaseAverageAmount) 映射**/
    private Long minWxPurchaseAverageAmount;

    /** 与 avg(wxPurchaseAverageAmount) 映射**/
    private Long avgWxPurchaseAverageAmount;

    /** 与 count(wxPurchaseAverageAmount) 映射**/
    private Long countWxPurchaseAverageAmount;

    /** 与 count(distinctwxPurchaseAverageAmount) 映射**/
    private Long countDistinctWxPurchaseAverageAmount;

    /** 与 sum(wxPurchaseAverageAmount) 映射**/
    private Long sumWxPurchaseAverageAmount;

    /** smsAcceptNumber属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String smsAcceptNumberExpression;

    /** 与 max(smsAcceptNumber) 映射**/
    private Long maxSmsAcceptNumber;

    /** 与 min(smsAcceptNumber) 映射**/
    private Long minSmsAcceptNumber;

    /** 与 avg(smsAcceptNumber) 映射**/
    private Long avgSmsAcceptNumber;

    /** 与 count(smsAcceptNumber) 映射**/
    private Long countSmsAcceptNumber;

    /** 与 count(distinctsmsAcceptNumber) 映射**/
    private Long countDistinctSmsAcceptNumber;

    /** 与 sum(smsAcceptNumber) 映射**/
    private Integer sumSmsAcceptNumber;

    /** smsAcceptCircle属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String smsAcceptCircleExpression;

    /** 与 max(smsAcceptCircle) 映射**/
    private Long maxSmsAcceptCircle;

    /** 与 min(smsAcceptCircle) 映射**/
    private Long minSmsAcceptCircle;

    /** 与 avg(smsAcceptCircle) 映射**/
    private Long avgSmsAcceptCircle;

    /** 与 count(smsAcceptCircle) 映射**/
    private Long countSmsAcceptCircle;

    /** 与 count(distinctsmsAcceptCircle) 映射**/
    private Long countDistinctSmsAcceptCircle;

    /** 与 sum(smsAcceptCircle) 映射**/
    private Integer sumSmsAcceptCircle;

    /** emailAcceptNumber属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String emailAcceptNumberExpression;

    /** 与 max(emailAcceptNumber) 映射**/
    private Long maxEmailAcceptNumber;

    /** 与 min(emailAcceptNumber) 映射**/
    private Long minEmailAcceptNumber;

    /** 与 avg(emailAcceptNumber) 映射**/
    private Long avgEmailAcceptNumber;

    /** 与 count(emailAcceptNumber) 映射**/
    private Long countEmailAcceptNumber;

    /** 与 count(distinctemailAcceptNumber) 映射**/
    private Long countDistinctEmailAcceptNumber;

    /** 与 sum(emailAcceptNumber) 映射**/
    private Integer sumEmailAcceptNumber;

    /** emailAcceptCircle属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String emailAcceptCircleExpression;

    /** 与 max(emailAcceptCircle) 映射**/
    private Long maxEmailAcceptCircle;

    /** 与 min(emailAcceptCircle) 映射**/
    private Long minEmailAcceptCircle;

    /** 与 avg(emailAcceptCircle) 映射**/
    private Long avgEmailAcceptCircle;

    /** 与 count(emailAcceptCircle) 映射**/
    private Long countEmailAcceptCircle;

    /** 与 count(distinctemailAcceptCircle) 映射**/
    private Long countDistinctEmailAcceptCircle;

    /** 与 sum(emailAcceptCircle) 映射**/
    private Integer sumEmailAcceptCircle;

    /** fancy属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String fancyExpression;

    /** 与 max(fancy) 映射**/
    private Long maxFancy;

    /** 与 min(fancy) 映射**/
    private Long minFancy;

    /** 与 avg(fancy) 映射**/
    private Long avgFancy;

    /** 与 count(fancy) 映射**/
    private Long countFancy;

    /** 与 count(distinctfancy) 映射**/
    private Long countDistinctFancy;

    /** 与 sum(fancy) 映射**/
    private String sumFancy;

    /** goodsRate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String goodsRateExpression;

    /** 与 max(goodsRate) 映射**/
    private Long maxGoodsRate;

    /** 与 min(goodsRate) 映射**/
    private Long minGoodsRate;

    /** 与 avg(goodsRate) 映射**/
    private Long avgGoodsRate;

    /** 与 count(goodsRate) 映射**/
    private Long countGoodsRate;

    /** 与 count(distinctgoodsRate) 映射**/
    private Long countDistinctGoodsRate;

    /** 与 sum(goodsRate) 映射**/
    private BigDecimal sumGoodsRate;

    /** contributionTmall属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String contributionTmallExpression;

    /** 与 max(contributionTmall) 映射**/
    private Long maxContributionTmall;

    /** 与 min(contributionTmall) 映射**/
    private Long minContributionTmall;

    /** 与 avg(contributionTmall) 映射**/
    private Long avgContributionTmall;

    /** 与 count(contributionTmall) 映射**/
    private Long countContributionTmall;

    /** 与 count(distinctcontributionTmall) 映射**/
    private Long countDistinctContributionTmall;

    /** 与 sum(contributionTmall) 映射**/
    private BigDecimal sumContributionTmall;

    /** contributionTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String contributionTbExpression;

    /** 与 max(contributionTb) 映射**/
    private Long maxContributionTb;

    /** 与 min(contributionTb) 映射**/
    private Long minContributionTb;

    /** 与 avg(contributionTb) 映射**/
    private Long avgContributionTb;

    /** 与 count(contributionTb) 映射**/
    private Long countContributionTb;

    /** 与 count(distinctcontributionTb) 映射**/
    private Long countDistinctContributionTb;

    /** 与 sum(contributionTb) 映射**/
    private BigDecimal sumContributionTb;

    /** contributionJd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String contributionJdExpression;

    /** 与 max(contributionJd) 映射**/
    private Long maxContributionJd;

    /** 与 min(contributionJd) 映射**/
    private Long minContributionJd;

    /** 与 avg(contributionJd) 映射**/
    private Long avgContributionJd;

    /** 与 count(contributionJd) 映射**/
    private Long countContributionJd;

    /** 与 count(distinctcontributionJd) 映射**/
    private Long countDistinctContributionJd;

    /** 与 sum(contributionJd) 映射**/
    private BigDecimal sumContributionJd;

    /** contributionYz属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String contributionYzExpression;

    /** 与 max(contributionYz) 映射**/
    private Long maxContributionYz;

    /** 与 min(contributionYz) 映射**/
    private Long minContributionYz;

    /** 与 avg(contributionYz) 映射**/
    private Long avgContributionYz;

    /** 与 count(contributionYz) 映射**/
    private Long countContributionYz;

    /** 与 count(distinctcontributionYz) 映射**/
    private Long countDistinctContributionYz;

    /** 与 sum(contributionYz) 映射**/
    private BigDecimal sumContributionYz;
}