package com.github.masx200.biliClient;

import com.github.masx200.biliClient.api.dynamic.DynamicConditionImpl;
import com.github.masx200.biliClient.api.dynamic.IDynamicCondition;
import com.github.masx200.biliClient.api.relation.IRelationCondition;
import com.github.masx200.biliClient.api.relation.RelationConditionImpl;
import com.github.masx200.biliClient.api.user.IUserCondition;
import com.github.masx200.biliClient.api.user.UserConditionImpl;
import com.github.masx200.biliClient.api.video.IVideoCondition;
import com.github.masx200.biliClient.api.video.VideoConditionImpl;

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


    private static class BiliClientDefault implements BiliClient {

        @Override
        public IUserCondition user() {
            return new UserConditionImpl();
        }

        @Override
        public IDynamicCondition dynamic() {
            return new DynamicConditionImpl();
        }

        @Override
        public IRelationCondition relation() {
            return new RelationConditionImpl();
        }

        @Override
        public IVideoCondition video() {
            return new VideoConditionImpl();
        }
    }
}
