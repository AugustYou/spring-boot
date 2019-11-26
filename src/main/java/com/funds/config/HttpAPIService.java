package com.funds.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
public class HttpAPIService {
    private static final String EXCEPTION_MSG_PATTERN = "接口异常信息：{}";

    private CloseableHttpClient httpClient;
    private RequestConfig config;

    public static final String encode = "UTF-8";

    /**
     * 不带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     *
     * @param url 请求连接
     * @return 结果
     * @throws Exception 异常
     */
    public String doGet(String url) throws Exception {

        // 获取HttpGet
        HttpGet httpGet = getHttpGet(url);

        // 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpGet);

        // 判断状态码是否为200
        if (response.getStatusLine().getStatusCode() == HttpResult.CODE_200) {
            // 返回响应体的内容
            return EntityUtils.toString(response.getEntity(), encode);
        } else {
            log.error(EXCEPTION_MSG_PATTERN, response.getEntity().toString());
        }
        return null;
    }

    /**
     * 带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     *
     * @param url 请求连接
     * @return 结果
     * @throws Exception 异常
     */
    public String doGet(String url, Map<String, Object> map) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(url);

        if (map != null) {
            // 遍历map,拼接请求参数
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }
        // 调用不带参数的get请求
        return this.doGet(uriBuilder.build().toString());

    }

    /**
     * 带参数的post请求
     *
     * @param url 请求连接
     * @param map 参数
     * @return 结果
     * @throws Exception 异常
     */
    public HttpResult doPost(String url, Map<String, Object> map) throws Exception {
        CloseableHttpResponse response = null;
        HttpPost httpPost = null;
        HttpResult result = null;
        try {
            // 声明httpPost请求
            httpPost = getHttpPost(url);

            // 判断map是否为空，不为空则进行遍历，封装from表单对象
            if (map != null) {
                List<NameValuePair> list = new ArrayList<>();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
                // 构造from表单对象
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, encode);

                // 把表单放到post里
                httpPost.setEntity(urlEncodedFormEntity);
            }

            // 发起请求
            response = this.httpClient.execute(httpPost);
            result = new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(
                    response.getEntity(), encode));
        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        } finally {
            if (response != null) {
                EntityUtils.consume(response.getEntity());
            }
        }
        return result;
    }

    /**
     * 不带参数post请求
     *
     * @param url 请求连接
     * @return 结果
     * @throws Exception 异常
     */
    public HttpResult doPost(String url) throws Exception {
        return this.doPost(url, null);
    }

    /**
     * json格式请求
     *
     * @param apiUrl      请求地址
     * @param requestData 请求数据
     * @param propertyMap 属性map
     */
    public HttpResult doPostJson(String apiUrl, String requestData, Map<String, String> propertyMap) {
        // 获取HttpPost
        HttpPost httpPost = getHttpPost(apiUrl);
        //返回值
        CloseableHttpResponse response = null;
        String respRet = "";
        try {
            if (propertyMap != null && propertyMap.size() > 0) {
                for (Map.Entry<String, String> params : propertyMap.entrySet()) {
                    httpPost.addHeader(params.getKey(), params.getValue());
                }
            } else {
                httpPost.addHeader("Content-Type", "application/json");
            }
            if (StringUtils.isNotBlank(requestData)) {
                StringEntity entity = new StringEntity(requestData, encode);
                entity.setChunked(true);
                httpPost.setEntity(entity);
            }
            // 发送请求
            response = httpClient.execute(httpPost, HttpClientContext.create());
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(
                    response.getEntity(), encode));
        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                log.error("Exception: {}", e.getMessage());
            }
        }
        return null;
    }

    /**
     * 获取HTTP GET 方法
     *
     * @param url 接口连接
     */
    private HttpGet getHttpGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config);
        return httpGet;
    }

    /**
     * 获取HTTP POST 方法
     *
     * @param url 接口连接
     */
    private HttpPost getHttpPost(String url) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(config);
        return httpPost;
    }

    public void setHttpClient(CloseableHttpClient closeableHttpClient) {
        this.httpClient = closeableHttpClient;
    }

    public void setConfig(RequestConfig requestConfig) {
        this.config = requestConfig;
    }

    /**
     * Http请求结果对象结果对象
     */
    public static class HttpResult {
        public static final int CODE_200 = 200;
        private int code;
        private String body;

        HttpResult(int code, String body) {
            this.code = code;
            this.body = body;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

}