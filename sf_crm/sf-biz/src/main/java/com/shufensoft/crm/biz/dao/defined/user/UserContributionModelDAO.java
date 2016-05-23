package com.shufensoft.crm.biz.dao.defined.user;

import com.shufensoft.crm.biz.domain.defined.user.ContributionModelDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *               用户价值模型
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/16  
 */
@Repository
public interface UserContributionModelDAO {

    /**
     * 用户价值模型统计
     * @param source
     * @param startContribution
     * @param endContribution
     * @return
     */
    public List<ContributionModelDO> queryUserContributionModel(@Param("source")String source, @Param("startContribution")BigDecimal startContribution, @Param("endContribution")BigDecimal endContribution, @Param("sellerId")Long sellerId);
}
