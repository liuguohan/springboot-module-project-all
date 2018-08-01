package com.biyouche.domain.drive.vo;

/**
 * created by pht on 2018/7/26 0026
 */

import java.io.Serializable;

/**
 * @program core-parent
 * @date 2018/7/26 0026
 * @author pht
 */
public class CommentVo implements Serializable {

    private static final long serialVersionUID = 1L;

    //评论用户id
    private Integer user_id;
    //用户昵称
    private String nick_name;
    //用户头像
    private String avatarUrl;
    //评论id
    private Integer comment_id;
    //评论内容
    private String content;
    //评论时间
    private Integer create_time;
    //点赞数
    private Integer praise_num;


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public Integer getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(Integer praise_num) {
        this.praise_num = praise_num;
    }

    @Override
    public String toString() {
        return "CommentVo{" +
                "user_id=" + user_id +
                ", nick_name='" + nick_name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", comment_id=" + comment_id +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", praise_num=" + praise_num +
                '}';
    }
}
