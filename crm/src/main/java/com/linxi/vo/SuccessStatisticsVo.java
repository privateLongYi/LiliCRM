package com.linxi.vo;

import lombok.Data;

/**
 * @Author LongYi
 * @create 2020/10/17 16:16
 */
public class SuccessStatisticsVo {

    /**
     * 统计单位
     */
    private String unit;

    /**
     * 成交额
     */
    private Integer sum;

    public SuccessStatisticsVo() {
    }

    public SuccessStatisticsVo(String unit, Integer sum) {
        this.unit = unit;
        this.sum = sum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
