package com.github.masx200.biliClient.able

/**
 * 描述：返回一个对象的方法 Gettable
 *
 * @author lpc lpc@hll520.cn
 * @version 1.0  2021-02-05-15:55
 * @since 2021-02-05-15:55
 */
interface Gettable<T> : BiliAbel<T> {
    /**
     * 返回一个对象
     *
     * @return 一个
     */
    fun get(): T
}
