package com.shufensoft.crm.biz.service.hongbao.helper;

import com.shufensoft.crm.biz.cache.RedisCache;
import com.shufensoft.crm.biz.dao.generation.point.PointObtainMapper;
import com.shufensoft.crm.biz.domain.generation.point.PointObtain;
import com.shufensoft.crm.biz.domain.generation.point.PointObtainExample;
import com.shufensoft.crm.biz.helper.ConcurrentControlHelper;
import com.shufensoft.crm.biz.service.rock.RockService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 积分工具类
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/10 下午10:57  
 */
public class PointHelper {
    private static String POINT_NUM = "POINT_NUM";

    private static RockService rockService;

    private static PointObtainMapper pointObtainMapper;

    static {
        rockService = (RockService) SpringContextUtil.getBean("rockService");
        pointObtainMapper = (PointObtainMapper) SpringContextUtil.getBean("pointObtainMapper");
    }

    public static boolean isPointObtained(Long sellerId,Long rockId) {

        AssertsUtil.notNull(rockId, "rockId不能为空");

        if (ConcurrentControlHelper.getDistributedThreadLock(POINT_NUM + "_" + rockId + "_LOCK")) {
            try {

                Integer num = 0;
                Object numObject = null;//RedisCache.get(POINT_NUM + "_" + rockId);

                if (null == numObject) {
                    int count = rockService.queryPointCountByRockId(sellerId,rockId);
                    RedisCache.put(POINT_NUM + "_" + rockId, count);
                    num = Integer.valueOf(count);
                }


                if (num <= 0) {
                    return false;

                }

                RedisCache.put(POINT_NUM + "_" + rockId, num - 1);


            } catch (Exception e) {

                throw new RuntimeException("摇一摇积分出错。");

            } finally {

                /**
                 * 锁释放
                 */
                ConcurrentControlHelper.releaseDistributedLock(POINT_NUM + "_" + rockId + "_LOCK");

            }

            // }

            //throw new RuntimeException("领取积分的人数过多,请稍后再试");

        }
        return true;
    }


    /**
     * 积分数量加一
     *
     * @param rockId 摇一摇ID
     * @return
     */
    public static boolean incrementPointNum(Long rockId) {

        if (ConcurrentControlHelper.getDistributedThreadLock(POINT_NUM + "_" + rockId + "_LOCK")) {

            try {

                Integer num = (Integer) RedisCache.get(POINT_NUM + "_" + rockId);
                RedisCache.put(POINT_NUM + "_" + rockId, num + 1);
                return true;

            } catch (Exception e) {

                throw new RuntimeException("系统繁忙，请稍后重试。");

            } finally {

                /**
                 * 锁释放
                 */
                ConcurrentControlHelper.releaseDistributedLock(POINT_NUM + "_" + rockId + "_LOCK");

            }

        }

        throw new RuntimeException("摇积分的人数过多,请稍后再试");

    }


    /**
     * 根据积分获取表ID查询积分值。
     *
     * @return 值
     */
    public static Long queryPointByObtainId(Long pointId) {

        Long code = -1l;
        PointObtainExample pointObtainExample = new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
        criteria.andIdEqualTo(pointId);

        List<PointObtain> pointObtainList = pointObtainMapper.selectByExample(pointObtainExample);
        if (pointObtainList != null && !pointObtainList.isEmpty()) {
            return pointObtainList.get(0).getAmount();
        }

        return code;
    }

}