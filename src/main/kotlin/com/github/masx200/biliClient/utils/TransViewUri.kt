package com.github.masx200.biliClient.utils

import com.github.masx200.biliClient.BiliClientFactor.getClient
import com.github.masx200.biliClient.model.dynamic.Dynamic
import com.github.masx200.biliClient.model.dynamic.Slf4j.Companion.log
import com.github.masx200.biliClient.model.user.User
import com.github.masx200.biliClient.model.video.Video
import lombok.extern.slf4j.Slf4j

/**
 * 描述：将对象转换为真实的访问地址
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-20-15:27
 * @since 2021-02-20-15:27
 */
@Slf4j
object TransViewUri {
    /**
     * 用户
     *
     * @param user 用户
     * @return 用户主页
     */
    fun transUser(user: User?): String {
        return "https://space.bilibili.com/" + user?.mid
    }

    /**
     * 动态
     *
     * @param dynamic 动态
     * @return 动态详情
     */
    fun transDynamic(dynamic: Dynamic?): String? {
        if (dynamic != null && dynamic.data != null) return "https://t.bilibili.com/" + dynamic.data!!.dynamic_id
        else return null
    }

    /**
     * 视频
     *
     * @param video 视频
     * @return 视频地址
     */
    fun transVideo(video: Video?): String? {
        if (video != null) {
            if (!video.bvid!!.isEmpty()) {
                return "https://www.bilibili.com/video/" + video.bvid
            } else if (video.aid != 0L) {
                return "https://www.bilibili.com/video/av" + video.aid
            }
        }
        return null
    }

    /**
     * Av转Bv
     *
     * @param avid av
     * @return bv
     */
    fun AvidToBvid(avid: Long): String? {
        var video: Video? = null
        try {
            val biliClient = getClient()
            video = biliClient.video().withAvid(avid).get()
            if (video != null) return video.bvid
        } catch (e: Exception) {
            TransViewUri.log.error("转换错误，原始id为 {},对于视频信息为{},错误原因为{}", avid, video, e.toString())
            e.printStackTrace()
        }
        return null
    }


    /**
     * bv转av
     *
     * @param bvid bv
     * @return av
     */
    fun BvidToAvid(bvid: String): Long {
        var video: Video? = null
        try {
            val biliClient = getClient()
            video = biliClient.video().withBvid(bvid).get()
            if (video != null) return video.aid
        } catch (e: Exception) {
            TransViewUri.log.error("转换错误，原始id为 {},对于视频信息为{},错误原因为{}", bvid, video, e.toString())
            e.printStackTrace()
        }
        return 0
    }
}
