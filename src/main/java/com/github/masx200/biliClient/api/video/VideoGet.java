package com.github.masx200.biliClient.api.video;

import com.github.masx200.biliClient.BiliCall;
import com.github.masx200.biliClient.BiliRequest;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.model.video.Video;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.function.Consumer;

/**
 * 描述：video get
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-19:07
 * @since 2021-02-08-19:07
 */
public class VideoGet implements Gettable<Video> {

    private final BiliRequest request;
    private final Consumer<HttpRequestBase> beforeRequest;

    // 默认构造函数
    public VideoGet(BiliRequest request) {
        this(request, null);
    }

    // 带参数的构造函数
    public VideoGet(BiliRequest request, Consumer<HttpRequestBase> beforeRequest) {
        this.request = request;
        this.beforeRequest = beforeRequest;
    }

    @Override
    public Video get() {
        return BiliCall.doCall(request,beforeRequest).toData(Video.class);
    }
}
