package com.github.masx200.biliClient.api.user

import com.github.masx200.biliClient.BiliClientFactor.getClient
import com.github.masx200.biliClient.BiliResult
import com.github.masx200.biliClient.model.user.User
import java.util.function.Consumer
import kotlin.test.Test
import kotlinx.serialization.json.Json
import org.apache.http.client.methods.HttpRequestBase

/**
 * 描述： 用户测试
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-19:22
 * @since 2021-02-07-19:22
 */
class IUserConditionTest {
    private val biliClient = getClient(Consumer { requestBase: HttpRequestBase? ->
        requestBase!!.setHeader(
            "cookie",
            "buvid3=BA62F2E5-EA88-7BC6-01ED-C5855BE1B54206095infoc; b_nut=1729324706; buvid4=75C4D7D7-A04A-F0B5-12E1-74FFBF47404738664-024101907-s9FFyawkfId5TZ3cskKUTA%3D%3D; DedeUserID=27919054; DedeUserID__ckMd5=b49996211ff5fbd5; _uuid=5498164E-19D9-C5F9-73AF-AD1E2344D83997843infoc; CURRENT_FNVAL=4048; rpdid=|(u~||u)|)mu0J'u~kmJkRmlu; header_theme_version=CLOSE; enable_web_push=DISABLE; home_feed_column=5; browser_resolution=1707-932; LIVE_BUVID=AUTO3417300333706425; hit-dyn-v2=1; fingerprint=edb02e588a73229a8b1fa7c5a0356671; buvid_fp_plain=undefined; buvid_fp=edb02e588a73229a8b1fa7c5a0356671; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MzI2MjQwMTksImlhdCI6MTczMjM2NDc1OSwicGx0IjotMX0.gWy0KoxRuGGE6xXhtxYB7N-tbFnQe3bX3JZIEHI7GLE; bili_ticket_expires=1732623959; SESSDATA=db98d970%2C1747916820%2C8ac23%2Ab2CjAniQXJ8hmz4KC7IbU2ER_XydjlkNe0fnuwYZDxl465NcOE6hAZPVeH_0Uj9QYtu6wSVjJ4RkJqaXZuUW9iS0ZGbVdtTFM1OXFvMzgtRVdVV1hLLWlhcEFuQW1KVm9hVnBmNkRIQndZSHJKV0kzOVRKdVpadkY4R1hMOHBUR1V3QVdldmM4cFJnIIEC; bili_jct=7f980dd81f7ff0573be461f5b0d98a6b; PVID=3; bp_t_offset_27919054=1003616544338477056"
        )
    })

    @Test
    fun withUID() {
        val user = biliClient.user().withUID(392819792L).get()!!
        println(user)
        println(user.birthday)
        println(user.name)
        println(user.official)
    }

    @Test
    fun withMe() {
        val user = biliClient.user().withMe().get()
        println(user)
        println(user!!.birthday)
        println(user.name)
        println(user.official)
    }


