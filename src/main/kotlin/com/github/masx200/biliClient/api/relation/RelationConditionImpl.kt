package com.github.masx200.biliClient.api.relation

import com.github.masx200.biliClient.BiliRequestFactor
import com.github.masx200.biliClient.able.Listable
import com.github.masx200.biliClient.model.relation.Relation
import java.util.function.Consumer
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述： 关系条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-16:53
 * @since 2021-02-08-16:53
 */
class RelationConditionImpl : IRelationCondition {
    private val beforeRequest: Consumer<HttpRequestBase?>?

    // 默认构造函数
    constructor() {
        this.beforeRequest = null
    }

    // 带参数的构造函数
    constructor(beforeRequest: Consumer<HttpRequestBase?>?) {
        this.beforeRequest = beforeRequest
    }

    override fun toFollowers(uid: Long): Listable<Relation?> {
        return RelationList(
            BiliRequestFactor.getBiliRequest().setPath(RelationPath.RELATION_FOLLOWERS)
                .setParams("vmid", uid), beforeRequest
        )
    }

    override fun toFollowings(uid: Long): Listable<Relation?> {
        return RelationList(
            BiliRequestFactor.getBiliRequest().setPath(RelationPath.RELATION_FOLLOWINGS)
                .setParams("vmid", uid), beforeRequest
        )
    }
}
