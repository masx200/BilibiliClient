package com.github.masx200.biliClient.model.video

import kotlinx.serialization.Serializable

/**
 * 描述： 分辨率
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-08-18:59
 * @since 2021-02-08-18:59
 */
@Serializable
data class Dimension(
    /**
     * 宽
     */
    val width: Int,

    /**
     * 高
     */
    val height: Int,

    /**
     * 选择 ？
     */
    val rotate: Int
)