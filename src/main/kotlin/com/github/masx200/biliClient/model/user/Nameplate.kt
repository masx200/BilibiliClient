package com.github.masx200.biliClient.model.user

import kotlinx.serialization.Serializable

/**
 * 描述： 勋章信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:20
 * @since 2021-02-07-14:20
 */
@Serializable
data class Nameplate(
    /**
     * 胸罩id
     */
    val nid: Long? = null,

    /**
     * 胸罩名称
     */
    val name: String? = null,

    /**
     * 胸罩url 标准画质
     */
    val image: String? = null,

    /**
     * 胸章url 略缩图
     */
    val image_small: String? = null,

    /**
     * 勋章等级
     */
    val level: String? = null,

    /**
     * 获取条件
     */
    val condition: String? = null
)
