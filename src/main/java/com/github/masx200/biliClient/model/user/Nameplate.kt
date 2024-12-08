package com.github.masx200.biliClient.model.user

/**
 * 描述： 勋章信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:20
 * @since 2021-02-07-14:20
 */
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class Nameplate {
    /**
     * 胸罩id
     */
    private val nid: Long? = null

    /**
     * 胸罩名称
     */
    private val name: String? = null

    /**
     * 胸罩url 标准画质
     */
    private val image: String? = null

    /**
     * 胸章url 略缩图
     */
    private val image_small: String? = null

    /**
     * 勋章等级
     */
    private val level: String? = null

    /**
     * 获取条件
     */
    private val condition: String? = null
}
