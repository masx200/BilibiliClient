package com.github.masx200.biliClient.model.dynamic

import com.github.masx200.biliClient.model.video.Video

/**
 * 描述： 动态对象
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-20:54
 * @since 2021-02-07-20:54
 */
data class Dynamic(
    val video: Video? = null,

    /**
     * 作者ID
     */
    val uid: Long? = null

    /**
     * 作者姓名
     */
    , val name: String? = null

    /**
     * 是否转发
     */
    , val type: DType? = null

    /**
     * 源ID
     * **仅当是转发时存在**
     */
    , val origId: Long? = null

    /**
     * 数据
     */
    , val data: DynamicData? = null

    /**
     * 动态详情
     *
     *
     * 转发时为源 **若源违规被和谐将为null**
     *
     */
    , val detail: DynamicDetail? = null

    /**
     * 转发内容 否则为null
     */
    , val repost: DynamicRepost? = null

    /**
     * 当DType 为 video 时
     */
    , var essay: ESSAY? = null
) {


    fun setESSAY(essay: ESSAY?) {
        this.essay = essay
    }

    /**
     * 动态类型枚举
     */
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
