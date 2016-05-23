package com.shufensoft.crm.biz.cache;

import com.shufensoft.crm.biz.domain.generation.system.LstOfVal;
import com.shufensoft.crm.biz.service.system.LstOfValService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *              系统配置缓存
 *             </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/23  
 */
public class LstOfValCache {


    private static LstOfValService lstOfValService;

    static {
        lstOfValService = (LstOfValService) SpringContextUtil.getBean("lstOfValService");
    }


    /**
     * 通过类型和名称(TYPE,Name)字段,得到一个唯一LstOfVal,
     * 如果数据库中找到多个，默认返回第一个.
     * 如果没有,则返回null
     *
     * @param type,name
     * @return
     */
    public static LstOfVal getLOV(String type, String name) {

        AssertsUtil.notBothSidesBlank(type, "type is null");
        AssertsUtil.notBothSidesBlank(type, "name is null");

        String key = type + "_#@#_" + name;

        if (RedisCache.get(key) == null) {
            reload(type, name);
        }


        return (LstOfVal) RedisCache.get(key);

    }

    /**
     * 通过类型和名称(TYPE,Name)字段,得到一个唯一value,
     * 如果数据库中找到多个，默认返回第一个.
     * 如果没有,则返回null
     *
     * @param type,name
     * @return
     */
    public static String getValue(String type, String name) {

        AssertsUtil.notBothSidesBlank(type, "type is null");
        AssertsUtil.notBothSidesBlank(type, "name is null");

        String key = type + "_#@#_" + name;

        if (RedisCache.get(key) == null) {
            reload(type, name);
        }
        LstOfVal lstOfVal = (LstOfVal) RedisCache.get(key);
        if(lstOfVal == null){
            return lstOfVal.getValue();
        }
        return null;

    }

    /**
     * 通过类型(TYPE)字段,得到一个LstOfVal的列表
     *
     * @param type
     * @return
     */
    public static List<LstOfVal> getTypeList(String type) {

        AssertsUtil.notBothSidesBlank(type, "type is null");

        String key = type;

        if (RedisCache.get(key) == null) {
            reload(type);
        }

        return (List<LstOfVal>) RedisCache.get(key);
    }


    /**
     * 根据type刷缓存
     *
     * @param type
     */
    public static void reload(String type) {

        AssertsUtil.notBothSidesBlank(type, "type is null");

        List<LstOfVal> lstOfVals = lstOfValService.getLstOfValsByType(type);

        RedisCache.put(type, (ArrayList<LstOfVal>)lstOfVals);

    }

    /**
     * 根据type刷缓存
     *
     * @param type
     */
    public static void reload(String type, String name) {

        AssertsUtil.notBothSidesBlank(type, "type is null");
        AssertsUtil.notBothSidesBlank(type, "name is null");
        List<LstOfVal> lstOfVals = lstOfValService.getLstOfValsByTypeAndName(type, name);

        if (!CollectionUtils.isEmpty(lstOfVals)) {
            String key = type + "_#@#_" + name;
            RedisCache.put(key, lstOfVals.get(0));
        }

    }


}
