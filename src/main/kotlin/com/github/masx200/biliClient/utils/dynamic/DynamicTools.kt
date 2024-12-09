package com.github.masx200.biliClient.utils.dynamic

import com.github.masx200.biliClient.BiliClient
import com.github.masx200.biliClient.model.dynamic.Dynamic

/**
 * 描述： 动态相关工具类
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-15:05
 * @since 2021-02-08-15:05
 */
object DynamicTools {
    /**
     * 获取某一用户全部的动态信息
     *
     * @param biliClient biliClient
     * @param uid        uid
     * @return all dynamic
     */
    @Throws(Exception::class)
    fun queryAll(biliClient: BiliClient, uid: Long?): MutableList<Dynamic?> {
        val dynamics: MutableList<Dynamic?> = ArrayList<Dynamic?>()
        var items = biliClient.dynamic().withHostUid(uid).list(0L)
        do {
            dynamics.addAll(items!!.items)
            items = biliClient.dynamic().withHostUid(uid).list(items.nextOffset)
        } while (items != null && items.hasMore == 1)
        return dynamics
    }


    /**
     * 分析后的数据返回
     *
     * @param biliClient biliClient
     * @param uid        uid
     * @return all dynamic
     */
    @JvmStatic
    @Throws(Exception::class)
    fun queryData(biliClient: BiliClient, uid: Long?): DynamicSortInfo {
        return DynamicSortInfo(queryAll(biliClient, uid)).analyze() as DynamicSortInfo
    }
}
