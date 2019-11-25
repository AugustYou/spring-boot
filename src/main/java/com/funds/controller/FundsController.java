package com.funds.controller;

import com.alibaba.fastjson.JSON;
import com.funds.config.HttpAPIService;
import com.funds.domain.FundDetail;
import com.funds.service.IFundsService;
import com.funds.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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
    public Result getData(@RequestParam("code") String code,
                          @RequestParam("pages") Integer pages) {
        try {
            for (int page = 1; page < pages + 1; page++) {
                StringBuilder url = new StringBuilder("http://fund.eastmoney.com/f10/F10DataApi.aspx?type=lsjz&code=");
                url.append(code).append("&page=").append(page).append("&per=40");
                String result = httpAPIService.doGet(url.toString());
                Document document = Jsoup.parse(result);
                final Element body = document.body();
                final Elements tbody = body.getElementsByTag("tbody");
                final String text = tbody.text();
                if (StringUtils.isNotBlank(text)) {
                    final String[] arr = text.split("\\s+");
                    final int i = arr.length / 6;
                    for (int j = 0; j < i; j++) {
                        FundDetail detail = new FundDetail();
                        detail.setFdate(DateUtils.parseDate(arr[j], "yyyy-MM-dd"));
                        detail.setNav(new BigDecimal(arr[j + 1]));
                        detail.setAccnav(new BigDecimal(arr[j + 2]));
                        detail.setDgr(arr[j + 3]);
                        detail.setPstate(arr[j + 4]);
                        detail.setRstate(arr[j + 5]);
                        j = 6 * j;
                        service.insertSelective(detail);
                    }
                }
                Thread.sleep(1000 * 60);
            }
        } catch (Exception e) {
            throw new RuntimeException("远程异常");
        }
        return new Result(HttpStatus.OK);
    }
}
