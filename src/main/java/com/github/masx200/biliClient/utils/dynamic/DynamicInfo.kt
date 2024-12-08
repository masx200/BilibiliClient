package com.github.masx200.biliClient.utils.dynamic

import com.github.masx200.biliClient.model.dynamic.Dynamic

/**
 * 描述： 动态信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-08-15:14
 * @since 2021-02-08-15:14
 */
//@Data
//@com.alibaba.fastjson2.annotation.JSONCompiled
data class DynamicInfo
/**
 * 无参构造
 */
    (
    var dynamics: MutableList<Dynamic?>? = ArrayList<Dynamic?>(),

    /**
     * 阅读总数
     */
    var viewAll: Long = 0,

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
    var count: Long = 0
) {
    /**
     * 动态集合
     */

    /**
     * 单参数构造
     *
     * @param dynamics list
     */
//    constructor(dynamics: MutableList<Dynamic?>?) : this() {
//        this.dynamics = dynamics
//    }

    /**
     * 分析数据
     *
     * @return this
     */
    fun analyze(): DynamicInfo {
        if (dynamics != null && !dynamics!!.isEmpty()) {

            for (dynamic in dynamics!!) {
                viewAll += dynamic!!.getData().getView()
                likeAll += dynamic.getData().getLike()
                repostAll += dynamic.getData().getRepost()
                commentAll += dynamic.getData().getComment()
                if (dynamic.getType() == Dynamic.DType.VIDEO) {
                    coinAll += dynamic.getVideo().getStat().getCoin()
                }
            }

            count = dynamics!!.size.toLong()
        }
        return this
    }
}
