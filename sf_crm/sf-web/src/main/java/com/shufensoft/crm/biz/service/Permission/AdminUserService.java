package com.shufensoft.crm.biz.service.Permission;

import com.shufensoft.crm.biz.dao.generation.permission.AdminUserMapper;
import com.shufensoft.crm.biz.domain.generation.permission.AdminUser;
import com.shufensoft.crm.biz.domain.generation.permission.AdminUserExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.Md5Encrypt;
import com.shufensoft.crm.web.vo.AdminUserVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 后台用户服务类
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/29 23:15  
 */
@Service
public class AdminUserService {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(AdminUserService.class);

    @Autowired
    private AdminUserMapper adminUserMapper;

    /**
     * 通过UserName查询用户
     * @param userName
     * @return
     */
    public AdminUserVO findAdminUserByUserName(String userName) {

        AdminUserExample adminUserExample = new AdminUserExample();
        adminUserExample.createCriteria().andUserNameEqualTo(userName);
        List<AdminUser> adminUserVOs = adminUserMapper.selectByExample(adminUserExample);
        AdminUserVO adminUserVO = null;
        if(!CollectionUtils.isEmpty(adminUserVOs)){
            adminUserVO = (AdminUserVO)BeanCopierUtils.copyProperties(adminUserVOs.get(0), AdminUserVO.class);
        }

        return adminUserVO;
    }

    /**
     * 修改用户密码
     * @param adminUserVO
     * @return
     */
    public boolean  updatePasswd(AdminUserVO adminUserVO) {

        AdminUserVO adminUser = findAdminUserByUserName(adminUserVO.getUserName());

        if(adminUser == null){
            throw new ServiceException("用户名不存在");
        }

        String oldPasswd = Md5Encrypt.md5(adminUserVO.getPassword());
        if(!oldPasswd.equals(adminUser.getPassword())){
            throw new ServiceException("原密码错误");
        }

        adminUser.setPassword(adminUserVO.getNewpasswd1());
        AdminUser updateAdminUser = (AdminUser)BeanCopierUtils.copyProperties(adminUser,AdminUser.class);

        return adminUserMapper.updateByPrimaryKey(updateAdminUser)==1;

    }

    /**
     * 验证用户名是否存在
     *
     * @param userName
     * @return
     */
    public boolean checkSameUserName(String userName) {

        AdminUser adminUser = findAdminUserByUserName(userName);

        if (adminUser != null) {
            return true;
        }

        return false;
    }

}
