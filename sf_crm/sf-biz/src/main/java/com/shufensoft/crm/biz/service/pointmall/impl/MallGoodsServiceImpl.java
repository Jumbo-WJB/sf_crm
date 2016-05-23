package com.shufensoft.crm.biz.service.pointmall.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.pointMall.GoodsSkuExchangeDao;
import com.shufensoft.crm.biz.dao.defined.pointMall.MallGoodsDAO;
import com.shufensoft.crm.biz.dao.generation.pointmall.MallCategoryMapper;
import com.shufensoft.crm.biz.dao.generation.pointmall.MallGoodsMapper;
import com.shufensoft.crm.biz.dao.generation.pointmall.MallGoodsSkuMapper;
import com.shufensoft.crm.biz.dao.generation.present.PresentMapper;
import com.shufensoft.crm.biz.domain.defined.pointMall.GoodsSkuExchangeInfoDo;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallGoodsDo;
import com.shufensoft.crm.biz.domain.generation.pointmall.*;
import com.shufensoft.crm.biz.domain.generation.present.Present;
import com.shufensoft.crm.biz.domain.generation.present.PresentExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.pointmall.MallConstants;
import com.shufensoft.crm.biz.service.pointmall.face.MallGoodsService;
import com.shufensoft.crm.biz.service.pointmall.vo.GoodsSkuVo;
import com.shufensoft.crm.biz.service.pointmall.vo.GoodsVo;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/6/26  
 */
@Service(value="mallGoodsService")
public class MallGoodsServiceImpl implements MallGoodsService{

    private Logger logger = Logger.getLogger(MallGoodsServiceImpl.class);

    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    @Autowired
    private MallGoodsSkuMapper mallGoodsSkuMapper;

    @Autowired
    private GoodsSkuExchangeDao goodsSkuExchangeDao;

    @Autowired
    private MallGoodsDAO mallGoodsDAO;

    @Autowired
    private MallCategoryMapper mallCategoryMapper;

    @Autowired
    private PresentMapper presentMapper;
    /**
     * 新建商品（含多SKU的情况）
     *
     * @param sellerId
     * @param goodsVo
     * @return 插入的记录条数
     */
    @Transactional
    public int create(Long sellerId, GoodsVo goodsVo) {
        MallGoods mallGoods = new MallGoods();
        mallGoods.setSellerId(sellerId);
        mallGoods.setTitle(goodsVo.getTitle());
        mallGoods.setCategoryId(goodsVo.getCategoryId());
        mallGoods.setExchangeAmount(goodsVo.getExchangeAmount());
        if(goodsVo.getIsVirtual() != null) {
            mallGoods.setIsVirtual(goodsVo.getIsVirtual());
        }
        mallGoods.setQuantity(goodsVo.getQuantity());
        mallGoods.setPrice(goodsVo.getPrice());
        mallGoods.setPoint(goodsVo.getPoint());
        if(!CollectionUtils.isEmpty(goodsVo.getImgUrlList())) {
            StringBuffer buf = new StringBuffer();
            for(int i=0; i<goodsVo.getImgUrlList().size(); i++) {
                String imgUrl = goodsVo.getImgUrlList().get(i);
                buf.append(imgUrl);
                if(i+1 != goodsVo.getImgUrlList().size()) {
                    buf.append(",");
                }
            }
            mallGoods.setImgsUrl(buf.toString());
        }
        mallGoods.setDetailUrl(goodsVo.getDetailUrl());
        mallGoods.setQrUrl(goodsVo.getQrUrl());
        mallGoods.setThumbnail(goodsVo.getThumbnail());
        mallGoods.setOuterId(goodsVo.getOuterId());
        mallGoods.setListTime(goodsVo.getListTime());
        mallGoods.setStatus(MallConstants.GoodsStatus.ONSALE);

        int result = 0;
        mallGoodsMapper.insert(mallGoods);
        result++;
        long goodsId = mallGoods.getGoodsId();
        long id = mallGoods.getId();

        StringBuffer bufSkuId = new StringBuffer();
        if(!CollectionUtils.isEmpty(goodsVo.getSkus())) {
            for(int i=0; i<goodsVo.getSkus().size(); i++) {
                GoodsSkuVo goodsSkuVo = goodsVo.getSkus().get(i);
                MallGoodsSku mallGoodsSku = new MallGoodsSku();
                mallGoodsSku.setSellerId(sellerId);
                mallGoodsSku.setGoodsId(goodsId);
                mallGoodsSku.setOuterSkuId(goodsSkuVo.getOuterSkuId());
                mallGoodsSku.setPoint(goodsSkuVo.getPoint());
                mallGoodsSku.setPrice(goodsSkuVo.getPrice());
                mallGoodsSku.setQuantity(goodsSkuVo.getQuantity());
                mallGoodsSku.setProps(goodsSkuVo.getPropValueListString());
                mallGoodsSku.setPropsName(goodsSkuVo.getPropValueNameListString());
                mallGoodsSkuMapper.insert(mallGoodsSku);
                result++;

                long skuId = mallGoodsSku.getSkuId();
                bufSkuId.append(skuId);
                if(i+1 != goodsVo.getSkus().size()) {
                    bufSkuId.append(",");
                }
            }
        }

        if(bufSkuId.length() > 0) {
            mallGoods = new MallGoods();
            mallGoods.setId(id);
            mallGoods.setSkus(bufSkuId.toString());
//            mallGoodsMapper.updateByPrimaryKey(mallGoods);
            mallGoodsMapper.updateByPrimaryKeySelective(mallGoods);
        }

        return result;
    }

