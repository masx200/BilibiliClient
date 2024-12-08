package com.github.masx200.biliClient.model.user

import kotlinx.serialization.Serializable

/**
 * 描述： 哔哩哔哩会员信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:07
 * @since 2021-02-07-14:07
 */
@Serializable
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class Vip(
    val type: Int? = null,

    /**
     * 是否有会员
     *
     *
     * 0 无
     *
     *
     *
     * 1 有
     *
     */
    val status: Int? = null,

    /**
     * 主题类型 默认 ""
     */
    val theme_type: Int? = null,
    /**
     * 标签
     *
     *
     * `"label": {
     * "path": "",
     * "text": "",
     * "label_theme": ""
     * }
    ` *
     *
     */
    val label: Label? = null,

    /**
     * 是否外显会员
     *
     *
     * 0 不显示
     *
     *
     *
     * 1 显示
     *
     */
    val avatar_subscript: Int? = null,

    /**
     * 活动昵称颜色代码 默认 ""
     *
     *
     * 粉色或绿色(愚人节)
     *
     */
    val nickname_color: String? = null
) {
    /**
     * 会员类型
     *
     *
     * 0 无会员
     *
     *
     *
     * 1 包月会员
     *
     *
     *
     * 2 年费会员
     *
     */
    @Serializable
    data //    @com.alibaba.fastjson2.annotation.JSONCompiled
    class Label(
        val path: String? = null,
        /**
         * 名称
         */
        val text: String? = null

        /**
         * 标签
         *
         *
         * vip：大会员
         *
         *
         *
         * annual_vip：年度大会员
         *
         *
         *
         * ten_annual_vip：十年大会员
         *
         *
         *
         * hundred_annual_vip：百年大会员
         *
         */
        , val label_theme: String? = null
    ) {
        /**
         * 渠道路径
         */

    }
}
