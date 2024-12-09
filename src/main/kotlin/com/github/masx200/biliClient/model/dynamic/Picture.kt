package com.github.masx200.biliClient.model.dynamic

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * 描述： 图片
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-20:21
 * @since 2021-02-07-20:21
 */
@Serializable
data class Picture(
    /**
     * 图片地址
     */
    val img_src: String? = null,

    /**
     * 图片大小
     */
    val img_size: Double? = null,

    /**
     * 图片宽度
     */
    val img_width: Int? = null,

    /**
     * 图片高度
     */
    val img_height: Int? = null,

    /**
     * 图片标签
     *
     *
     * 目前为 List 对象
     *
     *
     *
     * `[
     * {
     * "item_id": 0,
     * "tid": 504355,
     * "mid": 0,
     * "text": "螺蛳粉",
     * "type": 3,
     * "source_type": 0,
     * "url": "",
     * "schema_url": "",
     * "jump_url": "",
     * "orientation": 2,
     * "x": 65122,
     * "y": 83945,
     * "poi": ""
     * },
     * {
     * "item_id": 0,
     * "tid": 1433935,
     * "mid": 0,
     * "text": "武汉纺织大学",
     * "type": 3,
     * "source_type": 0,
     * "url": "",
     * "schema_url": "",
     * "jump_url": "",
     * "orientation": 2,
     * "x": 61298,
     * "y": 95691,
     * "poi": ""
     * }
     * ]`
     *
     */
    val img_tags: List<JsonElement>? = null
)
