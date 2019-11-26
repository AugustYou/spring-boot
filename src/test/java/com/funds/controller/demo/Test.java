package com.funds.controller.demo;

import com.alibaba.fastjson.JSON;
import com.funds.Bo.Business;
import com.funds.Bo.FundsBo;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tuzhijin
 * @version Id: Test.java, v 0.1 2019/11/25 21:42 tuzhijin Exp $$
 */
public class Test {

    public static void main(String[] args) {
//        getdatas();
        List list = new ArrayList();
        FundsBo bo = new FundsBo();
        bo.setStartDate("2019-10-12");
        bo.setEndDate("2019-11-18");
        Business business = new Business();
        business.setFcode("160216");
        business.setRatio("0.5");
        list.add(business);
        bo.setLists(list);
        System.out.println(JSON.toJSON(bo));
    }

    private static void getdatas() {
        String s = "var apidata={ content:\"<table class='w782 comm lsjz'><thead><tr><th class='first'>净值日期</th><th>单位净值</th><th>累计净值</th><th>日增长率</th><th>申购状态</th><th>赎回状态</th><th class='tor last'>分红送配</th></tr></thead><tbody><tr><td>2019-11-25</td><td class='tor bold'>2.9350</td><td class='tor bold'>2.9350</td><td class='tor bold grn'>-0.10%</td><td>开放申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2019-11-22</td><td class='tor bold'>2.9380</td><td class='tor bold'>2.9380</td><td class='tor bold grn'>-1.84%</td><td>开放申购</td><td>开放赎回</td><td class='red unbold'></td></tr></tbody></table>\",records:2232,pages:1116,curpage:1};";
        Document document = Jsoup.parse(s);
        final Element body = document.body();
        System.out.println(body.toString().split(",")[2].split(":")[1]);
        System.out.println(body);
        final Elements tbody = body.getElementsByTag("tbody");
        final String text = tbody.text();
        if (StringUtils.isNotBlank(text)) {
            final String[] arr = text.split("\\s+");
            final int i = arr.length / 6;
            for (int j = 0; j < i; j++) {
                j = 6 * j;
//                System.out.println(arr[j]);
//                System.out.println(arr[j + 1]);
//                System.out.println(arr[j + 2]);
//                System.out.println(arr[j + 3]);
//                System.out.println(arr[j + 4]);
//                System.out.println(arr[j + 5]);
            }
        }
    }

}
