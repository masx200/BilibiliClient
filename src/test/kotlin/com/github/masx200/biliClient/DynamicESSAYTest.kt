package com.github.masx200.biliClient

import com.github.masx200.biliClient.api.dynamic.BiliResultToDynamic
import com.github.masx200.biliClient.model.dynamic.Dynamic
import com.github.masx200.biliClient.model.dynamic.Dynamic.DType
import kotlinx.serialization.json.Json
import org.junit.Test

class DynamicESSAYTest {

    @Test
    fun test_common_essay() {
        val body = """{
    "code": 0,
    "message": "0",
    "ttl": 1,
    "data": {
        "card": {
            "desc": {
                "uid": 2647146,
                "type": 64,
                "rid": 4668037,
                "acl": 0,
                "view": 0,
                "repost": 0,
                "comment": 0,
                "like": 0,
                "is_liked": 1,
                "dynamic_id": 355380033752938050,
                "timestamp": 1581581762,
                "pre_dy_id": 0,
                "orig_dy_id": 0,
                "orig_type": 0,
                "user_profile": {
                    "info": {
                        "uid": 2647146,
                        "uname": "煎轰JianHong",
                        "face": "https://i0.hdslb.com/bfs/face/b2147fa088de70488be908e0b54173029311c630.jpg"
                    },
                    "card": {
                        "official_verify": {
                            "type": -1
                        }
                    },
                    "vip": {
                        "vipType": 1,
                        "vipDueDate": 1670947200000,
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
                    "sign": "四猫家庭御用铲屎官-煎轰",
                    "level_info": {
                        "current_level": 6,
                        "current_min": 0,
                        "current_exp": 0,
                        "next_exp": ""
                    }
                },
                "spec_type": 0,
                "uid_type": 1,
                "stype": 0,
                "r_type": 1,
                "inner_id": 0,
                "status": 1,
                "dynamic_id_str": "355380033752938050",
                "pre_dy_id_str": "0",
                "orig_dy_id_str": "0",
                "rid_str": "4668037",
                "origin": null,
                "bvid": "",
                "previous": null
            },
            "card": "{\"id\":4668037,\"title\":\"【避坑指南】在装机猿合作店买整机你所需要注意的\",\"summary\":\"哈喽，各位亲爱的观众朋友们，今天给大家补上一个作业  我在B站百万up主 “远古时代装机猿”老师合作店 那里购买的电脑体验吧！ [图片] 咱的电脑桌面 视频版请猛搓下面↓ [链接]   装老师的合作店有两家 “西安水元素水冷实验室 ”卖AMD CPU的机子 “西安火元素intel玩家店” 卖Intel CPU的机子   [图片] AMD 机子专卖店 [图片] intel 电脑整机专卖店 这里有第一个需要注意点 当你在某宝搜索“装机猿”店铺，前4家店有两家不是合作店面   [图片] 框选的都不是b站装机猿合作店铺   想找装机猿合作店的新买家千万不要找错了！ 进店后，第二个注意点来了！ 你会发现呀，店里价格不对啊，怎么比装机猿老师发的视频上、公众号上的价格贵那么多呢？   [图片] 为啥价格这么高呢？ 啊，这是因为虚标的 （听说是淘宝控价啥的）咱也不知道详细原因，不过只要和客服沟通一下就可以拿到正确的价格啦 装老师合作的套餐价格在3899~13666之间   这里要夸一下，各种配置都罗列得非常清晰，用的配件都是同价位比较好的，对得起价格！方便小白挑选，真的可以帮帮我 然后我所购买的是5899这一款，具体配置如图   [图片] 58\",\"author\":{\"mid\":2647146,\"name\":\"煎轰JianHong\",\"face\":\"https://i0.hdslb.com/bfs/face/b2147fa088de70488be908e0b54173029311c630.jpg\"},\"image_urls\":[\"https://i0.hdslb.com/bfs/article/ad8890d24c40edb920bd4773193f2f735a73c8e5.jpg\"],\"publish_time\":1581581762,\"ctime\":1581581762,\"mtime\":0,\"stats\":null,\"origin_image_urls\":[\"https://i0.hdslb.com/bfs/article/ad8890d24c40edb920bd4773193f2f735a73c8e5.jpg\"]}",
            "extend_json": "{\"from\":{\"from\":\"\",\"emoji_type\":1},\"ctrl\":null,\"lott\":null}",
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
}""".trimIndent()
        val result = Json.decodeFromString<BiliResult>(body)
            .check()
//        val items = DynamicItems.build(result)
        var dynamic = BiliResultToDynamic(result)
//        for (dynamic in items.items) {
        assert(dynamic != null)
        if (dynamic != null) {
            assert(dynamic.data != null)
            assert(dynamic.data?.dynamic_id_str == dynamic.data?.dynamic_id.toString())
            assert(dynamic.extend_json != null)
            assert(dynamic.origin?.extend_json == null)
            assert(dynamic.origin?.type != DType.VIDEO)
            assert(dynamic.type == DType.ESSAY)
            assert(dynamic.essay != null)
            assert(dynamic.repost == null)
            assert(dynamic.desc != null)
            assert(dynamic.detail == null)
            assert(dynamic.detail?.pictures == null)
            assert(dynamic.origin == null)
            assert(dynamic.origin?.video == null)
            assert(dynamic.origin?.desc == null)
            println(dynamic)
            val encodedstring = Json.encodeToString<Dynamic>(Dynamic.serializer(), dynamic)

            println(encodedstring)
        }
//        }
    }

