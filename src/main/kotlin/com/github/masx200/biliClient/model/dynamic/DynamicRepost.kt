package com.github.masx200.biliClient.model.dynamic

import com.github.masx200.biliClient.model.BaseModel
import com.github.masx200.biliClient.utils.TransDate
import java.util.Date
import kotlinx.serialization.Serializable

/**
 * 描述： 动态转发
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-21:13
 * @since 2021-02-07-21:13
 */
@Serializable
data class DynamicRepost(
    /**
     * 转发详情
     */
    val content: String? = null,

    /**
     * 转发时间
     */
    val timestamp: Long? = null
) : BaseModel {
    override fun createTime(): Date {
        return TransDate.timestampToDate(this.timestamp)
    }
}