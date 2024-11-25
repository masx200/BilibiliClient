package com.github.masx200.biliClient.api.relation;

import com.github.masx200.biliClient.BiliCondition;
import com.github.masx200.biliClient.able.Listable;
import com.github.masx200.biliClient.model.relation.Relation;

/**
 * 描述：
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-16:29
 * @since 2021-02-08-16:29
 */
public interface IRelationCondition extends BiliCondition {
    /**
     * 粉丝
     *
     * @param uid uid
     * @return relation
     */
    Listable<Relation> toFollowers(long uid);

    /**
     * 关注
     *
     * @param uid uid
     * @return relation
     */
    Listable<Relation> toFollowings(long uid);
}
