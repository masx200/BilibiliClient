package com.github.masx200.biliClient;

import com.github.masx200.biliClient.api.dynamic.IDynamicCondition;
import com.github.masx200.biliClient.api.relation.IRelationCondition;
import com.github.masx200.biliClient.api.user.IUserCondition;
import com.github.masx200.biliClient.api.video.IVideoCondition;

/**
 * 描述： 哔哩哔哩 Client
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-05-15:53
 * @since 2021-02-05-15:53
 */
public interface BiliClient {
    /**
     * 用户相关
     *
     * @return 用户条件
     */
    IUserCondition user();

    /**
     * 动态相关
     *
     * @return 动态条件
     */
    IDynamicCondition dynamic();

    /**
     * 关系相关
     *
     * @return 关系条件
     */
    IRelationCondition relation();

    /**
     * 视频相关
     *
     * @return 视频条件
     */
    IVideoCondition video();
}
