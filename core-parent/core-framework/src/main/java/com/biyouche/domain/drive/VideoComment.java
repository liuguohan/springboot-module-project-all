package com.biyouche.domain.drive;

/**
 * created by pht on 2018/7/26 0026
 */

import java.io.Serializable;

/**
 * @program core-parent
 * @date 2018/7/26 0026
 * @author pht
 */
public class VideoComment implements Serializable {

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
    //视频id
    private Integer video_id;
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

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VideoComment{" +
                "comment_Id=" + comment_id +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", praise_num=" + praise_num +
                ", video_id=" + video_id +
                ", status=" + status +
                '}';
    }
}
