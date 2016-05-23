package com.shufensoft.crm.polySpire.biz.service.comment;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;

import java.util.Date;
import java.util.List;

/** 
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                淘宝评价service
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/25  
 */
@DataSourceSwitch
public interface TaoBaoTradeRateService {

    /**
     * 保存评价信息
     *
     * @param commentTaoBaos
     * @return
     */
    public boolean saveCommentToPolySpire(Long sellerId, Long shopId , List<CommentTaoBao> commentTaoBaos);


    /**
     * 同步评价信息用
     *
     * @param commentTaoBaos
     * @return
     */
    public boolean syncCommentFromPolySpireToCrm(Long sellerId, Long shopId , List<CommentTaoBao> commentTaoBaos);


    /**
     * 拉取淘宝评价信息
     * @param sellerId
     * @param tid
     * @param pageNo
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId,Long shopId, Long tid, Long pageNo,Long pageSize, Date startDate, Date endDate);


    /**
     * 拉取淘宝评价信息
     * @param sellerId
     * @param tid
     * @param shopId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId, Long shopId,  Long tid, Long pageNo, Long pageSize);


    /**
     * 拉取淘宝评价信息
     * @param sellerId
     * @param tid
     * @param pageNo
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId,  Long shopId, Long tid, Long pageNo);

    /**
     * 拉取淘宝评价信息
     * @param sellerId
     * @param tid
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId, Long shopId, Long tid);

    /**
     * 拉取淘宝评价信息
     * @param sellerId
     * @param pageNo
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId,  Long shopId, Long pageNo, Long pageSize,Date startDate, Date endDate);

    /**
     * 拉取淘宝评价信息
     * @param sellerId
     * @param pageNo
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId,  Long shopId, Long pageNo, Date startDate, Date endDate);
}
