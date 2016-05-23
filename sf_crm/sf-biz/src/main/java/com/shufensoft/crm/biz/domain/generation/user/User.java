package com.shufensoft.crm.biz.domain.generation.user;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Domain
@Data
@ToString
public class User {
    /** 自增主键 */
    private Long id;

    /** 创建时间 */
    private Date gmtCreated;

    /** 修改时间 */
    private Date gmtModified;

    /** 创建人 */
    private String createdBy;

    /** 修改人 */
    private String modifiedBy;

    /** 是否逻辑上被删除0:未删除1:删除 */
    private String isDeleted;

    /** 内部用户Id,作为@BizId */
    @BizId
    private Long userId;

    /** 商家Id */
    private Long sellerId;

    /** user_taobao表user_id */
    private Long userIdTb;

    /** user_jd表user_id */
    private Long userIdJd;

    /** user_yz表user_id */
    private Long userIdYz;

    /** 用户来源 JD TB YZ WX */
    private String firstSource;

    /** 用户来源JD TB YZ WX，可以多个渠道逗号隔开 */
    private String source;

    /** 买家账号信息 */
    private String jdPin;

    /** 买家昵称 */
    private String tbBuyerNick;

    /** 有赞昵称 */
    private String yzBuyerNick;

    /** 微信openid */
    private String wxOpenid;

    /** 用户姓名 从收货人中提取 */
    private String name;

    /** 微信昵称 */
    private String wxNickName;

    /** 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 */
    private String sex;

    /** 城市 */
    private String city;

    /** 用户所在国家 */
    private String country;

    /** 用户所在省份 */
    private String province;

    /** 邮件 */
    private String email;

    /** 用户手机号码 */
    private String mobile;

    /** 公众号关注标识,0:未关注;1关注 */
    private String wxSubscribe;

    /** 微信头像 */
    private String wxHeadimgurl;

    /** 关注时间 */
    private Date wxSubscribeTime;

    /** 老客户标识，1：老客户，0::新客户 */
    private String isOldUser;

    /** 用户积分 */
    private Long integral;

    /** 品牌粉丝，1：是，0:否 */
    private String brandFans;

    /** 是否验证，1：是，0::否 */
    private String isVerify;

    /** 是领取过红包，1：是，0::否 */
    private String isReceivedHb;

    /** 用户画像Id */
    private Long userPortraitId;

    /** 用户的生日 */
    private Date birthday;

    /** taobao receiver id */
    private Long receiverIdTb;

    /** jd receiver id */
    private Long receiverIdJd;

    /** youzan receiver id */
    private Long receiverIdYz;

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

    /** userId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdExpression;

    /** 与 max(userId) 映射**/
    private Long maxUserId;

    /** 与 min(userId) 映射**/
    private Long minUserId;

    /** 与 avg(userId) 映射**/
    private Long avgUserId;

    /** 与 count(userId) 映射**/
    private Long countUserId;

    /** 与 count(distinctuserId) 映射**/
    private Long countDistinctUserId;

    /** 与 sum(userId) 映射**/
    private Long sumUserId;

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

    /** userIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdTbExpression;

    /** 与 max(userIdTb) 映射**/
    private Long maxUserIdTb;

    /** 与 min(userIdTb) 映射**/
    private Long minUserIdTb;

    /** 与 avg(userIdTb) 映射**/
    private Long avgUserIdTb;

    /** 与 count(userIdTb) 映射**/
    private Long countUserIdTb;

    /** 与 count(distinctuserIdTb) 映射**/
    private Long countDistinctUserIdTb;

    /** 与 sum(userIdTb) 映射**/
    private Long sumUserIdTb;

    /** userIdJd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdJdExpression;

    /** 与 max(userIdJd) 映射**/
    private Long maxUserIdJd;

    /** 与 min(userIdJd) 映射**/
    private Long minUserIdJd;

    /** 与 avg(userIdJd) 映射**/
    private Long avgUserIdJd;

    /** 与 count(userIdJd) 映射**/
    private Long countUserIdJd;

    /** 与 count(distinctuserIdJd) 映射**/
    private Long countDistinctUserIdJd;

    /** 与 sum(userIdJd) 映射**/
    private Long sumUserIdJd;

    /** userIdYz属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdYzExpression;

    /** 与 max(userIdYz) 映射**/
    private Long maxUserIdYz;

    /** 与 min(userIdYz) 映射**/
    private Long minUserIdYz;

    /** 与 avg(userIdYz) 映射**/
    private Long avgUserIdYz;

    /** 与 count(userIdYz) 映射**/
    private Long countUserIdYz;

    /** 与 count(distinctuserIdYz) 映射**/
    private Long countDistinctUserIdYz;

    /** 与 sum(userIdYz) 映射**/
    private Long sumUserIdYz;

