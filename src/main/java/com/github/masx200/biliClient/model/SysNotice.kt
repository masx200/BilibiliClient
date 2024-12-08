package com.github.masx200.biliClient.model

/**
 * 描述： 系统通知信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:23
 * @since 2021-02-07-14:23
 */
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class SysNotice {
    /**
     * 通知id
     */
    private val id: Int? = null

    /**
     * 提示信息
     */
    private val content: String? = null

    /**
     * 详细说明连接
     */
    private val url: String? = null

    /**
     * 通知类型
     *
     *
     * 2 纪念账号
     *
     */
    private val notice_type: Int? = null

    /**
     * 通知图标连接
     */
    private val icon: String? = null

    /**
     * 文本颜色 #16进制
     */
    private val text_color: String? = null

    /**
     * 背景颜色 #16进制
     */
    private val bg_color: String? = null
}
