package com.funds.controller;

import com.alibaba.fastjson.JSON;
import com.funds.Bo.FundsBo;
import com.funds.config.HttpAPIService;
import com.funds.domain.FundDetail;
import com.funds.service.IFundsService;
import com.funds.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author tuzhijin
 * @version Id: DemoController.java, v 0.1 2019/11/24 19:46 tuzhijin Exp $$
 */
@RestController
@Slf4j
@CrossOrigin
public class FundsController {

    @Autowired
    private IFundsService service;

    @Autowired
    private HttpAPIService httpAPIService;


    @PostMapping("/insertDate")
    public Result insert(@RequestBody FundDetail fundDetail) {
        try {
            log.info("入参：{}", JSON.toJSON(fundDetail));
            service.insertSelective(fundDetail);
            return new Result(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("插入数据失败");
        }
    }

    @PostMapping("/calculateAvgRate")
    public Result calculateAvgRate(@RequestBody FundsBo fundsBo) {
        try {
            log.info("入参：{}", JSON.toJSON(fundsBo));
            if (StringUtils.isBlank(fundsBo.getStartDate())) {
                Calendar calendar = Calendar.getInstance(); //创建Calendar 的实例
                calendar.add(Calendar.YEAR, -1);//当前时间减去一年，即一年前的时间
                calendar.getTime();
                fundsBo.setStartDate(DateFormatUtils.format(calendar.getTime(), "yyyy-MM-dd"));
                fundsBo.setEndDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
            }
            return new Result(service.calculateAvgRate(fundsBo));
        } catch (Exception e) {
            throw new RuntimeException("查询失败！");
        }
    }

    @GetMapping("/getData")
    public Result getData(@RequestParam("code") String code,
                          @RequestParam("pages") Integer pages) {
        try {
            for (int page = 1; page < pages + 1; page++) {
                StringBuilder url = new StringBuilder("http://fund.eastmoney.com/f10/F10DataApi.aspx?type=lsjz&code=");
                url.append(code).append("&page=").append(page).append("&per=40");
                log.info("请求url:{}", url.toString());
                String result = httpAPIService.doGet(url.toString());
                Document document = Jsoup.parse(result);
                Elements trList = document.select("table > tbody > tr");
                List<FundDetail> list = new ArrayList();
                for (Element tdElement : trList) {
                    Elements tdElements = tdElement.select("td");
                    FundDetail fundDetail = new FundDetail();
                    fundDetail.setFdate(DateUtils.parseDate(tdElements.get(0).text(), "yyyy-MM-dd"));
                    fundDetail.setNav(new BigDecimal(tdElements.get(1).text()));
                    fundDetail.setAccnav(new BigDecimal(tdElements.get(2).text()));
                    fundDetail.setDgr(tdElements.get(3).text().replace("%", ""));
                    fundDetail.setFcode(code);
                    fundDetail.setPstate(tdElements.get(4).text());
                    fundDetail.setRstate(tdElements.get(5).text());
//                    log.info("数据详情:{}", fundDetail.toString());
                    list.add(fundDetail);
                    service.insertSelective(fundDetail);
                }
                log.info("插入数据数:{}", list.size());
                Thread.sleep(1000 * 10);
            }
        } catch (Exception e) {
            throw new RuntimeException("远程异常");
        }
        return new Result(HttpStatus.OK);
    }


}
