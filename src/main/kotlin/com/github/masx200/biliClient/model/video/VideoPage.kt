package com.github.masx200.biliClient.model.video

import kotlinx.serialization.Serializable

/**
 * 描述： 稿件单P
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-08-19:01
 * @since 2021-02-08-19:01
 */@Serializable
data class VideoPage(
    /**
     * cid
     */
    val cid: Long = 0,

    /**
     * 当前P 数
     */
    val page: Long = 0,

    /**
     * 来源
     *
     *
     * vupload 上传
     *
     *
     *
     * huan 芒果TV
     *
     *
     *
     * qq 腾讯视频
     *
     */
    val from: String? = null,

    /**
     * 当前P 名称
     */
    val part: String? = null,

    /**
     * 当前P 时长 秒
     */
    val duration: String? = null,

    /**
     * vid
     */
    val vid: String? = null,

    /**
     * 网络连接
     */
    val weblink: String? = null,

    /**
     * 分辨率
     */
    val dimension: Dimension? = null
)