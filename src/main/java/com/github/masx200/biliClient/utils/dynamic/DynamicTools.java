package com.github.masx200.biliClient.utils.dynamic;

import com.github.masx200.biliClient.BiliClient;
import com.github.masx200.biliClient.model.dynamic.Dynamic;
import com.github.masx200.biliClient.model.dynamic.DynamicItems;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述： 动态相关工具类
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-15:05
 * @since 2021-02-08-15:05
 */
public class DynamicTools {
    /**
     * 获取某一用户全部的动态信息
     *
     * @param biliClient biliClient
     * @param uid        uid
     * @return all dynamic
     */
    public static List<Dynamic> queryAll(BiliClient biliClient, Long uid) throws Exception {
        List<Dynamic> dynamics = new ArrayList<>();
        DynamicItems items = biliClient.dynamic().withHostUid(uid).list(0L);
        do {
            dynamics.addAll(items.getItems());
            items = biliClient.dynamic().withHostUid(uid).list(items.getNextOffset());
        } while (items != null && items.getHasMore() == 1);
        return dynamics;
    }


    /**
     * 分析后的数据返回
     *
     * @param biliClient biliClient
     * @param uid        uid
     * @return all dynamic
     */
    public static DynamicSortInfo queryData(BiliClient biliClient, Long uid) throws Exception {
        return (DynamicSortInfo) new DynamicSortInfo(queryAll(biliClient, uid)).analyze();
    }


}
