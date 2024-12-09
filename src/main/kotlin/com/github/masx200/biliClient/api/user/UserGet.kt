package com.github.masx200.biliClient.api.user

import com.github.masx200.biliClient.BiliCall
import com.github.masx200.biliClient.BiliRequest
import com.github.masx200.biliClient.able.Gettable
import com.github.masx200.biliClient.exception.BiliRequestException
import com.github.masx200.biliClient.model.user.User
import java.util.function.Consumer
//import kotlinx.serialization.builtins.serializer
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述： 用户GET
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-14:58
 * @since 2021-02-07-14:58
 */
class UserGet // 带参数的构造函数
// 默认构造函数
@JvmOverloads constructor(
    private val request: BiliRequest,
    private val beforeRequest: Consumer<HttpRequestBase?>? = null
) : Gettable<User?> {
    override fun get(): User {
        try {
            return BiliCall.doCall(request, beforeRequest).toData<User>()
        } catch (e: Exception) {
            e.printStackTrace()
            throw BiliRequestException(request.uri, e.message)
        }
    }
}