    @Test
    fun withUIDLocalData() {

        val body = """{
    "code": 0,
    "message": "0",
    "ttl": 1,
    "data": {
        "mid": 392819792,
        "name": "武汉纺织大学",
        "sex": "男",
        "face": "https://i2.hdslb.com/bfs/face/b1119b1d6f0b77a5e3d9ff39cddd2de5474dfad0.jpg",
        "face_nft": 0,
        "face_nft_type": 0,
        "sign": "嗨!! 我是WTU!!  不一样的WTU！WTU IN BILhttps://t.bilibili.com/IBILI!",
        "rank": 10000,
        "level": 5,
        "jointime": 0,
        "moral": 0,
        "silence": 0,
        "coins": 0,
        "fans_badge": true,
        "fans_medal": {
            "show": false,
            "wear": false,
            "medal": null
        },
        "official": {
            "role": 6,
            "title": "武汉纺织大学官方账号",
            "desc": "",
            "type": 1
        },
        "vip": {
            "type": 1,
            "status": 0,
            "due_date": 1612281600000,
            "vip_pay_type": 0,
            "theme_type": 0,
            "label": {
                "path": "",
                "text": "",
                "label_theme": "",
                "text_color": "",
                "bg_style": 0,
                "bg_color": "",
                "border_color": "",
                "use_img_label": true,
                "img_label_uri_hans": "",
                "img_label_uri_hant": "",
                "img_label_uri_hans_static": "https://i0.hdslb.com/bfs/vip/d7b702ef65a976b20ed854cbd04cb9e27341bb79.png",
                "img_label_uri_hant_static": "https://i0.hdslb.com/bfs/activity-plat/static/20220614/e369244d0b14644f5e1a06431e22a4d5/KJunwh19T5.png"
            },
            "avatar_subscript": 0,
            "nickname_color": "",
            "role": 0,
            "avatar_subscript_url": "",
            "tv_vip_status": 0,
            "tv_vip_pay_type": 0,
            "tv_due_date": 0,
            "avatar_icon": {
                "icon_resource": {}
            }
        },
        "pendant": {
            "pid": 0,
            "name": "",
            "image": "",
            "expire": 0,
            "image_enhance": "",
            "image_enhance_frame": "",
            "n_pid": 0
        },
        "nameplate": {
            "nid": 0,
            "name": "",
            "image": "",
            "image_small": "",
            "level": "",
            "condition": ""
        },
        "user_honour_info": {
            "mid": 0,
            "colour": null,
            "tags": [],
            "is_latest_100honour": 0
        },
        "is_followed": false,
        "top_photo": "http://i2.hdslb.com/bfs/space/6e799ff2de2de55d27796707a283068d66cdf3f4.png",
        "theme": {},
        "sys_notice": {},
        "live_room": {
            "roomStatus": 1,
            "liveStatus": 0,
            "url": "https://live.bilibili.com/21566872?broadcast_type=0\u0026is_room_feed=1",
            "title": "武汉纺织大学小纺带你逛南湖",
            "cover": "https://i0.hdslb.com/bfs/live/new_room_cover/2f5c58c8fdf0bb3563533448c397fcd94e452911.jpg",
            "roomid": 21566872,
            "roundStatus": 1,
            "broadcast_type": 0,
            "watched_show": {
                "switch": true,
                "num": 2,
                "text_small": "2",
                "text_large": "2人看过",
                "icon": "https://i0.hdslb.com/bfs/live/a725a9e61242ef44d764ac911691a7ce07f36c1d.png",
                "icon_location": "",
                "icon_web": "https://i0.hdslb.com/bfs/live/8d9d0f33ef8bf6f308742752d13dd0df731df19c.png"
            }
        },
        "birthday": "10-18",
        "school": {
            "name": "武汉纺织大学"
        },
        "profession": {
            "name": "",
            "department": "",
            "title": "",
            "is_show": 0
        },
        "tags": [
            "武汉纺织大学",
            "高校",
            "官方"
        ],
        "series": {
            "user_upgrade_status": 3,
            "show_upgrade_window": false
        },
        "is_senior_member": 0,
        "mcn_info": null,
        "gaia_res_type": 0,
        "gaia_data": null,
        "is_risk": false,
        "elec": {
            "show_info": {
                "show": true,
                "state": 3,
                "title": "充电",
                "icon": "https://i0.hdslb.com/bfs/garb/item/33e2e72d9a0c855f036b4cb55448f44af67a0635.png",
                "jump_url": "https://www.bilibili.com/h5/upower/index?mid=392819792\u0026navhide=1\u0026oid=392819792"
            }
        },
        "contract": {
            "is_display": false,
            "is_follow_display": false
        },
        "certificate_show": false,
        "name_render": null
    }
}"""
        val result = Json.decodeFromString<BiliResult>(body)
            .check()
        val user = result.toData<User>()
        println(user)
        println(user.birthday)
        println(user.name)
        println(user.official)
    }
}