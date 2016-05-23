package com.shufensoft.crm.web.controller.cache;

import com.shufensoft.crm.biz.cache.LstOfValCache;
import com.shufensoft.crm.biz.cache.RedisCache;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.StringUtils;
import com.shufensoft.crm.ruleEngine.cache.RuleCache;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 缓存Controller
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/19  
 */
@RequestMapping("/cache")
@Controller
public class CacheController {

    /**
     * 刷新商家配置
     * @return
     */
    @RequestMapping("/sellerConfigInfo/refresh")
    @ResponseBody
    public String sellerConfigInfoRefresh(String sellerId){

        if(StringUtils.isBlank(sellerId)){
            SellerConfigCache.reloadAll();
            return "sellerConfigInfo cache refresh all success";
        }

        AssertsUtil.notContainsBlank(sellerId,"sellerId");
        AssertsUtil.check(!NumberUtils.isNumber(sellerId),"sellerId is not number!");
        SellerConfigCache.reload(sellerId);
        return "sellerConfigInfo[sellerId="+sellerId+"] cache refresh  success";
    }

    /**
     * 刷新系统配置
     * @return
     */
    @RequestMapping("/lstOfVal/refresh")
    @ResponseBody
    public String lstOfValRefresh(String type,String name){

        AssertsUtil.notBlank(type,"type");

        if(StringUtils.isNotBlank(name)){
            LstOfValCache.reload(type,name);
            return "lstOfVal cache refresh success[type="+type+";name="+name+"]";
        }

        LstOfValCache.reload(type);
        return "lstOfVal cache refresh success[type="+type+"]";

    }

    /**
     * 刷新规则缓存配置
     * @return
     */
    @RequestMapping("/ruleCache/refresh")
    @ResponseBody
    public String ruleCacheRefresh(){

        RuleCache.reloadAll();
        return "rule cache refresh all success";

    }

    /**
     * 清redis缓存配置
     * @return
     */
    @RequestMapping("/redisCache/clear")
    @ResponseBody
    public String redisCacheRefresh(String key){

        AssertsUtil.notBlank(key,"key");
        RedisCache.delete(key);
        return "rule cache refresh all success";

    }



}