    /**
     * 商品更新
     *
     * @param goodsVo
     * @return
     */
    @Transactional
    public int updateGoods(GoodsVo goodsVo) {
        if(goodsVo.getSellerId() <= 0 || goodsVo.getGoodsId() <= 0) {
            throw new ServiceException("illegal argument");
        }

        MallGoods mallGoods = new MallGoods();
        mallGoods.setSellerId(goodsVo.getSellerId());

        if(StringUtils.isNotEmpty(goodsVo.getTitle())) {
            mallGoods.setTitle(goodsVo.getTitle());
        }
        if(goodsVo.getCategoryId() > 0) {
            mallGoods.setCategoryId(goodsVo.getCategoryId());
        }
        if(goodsVo.getIsVirtual() != null) {
            mallGoods.setIsVirtual(goodsVo.getIsVirtual());
        }
        if(goodsVo.getQuantity() > 0) {
            mallGoods.setQuantity(goodsVo.getQuantity());
        }
        if(goodsVo.getPrice() > 0) {
            mallGoods.setPrice(goodsVo.getPrice());
        }
        if(goodsVo.getPoint() > 0) {
            mallGoods.setPoint(goodsVo.getPoint());
        }

        if(!CollectionUtils.isEmpty(goodsVo.getImgUrlList())) {
            StringBuffer buf = new StringBuffer();
            for(int i=0; i<goodsVo.getImgUrlList().size(); i++) {
                String imgUrl = goodsVo.getImgUrlList().get(i);
                buf.append(imgUrl);
                if(i+1 != goodsVo.getImgUrlList().size()) {
                    buf.append(",");
                }
            }
            mallGoods.setImgsUrl(buf.toString());
        }
        if(StringUtils.isNotEmpty(goodsVo.getDetailUrl())) {
            mallGoods.setDetailUrl(goodsVo.getDetailUrl());
        }
        if(StringUtils.isNotEmpty(goodsVo.getQrUrl())) {
            mallGoods.setQrUrl(goodsVo.getQrUrl());
        }
        if(StringUtils.isNotEmpty(goodsVo.getOuterId())) {
            mallGoods.setOuterId(goodsVo.getOuterId());
        }

        if(StringUtils.isNotBlank(goodsVo.getThumbnail())){
            mallGoods.setThumbnail(goodsVo.getThumbnail());
        }

        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andSellerIdEqualTo(goodsVo.getSellerId()).andGoodsIdEqualTo(goodsVo.getGoodsId());
        int result = mallGoodsMapper.updateByExampleSelective(mallGoods, mallGoodsExample);
        if(result != 1) {
            throw new ServiceException("update fail: " + goodsVo.toString());
        }
        logger.info("mallGoods更新数量:" + result);
        updateSku(goodsVo);
        return result;
    }

