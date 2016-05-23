package com.shufensoft.crm.biz.domain.generation.seller;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Domain
@Data
@ToString
public class SellerConfigInfo implements Serializable {

    private static final long serialVersionUID = -8098452976629871709L;

    /** 主键ID */
    private Long id;

    /** 创建时间 */
    private Date gmtCreated;

    /** 修改时间 */
    private Date gmtModified;

    /** 创建人 */
    private String createdBy;

    /** 修改人 */
    private String modifiedBy;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 商家Id,作为@BizId */
    @BizId
    private Long sellerId;

    /** 商家类型 */
    private String sellerType;

    /** 商家名称 */
    private String sellerName;

    /** 商家手机号码 */
    private String mobile;

    /** 商家电话号码 */
    private String phone;

    /** 商家邮箱 */
    private String email;

    /** 商家地址 */
    private String address;

    /** 微信号 */
    private String wxNo;

    /** 	微信appid */
    private String wxAppId;

    /** 	微信app_secret */
    private String wxAppSecret;

    /** 微信wx_access_token */
    private String wxAccessToken;

    /** 微信wx_refresh_token */
    private String wxRefreshToken;

    /** 微信wx_jsapi_ticket */
    private String wxJsapiTicket;

    /** 微信token过期时间 */
    private Date wxTokenExpire;

    /** 本地app_id */
    private String appId;

    /** 本地app_secret */
    private String appSecret;

    /** 本地 access_token */
    private String accessToken;

    /** 本地 refresh_token */
    private String refreshToken;

    /** 微信商户号 */
    private String wxMchid;

    /** 微信证书地址 */
    private String wxSecrteUrl;

    /** 微信ticket过期时间 */
    private Date wxTicketExpire;

    /** 微信商户key */
    private String wxAppKey;

    /** 公众号头像地址 */
    private String wxImgUrl;

    /** 微信二维码地址 */
    private String wxQrcode;

    /** 短信发送扩展码 */
    private String smsSerial;

    /** 通知短信签名 */
    private String smsNotifySign;

    /** 营销短信签名 */
    private String smsSaleSign;

    /** 邮件签名 */
    private String emailSign;

    /** 邮件发送者显是名称 */
    private String emailFromName;

    /** 数据源id */
    private Long datasourceId;

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

    /** sellerType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerTypeExpression;

    /** 与 max(sellerType) 映射**/
    private Long maxSellerType;

    /** 与 min(sellerType) 映射**/
    private Long minSellerType;

    /** 与 avg(sellerType) 映射**/
    private Long avgSellerType;

    /** 与 count(sellerType) 映射**/
    private Long countSellerType;

    /** 与 count(distinctsellerType) 映射**/
    private Long countDistinctSellerType;

    /** 与 sum(sellerType) 映射**/
    private String sumSellerType;

    /** sellerName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerNameExpression;

    /** 与 max(sellerName) 映射**/
    private Long maxSellerName;

    /** 与 min(sellerName) 映射**/
    private Long minSellerName;

    /** 与 avg(sellerName) 映射**/
    private Long avgSellerName;

    /** 与 count(sellerName) 映射**/
    private Long countSellerName;

    /** 与 count(distinctsellerName) 映射**/
    private Long countDistinctSellerName;

    /** 与 sum(sellerName) 映射**/
    private String sumSellerName;

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

    /** phone属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String phoneExpression;

    /** 与 max(phone) 映射**/
    private Long maxPhone;

    /** 与 min(phone) 映射**/
    private Long minPhone;

    /** 与 avg(phone) 映射**/
    private Long avgPhone;

    /** 与 count(phone) 映射**/
    private Long countPhone;

    /** 与 count(distinctphone) 映射**/
    private Long countDistinctPhone;

    /** 与 sum(phone) 映射**/
    private String sumPhone;

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

    /** address属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String addressExpression;

    /** 与 max(address) 映射**/
    private Long maxAddress;

    /** 与 min(address) 映射**/
    private Long minAddress;

    /** 与 avg(address) 映射**/
    private Long avgAddress;

    /** 与 count(address) 映射**/
    private Long countAddress;

    /** 与 count(distinctaddress) 映射**/
    private Long countDistinctAddress;

    /** 与 sum(address) 映射**/
    private String sumAddress;

    /** wxNo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxNoExpression;

    /** 与 max(wxNo) 映射**/
    private Long maxWxNo;

    /** 与 min(wxNo) 映射**/
    private Long minWxNo;

    /** 与 avg(wxNo) 映射**/
    private Long avgWxNo;

