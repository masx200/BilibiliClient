package com.github.masx200.biliClient.model.dynamic

import com.github.masx200.biliClient.model.BaseModel
import com.github.masx200.biliClient.utils.TransDate
import java.util.Date
import kotlinx.serialization.Serializable

/**
 * Auto-generated: 2024-11-27 13:23:3
 *
 * @author json.cn (i@json.cn)
 * @website [...](http://www.json.cn/)
 */
@Serializable
data class ESSAYl(
    val ctime: Long = 0,
    val id: Long = 0,
    val title: String? = null,
    val summary: String? = null,
    val author: Author? = null,
    val image_urls: MutableList<String?>? = null,
    val publish_time: Long = 0,
    val mtime: Int = 0,
    val stats: String? = null,
    val origin_image_urls: MutableList<String?>? = null
) : BaseModel {
    override fun createTime(): Date {
        return TransDate.timestampToDate(this.ctime)
    }
}