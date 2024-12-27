package com.github.masx200.biliClient.model.video

import com.github.masx200.biliClient.model.BaseModel
import com.github.masx200.biliClient.model.user.User
import com.github.masx200.biliClient.utils.TransDate
import java.util.Date
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement

//import sun.jvm.hotspot.debugger.Page

/**
 * 描述： 视频稿件对象
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-08-18:37
 * @since 2021-02-08-18:37
 */@Serializable
data class Video(
    var argue_info: JsonElement? = null,
    var mission_id: Long? = null,
    var desc_v2: JsonArray? = null,
    var tname_v2: String? = null,
    var tid_v2: Long? = 0,
    val bvid: String? = null,

    /**
     * av
     */
    val aid: Long = 0,

    /**
     * p 数
     */
    val videos: Long = 0,

    /**
     * 分区 id
     */
    val tid: Long = 0,

    /**
     * 小区名
     */
    val tname: String? = null,

    /**
     * 视频类型
     *
     *
     * 1 自制
     *
     *
     *
     * 2 转载
     *
     */
    val copyright: Int? = null,

    /**
     * 封面图片
     */
    val pic: String? = null,

    /**
     * 标题
     */
    val title: String? = null,

    /**
     * 发布时间
     */
    val pubdate: Long = 0,

    /**
     * 上传时间
     */
    val ctime: Long = 0,

    /**
     * 视频简介
     */
    val desc: String? = null,

    /**
     * 稿件状态
     *
     *
     * 1 橙色通过
     *
     *
     *
     * 0 开放浏览
     *
     *
     *
     * -1 待审
     *
     *
     *
     * -2 被打回
     *
     *
     *
     * -3 网警锁定
     *
     *
     *
     * -4 被锁定 视频撞车了
     *
     *
     *
     * -5 管理员锁定
     *
     *
     *
     * -6 修复待审
     *
     *
     *
     * -7 暂缓审核
     *
     *
     *
     * -8 补档待审
     *
     *
     *
     * -9 等待转码
     *
     *
     *
     * -10 延迟审核
     *
     *
     *
     * -11 视频源待修
     *
     *
     *
     * -12 转储失败
     *
     *
     *
     * -13 允许评论待审
     *
     *
     *
     * -14 临时回收站
     *
     *
     *
     * -15 分发中
     *
     *
     *
     * -16 转码失败
     *
     *
     *
     * -20 创建未提交
     *
     *
     *
     * -30 创建已提交
     *
     *
     *
     * -40 定时发布
     *
     *
     *
     * -100 用户删除
     *
     */
    val state: Int? = null,

    /**
     * 关闭缓存
     */
    val no_cache: Boolean? = null,

    /**
     * 总时长 秒
     */
    val duration: Long? = null,

    /**
     * 视频属性
     *
     *
     * `"rights": {
     * "bp": 0,
     * "elec": 0,
     * "download": 1,
     * "movie": 0,
     * "pay": 0,
     * "hd5": 1,
     * "no_reprint": 1,
     * "autoplay": 1,
     * "ugc_pay": 0,
     * "is_cooperation": 0,
     * "ugc_pay_preview": 0,
     * "no_background": 0,
     * "clean_mode": 0,
     * "is_stein_gate": 0
     * }`
     *
     */
    val rights: JsonElement? = null,

    /**
     * 视频所有者
     */
    val owner: User? = null,

    /**
     * 视频数据
     */
    val stat: VideoData? = null,

    /**
     * 动态内容
     */
    val dynamic: String? = null,

    /**
     * 尚不明确
     */
    val cid: Long = 0,

    /**
     * 分辨率
     */
    val dimension: Dimension? = null,

    /**
     * 分P 信息
     *
     *
     * `"pages": [
     * {
     * "cid": 237377194,
     * "page": 1,
     * "from": "vupload",
     * "part": "【武汉纺织大学】你 要 在 纺 大 跳 舞 吗～",
     * "duration": 187,
     * "vid": "",
     * "weblink": "",
     * "dimension": {
     * "width": 3840,
     * "height": 2160,
     * "rotate": 0
     * }
     * }
     * ]`
     *
     */
    val pages: MutableList<VideoPage?>? = null,

    /**
     * 字幕信息
     *
     *
     * `"subtitle": {
     * "allow_submit": false,
     * "list": []
     * }`
     *
     */
    val subtitle: JsonElement? = null,

    /**
     * 合作者信息
     * **List **
     */
    val staff: MutableList<User?>? = null,

    /**
     * 用户穿衣信息
     *
     *
     * `"user_garb": {
     * "url_image_ani_cut": ""
     * }`
     *
     */
    val user_garb: JsonElement? = null,

//    val aid: Long,
//    val cid: Long,
//    val ctime: Long,
//    val desc: String,
//    val dimension: Dimension,
//    val duration: Long,
//    val dynamic: String,
    val first_frame: String? = null,
    val jump_url: String? = null,
//    val owner: Owner,
//    val pic: String,
//    val pubdate: Long,
    val short_link_v2: String? = null,
    
    
    
    
//    val stat: Stat,
//    val state: Long,
//    val tid: Long,
//    val title: String,
//    val tname: String,
//    val videos: Long


    val premiere: JsonElement? = null,
    @SerialName("teenage_mode")
    val teenageMode: Long? = null,
    @SerialName("is_chargeable_season")
    val isChargeableSeason: Boolean? = null,
    @SerialName("is_story")
    val isStory: Boolean? = null,
    @SerialName("is_upower_exclusive")
    val isUpowerExclusive: Boolean? = null,
    @SerialName("is_upower_play")
    val isUpowerPlay: Boolean? = null,
    @SerialName("is_upower_preview")
    val isUpowerPreview: Boolean? = null,
    @SerialName("enable_vt")
    val enableVt: Long? = null,
    @SerialName("vt_display")
    val vtDisplay: String? = null,
//    @SerialName("no_cache")
//    val noCache: Boolean,
//    val pages: List<Page>,
//    val subtitle: Subtitle,
    @SerialName("is_season_display")
    val isSeasonDisplay: Boolean? = null,
//    @SerialName("user_garb")
//    val userGarb: UserGarb,
    @SerialName("honor_reply")
    val honorReply: JsonElement? = null,
    @SerialName("like_icon")
    val likeIcon: String? = null,
    @SerialName("need_jump_bv")
    val needJumpBv: Boolean? = null,
    @SerialName("disable_show_up_info")
    val disableShowUpInfo: Boolean? = null,
    @SerialName("is_story_play")
    val isStoryPlay: Long? = null,
    @SerialName("is_view_self")
    val isViewSelf: Boolean? = null,
) : BaseModel {
    /**
     * bv
     */

    override fun createTime(): Date {
        return TransDate.timestampToDate(this.ctime)
    }
}