    /** 与 count(wxNo) 映射**/
    private Long countWxNo;

    /** 与 count(distinctwxNo) 映射**/
    private Long countDistinctWxNo;

    /** 与 sum(wxNo) 映射**/
    private String sumWxNo;

    /** wxAppId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxAppIdExpression;

    /** 与 max(wxAppId) 映射**/
    private Long maxWxAppId;

    /** 与 min(wxAppId) 映射**/
    private Long minWxAppId;

    /** 与 avg(wxAppId) 映射**/
    private Long avgWxAppId;

    /** 与 count(wxAppId) 映射**/
    private Long countWxAppId;

    /** 与 count(distinctwxAppId) 映射**/
    private Long countDistinctWxAppId;

    /** 与 sum(wxAppId) 映射**/
    private String sumWxAppId;

    /** wxAppSecret属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxAppSecretExpression;

    /** 与 max(wxAppSecret) 映射**/
    private Long maxWxAppSecret;

    /** 与 min(wxAppSecret) 映射**/
    private Long minWxAppSecret;

    /** 与 avg(wxAppSecret) 映射**/
    private Long avgWxAppSecret;

    /** 与 count(wxAppSecret) 映射**/
    private Long countWxAppSecret;

    /** 与 count(distinctwxAppSecret) 映射**/
    private Long countDistinctWxAppSecret;

    /** 与 sum(wxAppSecret) 映射**/
    private String sumWxAppSecret;

    /** wxAccessToken属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxAccessTokenExpression;

    /** 与 max(wxAccessToken) 映射**/
    private Long maxWxAccessToken;

    /** 与 min(wxAccessToken) 映射**/
    private Long minWxAccessToken;

    /** 与 avg(wxAccessToken) 映射**/
    private Long avgWxAccessToken;

    /** 与 count(wxAccessToken) 映射**/
    private Long countWxAccessToken;

    /** 与 count(distinctwxAccessToken) 映射**/
    private Long countDistinctWxAccessToken;

    /** 与 sum(wxAccessToken) 映射**/
    private String sumWxAccessToken;

    /** wxRefreshToken属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxRefreshTokenExpression;

    /** 与 max(wxRefreshToken) 映射**/
    private Long maxWxRefreshToken;

    /** 与 min(wxRefreshToken) 映射**/
    private Long minWxRefreshToken;

    /** 与 avg(wxRefreshToken) 映射**/
    private Long avgWxRefreshToken;

    /** 与 count(wxRefreshToken) 映射**/
    private Long countWxRefreshToken;

    /** 与 count(distinctwxRefreshToken) 映射**/
    private Long countDistinctWxRefreshToken;

    /** 与 sum(wxRefreshToken) 映射**/
    private String sumWxRefreshToken;

    /** wxJsapiTicket属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxJsapiTicketExpression;

    /** 与 max(wxJsapiTicket) 映射**/
    private Long maxWxJsapiTicket;

    /** 与 min(wxJsapiTicket) 映射**/
    private Long minWxJsapiTicket;

    /** 与 avg(wxJsapiTicket) 映射**/
    private Long avgWxJsapiTicket;

    /** 与 count(wxJsapiTicket) 映射**/
    private Long countWxJsapiTicket;

    /** 与 count(distinctwxJsapiTicket) 映射**/
    private Long countDistinctWxJsapiTicket;

    /** 与 sum(wxJsapiTicket) 映射**/
    private String sumWxJsapiTicket;

    /** wxTokenExpire属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxTokenExpireExpression;

    /** 与 max(wxTokenExpire) 映射**/
    private Long maxWxTokenExpire;

    /** 与 min(wxTokenExpire) 映射**/
    private Long minWxTokenExpire;

    /** 与 avg(wxTokenExpire) 映射**/
    private Long avgWxTokenExpire;

    /** 与 count(wxTokenExpire) 映射**/
    private Long countWxTokenExpire;

    /** 与 count(distinctwxTokenExpire) 映射**/
    private Long countDistinctWxTokenExpire;

    /** 与 sum(wxTokenExpire) 映射**/
    private Date sumWxTokenExpire;

    /** appId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String appIdExpression;

    /** 与 max(appId) 映射**/
    private Long maxAppId;

    /** 与 min(appId) 映射**/
    private Long minAppId;

    /** 与 avg(appId) 映射**/
    private Long avgAppId;

    /** 与 count(appId) 映射**/
    private Long countAppId;

    /** 与 count(distinctappId) 映射**/
    private Long countDistinctAppId;

    /** 与 sum(appId) 映射**/
    private String sumAppId;

