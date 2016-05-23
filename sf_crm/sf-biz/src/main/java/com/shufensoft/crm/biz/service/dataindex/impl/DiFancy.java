package com.shufensoft.crm.biz.service.dataindex.impl;

import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBao;
import com.shufensoft.crm.biz.service.dataindex.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-31 21:35  
 */
public class DiFancy extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diFancy";
        this.description = "喜好";
        this.dataList = Arrays.asList(DataTypeEnum.ORDER_TB);
        this.platformList = Arrays.asList(PlatformEnum.TB);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {

        return  new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {

        List<CidCnt> cidCntList = new ArrayList<CidCnt>();

        List<OrderTaoBao> orderTaoBaoList = rawData.getOrderTaoBaoList();

        if(!CollectionUtils.isEmpty(orderTaoBaoList)){

            for(OrderTaoBao orderTaoBao : orderTaoBaoList) {
                String cid = orderTaoBao.getCid().toString();
                boolean hasSame = false;
                for(CidCnt cidCnt : cidCntList) {
                    if(cidCnt.getCid().equals(cid)) {
                        hasSame = true;
                        cidCnt.setCnt(cidCnt.getCnt() + 1);
                    }
                }

                if(!hasSame) {
                    CidCnt cidCnt = new CidCnt();
                    cidCnt.setCnt(1);
                    cidCnt.setCid(cid);
                    cidCntList.add(cidCnt);
                }
            }

        }

        // 从大到小排序
        Collections.sort(cidCntList);

        if(cidCntList.size() == 0) {
            return new DataIndexResult("no valid trade", true);
        } else {
            return new DataIndexResult(cidCntList.get(0).getCid());
        }

    }

    class CidCnt implements Comparable<CidCnt> {
        private String cid;

        private int cnt = 0;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        public int compareTo(CidCnt cidCnt) {
            if(this.cnt > cidCnt.getCnt()) {
                return -1;
            } else if (this.cnt < cidCnt.getCnt()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
