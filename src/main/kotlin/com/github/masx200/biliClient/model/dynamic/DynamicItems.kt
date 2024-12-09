package com.github.masx200.biliClient.model.dynamic

//import kotlinx.serialization.json.Json
//import lombok.extern.slf4j.Slf4j
import com.github.masx200.biliClient.BiliResult
import com.github.masx200.biliClient.model.dynamic.Slf4j.Companion.log
import java.util.Objects
import java.util.stream.Collectors
import kotlinx.serialization.Serializable


//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
/**
 * 描述： 集合列表
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-22:14
 * @since 2021-02-07-22:14
 */
@Serializable
@Slf4j
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class DynamicItems(
    var hasMore: Long? = null,
    var has_more: Long? = null, val cards: MutableList<DynamicCard>?,
    /**
     * dynamic 集合
     *
     *
     * 为避免空指针,默认为null集合
     *
     */
    var items: MutableList<Dynamic?> = ArrayList<Dynamic?>(),
    /**
     * 下一次请求偏移量
     *
     *
     * 第一次为0
     *
     */
    var nextOffset: Long = 0L,
    val next_offset: Long = 0,
) {
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
                val dynamicItems: DynamicItems = result.toData<DynamicItems>()

                // 没有更多就返回包含源数据的对象
                // if (dynamicItems.hasMore != 1) {
                // return dynamicItems;
                // }

                // 否则进行遍历 并过滤空对象
                val toDataRoot = result.toData<SpaceHistoryRoot>()
                val cardsarray = toDataRoot.cards
                if (cardsarray == null) {
                    throw Exception("cardsarray为null,可能未登录")
                }
                val cards: MutableList<Dynamic?> = cardsarray.stream().map { obj: DynamicCard? -> obj!!.toDynamic() }
                    .filter { obj: Any? -> Objects.nonNull(obj) }
                    .collect(Collectors.toList())
                dynamicItems.SETITEMS(cards)
                dynamicItems.hasMore = toDataRoot.has_more
                dynamicItems.nextOffset = toDataRoot.next_offset
                // 返回
                return dynamicItems
            } catch (e: Exception) {
                e.printStackTrace()
                this.log.error("当前请求解析异常!原始请求数据为\n {}", result)
                throw e
            }
        }
    }

    fun SETITEMS(dynamics: MutableList<Dynamic?>) {
        items = dynamics
    }
}

@Serializable
data class SpaceHistoryRoot(
    val has_more: Long = 0,
    val next_offset: Long = 0,
    val cards: MutableList<DynamicCard>?,
)