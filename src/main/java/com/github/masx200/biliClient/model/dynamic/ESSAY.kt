package com.github.masx200.biliClient.model.dynamic

import com.github.masx200.biliClient.model.BaseModel
import com.github.masx200.biliClient.utils.TransDate
import java.util.Date
import lombok.Getter
import lombok.Setter

/**
 * Auto-generated: 2024-11-27 13:23:3
 *
 * @author json.cn (i@json.cn)
 * @website [...](http://www.json.cn/)
 */
@Setter
@Getter
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class ESSAY : BaseModel {
    private val ctime: Long = 0
    private val id: Long = 0
    private val title: String? = null
    private val summary: String? = null
    private val author: Author? = null
    private val image_urls: MutableList<String?>? = null
    private val publish_time: Long = 0

    // private long ctime;
    private val mtime = 0
    private val stats: String? = null
    private val origin_image_urls: MutableList<String?>? = null

    override fun createTime(): Date {
        return TransDate.timestampToDate(this.ctime)
    }
}
