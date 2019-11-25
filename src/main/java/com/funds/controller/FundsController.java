package com.funds.controller;

import com.alibaba.fastjson.JSON;
import com.funds.config.HttpAPIService;
import com.funds.domain.FundDetail;
import com.funds.service.IFundsService;
import com.funds.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author tuzhijin
 * @version Id: DemoController.java, v 0.1 2019/11/24 19:46 tuzhijin Exp $$
 */
@RestController
@Slf4j
public class FundsController {

    @Autowired
    private IFundsService service;

    @Autowired
    private HttpAPIService httpAPIService;

    @GetMapping("/test")
    public String getMessage(@RequestParam String message) {
        return "2019 hello, " + message;
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody FundDetail fundDetail) {
        try {
            log.info("入参：{}", JSON.toJSON(fundDetail));
            service.insertSelective(fundDetail);
            return new Result(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("插入数据失败");
        }
    }

    @GetMapping("/getData")
    public Result getData() {
        String url = "http://fund.eastmoney.com/f10/F10DataApi.aspx?type=lsjz&code=110022&page=2&per=40";
        String result;
        try {
            result = httpAPIService.doGet(url);
            log.info("result:{}", result);
        } catch (Exception e) {
            throw new RuntimeException("远程异常");
        }
        return new Result(result);
    }
}
