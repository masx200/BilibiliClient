package com.github.masx200.biliClient.utils

import com.github.masx200.biliClient.BiliClient
import com.github.masx200.biliClient.BiliClientFactor.getClient
import com.github.masx200.biliClient.BiliResult
import com.github.masx200.biliClient.model.dynamic.Dynamic
import com.github.masx200.biliClient.model.video.Video
import java.util.function.Consumer
import kotlin.test.Test
import kotlinx.serialization.json.Json
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述： View转换工具
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-20-15:31
 * @since 2021-02-20-15:31
 */
class TransViewUriTest {
    var biliClient: BiliClient = getClient(Consumer { requestBase: HttpRequestBase? ->
        requestBase!!.setHeader(
            "cookie",
            "buvid3=BA62F2E5-EA88-7BC6-01ED-C5855BE1B54206095infoc; b_nut=1729324706; buvid4=75C4D7D7-A04A-F0B5-12E1-74FFBF47404738664-024101907-s9FFyawkfId5TZ3cskKUTA%3D%3D; DedeUserID=27919054; DedeUserID__ckMd5=b49996211ff5fbd5; _uuid=5498164E-19D9-C5F9-73AF-AD1E2344D83997843infoc; CURRENT_FNVAL=4048; rpdid=|(u~||u)|)mu0J'u~kmJkRmlu; header_theme_version=CLOSE; enable_web_push=DISABLE; home_feed_column=5; browser_resolution=1707-932; LIVE_BUVID=AUTO3417300333706425; hit-dyn-v2=1; fingerprint=edb02e588a73229a8b1fa7c5a0356671; buvid_fp_plain=undefined; buvid_fp=edb02e588a73229a8b1fa7c5a0356671; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MzI2MjQwMTksImlhdCI6MTczMjM2NDc1OSwicGx0IjotMX0.gWy0KoxRuGGE6xXhtxYB7N-tbFnQe3bX3JZIEHI7GLE; bili_ticket_expires=1732623959; SESSDATA=db98d970%2C1747916820%2C8ac23%2Ab2CjAniQXJ8hmz4KC7IbU2ER_XydjlkNe0fnuwYZDxl465NcOE6hAZPVeH_0Uj9QYtu6wSVjJ4RkJqaXZuUW9iS0ZGbVdtTFM1OXFvMzgtRVdVV1hLLWlhcEFuQW1KVm9hVnBmNkRIQndZSHJKV0kzOVRKdVpadkY4R1hMOHBUR1V3QVdldmM4cFJnIIEC; bili_jct=7f980dd81f7ff0573be461f5b0d98a6b; PVID=3; bp_t_offset_27919054=1003616544338477056"
        )
    })

    @Test
    fun transVideoDynamicUserUser() {
        val user = biliClient.user().withUID(5548903L).get()
        println(user)
        println(TransViewUri.transUser(user))
    }

    @Test
    @Throws(Exception::class)
    fun transVideoDynamicUserDynamic() {
        val dynamic = biliClient.dynamic().withDynamicId(464864767376633630L).get()
        println(dynamic)
        println(TransViewUri.transDynamic(dynamic))
        println("############")
        val list = biliClient.dynamic().withHostUid(392819792L).list()
        list!!.items.stream().map<String?> { dynamic: Dynamic? -> TransViewUri.transDynamic(dynamic) }
            .forEach { x: String? -> println(x) }
    }

    @Test
    fun transVideoDynamicUserVideo() {
        val video = biliClient.video().withBvid("BV1nz4y1r7TW").get()
        println(video)
        println(TransViewUri.transVideo(video))
    }

    @Test
    fun BvidToAvid() {
        println(TransViewUri.BvidToAvid("BV1nz4y1r7TW"))
    }

    @Test
    fun avidToBvid() {
        println(TransViewUri.AvidToBvid(19890604L))
    }

