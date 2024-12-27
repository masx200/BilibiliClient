package com.github.masx200.biliClient.model.dynamic

//import com.github.masx200.biliClient.model.dynamic.DynamicData.bvid
//import com.github.masx200.biliClient.model.dynamic.DynamicData.orig_dy_id
//import com.github.masx200.biliClient.model.dynamic.DynamicData.type
import com.github.masx200.biliClient.model.dynamic.Slf4j.Companion.log
import com.github.masx200.biliClient.model.video.Video
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
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
    val extend_json: String? = null,
    val display : JsonElement?=null
//    val origin: JsonElement?,
){
//     val log = KotlinLogging.logger {}
    /**
     * 动态数据
     */
//     val desc: DynamicData? = null

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
//     val card: String? = null

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
//            把原始数据保留下来
            dynamic.desc = desc
//            if (card != null) {
            val decodecardtoelement = decodecardtoelement(card)

            dynamic.card = decodecardtoelement

            val element = when (decodecardtoelement) {
                is JsonObject -> {
                    val item = decodecardtoelement["origin"]
                    item

                }

                else -> null


            }

            if (desc.type == 1) {
                val dynamic1origin = Dynamic()
                dynamic1origin.data = desc.origin
                dynamic1origin.desc = desc.origin
                dynamic1origin.extend_json = when (decodecardtoelement) {
                    is JsonObject -> {
//                    println(decodecardtoelement["origin_extend_json"])
                        val item = decodecardtoelement["origin_extend_json"]
                        item
                    }

                    else -> null
                }
                if (desc.orig_type == 8L && element != null) {
                    dynamic1origin.type = Dynamic.DType.VIDEO
                    dynamic1origin.video = Json.decodeFromString<Video>(
                        Video.serializer(),
                        Json.encodeToString(JsonElement.serializer(), element)
                    )
                } else {
                    if (desc.orig_type == 2L && element != null) {

                        val element2 = when (element) {
                            is JsonObject -> {
                                val item = element["item"]
                                item

                            }

                            else -> null


                        }
                        dynamic1origin.type = Dynamic.DType.COMMON
                        if (element2 != null) {
//                            println(element2)
                            dynamic1origin.detail = Json.decodeFromString<DynamicDetail>(
                                DynamicDetail.serializer(),
                                Json.encodeToString(JsonElement.serializer(), element2)
                            )
                        }
                    }
                }
                dynamic.origin = dynamic1origin
            }
            dynamic.extend_json = extend_json?.let { decodecardtoelement(it) }
//                if (decodecardtoelement is JsonObject) decodecardtoelement["extend_json"] else null
            dynamic.display = display
//            }
            // 设置数据
            dynamic.SETDATA(this.GETDESC())
            // 解析动态详情
            val dynamicCard: JsonElement =
                Json.decodeFromString<JsonElement>(this.GETCARD())
            if (dynamicCard is JsonObject) {
                if (this.GETDESC().orig_dy_id != null && this.GETDESC().orig_dy_id != 0L) {
                    // 转发
                    dynamic.SETTYPE(Dynamic.DType.REPOST)
                    // 转发内容
                    val stringcontent = if (dynamicCard["item"] != null) Json.encodeToString<JsonElement>(
                        JsonElement.serializer(),
                        dynamicCard["item"]!!
                    ) else {
                        null
                    }
//                    val cardorigin = JsonElementgetString(dynamicCard, ("origin"))
//
//                    if (cardorigin != null && cardorigin.isNotEmpty()) {
//                        //println("cardorigin:"+cardorigin)
////                        val cardoriginobj = Json.decodeFromString<JsonObject>(cardorigin.toString())
//                        try {
////                            val string = JsonElementgetString(cardoriginobj, "item".toString())
//                            if (cardorigin != null) {
////                                println(string)
//                                dynamic.detail =
//                                    Json.decodeFromString<DynamicDetail>(cardorigin)
//                            }
//
//                        } catch (e: Throwable) {
////                            e.printStackTrace()
//                            println(e)
//                        }
//                    }


                    if (stringcontent is String) {
                        dynamic.setrepost(Json.decodeFromString<DynamicRepost>(stringcontent))
                    }
                    // 源内容
//                    val cardorigin2 = dynamicCard.getString("origin")
//                    if (cardorigin2 != null&& cardorigin2.isNotEmpty()) {
//
//                        val cardoriginobj = Json.decodeFromString<JsonObject>(cardorigin2.toString())
//                    // 若源内容违规被屏蔽 避免转换失败
//                        if (cardoriginobj != null && cardoriginobj is JsonObject && !cardoriginobj.isEmpty()) {
//                        val stringcontent = if (dynamicCard["item"] != null) Json.encodeToString<JsonElement>(
//                            JsonElement.serializer(),
//                            dynamicCard["item"]!!
//                        ) else {
//                            null
//                        }
//                        if (stringcontent is String) {
//                            dynamic.detail =
//                                Json .decodeFromString<DynamicDetail>(stringcontent)
//                        }
//                        }
//                    }
                } else if (this.desc.type == 8 || (this.GETDESC().bvid != null && !this.GETDESC().bvid!!.isEmpty())) {
                    // 视频
                    dynamic.SETTYPE(Dynamic.DType.VIDEO)
                    // 视频内容
                    dynamic.SETVIDEO(Json.decodeFromString<Video>(this.GETCARD()))
                } else if (this.GETDESC().type == 64) {
                    // 专栏动态
                    dynamic.SETTYPE(Dynamic.DType.ESSAY)
                    // 写入详情
                    dynamic.setESSAY(Json.decodeFromString<ESSAY>(this.GETCARD()))
                } else {
                    // 普通动态
                    dynamic.SETTYPE(Dynamic.DType.COMMON)
                    // 写入详情
                    val stringcontent = if (dynamicCard["item"] != null) Json.encodeToString<JsonElement>(
                        JsonElement.serializer(),
                        dynamicCard["item"]!!
                    ) else {
                        null
                    }
                    if (stringcontent is String) {
                        dynamic.detail =
                            Json.decodeFromString<DynamicDetail>(stringcontent)
                    }
                }
            }


            // 解析作者信息
            var user: JsonObject? = null
            if (dynamicCard is JsonObject) {
                try {
                    val get = dynamicCard["user"]
                    if (get is JsonObject) {
                        user = get
                    }
                    if (user != null && !user.isEmpty()) {
                        dynamic.uid = LongCompanionvalueOf(JsonObjectgetString(user, ("uid")))
                        dynamic.SETNAME(JsonObjectgetString(user, ("uname")))
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
            throw e
            return null
        }
    }

    fun GETCARD(): String {
        return card!!
    }

    fun GETDESC(): DynamicData {

        return desc!!
    }
}

fun jsonElementoString(obj: JsonElement): String? {


    return when (obj) {
        is JsonPrimitive -> {
            if (obj.isString) {
                obj.content
            } else {
                null
            }
        }

        is JsonArray -> null
        is JsonObject -> null
    }

}

fun decodecardtoelement(card: String): JsonElement {
    val element = Json.decodeFromString<JsonElement>(JsonElement.serializer(), card)
    if (element is JsonObject) {
        val jsonmap = mutableMapOf<String, JsonElement>()

        for (key in element) {
            val value = key.value
//            println(key)
            jsonmap[key.key] =
                when (key.key) {
                    "origin_extend_json", "origin" -> {
                        val card1 = jsonElementoString(value)
                        if (card1 != null) decodecardtoelementcommon(card1) else value
                    }

                    else -> value
                }
//                value

        }
        return JsonObject(jsonmap)
    }
    return element
}

fun decodecardtoelementcommon(card: String): JsonElement {
    val element = Json.decodeFromString<JsonElement>(JsonElement.serializer(), card)



    return element
}

fun LongCompanionvalueOf(string: String?): Long? {
    return try {
        string!!.toLong()
    } catch (_: Exception) {
        null
    }
}

fun JsonObjectgetString(obj: JsonObject, string: String): String? {
//     val this=obj
    if (obj[string] is JsonPrimitive && (obj[string] as JsonPrimitive).isString) {
        return (obj[string] as JsonPrimitive).content
    }
    return null
}

fun JsonElementgetString(obj: JsonElement, string: String): String? {
    if (obj is JsonObject)
        if (obj[string] is JsonPrimitive && (obj[string] as JsonPrimitive).isString) {
            return (obj[string] as JsonPrimitive).content
        }
    return null
}
