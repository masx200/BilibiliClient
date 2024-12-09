package com.github.masx200.biliClient.api.relation

import com.github.masx200.biliClient.BiliCall.doCall
import com.github.masx200.biliClient.BiliRequest
import com.github.masx200.biliClient.able.Listable
import com.github.masx200.biliClient.model.relation.Relation
import com.github.masx200.biliClient.model.relation.Relation.Companion.build
import java.util.function.Consumer
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述： 关系
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-16:32
 * @since 2021-02-08-16:32
 */
class RelationList // 带参数的构造函数
// 默认构造函数
@JvmOverloads constructor(
    private val result: BiliRequest,
    private val beforeRequest: Consumer<HttpRequestBase?>? = null
) : Listable<Relation?> {
    override fun list(): Relation {
        return build(doCall(result, beforeRequest))
    }

    override fun list(limit: Long, offset: Long): Relation {
        return build(doCall(result.setParams("pn", offset / limit).setParams("ps", limit), beforeRequest))
    }

    override fun list(nextOffset: Long?): Relation {
        return build(doCall(result.setParams("pn", nextOffset), beforeRequest))
    }

    override fun listPage(size: Long?, page: Long?): Relation {
        return build(doCall(result.setParams("pn", page).setParams("ps", size), beforeRequest))
    }
}
