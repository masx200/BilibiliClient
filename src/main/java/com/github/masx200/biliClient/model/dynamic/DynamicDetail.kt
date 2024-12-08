package com.github.masx200.biliClient.model.dynamic

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
 */
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class DynamicDetail {
    /**
     * 详情ID
     */
    private val id: Long? = null

    /**
     * 标题
     */
    private val title: String? = null

    /**
     * 动态详情
     */
    private val description: String? = null

    /**
     * 分类类型
     */
    private val category: String? = null

    /**
     * 角色 List
     */
    private val role: Any? = null

    /**
     * 来源 List
     */
    private val source: Any? = null

    /**
     * 图片
     */
    private val pictures: MutableList<Picture?>? = null

    /**
     * 图片数量
     */
    private val pictures_count: Int? = null

    /**
     * 更新时间
     */
    private val upload_time: Long? = null

    /**
     * 回复数量
     */
    private val reply: Long? = null

    /**
     * 设置
     *
     *
     * `{
     * "copy_forbidden": "0"
     * }`
     *
     */
    private val settings: Any? = null

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
    private val is_fav: Int? = null
}
