package com.github.masx200.biliClient.model.user

import kotlinx.serialization.Serializable

/**
 * 描述： 用户认证信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:00
 * @since 2021-02-07-14:00
 */
@Serializable
data class Official(
    /**
     * 角色类型
     *
     *
     * 0: 无认证
     *
     *
     *
     * 1\2 个人认证 -- 知名\专栏
     *
     *
     *
     * 3\4\5\6 机构认证认证 --- 企业\媒体\政府组织
     *
     */
    val role: Int? = null,

    /**
     * 认证信息
     */
    val title: String? = null,

    /**
     * 认证备注
     */
    val desc: String? = null,

    /**
     * 是否认证
     *
     *
     * 0 未认证
     *
     *
     *
     * 1 认证
     *
     */
    val type: Int? = null
)