    @Test
    fun transVideoDynamicUserVideoLocalData() {
        val body = """{
    "code": 0,
    "message": "0",
    "ttl": 1,
    "data": {
        "bvid": "BV1nz4y1r7TW",
        "aid": 585760422,
        "videos": 1,
        "tid": 124,
        "tid_v2": 0,
        "tname": "社科·法律·心理",
        "tname_v2": "",
        "copyright": 1,
        "pic": "http://i0.hdslb.com/bfs/archive/d4a6856871141da5d8b7d72191fcdef3d6b66066.jpg",
        "title": "【眉山论剑】留给特朗普的时间不多了，我们该“帮”他一把了",
        "pubdate": 1608724905,
        "ctime": 1608724905,
        "desc": "眉山论剑  ·  给特朗普最后的上中下策",
        "desc_v2": [
            {
                "raw_text": "眉山论剑  ·  给特朗普最后的上中下策",
                "type": 1,
                "biz_id": 0
            }
        ],
        "state": 0,
        "duration": 892,
        "mission_id": 15417,
        "rights": {
            "bp": 0,
            "elec": 0,
            "download": 1,
            "movie": 0,
            "pay": 0,
            "hd5": 1,
            "no_reprint": 1,
            "autoplay": 1,
            "ugc_pay": 0,
            "is_cooperation": 0,
            "ugc_pay_preview": 0,
            "no_background": 0,
            "clean_mode": 0,
            "is_stein_gate": 0,
            "is_360": 0,
            "no_share": 0,
            "arc_pay": 0,
            "free_watch": 0
        },
        "owner": {
            "mid": 526559715,
            "name": "陈平眉山论剑",
            "face": "https://i0.hdslb.com/bfs/face/8bb0b1ea83b892a1f396bd75849d60b61a49273f.jpg"
        },
        "stat": {
            "aid": 585760422,
            "view": 335521,
            "danmaku": 4031,
            "reply": 822,
            "favorite": 2155,
            "coin": 4987,
            "share": 725,
            "now_rank": 0,
            "his_rank": 0,
            "like": 23581,
            "dislike": 0,
            "evaluation": "",
            "vt": 0
        },
        "argue_info": {
            "argue_msg": "",
            "argue_type": 0,
            "argue_link": ""
        },
        "dynamic": "离1月20号总统交接，不到一个月了。特朗普如果还想得和平奖，还想成为“美国史上最伟大的总统”，还想为美国老百姓和世界做出一点贡献，还想为拜登“埋雷”以及卸任后过得稍微好点，那他可以在剩下的一个月里做很多事情：撤离驻韩国的军队，甚至从德国和日本撤军，特朗普已经减少了驻德国一半的美军了，如果接着做下去，对世界各国包括美国和特朗普自己，都是有很大好处的。#美国大选##特朗普##陈平#",
        "cid": 271964298,
        "dimension": {
            "width": 1920,
            "height": 1080,
            "rotate": 0
        },
        "premiere": null,
        "teenage_mode": 0,
        "is_chargeable_season": false,
        "is_story": false,
        "is_upower_exclusive": false,
        "is_upower_play": false,
        "is_upower_preview": false,
        "enable_vt": 0,
        "vt_display": "",
        "no_cache": false,
        "pages": [
            {
                "cid": 271964298,
                "page": 1,
                "from": "vupload",
                "part": "给特朗普最后的上中下策",
                "duration": 892,
                "vid": "",
                "weblink": "",
                "dimension": {
                    "width": 1920,
                    "height": 1080,
                    "rotate": 0
                }
            }
        ],
        "subtitle": {
            "allow_submit": false,
            "list": [
                {
                    "id": 1107760229548060160,
                    "lan": "ai-zh",
                    "lan_doc": "中文（自动生成）",
                    "is_lock": false,
                    "subtitle_url": "",
                    "type": 1,
                    "id_str": "1107760229548060160",
                    "ai_type": 0,
                    "ai_status": 2,
                    "author": {
                        "mid": 0,
                        "name": "",
                        "sex": "",
                        "face": "",
                        "sign": "",
                        "rank": 0,
                        "birthday": 0,
                        "is_fake_account": 0,
                        "is_deleted": 0,
                        "in_reg_audit": 0,
                        "is_senior_member": 0,
                        "name_render": null
                    }
                }
            ]
        },
        "is_season_display": false,
        "user_garb": {
            "url_image_ani_cut": ""
        },
        "honor_reply": {
            "honor": [
                {
                    "aid": 585760422,
                    "type": 4,
                    "desc": "热门",
                    "weekly_recommend_num": 0
                },
                {
                    "aid": 585760422,
                    "type": 7,
                    "desc": "热门收录",
                    "weekly_recommend_num": 0
                }
            ]
        },
        "like_icon": "",
        "need_jump_bv": false,
        "disable_show_up_info": false,
        "is_story_play": 1,
        "is_view_self": false
    }
}"""
        val result = Json.decodeFromString<BiliResult>(body)
            .check()
        val video = result.toData<Video>()
        println(video)
        println((TransViewUri.transVideo(video)))
    }

}