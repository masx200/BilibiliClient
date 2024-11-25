package com.github.masx200.biliClient.model.relation;

import com.github.masx200.biliClient.BiliResult;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

/**
 * 描述：
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-16:32
 * @since 2021-02-08-16:32
 */
@Data
public class Relation {
    /**
     * 总数
     */
    private long total;

    /**
     * 乐观锁版本
     */
    private long re_version;

    /**
     * 关注者列表
     */
    private List<Follower> items;

    /**
     * 工根据响应结果构建
     *
     * @param result 响应结果
     * @return rl
     */
    public static Relation build(BiliResult result) {
        Relation relation = result.toData(Relation.class);
        List<Follower> list = JSONObject.parseObject(result.getData().toString())
                .getJSONArray("list").toJavaList(Follower.class);
        relation.setItems(list);
        return relation;
    }
}
