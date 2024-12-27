package com.github.masx200.biliClient

import com.github.masx200.biliClient.api.dynamic.BiliResultToDynamic
import com.github.masx200.biliClient.model.dynamic.Dynamic
import com.github.masx200.biliClient.model.dynamic.Dynamic.DType
import kotlinx.serialization.json.Json
import org.junit.Test

class DynamiccommonTest {

    @Test
    fun test_common_common() {
        val body = """
{
    "code": 0,
    "message": "0",
    "ttl": 1,
    "data": {
        "card": {
            "desc": {
                "uid": 3493136860973895,
                "type": 2,
                "rid": 337922502,
                "acl": 1024,
                "view": 2652,
                "repost": 2,
                "comment": 2,
                "like": 30,
                "is_liked": 1,
                "dynamic_id": 1014438148251320339,
                "timestamp": 1735030687,
                "pre_dy_id": 0,
                "orig_dy_id": 0,
                "orig_type": 0,
                "user_profile": {
                    "info": {
                        "uid": 3493136860973895,
                        "uname": "TESTV-集市",
                        "face": "https://i0.hdslb.com/bfs/face/c12ecee76759b2f0458aa5b2fce0a77a03fa0ba1.jpg"
                    },
                    "card": {
                        "official_verify": {
                            "type": -1
                        }
                    },
                    "vip": {
                        "vipType": 0,
                        "vipDueDate": 0,
                        "dueRemark": "",
                        "accessStatus": 0,
                        "vipStatus": 0,
                        "vipStatusWarn": "",
                        "themeType": 0,
                        "label": {
                            "path": "",
                            "text": "",
                            "label_theme": "",
                            "text_color": "",
                            "bg_style": 0,
                            "bg_color": "",
                            "border_color": ""
                        },
                        "avatar_subscript": 0,
                        "nickname_color": "",
                        "role": 0,
                        "avatar_subscript_url": ""
                    },
                    "pendant": {
                        "pid": 0,
                        "name": "",
                        "image": "",
                        "expire": 0,
                        "image_enhance": "",
                        "image_enhance_frame": ""
                    },
                    "rank": "10000",
                    "sign": "分享TESTV周边的一些最新进展，或者是一些周边的神奇用法，总之，在这里，你能看到我们周边想看的一切！",
                    "level_info": {
                        "current_level": 4,
                        "current_min": 0,
                        "current_exp": 0,
                        "next_exp": ""
                    }
                },
                "spec_type": 0,
                "uid_type": 1,
                "stype": 0,
                "r_type": 2,
                "inner_id": 0,
                "status": 1,
                "dynamic_id_str": "1014438148251320339",
                "pre_dy_id_str": "0",
                "orig_dy_id_str": "0",
                "rid_str": "337922502",
                "origin": null,
                "bvid": "",
                "previous": null
            },
            "card": "{\"item\":{\"id\":337922502,\"description\":\"肖师傅终于可以说“多喝热水”了，也可以不用再说“多喝热水”了！——明天十点，来看肖师傅赛博“脱单”！\\n​TESTV在桃乌龙袋泡茶...\",\"pictures\":[{\"img_height\":1200,\"img_width\":800,\"img_src\":\"http://i0.hdslb.com/bfs/new_dyn/14b0a29fb121b39058d821b051fe0fc73493136860973895.jpg\",\"img_size\":152.80999755859375},{\"img_height\":3824,\"img_width\":2151,\"img_src\":\"http://i0.hdslb.com/bfs/new_dyn/6d91891a62d36e06070ad1f7186519703493136860973895.jpg\",\"img_size\":1196.52001953125}],\"pictures_count\":2,\"reply\":2,\"upload_time\":1735030687},\"user\":{\"uid\":3493136860973895,\"name\":\"TESTV-集市\",\"head_url\":\"https://i0.hdslb.com/bfs/face/c12ecee76759b2f0458aa5b2fce0a77a03fa0ba1.jpg\",\"vip\":{\"type\":0,\"due_date\":0,\"status\":0,\"theme_type\":0,\"label\":{\"path\":\"\",\"text\":\"\",\"label_theme\":\"\",\"text_color\":\"\",\"bg_style\":0,\"bg_color\":\"\",\"border_color\":\"\"},\"avatar_subscript\":0,\"nickname_color\":\"\",\"vip_pay_type\":0}}}",
            "extend_json": "{\"from\":{\"from\":\"create.big_plus\",\"emoji_type\":1},\"ctrl\":[{\"data\":\"16\",\"length\":16,\"location\":51,\"type\":4,\"type_id\":\"4_102583419\",\"prefix_icon\":\"\"}],\"lott\":null}",
            "display": {
                "origin": null,
                "usr_action_txt": "",
                "relation": {
                    "status": 1,
                    "is_follow": 0,
                    "is_followed": 0
                },
                "live_info": null,
                "emoji_info": {
                    "emoji_details": null
                },
                "highlight": null
            }
        }
    }
}


""".trimIndent()
        val result = Json.decodeFromString<BiliResult>(body)
            .check()
//        val items = DynamicItems.build(result)
        var dynamic = BiliResultToDynamic(result)
//        for (dynamic in items.items) {
        assert(dynamic != null)
        if (dynamic != null) {
            assert(dynamic.extend_json != null)
            assert(dynamic.origin?.extend_json == null)
            assert(dynamic.origin?.type != DType.VIDEO)
            assert(dynamic.type == DType.COMMON)
            assert(dynamic.repost == null)
            assert(dynamic.desc != null)
            assert(dynamic.detail != null)
            assert(dynamic.detail?.pictures != null)
            assert(dynamic.origin == null)
            assert(dynamic.origin?.video == null)
            assert(dynamic.origin?.desc == null)
            println(dynamic)
            val encodedstring = Json.encodeToString<Dynamic>(Dynamic.serializer(), dynamic)

            println(encodedstring)
        }
//        }
    }
}