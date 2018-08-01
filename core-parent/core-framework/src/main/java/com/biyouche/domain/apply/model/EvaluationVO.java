package com.biyouche.domain.apply.model;

import java.io.Serializable;

import static org.hibernate.type.IntegerType.ZERO;

/**
 * 评论VO
 */
public class EvaluationVO implements Serializable {

    //评论id
    private Integer id;
    //评论用户id
    private Integer user_id;
    //驾校id
    private Integer  school_id;
    //评论用户名
    private String nick_name;
    //用户头像
    private String avatar_url;
    //评价等级
    private Integer level;
    //评价内容
    private String evaluation_content;
    //评价图片
    private String evaluation_image;
    //评价时间
    private Integer evaluation_time;
    //点赞个数
    private Integer praise_num;
    //当前用户是否点赞(0:未点赞,已点赞)
    private Integer ifPraise = ZERO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getEvaluation_content() {
        return evaluation_content;
    }

    public void setEvaluation_content(String evaluation_content) {
        this.evaluation_content = evaluation_content;
    }

    public String getEvaluation_image() {
        return evaluation_image;
    }

    public void setEvaluation_image(String evaluation_image) {
        this.evaluation_image = evaluation_image;
    }

    public Integer getEvaluation_time() {
        return evaluation_time;
    }

    public void setEvaluation_time(Integer evaluation_time) {
        this.evaluation_time = evaluation_time;
    }

    public Integer getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(Integer praise_num) {
        this.praise_num = praise_num;
    }

    public Integer getIfPraise() {
        return ifPraise;
    }

    public void setIfPraise(Integer ifPraise) {
        this.ifPraise = ifPraise;
    }

    @Override
    public String toString() {
        return "EvaluationVO{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", school_id=" + school_id +
                ", nick_name='" + nick_name + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", level=" + level +
                ", evaluation_content='" + evaluation_content + '\'' +
                ", evaluation_image='" + evaluation_image + '\'' +
                ", evaluation_time=" + evaluation_time +
                ", praise_num=" + praise_num +
                ", ifPraise=" + ifPraise +
                '}';
    }
}
