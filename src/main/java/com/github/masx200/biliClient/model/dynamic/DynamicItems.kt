package com.github.masx200.biliClient.model.dynamic

import com.github.masx200.biliClient.BiliResult
import java.util.Objects
import java.util.stream.Collectors
import kotlinx.serialization.json.Json
import lombok.extern.slf4j.Slf4j

//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
/**
 * 描述： 集合列表
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-22:14
 * @since 2021-02-07-22:14
 */
@Slf4j
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class DynamicItems {
    /**
     * 是否还有更多
     *
     *
     * 1 是
     *
     *
     *
     * 0 否
     *
     */
    private val hasMore: Int? = null

    /**
     * dynamic 集合
     *
     *
     * 为避免空指针,默认为null集合
     *
     */
    private val items: MutableList<Dynamic?> = ArrayList<Dynamic?>()

    /**
     * 下一次请求偏移量
     *
     *
     * 第一次为0
     *
     */
    private val nextOffset = 0L

    companion object {
        /**
         * 根据 result 构建
         *
         *
         * 解析错误将返回null 对象
         *
         *
         * @param result 响应结果
         * @return di
         */
        @JvmStatic
        @Throws(Exception::class)
        fun build(result: BiliResult): DynamicItems {
            try {
                val dynamicItems: DynamicItems = result.toData(DynamicItems::class.java)

                // 没有更多就返回包含源数据的对象
                // if (dynamicItems.hasMore != 1) {
                // return dynamicItems;
                // }

                // 否则进行遍历 并过滤空对象
                val cardsarray: JSONArray = Json.decodeFromString(result.data.toString()).getJSONArray("cards")
                if (cardsarray == null) {
                    throw Exception("cardsarray为null,可能未登录")
                }
                val cards: MutableList<Dynamic?> = cardsarray
                    .toJavaList(DynamicCard::class.java).stream().map({ obj: DynamicCard? -> obj!!.toDynamic() })
                    .filter({ obj: Any? -> Objects.nonNull(obj) })
                    .collect(Collectors.toList())
                dynamicItems.setItems(cards)

                // 返回
                return dynamicItems
            } catch (e: Exception) {
                e.printStackTrace()
                DynamicItems.log.error("当前请求解析异常!原始请求数据为\n {}", result)
                throw e
            }
        }
    }
}
