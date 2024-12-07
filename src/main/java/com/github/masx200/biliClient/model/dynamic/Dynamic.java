package com.github.masx200.biliClient.model.dynamic;

import com.github.masx200.biliClient.model.video.Video;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 描述： 动态对象
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-20:54
 * @since 2021-02-07-20:54
 */
@Data
@com.alibaba.fastjson2.annotation.JSONCompiled
@Setter
@Getter
public class Dynamic {
    private Video video;
    /**
     * 作者ID
     */
    private Long uid;
    /**
     * 作者姓名
     */
    private String name;
    /**
     * 是否转发
     */
    private DType type;

    /**
     * 源ID
     * <b>仅当是转发时存在</b>
     */
    private Long origId;

    /**
     * 数据
     */
    private DynamicData data;

    /**
     * 动态详情
     * <p>
     * 转发时为源 <b>若源违规被和谐将为null</b>
     * </p>
     */
    private DynamicDetail detail;

    /**
     * 转发内容 否则为null
     */
    private DynamicRepost repost;

    /**
     * 当DType 为 video 时
     */
    private ESSAY essay;

    public void setESSAY(ESSAY essay) {
        this.essay = essay;
    }

    /**
     * 动态类型枚举
     */
    public enum DType {
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
