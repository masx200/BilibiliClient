package com.github.masx200.biliClient.api.dynamic

import com.github.masx200.biliClient.BiliRequestFactor
import com.github.masx200.biliClient.able.Gettable
import com.github.masx200.biliClient.able.Listable
import com.github.masx200.biliClient.model.dynamic.Dynamic
import com.github.masx200.biliClient.model.dynamic.DynamicItems
import java.util.function.Consumer
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述：动态条件实现类
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-21:24
 * @since 2021-02-07-21:24
 */
class DynamicConditionImpl : IDynamicCondition {
    private val beforeRequest: Consumer<HttpRequestBase?>?

    // 默认构造函数
    constructor() {
        this.beforeRequest = null
    }

    // 带参数的构造函数
    constructor(beforeRequest: Consumer<HttpRequestBase?>?) {
        this.beforeRequest = beforeRequest
    }

    override fun withDynamicId(dynamicId: Long?): Gettable<Dynamic?>? {
        return DynamicGet(
            BiliRequestFactor.getBiliRequest().useHostVC().setPath(DynamicPath.DYNAMIC_DETAIL)
                .setParams("dynamic_id", dynamicId), beforeRequest
        )
    }

    override fun withHostUid(uid: Long?): Listable<DynamicItems?>? {
        return DynamicList(
            BiliRequestFactor.getBiliRequest().useHostVC().setPath(DynamicPath.DYNAMIC_USER_LIST)
                .setParams("host_uid", uid), beforeRequest
        )
    }
}
