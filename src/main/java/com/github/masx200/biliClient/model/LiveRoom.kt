package com.github.masx200.biliClient.model

/**
 * 描述：直播间信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:28
 * @since 2021-02-07-14:28
 */
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class LiveRoom {
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
    private val roomStatus: Int? = null

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
    private val liveStatus: Int? = null

    /**
     * 直播间地址
     */
    private val url: String? = null

    /**
     * 直播间标题
     */
    private val title: String? = null

    /**
     * 直播间封面连接
     */
    private val cover: String? = null

    /**
     * 上次直播人气
     */
    private val online: Long? = null

    /**
     * 直播间ID
     */
    private val roomid: Long? = null

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
    private val roundStatus: Int? = null

    /**
     * 类型 默认0
     */
    private val broadcast_type: Int? = null
}
