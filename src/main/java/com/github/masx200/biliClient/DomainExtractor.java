package com.github.masx200.biliClient;

import org.apache.http.client.methods.HttpRequestBase;

public class DomainExtractor {

    public static String getDomainFromHttpRequest(HttpRequestBase httpRequest) {
        // 获取请求的 URI
        String uri = httpRequest.getURI().toString();

        // 创建一个 URI 对象
        java.net.URI parsedUri;
        try {
            parsedUri = new java.net.URI(uri);
        } catch (Exception e) {
            throw new RuntimeException("无法解析 URI: " + uri, e);
        }

        // 获取主机名（域名）
        String domain = parsedUri.getHost();

        return domain;
    }}
