package com.shufensoft.crm.web.controller.data;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.sellerConfig.SellerConfigService;
import com.shufensoft.crm.biz.vo.SellerShopVO;
import com.shufensoft.crm.common.runner.BizRunner;
import com.shufensoft.crm.common.runner.executor.BizExecutor;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.web.controller.base.BaseController;
import com.shufensoft.crm.web.helper.DataImportHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/23  
 */
@RequestMapping("/data")
@Controller
public class DataImportController extends BaseController {

    private static final Logger logger = Logger.getLogger(DataImportController.class);

    @Autowired
    private SellerConfigService sellerConfigService;

    /**
     * 数据导入页
     *
     * @return
     */
    @RequestMapping("/import/show")
    @ResponseBody
    public ModelAndView tradeImportShow(ModelMap modelMap, HttpSession session) {

        Long selleId = getSellerId(session);
        SellerShopVO sellerShopVO = new SellerShopVO();
        sellerShopVO.setSellerId(selleId);
        List<SellerShop> shopList = sellerConfigService.queryShops(sellerShopVO);

        if (!CollectionUtils.isEmpty(shopList)){
            modelMap.put("shopList",shopList);
        }

        return new ModelAndView("/data/importTrade",modelMap);
    }

    /**
     * 淘宝execel数据导入操作从
     *
     * @return
     */
    @RequestMapping("/import")
    @ResponseBody
    public Map<String, String> tradeImport(@RequestParam("uploadFile") MultipartFile uploadFile, String shopId, HttpSession httpSession) {

        Long sellerId = getSellerId(httpSession);

        Map<String, String> resultMap = Maps.newHashMap();
        resultMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        if (uploadFile == null) {
            resultMap.put(ERROR_MESSAGE_KEY, "导入的文件不能为空！");
            return resultMap;
        }

        if (StringUtils.isBlank(uploadFile.getOriginalFilename()) || uploadFile.getOriginalFilename().indexOf(".csv")==-1) {
            resultMap.put(ERROR_MESSAGE_KEY, "导入的文件格式必须为csv！");
            return resultMap;
        }

        if (StringUtils.isBlank(shopId)) {
            resultMap.put(ERROR_MESSAGE_KEY, "请选择店铺！");
            return resultMap;
        }

        /**
         * 导入的数据量可能会很大，故异步处理
         */
        final MultipartFile csvFile = uploadFile;

        final String shopIdTmp = shopId;
        final String sellerIdTmp = String.valueOf(sellerId);
        final String dataSourceKey = DBContextHolder.getDataSourceKey();

        new BizRunner(new BizExecutor() {
            @Override
            public Boolean execute() {

                try {
                    DBContextHolder.setDataSourceKey(dataSourceKey);
                    return DataImportHelper.importTrade( sellerIdTmp , shopIdTmp , csvFile);
                } catch (Exception e) {
                    logger.error("trade import error[sellerId="+sellerIdTmp+",shopId="+shopIdTmp+"]" + e.getMessage(), e);
                    return false;
                }

            }
        }).start();

        resultMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);

        return resultMap;

    }


    private  Map<String,Object> handleTradeData(HttpServletRequest request) {

        DefaultMultipartHttpServletRequest multipartHttpServletRequest = (DefaultMultipartHttpServletRequest) request;
        String tradeData = multipartHttpServletRequest.getParameter("tradeData");

        Map<String,Object> resultMap = (Map<String,Object>) JSONUtils.parseToObject(tradeData, Map.class);

        resultMap.put("uploadFile",multipartHttpServletRequest.getFile("uploadFile"));

        return resultMap;
    }


}
