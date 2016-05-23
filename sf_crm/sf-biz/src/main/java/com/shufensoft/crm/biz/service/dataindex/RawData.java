package com.shufensoft.crm.biz.service.dataindex;

import com.shufensoft.crm.biz.domain.generation.comment.CommentJD;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.*;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserInteractionDetail;
import com.shufensoft.crm.biz.domain.generation.user.UserInteractionStatistic;
import com.shufensoft.crm.biz.domain.generation.user.UserTaoBao;
import lombok.Data;

import java.util.List;

/**
 *  
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-28 13:55  
 */
@Data
public class RawData {

    private List<TradeTaoBao> tradeTaoBaoList;

    private List<TradeYZ> tradeYZList;

    private List<OrderYZ> orderYZList;

    private List<OrderJD> orderJdList;

    private List<OrderTaoBao> orderTaoBaoList;

    private List<CommentTaoBao> commentTaoBaoList;

    private List<ReceiverTaoBao> receiverTaoBaoList;

    private List<UserTaoBao> userTaoBaoList;

    private List<User> userList;

    private List<UserInteractionStatistic> userInteractionStatisticList;

    private List<UserInteractionDetail> userInteractionDetailList;

    private Long userInteractionDetailCount;

    private List<OrderJD> orderJDList;

    private List<ItemInfoJD> itemInfoJDList;

    private List<CommentJD> commentJDList;

}
