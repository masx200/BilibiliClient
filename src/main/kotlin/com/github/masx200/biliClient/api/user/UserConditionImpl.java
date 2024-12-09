package com.github.masx200.biliClient.api.user;

import com.github.masx200.biliClient.BiliRequestFactor;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.model.user.User;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.function.Consumer;

/**
 * 描述： 用户条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-15:37
 * @since 2021-02-07-15:37
 */
public class UserConditionImpl implements IUserCondition {
    private final Consumer<HttpRequestBase> beforeRequest;

    // 默认构造函数
    public UserConditionImpl() {
        this.beforeRequest = null;
    }

    // 带参数的构造函数
    public UserConditionImpl(Consumer<HttpRequestBase> beforeRequest) {
        this.beforeRequest = beforeRequest;
    }
    @Override
    public Gettable<User> withUID(Long uid) {
        return new UserGet(BiliRequestFactor.getBiliRequest().setPath(UserPath.USER_INFO)
                .setParams("mid", String.valueOf(uid)),beforeRequest);
    }

    @Override
    public Gettable<User> withMe() {
        return new UserGet(BiliRequestFactor.getBiliRequest().setPath(UserPath.USER_MY_INFO),beforeRequest);
    }
}
