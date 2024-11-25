<h1 align="center">BilibiliClient</h1>

BilibiliClient —— 基于HttpClient 的 哔哩哔哩 API ,根据JSON反向完成的BiliBili
Java 包 **将会持续更新**

# 最近更新

2021/2/20 添加对象公共方法 creatTime和updateTime 对时间进行转换

# 使用方法

（以目前版本为例 1.0.2)

## 1、引入

可以通过Jar 包下载的方式导入 (不推荐)

推荐使用Maven或其他包管理工具引入(见MavenSearch)

```xml
<dependency>
    <groupId>com.github.masx200</groupId>
    <artifactId>BilibiliClient</artifactId>
    <version>1.0.2</version>
</dependency>
```

## 2、配置

调用 `BaseClientConfig`的静态方法对相关属进行配置，目前支持如下配置

```java
public class Config {
    public static void main(String[] args) {
        // 协议
      BaseClientConfig.setProtocol(/*String*/ protocol);
        // 服务host
      BaseClientConfig.setHost(/*String*/ host);
        // 服务host Vc
      BaseClientConfig.setHostVc(/*String*/ hostVc);
        // 配置端口
      BaseClientConfig.setPort(/*Integer*/ port);
        // 配置请求
      BaseClientConfig.setRequestConfig(/*RequestConfig*/ config);

        // 配置仅对 之后 执行的请求有效 且会 更改 之后的全部全局配置
    }
}
```

## 3、使用

```java
public class Test {
    public static void main(String[] args) {
        // 实例化应该 BiliClient 对象
        BiliClient biliClient = BiliClientFactor.getClient();
        // 调用 Client 对象的 相关条件方法
        BiliCondition biliCondition = biliClient.video();
        // 设置条件参数
        BiliAbel<?> able = biliCondition.withBvid("BV1Ut4y1X7SS");
        // 获取 get 单个、list 多个   add delete update 暂不支持
        Video video = able.get();

        // 一般直接执行链式调用
        DynamicItems list = biliClient.dynamic.withHostUid(392819792L).list();

        // 其中 list 调用 可以传入 偏移或分页参数
    }
}
```

**其他使用方法请参考单元测试类**

**使用参考文档:
[IDEA JAVA使用BilibiliClient抓取哔哩哔哩用户动态等数据信息](https://blog.csdn.net/XiaoYunKuaiFei/article/details/113802710)**

# 目前支持

- `Dynamic 动态` [动态文档](docs/动态dynamic/Dynamic.md)
  - 根据动态ID获取动态数据
  - 根据用户ID获取用户动态列表(目前支持普通动态、视频动态、转发动态)
- `User 用户相关` [用户文档](docs/用户user/User.md)
  - 根据用户ID获取用户详情
  - 获取当前登录用户信息
- `Relation 用户关系` [关系文档](docs/关系relation/Relation.md)
  - 根据用户ID获取用户粉丝详情
  - 根据用户ID获取用户关注详情
- `Video 视频相关` [视频文档](docs/视频video/Video.md)
  - 根据AV获取视频信息
  - 根据BV获取视频信息

- `DynamicTools` 包含一些静态方法**对动态进行分类和数据整理**

# 参考鸣谢

- [`bilibili-API-collect` API对照参考](https://github.com/SocialSisterYi/bilibili-API-collect)
- [`yujincheng08` 提供的接口文档](https://github.com/yujincheng08)

# 说明

1. 本项目遵守MIT协议,基于本项目的任何开发请保留License
2. **本项目仅用于学习目的！** 因使用本项目而导致的各种情况均与开发者无关
3. 若因不可抗力或小破站要求,本项目可能随时中止或存档

# 添加cookie

由于有些接口需要登录才能使用，所以需要添加cookie。

```java
public class IDynamicConditionTest {
  private final BiliClient biliClient = BiliClientFactor.getClient((requestBase) -> requestBase.setHeader("cookie", "buvid3=BA62F2E5-EA88-7BC6-01ED-C5855BE1B54206095infoc; b_nut=1729324706; buvid4=75C4D7D7-A04A-F0B5-12E1-74FFBF47404738664-024101907-s9FFyawkfId5TZ3cskKUTA%3D%3D; DedeUserID=27919054; DedeUserID__ckMd5=b49996211ff5fbd5; _uuid=5498164E-19D9-C5F9-73AF-AD1E2344D83997843infoc; CURRENT_FNVAL=4048; rpdid=|(u~||u)|)mu0J'u~kmJkRmlu; header_theme_version=CLOSE; enable_web_push=DISABLE; home_feed_column=5; browser_resolution=1707-932; LIVE_BUVID=AUTO3417300333706425; hit-dyn-v2=1; fingerprint=edb02e588a73229a8b1fa7c5a0356671; buvid_fp_plain=undefined; buvid_fp=edb02e588a73229a8b1fa7c5a0356671; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MzI2MjQwMTksImlhdCI6MTczMjM2NDc1OSwicGx0IjotMX0.gWy0KoxRuGGE6xXhtxYB7N-tbFnQe3bX3JZIEHI7GLE; bili_ticket_expires=1732623959; SESSDATA=db98d970%2C1747916820%2C8ac23%2Ab2CjAniQXJ8hmz4KC7IbU2ER_XydjlkNe0fnuwYZDxl465NcOE6hAZPVeH_0Uj9QYtu6wSVjJ4RkJqaXZuUW9iS0ZGbVdtTFM1OXFvMzgtRVdVV1hLLWlhcEFuQW1KVm9hVnBmNkRIQndZSHJKV0kzOVRKdVpadkY4R1hMOHBUR1V3QVdldmM4cFJnIIEC; bili_jct=7f980dd81f7ff0573be461f5b0d98a6b; PVID=3; bp_t_offset_27919054=1003616544338477056"));
}
```

