package com.github.masx200.biliClient.api.dynamic;

import com.github.masx200.biliClient.BiliRequestFactor;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.able.Listable;
import com.github.masx200.biliClient.model.dynamic.Dynamic;
import com.github.masx200.biliClient.model.dynamic.DynamicItems;

/**
 * 描述：动态条件实现类
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-21:24
 * @since 2021-02-07-21:24
 */
public class DynamicConditionImpl implements IDynamicCondition {
    @Override
    public Gettable<Dynamic> withDynamicId(Long dynamicId) {
        return new DynamicGet(BiliRequestFactor.getBiliRequest().useHostVC().setPath(DynamicPath.DYNAMIC_DETAIL)
                .setParams("dynamic_id", dynamicId));
    }

    @Override
    public Listable<DynamicItems> withHostUid(Long uid) {
        return new DynamicList(BiliRequestFactor.getBiliRequest().useHostVC().setPath(DynamicPath.DYNAMIC_USER_LIST)
                .setParams("host_uid", uid));
    }
}