    /** appSecret属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String appSecretExpression;

    /** 与 max(appSecret) 映射**/
    private Long maxAppSecret;

    /** 与 min(appSecret) 映射**/
    private Long minAppSecret;

    /** 与 avg(appSecret) 映射**/
    private Long avgAppSecret;

    /** 与 count(appSecret) 映射**/
    private Long countAppSecret;

    /** 与 count(distinctappSecret) 映射**/
    private Long countDistinctAppSecret;

    /** 与 sum(appSecret) 映射**/
    private String sumAppSecret;

    /** accessToken属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String accessTokenExpression;

    /** 与 max(accessToken) 映射**/
    private Long maxAccessToken;

    /** 与 min(accessToken) 映射**/
    private Long minAccessToken;

    /** 与 avg(accessToken) 映射**/
    private Long avgAccessToken;

    /** 与 count(accessToken) 映射**/
    private Long countAccessToken;

    /** 与 count(distinctaccessToken) 映射**/
    private Long countDistinctAccessToken;

    /** 与 sum(accessToken) 映射**/
    private String sumAccessToken;

    /** refreshToken属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String refreshTokenExpression;

    /** 与 max(refreshToken) 映射**/
    private Long maxRefreshToken;

    /** 与 min(refreshToken) 映射**/
    private Long minRefreshToken;

    /** 与 avg(refreshToken) 映射**/
    private Long avgRefreshToken;

    /** 与 count(refreshToken) 映射**/
    private Long countRefreshToken;

    /** 与 count(distinctrefreshToken) 映射**/
    private Long countDistinctRefreshToken;

    /** 与 sum(refreshToken) 映射**/
    private String sumRefreshToken;

    /** wxMchid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxMchidExpression;

    /** 与 max(wxMchid) 映射**/
    private Long maxWxMchid;

    /** 与 min(wxMchid) 映射**/
    private Long minWxMchid;

    /** 与 avg(wxMchid) 映射**/
    private Long avgWxMchid;

    /** 与 count(wxMchid) 映射**/
    private Long countWxMchid;

    /** 与 count(distinctwxMchid) 映射**/
    private Long countDistinctWxMchid;

    /** 与 sum(wxMchid) 映射**/
    private String sumWxMchid;

    /** wxSecrteUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxSecrteUrlExpression;

    /** 与 max(wxSecrteUrl) 映射**/
    private Long maxWxSecrteUrl;

    /** 与 min(wxSecrteUrl) 映射**/
    private Long minWxSecrteUrl;

    /** 与 avg(wxSecrteUrl) 映射**/
    private Long avgWxSecrteUrl;

    /** 与 count(wxSecrteUrl) 映射**/
    private Long countWxSecrteUrl;

    /** 与 count(distinctwxSecrteUrl) 映射**/
    private Long countDistinctWxSecrteUrl;

    /** 与 sum(wxSecrteUrl) 映射**/
    private String sumWxSecrteUrl;

    /** wxTicketExpire属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxTicketExpireExpression;

    /** 与 max(wxTicketExpire) 映射**/
    private Long maxWxTicketExpire;

    /** 与 min(wxTicketExpire) 映射**/
    private Long minWxTicketExpire;

    /** 与 avg(wxTicketExpire) 映射**/
    private Long avgWxTicketExpire;

    /** 与 count(wxTicketExpire) 映射**/
    private Long countWxTicketExpire;

    /** 与 count(distinctwxTicketExpire) 映射**/
    private Long countDistinctWxTicketExpire;

    /** 与 sum(wxTicketExpire) 映射**/
    private Date sumWxTicketExpire;

    /** wxAppKey属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxAppKeyExpression;

    /** 与 max(wxAppKey) 映射**/
    private Long maxWxAppKey;

    /** 与 min(wxAppKey) 映射**/
    private Long minWxAppKey;

    /** 与 avg(wxAppKey) 映射**/
    private Long avgWxAppKey;

    /** 与 count(wxAppKey) 映射**/
    private Long countWxAppKey;

    /** 与 count(distinctwxAppKey) 映射**/
    private Long countDistinctWxAppKey;

    /** 与 sum(wxAppKey) 映射**/
    private String sumWxAppKey;

    /** wxImgUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxImgUrlExpression;

    /** 与 max(wxImgUrl) 映射**/
    private Long maxWxImgUrl;

    /** 与 min(wxImgUrl) 映射**/
    private Long minWxImgUrl;

    /** 与 avg(wxImgUrl) 映射**/
    private Long avgWxImgUrl;

