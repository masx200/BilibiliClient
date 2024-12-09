package com.github.masx200.biliClient.api.relation

import com.github.masx200.biliClient.BiliCondition
import com.github.masx200.biliClient.able.Listable
import com.github.masx200.biliClient.model.relation.Relation

/**
 * 描述：
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-16:29
 * @since 2021-02-08-16:29
 */
interface IRelationCondition : BiliCondition {
    /**
     * 粉丝
     *
     * @param uid uid
     * @return relation
     */
    fun toFollowers(uid: Long): Listable<Relation?>?

    /**
     * 关注
     *
     * @param uid uid
     * @return relation
     */
    fun toFollowings(uid: Long): Listable<Relation?>?
}
