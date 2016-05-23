package com.shufensoft.crm.biz.service.system;

import com.shufensoft.crm.biz.dao.generation.system.LstOfValMapper;
import com.shufensoft.crm.biz.domain.generation.system.LstOfVal;
import com.shufensoft.crm.biz.domain.generation.system.LstOfValExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 系统配置服务
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/23  
 */
@Service
public class LstOfValService {

    @Autowired
    private LstOfValMapper lstOfValMapper;

    public List<LstOfVal> getLstOfValsByTypeAndName(String type, String name){

        LstOfValExample lstOfValExample = new LstOfValExample();
        lstOfValExample.createCriteria().andTypeEqualTo(type).andNameEqualTo(name);

        return lstOfValMapper.selectByExample(lstOfValExample);
    }

    public List<LstOfVal> getLstOfValsByType(String type){

        LstOfValExample lstOfValExample = new LstOfValExample();
        lstOfValExample.createCriteria().andTypeEqualTo(type);

        return lstOfValMapper.selectByExample(lstOfValExample);
    }
}
