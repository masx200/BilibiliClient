package com.github.masx200.biliClient.utils;

import com.github.masx200.biliClient.BiliClient;
import com.github.masx200.biliClient.BiliClientFactor;
import com.github.masx200.biliClient.model.dynamic.Dynamic;
import com.github.masx200.biliClient.model.dynamic.DynamicItems;
import com.github.masx200.biliClient.model.user.User;
import com.github.masx200.biliClient.model.video.Video;
import org.junit.Test;

/**
 * 描述： View转换工具
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-20-15:31
 * @since 2021-02-20-15:31
 */
public class TransViewUriTest {
    BiliClient biliClient = BiliClientFactor.getClient((requestBase) -> requestBase.setHeader("cookie", "buvid3=BA62F2E5-EA88-7BC6-01ED-C5855BE1B54206095infoc; b_nut=1729324706; buvid4=75C4D7D7-A04A-F0B5-12E1-74FFBF47404738664-024101907-s9FFyawkfId5TZ3cskKUTA%3D%3D; DedeUserID=27919054; DedeUserID__ckMd5=b49996211ff5fbd5; _uuid=5498164E-19D9-C5F9-73AF-AD1E2344D83997843infoc; CURRENT_FNVAL=4048; rpdid=|(u~||u)|)mu0J'u~kmJkRmlu; header_theme_version=CLOSE; enable_web_push=DISABLE; home_feed_column=5; browser_resolution=1707-932; LIVE_BUVID=AUTO3417300333706425; hit-dyn-v2=1; fingerprint=edb02e588a73229a8b1fa7c5a0356671; buvid_fp_plain=undefined; buvid_fp=edb02e588a73229a8b1fa7c5a0356671; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MzI2MjQwMTksImlhdCI6MTczMjM2NDc1OSwicGx0IjotMX0.gWy0KoxRuGGE6xXhtxYB7N-tbFnQe3bX3JZIEHI7GLE; bili_ticket_expires=1732623959; SESSDATA=db98d970%2C1747916820%2C8ac23%2Ab2CjAniQXJ8hmz4KC7IbU2ER_XydjlkNe0fnuwYZDxl465NcOE6hAZPVeH_0Uj9QYtu6wSVjJ4RkJqaXZuUW9iS0ZGbVdtTFM1OXFvMzgtRVdVV1hLLWlhcEFuQW1KVm9hVnBmNkRIQndZSHJKV0kzOVRKdVpadkY4R1hMOHBUR1V3QVdldmM4cFJnIIEC; bili_jct=7f980dd81f7ff0573be461f5b0d98a6b; PVID=3; bp_t_offset_27919054=1003616544338477056"));

    @Test
    public void transUser() {
        User user = biliClient.user().withUID(5548903L).get();
        System.out.println(user);
        System.out.println(TransViewUri.trans(user));
    }

    @Test
    public void transDynamic() throws Exception {
        Dynamic dynamic = biliClient.dynamic().withDynamicId(464864767376633630L).get();
        System.out.println(dynamic);
        System.out.println(TransViewUri.trans(dynamic));
        System.out.println("############");
        DynamicItems list = biliClient.dynamic().withHostUid(392819792L).list();
        list.getItems().stream().map(TransViewUri::trans).forEach(System.out::println);
    }

    @Test
    public void transVideo() {
        Video video = biliClient.video().withBvid("BV1nz4y1r7TW").get();
        System.out.println(video);
        System.out.println(TransViewUri.trans(video));
    }

    @Test
    public void BvidToAvid() {
        System.out.println(TransViewUri.BvidToAvid("BV1nz4y1r7TW"));
    }

    @Test
    public void avidToBvid() {
        System.out.println(TransViewUri.AvidToBvid(19890604L));
    }
}