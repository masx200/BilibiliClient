package com.github.masx200.biliClient.api.dynamic;

import com.github.masx200.biliClient.BiliClient;
import com.github.masx200.biliClient.BiliClientFactor;
import com.github.masx200.biliClient.exception.BiliRequestException;
import com.github.masx200.biliClient.model.dynamic.Dynamic;
import com.github.masx200.biliClient.model.dynamic.DynamicItems;
import org.junit.Test;

/**
 * 描述： 动态测试
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-21:49
 * @since 2021-02-07-21:49
 */
public class IDynamicConditionTest {
    private final BiliClient biliClient = BiliClientFactor.getClient();

    @Test
    public void withDynamicIdForward() {
        Dynamic dynamic = biliClient.dynamic().withDynamicId(484920426409631452L).get();
        System.out.println(dynamic);
        System.out.println(dynamic.getData().createTime());
    }

    @Test
    public void withDynamicId() {
        Dynamic dynamic = biliClient.dynamic().withDynamicId(485425544628969967L).get();
        System.out.println(dynamic);
        System.out.println(dynamic.getData().createTime());
        System.out.println(dynamic.getData().updateTime());
    }

    @Test
    public void withHostUid() {
        DynamicItems list = biliClient.dynamic().withHostUid(392819792L).list();
        System.out.println(list);
        list.getItems().forEach(System.out::println);
        System.out.println(list.getItems().get(0).getData());
        System.out.println(list.getItems().get(0).getData().getView());
        System.out.println(list.getItems().get(0).getDetail().getDescription());
        System.out.println(list.getItems().get(0).getUid());
        System.out.println(list.getItems().get(0).getName());
    }

    @Test
    public void withHostUidOffset() {
        DynamicItems list = biliClient.dynamic().withHostUid(392819792L).list();
        System.out.println(list);
        System.out.println("__________________");
        DynamicItems list1 = biliClient.dynamic().withHostUid(392819792L).list(list.getNextOffset());
        System.out.println(list1);
    }


    @Test
    public void withHostUidOffsetLimit() {
        try {
            biliClient.dynamic().withHostUid(392819792L).list(20L, 30L);
        } catch (BiliRequestException e) {
            e.printStackTrace();
        }
    }
}