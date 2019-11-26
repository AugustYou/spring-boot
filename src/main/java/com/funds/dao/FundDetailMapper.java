package com.funds.dao;

import com.funds.domain.FundDetail;
import com.funds.domain.FundDetailExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FundDetailMapper {
    int countByExample(FundDetailExample example);

    int deleteByExample(FundDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundDetail record);

    int insertSelective(FundDetail record);

    List<FundDetail> selectByExample(FundDetailExample example);

    FundDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundDetail record, @Param("example") FundDetailExample example);

    int updateByExample(@Param("record") FundDetail record, @Param("example") FundDetailExample example);

    int updateByPrimaryKeySelective(FundDetail record);

    int updateByPrimaryKey(FundDetail record);

    List<FundDetail> calculateAvgRate(@Param("startDate") String startDate,
                                      @Param("endDate") String endDate);
}
