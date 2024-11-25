package com.github.masx200.biliClient.api.video;

import com.github.masx200.biliClient.BiliRequestFactor;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.model.video.Video;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.function.Consumer;

/**
 * 描述：视频条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-19:11
 * @since 2021-02-08-19:11
 */
public class VideoConditionImpl implements IVideoCondition {
    private final Consumer<HttpRequestBase> beforeRequest;

    // 默认构造函数
    public VideoConditionImpl() {
        this.beforeRequest = null;
    }

    // 带参数的构造函数
    public VideoConditionImpl(Consumer<HttpRequestBase> beforeRequest) {
        this.beforeRequest = beforeRequest;
    }
    @Override
    public Gettable<Video> withAvid(long av) {
        return new VideoGet(BiliRequestFactor.getBiliRequest().setPath(VideoPath.VIDEO_INFO).setParams("aid", av),beforeRequest);
    }

    @Override
    public Gettable<Video> withBvid(String bvid) {
        return new VideoGet(BiliRequestFactor.getBiliRequest().setPath(VideoPath.VIDEO_INFO).setParams("bvid", bvid),beforeRequest);

    }
}