    @Transactional
    public int updateGoodsSku(GoodsVo goodsVo) {
        if(goodsVo.getSellerId() <= 0 || goodsVo.getGoodsId() <= 0) {
            throw new ServiceException("illegal argument");
        }

        int result = 0;
        StringBuffer bufSkuId = new StringBuffer();
        if(!CollectionUtils.isEmpty(goodsVo.getSkus())) {
            for(int i=0; i<goodsVo.getSkus().size(); i++) {
                GoodsSkuVo goodsSkuVo = goodsVo.getSkus().get(i);
                if(goodsSkuVo.getSkuId() <= 0) {
                    MallGoodsSku mallGoodsSku = new MallGoodsSku();
                    mallGoodsSku.setSellerId(goodsVo.getSellerId());
                    mallGoodsSku.setGoodsId(goodsVo.getGoodsId());
                    mallGoodsSku.setOuterSkuId(goodsSkuVo.getOuterSkuId());
                    mallGoodsSku.setPoint(goodsSkuVo.getPoint());
                    mallGoodsSku.setPrice(goodsSkuVo.getPrice());
                    mallGoodsSku.setQuantity(goodsSkuVo.getQuantity());
                    mallGoodsSku.setProps(goodsSkuVo.getPropValueListString());
                    mallGoodsSku.setPropsName(goodsSkuVo.getPropValueNameListString());

                    mallGoodsSkuMapper.insert(mallGoodsSku);
                    result++;
                    long skuId = mallGoodsSku.getSkuId();
                    bufSkuId.append(skuId);
                } else {
                    MallGoodsSku mallGoodsSku = new MallGoodsSku();
                    mallGoodsSku.setSellerId(goodsVo.getSellerId());
                    mallGoodsSku.setGoodsId(goodsVo.getGoodsId());
                    if(StringUtils.isNotEmpty(goodsSkuVo.getOuterSkuId())) {
                        mallGoodsSku.setOuterSkuId(goodsSkuVo.getOuterSkuId());
                    }
                    if(goodsSkuVo.getPoint() > 0) {
                        mallGoodsSku.setPoint(goodsSkuVo.getPoint());
                    }
                    if(goodsSkuVo.getPrice() > 0) {
                        mallGoodsSku.setPrice(goodsSkuVo.getPrice());
                    }
                    if(goodsSkuVo.getQuantity() > 0) {
                        mallGoodsSku.setQuantity(goodsSkuVo.getQuantity());
                    }
                    mallGoodsSku.setProps(goodsSkuVo.getPropValueListString());
                    mallGoodsSku.setPropsName(goodsSkuVo.getPropValueNameListString());

                    MallGoodsSkuExample mallGoodsSkuExample = new MallGoodsSkuExample();
                    mallGoodsSkuExample.createCriteria().andSellerIdEqualTo(goodsVo.getSellerId()).andGoodsIdEqualTo(goodsVo.getGoodsId())
                            .andSkuIdEqualTo(goodsSkuVo.getSkuId());
                    result += mallGoodsSkuMapper.updateByExampleSelective(mallGoodsSku, mallGoodsSkuExample);

                    long skuId = mallGoodsSku.getSkuId();
                    bufSkuId.append(skuId);
                }

                if(i+1 != goodsVo.getSkus().size()) {
                    bufSkuId.append(",");
                }
            }
        }

        MallGoods mallGoods = new MallGoods();
        mallGoods.setSkus(bufSkuId.toString());

        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andSellerIdEqualTo(goodsVo.getSellerId()).andGoodsIdEqualTo(goodsVo.getGoodsId());
        result += mallGoodsMapper.updateByExampleSelective(mallGoods, mallGoodsExample);

        return result;
    }

