package com.biyouche.domain.drive;

/**
 * created by pht on 2018/7/26 0026
 */

import java.io.Serializable;

/**
 * @author pht
 * @program core-parent
 * @date 2018/7/26 0026
 */
public class DriveVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer video_id; //科目视频id
    private String video_title; //科目视频标题
    private String video_content; //  '视频文本内容(暂无)',
    private String video_url; // '视频连接',
    private String video_image; //'封面图路径',
    private Integer create_time; //'视频录入时间',
    private Integer play_num; //'视频播放量',
    private Integer comment_num; //'评论数(冗余字段)',
    private Integer admin_id; //'视频添加人id',
    private Integer status; //'视频状态(0:启用,1:停用)',
    private Integer subject_type; //'科目类型(0:科目二,1:科目三)',

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_content() {
        return video_content;
    }

    public void setVideo_content(String video_content) {
        this.video_content = video_content;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getVideo_image() {
        return video_image;
    }

    public void setVideo_image(String video_image) {
        this.video_image = video_image;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public Integer getPlay_num() {
        return play_num;
    }

    public void setPlay_num(Integer play_num) {
        this.play_num = play_num;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(Integer subject_type) {
        this.subject_type = subject_type;
    }

    @Override
    public String toString() {
        return "DriveVideo{" +
                "video_id=" + video_id +
                ", video_title='" + video_title + '\'' +
                ", video_content='" + video_content + '\'' +
                ", video_url='" + video_url + '\'' +
                ", video_image='" + video_image + '\'' +
                ", create_time=" + create_time +
                ", play_num=" + play_num +
                ", comment_num=" + comment_num +
                ", admin_id=" + admin_id +
                ", status=" + status +
                ", subject_type=" + subject_type +
                '}';
    }
}
