package com.github.masx200.biliClient.api.relation;

import com.github.masx200.biliClient.BiliRequestFactor;
import com.github.masx200.biliClient.able.Listable;
import com.github.masx200.biliClient.model.relation.Relation;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.function.Consumer;

/**
 * 描述： 关系条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-16:53
 * @since 2021-02-08-16:53
 */
public class RelationConditionImpl implements IRelationCondition {
    private final Consumer<HttpRequestBase> beforeRequest;

    // 默认构造函数
    public RelationConditionImpl() {
        this.beforeRequest = null;
    }

    // 带参数的构造函数
    public RelationConditionImpl(Consumer<HttpRequestBase> beforeRequest) {
        this.beforeRequest = beforeRequest;
    }

    @Override
    public Listable<Relation> toFollowers(long uid) {
        return new RelationList(BiliRequestFactor.getBiliRequest().setPath(RelationPath.RELATION_FOLLOWERS)
                .setParams("vmid", uid));
    }

    @Override
    public Listable<Relation> toFollowings(long uid) {
        return new RelationList(BiliRequestFactor.getBiliRequest().setPath(RelationPath.RELATION_FOLLOWINGS)
                .setParams("vmid", uid));
    }
}
