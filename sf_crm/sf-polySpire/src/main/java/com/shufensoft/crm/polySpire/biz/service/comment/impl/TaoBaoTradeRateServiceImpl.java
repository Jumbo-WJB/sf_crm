package com.shufensoft.crm.polySpire.biz.service.comment.impl;

import com.shufensoft.crm.biz.dao.generation.comment.CommentTaoBaoMapper;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBaoExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.polySpire.adapter.CrmAdapter;
import com.shufensoft.crm.polySpire.adapter.TaoBaoAdapter;
import com.shufensoft.crm.polySpire.biz.service.comment.TaoBaoTradeRateService;
import com.taobao.api.response.TraderatesGetResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/1  
 */
@Service(value = "taoBaoTradeRateService")
public class TaoBaoTradeRateServiceImpl implements TaoBaoTradeRateService {

    private static final Logger logger = Logger.getLogger(TaoBaoTradeRateServiceImpl.class);

    @Autowired
    private CommentTaoBaoMapper commentTaoBaoMapper;

    private static CrmAdapter crmAdapter = new CrmAdapter();

    private static TaoBaoAdapter taoBaoAdapter = new TaoBaoAdapter();

    /**
     * 保存评价信息
     *
     * @param commentTaoBaos
     * @return
     */
    public boolean saveCommentToPolySpire(Long sellerId , Long shopId , List<CommentTaoBao> commentTaoBaos) {

        AssertsUtil.notNull(commentTaoBaos, "commentTaoBaos");

        for (CommentTaoBao commentTaoBao : commentTaoBaos) {
            commentTaoBao.setUserIdTb(0l);
            try {
                saveOrUpdateCommentToPolySpire(sellerId , shopId , commentTaoBao);
            }catch (Exception e){
                String message = e.getMessage()==null?e.toString():e.getMessage();
                throw new ServiceException("TaoBaoTradeRateServiceImpl.saveCommentToPolySpire error,errorMsg:"+message,e);
            }

        }

        return true;
    }


    /**
     * 保存评价信息
     * @param commentTaoBao
     * @return
     */
    public boolean saveOrUpdateCommentToPolySpire(Long sellerId , Long shopId , CommentTaoBao commentTaoBao) {

        AssertsUtil.notNull(commentTaoBao, "commentTaoBao");

        AssertsUtil.notNull(sellerId, "sellerId");

        AssertsUtil.notNull(shopId, "shopId");

        CommentTaoBaoExample commentTaoBaoExample = new CommentTaoBaoExample();
        commentTaoBaoExample.createCriteria().andOidEqualTo(commentTaoBao.getOid());
        List<CommentTaoBao> commentTaoBaos = commentTaoBaoMapper.selectByExample(commentTaoBaoExample);
        commentTaoBao.setSellerId(sellerId);
        commentTaoBao.setShopId(shopId);
        if(CollectionUtils.isEmpty(commentTaoBaos)) {
            commentTaoBao.setUserIdTb(0l);
            commentTaoBaoMapper.insert(commentTaoBao);
            logger.info("insert comment success,oid="+commentTaoBao.getOid());

        }else{
            commentTaoBao.setId(commentTaoBaos.get(0).getId());
            int updateFlg = commentTaoBaoMapper.updateByPrimaryKeySelective(commentTaoBao);
            if(updateFlg>0){
                logger.info("update comment success,oid="+commentTaoBao.getOid());
            }else{
                logger.error("update comment error,oid=" + commentTaoBao.getOid());
            }

        }

        return true;
    }

    /**
     * 同步评价信息用
     *
     * @param commentTaoBaos
     * @return
     */
    public boolean syncCommentFromPolySpireToCrm(Long sellerId , Long shopId , List<CommentTaoBao> commentTaoBaos) {
        return crmAdapter.syncComment(sellerId, shopId , commentTaoBaos);
    }


    /**
     * 拉取淘宝评价信息
     *
     * @param sellerId
     * @param tid
     * @param pageNo
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId, Long shopId, Long tid, Long pageNo, Long pageSize, Date startDate, Date endDate) {

        TraderatesGetResponse traderatesGetResponse;

        if (pageNo == null || pageNo == 0) {
            pageNo = 1L;
        }

        if (pageSize == null || pageSize == 0) {
            pageSize = 150L;
        }


        do {

            try {

                traderatesGetResponse = taoBaoAdapter.pullTaoBaoTradeRate(sellerId, shopId, tid, pageNo, pageSize, startDate, endDate);

                if (!CollectionUtils.isEmpty(traderatesGetResponse.getTradeRates())) {

                    List<CommentTaoBao> commentTaoBaos = (List<CommentTaoBao>) BeanCopierUtils.copyListProperties(traderatesGetResponse.getTradeRates(), CommentTaoBao.class);
                    saveCommentToPolySpire(sellerId , shopId , commentTaoBaos);
                    syncCommentFromPolySpireToCrm(sellerId , shopId , commentTaoBaos);

                }

            } catch (Exception e) {

                throw new RuntimeException("TaoBaoTradeRateService.pullTaoBaoTradeRates[startDate="
                        + DateUtil.getDateToString(startDate)+",endDate="
                        + DateUtil.getDateToString(endDate)+"] error;errorMsg:"
                        +(e.getMessage()==null?e.toString():e.getMessage()), e);

            }

            pageNo++;

        } while (traderatesGetResponse != null && traderatesGetResponse.getHasNext());


        return true;

    }

    /**
     * 拉取淘宝评价信息
     *
     * @param sellerId
     * @param tid
     * @param pageNo
     * @param pageSize
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId, Long shopId, Long tid, Long pageNo, Long pageSize) {

        return pullTaoBaoTradeRates(sellerId, shopId,tid, pageNo, pageSize, null, null);

    }

    /**
     * 拉取淘宝评价信息
     *
     * @param sellerId
     * @param tid
     * @param pageNo
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId, Long shopId, Long tid, Long pageNo) {

        return pullTaoBaoTradeRates(sellerId, shopId,tid, pageNo, null, null, null);

    }

    /**
     * 拉取淘宝评价信息
     *
     * @param sellerId
     * @param tid
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId,  Long shopId, Long tid) {

        return pullTaoBaoTradeRates(sellerId, shopId,  tid, null, null, null, null);

    }

    /**
     * 拉取淘宝评价信息
     *
     * @param sellerId
     * @param pageNo
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId,  Long shopId, Long pageNo, Long pageSize, Date startDate, Date endDate) {

        return pullTaoBaoTradeRates(sellerId, shopId,  null, pageNo, pageSize, startDate, endDate);

    }

    /**
     * 拉取淘宝评价信息
     *
     * @param sellerId
     * @param pageNo
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean pullTaoBaoTradeRates(Long sellerId,  Long shopId, Long pageNo, Date startDate, Date endDate) {

        return pullTaoBaoTradeRates(sellerId, shopId,  null, pageNo, null, startDate, endDate);

    }
}
