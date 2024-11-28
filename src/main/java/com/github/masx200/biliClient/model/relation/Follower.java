package com.github.masx200.biliClient.model.relation;

import java.util.Date;

import com.github.masx200.biliClient.model.BaseModel;
import com.github.masx200.biliClient.model.user.User;
import com.github.masx200.biliClient.utils.TransDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述： 关注者
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-08-16:34
 * @since 2021-02-08-16:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
@com.alibaba.fastjson2.annotation.JSONCompiled
public class Follower extends User implements BaseModel {
    /**
     * 关注/被关 时间
     */
    private long mtime;

    /**
     * 名称
     */
    private String uname;

    @Override
    public Date createTime() {
        return TransDate.timestampToDate(this.mtime);
    }
}
