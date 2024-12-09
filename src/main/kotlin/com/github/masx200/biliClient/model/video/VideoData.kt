package com.github.masx200.biliClient.model.video

import kotlinx.serialization.Serializable

/**
 * 描述： 视频数据
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-08-18:50
 * @since 2021-02-08-18:50
 */@Serializable
data class VideoData(
    /**
     * av
     */
    val aid: Long = 0,

    /**
     * 弹幕数量
     */
    val danmaku: Long = 0,
    /**
     * 观看数
     */
    val view: Long = 0,
    /**
     * 评论数
     */
    val reply: Long = 0,

    /**
     * 投币
     */
    val coin: Long = 0,
    /**
     * 点赞
     */
    val like: Long = 0,
    /**
     * 收藏
     */
    val favorite: Long = 0,
    /**
     * 分享
     */
    val share: Long = 0,
    /**
     * 当前排名
     */
    val now_rank: Long = 0,
    /**
     * 全站最高
     */
    val his_rank: Long = 0,
    /**
     * 踩
     */
    val dislike: Long = 0,
    /**
     * 评分
     */
    val evaluation: String? = null
)
