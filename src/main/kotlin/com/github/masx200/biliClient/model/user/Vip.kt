package com.github.masx200.biliClient.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

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
    var vip_pay_type: Long? = null,
    val type: Int? = null,
    var due_date: Long? = null,
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
    val role: Int? = null,
    /**
     * 活动昵称颜色代码 默认 ""
     *
     *
     * 粉色或绿色(愚人节)
     *
     */
    val nickname_color: String? = null,
    val avatar_subscript_url: String? = null,

    val tv_vip_status: Int? = null,
    val tv_vip_pay_type: Int? = null,
    val tv_due_date: Int? = null,
    var avatar_icon: JsonElement? = null,
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

//        val path: String? = null,
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
        , val label_theme: String? = null,
        val path: String? = null,
//        val text: String,
        val labelTheme: String? = null,
        val text_color: String? = null,
        @SerialName("bg_style")
        val bgStyle: Long? = null,
        @SerialName("bg_color")
        val bgColor: String? = null,
        @SerialName("border_color")
        val borderColor: String? = null,
        @SerialName("use_img_label")
        val useImgLabel: Boolean? = null,
        @SerialName("img_label_uri_hans")
        val imgLabelURIHans: String? = null,
        @SerialName("img_label_uri_hant")
        val imgLabelURIHant: String? = null,
        @SerialName("img_label_uri_hans_static")
        val imgLabelURIHansStatic: String? = null,
        @SerialName("img_label_uri_hant_static")
        val imgLabelURIHantStatic: String? = null
    ) {
        /**
         * 渠道路径
         */

    }
}
