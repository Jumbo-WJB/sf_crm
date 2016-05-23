package com.shufensoft.crm.biz.dao.redis;

import com.shufensoft.crm.common.utils.AssertsUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 缓存DAO
 *                 </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/23  
 */
public class RedisDAO extends AbstractBaseRedisDao<String,Serializable>{

    /**
     * 保存缓存(如果key已经存在,不能重复保存)
     * @return
     */
    public boolean putNX(final String key,final Serializable value) {
        AssertsUtil.notBothSidesBlank(key,"key");

        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {

                RedisSerializer serializer = getRedisSerializer();
                byte[] name = serializer.serialize(key);
                byte[] obj = serializer.serialize(value);

                return connection.setNX(name, obj);
            }

        });

        return result;
    }

    /**
     * 缓存失效时间设置
     * @param key
     * @param time 失效时间
     * @return
     */
    public boolean expire(final String key,final Long time) {

        AssertsUtil.notBothSidesBlank(key,"key");

        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {

                RedisSerializer serializer = getRedisSerializer();
                byte[] name = serializer.serialize(key);
                connection.expire(name,time);
                return true;
            }

        });

        return result;
    }


    /**
     * 保存缓存
     * @return
     */
    public boolean put(final String key,final Serializable value) {

        AssertsUtil.notBothSidesBlank(key,"key");

        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {

                RedisSerializer serializer = getRedisSerializer();
                byte[] name = serializer.serialize(key);
                byte[] obj = serializer.serialize(value);
                connection.set(name, obj);
                return true;
            }

        });

        return result;
    }


    /**
     * 保存缓存，返回旧值
     * @return
     */
    public Object getSet(final String key,final Serializable value) {

        AssertsUtil.notBothSidesBlank(key,"key");

        Object result = redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {

                RedisSerializer serializer = getRedisSerializer();
                byte[] name = serializer.serialize(key);
                byte[] obj = serializer.serialize(value);
                byte[] val = connection.getSet(name, obj);
                if (val == null) {
                    return null;
                }

                return serializer.deserialize(val);
            }

        });

        return result;
    }

    /**
     * 获取缓存
     * @return
     */
    public Object get(final String key) {

        AssertsUtil.notBothSidesBlank(key,"key");
        Object result = redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {

                RedisSerializer serializer = getRedisSerializer();
                byte[] name = serializer.serialize(key);
                byte[] value = connection.get(name);

                if (value == null) {
                    return null;
                }

                return serializer.deserialize(value);
            }

        });

        return result;
    }

    /**
     * 删除缓存
     * @param key
     */
    public void delete(String key) {
        AssertsUtil.notBothSidesBlank(key,"key");
        List<String> list = new ArrayList<String>();
        list.add(key);
        delete(list);
    }

    /**
     * 删除多个缓存
     * @param keys
     */
    public void delete(List<String> keys) {
        AssertsUtil.check(!CollectionUtils.isEmpty(keys), "keys");
        redisTemplate.delete(keys);
    }

}
