package com.github.masx200.biliClient.model.user

/**
 * 描述： 哔哩哔哩会员信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:07
 * @since 2021-02-07-14:07
 */
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class Vip {
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
    private val type: Int? = null

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
    private val status: Int? = null

    /**
     * 主题类型 默认 ""
     */
    private val theme_type: Int? = null

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
    private val label: Label? = null

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
    private val avatar_subscript: Int? = null

    /**
     * 活动昵称颜色代码 默认 ""
     *
     *
     * 粉色或绿色(愚人节)
     *
     */
    private val nickname_color: String? = null

    data //    @com.alibaba.fastjson2.annotation.JSONCompiled
    class Label {
        /**
         * 渠道路径
         */
        private val path: String? = null

        /**
         * 名称
         */
        private val text: String? = null

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
        private val label_theme: String? = null
    }
}
