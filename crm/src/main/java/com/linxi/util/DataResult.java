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

    public DataResult(Integer code, String msg, Integer count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public DataResult() {
    }

    public DataResult fail() {
        return new DataResult(1, "操作失败", 0, null);
    }

    public DataResult fail(String msg) {
        return new DataResult(1, msg, 0, null);
    }

    public DataResult ok() {
        return new DataResult(0, "操作成功", 0, null);
    }

    public DataResult ok(Integer count, T data) {
        return new DataResult(0, "操作成功", count, data);
    }
}