package com.funds.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FundDetail {
    private Integer id;

    //基金代码
    private String fcode;

    //基金日期
    private Date fdate;

    //单位净值
    private BigDecimal nav;

    //累计净值
    private BigDecimal accnav;

    //日增长率
    private String dgr;

    //申购状态
    private String pstate;

    //赎回状态
    private String rstate;

}