    /** firstSource属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String firstSourceExpression;

    /** 与 max(firstSource) 映射**/
    private Long maxFirstSource;

    /** 与 min(firstSource) 映射**/
    private Long minFirstSource;

    /** 与 avg(firstSource) 映射**/
    private Long avgFirstSource;

    /** 与 count(firstSource) 映射**/
    private Long countFirstSource;

    /** 与 count(distinctfirstSource) 映射**/
    private Long countDistinctFirstSource;

    /** 与 sum(firstSource) 映射**/
    private String sumFirstSource;

    /** source属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sourceExpression;

    /** 与 max(source) 映射**/
    private Long maxSource;

    /** 与 min(source) 映射**/
    private Long minSource;

    /** 与 avg(source) 映射**/
    private Long avgSource;

    /** 与 count(source) 映射**/
    private Long countSource;

    /** 与 count(distinctsource) 映射**/
    private Long countDistinctSource;

    /** 与 sum(source) 映射**/
    private String sumSource;

    /** jdPin属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String jdPinExpression;

    /** 与 max(jdPin) 映射**/
    private Long maxJdPin;

    /** 与 min(jdPin) 映射**/
    private Long minJdPin;

    /** 与 avg(jdPin) 映射**/
    private Long avgJdPin;

    /** 与 count(jdPin) 映射**/
    private Long countJdPin;

    /** 与 count(distinctjdPin) 映射**/
    private Long countDistinctJdPin;

    /** 与 sum(jdPin) 映射**/
    private String sumJdPin;

    /** tbBuyerNick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tbBuyerNickExpression;

    /** 与 max(tbBuyerNick) 映射**/
    private Long maxTbBuyerNick;

    /** 与 min(tbBuyerNick) 映射**/
    private Long minTbBuyerNick;

    /** 与 avg(tbBuyerNick) 映射**/
    private Long avgTbBuyerNick;

    /** 与 count(tbBuyerNick) 映射**/
    private Long countTbBuyerNick;

    /** 与 count(distincttbBuyerNick) 映射**/
    private Long countDistinctTbBuyerNick;

    /** 与 sum(tbBuyerNick) 映射**/
    private String sumTbBuyerNick;

    /** yzBuyerNick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String yzBuyerNickExpression;

    /** 与 max(yzBuyerNick) 映射**/
    private Long maxYzBuyerNick;

    /** 与 min(yzBuyerNick) 映射**/
    private Long minYzBuyerNick;

    /** 与 avg(yzBuyerNick) 映射**/
    private Long avgYzBuyerNick;

    /** 与 count(yzBuyerNick) 映射**/
    private Long countYzBuyerNick;

    /** 与 count(distinctyzBuyerNick) 映射**/
    private Long countDistinctYzBuyerNick;

    /** 与 sum(yzBuyerNick) 映射**/
    private String sumYzBuyerNick;

    /** wxOpenid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxOpenidExpression;

    /** 与 max(wxOpenid) 映射**/
    private Long maxWxOpenid;

    /** 与 min(wxOpenid) 映射**/
    private Long minWxOpenid;

    /** 与 avg(wxOpenid) 映射**/
    private Long avgWxOpenid;

    /** 与 count(wxOpenid) 映射**/
    private Long countWxOpenid;

    /** 与 count(distinctwxOpenid) 映射**/
    private Long countDistinctWxOpenid;

    /** 与 sum(wxOpenid) 映射**/
    private String sumWxOpenid;

    /** name属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String nameExpression;

    /** 与 max(name) 映射**/
    private Long maxName;

    /** 与 min(name) 映射**/
    private Long minName;

    /** 与 avg(name) 映射**/
    private Long avgName;

    /** 与 count(name) 映射**/
    private Long countName;

    /** 与 count(distinctname) 映射**/
    private Long countDistinctName;

    /** 与 sum(name) 映射**/
    private String sumName;

    /** wxNickName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxNickNameExpression;

    /** 与 max(wxNickName) 映射**/
    private Long maxWxNickName;

    /** 与 min(wxNickName) 映射**/
    private Long minWxNickName;

    /** 与 avg(wxNickName) 映射**/
    private Long avgWxNickName;

    /** 与 count(wxNickName) 映射**/
    private Long countWxNickName;

    /** 与 count(distinctwxNickName) 映射**/
    private Long countDistinctWxNickName;

    /** 与 sum(wxNickName) 映射**/
    private String sumWxNickName;

    /** sex属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sexExpression;

    /** 与 max(sex) 映射**/
    private Long maxSex;

    /** 与 min(sex) 映射**/
    private Long minSex;

    /** 与 avg(sex) 映射**/
    private Long avgSex;

    /** 与 count(sex) 映射**/
    private Long countSex;

    /** 与 count(distinctsex) 映射**/
    private Long countDistinctSex;