    @Test
    fun test_repost_essay() {
        val body = """{
    "code": 0,
    "message": "0",
    "ttl": 1,
    "data": {
        "card": {
            "desc": {
                "uid": 27919054,
                "type": 1,
                "rid": 1015556209870110725,
                "acl": 1024,
                "view": 7,
                "repost": 0,
                "comment": 0,
                "like": 1,
                "is_liked": 1,
                "dynamic_id": 1015556209870110725,
                "timestamp": 1735291006,
                "pre_dy_id": 355380033752938050,
                "orig_dy_id": 355380033752938050,
                "orig_type": 64,
                "user_profile": {
                    "info": {
                        "uid": 27919054,
                        "uname": "一生忽得夏司掌好年华",
                        "face": "http://i1.hdslb.com/bfs/face/b95f13deee2f9849105161b938a9c227d3648568.jpg"
                    },
                    "card": {
                        "official_verify": {
                            "type": -1
                        }
                    },
                    "vip": {
                        "vipType": 1,
                        "vipDueDate": 1626451200000,
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
                    "sign": "一生忽而得一夏 当司掌好年华\n一生得此一夏 小舟短楫不负它。\n一司盛夏一生花，一朝诞辰一芳华。\n",
                    "level_info": {
                        "current_level": 6,
                        "current_min": 0,
                        "current_exp": 0,
                        "next_exp": ""
                    }
                },
                "spec_type": 0,
                "uid_type": 1,
                "stype": 0,
                "r_type": 0,
                "inner_id": 0,
                "status": 1,
                "dynamic_id_str": "1015556209870110725",
                "pre_dy_id_str": "355380033752938050",
                "orig_dy_id_str": "355380033752938050",
                "rid_str": "1015556209870110725",
                "origin": {
                    "uid": 2647146,
                    "type": 64,
                    "rid": 4668037,
                    "acl": 0,
                    "view": 0,
                    "repost": 0,
                    "comment": 0,
                    "like": 0,
                    "is_liked": 0,
                    "dynamic_id": 355380033752938050,
                    "timestamp": 0,
                    "pre_dy_id": 0,
                    "orig_dy_id": 0,
                    "orig_type": 0,
                    "user_profile": null,
                    "spec_type": 0,
                    "uid_type": 1,
                    "stype": 0,
                    "r_type": 0,
                    "inner_id": 0,
                    "status": 0,
                    "dynamic_id_str": "355380033752938050",
                    "pre_dy_id_str": "",
                    "orig_dy_id_str": "",
                    "rid_str": "4668037",
                    "origin": null,
                    "bvid": "",
                    "previous": null
                },
                "bvid": "",
                "previous": null
            },
            "card": "{\"user\":{\"uid\":27919054,\"uname\":\"一生忽得夏司掌好年华\",\"face\":\"http://i1.hdslb.com/bfs/face/b95f13deee2f9849105161b938a9c227d3648568.jpg\"},\"item\":{\"rp_id\":1015556209870110725,\"uid\":27919054,\"content\":\"分享动态\",\"ctrl\":\"\",\"reply\":0,\"orig_type\":64,\"orig_dy_id\":355380033752938050,\"pre_dy_id\":355380033752938050,\"miss\":0,\"tips\":\"\"},\"origin\":\"{\\\"id\\\":4668037,\\\"title\\\":\\\"【避坑指南】在装机猿合作店买整机你所需要注意的\\\",\\\"summary\\\":\\\"哈喽，各位亲爱的观众朋友们，今天给大家补上一个作业  我在B站百万up主 “远古时代装机猿”老师合作店 那里购买的电脑体验吧！ [图片] 咱的电脑桌面 视频版请猛搓下面↓ [链接]   装老师的合作店有两家 “西安水元素水冷实验室 ”卖AMD CPU的机子 “西安火元素intel玩家店” 卖Intel CPU的机子   [图片] AMD 机子专卖店 [图片] intel 电脑整机专卖店 这里有第一个需要注意点 当你在某宝搜索“装机猿”店铺，前4家店有两家不是合作店面   [图片] 框选的都不是b站装机猿合作店铺   想找装机猿合作店的新买家千万不要找错了！ 进店后，第二个注意点来了！ 你会发现呀，店里价格不对啊，怎么比装机猿老师发的视频上、公众号上的价格贵那么多呢？   [图片] 为啥价格这么高呢？ 啊，这是因为虚标的 （听说是淘宝控价啥的）咱也不知道详细原因，不过只要和客服沟通一下就可以拿到正确的价格啦 装老师合作的套餐价格在3899~13666之间   这里要夸一下，各种配置都罗列得非常清晰，用的配件都是同价位比较好的，对得起价格！方便小白挑选，真的可以帮帮我 然后我所购买的是5899这一款，具体配置如图   [图片] 58\\\",\\\"author\\\":{\\\"mid\\\":2647146,\\\"name\\\":\\\"煎轰JianHong\\\",\\\"face\\\":\\\"https://i0.hdslb.com/bfs/face/b2147fa088de70488be908e0b54173029311c630.jpg\\\"},\\\"image_urls\\\":[\\\"https://i0.hdslb.com/bfs/article/ad8890d24c40edb920bd4773193f2f735a73c8e5.jpg\\\"],\\\"publish_time\\\":1581581762,\\\"ctime\\\":1581581762,\\\"mtime\\\":0,\\\"stats\\\":null,\\\"origin_image_urls\\\":[\\\"https://i0.hdslb.com/bfs/article/ad8890d24c40edb920bd4773193f2f735a73c8e5.jpg\\\"]}\",\"origin_extend_json\":\"{\\\"from\\\":{\\\"from\\\":\\\"\\\",\\\"emoji_type\\\":1},\\\"ctrl\\\":null,\\\"lott\\\":null}\",\"origin_user\":{\"info\":{\"uid\":2647146,\"uname\":\"煎轰JianHong\",\"face\":\"https://i0.hdslb.com/bfs/face/b2147fa088de70488be908e0b54173029311c630.jpg\"},\"card\":{\"official_verify\":{\"type\":-1}},\"vip\":{\"vipType\":1,\"vipDueDate\":1670947200000,\"dueRemark\":\"\",\"accessStatus\":0,\"vipStatus\":0,\"vipStatusWarn\":\"\",\"themeType\":0,\"label\":{\"path\":\"\",\"text\":\"\",\"label_theme\":\"\",\"text_color\":\"\",\"bg_style\":0,\"bg_color\":\"\",\"border_color\":\"\"},\"avatar_subscript\":0,\"nickname_color\":\"\",\"role\":0,\"avatar_subscript_url\":\"\"},\"pendant\":{\"pid\":0,\"name\":\"\",\"image\":\"\",\"expire\":0,\"image_enhance\":\"\",\"image_enhance_frame\":\"\"},\"rank\":\"10000\",\"sign\":\"四猫家庭御用铲屎官-煎轰\",\"level_info\":{\"current_level\":6,\"current_min\":0,\"current_exp\":0,\"next_exp\":\"\"}}}",
            "extend_json": "{\"from\":{\"from\":\"create.dynamic\",\"emoji_type\":1},\"ctrl\":null,\"lott\":null}",
            "display": {
                "origin": {
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
                },
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
}""".trimIndent()
        val result = Json.decodeFromString<BiliResult>(body)
            .check()
//        val items = DynamicItems.build(result)
        var dynamic = BiliResultToDynamic(result)
//        for (dynamic in items.items) {
        assert(dynamic != null)
        if (dynamic != null) {
            assert(dynamic.data != null)
            assert(dynamic.data?.dynamic_id_str == dynamic.data?.dynamic_id.toString())
            assert(dynamic.extend_json != null)
            assert(dynamic.origin?.extend_json != null)
            assert(dynamic.origin?.type == DType.ESSAY)
            assert(dynamic.type == DType.REPOST)
            assert(dynamic.repost != null)
            assert(dynamic.desc != null)
            assert(dynamic.detail == null)
            assert(dynamic.detail?.pictures == null)
            assert(dynamic.origin != null)
            assert(dynamic.origin?.essay != null)
            assert(dynamic.origin?.desc != null)
            assert(dynamic.origin?.detail?.pictures == null)
            assert(dynamic.origin?.data != null)
            assert(dynamic.origin?.data?.dynamic_id_str == dynamic.origin?.data?.dynamic_id.toString())
            println(dynamic)
            val encodedstring = Json.encodeToString<Dynamic>(Dynamic.serializer(), dynamic)

            println(encodedstring)
        }
//        }
    }
}