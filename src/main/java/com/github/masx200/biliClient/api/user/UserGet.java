package com.github.masx200.biliClient.api.user;

import com.github.masx200.biliClient.BiliCall;
import com.github.masx200.biliClient.BiliRequest;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.exception.BiliRequestException;
import com.github.masx200.biliClient.model.user.User;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.function.Consumer;

/**
 * 描述： 用户GET
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-14:58
 * @since 2021-02-07-14:58
 */
public class UserGet implements Gettable<User> {
    private final BiliRequest request;
    private final Consumer<HttpRequestBase> beforeRequest;

    // 默认构造函数
    public UserGet(BiliRequest request) {
        this(request, null);
    }

    // 带参数的构造函数
    public UserGet(BiliRequest request, Consumer<HttpRequestBase> beforeRequest) {
        this.request = request;
        this.beforeRequest = beforeRequest;
    }


    @Override
    public User get() {
        try {
            return BiliCall.doCall(request,beforeRequest).toData(User.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BiliRequestException(request.getURI(), e.getMessage());
        }
    }
}
