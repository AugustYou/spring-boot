package com.funds.Bo;

import lombok.Data;

import java.util.List;


@Data
public class FundsBo {

    private String startDate;
    private String endDate;
    private List<Business> lists;

}
