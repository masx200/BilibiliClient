package com.github.masx200.biliClient

import com.github.masx200.biliClient.model.dynamic.Dynamic
import com.github.masx200.biliClient.model.dynamic.Dynamic.DType
import com.github.masx200.biliClient.model.dynamic.DynamicItems
import kotlinx.serialization.json.Json
import org.junit.Test

class DynamicVideoTest {
    @Test
    fun test_repost_video() {
        val body = """
            {
    "code": 0,
    "message": "0",
    "ttl": 1,
    "data": {
        "has_more": 1,
        "cards": [
            {
                "desc": {
                    "uid": 27919054,
                    "type": 1,
                    "rid": 1015262674586435602,
                    "acl": 1024,
                    "view": 0,
                    "repost": 0,
                    "comment": 0,
                    "like": 0,
                    "is_liked": 0,
                    "dynamic_id": 1015262674586435602,
                    "timestamp": 1735222662,
                    "pre_dy_id": 1009514036959641673,
                    "orig_dy_id": 1009514036959641673,
                    "orig_type": 8,
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
                    "dynamic_id_str": "1015262674586435602",
                    "pre_dy_id_str": "1009514036959641673",
                    "orig_dy_id_str": "1009514036959641673",
                    "rid_str": "1015262674586435602",
                    "origin": {
                        "uid": 347441270,
                        "type": 8,
                        "rid": 113628795637788,
                        "acl": 0,
                        "view": 0,
                        "repost": 0,
                        "comment": 0,
                        "like": 0,
                        "is_liked": 0,
                        "dynamic_id": 1009514036959641673,
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
                        "dynamic_id_str": "1009514036959641673",
                        "pre_dy_id_str": "",
                        "orig_dy_id_str": "",
                        "rid_str": "113628795637788",
                        "origin": null,
                        "bvid": "",
                        "previous": null
                    },
                    "bvid": "",
                    "previous": null
                },
                "card": "{\"user\":{\"uid\":27919054,\"uname\":\"一生忽得夏司掌好年华\",\"face\":\"http://i1.hdslb.com/bfs/face/b95f13deee2f9849105161b938a9c227d3648568.jpg\"},\"item\":{\"rp_id\":1015262674586435602,\"uid\":27919054,\"content\":\"分享动态\",\"ctrl\":\"\",\"reply\":0,\"orig_type\":8,\"orig_dy_id\":1009514036959641673,\"pre_dy_id\":1009514036959641673,\"miss\":0,\"tips\":\"\"},\"origin\":\"{\\\"aid\\\":113628795637788,\\\"cid\\\":27275036996,\\\"ctime\\\":1733884203,\\\"desc\\\":\\\"先奉上华为 Mate 70 Pro+ 的拆解，其它三杯（标准版、Pro 和 RS）的拆解已经在进行中～\\\",\\\"dimension\\\":{\\\"height\\\":1920,\\\"rotate\\\":0,\\\"width\\\":3840},\\\"duration\\\":1149,\\\"dynamic\\\":\\\"\\\",\\\"first_frame\\\":\\\"http://i1.hdslb.com/bfs/storyff/n241210sa3o3jzlk8rpe5q14zpbsb68x_firsti.jpg\\\",\\\"jump_url\\\":\\\"bilibili://video/113628795637788/?page=1\\\\u0026player_width=3840\\\\u0026player_height=1920\\\\u0026player_rotate=0\\\",\\\"owner\\\":{\\\"face\\\":\\\"https://i2.hdslb.com/bfs/face/7d8bcf782104fe1c26e99294ce365ce21fa02c80.jpg\\\",\\\"mid\\\":347441270,\\\"name\\\":\\\"微机分WekiHome\\\"},\\\"pic\\\":\\\"http://i2.hdslb.com/bfs/archive/70c43c362f78652d633c32cf9cdd8a4005076bef.jpg\\\",\\\"pubdate\\\":1733884200,\\\"short_link_v2\\\":\\\"\\\",\\\"stat\\\":{\\\"aid\\\":113628795637788,\\\"coin\\\":4577,\\\"danmaku\\\":5455,\\\"dislike\\\":0,\\\"favorite\\\":2427,\\\"like\\\":16957,\\\"reply\\\":3701,\\\"share\\\":1770,\\\"view\\\":429684},\\\"state\\\":0,\\\"tid\\\":95,\\\"title\\\":\\\"【享拆】华为 Mate 70 Pro+ 拆解：稳步向前～\\\",\\\"tname\\\":\\\"数码\\\",\\\"videos\\\":1}\",\"origin_extend_json\":\"{\\\"from\\\":{\\\"from\\\":\\\"\\\",\\\"emoji_type\\\":1},\\\"ctrl\\\":null,\\\"lott\\\":null}\",\"origin_user\":{\"info\":{\"uid\":347441270,\"uname\":\"微机分WekiHome\",\"face\":\"https://i2.hdslb.com/bfs/face/7d8bcf782104fe1c26e99294ce365ce21fa02c80.jpg\"},\"card\":{\"official_verify\":{\"type\":-1}},\"vip\":{\"vipType\":2,\"vipDueDate\":1747670400000,\"dueRemark\":\"\",\"accessStatus\":0,\"vipStatus\":1,\"vipStatusWarn\":\"\",\"themeType\":0,\"label\":{\"path\":\"\",\"text\":\"年度大会员\",\"label_theme\":\"annual_vip\",\"text_color\":\"#FFFFFF\",\"bg_style\":1,\"bg_color\":\"#FB7299\",\"border_color\":\"\"},\"avatar_subscript\":1,\"nickname_color\":\"#FB7299\",\"role\":3,\"avatar_subscript_url\":\"\"},\"pendant\":{\"pid\":0,\"name\":\"\",\"image\":\"\",\"expire\":0,\"image_enhance\":\"\",\"image_enhance_frame\":\"\"},\"rank\":\"10000\",\"sign\":\"体验因人而异，结构用料是实打实的！ 商务合作：bd@wekihome.com \",\"level_info\":{\"current_level\":6,\"current_min\":0,\"current_exp\":0,\"next_exp\":\"\"}}}",
                "extend_json": "{\"from\":{\"from\":\"fastpub.ugc_play\",\"emoji_type\":1},\"ctrl\":null,\"lott\":null}",
                "display": {
                    "origin": {
                        "origin": null,
                        "usr_action_txt": "投稿了视频",
                        "relation": {
                            "status": 2,
                            "is_follow": 1,
                            "is_followed": 0
                        },
                        "live_info": null,
                        "emoji_info": null,
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
            
        ],
        "next_offset":  1015262674586435602
    }
}
""".trimIndent()
        val result = Json.decodeFromString<BiliResult>(body)
            .check()
        val items = DynamicItems.build(result)

        for (dynamic in items.items) {
            assert(dynamic != null)
            if (dynamic != null) {
                assert(dynamic.extend_json != null)
                assert(dynamic.origin?.extend_json != null)
                assert(dynamic.origin?.type == DType.VIDEO)
                assert(dynamic.type == DType.REPOST)
                assert(dynamic.repost != null)
                assert(dynamic.desc != null)
                assert(dynamic.origin != null)
                assert(dynamic.origin?.video != null)
                assert(dynamic.origin?.desc != null)
                println(dynamic)
                val encodedstring = Json.encodeToString<Dynamic>(Dynamic.serializer(), dynamic)

                println(encodedstring)
            }
        }
    }

