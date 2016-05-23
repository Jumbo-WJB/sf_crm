package com.shufensoft.crm.biz.domain.generation.comment;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class TmallRateTag {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 内部淘宝评价标签@BizId */
    @BizId
    private Long tagId;

    /** 内部淘宝评价id */
    private Long commentIdTb;

    /** 是否是追加的评论标签1:是;0:否 */
    private Boolean appendTags;

    /** 表示标签的名称 */
    private String tagName;

    /** 表示标签的极性，正极1，负极0 */
    private Boolean posi;

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

    /** tagId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tagIdExpression;

    /** 与 max(tagId) 映射**/
    private Long maxTagId;

    /** 与 min(tagId) 映射**/
    private Long minTagId;

    /** 与 avg(tagId) 映射**/
    private Long avgTagId;

    /** 与 count(tagId) 映射**/
    private Long countTagId;

    /** commentIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String commentIdTbExpression;

    /** 与 max(commentIdTb) 映射**/
    private Long maxCommentIdTb;

    /** 与 min(commentIdTb) 映射**/
    private Long minCommentIdTb;

    /** 与 avg(commentIdTb) 映射**/
    private Long avgCommentIdTb;

    /** 与 count(commentIdTb) 映射**/
    private Long countCommentIdTb;

    /** appendTags属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String appendTagsExpression;

    /** 与 max(appendTags) 映射**/
    private Long maxAppendTags;

    /** 与 min(appendTags) 映射**/
    private Long minAppendTags;

    /** 与 avg(appendTags) 映射**/
    private Long avgAppendTags;

    /** 与 count(appendTags) 映射**/
    private Long countAppendTags;

    /** tagName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tagNameExpression;

    /** 与 max(tagName) 映射**/
    private Long maxTagName;

    /** 与 min(tagName) 映射**/
    private Long minTagName;

    /** 与 avg(tagName) 映射**/
    private Long avgTagName;

    /** 与 count(tagName) 映射**/
    private Long countTagName;

    /** posi属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String posiExpression;

    /** 与 max(posi) 映射**/
    private Long maxPosi;

    /** 与 min(posi) 映射**/
    private Long minPosi;

    /** 与 avg(posi) 映射**/
    private Long avgPosi;

    /** 与 count(posi) 映射**/
    private Long countPosi;
}