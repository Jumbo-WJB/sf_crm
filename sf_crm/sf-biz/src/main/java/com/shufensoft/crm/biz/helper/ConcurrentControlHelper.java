package com.shufensoft.crm.biz.helper;

import com.shufensoft.crm.biz.cache.LstOfValCache;
import com.shufensoft.crm.biz.cache.RedisCache;
import com.shufensoft.crm.biz.domain.generation.system.LstOfVal;
import com.shufensoft.crm.common.utils.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicLong;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 并发控制helper
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/28  
 */
public class ConcurrentControlHelper {

    private static final Logger logger = Logger.getLogger(ConcurrentControlHelper.class);

    public AtomicLong concurrentThreadNum;

    public static Long DEFAULT_GET_LOCK_TIME_OUT = 10000L;

    public static String CONCURRENT_LOCK_TYPE = "CONCURRENT_LOCK";

    public static String GET_LOCK_TIME_OUT_NAME = "getLockTimeOut";

    public ConcurrentControlHelper(){

        concurrentThreadNum = new AtomicLong(0);

    }

    /**
     * 并发线程是否超标（采用cas乐观所方案）
     * @param bizMaxConcurrentThreadType  对应lstofval表配置的key
     * @param bizMaxConcurrentThreadName 对应lstofval表配置的type
     */
    public boolean isBizConcurrentThreadOut(String bizMaxConcurrentThreadType,String bizMaxConcurrentThreadName){

        LstOfVal lstOfVal = LstOfValCache.getLOV(bizMaxConcurrentThreadType, bizMaxConcurrentThreadName);

        if(lstOfVal == null || StringUtils.isBlank(lstOfVal.getValue())){
            logger.error("biz concurrent control lstOfVal or value is null or");
            return true;
        }

        if(!NumberUtils.isNumber(lstOfVal.getValue())){
            logger.error("biz concurrent control  value is null number");
            return true;
        }

        Long threadNum = concurrentThreadNum.incrementAndGet();

        if(threadNum > Long.valueOf(lstOfVal.getValue())){
             return false;
        }

        return true;

    }

    /**
     * 释放分布式锁
     * @return
     */
    public static void releaseDistributedLock(String lockId) {

        RedisCache.delete(lockId);

    }


    /**
     * 获取分布式锁
     * @return
     */
    public static boolean getDistributedThreadLock(String lockId) {

        Boolean flag = RedisCache.putNX(lockId, true);

        if (flag != null && flag) {
            return true;
        }

        long start = System.currentTimeMillis();

        LstOfVal lstOfVal = LstOfValCache.getLOV(CONCURRENT_LOCK_TYPE, GET_LOCK_TIME_OUT_NAME);

        long getLockTimeOut = 0;
        if (lstOfVal == null || com.shufensoft.crm.common.utils.StringUtils.isBlank(lstOfVal.getValue()) || !NumberUtils.isNumber(lstOfVal.getValue())) {
            getLockTimeOut = DEFAULT_GET_LOCK_TIME_OUT;

        }

        long end = 0;

        /**
         * 重试直到成功或者超时为止
         */
        while (end - start <= getLockTimeOut) {

            try {

                flag = RedisCache.putNX(lockId, true);

                if (flag != null && flag) {
                    return true;
                }

                Thread.sleep(200);//减轻重试时缓存压力

            } catch (InterruptedException e) {
                logger.error("concurrentControlHelper.getConcurrentThreadLock error", e);
            }

            end = System.currentTimeMillis();
        }

        return false;
    }

    /**
     * 获取线程锁
     * @param bizMaxConcurrentThreadkey
     * @param bizMaxConcurrentThreadType
     * @return
     */
    public boolean getConcurrentThreadLock(String bizMaxConcurrentThreadType ,String bizMaxConcurrentThreadkey){

        long start = System.currentTimeMillis();

        LstOfVal lstOfVal = LstOfValCache.getLOV(CONCURRENT_LOCK_TYPE, GET_LOCK_TIME_OUT_NAME);

        long getLockTimeOut = 0;
        if(lstOfVal == null || StringUtils.isBlank(lstOfVal.getValue()) || !NumberUtils.isNumber(lstOfVal.getValue())){
            getLockTimeOut = DEFAULT_GET_LOCK_TIME_OUT;

        }

        long end = 0;

        /**
         * 重试直到成功或者超时为止
         */
        while (end - start <= getLockTimeOut){

            Boolean lockFlag = isBizConcurrentThreadOut(bizMaxConcurrentThreadType,bizMaxConcurrentThreadkey);
            /**
             * lockFlag=true,有锁被释放
             */
            if(true == lockFlag){
                return true;
            }

            try {
                Thread.sleep(500);//减轻重试时缓存压力
            } catch (InterruptedException e) {
                logger.error("concurrentControlHelper.getConcurrentThreadLock error",e);
            }

            end = System.currentTimeMillis();
        }

        return false;
    }

    /**
     * 释放锁,线程数减一
     * @return
     */
    public  Long releaseBizConcurrentThreadLock(){

        return concurrentThreadNum.decrementAndGet();

    }
}
