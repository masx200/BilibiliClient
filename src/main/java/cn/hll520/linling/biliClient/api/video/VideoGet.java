package com.github.masx200.biliClient.api.video;

import com.github.masx200.biliClient.BiliCall;
import com.github.masx200.biliClient.BiliRequest;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.model.video.Video;

/**
 * 描述：video get
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-19:07
 * @since 2021-02-08-19:07
 */
public class VideoGet implements Gettable<Video> {

    private final BiliRequest request;

    public VideoGet(BiliRequest request) {
        this.request = request;
    }

    @Override
    public Video get() {
        return BiliCall.doCall(request).toData(Video.class);
    }
}
