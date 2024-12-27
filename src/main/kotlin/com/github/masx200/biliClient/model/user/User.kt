package com.github.masx200.biliClient.model.user

import com.github.masx200.biliClient.model.LiveRoom
import com.github.masx200.biliClient.model.SysNotice
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement

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
    var series: JsonElement? = null,
    var fans_badge: Boolean? = null,
    var face_nft_new: Int? = null,
    var face_nft_type: Int? = null,
    var face_nft: Int? = null,
    val mid: Long? = null,
    var jointime: Int? = null,
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
//    val silence: Int? = null,

    /**
     * 生日
     *
     *
     * 格式 **MM-DD**
     *
     */
//    val birthday: String? = null,

    /**
     * 硬币数目
     *
     *
     * **需要登录后才能查看**
     *
     */
//    val coins: Long? = null,

    /**
     * 是否具有粉丝胸罩
     */
    val fans_medal: JsonElement? = null,
    val school: JsonElement? = null,
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
    var user_honour_info: JsonElement? = null,
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
    val theme: JsonElement? = null,

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
    val live_room: LiveRoom? = null,
//    val mid: Long,
//    val name: String,
//    val sex: String,
//    val face: String,
//    val sign: String,
//    val rank: Long,
//    val level: Long,
//    val jointime: Long,
    val moral: Long? = null,
    val silence: Long? = null,
    @SerialName("email_status")
    val emailStatus: Long? = null,
    @SerialName("tel_status")
    val telStatus: Long? = null,
    val identification: Long? = null,
//    val vip: Map<String, JsonElement>,
//    val pendant: Map<String, JsonElement>,
//    val nameplate: Map<String, JsonElement>,
//    val official: Map<String, JsonElement>,
    val birthday: String? = null,
    @SerialName("is_tourist")
    val isTourist: Long? = null,
    @SerialName("is_fake_account")
    val isFakeAccount: Long? = null,
    @SerialName("pin_prompting")
    val pinPrompting: Long? = null,
    @SerialName("is_deleted")
    val isDeleted: Long? = null,
    @SerialName("in_reg_audit")
    val inRegAudit: Long? = null,
    @SerialName("is_rip_user")
    val isRipUser: Boolean? = null,
    val profession: JsonElement? = null,
//    @SerialName("face_nft")
//    val faceNft: Long,
//    @SerialName("face_nft_new")
//    val faceNftNew: Long,
    @SerialName("is_senior_member")
    val isSeniorMember: Long? = null,
//    val honours: Map<String, JsonElement>,
    @SerialName("digital_id")
    val digitalId: String? = null,
    @SerialName("digital_type")
    val digitalType: Long? = null,
//    val attestation: Map<String, JsonElement>,
//    @SerialName("expert_info")
//    val expertInfo: Map<String, JsonElement>,
//    @SerialName("name_render")
//    val nameRender: JsonElement?,
    @SerialName("country_code")
    val countryCode: String? = null,
//    @SerialName("level_exp")
//    val levelExp: Map<String, JsonElement>,
    val coins: Double? = null,
    val following: Long? = null,
    val follower: Long? = null,
    var tags: JsonArray? = null,
    @SerialName("mcn_info")
    val mcnInfo: JsonElement? = null,
    @SerialName("gaia_res_type")
    val gaiaResType: Long? = null,
    @SerialName("gaia_data")
    val gaiaData: JsonElement? = null,
    @SerialName("is_risk")
    val isRisk: Boolean? = null,
    val elec: JsonElement? = null,
    val contract: JsonElement? = null,
    @SerialName("certificate_show")
    val certificateShow: Boolean? = null,
    @SerialName("name_render")
    val nameRender: JsonElement? = null
)
/**
 * UID
 */
