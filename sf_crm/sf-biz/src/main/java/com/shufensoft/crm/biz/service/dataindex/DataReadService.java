package com.shufensoft.crm.biz.service.dataindex;

import com.shufensoft.crm.biz.dao.generation.comment.CommentJDMapper;
import com.shufensoft.crm.biz.dao.generation.comment.CommentTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.trade.*;
import com.shufensoft.crm.biz.dao.generation.user.UserInteractionDetailMapper;
import com.shufensoft.crm.biz.domain.generation.comment.CommentJD;
import com.shufensoft.crm.biz.domain.generation.comment.CommentJDExample;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBaoExample;
import com.shufensoft.crm.biz.domain.generation.trade.*;
import com.shufensoft.crm.biz.domain.generation.user.UserInteractionDetail;
import com.shufensoft.crm.biz.domain.generation.user.UserInteractionDetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang chenqiang@shufensoft.com
 *  @date 2015-05-28 15:09  
 */
@Service
public class DataReadService {

    @Autowired
    private TradeTaoBaoMapper tradeTaoBaoMapper;

    @Autowired
    private OrderTaoBaoMapper orderTaoBaoMapper;

    @Autowired
    private CommentTaoBaoMapper commentTaoBaoMapper;

    @Autowired
    private OrderJDMapper orderJDMapper;

    @Autowired
    private TradeYZMapper tradeYZMapper;

    @Autowired
    private ItemInfoJDMapper itemInfoJDMapper;

    @Autowired
    private OrderYZMapper orderYZMapper;

    @Autowired
    private CommentJDMapper commentJDMapper;

    @Autowired
    private UserInteractionDetailMapper userInteractionDetailMapper;

    public List<TradeTaoBao> queryTradeTaoBao(long userIdTb) {
        TradeTaoBaoExample tradeTaoBaoExample = new TradeTaoBaoExample();
        tradeTaoBaoExample.createCriteria().andUserIdTbEqualTo(userIdTb);
        return tradeTaoBaoMapper.selectByExample(tradeTaoBaoExample);
    }

    public List<OrderTaoBao> queryOrderTaoBao(long userIdTb) {
        OrderTaoBaoExample orderTaoBaoExample = new OrderTaoBaoExample();
        orderTaoBaoExample.createCriteria().andUserIdTbEqualTo(userIdTb);
        return orderTaoBaoMapper.selectByExample(orderTaoBaoExample);
    }

    public List<CommentTaoBao> queryCommentTaoBao(long userIdTb) {
        CommentTaoBaoExample commentTaoBaoExample = new CommentTaoBaoExample();
        commentTaoBaoExample.createCriteria().andUserIdTbEqualTo(userIdTb);
        return commentTaoBaoMapper.selectByExample(commentTaoBaoExample);
    }

    public List<OrderJD> queryOrderJd(long userIdJd) {
        OrderJDExample orderJdExample = new OrderJDExample();
        orderJdExample.createCriteria().andUserIdJdEqualTo(userIdJd);
        return orderJDMapper.selectByExample(orderJdExample);
    }

    public List<TradeYZ> queryOrderYz(long userIdYz) {

        TradeYZExample tradeYZExample = new TradeYZExample();
        tradeYZExample.createCriteria().andUserIdYzEqualTo(userIdYz);

        return tradeYZMapper.selectByExample(tradeYZExample);

    }

    public List<ItemInfoJD> queryItemInfoJD(long userIdJd) {
        ItemInfoJDExample itemInfoJDExample = new ItemInfoJDExample();
        itemInfoJDExample.createCriteria().andUserIdJdEqualTo(userIdJd);
        return itemInfoJDMapper.selectByExample(itemInfoJDExample);
    }

    public List<OrderYZ> queryOradeYZ(long userIdYz) {

        OrderYZExample orderYZExample = new OrderYZExample();
        orderYZExample.createCriteria().andUserIdYzEqualTo(userIdYz);

        return orderYZMapper.selectByExample(orderYZExample);

    }

    public List<CommentJD> queryCommentJd(long userIdJd) {
        CommentJDExample commentJDExample = new CommentJDExample();
        commentJDExample.createCriteria().andUserIdJdEqualTo(userIdJd);
        return commentJDMapper.selectByExample(commentJDExample);
    }

    public Long queryInteractionDetailCount(long sellerId, long userId) {

        UserInteractionDetailExample userInteractionDetailExample = new UserInteractionDetailExample();
        userInteractionDetailExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId);
        userInteractionDetailExample.setDefinedQueryColumns(true);
        userInteractionDetailExample.addCountIdQueryColumn();

        List<UserInteractionDetail> userInteractionDetails =  userInteractionDetailMapper.selectByExample(userInteractionDetailExample);

        if(CollectionUtils.isEmpty(userInteractionDetails) || userInteractionDetails.get(0).getUserId()==null){
            return 0l;
        }

        return userInteractionDetails.get(0).getCountId();
    }

}
