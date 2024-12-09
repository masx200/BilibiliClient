package com.github.masx200.biliClient.api.user

import com.github.masx200.biliClient.BiliRequestFactor
import com.github.masx200.biliClient.able.Gettable
import com.github.masx200.biliClient.model.user.User
import java.util.function.Consumer
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述： 用户条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-15:37
 * @since 2021-02-07-15:37
 */
class UserConditionImpl : IUserCondition {
    private val beforeRequest: Consumer<HttpRequestBase?>?

    // 默认构造函数
    constructor() {
        this.beforeRequest = null
    }

    // 带参数的构造函数
    constructor(beforeRequest: Consumer<HttpRequestBase?>?) {
        this.beforeRequest = beforeRequest
    }

    override fun withUID(uid: Long?): Gettable<User?>? {
        return UserGet(
            BiliRequestFactor.getBiliRequest().setPath(UserPath.USER_INFO)
                .setParams("mid", uid.toString()), beforeRequest
        )
    }

    override fun withMe(): Gettable<User?>? {
        return UserGet(BiliRequestFactor.getBiliRequest().setPath(UserPath.USER_MY_INFO), beforeRequest)
    }
}
