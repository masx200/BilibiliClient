package com.github.masx200.biliClient.api.dynamic;

import com.github.masx200.biliClient.BiliCondition;
import com.github.masx200.biliClient.able.Gettable;
import com.github.masx200.biliClient.able.Listable;
import com.github.masx200.biliClient.model.dynamic.Dynamic;
import com.github.masx200.biliClient.model.dynamic.DynamicItems;

/**
 * 描述： 动态条件
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-21:22
 * @since 2021-02-07-21:22
 */
public interface IDynamicCondition extends BiliCondition {
    /**
     * 根据动态ID 获取动态
     *
     * @param dynamicId 动态id
     * @return 动态
     */
    Gettable<Dynamic> withDynamicId(Long dynamicId);

    /**
     * 根据用户获取动态列表
     *
     * @param uid 用户id
     * @return list
     */
    Listable<DynamicItems> withHostUid(Long uid);
}
