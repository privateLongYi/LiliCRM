package com.linxi.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DataResult<T> {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "提示信息")
    private String msg;

    @ApiModelProperty(value = "返回数据的总个数")
    private Integer count;

    @ApiModelProperty(value = "返回的具体内容")
    private T data;

    public DataResult() {
    }

    public DataResult(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.msg = errorInfo.getResultMsg();
    }

    /**
     * 成功
     */
    public static DataResult success() {
        return success(null);
    }

    /**
     * 成功
     */
    public static DataResult success(Object data) {
        DataResult dr = new DataResult();
        dr.setCode(CommonEnum.SUCCESS.getResultCode());
        dr.setMsg(CommonEnum.SUCCESS.getResultMsg());
        dr.setCount(null);
        dr.setData(data);
        return dr;
    }

    /**
     * 成功
     */
    public static DataResult success(Integer count, Object data) {
        DataResult dr = new DataResult();
        dr.setCode(0);
        dr.setMsg(CommonEnum.SUCCESS.getResultMsg());
        dr.setCount(count);
        dr.setData(data);
        return dr;
    }

    /**
     * 失败
     */
    public static DataResult error(BaseErrorInfoInterface errorInfo) {
        DataResult dr = new DataResult();
        dr.setCode(errorInfo.getResultCode());
        dr.setMsg(errorInfo.getResultMsg());
        dr.setCount(null);
        dr.setData(null);
        return dr;
    }

    /**
     * 失败
     */
    public static DataResult error(Integer code, String message) {
        DataResult dr = new DataResult();
        dr.setCode(code);
        dr.setMsg(message);
        dr.setCount(null);
        dr.setData(null);
        return dr;
    }

    /**
     * 失败
     */
    public static DataResult error(String message) {
        DataResult dr = new DataResult();
        dr.setCode(CommonEnum.INTERNAL_SERVER_ERROR.getResultCode());
        dr.setMsg(message);
        dr.setCount(null);
        dr.setData(null);
        return dr;
    }

    /**
     * 失败
     */
    public static DataResult RepeatSubmit() {
        DataResult dr = new DataResult();
        dr.setCode(CommonEnum.NOT_REPEATSUBMIT.getResultCode());
        dr.setMsg(CommonEnum.NOT_REPEATSUBMIT.getResultMsg());
        dr.setCount(null);
        dr.setData(null);
        return dr;
    }

}