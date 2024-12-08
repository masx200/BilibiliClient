package com.github.masx200.biliClient.model.user

/**
 * 描述： 用户认证信息
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0 2021-02-07-14:00
 * @since 2021-02-07-14:00
 */
data //@com.alibaba.fastjson2.annotation.JSONCompiled
class Official {
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
    private val role: Int? = null

    /**
     * 认证信息
     */
    private val title: String? = null

    /**
     * 认证备注
     */
    private val desc: String? = null

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
    private val type: Int? = null
}
