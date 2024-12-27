package com.github.masx200.biliClient.model.dynamic

import com.github.masx200.biliClient.model.BaseModel
import com.github.masx200.biliClient.utils.TransDate
import java.util.Date
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * 描述： 动态 数据
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-21:06
 * @since 2021-02-07-21:06
 */@Serializable
data class DynamicData(
    val origin: DynamicData? = null,
    val orig_dy_id_str: String? = null,
    val rid_str: String? = null,
    /**
     * 动态类型
     */
    val type: Int? = null,

    /**
     * 作者ID
     */
    val uid: Long? = null,
    val rid: Long? = null,
    /**
     * 动态 id
     */
    val dynamic_id: Long? = null,

    /**
     * 源ID
     *
     *
     * 非转发为0 或 Null
     *
     */
    val orig_dy_id: Long? = null,
    val pre_dy_id: Long? = null,
    val orig_type: Long? = null,
    val uid_type: Long? = null,
    val stype: Long? = null,
    val dynamic_id_str: String? = null,
    val pre_dy_id_str: String? = null,
    val inner_id: Long? = null,
    val status: Long? = null,
    val r_type: Long? = null,
    val spec_type: Long? = null,
    val user_profile: JsonElement? = null,
    /**
     * 时间
     */
    val timestamp: Long? = null,

    /**
     * 阅读
     */
    val view: Long = 0,

    /**
     * 转发
     */
    val repost: Long = 0,

    /**
     * 评论
     */
    val comment: Long = 0,

    /**
     * 点赞
     */
    val like: Long = 0,
    val acl: Long = 0,

    /**
     * 是否点赞
     *
     *
     * 0 否/未登录
     *
     *
     *
     * 1 是
     *
     */
    val is_liked: Int? = null,

    /**
     * 视频 bvid
     *
     *
     * 仅仅视频动态存在 其余为null or empty
     *
     */
    val bvid: String? = null,
    val previous: JsonElement?=null,
) : BaseModel {

    override fun createTime(): Date {
        return TransDate.timestampToDate(this.timestamp)
    }
}