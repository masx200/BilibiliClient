package com.github.masx200.biliClient.model.dynamic

import kotlinx.serialization.Serializable

/**
 * 描述：动态详情
 *
 *
 * data.card.desc.card.item
 *
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-20:17
 * @since 2021-02-07-20:17
 */@Serializable
data class DynamicDetail(
    /**
     * 详情ID
     */
    val id: Long? = null,

    /**
     * 标题
     */
    val title: String? = null,

    /**
     * 动态详情
     */
    val description: String? = null,

    /**
     * 分类类型
     */
    val category: String? = null,

    /**
     * 角色 List
     */
    val role: Any? = null,

    /**
     * 来源 List
     */
    val source: Any? = null,

    /**
     * 图片
     */
    val pictures: MutableList<Picture?>? = null,

    /**
     * 图片数量
     */
    val pictures_count: Int? = null,

    /**
     * 更新时间
     */
    val upload_time: Long? = null,

    /**
     * 回复数量
     */
    val reply: Long? = null,

    /**
     * 设置
     *
     *
     * `{
     * "copy_forbidden": "0"
     * }`
     *
     */
    val settings: Any? = null,

    /**
     * 是否喜欢
     *
     *
     * 0 否
     *
     *
     *
     * 1 是
     *
     */
    val is_fav: Int? = null
)