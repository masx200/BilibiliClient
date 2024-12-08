package com.github.masx200.biliClient.utils.dynamic

import com.github.masx200.biliClient.model.dynamic.Dynamic
import com.github.masx200.biliClient.model.dynamic.Dynamic.DType
import java.util.function.Consumer

/**
 * 描述： 动态分类信息类
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-08-15:20
 * @since 2021-02-08-15:20
 */
//@EqualsAndHashCode(callSuper = true)
//data
//@com.alibaba.fastjson2.annotation.JSONCompiled
data class DynamicSortInfo(
    val dynamics: MutableList<Dynamic?>? = ArrayList<Dynamic?>(), var viewAll: Long = 0,

    /**
     * 点赞总数
     */
    var likeAll: Long = 0,

    /**
     * 转发总数
     */
    var repostAll: Long = 0,

    /**
     * 评论总数
     */
    var commentAll: Long = 0,

    /**
     * 硬币总数
     */
    var coinAll: Long = 0,

    /**
     * 动态总数
     */
    var count: Long = 0, val sortInfo: MutableMap<DType?, DynamicInfoClass?> = HashMap<DType?, DynamicInfoClass?>()
) : DynamicInfo {


    override fun analyze(): DynamicInfo {
        if (dynamics != null && !dynamics.isEmpty()) {
            // 分类
            dynamics.forEach(Consumer { dynamic: Dynamic? ->
                toInfo(dynamic!!.type).dynamics?.add(dynamic)
            })
            // 分析
            sortInfo.forEach { (_: DType?, dynamicInfo: DynamicInfoClass?) ->
                dynamicInfo!!.analyze()
                viewAll = viewAll + dynamicInfo.viewAll
                likeAll = (likeAll + dynamicInfo.likeAll)
                commentAll = (commentAll + dynamicInfo.commentAll)
                repostAll = (repostAll + dynamicInfo.repostAll)
                coinAll = (coinAll + dynamicInfo.coinAll)
            }
            count = (dynamics.size.toLong())
        }
        return this
    }

    /**
     * 从 map 中获取种类的 值
     *
     * @param type 类别
     * @return 总类
     */
    fun toInfo(type: DType?): DynamicInfoClass {
        var dynamicInfo = sortInfo[type]
        if (dynamicInfo == null) {
            dynamicInfo = DynamicInfoClass()
            sortInfo.put(type, dynamicInfo)
        }
        return dynamicInfo
    }
}
