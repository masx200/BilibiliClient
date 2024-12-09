package com.github.masx200.biliClient.api.dynamic

import com.github.masx200.biliClient.BiliCall
import com.github.masx200.biliClient.BiliRequest
import com.github.masx200.biliClient.able.Gettable
import com.github.masx200.biliClient.model.dynamic.Dynamic
import com.github.masx200.biliClient.model.dynamic.DynamicCard
import java.util.function.Consumer
import kotlinx.serialization.Serializable
import org.apache.http.client.methods.HttpRequestBase

//import com.alibaba.fastjson.JSONObject;
/**
 * 描述： 动态获取
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-21:25
 * @since 2021-02-07-21:25
 */
class DynamicGet // 带参数的构造函数
// 默认构造函数
@JvmOverloads constructor(
    private val request: BiliRequest,
    private val beforeRequest: Consumer<HttpRequestBase?>? = null
) : Gettable<Dynamic?> {
    override fun get(): Dynamic? {
        val result = BiliCall.doCall(request, beforeRequest)
//        val data = result.data
        return result.toData<GetDynamicDetailRoot>().card
            .toDynamic()
    }
}

@Serializable
data class GetDynamicDetailRoot(
    val card: DynamicCard,
)
