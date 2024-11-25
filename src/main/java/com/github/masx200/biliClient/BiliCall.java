package com.github.masx200.biliClient;

import com.alibaba.fastjson.JSONObject;
import com.github.masx200.biliClient.client.BaseClient;
import com.github.masx200.biliClient.exception.BiliRequestException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;

/**
 * 描述： 发起请求
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-15:18
 * @since 2021-02-07-15:18
 */
public class BiliCall {

    /**
     * 进行请求
     *
     * @param httpRequest 请求
     * @param baseClient  请求客户端
     * @return 响应结果
     */
    public static BiliResult doCall(HttpRequestBase httpRequest, BaseClient baseClient) {
        try {
            // 获取请求客户端
            HttpClient httpClient = baseClient.getHttpClient();
            RequestConfig requestConfig = baseClient.getRequestConfig();
            httpRequest.setConfig(requestConfig);

            // 发起请求
            HttpResponse response = httpClient.execute(httpRequest);
            System.out.println(httpRequest.getMethod());
            System.out.println(httpRequest.getURI());
            System.out.println(response.getStatusLine());

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new BiliRequestException(httpRequest.getURI(), "请求失败，状态码: " + statusCode);
            }
            // 判空
            String body = EntityUtils.toString(response.getEntity());
            if (body == null || body.isEmpty()) {
                throw new Exception("响应体为空");
            }
            // 转换
            return JSONObject.parseObject(body, BiliResult.class).check();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BiliRequestException(httpRequest.getURI(), e.getMessage());
        }
    }

    /**
     * 默认Get 请求
     *
     * @param request 请求
     * @return 响应结果
     */
    public static BiliResult doCall(BiliRequest request) {
        return doCall(new HttpGet(request.getURI()), request.getBaseClient());
    }
}