    /** 与 sum(sex) 映射**/
    private String sumSex;

    /** city属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String cityExpression;

    /** 与 max(city) 映射**/
    private Long maxCity;

    /** 与 min(city) 映射**/
    private Long minCity;

    /** 与 avg(city) 映射**/
    private Long avgCity;

    /** 与 count(city) 映射**/
    private Long countCity;

    /** 与 count(distinctcity) 映射**/
    private Long countDistinctCity;

    /** 与 sum(city) 映射**/
    private String sumCity;

    /** country属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String countryExpression;

    /** 与 max(country) 映射**/
    private Long maxCountry;

    /** 与 min(country) 映射**/
    private Long minCountry;

    /** 与 avg(country) 映射**/
    private Long avgCountry;

    /** 与 count(country) 映射**/
    private Long countCountry;

    /** 与 count(distinctcountry) 映射**/
    private Long countDistinctCountry;

    /** 与 sum(country) 映射**/
    private String sumCountry;

    /** province属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String provinceExpression;

    /** 与 max(province) 映射**/
    private Long maxProvince;

    /** 与 min(province) 映射**/
    private Long minProvince;

    /** 与 avg(province) 映射**/
    private Long avgProvince;

    /** 与 count(province) 映射**/
    private Long countProvince;

    /** 与 count(distinctprovince) 映射**/
    private Long countDistinctProvince;

    /** 与 sum(province) 映射**/
    private String sumProvince;

    /** email属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String emailExpression;

    /** 与 max(email) 映射**/
    private Long maxEmail;

    /** 与 min(email) 映射**/
    private Long minEmail;

    /** 与 avg(email) 映射**/
    private Long avgEmail;

    /** 与 count(email) 映射**/
    private Long countEmail;

    /** 与 count(distinctemail) 映射**/
    private Long countDistinctEmail;

    /** 与 sum(email) 映射**/
    private String sumEmail;

    /** mobile属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String mobileExpression;

    /** 与 max(mobile) 映射**/
    private Long maxMobile;

    /** 与 min(mobile) 映射**/
    private Long minMobile;

    /** 与 avg(mobile) 映射**/
    private Long avgMobile;

    /** 与 count(mobile) 映射**/
    private Long countMobile;

    /** 与 count(distinctmobile) 映射**/
    private Long countDistinctMobile;

    /** 与 sum(mobile) 映射**/
    private String sumMobile;

    /** wxSubscribe属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxSubscribeExpression;

    /** 与 max(wxSubscribe) 映射**/
    private Long maxWxSubscribe;

    /** 与 min(wxSubscribe) 映射**/
    private Long minWxSubscribe;

    /** 与 avg(wxSubscribe) 映射**/
    private Long avgWxSubscribe;

    /** 与 count(wxSubscribe) 映射**/
    private Long countWxSubscribe;

    /** 与 count(distinctwxSubscribe) 映射**/
    private Long countDistinctWxSubscribe;

    /** 与 sum(wxSubscribe) 映射**/
    private String sumWxSubscribe;

    /** wxHeadimgurl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxHeadimgurlExpression;

    /** 与 max(wxHeadimgurl) 映射**/
    private Long maxWxHeadimgurl;

    /** 与 min(wxHeadimgurl) 映射**/
    private Long minWxHeadimgurl;

    /** 与 avg(wxHeadimgurl) 映射**/
    private Long avgWxHeadimgurl;

    /** 与 count(wxHeadimgurl) 映射**/
    private Long countWxHeadimgurl;

    /** 与 count(distinctwxHeadimgurl) 映射**/
    private Long countDistinctWxHeadimgurl;

    /** 与 sum(wxHeadimgurl) 映射**/
    private String sumWxHeadimgurl;

    /** wxSubscribeTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxSubscribeTimeExpression;

    /** 与 max(wxSubscribeTime) 映射**/
    private Long maxWxSubscribeTime;

    /** 与 min(wxSubscribeTime) 映射**/
    private Long minWxSubscribeTime;

    /** 与 avg(wxSubscribeTime) 映射**/
    private Long avgWxSubscribeTime;

    /** 与 count(wxSubscribeTime) 映射**/
    private Long countWxSubscribeTime;

    /** 与 count(distinctwxSubscribeTime) 映射**/
    private Long countDistinctWxSubscribeTime;

    /** 与 sum(wxSubscribeTime) 映射**/
    private Date sumWxSubscribeTime;

    /** isOldUser属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isOldUserExpression;

    /** 与 max(isOldUser) 映射**/
    private Long maxIsOldUser;

    /** 与 min(isOldUser) 映射**/
    private Long minIsOldUser;

    /** 与 avg(isOldUser) 映射**/
    private Long avgIsOldUser;

    /** 与 count(isOldUser) 映射**/
    private Long countIsOldUser;

