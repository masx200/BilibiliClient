package com.github.masx200.biliClient.api.dynamic;

import com.github.masx200.biliClient.BiliCall;
import com.github.masx200.biliClient.BiliRequest;
import com.github.masx200.biliClient.BiliResult;
import com.github.masx200.biliClient.able.Listable;
import com.github.masx200.biliClient.exception.BiliRequestException;
import com.github.masx200.biliClient.model.dynamic.DynamicItems;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.function.Consumer;

/**
 * 描述： 动态 list
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-22:30
 * @since 2021-02-07-22:30
 */
public class DynamicList implements Listable<DynamicItems> {
    private final BiliRequest request;
    private final Consumer<HttpRequestBase> beforeRequest;

    // 默认构造函数
    public DynamicList(BiliRequest request) {
        this(request, null);
    }

    // 带参数的构造函数
    public DynamicList(BiliRequest request, Consumer<HttpRequestBase> beforeRequest) {
        this.request = request;
        this.beforeRequest = beforeRequest;
    }

    @Override
    public DynamicItems list() throws Exception {
        BiliResult biliResult = BiliCall.doCall(request,beforeRequest);
        return DynamicItems.build(biliResult);
    }

    /**
     * 目前不支持当前方式调用
     *
     * @param limit  size
     * @param offset 偏移量
     * @return exception
     * @see #list(Long)
     */
    @Deprecated
    @Override
    public DynamicItems list(Long limit, Long offset) {
//        BiliResult biliResult = BiliCall.doCall(request
//                .setParams("offset_dynamic_id", offset)
//                .setParams("limit", limit));
//        return DynamicItems.build(biliResult);
        throw new BiliRequestException(request.getURI(), "目前不支持此种方式调用");
    }

    @Override
    public DynamicItems list(Long nextOffset) throws Exception {
        BiliResult biliResult = BiliCall.doCall(request.setParams("offset_dynamic_id", nextOffset),beforeRequest);
        return DynamicItems.build(biliResult);
    }
}
