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
    private Double sum;

    public SuccessStatisticsVo() {
    }

    public SuccessStatisticsVo(String unit, Double sum) {
        this.unit = unit;
        this.sum = sum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
