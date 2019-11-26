package com.funds.service;

import com.funds.Bo.Business;
import com.funds.Bo.FundsBo;
import com.funds.dao.FundDetailMapper;
import com.funds.domain.FundDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tuzhijin
 * @version Id: FundsServiceImpl.java, v 0.1 2019/11/24 23:23 tuzhijin Exp $$
 */
@Service
public class FundsServiceImpl implements IFundsService {

    @Autowired
    private FundDetailMapper fundDetailMapper;

    @Override
    public int insertSelective(FundDetail record) {
        return fundDetailMapper.insertSelective(record);
    }

    @Override
    public Map<String, Object> calculateAvgRate(FundsBo fundsBo) {
        Map map = new HashMap();
        List<FundDetail> list = fundDetailMapper.calculateAvgRate(fundsBo.getStartDate(), fundsBo.getEndDate());
        BigDecimal totalDgr = new BigDecimal(0.0);
        try {
            for (FundDetail fundDetail : list) {
                List<Business> lists = fundsBo.getLists();
                for (int i = 0; i < lists.size(); i++) {
                    if (fundDetail.getFcode().equals(lists.get(i).getFcode())) {
                        // 根据比例计算
                        BigDecimal result = new BigDecimal(fundDetail.getDgr()).multiply(new BigDecimal(lists.get(i).getRatio()));
                        totalDgr = totalDgr.add(result);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("计算失败！");
        }
        map.put("data", list);
        map.put("totalDgr", totalDgr.setScale(2, RoundingMode.HALF_UP));
        return map;
    }
}
