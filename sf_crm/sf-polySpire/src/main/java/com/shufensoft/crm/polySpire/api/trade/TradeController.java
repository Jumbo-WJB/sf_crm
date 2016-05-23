package com.shufensoft.crm.polySpire.api.trade;

import com.google.common.collect.Maps;
import com.shufensoft.crm.polySpire.api.base.BaseController;
import com.shufensoft.crm.polySpire.api.vo.TaoBaoTradeVO;
import com.shufensoft.crm.polySpire.biz.service.trade.PolySpireTaoBaoTradeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/7  
 */
@Controller
public class TradeController extends BaseController {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(TradeController.class);

    private static SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private PolySpireTaoBaoTradeService polySpireTaoBaoTradeService;

    /**
     * 分页获取交易信息
     * @param startDate
     * @param endDate
     * @param start
     * @param pageSize
     * @return
     */
    @RequestMapping("/trade/fullInfo")
    public
    @ResponseBody
    Map<String, Object> tradeFullinfoGet(String startDate, String endDate, Integer start, Integer pageSize) {

        if (start == null || start <= 0) {
            start = 1;
        }

        if(pageSize == null || pageSize <= 0){
            pageSize = PAGE_SIZE;
        }

        Map<String, Object> datas = Maps.newHashMap();

        List<TaoBaoTradeVO> taoBaoTradeVOs = null;
        try {
            Date startD = simpleDateFormat.parse(startDate);
            Date endD = simpleDateFormat.parse(endDate);
            taoBaoTradeVOs = polySpireTaoBaoTradeService.quaryTradeByDate(startD,endD,start,pageSize);
        }catch (Exception e){
            logger.error("tradeController.tradeFullinfoGet error",e);
            datas.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            datas.put(ERROR_MESSAGE_KEY,e.getMessage());
            return datas;
        }

        datas.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        datas.put(INFO_KEY, taoBaoTradeVOs);

        return datas;
    }




}
