package com.shufensoft.crm.biz.service.system;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.service.system.vo.SysTokenVO;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                  systoken服务类
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/9/9  
 */
@DataSourceSwitch
public interface SysTokenService {

    public boolean createToken(SysTokenVO sysTokenVO);

    public boolean validateToken(String token);
}
