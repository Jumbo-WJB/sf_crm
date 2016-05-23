package com.shufensoft.crm.biz.domain.generation.reply;

import com.shufensoft.crm.biz.annotation.Domain;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Domain
@Data
@ToString
public class WxMedia {
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

    /** 图文消息的标题 */
    private String title;

    /** 媒体文件上传后，获取时的唯一标识 */
    private String thumbMediaId;

    /** 是否显示封面，0为false，即不显示，1为true，即显示 */
    private String showCoverPic;

    /** 作者 */
    private String author;

    /** 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空 */
    private String digest;

    /** 图文页的URL */
    private String url;

    /** 图文消息的原文地址，即点击“阅读原文”后的URL */
    private String contentSourceUrl;

    /**  */
    private Long sellerId;

    /** 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS */
    private String content;

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

    /** title属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String titleExpression;

    /** 与 max(title) 映射**/
    private Long maxTitle;

    /** 与 min(title) 映射**/
    private Long minTitle;

    /** 与 avg(title) 映射**/
    private Long avgTitle;

    /** 与 count(title) 映射**/
    private Long countTitle;

    /** 与 count(distincttitle) 映射**/
    private Long countDistinctTitle;

    /** 与 sum(title) 映射**/
    private String sumTitle;

    /** thumbMediaId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String thumbMediaIdExpression;

    /** 与 max(thumbMediaId) 映射**/
    private Long maxThumbMediaId;

    /** 与 min(thumbMediaId) 映射**/
    private Long minThumbMediaId;

    /** 与 avg(thumbMediaId) 映射**/
    private Long avgThumbMediaId;

    /** 与 count(thumbMediaId) 映射**/
    private Long countThumbMediaId;

    /** 与 count(distinctthumbMediaId) 映射**/
    private Long countDistinctThumbMediaId;

    /** 与 sum(thumbMediaId) 映射**/
    private String sumThumbMediaId;

    /** showCoverPic属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String showCoverPicExpression;

    /** 与 max(showCoverPic) 映射**/
    private Long maxShowCoverPic;

    /** 与 min(showCoverPic) 映射**/
    private Long minShowCoverPic;

    /** 与 avg(showCoverPic) 映射**/
    private Long avgShowCoverPic;

    /** 与 count(showCoverPic) 映射**/
    private Long countShowCoverPic;

    /** 与 count(distinctshowCoverPic) 映射**/
    private Long countDistinctShowCoverPic;

    /** 与 sum(showCoverPic) 映射**/
    private String sumShowCoverPic;

    /** author属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String authorExpression;

    /** 与 max(author) 映射**/
    private Long maxAuthor;

    /** 与 min(author) 映射**/
    private Long minAuthor;

    /** 与 avg(author) 映射**/
    private Long avgAuthor;

    /** 与 count(author) 映射**/
    private Long countAuthor;

    /** 与 count(distinctauthor) 映射**/
    private Long countDistinctAuthor;

    /** 与 sum(author) 映射**/
    private String sumAuthor;

    /** digest属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String digestExpression;

    /** 与 max(digest) 映射**/
    private Long maxDigest;

    /** 与 min(digest) 映射**/
    private Long minDigest;

    /** 与 avg(digest) 映射**/
    private Long avgDigest;

    /** 与 count(digest) 映射**/
    private Long countDigest;

    /** 与 count(distinctdigest) 映射**/
    private Long countDistinctDigest;

    /** 与 sum(digest) 映射**/
    private String sumDigest;

    /** url属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String urlExpression;

    /** 与 max(url) 映射**/
    private Long maxUrl;

    /** 与 min(url) 映射**/
    private Long minUrl;

    /** 与 avg(url) 映射**/
    private Long avgUrl;

    /** 与 count(url) 映射**/
    private Long countUrl;

    /** 与 count(distincturl) 映射**/
    private Long countDistinctUrl;

    /** 与 sum(url) 映射**/
    private String sumUrl;

    /** contentSourceUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String contentSourceUrlExpression;

    /** 与 max(contentSourceUrl) 映射**/
    private Long maxContentSourceUrl;

    /** 与 min(contentSourceUrl) 映射**/
    private Long minContentSourceUrl;

    /** 与 avg(contentSourceUrl) 映射**/
    private Long avgContentSourceUrl;

    /** 与 count(contentSourceUrl) 映射**/
    private Long countContentSourceUrl;

    /** 与 count(distinctcontentSourceUrl) 映射**/
    private Long countDistinctContentSourceUrl;

    /** 与 sum(contentSourceUrl) 映射**/
    private String sumContentSourceUrl;

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

    /** content属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String contentExpression;

    /** 与 max(content) 映射**/
    private Long maxContent;

    /** 与 min(content) 映射**/
    private Long minContent;

    /** 与 avg(content) 映射**/
    private Long avgContent;

    /** 与 count(content) 映射**/
    private Long countContent;

    /** 与 count(distinctcontent) 映射**/
    private Long countDistinctContent;

    /** 与 sum(content) 映射**/
    private String sumContent;
}