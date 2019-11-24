package com.funds.service;

import com.funds.dao.FundDetailMapper;
import com.funds.domain.FundDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tuzhijin
 * @version Id: FundsServiceImpl.java, v 0.1 2019/11/24 23:23 tuzhijin Exp $$
 */
@Service
public class FundsServiceImpl implements IFundsService{

    @Autowired
    private FundDetailMapper fundDetailMapper;

    @Override
    public int insertSelective(FundDetail record) {
        return fundDetailMapper.insertSelective(record);
    }
}
