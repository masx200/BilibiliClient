package com.github.masx200.biliClient.api.relation;

import com.github.masx200.biliClient.BiliCall;
import com.github.masx200.biliClient.BiliRequest;
import com.github.masx200.biliClient.able.Listable;
import com.github.masx200.biliClient.model.relation.Relation;

/**
 * 描述： 关系
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-16:32
 * @since 2021-02-08-16:32
 */
public class RelationList implements Listable<Relation> {

    private final BiliRequest result;

    public RelationList(BiliRequest result) {
        this.result = result;
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
