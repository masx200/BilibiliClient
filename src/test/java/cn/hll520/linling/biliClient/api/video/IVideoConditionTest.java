package com.github.masx200.biliClient.api.video;

import com.github.masx200.biliClient.BiliClient;
import com.github.masx200.biliClient.BiliClientFactor;
import com.github.masx200.biliClient.model.video.Video;
import org.junit.Test;

/**
 * 描述：
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-19:13
 * @since 2021-02-08-19:13
 */
public class IVideoConditionTest {
    private final BiliClient biliClient = BiliClientFactor.getClient();

    @Test
    public void withAvid() {
        Video video = biliClient.video().withAvid(12306L).get();
        System.out.println(video);
        System.out.println(video.createTime());
    }

    @Test
    public void withBvid() {
        Video video = biliClient.video().withBvid("BV1Zx411A7Q9").get();
        System.out.println(video);
        System.out.println(video.createTime());
        System.out.println(video.updateTime());

    }
}