    /**
     *  删除一个商品, 连同其下的sku一同删除
     * */
    @Transactional
    public int delete(long sellerId, long goodsId) {
        if(sellerId <= 0 || goodsId <= 0) {
            throw new ServiceException("illegal argument");
        }
        int deleteNum = 0;
        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andSellerIdEqualTo(sellerId).andGoodsIdEqualTo(goodsId);
        MallGoods mallGoods = new MallGoods();
        mallGoods.setIsDeleted(DaoConstant.IsDeleted.TRUE);
        List<MallGoodsSku> skus = this.queryGoodsSku(sellerId,goodsId);
        for(MallGoodsSku sks : skus){
            deleteNum += mallGoodsSkuMapper.deleteByPrimaryKey(sks.getId());
        }
        deleteNum += mallGoodsMapper.updateByExampleSelective(mallGoods, mallGoodsExample);
        return deleteNum;
    }

    /**
     * 分页查询商品
     *
     * @param sellerId
     * @param start
     * @param pageSize
     * @return
     */
    public List<MallGoods> queryGoods(long sellerId, int start, int pageSize) {
        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andSellerIdEqualTo(sellerId);
        PageHelper.startPage(start, pageSize);
        List<MallGoods> mallGoodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
        if(CollectionUtils.isEmpty(mallGoodsList)) {
            return null;
        }

        return mallGoodsList;
    }

    /**
     * 查询某商品的SKU
     *
     * @param sellerId
     * @param goodsId
     * @return
     */
    public List<MallGoodsSku> queryGoodsSku(long sellerId, long goodsId) {
        MallGoodsSkuExample mallGoodsSkuExample = new MallGoodsSkuExample();
        mallGoodsSkuExample.createCriteria().andSellerIdEqualTo(sellerId).andGoodsIdEqualTo(goodsId);
        List<MallGoodsSku> mallGoodsSkuList = mallGoodsSkuMapper.selectByExample(mallGoodsSkuExample);
        return mallGoodsSkuList;
    }

    /**
     * 商品上架
     *
     * @param sellerId
     * @param goodsId
     * @return 变更记录数
     */
    public int list(long sellerId, long goodsId) {
        if(sellerId <= 0 || goodsId <= 0) {
            throw new ServiceException("illegal argument");
        }

        MallGoods mallGoods = new MallGoods();
        mallGoods.setListTime(new Date());
        mallGoods.setStatus(MallConstants.GoodsStatus.ONSALE);

        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andSellerIdEqualTo(sellerId).andGoodsIdEqualTo(goodsId);

        int result = mallGoodsMapper.updateByExampleSelective(mallGoods, mallGoodsExample);
        if(result != 1) {
            throw new ServiceException("update fail: " + sellerId + ", " + goodsId);
        }

        return result;
    }

    /**
     * 商品下架
     *
     * @param sellerId
     * @param goodsId
     * @return
     */
    public int delist(long sellerId, long goodsId) {
        if(sellerId <= 0 || goodsId <= 0) {
            throw new ServiceException("illegal argument");
        }

        MallGoods mallGoods = new MallGoods();
        mallGoods.setDelistTime(new Date());
        mallGoods.setStatus(MallConstants.GoodsStatus.INSTOCK);

        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andSellerIdEqualTo(sellerId).andGoodsIdEqualTo(goodsId);

        int result = mallGoodsMapper.updateByExampleSelective(mallGoods, mallGoodsExample);
        if(result != 1) {
            throw new ServiceException("update fail: " + sellerId + ", " + goodsId);
        }

        return result;
    }

    /**
     * 分页查询积分兑换商品 by sellerId
     *
     * @param sellerId
     * @param start
     * @param length
     */
    @Override
    public PageInfo findGoodsBySellerIdAndPage(Long sellerId, Integer start, Integer length) {
        PageHelper.startPage(start,length);
        MallGoodsExample example = new MallGoodsExample();
        example.createCriteria().andSellerIdEqualTo(sellerId).andQuantityGreaterThan(0L);    //库存数量大于0
        example.setOrderByClause("list_time desc");
        List<MallGoods> goodsList  =mallGoodsMapper.selectByExample(example);
        return new PageInfo(goodsList);
    }

