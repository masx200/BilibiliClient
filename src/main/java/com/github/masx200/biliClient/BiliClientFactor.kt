package com.github.masx200.biliClient

import com.github.masx200.biliClient.api.dynamic.DynamicConditionImpl
import com.github.masx200.biliClient.api.dynamic.IDynamicCondition
import com.github.masx200.biliClient.api.relation.IRelationCondition
import com.github.masx200.biliClient.api.relation.RelationConditionImpl
import com.github.masx200.biliClient.api.user.IUserCondition
import com.github.masx200.biliClient.api.user.UserConditionImpl
import com.github.masx200.biliClient.api.video.IVideoCondition
import com.github.masx200.biliClient.api.video.VideoConditionImpl
import java.util.function.Consumer
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述： 客户端工厂方法
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-16:00
 * @since 2021-02-07-16:00
 */
object BiliClientFactor {
    @JvmStatic
//    val client: BiliClient
//        get() = BiliClientDefault()
    fun getClient(): BiliClient {
        return BiliClientDefault()
    }
    fun getClient(beforeRequest: Consumer<HttpRequestBase?>?): BiliClient {
        return BiliClientDefault(beforeRequest)
    }

    private class BiliClientDefault : BiliClient {
        // 默认构造函数
        constructor() {
            this.beforeRequest = null
        }

        // 带参数的构造函数
        constructor(beforeRequest: Consumer<HttpRequestBase?>?) {
            this.beforeRequest = beforeRequest
        }

        private val beforeRequest: Consumer<HttpRequestBase?>?
        override fun user(): IUserCondition {
            return UserConditionImpl(beforeRequest)
        }

        override fun dynamic(): IDynamicCondition {
            return DynamicConditionImpl(beforeRequest)
        }

        override fun relation(): IRelationCondition {
            return RelationConditionImpl(beforeRequest)
        }

        override fun video(): IVideoCondition {
            return VideoConditionImpl(beforeRequest)
        }
    }
}
