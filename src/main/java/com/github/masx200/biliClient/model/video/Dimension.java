package com.github.masx200.biliClient.model.video;

import lombok.Data;

/**
 * 描述： 分辨率
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-08-18:59
 * @since 2021-02-08-18:59
 */
@Data
@com.alibaba.fastjson2.annotation.JSONCompiled
public class Dimension {
    /**
     * 宽
     */
    private int width;

    /**
     * 高
     */
    private int height;

    /**
     * 选择 ？
     */
    private int rotate;
}
