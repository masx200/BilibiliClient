package com.github.masx200.biliClient.api.video

import com.github.masx200.biliClient.BiliClient
import com.github.masx200.biliClient.BiliClientFactor
import org.junit.Test

/**
 * 描述：
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-19:13
 * @since 2021-02-08-19:13
 */
class IVideoConditionTest {
    private val biliClient: BiliClient = BiliClientFactor.getClient()

    @Test
    fun withAvid() {
        val video = biliClient.video().withAvid(12306L).get()
        println(video)
        println(video.createTime())
    }

    @Test
    fun withBvid() {
        val video = biliClient.video().withBvid("BV1Zx411A7Q9").get()
        println(video)
        println(video.createTime())
        println(video.updateTime())
    }
}