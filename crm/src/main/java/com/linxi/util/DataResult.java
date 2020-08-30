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

    public DataResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public DataResult() {
    }

}