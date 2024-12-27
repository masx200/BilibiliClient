package com.github.masx200.biliClient.api.dynamic

import com.github.masx200.biliClient.BiliCall.doCall
import com.github.masx200.biliClient.BiliRequest
import com.github.masx200.biliClient.able.Listable
import com.github.masx200.biliClient.exception.BiliRequestException
import com.github.masx200.biliClient.model.dynamic.DynamicItems
import com.github.masx200.biliClient.model.dynamic.DynamicItems.Companion.build
import java.util.function.Consumer
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述： 动态 list
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-22:30
 * @since 2021-02-07-22:30
 */
class DynamicList // 带参数的构造函数
// 默认构造函数
@JvmOverloads constructor(
    private val request: BiliRequest,
    private val beforeRequest: Consumer<HttpRequestBase?>? = null
) : Listable<DynamicItems?> {
    @Throws(Exception::class)
    override fun list(): DynamicItems {
        val biliResult = doCall(request, beforeRequest)
        return build(biliResult)
    }

    /**
     * 目前不支持当前方式调用
     *
     * @param limit  size
     * @param offset 偏移量
     * @return exception
     * @see .list
     */
    @Deprecated("")
    override fun list(limit: Long?, offset: Long?): DynamicItems? {
//        BiliResult biliResult = BiliCall.doCall(request
//                .setParams("offset_dynamic_id", offset)
//                .setParams("limit", limit));
//        return DynamicItems.build(biliResult);
        throw BiliRequestException(request.uri, "目前不支持此种方式调用")
    }

    @Throws(Exception::class)
    override fun list(next_offset: Long?): DynamicItems {
        val biliResult = doCall(request.setParams("offset_dynamic_id", next_offset), beforeRequest)
        return build(biliResult)
    }
}