    /**
     * 根据id查询一个商品
     *
     * @param id
     */
    @Override
    public MallGoods getMallGoodsById(Long id) {
        MallGoods mg = mallGoodsMapper.selectByPrimaryKey(id);
        return mg;
    }

    /**
     * 更新 goodsSku , 编辑商品的时候用到
     *
     * @param goodsVo
     */
    @Override
    @Transactional
    public String updateSku(GoodsVo goodsVo) {
        List<MallGoodsSku> skus = queryGoodsSku(goodsVo.getSellerId(),goodsVo.getGoodsId());
        Map<Long, MallGoodsSku> map = new HashMap<Long,MallGoodsSku>();
        StringBuffer sbu = new StringBuffer();
        StringBuffer temp = new StringBuffer();      //如果有新添加的产品设置, 要更新商品的 skus 字段
        int deleteNum = 0;
        int saveNum = 0;
        int updateNum = 0;
        for(MallGoodsSku sku : skus){
            map.put(sku.getSkuId(),sku);
        }
        List<GoodsSkuVo> skuVos = goodsVo.getSkus();
        if(!CollectionUtils.isEmpty(skuVos)) {
            MallGoodsSku mallGoodsSku = null;
            for (GoodsSkuVo svo : skuVos) {
                MallGoodsSku original = map.get(svo.getSkuId());
                if(original != null){           //需要更新
                    if(!original.getProps().equals(svo.getPropValueListString()) || !original.getPropsName().equals(svo.getPropValueNameListString())
                            || original.getQuantity() != svo.getQuantity() || original.getPrice() != svo.getPrice() || original.getPoint() != svo.getPoint()) {
                        mallGoodsSku = new MallGoodsSku();
                        mallGoodsSku.setId(original.getId());
                        mallGoodsSku.setProps(svo.getPropValueListString());
                        mallGoodsSku.setPropsName(svo.getPropValueNameListString());
                        mallGoodsSku.setQuantity(svo.getQuantity());
                        mallGoodsSku.setPrice(svo.getPrice());
                        mallGoodsSku.setPoint(goodsVo.getPoint());
                        mallGoodsSkuMapper.updateByPrimaryKeySelective(mallGoodsSku);
                        updateNum++;
                    }
                    temp.append(original.getSkuId()).append(",");
                    map.remove(svo.getSkuId());                        //把匹配上的从map中删除, 没有匹配上的后面要删除
                }else{                          //重新添加的
                    mallGoodsSku = new MallGoodsSku();
                    mallGoodsSku.setProps(svo.getPropValueListString());
                    mallGoodsSku.setPropsName(svo.getPropValueNameListString());
                    mallGoodsSku.setSellerId(goodsVo.getSellerId());
                    mallGoodsSku.setGoodsId(goodsVo.getGoodsId());
                    mallGoodsSku.setOuterSkuId(svo.getOuterSkuId());
                    mallGoodsSku.setPoint(svo.getPoint());
                    mallGoodsSku.setPrice(svo.getPrice());
                    mallGoodsSku.setQuantity(svo.getQuantity());
                    mallGoodsSkuMapper.insert(mallGoodsSku);
                    saveNum++;
                    temp.append(mallGoodsSku.getSkuId()).append(",");
                }
            }
            String skuIds = temp.toString();
            if(map.size() > 0){               //要删除的
                for(Map.Entry<Long,MallGoodsSku> entry : map.entrySet()){
                    mallGoodsSkuMapper.deleteByPrimaryKey(entry.getValue().getId());
                    skuIds = skuIds.replace(entry.getValue().getSkuId()+",","");          //把要删除的skuId用空串替换掉
                    deleteNum++;
                }
            }

            if(saveNum != 0 || deleteNum != 0){        //有添加的或者删除的都要更新下mallgoods的skuId
                if(skuIds.endsWith(",")){
                    skuIds = skuIds.substring(0,temp.lastIndexOf(","));
                }
                MallGoods mg = new MallGoods();
                mg.setSkus(skuIds);
                MallGoodsExample example = new MallGoodsExample();
                example.createCriteria().andGoodsIdEqualTo(goodsVo.getGoodsId()).andSellerIdEqualTo(goodsVo.getSellerId());
                mallGoodsMapper.updateByExampleSelective(mg, example);
            }

        }
        sbu.append("SKU更新数量:" + updateNum).append(" 删除数量:" + deleteNum).append(" 增加数量:" + saveNum);
        logger.info(sbu.toString());
        return sbu.toString();
    }