    @Test
    fun test_common_video() {
        val body = """
{
    "code": 0,
    "message": "0",
    "ttl": 1,
    "data": {
        "has_more": 1,
        "cards": [
            {
                "desc": {
                    "uid": 11336264,
                    "type": 8,
                    "rid": 113717983318927,
                    "acl": 0,
                    "view": 168701,
                    "repost": 9,
                    "comment": 222,
                    "like": 3437,
                    "is_liked": 1,
                    "dynamic_id": 1015443660247924788,
                    "timestamp": 1735264801,
                    "pre_dy_id": 0,
                    "orig_dy_id": 0,
                    "orig_type": 0,
                    "user_profile": {
                        "info": {
                            "uid": 11336264,
                            "uname": "TESTV官方频道",
                            "face": "https://i2.hdslb.com/bfs/face/34ccaf9461c67482e3164675c0036e94df18b7a7.jpg"
                        },
                        "card": {
                            "official_verify": {
                                "type": -1
                            }
                        },
                        "vip": {
                            "vipType": 2,
                            "vipDueDate": 1758038400000,
                            "dueRemark": "",
                            "accessStatus": 0,
                            "vipStatus": 1,
                            "vipStatusWarn": "",
                            "themeType": 0,
                            "label": {
                                "path": "",
                                "text": "年度大会员",
                                "label_theme": "annual_vip",
                                "text_color": "#FFFFFF",
                                "bg_style": 1,
                                "bg_color": "#FB7299",
                                "border_color": ""
                            },
                            "avatar_subscript": 1,
                            "nickname_color": "#FB7299",
                            "role": 3,
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
                        "sign": "我们不做评测，是体验！愉快的体验！tb店铺：TESTV值不值得买 | 官网：testv.cn",
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
                    "dynamic_id_str": "1015443660247924788",
                    "pre_dy_id_str": "0",
                    "orig_dy_id_str": "0",
                    "rid_str": "113717983318927",
                    "origin": null,
                    "bvid": "BV1J4C6YfEDz",
                    "previous": null
                },
                "card": "{\"aid\":113717983318927,\"cid\":27537181343,\"ctime\":1735264801,\"desc\":\"买了电竞耳机但是不玩游戏是种什么体验？只能说低延迟确实增色不少。\\n投票链接：https://testv.cn/portfolio/hongmibuds6prodianjingban/\",\"dimension\":{\"height\":2160,\"rotate\":0,\"width\":3840},\"duration\":784,\"dynamic\":\"男后期喜当爹\",\"first_frame\":\"http://i0.hdslb.com/bfs/storyff/n241226sa39jzr5pgk9s76leow210q85_firsti.jpg\",\"jump_url\":\"bilibili://video/113717983318927/?page=1\\u0026player_width=3840\\u0026player_height=2160\\u0026player_rotate=0\",\"owner\":{\"face\":\"https://i2.hdslb.com/bfs/face/34ccaf9461c67482e3164675c0036e94df18b7a7.jpg\",\"mid\":11336264,\"name\":\"TESTV官方频道\"},\"pic\":\"http://i2.hdslb.com/bfs/archive/e6da0b5f90e8fe6b76705b1a71903e196fc2738d.jpg\",\"pubdate\":1735264800,\"short_link_v2\":\"\",\"stat\":{\"aid\":113717983318927,\"coin\":1188,\"danmaku\":316,\"dislike\":0,\"favorite\":519,\"like\":3437,\"reply\":222,\"share\":76,\"view\":45020},\"state\":0,\"tid\":95,\"title\":\"有病！电竞耳机不玩游戏-红米Buds6 Pro电竞版【值不值得买第679期】\",\"tname\":\"数码\",\"videos\":1}",
                "extend_json": "{\"from\":{\"from\":\"\",\"emoji_type\":1},\"ctrl\":null,\"lott\":null}",
                "display": {
                    "origin": null,
                    "usr_action_txt": "投稿了视频",
                    "relation": {
                        "status": 2,
                        "is_follow": 1,
                        "is_followed": 0
                    },
                    "live_info": null,
                    "emoji_info": null,
                    "highlight": null
                }
            }
        ],
        "next_offset": 1015443660247924788
    }
}

""".trimIndent()
        val result = Json.decodeFromString<BiliResult>(body)
            .check()
        val items = DynamicItems.build(result)

        for (dynamic in items.items) {
            assert(dynamic != null)
            if (dynamic != null) {
                assert(dynamic.extend_json != null)
                assert(dynamic.origin?.extend_json == null)
                assert(dynamic.origin?.type != DType.VIDEO)
                assert(dynamic.type == DType.VIDEO)
                assert(dynamic.repost == null)
                assert(dynamic.desc != null)
                assert(dynamic.video != null)
                assert(dynamic.origin == null)
                assert(dynamic.origin?.video == null)
                assert(dynamic.origin?.desc == null)
                println(dynamic)
                val encodedstring = Json.encodeToString<Dynamic>(Dynamic.serializer(), dynamic)

                println(encodedstring)
            }
        }
    }
}