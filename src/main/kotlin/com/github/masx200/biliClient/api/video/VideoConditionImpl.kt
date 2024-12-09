package com.github.masx200.biliClient.api.video

import com.github.masx200.biliClient.BiliRequestFactor
import com.github.masx200.biliClient.able.Gettable
import com.github.masx200.biliClient.model.video.Video
import java.util.function.Consumer
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述：视频条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-19:11
 * @since 2021-02-08-19:11
 */
class VideoConditionImpl : IVideoCondition {
    private val beforeRequest: Consumer<HttpRequestBase?>?

    // 默认构造函数
    constructor() {
        this.beforeRequest = null
    }

    // 带参数的构造函数
    constructor(beforeRequest: Consumer<HttpRequestBase?>?) {
        this.beforeRequest = beforeRequest
    }

    override fun withAvid(av: Long): Gettable<Video> {
        return VideoGet(
            BiliRequestFactor.getBiliRequest().setPath(VideoPath.VIDEO_INFO).setParams("aid", av),
            beforeRequest
        )
    }

    override fun withBvid(bvid: String?): Gettable<Video> {
        return VideoGet(
            BiliRequestFactor.getBiliRequest().setPath(VideoPath.VIDEO_INFO).setParams("bvid", bvid),
            beforeRequest
        )
    }
}
