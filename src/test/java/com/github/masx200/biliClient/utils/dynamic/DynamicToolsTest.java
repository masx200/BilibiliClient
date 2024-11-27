package com.github.masx200.biliClient.utils.dynamic;

import com.github.masx200.biliClient.BiliClient;
import com.github.masx200.biliClient.BiliClientFactor;
import org.junit.Test;

/**
 * 描述： 分析工具测试
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-08-15:36
 * @since 2021-02-08-15:36
 */
public class DynamicToolsTest {


    @Test
    public void queryData() throws Exception {
        BiliClient biliClient = BiliClientFactor.getClient((requestBase) -> requestBase.setHeader("cookie", "buvid3=BA62F2E5-EA88-7BC6-01ED-C5855BE1B54206095infoc; b_nut=1729324706; buvid4=75C4D7D7-A04A-F0B5-12E1-74FFBF47404738664-024101907-s9FFyawkfId5TZ3cskKUTA%3D%3D; DedeUserID=27919054; DedeUserID__ckMd5=b49996211ff5fbd5; _uuid=5498164E-19D9-C5F9-73AF-AD1E2344D83997843infoc; CURRENT_FNVAL=4048; rpdid=|(u~||u)|)mu0J'u~kmJkRmlu; header_theme_version=CLOSE; enable_web_push=DISABLE; home_feed_column=5; browser_resolution=1707-932; LIVE_BUVID=AUTO3417300333706425; hit-dyn-v2=1; fingerprint=edb02e588a73229a8b1fa7c5a0356671; buvid_fp_plain=undefined; buvid_fp=edb02e588a73229a8b1fa7c5a0356671; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MzI2MjQwMTksImlhdCI6MTczMjM2NDc1OSwicGx0IjotMX0.gWy0KoxRuGGE6xXhtxYB7N-tbFnQe3bX3JZIEHI7GLE; bili_ticket_expires=1732623959; SESSDATA=db98d970%2C1747916820%2C8ac23%2Ab2CjAniQXJ8hmz4KC7IbU2ER_XydjlkNe0fnuwYZDxl465NcOE6hAZPVeH_0Uj9QYtu6wSVjJ4RkJqaXZuUW9iS0ZGbVdtTFM1OXFvMzgtRVdVV1hLLWlhcEFuQW1KVm9hVnBmNkRIQndZSHJKV0kzOVRKdVpadkY4R1hMOHBUR1V3QVdldmM4cFJnIIEC; bili_jct=7f980dd81f7ff0573be461f5b0d98a6b; PVID=3; bp_t_offset_27919054=1003616544338477056"));
        DynamicSortInfo dynamicSortInfo = DynamicTools.queryData(biliClient, 5548903L);
//        System.out.println(dynamicSortInfo);


        System.out.println("______________________");
        System.out.println("总动态" + dynamicSortInfo.getCount());
        System.out.println("总阅读" + dynamicSortInfo.getViewAll());
        System.out.println("总点赞" + dynamicSortInfo.getLikeAll());
        System.out.println("总转发" + dynamicSortInfo.getRepostAll());
        System.out.println("总评论" + dynamicSortInfo.getCommentAll());
        System.out.println("总硬币" + dynamicSortInfo.getCoinAll());

        System.out.println("________________分类______________");
        dynamicSortInfo.getSortInfo().forEach((type, dynamicInfo) -> {
            System.out.println("________________" + type + "______________");
            System.out.println(type + "总动态" + dynamicInfo.getCount());
            System.out.println(type + "总阅读" + dynamicInfo.getViewAll());
            System.out.println(type + "总点赞" + dynamicInfo.getLikeAll());
            System.out.println(type + "总转发" + dynamicInfo.getRepostAll());
            System.out.println(type + "总评论" + dynamicInfo.getCommentAll());
            System.out.println(type + "总硬币" + dynamicInfo.getCoinAll());
        });

    }
}