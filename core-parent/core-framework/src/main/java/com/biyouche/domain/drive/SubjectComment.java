package com.biyouche.domain.drive;

/**
 * created by pht on 2018/7/27 0027
 */

import java.io.Serializable;

/**
 * @author pht
 * @program core-parent
 * @date 2018/7/27 0027
 */
public class SubjectComment implements Serializable{

    private static final long serialVersionUID = 1L;

    //评论id
    private Integer comment_id;
    //用户id
    private Integer user_id;
    //评论内容
    private String content;
    //评论时间
    private Integer create_time;
    //点赞数
    private Integer praise_num;
    //考试项目id
    private Integer subject_id;
    //评论状态
    private Integer status;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SubjectComment{" +
                "comment_id=" + comment_id +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", praise_num=" + praise_num +
                ", subject_id=" + subject_id +
                ", status=" + status +
                '}';
    }
}
