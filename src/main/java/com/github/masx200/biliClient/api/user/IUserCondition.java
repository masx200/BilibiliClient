package com.github.masx200.biliClient.api.user;

import com.github.masx200.biliClient.BiliCondition;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.model.user.User;

/**
 * 描述：用户请求条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-14:40
 * @since 2021-02-07-14:40
 */
public interface IUserCondition extends BiliCondition {
    /**
     * 获取指定用户的用户信息
     *
     * @param uid uid
     * @return get
     */
    Gettable<User> withUID(Long uid);

    /**
     * 获取当前登录用户信息
     *
     * @return get
     */
    Gettable<User> withMe();
}