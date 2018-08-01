package com.biyouche.domain.apply;

import java.io.Serializable;

/**
 * 点赞实体类
 */
public class Praise implements Serializable {

    private static final long serialVersionUID = 1L;

    //点赞id
    private Integer id;
    //评论id
    private Integer evaluationId;
    //点赞用户id
    private Integer userId;
    //点赞时间
    private Integer createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Praise{" +
                "id=" + id +
                ", evaluationId=" + evaluationId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                '}';
    }
}
