package com.github.masx200.biliClient.model

import kotlinx.serialization.Serializable

/**
 * 描述： 系统通知信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:23
 * @since 2021-02-07-14:23
 */
@Serializable
data class SysNotice(
    /**
     * 通知id
     */
    val id: Int? = null,

    /**
     * 提示信息
     */
    val content: String? = null,

    /**
     * 详细说明连接
     */
    val url: String? = null,

    /**
     * 通知类型
     *
     *
     * 2 纪念账号
     *
     */
    val notice_type: Int? = null,

    /**
     * 通知图标连接
     */
    val icon: String? = null,

    /**
     * 文本颜色 #16进制
     */
    val text_color: String? = null,

    /**
     * 背景颜色 #16进制
     */
    val bg_color: String? = null
)