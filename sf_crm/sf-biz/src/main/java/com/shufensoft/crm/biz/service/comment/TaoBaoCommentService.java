package com.shufensoft.crm.biz.service.comment;

import com.shufensoft.crm.biz.dao.generation.comment.CommentTaoBaoMapper;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBaoExample;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.comment.vo.CommentTaoBaoVO;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                  淘宝评价service
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/25  
 */
@Service
public class TaoBaoCommentService {


    private static final Logger logger = Logger.getLogger(TaoBaoCommentService.class);

    @Autowired
    private CommentTaoBaoMapper commentTaoBaoMapper;

    @Autowired
    private TaoBaoTradeService taoBaoTradeService;

    /**
     * 保存评价信息
     * @param commentTaoBaoVOs
     * @return
     */
    public boolean saveComments(List<CommentTaoBaoVO> commentTaoBaoVOs){

        AssertsUtil.notNull(commentTaoBaoVOs,"commentTaoBaoVOs");
        for(CommentTaoBaoVO commentTaoBaoVO : commentTaoBaoVOs){
            saveOrUpdateComment(commentTaoBaoVO);
        }

        return true;
    }

    /**
     * 保存评价信息
     * @param commentTaoBaoVO
     * @return
     */
    public boolean saveOrUpdateComment(CommentTaoBaoVO commentTaoBaoVO){

        AssertsUtil.notNull(commentTaoBaoVO,"commentTaoBaoVO");
        CommentTaoBao commentTaoBao;
        try {
            commentTaoBao = (CommentTaoBao)BeanCopierUtils.copyProperties(commentTaoBaoVO,CommentTaoBao.class);
        } catch (Exception e) {
           throw new ServiceException("TaoBaoCommentService.saveComment",e);
        }

        AssertsUtil.notNull(commentTaoBao,"commentTaoBao");

        if(commentTaoBao.getUserIdTb() == null || commentTaoBao.getUserIdTb()==0){
            TradeTaoBao tradeTaoBao = taoBaoTradeService.selectTradeTaoBaoByTid(commentTaoBao.getTid());
            if(tradeTaoBao!=null){
                commentTaoBao.setUserIdTb(tradeTaoBao.getUserIdTb());
            }else{
                commentTaoBao.setUserIdTb(0l);
            }

        }

        CommentTaoBaoExample commentTaoBaoExample = new CommentTaoBaoExample();
        commentTaoBaoExample.createCriteria().andOidEqualTo(commentTaoBao.getOid());
        List<CommentTaoBao> commentTaoBaos = commentTaoBaoMapper.selectByExample(commentTaoBaoExample);

        if(CollectionUtils.isEmpty(commentTaoBaos)) {

            if(StringUtils.isNotBlank(commentTaoBao.getContent())){
                commentTaoBaoMapper.insert(commentTaoBao);
                logger.info("insert comment success,oid="+commentTaoBao.getOid());
            }

        }else{

            commentTaoBao.setId(commentTaoBaos.get(0).getId());
            int updateFlg = commentTaoBaoMapper.updateByPrimaryKeySelective(commentTaoBao);
            if(updateFlg>0){
                logger.info("update comment success,[sellerId=" + commentTaoBao.getSellerId() + ",oid=" + commentTaoBao.getOid()+"]");
            }else{
                logger.error("update comment error,[sellerId=" + commentTaoBao.getSellerId() + ",oid=" + commentTaoBao.getOid()+"]");
            }

        }

        return true;
    }


}
