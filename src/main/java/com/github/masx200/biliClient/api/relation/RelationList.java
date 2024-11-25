package com.github.masx200.biliClient.api.relation;

import com.github.masx200.biliClient.BiliCall;
import com.github.masx200.biliClient.BiliRequest;
import com.github.masx200.biliClient.able.Listable;
import com.github.masx200.biliClient.model.relation.Relation;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.function.Consumer;

/**
 * 描述： 关系
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-16:32
 * @since 2021-02-08-16:32
 */
public class RelationList implements Listable<Relation> {

    private final BiliRequest result;
    private final Consumer<HttpRequestBase> beforeRequest;

    // 默认构造函数
    public RelationList(BiliRequest result) {
        this(result, null);
    }

    // 带参数的构造函数
    public RelationList(BiliRequest result, Consumer<HttpRequestBase> beforeRequest) {
        this.result = result;
        this.beforeRequest = beforeRequest;
    }

    @Override
    public Relation list() {
        return Relation.build(BiliCall.doCall(result,beforeRequest));
    }

    @Override
    public Relation list(Long limit, Long offset) {
        return Relation.build(BiliCall.doCall(result.setParams("pn", offset / limit).setParams("ps", limit),beforeRequest));
    }

    @Override
    public Relation list(Long nextOffset) {
        return Relation.build(BiliCall.doCall(result.setParams("pn", nextOffset),beforeRequest));
    }

    @Override
    public Relation listPage(Long size, Long page) {
        return Relation.build(BiliCall.doCall(result.setParams("pn", page).setParams("ps", size),beforeRequest));
    }
}
