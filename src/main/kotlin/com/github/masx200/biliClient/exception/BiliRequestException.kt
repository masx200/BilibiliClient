package com.github.masx200.biliClient.exception

import java.net.URI

/**
 * 描述：请求异常
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-03-21:44
 * @since 2021-02-03-21:44
 */
class BiliRequestException(message: String?) : RuntimeException(message) {


    constructor(message: String? = null, block: (BiliRequestException.() -> Unit)? = null) : this(message) {
        block?.let { it(this) }
    }

    constructor() : this(null) {}

    var method: String? = null

    var statusCode: Int? = 0

    /**
     * 请求URI
     */
    var uri: URI? = null

    /**
     * 请求路径
     */
    var path: String? = null

    @JvmOverloads
    constructor(uri: URI, message: String? = "未知错误") : this(message) {
        this.uri = uri
    }

    constructor(path: String?, message: String?) : this(message) {
        this.path = path
    }

    fun getUri(): URI {
        return uri!!
    }

    fun setUri(uri: URI) {
        this.uri = uri
    }

    override fun toString(): String {
        return "BiliRequestException{" +
                "uri=" + uri +
                ", path='" + path + '\'' +
                "} " + super.toString()
    }

    override fun printStackTrace() {
        super.printStackTrace()
        if (path != null) {
            System.err.println("请求错误路径为---> " + path)
        } else {
            System.err.println(
                ("请求错误路径为---> " + uri!!.getScheme() + "://" + uri!!.getHost() + ":"
                        + uri!!.getPort() + uri!!.getPath())
            )
        }
    }
}
