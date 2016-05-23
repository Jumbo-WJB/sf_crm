package com.shufensoft.crm.biz.service.system.impl;

import com.shufensoft.crm.biz.dao.generation.system.SysTokenMapper;
import com.shufensoft.crm.biz.domain.generation.system.SysToken;
import com.shufensoft.crm.biz.domain.generation.system.SysTokenExample;
import com.shufensoft.crm.biz.service.system.SysTokenService;
import com.shufensoft.crm.biz.service.system.vo.SysTokenVO;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/9/9  
 */
@Service(value = "sysTokenService")
public class SysTokenServiceImpl implements SysTokenService{

    @Autowired
    private SysTokenMapper sysTokenMapper;

    @Override
    public boolean createToken(SysTokenVO sysTokenVO) {

        SysToken sysToken = new SysToken();

        BeanCopierUtils.copyProperties(sysTokenVO,sysToken);
        sysTokenMapper.insert(sysToken);

        return true;
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    @Override
    @Transactional
    public boolean validateToken(String token) {

        if (isRepeatSubmit(token)) {
            return false;
        }

        /**
         * 验证成功删除token
         */
        SysTokenExample sysTokenExample = new SysTokenExample();
        sysTokenExample.createCriteria().andTokenEqualTo(token);
        sysTokenMapper.deleteByExample(sysTokenExample);

        return true;

    }

    /**
     * 判断表单是否重复提交
     *
     * @param token
     * @return
     */
    private boolean isRepeatSubmit(String token) {

        if (StringUtils.isBlank(token)) {
            return true;
        }

        SysTokenExample sysTokenExample = new SysTokenExample();
        sysTokenExample.setForUpdate(true);
        sysTokenExample.createCriteria().andTokenEqualTo(token);
        List<SysToken> sysTokens = sysTokenMapper.selectByExample(sysTokenExample);

        if(CollectionUtils.isEmpty(sysTokens)){
            return true;
        }

        if (sysTokens.get(0).getGmtExpired().before(new Date())) {
            return true;
        }

        return false;
    }
}
