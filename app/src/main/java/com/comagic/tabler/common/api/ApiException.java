package com.comagic.tabler.common.api;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 10:52
 * 邮箱: leiyuanxin@eims.com.cn
 * 描述：异常类，当获取的数据不是我们需要时，抛出异常
 *
 */
public class ApiException extends RuntimeException {

    public String type;

    /**
     * 异常信息
     * @param detailMessage
     */
    public ApiException(String type, String detailMessage) {
        super(detailMessage);
        this.type = type;
    }
}
