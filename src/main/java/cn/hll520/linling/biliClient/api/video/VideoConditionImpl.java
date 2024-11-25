package com.github.masx200.biliClient.api.video;

import com.github.masx200.biliClient.BiliRequestFactor;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.model.video.Video;

/**
 * 描述：视频条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-19:11
 * @since 2021-02-08-19:11
 */
public class VideoConditionImpl implements IVideoCondition {
    @Override
    public Gettable<Video> withAvid(long av) {
        return new VideoGet(BiliRequestFactor.getBiliRequest().setPath(VideoPath.VIDEO_INFO).setParams("aid", av));
    }

    @Override
    public Gettable<Video> withBvid(String bvid) {
        return new VideoGet(BiliRequestFactor.getBiliRequest().setPath(VideoPath.VIDEO_INFO).setParams("bvid", bvid));

    }
}
