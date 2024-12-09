package com.github.masx200.biliClient.api.video

import com.github.masx200.biliClient.BiliCall.doCall
import com.github.masx200.biliClient.BiliRequest
import com.github.masx200.biliClient.able.Gettable
import com.github.masx200.biliClient.model.video.Video
import java.util.function.Consumer
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述：video get
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-19:07
 * @since 2021-02-08-19:07
 */
class VideoGet // 带参数的构造函数
// 默认构造函数
@JvmOverloads constructor(
    private val request: BiliRequest,
    private val beforeRequest: Consumer<HttpRequestBase?>? = null
) : Gettable<Video> {
    override fun get(): Video {
        return doCall(request, beforeRequest).toData<Video>()
    }
}
