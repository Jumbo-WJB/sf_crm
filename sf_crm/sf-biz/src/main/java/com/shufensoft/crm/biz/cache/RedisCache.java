package com.shufensoft.crm.biz.cache;

import com.shufensoft.crm.biz.dao.redis.RedisDAO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 redis 缓存
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/23  
 */
public class RedisCache {

    private static RedisDAO redisDAO = new RedisDAO();

    /**
     * 保存缓存(如果key已经存在,不能重复保存)
     * @return
     */
    public static boolean putNX(String key,Serializable value) {

        AssertsUtil.notBothSidesBlank(key, "key");

        return redisDAO.putNX(key,value);

    }

    /**
     * 保存缓存
     * @return
     */
    public static boolean put(String key,Serializable value) {

        AssertsUtil.notBothSidesBlank(key,"key");

        return redisDAO.put(key, value);

    }

    /**
     * 保存缓存,并换回老的缓存
     * @return
     */
    public static Object getSet(String key,Serializable value) {

        AssertsUtil.notBothSidesBlank(key,"key");

        return redisDAO.getSet(key, value);

    }


    /**
     * 缓存失效时间设置
     * @param key
     * @param time 失效时间
     * @return
     */
    public static boolean expire(String key, Long time) {

        AssertsUtil.notBothSidesBlank(key,"key");

        return redisDAO.expire(key, time);

    }

    /**
     * 获取缓存
     * @return
     */
    public static Object get(final String key) {

        AssertsUtil.notBothSidesBlank(key,"key");

        return redisDAO.get(key);
    }

    /**
     * 删除缓存
     * @param key
     */
    public static void delete(String key) {

        AssertsUtil.notBothSidesBlank(key,"key");

        redisDAO.delete(key);

    }

    /**
     * 删除多个缓存
     * @param keys
     */
    public static void delete(List<String> keys) {
        AssertsUtil.check(!CollectionUtils.isEmpty(keys), "keys");
        redisDAO.delete(keys);
    }
}
