package com.shufensoft.crm.biz.dao.redis;

import com.shufensoft.crm.common.utils.SpringContextUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 redis基础DAO
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/23  
 */

public abstract class AbstractBaseRedisDao<K, V> {


    protected RedisTemplate<K, V> redisTemplate = (RedisTemplate)SpringContextUtil.getBean("redisTemplate");

    /**
     * 设置redisTemplate
     * @param redisTemplate
     */
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取 RedisSerializer
     */
    protected RedisSerializer<?> getRedisSerializer() {
        return redisTemplate.getKeySerializer();
    }
}
