package com.github.masx200.biliClient.model.dynamic

//import com.github.masx200.biliClient.model.dynamic.DynamicData.bvid
//import com.github.masx200.biliClient.model.dynamic.DynamicData.orig_dy_id
//import com.github.masx200.biliClient.model.dynamic.DynamicData.type
import com.github.masx200.biliClient.model.dynamic.Slf4j.Companion.log
import com.github.masx200.biliClient.model.video.Video
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

//import com.alibaba.fastjson.JSONObject;

/**
 * 描述： 动态条目 card
 *
 *
 * result.data.card
 *
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-20:35
 * @since 2021-02-07-20:35
 */
@Serializable
@Slf4j
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class DynamicCard (
    /**
     * 动态数据
     */
    val desc: DynamicData? = null,

    /**
     * 动态实际内容
     *
     *
     * card.item为动态详情或转发详情
     *
     *
     *
     * 根据desc 判断是否为转发
     *
     */
    val card: String? = null,
//    val origin: JsonElement?,
){
//     val log = KotlinLogging.logger {}
    /**
     * 动态数据
     */
//    private val desc: DynamicData? = null

    /**
     * 动态实际内容
     *
     *
     * card.item为动态详情或转发详情
     *
     *
     *
     * 根据desc 判断是否为转发
     *
     */
//    private val card: String? = null

    /**
     * 将card 转换为 dynamic 对象
     *
     *
     * **若解析异常将会传回null 对象**
     *
     *
     * @return dynamic
     */
    fun toDynamic(): Dynamic? {
        // 空对象抛出null
        if (desc == null || card == null || card.isEmpty()) {
            return null
        }
        try {
            val dynamic = Dynamic()
            // 设置数据
            dynamic.setData(this.getDesc())
            // 解析动态详情
            val dynamicCard: JsonElement = Json.decodeFromString<JsonElement>(this.getCard())
            if (dynamicCard is JsonObject) {
                if (this.getDesc().orig_dy_id != null && this.getDesc().orig_dy_id != 0L) {
                    // 转发
                    dynamic.setType(Dynamic.DType.REPOST)
                    // 转发内容
                    val string = dynamicCard["item"]
                    if (string is JsonPrimitive && string.isString) {
                        dynamic.setRepost(Json.decodeFromString<DynamicRepost>(string.content))
                    }
                    // 源内容
                    val origin = dynamicCard["origin"]
                    // 若源内容违规被屏蔽 避免转换失败
                    if (origin != null && origin is JsonObject && !origin.isEmpty()) {
                        val string1 = origin["item"]
                        if (string1 is JsonPrimitive && string1.isString) {
                            dynamic.setDetail(Json.decodeFromString<DynamicDetail>(string1.content))
                        }
                    }
                } else if (this.getDesc().bvid != null && !this.getDesc().bvid!!.isEmpty()) {
                    // 视频
                    dynamic.setType(Dynamic.DType.VIDEO)
                    // 视频内容
                    dynamic.setVideo(Json.decodeFromString<Video>(this.getCard()))
                } else if (this.getDesc().type == 64) {
                    // 专栏动态
                    dynamic.setType(Dynamic.DType.ESSAY)
                    // 写入详情
                    dynamic.setESSAY(Json.decodeFromString<ESSAY>(this.getCard()))
                } else {
                    // 普通动态
                    dynamic.setType(Dynamic.DType.COMMON)
                    // 写入详情
                    val string = dynamicCard["item"]
                    if (string is JsonPrimitive && string.isString) {
                        dynamic.setDetail(Json.decodeFromString<DynamicDetail>(string.content))
                    }
                }
            }


            // 解析作者信息
            var user: JsonObject? = null
            if (dynamicCard is JsonObject) {
                try {
                    val get = dynamicCard.get("user")
                    if (get is JsonObject) {
                        user = get
                    }
                    if (user != null && !user.isEmpty()) {
                        dynamic.setUid(Long.valueOf(user.getString("uid")))
                        dynamic.setName(user.getString("name"))
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    this.log.error("解析作者信息时发生异常！ 原始数据为{}", user)
                }
            }
            // 返回动态
            return dynamic
        } catch (e: Exception) {
            e.printStackTrace()
            this.log.error(
                "动态解析遇到错误！可能遇到了格式不支持的动态或该类型为新型动态,原始内容如下\n {}",
                this
            )
            return null
        }
    }

    private fun getCard(): String {
        return card!!
    }

    private fun getDesc(): DynamicData {

        return desc!!
    }
}

fun Long.Companion.valueOf(string: String?): Long? {
    return try {
        string!!.toLong()
    } catch (_: Exception) {
        null
    }
}

private fun JsonObject.getString(string: String): String? {
    if (this.get(string) is JsonPrimitive && (this.get(string) as JsonPrimitive).isString) {
        return (this.get(string) as JsonPrimitive).content
    }
    return null
}
