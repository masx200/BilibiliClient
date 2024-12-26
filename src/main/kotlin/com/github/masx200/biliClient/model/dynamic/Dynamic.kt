package com.github.masx200.biliClient.model.dynamic

import com.github.masx200.biliClient.model.video.Video
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * 描述： 动态对象
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-20:54
 * @since 2021-02-07-20:54
 */@Serializable
data class Dynamic(
    var origin: JsonElement? = null,
    var desc: DynamicData? = null,
    var card: JsonElement? = null,
    var extend_json: JsonElement? = null,
    var display: JsonElement? = null,
    var video: Video? = null,

    /**
     * 作者ID
     */
    var uid: Long? = null

    /**
     * 作者姓名
     */
    , var name: String? = null

    /**
     * 是否转发
     */
    , var type: DType? = null

    /**
     * 源ID
     * **仅当是转发时存在**
     */
    , val origId: Long? = null

    /**
     * 数据
     */
    , var data: DynamicData? = null

    /**
     * 动态详情
     *
     *
     * 转发时为源 **若源违规被和谐将为null**
     *
     */
    , var detail: DynamicDetail? = null

    /**
     * 转发内容 否则为null
     */
    , var repost: DynamicRepost? = null

    /**
     * 当DType 为 video 时
     */
    , var essay: ESSAY? = null
) {


    fun setESSAY(essay: ESSAY?) {
        this.essay = essay
    }

    fun SETDATA(data: DynamicData) {
        this.data= data
    }

    fun SETTYPE(type: DType) {
        this.type = type
    }

    fun setrepost(value: DynamicRepost) {
        this.repost = value
    }

    fun SETDETAIL(value: DynamicDetail) {
        this.detail = value
    }

    fun SETVIDEO(value: Video) {
        this.video = value
    }

    fun SETUID(value: Long?) {
        this.uid = value
    }

    fun SETNAME(value: String?) {
        this.name= value.toString()
    }

    /**
     * 动态类型枚举
     */
    @Serializable
    enum class DType {
        /**
         * 普通动态
         */
        COMMON,

        /**
         * 转发动态
         */
        REPOST,

        /**
         * 视频动态
         */
        VIDEO,

        /**
         * 音频动态
         */
        AUDIO,

        /**
         * 专栏文章
         */
        ESSAY,

        /**
         * 直播动态
         */
        LIVE
    }
}
