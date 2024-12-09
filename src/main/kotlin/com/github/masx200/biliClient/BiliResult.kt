package com.github.masx200.biliClient

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
//import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement

//import  kotlinx.serialization.json.Json.decodeFromJsonElement

//import lombok.Data

//import com.alibaba.fastjson.JSONObject
//import lombok.Data

/**
 * 描述： 哔哩哔哩 通用 响应
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-03-20:39
 * @since 2021-02-03-20:39
 */
//data
//@com.alibaba.fastjson2.annotation.JSONCompiled
@Serializable
data class BiliResult(
    val code: Int? = null, val message: String? = null,

    /**
     * 实际数据
     */
    val data: JsonElement? = null

    /**
     * 消息
     */
    , val msg: String? = null

    /**
     * ttl
     */
    , val ttl: Int? = null
) {

    /**
     * 响应码
     *
     *
     * 0 成功
     *
     *
     *
     * -400 请求失败
     *
     *
     *
     * -101 未登录
     *
     */
//    public val code: Int? = null

    /**
     * 请求消息
     */

    /**
     * 获取数据 对象
     *
    //     * @param tClass 类型
     * @param <T>    对象
     * @return t
    </T> */
    inline fun <reified T> toData(): T {
//        val element = data!!
//        return  kotlinx.serialization.json.Json.decodeFromJsonElement<T>( element)
//
        val string = Json.encodeToString<JsonElement>(JsonElement.serializer(), data!!)
        return Json { ignoreUnknownKeys = true }.decodeFromString<T>(string)
    }

    /**
     * 获取包含的错误信息
     *
     * @return 信息
     */
    fun toMessage(): String? {
        if (message != null && message.isEmpty()) {
            return message
        }
        return msg
    }

    /**
     * 检验当前请求
     *
     * @return 若检测无误返回当前
     */
    fun check(): BiliResult {
        return when (this.code) {
            -400 -> {
                System.err.println(this)
                throw RuntimeException("发起请求异常！" + this.toMessage())
            }

            -799 -> {
                System.err.println(this)
                throw RuntimeException("请求过于频繁，请稍后再试" + this.toMessage())
            }

            -101 -> {
                System.err.println(this)
                throw RuntimeException("请求需要认证！" + this.toMessage())
            }

            0 -> this
            else -> {
                System.err.println(this)
                throw RuntimeException("请求错误" + this.toMessage())
            }
        }
    }
}