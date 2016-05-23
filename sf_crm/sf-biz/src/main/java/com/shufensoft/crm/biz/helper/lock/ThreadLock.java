package com.shufensoft.crm.biz.helper.lock;

import com.shufensoft.crm.biz.cache.LstOfValCache;
import com.shufensoft.crm.biz.domain.generation.system.LstOfVal;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicLong;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/12  
 */
public class ThreadLock {

    private static final Logger logger = Logger.getLogger(ThreadLock.class);


    public static Long DEFAULT_GET_LOCK_TIME_OUT = 10000L;

    public static String CONCURRENT_LOCK_TYPE = "CONCURRENT_LOCK";

    public static String GET_LOCK_TIME_OUT_NAME = "getLockTimeOut";

    private AtomicLong lockFlag;

    public ThreadLock(){

        lockFlag = new AtomicLong(0);

    }

    public boolean releaseLock(){

        return lockFlag.decrementAndGet()==0;
    }

    public boolean getLock(){

        if (lockFlag.get() == 0) {
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


                if (lockFlag.incrementAndGet() == 1) {
                    return true;
                }

                Thread.sleep(50);

            } catch (InterruptedException e) {
                logger.error("ThreadLock.getLock error", e);
            }

            end = System.currentTimeMillis();
        }

        return false;
    }
}
