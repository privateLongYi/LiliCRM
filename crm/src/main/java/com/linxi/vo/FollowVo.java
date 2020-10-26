package com.linxi.vo;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author LongYi
 * @create 2020/10/26 21:53
 */
public class FollowVo {

    /**
     * 跟进时间
     */
    private Timestamp time;

    /**
     * 跟进类型
     */
    private String type;

    /**
     * 跟进信息列表
     */
    private List<String> followList;

    public FollowVo(Timestamp time, String type, List<String> followList) {
        this.time = time;
        this.type = type;
        this.followList = followList;
    }

    public FollowVo() {
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getFollowList() {
        return followList;
    }

    public void setFollowList(List<String> followList) {
        this.followList = followList;
    }
}
