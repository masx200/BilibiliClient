package com.github.masx200.biliClient.model.user

import com.github.masx200.biliClient.model.LiveRoom
import com.github.masx200.biliClient.model.SysNotice
import kotlinx.serialization.Serializable

//import lombok.Data;
/**
 * 描述： 哔哩哔哩用户对象
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-13:51
 * @since 2021-02-07-13:51
 */
//data
//@com.alibaba.fastjson2.annotation.JSONCompiled
@Serializable
data class User(
    val mid: Long? = null,

    /**
     * 名称
     */
    val name: String? = null,

    /**
     * 性别
     */
    val sex: String? = null,

    /**
     * 头像连接
     */
    val face: String? = null,

    /**
     * 签名
     */
    val sign: String? = null,

    /**
     * rank
     */
    val rank: Long = 1000L,

    /**
     * 等级
     */
    val level: Int? = null,

    /**
     * 封禁状态
     *
     *
     * 0: 正常
     *
     *
     *
     * 1: 封禁
     *
     */
    val silence: Int? = null,

    /**
     * 生日
     *
     *
     * 格式 **MM-DD**
     *
     */
    val birthday: String? = null,

    /**
     * 硬币数目
     *
     *
     * **需要登录后才能查看**
     *
     */
    val coins: Long? = null,

    /**
     * 是否具有粉丝胸罩
     */
    val fans_badge: Boolean? = null,

    /**
     * 认证信息
     */
    val official: Official? = null,

    /**
     * 会员信息
     */
    val vip: Vip? = null,

    /**
     * 头像框信息
     */
    val pendant: Pendant? = null,

    /**
     * 勋章信息
     */
    val nameplate: Nameplate? = null,

    /**
     * 是否关注
     * **需要登录，否则为 false**
     */
    val is_followed: Boolean? = null,

    /**
     * 头图连接
     */
    val top_photo: String? = null,

    /**
     * 主题信息
     */
    val theme: Any? = null,

    /**
     * 系统通知
     *
     *
     * 纪念账号小黑屋等
     *
     *
     *
     * `"sys_notice": {
     * "id": 20,
     * "content": "请允许我们在此献上最后的告别，以此纪念其在哔哩哔哩留下的回忆与足迹。请点此查看纪念账号相关说明\u003e",
     * "url": "https://www.bilibili.com/blackboard/help.html#/?qid=fb37c62ca61f4f10b8d17f3dc9051603",
     * "notice_type": 2,
     * "icon": "https://i0.hdslb.com/bfs/space/ca6d0ed2edae23cf348db19cd2c293f2121c1b59.png",
     * "text_color": "#999999",
     * "bg_color": "#e7e7e7"
     * }`
     *
     */
    val sys_notice: SysNotice? = null,

    /**
     * 直播间信息
     */
    val live_room: LiveRoom? = null
)
/**
 * UID
 */
