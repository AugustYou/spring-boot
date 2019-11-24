package com.funds.service;

import com.funds.domain.FundDetail;

/**
 * @author tuzhijin
 * @version Id: IFundsService.java, v 0.1 2019/11/24 23:23 tuzhijin Exp $$
 */
public interface IFundsService {

    int insertSelective(FundDetail record);

}