    /**
     * 根据skuId 查询一个商品,
     *
     * @param sellerId
     * @param skuId
     */
    @Override
    public GoodsSkuExchangeInfoDo findGoodsSkuExchangeInfoDoBySkuId(Long sellerId, Long skuId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sellerId",sellerId);
        map.put("skuId",skuId);
        return goodsSkuExchangeDao.findGoodsSkuExchangeInfoDoBySkuId(map);
    }


    @Override
    public MallGoods findMallGoodsBySellerAndGoodsId(Long sellerId, Long goodsId) {
        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andSellerIdEqualTo(sellerId).andGoodsIdEqualTo(goodsId);
        List<MallGoods> mallGoodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
        if(!CollectionUtils.isEmpty(mallGoodsList)){
            return mallGoodsList.get(0);
        }
        return null;
    }

    /**
     * 查询商户积分兑换商品, 满足条件, 1, 库存量要大于0; 2, 排除礼物类目,3, 在售, 4, 没有删除
     *
     * @param sellerId
     * @param start
     * @param length
     */
    @Override
    public PageInfo findExangeGoods(Long sellerId, Integer start, Integer length) {
        PageHelper.startPage(start, length);
        List<MallGoodsDo> goodsList = mallGoodsDAO.findMallGoodsByParams(sellerId);
        return new PageInfo(goodsList);
    }

    /**
     * 根据goodsId查询一个商品, 并且查出包含的所有sku
     * 用于商城, goodId已经筛选过一次, 去掉礼物分类, 下架, 兑换完的商品, 因此这里不加这些条件
     * @param sellerId
     * @param goodsId
     */
    @Override
    public GoodsVo findGoodsCascadeSkuByGoodsId(Long sellerId, Long goodsId) {
        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andSellerIdEqualTo(sellerId).andGoodsIdEqualTo(goodsId);
        List<MallGoods> mallGoodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
        GoodsVo goodsVo = null;
        if(!CollectionUtils.isEmpty(mallGoodsList)){
            MallGoods mallGoods = mallGoodsList.get(0);
            goodsVo = (GoodsVo)BeanCopierUtils.copyProperties(mallGoods,GoodsVo.class);
            //填充商品图片url
            List<String> urlList = new ArrayList<String>();
            String urls = mallGoods.getImgsUrl();
            if(StringUtils.isNotBlank(urls)){
                if(urls.indexOf(",") >= 0){
                    for(String url : urls.split(",")){
                        urlList.add(url);
                    }
                }else{
                    urlList.add(urls);
                }
            }
            goodsVo.setImgUrlList(urlList);
            //填充sku
            List<GoodsSkuVo> skusList = new ArrayList<GoodsSkuVo>();
            String skuIds = mallGoods.getSkus();
            MallGoodsSku mallGoodsSku = null;
            GoodsSkuVo goodsSkuVo = null;
            if(StringUtils.isNotBlank(skuIds)){
                if(skuIds.indexOf(",") >= 0){
                    for(String skuId : skuIds.split(",")){
                        mallGoodsSku = this.findMallGoodsSkuBySkuId(sellerId,goodsId,Long.parseLong(skuId));
                        goodsSkuVo = (GoodsSkuVo)BeanCopierUtils.copyProperties(mallGoodsSku,GoodsSkuVo.class);
                        skusList.add(goodsSkuVo);
                    }
                }else{
                    mallGoodsSku = this.findMallGoodsSkuBySkuId(sellerId,goodsId,Long.parseLong(skuIds));
                    goodsSkuVo = (GoodsSkuVo)BeanCopierUtils.copyProperties(mallGoodsSku,GoodsSkuVo.class);
                    skusList.add(goodsSkuVo);
                }
            }
            goodsVo.setSkus(skusList);
        }
        return goodsVo;
    }