    /** 与 count(wxImgUrl) 映射**/
    private Long countWxImgUrl;

    /** 与 count(distinctwxImgUrl) 映射**/
    private Long countDistinctWxImgUrl;

    /** 与 sum(wxImgUrl) 映射**/
    private String sumWxImgUrl;

    /** wxQrcode属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxQrcodeExpression;

    /** 与 max(wxQrcode) 映射**/
    private Long maxWxQrcode;

    /** 与 min(wxQrcode) 映射**/
    private Long minWxQrcode;

    /** 与 avg(wxQrcode) 映射**/
    private Long avgWxQrcode;

    /** 与 count(wxQrcode) 映射**/
    private Long countWxQrcode;

    /** 与 count(distinctwxQrcode) 映射**/
    private Long countDistinctWxQrcode;

    /** 与 sum(wxQrcode) 映射**/
    private String sumWxQrcode;

    /** smsSerial属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String smsSerialExpression;

    /** 与 max(smsSerial) 映射**/
    private Long maxSmsSerial;

    /** 与 min(smsSerial) 映射**/
    private Long minSmsSerial;

    /** 与 avg(smsSerial) 映射**/
    private Long avgSmsSerial;

    /** 与 count(smsSerial) 映射**/
    private Long countSmsSerial;

    /** 与 count(distinctsmsSerial) 映射**/
    private Long countDistinctSmsSerial;

    /** 与 sum(smsSerial) 映射**/
    private String sumSmsSerial;

    /** smsNotifySign属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String smsNotifySignExpression;

    /** 与 max(smsNotifySign) 映射**/
    private Long maxSmsNotifySign;

    /** 与 min(smsNotifySign) 映射**/
    private Long minSmsNotifySign;

    /** 与 avg(smsNotifySign) 映射**/
    private Long avgSmsNotifySign;

    /** 与 count(smsNotifySign) 映射**/
    private Long countSmsNotifySign;

    /** 与 count(distinctsmsNotifySign) 映射**/
    private Long countDistinctSmsNotifySign;

    /** 与 sum(smsNotifySign) 映射**/
    private String sumSmsNotifySign;

    /** smsSaleSign属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String smsSaleSignExpression;

    /** 与 max(smsSaleSign) 映射**/
    private Long maxSmsSaleSign;

    /** 与 min(smsSaleSign) 映射**/
    private Long minSmsSaleSign;

    /** 与 avg(smsSaleSign) 映射**/
    private Long avgSmsSaleSign;

    /** 与 count(smsSaleSign) 映射**/
    private Long countSmsSaleSign;

    /** 与 count(distinctsmsSaleSign) 映射**/
    private Long countDistinctSmsSaleSign;

    /** 与 sum(smsSaleSign) 映射**/
    private String sumSmsSaleSign;

    /** emailSign属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String emailSignExpression;

    /** 与 max(emailSign) 映射**/
    private Long maxEmailSign;

    /** 与 min(emailSign) 映射**/
    private Long minEmailSign;

    /** 与 avg(emailSign) 映射**/
    private Long avgEmailSign;

    /** 与 count(emailSign) 映射**/
    private Long countEmailSign;

    /** 与 count(distinctemailSign) 映射**/
    private Long countDistinctEmailSign;

    /** 与 sum(emailSign) 映射**/
    private String sumEmailSign;

    /** emailFromName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String emailFromNameExpression;

    /** 与 max(emailFromName) 映射**/
    private Long maxEmailFromName;

    /** 与 min(emailFromName) 映射**/
    private Long minEmailFromName;

    /** 与 avg(emailFromName) 映射**/
    private Long avgEmailFromName;

    /** 与 count(emailFromName) 映射**/
    private Long countEmailFromName;

    /** 与 count(distinctemailFromName) 映射**/
    private Long countDistinctEmailFromName;

    /** 与 sum(emailFromName) 映射**/
    private String sumEmailFromName;

    /** datasourceId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String datasourceIdExpression;

    /** 与 max(datasourceId) 映射**/
    private Long maxDatasourceId;

    /** 与 min(datasourceId) 映射**/
    private Long minDatasourceId;

    /** 与 avg(datasourceId) 映射**/
    private Long avgDatasourceId;

    /** 与 count(datasourceId) 映射**/
    private Long countDatasourceId;

    /** 与 count(distinctdatasourceId) 映射**/
    private Long countDistinctDatasourceId;

    /** 与 sum(datasourceId) 映射**/
    private Long sumDatasourceId;

    private List<SellerShop> sellerShopList;
}