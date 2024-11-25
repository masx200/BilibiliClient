package com.github.masx200.biliClient.api.relation;

import com.github.masx200.biliClient.BiliClient;
import com.github.masx200.biliClient.BiliClientFactor;
import com.github.masx200.biliClient.model.relation.Relation;
import org.junit.Test;

/**
 * 描述：
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-16:59
 * @since 2021-02-08-16:59
 */
public class IRelationConditionTest {

    private final BiliClient biliClient = BiliClientFactor.getClient();

    @Test
    public void toFollowers() {
        Relation list = biliClient.relation().toFollowers(392819792L).list();
        System.out.println(list.getTotal());
        System.out.println(list.getItems().get(0).getUname());
        System.out.println(list.getItems().get(0).createTime());
    }

    @Test
    public void toFollowings() {
        Relation list = biliClient.relation().toFollowings(392819792L).listPage(25L, 2L);
        System.out.println(list.getTotal());
        System.out.println(list.getItems().size());
        System.out.println(list.getItems().get(0).getUname());
        System.out.println(list.getItems().get(0).createTime());

    }
}