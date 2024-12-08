package com.github.masx200.biliClient.model.dynamic

import com.github.masx200.biliClient.model.BaseModel
import com.github.masx200.biliClient.utils.TransDate
import java.util.Date

/**
 * 描述： 动态转发
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-21:13
 * @since 2021-02-07-21:13
 */
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class DynamicRepost : BaseModel {
    /**
     * 转发详情
     */
    private val content: String? = null

    /**
     * 转发时间
     */
    private val timestamp: Long? = null

    override fun createTime(): Date {
        return TransDate.timestampToDate(this.timestamp)
    }
}
