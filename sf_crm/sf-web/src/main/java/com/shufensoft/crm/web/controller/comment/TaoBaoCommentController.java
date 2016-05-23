package com.shufensoft.crm.web.controller.comment;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.helper.DatasourceHelper;
import com.shufensoft.crm.biz.service.comment.TaoBaoCommentService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.web.controller.base.BaseController;
import com.shufensoft.crm.web.vo.PolySpireCommentTaoBaoVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                淘宝评价信息Controller
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/25  
 */
@Controller
@RequestMapping("/taobaoComment")
public class TaoBaoCommentController extends BaseController {

    private static final Logger logger = Logger.getLogger(TaoBaoCommentController.class);

    @Autowired
    private TaoBaoCommentService taoBaoCommentService;
    /**
     * 增加评价信息
     * @param polySpireCommentTaoBaoJson
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addComment(@RequestBody String polySpireCommentTaoBaoJson) {

        AssertsUtil.notBlank(polySpireCommentTaoBaoJson, "commentTaoBaoJson");

        PolySpireCommentTaoBaoVO polySpireCommentTaoBaoVO = (PolySpireCommentTaoBaoVO)JSONUtils.parseToObject(polySpireCommentTaoBaoJson,PolySpireCommentTaoBaoVO.class);

        Map<String, Object> datas = Maps.newHashMap();

        try {

            AssertsUtil.notNull(polySpireCommentTaoBaoVO,"polySpireCommentTaoBaoVO");
            AssertsUtil.notNull(polySpireCommentTaoBaoVO.getSellerId(),"sellerId");
            AssertsUtil.notNull(polySpireCommentTaoBaoVO.getSellerId(),"shopId");
            DatasourceHelper.setDatasource(String.valueOf(polySpireCommentTaoBaoVO.getSellerId()));
            taoBaoCommentService.saveComments(polySpireCommentTaoBaoVO.getCommentTaoBaos());

        }catch (Exception e){
            logger.error("TaoBaoCommentController.addComment error",e);
            datas.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            datas.put(ERROR_MESSAGE_KEY,e.getMessage());
            return datas;
        }

        datas.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        datas.put(INFO_KEY, "addComment success");

        return datas;
    }
}
