package com.shufensoft.crm.biz.service.shake;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.dao.defined.shake.ShakeQueryDAO;
import com.shufensoft.crm.biz.dao.generation.shake.ShakeDetailMapper;
import com.shufensoft.crm.biz.domain.defined.shake.ShakeQueryDO;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeDetail;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeDetailExample;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.rock.vo.RockConfigVO;
import com.shufensoft.crm.biz.vo.ShakeQueryVO;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/17 上午11:24  
 */
@Service
public class ShakeMultipleService {

    @Autowired
    private ShakeQueryDAO shakeQueryDAO;

    @Autowired
    private ShakeDetailMapper shakeDetailMapper;

    @Autowired
    private IPointService pointService;

    /**
     * 查询摇一摇结果
     * @param shakeQueryVO
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo queryShakeObtain(ShakeQueryVO shakeQueryVO,Integer start,Integer pageSize){

        ShakeQueryDO shakeQueryDO = new ShakeQueryDO();

        if (StringUtils.isNotEmpty(shakeQueryVO.getWxNickName())){
            shakeQueryDO.setWxNickName(shakeQueryVO.getWxNickName());
        }

        if (StringUtils.isNotEmpty(shakeQueryVO.getMobile())){
            shakeQueryDO.setMobile(shakeQueryVO.getMobile());
        }

        if (StringUtils.isNotEmpty(shakeQueryVO.getNDay())){
            shakeQueryDO.setObtainDate(DateUtil.getNDayStartTime(Integer.valueOf(shakeQueryVO.getNDay())));
        }

        if (StringUtils.isNotEmpty(shakeQueryVO.getRockId())){
            shakeQueryDO.setRockId(Long.valueOf(shakeQueryVO.getRockId()));
        }

        shakeQueryDO.setSellerId(shakeQueryVO.getSellerId());
        PageHelper.startPage(start,pageSize);
        List<ShakeQueryDO> shakeQueryDOList =  shakeQueryDAO.selectUserShakeDetail(shakeQueryDO);


        return new PageInfo(shakeQueryDOList);

    }

    /**
     * 根据ID查询摇一摇配置
     * @param id
     * @return
     */
    public RockConfigVO getRockConfigVOById(String id){

        RockConfigVO rockConfigVO = new RockConfigVO();
        ShakeDetailExample shakeDetailExample = new ShakeDetailExample();
        shakeDetailExample.createCriteria().andIdEqualTo(Long.valueOf(id));

        List<ShakeDetail> shakeDetailList = shakeDetailMapper.selectByExample(shakeDetailExample);

        if (shakeDetailList !=null && !shakeDetailList.isEmpty()){
            BeanCopierUtils.copyProperties(shakeDetailList.get(0),rockConfigVO);
            return rockConfigVO;
        }
        return null;
    }

    /**
     * 查询摇一摇配置查询
     * @param rockConfigVO
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo getShakeConfigQuery(RockConfigVO rockConfigVO,Integer start,Integer pageSize) {

        ShakeDetailExample shakeDetailExample = new ShakeDetailExample();

        shakeDetailExample.setOrderByClause("id desc");
        ShakeDetailExample.Criteria criteria = shakeDetailExample.createCriteria();
        if (StringUtils.isNotEmpty(rockConfigVO.getRockTitle())){
            criteria.andRockTitleEqualTo(rockConfigVO.getRockTitle());
        }

        if (StringUtils.isNotEmpty(rockConfigVO.getStatus())){
            criteria.andStatusEqualTo(rockConfigVO.getStatus());
        }

        criteria.andSellerIdEqualTo(rockConfigVO.getSellerId());

        PageHelper.startPage(start,pageSize);
        List<ShakeDetail> shakeDetailList = shakeDetailMapper.selectByExample(shakeDetailExample);

        return new PageInfo(shakeDetailList);
    }



    /**
     * 删除摇一摇配置
     * @param rockId
     */
    public void deleteRockConfig(Long rockId){
        shakeDetailMapper.deleteByPrimaryKey(rockId);
    }

}
