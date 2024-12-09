package com.github.masx200.biliClient.api.video

import com.github.masx200.biliClient.BiliCondition
import com.github.masx200.biliClient.able.Gettable
import com.github.masx200.biliClient.model.video.Video

/**
 * 描述：视频条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-19:07
 * @since 2021-02-08-19:07
 */
interface IVideoCondition : BiliCondition {
    /**
     * 根据av 查
     *
     * @param av av
     * @return get
     */
    fun withAvid(av: Long): Gettable<Video>

    /**
     * 根据bvid 查
     *
     * @param bvid bv
     * @return get
     */
    fun withBvid(bvid: String?): Gettable<Video>
}
