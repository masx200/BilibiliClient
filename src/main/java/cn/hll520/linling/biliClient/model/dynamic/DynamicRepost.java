package com.github.masx200.biliClient.model.dynamic;

import com.github.masx200.biliClient.model.BaseModel;
import com.github.masx200.biliClient.utils.TransDate;
import lombok.Data;

import java.util.Date;

/**
 * 描述： 动态转发
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-21:13
 * @since 2021-02-07-21:13
 */
@Data
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
