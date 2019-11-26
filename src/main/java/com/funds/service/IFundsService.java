package com.funds.service;

import com.funds.Bo.FundsBo;
import com.funds.domain.FundDetail;

import java.util.Map;

/**
 * @author tuzhijin
 * @version Id: IFundsService.java, v 0.1 2019/11/24 23:23 tuzhijin Exp $$
 */
public interface IFundsService {

    int insertSelective(FundDetail record);

    Map<String, Object> calculateAvgRate(FundsBo fundsBo);
}
