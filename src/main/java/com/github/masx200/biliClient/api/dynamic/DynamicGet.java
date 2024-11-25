package com.github.masx200.biliClient.api.dynamic;

import com.github.masx200.biliClient.BiliCall;
import com.github.masx200.biliClient.BiliRequest;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.model.dynamic.Dynamic;
import com.github.masx200.biliClient.model.dynamic.DynamicCard;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.function.Consumer;

/**
 * 描述： 动态获取
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-21:25
 * @since 2021-02-07-21:25
 */
public class DynamicGet implements Gettable<Dynamic> {
    private final BiliRequest request;
    private final Consumer<HttpRequestBase> beforeRequest;

    // 默认构造函数
    public DynamicGet(BiliRequest request) {
        this(request, null);
    }

    // 带参数的构造函数
    public DynamicGet(BiliRequest request, Consumer<HttpRequestBase> beforeRequest) {
        this.request = request;
        this.beforeRequest = beforeRequest;
    }

    @Override
    public Dynamic get() {
        Object data = BiliCall.doCall(request,beforeRequest).getData();
        return JSONObject.parseObject(data.toString()).getJSONObject("card")
                .toJavaObject(DynamicCard.class).toDynamic();

    }
}
