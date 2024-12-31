package com.github.masx200.biliClient

import com.github.masx200.biliClient.client.BaseClient
import com.github.masx200.biliClient.exception.BiliRequestException
import java.util.function.Consumer
import kotlinx.serialization.json.Json
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpRequestBase
import org.apache.http.util.EntityUtils

//import com.alibaba.fastjson.JSONObject;

/**
 * 描述： 发起请求
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-07-15:18
 * @since 2021-02-07-15:18
 */
object BiliCall {
    /**
     * 进行请求
     *
     * @param httpRequest 请求
     * @param baseClient  请求客户端
     * @return 响应结果
     */
    @JvmOverloads
    fun doCall(
        httpRequest: HttpRequestBase,
        baseClient: BaseClient,
        beforeRequest: Consumer<HttpRequestBase?>? = null
    ): BiliResult {
        var rawbody: String? = null
        try {
            // 获取请求客户端
            val httpClient = baseClient.getHttpClient()
            val requestConfig = baseClient.getRequestConfig()
            httpRequest.config = requestConfig
            val headershashMap: MutableMap<String?, String?> = object : HashMap<String?, String?>() {
                init {
                    put(
                        "accept",
                        "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"
                    )
                    put("accept-encoding", "gzip") //, deflate, br, zstd");
                    put("accept-language", "zh-CN,zh;q=0.9")
                    put("cache-control", "max-age=0")
                    put("priority", "u=0, i")
                    put(
                        "sec-ch-ua", """
                        "Google Chrome";v="131", "Chromium";v="131", "Not_A Brand";v="24"
                        
                        """.trimIndent()
                    )
                    put("sec-ch-ua-mobile", "?0")
                    put(
                        "sec-ch-ua-platform", """
                        "Windows"
                        
                        """.trimIndent()
                    )
                    put(
                        "sec-fetch-dest",
                        "document"
                    )
                    put(
                        "sec-fetch-mode",
                        "navigate"
                    )
                    put(
                        "sec-fetch-site",
                        "none"
                    )
                    put(
                        "sec-fetch-user",
                        "?1"
                    )
                    put("upgrade-insecure-requests:", "1")
                    put(
                        "user-agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36"
                    )
                    put("host", DomainExtractor.getDomainFromHttpRequest(httpRequest))
//                    put("Referer", httpRequest.uri.toString())
                }
            }

            for (key in headershashMap.keys) {
                httpRequest.setHeader(key, headershashMap.get(key))
            }

            if (beforeRequest != null) {
                beforeRequest.accept(httpRequest)
            }
            //           httpRequest.setHeader("cookie", "buvid3=BA62F2E5-EA88-7BC6-01ED-C5855BE1B54206095infoc; b_nut=1729324706; buvid4=75C4D7D7-A04A-F0B5-12E1-74FFBF47404738664-024101907-s9FFyawkfId5TZ3cskKUTA%3D%3D; DedeUserID=27919054; DedeUserID__ckMd5=b49996211ff5fbd5; _uuid=5498164E-19D9-C5F9-73AF-AD1E2344D83997843infoc; CURRENT_FNVAL=4048; rpdid=|(u~||u)|)mu0J'u~kmJkRmlu; header_theme_version=CLOSE; enable_web_push=DISABLE; home_feed_column=5; browser_resolution=1707-932; LIVE_BUVID=AUTO3417300333706425; hit-dyn-v2=1; fingerprint=edb02e588a73229a8b1fa7c5a0356671; buvid_fp_plain=undefined; buvid_fp=edb02e588a73229a8b1fa7c5a0356671; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MzI2MjQwMTksImlhdCI6MTczMjM2NDc1OSwicGx0IjotMX0.gWy0KoxRuGGE6xXhtxYB7N-tbFnQe3bX3JZIEHI7GLE; bili_ticket_expires=1732623959; SESSDATA=db98d970%2C1747916820%2C8ac23%2Ab2CjAniQXJ8hmz4KC7IbU2ER_XydjlkNe0fnuwYZDxl465NcOE6hAZPVeH_0Uj9QYtu6wSVjJ4RkJqaXZuUW9iS0ZGbVdtTFM1OXFvMzgtRVdVV1hLLWlhcEFuQW1KVm9hVnBmNkRIQndZSHJKV0kzOVRKdVpadkY4R1hMOHBUR1V3QVdldmM4cFJnIIEC; bili_jct=7f980dd81f7ff0573be461f5b0d98a6b; PVID=3; bp_t_offset_27919054=1003616544338477056");
            // 发起请求
            val response = httpClient.execute(httpRequest)

            //            System.out.println(httpRequest.getMethod());
//            System.out.println(httpRequest.getURI());
//            System.out.println(response.getStatusLine());
            val statusCode = response.statusLine.statusCode
            if (statusCode == 412) {

                throw BiliRequestException(
                    "由于触发哔哩哔哩安全风控策略，该次访问请求被拒绝。",
                    {
                        uri = httpRequest.uri
                        path = httpRequest.uri.path
                        this.statusCode = statusCode

                        this.method = httpRequest.method
                    }
                )
            }
            if (statusCode != 200) {
                throw BiliRequestException(
                    httpRequest.uri,
                    "请求地址：" + httpRequest.uri + "，请求方法：" + httpRequest.method + "，请求失败，状态码: " + statusCode
                )
            }
            // 判空
            val body = EntityUtils.toString(response.entity)
            if (body == null || body.isEmpty()) {
                throw Exception("响应体为空")
            }
            rawbody = body
            // 转换
            return Json /* { ignoreUnknownKeys = true } */.decodeFromString<BiliResult>(body)
                .check()
        } catch (e: BiliRequestException) {
//            System.err.println(e.message)
//            e.printStackTrace()
            throw e
        } catch (e: Exception) {
            System.err.println(e.message)
            e.printStackTrace()
            rawbody?.let { System.err.println(Json /* { ignoreUnknownKeys = true } */.decodeFromString<BiliResult>(it)) }
            throw BiliRequestException(httpRequest.uri, e.message)
        }
    }

    /**
     * 默认Get 请求
     *
     * @param request 请求
     * @return 响应结果
     */
    fun doCall(request: BiliRequest): BiliResult {
        return doCall(HttpGet(request.uri), request.baseClient, null)
    }

    fun doCall(request: BiliRequest, beforeRequest: Consumer<HttpRequestBase?>?): BiliResult {
        return doCall(HttpGet(request.uri), request.baseClient, beforeRequest)
    }
}
