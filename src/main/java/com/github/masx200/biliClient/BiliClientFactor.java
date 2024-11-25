package com.github.masx200.biliClient;

import com.github.masx200.biliClient.api.dynamic.DynamicConditionImpl;
import com.github.masx200.biliClient.api.dynamic.IDynamicCondition;
import com.github.masx200.biliClient.api.relation.IRelationCondition;
import com.github.masx200.biliClient.api.relation.RelationConditionImpl;
import com.github.masx200.biliClient.api.user.IUserCondition;
import com.github.masx200.biliClient.api.user.UserConditionImpl;
import com.github.masx200.biliClient.api.video.IVideoCondition;
import com.github.masx200.biliClient.api.video.VideoConditionImpl;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.function.Consumer;

/**
 * 描述： 客户端工厂方法
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-16:00
 * @since 2021-02-07-16:00
 */
public class BiliClientFactor {
    public static BiliClient getClient() {
        return new BiliClientDefault();
    }

    public static BiliClient getClient(Consumer<HttpRequestBase> beforeRequest) {
        return new BiliClientDefault(beforeRequest);
    }
    private static class BiliClientDefault implements BiliClient {
        // 默认构造函数
        public BiliClientDefault() {
            this.beforeRequest = null;
        }

        // 带参数的构造函数
        public BiliClientDefault(Consumer<HttpRequestBase> beforeRequest) {
            this.beforeRequest = beforeRequest;
        }
        private final Consumer<HttpRequestBase> beforeRequest;
        @Override
        public IUserCondition user() {
            return new UserConditionImpl(beforeRequest);
        }

        @Override
        public IDynamicCondition dynamic() {
            return new DynamicConditionImpl(beforeRequest);
        }

        @Override
        public IRelationCondition relation() {
            return new RelationConditionImpl(beforeRequest);
        }

        @Override
        public IVideoCondition video() {
            return new VideoConditionImpl(beforeRequest);
        }
    }
}