    /**
     * 根据goodsId查询一个商品, 不包含sku
     *
     * @param sellerId
     * @param goodsId
     */
    @Override
    public GoodsVo findGoodsByGoodsId(Long sellerId, Long goodsId) {
        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andSellerIdEqualTo(sellerId).andGoodsIdEqualTo(goodsId);
        List<MallGoods> mallGoodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
        GoodsVo goodsVo = new GoodsVo();
        if(!CollectionUtils.isEmpty(mallGoodsList)){
            MallGoods mallGoods = mallGoodsList.get(0);
            BeanCopierUtils.beanCopyByApacheBeanUtils(goodsVo, mallGoods);
            //填充商品图片url
            List<String> urlList = new ArrayList<String>();
            String urls = mallGoods.getImgsUrl();
            if(StringUtils.isNotBlank(urls)){
                if(urls.indexOf(",") >= 0){
                    for(String url : urls.split(",")){
                        urlList.add(url);
                    }
                }else{
                    urlList.add(urls);
                }
            }
            goodsVo.setImgUrlList(urlList);
        }
        return goodsVo;
    }

    /**
     * 根据skuId查询一个sku
     *
     * @param sellerId
     * @param skuId
     */
    @Override
    public MallGoodsSku findMallGoodsSkuBySkuId(Long sellerId, Long goodsId, Long skuId) {
        MallGoodsSkuExample example = new MallGoodsSkuExample();
        example.createCriteria().andSellerIdEqualTo(sellerId).andGoodsIdEqualTo(goodsId).andSkuIdEqualTo(skuId);
        List<MallGoodsSku> mallGoodsSkuList = mallGoodsSkuMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(mallGoodsSkuList)){
            return mallGoodsSkuList.get(0);
        }
        return null;
    }

    /**
     * 判断商品是否为礼物
     *
     * @param goodsId
     */
    @Override
    public boolean isGiftByGoodsId(Long sellerId, Long goodsId) {
        MallGoods mallGoods = this.findMallGoodsBySellerAndGoodsId(sellerId,goodsId);
        MallCategoryExample example = new MallCategoryExample();
        example.createCriteria().andSellerIdEqualTo(sellerId).andCidEqualTo(mallGoods.getCategoryId());
        List<MallCategory> mallCategories = mallCategoryMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(mallCategories)){
            MallCategory mallCategory = mallCategories.get(0);
            return "礼物".equals(mallCategory.getName());
        }
        return false;
    }

    /**
     * 通用的查询mallGoods方法
     *
     * @param mallGoodsDo
     */
    @Override
    public PageInfo findMallGoodsByMallGoodsDoByPage(MallGoodsDo mallGoodsDo, Integer pageNum, Integer length) {
        PageHelper.startPage(pageNum,length);
        List<MallGoodsDo> mallGoodsDos = mallGoodsDAO.findMallGoodsByGoodsDo(mallGoodsDo);
        return new PageInfo(mallGoodsDos);
    }


    /**
     * 根据obtainId查询商户信息
     * @param sellerId 商户ID
     * @param obtainId 获取ID
     * @return
     */
    public MallGoods getMailGoodsByGoodsId(Long sellerId,Long obtainId){

        PresentExample presentExample = new PresentExample();
        PresentExample.Criteria criteria = presentExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andPresentIdEqualTo(obtainId);

        List<Present> presentList = presentMapper.selectByExample(presentExample);

        if (CollectionUtils.isEmpty(presentList)){
            return null;
        }

        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        MallGoodsExample.Criteria criteriaGoods = mallGoodsExample.createCriteria();
        criteriaGoods.andSellerIdEqualTo(sellerId);
        criteriaGoods.andGoodsIdEqualTo(presentList.get(0).getGoodsId());
        List<MallGoods> mallGoodsList = mallGoodsMapper.selectByExample(mallGoodsExample);

        if (CollectionUtils.isEmpty(mallGoodsList)){
            return null;
        }

        return mallGoodsList.get(0);

    }

}
