package com.shufensoft.crm.biz.service.mall;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallFansDo;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallOrderDo;
import com.shufensoft.crm.biz.service.pointmall.MallConstants;
import com.shufensoft.crm.biz.service.pointmall.face.IMallCatPropService;
import com.shufensoft.crm.biz.service.pointmall.vo.GoodsSkuVo;
import com.shufensoft.crm.biz.service.pointmall.vo.GoodsVo;
import com.shufensoft.crm.biz.service.pointmall.vo.PropValue;
import com.shufensoft.crm.biz.service.pointmall.vo.PropValueName;
import com.shufensoft.crm.common.utils.*;
import com.shufensoft.crm.velocity.GeneratorHtml;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/6/23  
 */
public class MallProcess {

    private static Logger log = Logger.getLogger(MallProcess.class);
    private static IMallCatPropService iMallCatPropService;

    static{
        iMallCatPropService = (IMallCatPropService)SpringContextUtil.getBean("mallCategoryService");
    }

    /**
     * 解析前台传过来的属性串
     * @return PropValue  PropValueName
     * */
    public static Object[] getPropValue(String prp){
        PropValue pv = null;
        PropValueName pvn = null;
        List<Long> vidList = new ArrayList<Long>();
        List<String> valueNameList = new ArrayList<String>();
        String prop = prp;
        if(prp.indexOf("_") >= 0){         //针对编辑商品的时候
            prop = prp.split("_")[0];
        }
        if(StringUtils.isNotBlank(prop)){
            String[] arr = prop.split(":");
            pv = new PropValue();
            pvn = new PropValueName();
            pv.setPid(Long.parseLong(arr[0]));
            pvn.setPid(Long.parseLong(arr[0]));
            vidList.add(Long.parseLong(arr[1]));
            pv.setVidList(vidList);
            pvn.setVidList(vidList);
            pvn.setPropName(arr[2]);
            valueNameList.add(arr[3]);
            pvn.setValueNameList(valueNameList);
        }
        return new Object[]{pv,pvn};
    }

    /**
     *  从HTML中抽取商品详情
     * */
    public static String parseHtml(String detailUrl, HttpServletRequest request){
        if(StringUtils.isNotBlank(detailUrl)){
            String flag = File.separator;
            String[] arr = CommonUtil.splitPath(detailUrl);
            if(arr != null && arr.length == 5){
                String parentPath = request.getSession().getServletContext().getRealPath(arr[0] + "/" + arr[1] + "/" + arr[2] + "/" + arr[3]);
                String filePath = parentPath + flag +arr[4];
                return HTMLParseUtil.detailContext(filePath);
            }
        }
        return null;
    }

