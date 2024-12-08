package com.github.masx200.biliClient.model.user

/**
 * 描述： 头像框信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:17
 * @since 2021-02-07-14:17
 */
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class Pendant {
    /**
     * 头像框ID
     */
    private val pid: Long? = null

    /**
     * 头像框名称
     */
    private val name: String? = null

    /**
     * 头像框URL
     */
    private val image: String? = null

    /**
     * 到期时间
     */
    private val expire: Long? = null

    /**
     * 图形画质提升
     */
    private val image_enhance: String? = null

    /**
     * 图形画质提升框架
     */
    private val image_enhance_frame: String? = null
}
