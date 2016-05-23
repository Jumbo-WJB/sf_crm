package com.shufensoft.crm.web.controller.express;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.service.express.service.ExpressService;
import com.shufensoft.crm.biz.vo.WXMessageQueryVO;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author lisen  lisen@suniusoft.com
 *  @date 15/7/02 上午8:49  
 */
@Controller
public class ExpressController extends BaseController{
    @Autowired
    private ExpressService expressService;

    @RequestMapping(value = "/express/list")
    public ModelAndView getExpressDetail() {
        ModelAndView mv = new ModelAndView("/express/expressQueryDetail");
        return mv;
    }

    @RequestMapping(value = "/express/queryDetailList")
    @ResponseBody
    public Map<String, Object> queryExpressDetail (WXMessageQueryVO wxMessageQueryVO,Integer pageNum, Integer length) {

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        //1.从第三方快递接口中分页的形式查询出最新的快递信息, 并且存入到数据库中
        expressService.getExpressDetailsAndUpdate(wxMessageQueryVO, pageNum, length);
//        expressService.findExpressInfoByUserId(980522626L);
        //2.先从缓存中取值

        PageInfo pageInfo = expressService.queryExpressDetail(wxMessageQueryVO, pageNum, length);

        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }


}