    /** 与 count(distinctisOldUser) 映射**/
    private Long countDistinctIsOldUser;

    /** 与 sum(isOldUser) 映射**/
    private String sumIsOldUser;

    /** integral属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String integralExpression;

    /** 与 max(integral) 映射**/
    private Long maxIntegral;

    /** 与 min(integral) 映射**/
    private Long minIntegral;

    /** 与 avg(integral) 映射**/
    private Long avgIntegral;

    /** 与 count(integral) 映射**/
    private Long countIntegral;

    /** 与 count(distinctintegral) 映射**/
    private Long countDistinctIntegral;

    /** 与 sum(integral) 映射**/
    private Long sumIntegral;

    /** brandFans属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String brandFansExpression;

    /** 与 max(brandFans) 映射**/
    private Long maxBrandFans;

    /** 与 min(brandFans) 映射**/
    private Long minBrandFans;

    /** 与 avg(brandFans) 映射**/
    private Long avgBrandFans;

    /** 与 count(brandFans) 映射**/
    private Long countBrandFans;

    /** 与 count(distinctbrandFans) 映射**/
    private Long countDistinctBrandFans;

    /** 与 sum(brandFans) 映射**/
    private String sumBrandFans;

    /** isVerify属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isVerifyExpression;

    /** 与 max(isVerify) 映射**/
    private Long maxIsVerify;

    /** 与 min(isVerify) 映射**/
    private Long minIsVerify;

    /** 与 avg(isVerify) 映射**/
    private Long avgIsVerify;

    /** 与 count(isVerify) 映射**/
    private Long countIsVerify;

    /** 与 count(distinctisVerify) 映射**/
    private Long countDistinctIsVerify;

    /** 与 sum(isVerify) 映射**/
    private String sumIsVerify;

    /** isReceivedHb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isReceivedHbExpression;

    /** 与 max(isReceivedHb) 映射**/
    private Long maxIsReceivedHb;

    /** 与 min(isReceivedHb) 映射**/
    private Long minIsReceivedHb;

    /** 与 avg(isReceivedHb) 映射**/
    private Long avgIsReceivedHb;

    /** 与 count(isReceivedHb) 映射**/
    private Long countIsReceivedHb;

    /** 与 count(distinctisReceivedHb) 映射**/
    private Long countDistinctIsReceivedHb;

    /** 与 sum(isReceivedHb) 映射**/
    private String sumIsReceivedHb;

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

    /** birthday属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String birthdayExpression;

    /** 与 max(birthday) 映射**/
    private Long maxBirthday;

    /** 与 min(birthday) 映射**/
    private Long minBirthday;

    /** 与 avg(birthday) 映射**/
    private Long avgBirthday;

    /** 与 count(birthday) 映射**/
    private Long countBirthday;

    /** 与 count(distinctbirthday) 映射**/
    private Long countDistinctBirthday;

    /** 与 sum(birthday) 映射**/
    private Date sumBirthday;

    /** receiverIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdTbExpression;

    /** 与 max(receiverIdTb) 映射**/
    private Long maxReceiverIdTb;

    /** 与 min(receiverIdTb) 映射**/
    private Long minReceiverIdTb;

    /** 与 avg(receiverIdTb) 映射**/
    private Long avgReceiverIdTb;

    /** 与 count(receiverIdTb) 映射**/
    private Long countReceiverIdTb;

    /** 与 count(distinctreceiverIdTb) 映射**/
    private Long countDistinctReceiverIdTb;

    /** 与 sum(receiverIdTb) 映射**/
    private Long sumReceiverIdTb;

    /** receiverIdJd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdJdExpression;

    /** 与 max(receiverIdJd) 映射**/
    private Long maxReceiverIdJd;

    /** 与 min(receiverIdJd) 映射**/
    private Long minReceiverIdJd;

    /** 与 avg(receiverIdJd) 映射**/
    private Long avgReceiverIdJd;

    /** 与 count(receiverIdJd) 映射**/
    private Long countReceiverIdJd;

    /** 与 count(distinctreceiverIdJd) 映射**/
    private Long countDistinctReceiverIdJd;

    /** 与 sum(receiverIdJd) 映射**/
    private Long sumReceiverIdJd;

    /** receiverIdYz属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdYzExpression;

    /** 与 max(receiverIdYz) 映射**/
    private Long maxReceiverIdYz;

    /** 与 min(receiverIdYz) 映射**/
    private Long minReceiverIdYz;

    /** 与 avg(receiverIdYz) 映射**/
    private Long avgReceiverIdYz;

    /** 与 count(receiverIdYz) 映射**/
    private Long countReceiverIdYz;

    /** 与 count(distinctreceiverIdYz) 映射**/
    private Long countDistinctReceiverIdYz;

    /** 与 sum(receiverIdYz) 映射**/
    private Long sumReceiverIdYz;
}