package com.github.masx200.biliClient.model

/**
 * 描述：直播间信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:28
 * @since 2021-02-07-14:28
 */
//package com.github.masx200.biliClient.model

import kotlinx.serialization.Serializable

/**
 * 描述：直播间信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:28
 * @since 2021-02-07-14:28
 */
@Serializable
data class LiveRoom(
    /**
     * 房间状态
     *
     *
     * 0 无房间
     *
     *
     *
     * 1 有房间
     *
     */
    val roomStatus: Int? = null,

    /**
     * 直播状态
     *
     *
     * 0 休息
     *
     *
     *
     * 1 开播
     *
     */
    val liveStatus: Int? = null,

    /**
     * 直播间地址
     */
    val url: String? = null,

    /**
     * 直播间标题
     */
    val title: String? = null,

    /**
     * 直播间封面连接
     */
    val cover: String? = null,

    /**
     * 上次直播人气
     */
    val online: Long? = null,

    /**
     * 直播间ID
     */
    val roomid: Long? = null,

    /**
     * 轮播状态
     *
     *
     * 0 无轮播
     *
     *
     *
     * 1 轮播
     *
     */
    val roundStatus: Int? = null,

    /**
     * 类型 默认0
     */
    val broadcast_type: Int? = null
)
