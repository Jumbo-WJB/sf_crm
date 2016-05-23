package com.shufensoft.crm.web.controller.officalWebsite;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.service.onlineMessage.OnlineMessageService;
import com.shufensoft.crm.biz.vo.OnlineMessageVO;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;


/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>官网留言信息处理类
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/8/19  
 */
@Controller
public class ContactUsController extends BaseController{

    private static final Logger logger = Logger.getLogger(ContactUsController.class);

    @Autowired
    private OnlineMessageService onlineMessageService;

    @RequestMapping(value = "/officialWebsite/contact")
    public
    @ResponseBody Map<String, Object> leaveMessage(@Valid OnlineMessageVO onlineMessageVO){
        Map<String, Object> map = Maps.newHashMap();

        try {
            if (onlineMessageService.insertOrUpdateMessage(onlineMessageVO)){
                map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            }
        }catch (Exception e){
            logger.error("ContactUsController leaveMessage occur error,",e);
        }

        return map;
    }
}
