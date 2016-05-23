package com.shufensoft.crm.biz.service.dataindex.impl;

import com.shufensoft.crm.biz.domain.generation.comment.CommentJD;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;
import com.shufensoft.crm.biz.service.dataindex.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-31 14:51  
 */
public class DiCommentGoodRate extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diCommentGoodRate";
        this.description = "好评率";
        this.dataList = Arrays.asList(DataTypeEnum.COMMENT_TB, DataTypeEnum.COMMENT_JD);
        this.platformList = Arrays.asList(PlatformEnum.TB, PlatformEnum.JD);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {

        return  new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {

        int goodCnt = 0, totalCnt = 0;

        List<CommentTaoBao> commentTaoBaoList = rawData.getCommentTaoBaoList();
        if(!CollectionUtils.isEmpty(commentTaoBaoList)) {
            for (CommentTaoBao commentTaoBao : commentTaoBaoList) {
                String comment = commentTaoBao.getResult();
                if (StringUtils.isNotEmpty(comment)) {
                    if (comment.equalsIgnoreCase("good")) {
                        goodCnt++;
                    }
                    totalCnt++;
                }
            }
        }

        List<CommentJD> commentJDList = rawData.getCommentJDList();
        if(!CollectionUtils.isEmpty(commentJDList)) {
            for (CommentJD commentJD : commentJDList) {
                int score = commentJD.getScore();
                if (score == 5) {
                    goodCnt++;
                }
                totalCnt++;
            }
        }

        if(totalCnt == 0) {
            return new DataIndexResult(-1d);
        } else {
            java.text.DecimalFormat df = new java.text.DecimalFormat("#.00%");
            return new DataIndexResult(goodCnt * 100d / totalCnt);
        }
    }

}
