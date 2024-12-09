package com.github.masx200.biliClient.api.video;

import com.github.masx200.biliClient.BiliCondition;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.model.video.Video;

/**
 * 描述：视频条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-19:07
 * @since 2021-02-08-19:07
 */
public interface IVideoCondition extends BiliCondition {
    /**
     * 根据av 查
     *
     * @param av av
     * @return get
     */
    Gettable<Video> withAvid(long av);

    /**
     * 根据bvid 查
     *
     * @param bvid bv
     * @return get
     */
    Gettable<Video> withBvid(String bvid);
}
