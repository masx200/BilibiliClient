package com.github.masx200.biliClient.api.dynamic

import com.github.masx200.biliClient.BiliClient
import com.github.masx200.biliClient.BiliClientFactor
import com.github.masx200.biliClient.exception.BiliRequestException
import com.github.masx200.biliClient.model.dynamic.Dynamic
import java.util.function.Consumer
import org.apache.http.client.methods.HttpRequestBase
import kotlin.test.Test

/**
 * 描述： 动态测试
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-21:49
 * @since 2021-02-07-21:49
 */
class IDynamicConditionTest {
    private val biliClient: BiliClient = BiliClientFactor.getClient(Consumer { requestBase: HttpRequestBase? ->
        requestBase!!.setHeader(
            "cookie",
            "buvid3=BA62F2E5-EA88-7BC6-01ED-C5855BE1B54206095infoc; b_nut=1729324706; buvid4=75C4D7D7-A04A-F0B5-12E1-74FFBF47404738664-024101907-s9FFyawkfId5TZ3cskKUTA%3D%3D; DedeUserID=27919054; DedeUserID__ckMd5=b49996211ff5fbd5; _uuid=5498164E-19D9-C5F9-73AF-AD1E2344D83997843infoc; CURRENT_FNVAL=4048; rpdid=|(u~||u)|)mu0J'u~kmJkRmlu; header_theme_version=CLOSE; enable_web_push=DISABLE; home_feed_column=5; browser_resolution=1707-932; LIVE_BUVID=AUTO3417300333706425; hit-dyn-v2=1; fingerprint=edb02e588a73229a8b1fa7c5a0356671; buvid_fp_plain=undefined; buvid_fp=edb02e588a73229a8b1fa7c5a0356671; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MzI2MjQwMTksImlhdCI6MTczMjM2NDc1OSwicGx0IjotMX0.gWy0KoxRuGGE6xXhtxYB7N-tbFnQe3bX3JZIEHI7GLE; bili_ticket_expires=1732623959; SESSDATA=db98d970%2C1747916820%2C8ac23%2Ab2CjAniQXJ8hmz4KC7IbU2ER_XydjlkNe0fnuwYZDxl465NcOE6hAZPVeH_0Uj9QYtu6wSVjJ4RkJqaXZuUW9iS0ZGbVdtTFM1OXFvMzgtRVdVV1hLLWlhcEFuQW1KVm9hVnBmNkRIQndZSHJKV0kzOVRKdVpadkY4R1hMOHBUR1V3QVdldmM4cFJnIIEC; bili_jct=7f980dd81f7ff0573be461f5b0d98a6b; PVID=3; bp_t_offset_27919054=1003616544338477056"
        )
    })

    @Test
    fun withDynamicIdForward() {
        val dynamic = biliClient.dynamic().withDynamicId(484920426409631452L).get()
        println(dynamic)
        println(dynamic.data!!.createTime())
    }

    @Test
    fun withDynamicId() {
        val dynamic = biliClient.dynamic().withDynamicId(485425544628969967L).get()
        println(dynamic)
        println(dynamic.data!!.createTime())
        println(dynamic.data!!.updateTime())
    }

    @Test
    @Throws(Exception::class)
    fun withHostUid() {
        val list = biliClient.dynamic().withHostUid(392819792L).list()
        println(list)
        list.items.forEach(Consumer { x: Dynamic? -> println(x) })
        println(list.items.get(0)!!.data)
        println(list.items.get(0)!!.data!!.view)
        if (list.items.get(0)!!.detail != null) {
            println(list.items.get(0)!!.detail!!.description)
        }

        println(list.items.get(0)!!.uid)
        println(list.items.get(0)!!.name)
    }

    @Test
    @Throws(Exception::class)
    fun withHostUidOffset() {
        val list = biliClient.dynamic().withHostUid(392819792L).list()
        println(list)
        println("__________________")
        val list1 = biliClient.dynamic().withHostUid(392819792L).list(list.nextOffset)
        println(list1)
    }


    @Test
    fun withHostUidOffsetLimit() {
        try {
            biliClient.dynamic().withHostUid(392819792L).list(20L, 30L)
        } catch (e: BiliRequestException) {
            e.printStackTrace()
        }
    }
}