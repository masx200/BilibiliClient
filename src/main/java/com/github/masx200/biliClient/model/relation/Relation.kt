package com.github.masx200.biliClient.model.relation

import com.github.masx200.biliClient.BiliResult
import kotlinx.serialization.json.Json

//import com.alibaba.fastjson.JSONObject;
/**
 * 描述：
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-08-16:32
 * @since 2021-02-08-16:32
 */
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class Relation(
    /**
     * 总数
     */
    val total: Long = 0,

    /**
     * 乐观锁版本
     */
    val re_version: Long = 0,

    /**
     * 关注者列表
     */
    var items: MutableList<Follower?>? = mutableListOf()
) {
    companion object {
        /**
         * 工根据响应结果构建
         *
         * @param result 响应结果
         * @return rl
         */
        @JvmStatic
        fun build(result: BiliResult): Relation {
            val relation: Relation = result.toData<Relation>()
            val list: MutableList<Follower?>? = Json.decodeFromString(result.data.toString())
                .getJSONArray("list").toJavaList(Follower::class.java)
            relation.items=(list)
            return relation
        }
    }
}