    /**
     *  导出积分商城粉丝数据
     *  适配 excel 2007
     * */
    public static byte[] formatMallFansDatas(List<MallFansDo> datas){
        try {
            if (datas == null) {
                throw new RuntimeException("datas is null, Cann't export excel file");
            }
            String titile = "粉丝列表";           //标题名字
            String[] columnNames = new String[]{"序号", "微信昵称", "累计兑换金额(元)", "兑换次数", "累计积分", "已兑换积分", "最后一次兑换", "是否老客户", "老客户名称"};
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet1 = workBook.createSheet("粉丝列表");
            sheet1.setColumnWidth(0, 1500);     //设置列宽
            sheet1.setColumnWidth(1, 5000);
            sheet1.setColumnWidth(2, 4000);
            sheet1.setColumnWidth(3, 2000);
            sheet1.setColumnWidth(4, 2000);
            sheet1.setColumnWidth(5, 4000);
            sheet1.setColumnWidth(6, 4000);
            sheet1.setColumnWidth(7, 3000);
            sheet1.setColumnWidth(8, 3000);
            //头标题样式
            XSSFFont titleFont = workBook.createFont();
            titleFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);   //字体增粗
            titleFont.setColor(HSSFColor.BLACK.index);
            titleFont.setFontHeightInPoints((short) 14);
            XSSFCellStyle titleCellStyle = workBook.createCellStyle();
            titleCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);     //水平居中
            titleCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);    //垂直居中

            //列名样式
            XSSFFont topicFont = workBook.createFont();
            topicFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);   //字体增粗
            topicFont.setColor(HSSFColor.BLACK.index);
            topicFont.setFontHeightInPoints((short) 10);
            XSSFCellStyle topicCellStyle = workBook.createCellStyle();
            topicCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);     //水平居中
            topicCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);    //垂直居中
            topicCellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
            topicCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            topicCellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
            topicCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            topicCellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
            topicCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            topicCellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
            topicCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            topicCellStyle.setFont(topicFont);

            //单元格内容样式
            XSSFFont contentFont = workBook.createFont();
            contentFont.setColor(HSSFColor.BLACK.index);
            contentFont.setFontHeightInPoints((short) 10);
            XSSFCellStyle cellStyle = workBook.createCellStyle();
            cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);     //水平居中
            cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);    //垂直居中
            cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setWrapText(true);
            cellStyle.setFont(contentFont);

            CellRangeAddress region1 = new CellRangeAddress(0, 1, 0, columnNames.length - 1);
            sheet1.addMergedRegion(region1);
            //标题
            XSSFRow titleRow = sheet1.createRow(0);      //
            titleRow.setHeight((short) 600);
            XSSFCell titleCell = titleRow.createCell(0);
            titleCell.setCellType(XSSFCell.CELL_TYPE_STRING);
            titleCell.setCellStyle(titleCellStyle);
            titleCell.setCellValue(titile);

            //输出列名
            XSSFRow row = sheet1.createRow(2);      //
            row.setHeight((short) 400);
            XSSFCell cell = null;
            int columnNum = columnNames.length;
            for (int i = 0; i < columnNum; i++) {
                cell = row.createCell(i);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(topicCellStyle);
                cell.setCellValue(columnNames[i]);
            }

            //输出各行数据
            for (int k = 0; k < datas.size(); k++) {
                MallFansDo mallFansDo = datas.get(k);
                row = sheet1.createRow(k + 3);
                row.setHeight((short) 600);         //行高不能太小，否则设置的自动换行功能不能实现
                //0
                cell = row.createCell(0);
                cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(k + 1);
                //1
                cell = row.createCell(1);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(mallFansDo.getWxNickName());
                //2
                cell = row.createCell(2);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(CommonUtil.longDivide(mallFansDo.getPaymentTotal(), 100L).toString());
                //3
                cell = row.createCell(3);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(mallFansDo.getExchageCount());
                //4
                cell = row.createCell(4);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(mallFansDo.getPointTotal());
                //5
                cell = row.createCell(5);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(mallFansDo.getExchagePointTotal());
                //6
                cell = row.createCell(6);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                String type = mallFansDo.getLastExchageType();
                String lastExchageType = "未知";
                if (StringUtils.isNotBlank(type)) {
                    if ("HB".equalsIgnoreCase(type) || "hongbao".equalsIgnoreCase(type)) {
                        lastExchageType = "红包";
                    } else if ("goods".equalsIgnoreCase(type)) {
                        lastExchageType = "商品";
                    } else if ("lw".equalsIgnoreCase(type)) {
                        lastExchageType = "礼物";
                    }
                }
                cell.setCellValue(lastExchageType);
                //7
                cell = row.createCell(7);
                cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellStyle(cellStyle);
                String ou = mallFansDo.getIsOldUser();
                cell.setCellValue("1".equals(ou) ? "是" : "否" );
                //8
                cell = row.createCell(8);
                cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(mallFansDo.getUserName());
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workBook.write(bos);
            bos.flush();
            byte[] bb = bos.toByteArray();
            return bb;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  springmvc方式接受商品详情数据, 并解析    (直接form提交)
     *  @return 如果key为true,value就为goodsVo, 反之value为错误提示信息
     * */
    public static Map<Boolean,Object> parseMallGoods1(HttpServletRequest request,Long sellerId){
        Map<Boolean,Object> map = new HashMap<Boolean,Object>();
        GoodsVo goodsVo = new GoodsVo();
        Long payPoints = 0L;
        try {
            goodsVo.setSellerId(sellerId);
            DefaultMultipartHttpServletRequest multipartHttpServletRequest = (DefaultMultipartHttpServletRequest) request;
            //商品标题
            String title = multipartHttpServletRequest.getParameter("goodsName");
            if (StringUtils.isBlank(title)) {
                map.put(false, "商品名不能为空");
                return map;
            } else {
                goodsVo.setTitle(title);
            }
            //商品类目
            String category = multipartHttpServletRequest.getParameter("category");
            if (StringUtils.isBlank(category)) {
                map.put(false, "商品类别不能为空");
                return map;
            } else {
                goodsVo.setCategoryId(Long.parseLong(category));
            }
            //商品类型
            String type = multipartHttpServletRequest.getParameter("goodsType");
            if (StringUtils.isBlank(type)) {
                map.put(false, "商品类型不能为空");
                return map;
            } else {
                goodsVo.setIsVirtual(type);
            }
            //兑换所需积分
            String payPointsAmount = multipartHttpServletRequest.getParameter("payPointsAmount");
            if (StringUtils.isNotBlank(payPointsAmount)) {
                payPoints = Long.parseLong(payPointsAmount);
                goodsVo.setPoint(payPoints);
            }
            //目前最多支持类目三个属性
            String[] prop1 = multipartHttpServletRequest.getParameterValues("prop_1");
            String[] prop2 = multipartHttpServletRequest.getParameterValues("prop_2");
            String[] prop3 = multipartHttpServletRequest.getParameterValues("prop_3");
            //商品价格
            String[] skuPrices = multipartHttpServletRequest.getParameterValues("skuPrice");
            //商品数量
            String[] skuAmount = multipartHttpServletRequest.getParameterValues("skuAmount");

//            int propertyNum = iMallCatPropService.getPropertyCountByCategoryId(Long.parseLong(sellerId), Long.parseLong(category));
//            String[][] propertiesArr = new String[propertyNum][];
//            for (int i = 0; i < propertyNum; i++) {
//                propertiesArr[i] = multipartHttpServletRequest.getParameterValues("prop" + (i + 1));
//            }
            //判断商品价格, 商品数量, 商品属性是否都已经填写完整
            boolean isComplete = validateComplete(skuAmount, skuPrices, prop1,prop2,prop3);
            if (!isComplete) {
                map.put(false, "商品设置信息不能为空");
                return map;
            }
            //判断商品属性是否有重复
            boolean isDuplicate = validateDuplicate(prop1,prop2,prop3);
            if (isDuplicate) {
                map.put(false, "商品属性重复请修改");
                return map;
            }
            //处理 sku 和 属性值
            List<String> propListOne = new ArrayList<String>();           //商品属性一
            List<String> propListTwo = new ArrayList<String>();           //商品属性二
            List<String> propListThree = new ArrayList<String>();         //商品属性三, 目前最多支持三个商品销售属性
            List<String> skuAmountList = new ArrayList<String>();       //商品数量
            List<String> skuPriceList = new ArrayList<String>();               //SKU价格
            if(prop1 != null){
                propListOne.addAll(Arrays.asList(prop1));
            }
            if(prop2 != null){
                propListTwo.addAll(Arrays.asList(prop2));
            }
            if(prop3 != null){
                propListThree.addAll(Arrays.asList(prop3));
            }
            if(skuPrices != null){
                skuPriceList.addAll(Arrays.asList(skuPrices));
            }
            if(skuAmount != null){
                skuAmountList.addAll(Arrays.asList(skuAmount));
            }

            GoodsSkuVo skuVo = null;
            List<GoodsSkuVo> skus = new ArrayList<GoodsSkuVo>();
            PropValue pv = null;
            PropValueName pvn = null;
            for(int i=0; i < propListOne.size(); i++){
                List<PropValue> pvList = new ArrayList<PropValue>();
                List<PropValueName> pvnList = new ArrayList<PropValueName>();
                skuVo = new GoodsSkuVo();
                String skuNum = skuAmountList.get(i);
                if(StringUtils.isNotBlank(skuNum)){
                    skuVo.setQuantity(Long.parseLong(skuNum));
                }else{
                    map.put(false, "商品设置信息不能为空");
                    return map;
                }
                skuVo.setQuantity(Long.parseLong(skuAmountList.get(i)));
                skuVo.setPoint(payPoints);
                String skuPri = skuPriceList.get(i);
                if(StringUtils.isNotBlank(skuPri)){
                    skuVo.setPrice(Long.parseLong(skuPri) * 100);
                }else{
                    map.put(false, "商品设置信息不能为空");
                    return map;
                }
                String prop_1 = propListOne.get(i);
                if(prop_1.indexOf("_") >= 0){              //针对编辑商品的时候
                    String skuId = prop_1.split("_")[1];
                    skuVo.setSkuId(Long.parseLong(skuId));
                }
                String prop_2 = null;
                String prop_3 = null;
                if(!CollectionUtils.isEmpty(propListTwo)){
                    prop_2 = propListTwo.get(i);
                }
                if(!CollectionUtils.isEmpty(propListThree)){
                    prop_3 = propListThree.get(i);
                }
                Object[] pvnArr = null;
                if(prop_1 != null){
                    pvnArr = getPropValue(prop_1);
                    if(pvnArr != null){
                        pvList.add((PropValue)pvnArr[0]);
                        pvnList.add((PropValueName)pvnArr[1]);
                    }
                }
                if(prop_2 != null){
                    pvnArr = getPropValue(prop_2);
                    if(pvnArr != null){
                        pvList.add((PropValue)pvnArr[0]);
                        pvnList.add((PropValueName)pvnArr[1]);
                    }
                }
                if(prop_3 != null){
                    pvnArr = getPropValue(prop_3);
                    if(pvnArr != null){
                        pvList.add((PropValue)pvnArr[0]);
                        pvnList.add((PropValueName)pvnArr[1]);
                    }
                }
                skuVo.setPropValueList(pvList);
                skuVo.setPropValueNameList(pvnList);
                skus.add(skuVo);
            }
            goodsVo.setExchangeAmount(0L);
            goodsVo.setSkus(skus);

            //商品总数量
            String goodsAmount = multipartHttpServletRequest.getParameter("goodsAmount");
            if (StringUtils.isNotBlank(goodsAmount)) {
                Long quantity = Long.parseLong(goodsAmount);
                goodsVo.setQuantity(quantity);
            }
            //商品价格
            String goodsPrice = multipartHttpServletRequest.getParameter("goodsPrice");
            if (StringUtils.isNotBlank(goodsPrice)) {
                Long price = Long.parseLong(goodsPrice) * 100;
                goodsVo.setPrice(price);
            }

            //上架时间
            String isImmediate = multipartHttpServletRequest.getParameter("isImmediate");
            goodsVo.setStatus(isImmediate);
            if (MallConstants.GoodsStatus.ONSALE.equals(isImmediate)) {
                goodsVo.setListTime(new Date());      //上架时间
            }
            //编辑时用的
            String goodsId = multipartHttpServletRequest.getParameter("goodsId");
            if (StringUtils.isNotBlank(goodsId)) {
                goodsVo.setGoodsId(Long.parseLong(goodsId));
            }
            //商品详情
            String content = multipartHttpServletRequest.getParameter("content");
            if(StringUtils.isNotBlank(content)){
                String detailUrl = GeneratorHtml.createProductDetail(content, request.getSession().getServletContext(), request.getContextPath(),sellerId);
                goodsVo.setDetailUrl(detailUrl);
            }
            map.put(true,goodsVo);
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
            map.put(false, "发生异常");
        }
        return map;
    }

    /**
     *  验证商品属性信息填写是否有重复
     *  @return  重复了返回true
     * */
    private static boolean validateDuplicate(String[] prop1, String[] prop2, String[] prop3){
        Set<String> set = new HashSet<String>();
        if(prop1 != null && prop2 != null && prop3 != null){    //有三个属性
            for(int i=0;i<prop1.length;i++){
                String value = prop1[i] + prop2[i] + prop3[i];
                if(set.contains(value)){
                    return true;
                }else{
                    set.add(value);
                }
            }
        }else if(prop1 != null && prop2 != null){     //有两个属性
            for(int i=0;i<prop1.length;i++){
                String value = prop1[i] + prop2[i];
                if(set.contains(value)){
                    return true;
                }else{
                    set.add(value);
                }
            }
        }else if(prop1 != null){                   //只有一个属性
            for(int i=0;i<prop1.length;i++){
                String value = prop1[i];
                if(set.contains(value)){
                    return true;
                }else{
                    set.add(value);
                }
            }
        }else{                                     //没有属性
            return false;
        }
        return false;
    }

    /**
     * 验证商品属性信息是否填写完整
     * 是否缺少价格, 积分等
     * @return 填写完整了返回true
     * */
    public static boolean validateComplete(String[] skuAmount, String[] skuPrices, String[] prop1, String[] prop2, String[] prop3){
        Set<Integer> set = new HashSet<Integer>();      //如果值都填写完整的话，length就一样
        //有三个属性
        if(prop1 != null && prop2 != null && prop3 != null){
            set.add(prop1.length);
            set.add(prop2.length);
            set.add(prop3.length);
            if(skuAmount != null && skuPrices != null){
                set.add(skuAmount.length);
                set.add(skuPrices.length);
            }else{
                return false;
            }
        }else if(prop1 != null && prop2 != null){     //有两个属性
            set.add(prop1.length);
            set.add(prop2.length);
            if(skuAmount != null && skuPrices != null){
                set.add(skuAmount.length);
                set.add(skuPrices.length);
            }else{
                return false;
            }
        }else if(prop1 != null){                   //只有一个属性
            set.add(prop1.length);
            if(skuAmount != null && skuPrices != null){
                set.add(skuAmount.length);
                set.add(skuPrices.length);
            }else{
                return false;
            }
        }else{                                     //没有属性
            return true;
        }
        return set.size() == 1;
    }

    /**
     * 处理商品图片的上传
     * @return 如果图片处理成功, key为true, value为图片路径, 反之为错误信息
     * */
    public static Map<Boolean,String> handleGoodsImg(HttpServletRequest request){
        Map<Boolean, String> returnMap = Maps.newHashMap();
        try {
            String sp = "upload/photo";
            String savePath = request.getSession().getServletContext().getRealPath(sp);
            DefaultMultipartHttpServletRequest multipartHttpServletRequest = (DefaultMultipartHttpServletRequest) request;

            Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String ymd = sdf.format(new Date());
            String realSavePath = savePath + File.separator + ymd + File.separator;
            MultipartFile multipartFile = multipartHttpServletRequest.getFile("fileList");
            if (multipartFile.getContentType() == null && !multipartFile.getContentType().startsWith("image")) {
                returnMap.put(false, "请选择图片类文件,支持jpg,jpeg,png,bmp,gif");
                return returnMap;
            }
            if (multipartFile.getSize() > 0) {
                if (multipartFile.getSize() > 1024 * 1024 * 4) {
                    returnMap.put(false, "商品图片不超过4M");
                    return returnMap;
                }
                String goodsImgFileName = FileUtils.saveFile(multipartFile, realSavePath);
                returnMap.put(true, sp + File.separator + ymd + File.separator + goodsImgFileName);
            }
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnMap.put(false,"发生异常");
        }
        return returnMap;
    }

    /**
     *  通过 ajaxFileUpload 方式提交的商品信息解析
     *  @return  如果key为true,value就为goodsVo, 反之value为错误提示信息
     *  @param type editor编辑,  create创建
     * */
    public static Map<Boolean,Object> parseGoodsForAjax(HttpServletRequest request, String type, Long sellerId){
        Map<Boolean, Object> returnMap = Maps.newHashMap();
        try{
            DefaultMultipartHttpServletRequest multipartRequest = (DefaultMultipartHttpServletRequest) request;
            String goodsData = multipartRequest.getParameter("goodsData");
//            JSONObject dataJSON = JSONObject.parseObject(goodsData);
            Map<String,Object> resultMap = (Map<String,Object>)JSONUtils.parseToObject(goodsData,Map.class);
            GoodsVo goodsVo = new GoodsVo();
            goodsVo.setSellerId(sellerId);
            Object obj = resultMap.get("goodsId");
            if(obj != null){                    //针对编辑商品的时候
                String goodIdStr = String.valueOf(obj);
                goodsVo.setGoodsId(Long.parseLong(goodIdStr));
            }
            goodsVo.setTitle(String.valueOf(resultMap.get("goodsName")));
            goodsVo.setCategoryId(Long.parseLong(String.valueOf(resultMap.get("category"))));
            goodsVo.setIsVirtual(String.valueOf(resultMap.get("goodsType")));
            goodsVo.setQuantity(Long.parseLong(String.valueOf(resultMap.get("goodsAmount"))));
            String price = String.valueOf(resultMap.get(("goodsPrice")));
            Double pri = Double.parseDouble(price) * 100;
            goodsVo.setPrice(pri.longValue());
            goodsVo.setPoint(Long.parseLong(String.valueOf(resultMap.get("payPointsAmount"))));
            String isImmediate = String.valueOf(resultMap.get("isImmediate"));
            goodsVo.setStatus(isImmediate);
            if (MallConstants.GoodsStatus.ONSALE.equals(isImmediate)) {
                goodsVo.setListTime(new Date());      //上架时间
            }
            //目前最多支持类目三个属性
            String skuProps1 = String.valueOf(resultMap.get("skuProps1"));
            String skuProps2 = String.valueOf(resultMap.get("skuProps2"));
            String skuProps3 = String.valueOf(resultMap.get("skuProps3"));
            String skuAmounts = String.valueOf(resultMap.get("skuAmounts"));
            String skuPricess = String.valueOf(resultMap.get("skuPrices"));
            String[] prop1 = null;
            if(StringUtils.isNotBlank(skuProps1)){
                prop1 = skuProps1.split("\\|");
            }
            String[] prop2 = null;
            if(StringUtils.isNotBlank(skuProps2)){
                prop2 = skuProps2.split("\\|");
            }
            String[] prop3 = null;
            if(StringUtils.isNotBlank(skuProps3)){
                prop3 = skuProps3.split("\\|");
            }
            //商品价格
            String[] skuPrices = null;
            if(StringUtils.isNotBlank(skuPricess)){
                skuPrices = skuPricess.split("\\|");
            }
            //商品数量
            String[] skuAmount = null;
            if(StringUtils.isNotBlank(skuAmounts)){
                skuAmount = skuAmounts.split("\\|");
            }
            //---------------
            //判断商品价格, 商品数量, 商品属性是否都已经填写完整
            boolean isComplete = validateComplete(skuAmount, skuPrices, prop1,prop2,prop3);
            if (!isComplete) {
                returnMap.put(false, "商品设置信息不能为空");
                return returnMap;
            }
            //判断商品属性是否有重复
            boolean isDuplicate = validateDuplicate(prop1,prop2,prop3);
            if (isDuplicate) {
                returnMap.put(false, "商品属性重复请修改");
                return returnMap;
            }
            //处理 sku 和 属性值
            List<String> propListOne = new ArrayList<String>();           //商品属性一
            List<String> propListTwo = new ArrayList<String>();           //商品属性二
            List<String> propListThree = new ArrayList<String>();         //商品属性三, 目前最多支持三个商品销售属性
            List<String> skuAmountList = new ArrayList<String>();       //商品数量
            List<String> skuPriceList = new ArrayList<String>();               //SKU价格
            if(prop1 != null){
                propListOne.addAll(Arrays.asList(prop1));
            }
            if(prop2 != null){
                propListTwo.addAll(Arrays.asList(prop2));
            }
            if(prop3 != null){
                propListThree.addAll(Arrays.asList(prop3));
            }
            if(skuPrices != null){
                skuPriceList.addAll(Arrays.asList(skuPrices));
            }
            if(skuAmount != null){
                skuAmountList.addAll(Arrays.asList(skuAmount));
            }

            GoodsSkuVo skuVo = null;
            List<GoodsSkuVo> skus = new ArrayList<GoodsSkuVo>();
            PropValue pv = null;
            PropValueName pvn = null;
            for(int i=0; i < propListOne.size(); i++){
                List<PropValue> pvList = new ArrayList<PropValue>();
                List<PropValueName> pvnList = new ArrayList<PropValueName>();
                skuVo = new GoodsSkuVo();
                String skuNum = skuAmountList.get(i);
                if(StringUtils.isNotBlank(skuNum)){
                    skuVo.setQuantity(Long.parseLong(skuNum));
                }else{
                    returnMap.put(false, "商品设置信息不能为空");
                    return returnMap;
                }
                skuVo.setQuantity(Long.parseLong(skuAmountList.get(i)));
                skuVo.setPoint(Long.parseLong(String.valueOf(resultMap.get("payPointsAmount"))));
                String skuPri = skuPriceList.get(i);
                if(StringUtils.isNotBlank(skuPri)){
                    Double spri = Double.parseDouble(skuPri) * 100;
                    skuVo.setPrice(spri.longValue());
                }else{
                    returnMap.put(false, "商品设置信息不能为空");
                    return returnMap;
                }
                String prop_1 = propListOne.get(i);
                if(prop_1.indexOf("_") >= 0){              //针对编辑商品的时候
                    String skuId = prop_1.split("_")[1];
                    skuVo.setSkuId(Long.parseLong(skuId));
                }
                String prop_2 = null;
                String prop_3 = null;
                if(!CollectionUtils.isEmpty(propListTwo)){
                    prop_2 = propListTwo.get(i);
                }
                if(!CollectionUtils.isEmpty(propListThree)){
                    prop_3 = propListThree.get(i);
                }
                Object[] pvnArr = null;
                if(prop_1 != null){
                    pvnArr = getPropValue(prop_1);
                    if(pvnArr != null){
                        pvList.add((PropValue)pvnArr[0]);
                        pvnList.add((PropValueName)pvnArr[1]);
                    }
                }
                if(prop_2 != null){
                    pvnArr = getPropValue(prop_2);
                    if(pvnArr != null){
                        pvList.add((PropValue)pvnArr[0]);
                        pvnList.add((PropValueName)pvnArr[1]);
                    }
                }
                if(prop_3 != null){
                    pvnArr = getPropValue(prop_3);
                    if(pvnArr != null){
                        pvList.add((PropValue)pvnArr[0]);
                        pvnList.add((PropValueName)pvnArr[1]);
                    }
                }
                skuVo.setPropValueList(pvList);
                skuVo.setPropValueNameList(pvnList);
                skus.add(skuVo);
            }
            goodsVo.setExchangeAmount(0L);
            goodsVo.setSkus(skus);
            //---------------
            //商品详情
            String content = String.valueOf(resultMap.get("content"));
            if (StringUtils.isNotBlank(content)) {
                String detailUrl = GeneratorHtml.createProductDetail(CommonUtil.unescape(content), request.getSession().getServletContext(), request.getContextPath(),sellerId);
                goodsVo.setDetailUrl(detailUrl);
            }else{
                returnMap.put(false, "商品详情必填");
                return returnMap;
            }
            //处理图片
            String fileNames = String.valueOf(resultMap.get("fileNames"));
            String[] fileNameArr = fileNames.split("\\|");
            String sp = "upload/photo";
            String tp = "upload/temp";
            String savePath = request.getSession().getServletContext().getRealPath(sp);
            String tempPath = request.getSession().getServletContext().getRealPath(tp);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String ymd = sdf.format(new Date());
            String realSavePath = savePath + File.separator + ymd + File.separator;
            String realTempPath = tempPath + File.separator + ymd + File.separator;
            for (String fileName : fileNameArr) {
                MultipartFile multipartFile = multipartRequest.getFile(fileName);
                long size = multipartFile.getSize();
                if (size > 0) {
                    if (multipartFile.getContentType() != null && !multipartFile.getContentType().startsWith("image")) {
                        returnMap.put(false, "请选择图片类文件,支持jpg,jpeg,png,bmp,gif");
                        return returnMap;
                    }
                    if ("wxRq".equals(fileName)) {
                        if (size > 1024 * 1024) {
                            returnMap.put(false, "商品二维码图片不超过1M");
                            return returnMap;
                        }
                        String wxRqFileName = FileUtils.saveFile(multipartFile, realSavePath);
                        goodsVo.setQrUrl(sp + File.separator + ymd + File.separator + wxRqFileName);
                    } else if (fileName.startsWith("photo")) {
                        if(size > 1024 * 1024 * 4){
                            returnMap.put(false, "商品图片不超过4M");
                            return returnMap;
                        }
                        String goodsImgFileName = FileUtils.saveFile(multipartFile, realSavePath);
                        goodsVo.getImgUrlList().add(sp + File.separator + ymd + File.separator + goodsImgFileName);
                    } else if ("thumbnail".equals(fileName)){
                        if (size > 1024 * 1024) {
                            returnMap.put(false, "商品缩略图不超过1M");
                            return returnMap;
                        }
                        String thumbFileName = FileUtils.saveFile(multipartFile, realSavePath);
                        goodsVo.setThumbnail(sp + File.separator + ymd + File.separator +  thumbFileName);
//                        goodsVo.setQrUrl(sp + File.separator + ymd + File.separator + wxRqFileName);
                    }
                }
            }
            if(!"editor".equals(type)) {          //编辑的时候不检查图片是否上传
                if (goodsVo.getImgUrlList().size() == 0) {
                    returnMap.put(false, "商品图片必选");
                    return returnMap;
                }
            }
            returnMap.put(true, goodsVo);
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnMap.put(false,"发生异常");
        }
        return returnMap;
    }

    /**
     *  导出订单数据
     *  适配 excel 2007
     * */
    public static byte[] formatMallOrdersDatas(List<MallOrderDo> datas, String title){
        try {
            if (datas == null) {
                throw new RuntimeException("datas is null, Cann't export excel file");
            }
//            String titile = "订单";           //标题名字
            String[] columnNames = new String[]{"序号", "商品", "订单编号", "价格", "粉丝姓名", "兑换时间", "订单状态", "消耗积分"};
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet1 = workBook.createSheet(title);
            sheet1.setColumnWidth(0, 1500);     //设置列宽
            sheet1.setColumnWidth(1, 15000);
            sheet1.setColumnWidth(2, 5000);
            sheet1.setColumnWidth(3, 2000);
            sheet1.setColumnWidth(4, 4000);
            sheet1.setColumnWidth(5, 4000);
            sheet1.setColumnWidth(6, 4000);
            sheet1.setColumnWidth(7, 3000);
            //头标题样式
            XSSFFont titleFont = workBook.createFont();
            titleFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);   //字体增粗
            titleFont.setColor(HSSFColor.BLACK.index);
            titleFont.setFontHeightInPoints((short) 14);
            XSSFCellStyle titleCellStyle = workBook.createCellStyle();
            titleCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);     //水平居中
            titleCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);    //垂直居中

            //列名样式
            XSSFFont topicFont = workBook.createFont();
            topicFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);   //字体增粗
            topicFont.setColor(HSSFColor.BLACK.index);
            topicFont.setFontHeightInPoints((short) 10);
            XSSFCellStyle topicCellStyle = workBook.createCellStyle();
            topicCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);     //水平居中
            topicCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);    //垂直居中
            topicCellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
            topicCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            topicCellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
            topicCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            topicCellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
            topicCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            topicCellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
            topicCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            topicCellStyle.setFont(topicFont);

            //单元格内容样式
            XSSFFont contentFont = workBook.createFont();
            contentFont.setColor(HSSFColor.BLACK.index);
            contentFont.setFontHeightInPoints((short) 10);
            XSSFCellStyle cellStyle = workBook.createCellStyle();
            cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);     //水平居中
            cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);    //垂直居中
            cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setWrapText(true);
            cellStyle.setFont(contentFont);

            CellRangeAddress region1 = new CellRangeAddress(0, 1, 0, columnNames.length - 1);
            sheet1.addMergedRegion(region1);
            //标题
            XSSFRow titleRow = sheet1.createRow(0);      //
            titleRow.setHeight((short) 600);
            XSSFCell titleCell = titleRow.createCell(0);
            titleCell.setCellType(XSSFCell.CELL_TYPE_STRING);
            titleCell.setCellStyle(titleCellStyle);
            titleCell.setCellValue(title);

            //输出列名
            XSSFRow row = sheet1.createRow(2);      //
            row.setHeight((short) 400);
            XSSFCell cell = null;
            int columnNum = columnNames.length;
            for (int i = 0; i < columnNum; i++) {
                cell = row.createCell(i);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(topicCellStyle);
                cell.setCellValue(columnNames[i]);
            }

            //输出各行数据
            for (int k = 0; k < datas.size(); k++) {
                MallOrderDo mallOrderDo = datas.get(k);
                row = sheet1.createRow(k + 3);
                row.setHeight((short) 600);         //行高不能太小，否则设置的自动换行功能不能实现
                //0
                cell = row.createCell(0);
                cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(k + 1);
                //1
                cell = row.createCell(1);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                String goodsTitle = mallOrderDo.getTitle();
                StringBuffer sbf = new StringBuffer(goodsTitle);
                String props = mallOrderDo.getProp();
                if(StringUtils.isNotBlank(props)){
                    String[] pns = props.split(";");
                    for(String pn : pns){
                        sbf.append("  " + pn.split(":")[3]);
                    }
                }
                cell.setCellValue(sbf.toString());
                //2
                cell = row.createCell(2);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(String.valueOf(mallOrderDo.getTid()));
                //3
                cell = row.createCell(3);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                cell.setCellValue("￥"+CommonUtil.longDivide(mallOrderDo.getPrice(),100L).toString());
                //4
                cell = row.createCell(4);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(mallOrderDo.getUserName());
                //5
                cell = row.createCell(5);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(DateUtil.dateToShortStr(mallOrderDo.getTradeDate()));
                //6
                String status = mallOrderDo.getStatus();
                String value = "";
                if ("WAIT_BUYER_PAY".equals(status)) {
                    value = "待付款";
                } else if ("WAIT_SELLER_SEND_GOODS".equals(status)) {
                    value = "待发货";
                } else if ("WAIT_BUYER_CONFIRM_GOODS".equals(status)) {
                    value = "已发货";
                } else if ("TRADE_FINISHED".equals(status)) {
                    value = "交易完成";
                } else if ("TRADE_CLOSED".equals(status)) {
                    value = "交易关闭";
                } else if ("TRADE_CLOSED_BY_SELLER".equals(status)) {
                    value = "卖家关闭";
                }
                cell = row.createCell(6);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(value);
                //7
                cell = row.createCell(7);
                cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(mallOrderDo.getPoint()==null? "0" : String.valueOf(mallOrderDo.getPoint()));
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workBook.write(bos);
            bos.flush();
            byte[] bb = bos.toByteArray();
            return bb;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}