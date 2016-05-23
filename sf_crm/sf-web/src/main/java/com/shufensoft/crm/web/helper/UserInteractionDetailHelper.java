package com.shufensoft.crm.web.helper;

import com.shufensoft.crm.biz.cache.LstOfValCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.system.LstOfVal;
import com.shufensoft.crm.biz.service.user.UserInteractionDetailService;
import com.shufensoft.crm.biz.service.user.vo.UserInteractionDetailVO;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 活动帮助类
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/8/29  
 */
public class UserInteractionDetailHelper {


    private static UserInteractionDetailService userInteractionDetailService = (UserInteractionDetailService)SpringContextUtil.getBean("userInteractionDetailService");

    /**
     * 记录互动信息
     * @param request
     */
    public static  void recordUserInteractionDetail(HttpServletRequest request){

        String sellerId = request.getParameter("sellerId");
        String userId = request.getParameter("userId");

        if(StringUtils.isBlank(sellerId) || StringUtils.isBlank(userId)){
            return;
        }

        String url = request.getServletPath();

        List<LstOfVal> lstOfVals = LstOfValCache.getTypeList("INTERACTION_CONFIG");

        for(LstOfVal lstOfVal : lstOfVals){

            if(lstOfVal.getValue().equals(url)){

                String bizId = request.getParameter(lstOfVal.getValue01());
                String interactionType = request.getParameter(lstOfVal.getValue02());
                String iteractionEntry = request.getParameter(lstOfVal.getValue03());

                UserInteractionDetailVO userInteractionDetailVO = new UserInteractionDetailVO();
                userInteractionDetailVO.setSellerId(Long.valueOf(sellerId));
                userInteractionDetailVO.setUserId(Long.valueOf(userId));
                userInteractionDetailVO.setInteractionTime(new Date());

                String bizIdStr = StringUtils.isBlank(bizId)?lstOfVal.getValue01():bizId;
                userInteractionDetailVO.setBizId(StringUtils.isNotBlank(bizIdStr)?Long.parseLong(bizIdStr):null);

                String interactionTypeStr = StringUtils.isBlank(interactionType)?lstOfVal.getValue02():interactionType;

                String iteractionEntryStr = StringUtils.isBlank(iteractionEntry)?lstOfVal.getValue03():iteractionEntry;

                userInteractionDetailVO.setInteractionType(interactionTypeStr);
                userInteractionDetailVO.setInteractionEntry(StringUtils.isBlank(iteractionEntryStr)? DaoConstant.IteractionEntry.LINK : iteractionEntryStr);

                userInteractionDetailService.saveUserInteractionDetail(userInteractionDetailVO);

                return;

            }

        }

    }


}
