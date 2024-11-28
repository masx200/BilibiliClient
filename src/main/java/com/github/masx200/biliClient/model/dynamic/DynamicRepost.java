package com.github.masx200.biliClient.model.dynamic;

import java.util.Date;

import com.github.masx200.biliClient.model.BaseModel;
import com.github.masx200.biliClient.utils.TransDate;

import lombok.Data;

/**
 * 描述： 动态转发
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-21:13
 * @since 2021-02-07-21:13
 */
@Data
@com.alibaba.fastjson2.annotation.JSONCompiled
public class DynamicRepost implements BaseModel {
    /**
     * 转发详情
     */
    private String content;
    /**
     * 转发时间
     */
    private Long timestamp;

    @Override
    public Date createTime() {
        return TransDate.timestampToDate(this.timestamp);
    }
}
