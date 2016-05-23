package com.shufensoft.crm.biz.service.hongbao.helper;

import com.shufensoft.crm.biz.cache.RedisCache;
import com.shufensoft.crm.biz.helper.ConcurrentControlHelper;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.vo.HBPoolVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import org.apache.log4j.Logger;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 红包helper
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/28  
 */
public class HongBaoHelper {

    private static final Logger logger = Logger.getLogger(HongBaoHelper.class);

    private static String HB_NUM = "HB_NUM";

    private static HongbaoService hongbaoService;

    static {
        hongbaoService = (HongbaoService) SpringContextUtil.getBean("hongbaoService");
    }

    /**
     * 红包是否已经领完，用来去掉web层无用的并发请求（比如10000个线程进来，
     * 实际红包只有1000个，9000个线程直接返回红包已领完，不必再走业务层，提高性能，降低数据库压力）
     *
     * @param hbPoolId
     * @return
     */
    public static Boolean isHongBaoObtained(Long hbPoolId,Long  sellerId) {

        AssertsUtil.notNull(hbPoolId, "hbPoolId");

        if (ConcurrentControlHelper.getDistributedThreadLock(HB_NUM + "_" + hbPoolId + "_LOCK")) {

            try {

                Long num = (Long) RedisCache.get(HB_NUM + "_" + hbPoolId);

                if (num == null) {
                    HBPoolVO hbPoolVO = hongbaoService.getHBPoolVOByPoolId(hbPoolId,sellerId);
                    AssertsUtil.notNull(hbPoolVO, "红包活动为空!");
                    AssertsUtil.notNull(hbPoolVO.getNumber(), "红包活动数量为空,hbPoolId=" + hbPoolVO.getPoolId());
                    RedisCache.put(HB_NUM + "_" + hbPoolId, hbPoolVO.getNumber());
                    num = hbPoolVO.getNumber();
                }

                if (num <= 0) {

                    return false;

                }

                RedisCache.put(HB_NUM + "_" + hbPoolId, num - 1);

            } catch (Exception e){

                throw new RuntimeException("领取红包出错，请联系商家");

            }finally {
                /**
                 * 锁释放
                 */
                ConcurrentControlHelper.releaseDistributedLock(HB_NUM + "_" + hbPoolId + "_LOCK");

            }

            return true;
        }

        throw new RuntimeException("领取红包的人数过多,请稍后再试");

    }





    /**
     * 红包数量加一
     *
     * @param hbPoolId
     * @return
     */
    public static boolean incrementHongBaoBum(Long hbPoolId) {

        if (ConcurrentControlHelper.getDistributedThreadLock(HB_NUM + "_" + hbPoolId + "_LOCK")) {

            try {

                Long num = (Long) RedisCache.get(HB_NUM + "_" + hbPoolId);
                RedisCache.put(HB_NUM + "_" + hbPoolId, num + 1);
                return true;

            }catch (Exception e){

                throw new RuntimeException("领取红包出错，请联系商家");

            }finally {

                /**
                 * 锁释放
                 */
                ConcurrentControlHelper.releaseDistributedLock(HB_NUM + "_" + hbPoolId + "_LOCK");

            }

        }

        throw new RuntimeException("领取红包的人数过多,请稍后再试");

    }
}
