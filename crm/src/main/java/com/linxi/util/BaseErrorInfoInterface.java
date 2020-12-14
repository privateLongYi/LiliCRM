package com.linxi.util;

/**
 * @Author LongYi
 * @create 2020/12/14 14:43
 */
public interface BaseErrorInfoInterface {

    /**
     * 错误码
     */
    Integer getResultCode();

    /**
     * 错误描述
     */
    String getResultMsg();

}
