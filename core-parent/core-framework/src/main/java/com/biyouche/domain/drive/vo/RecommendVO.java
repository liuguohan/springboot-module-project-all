package com.biyouche.domain.drive.vo;
/**
 * created by pht on 2018/7/26 0026
 */

import java.io.Serializable;

/**
 * @author pht
 * @program core-parent
 * @date 2018/7/26 0026
 */
public class RecommendVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer video_id; //科目视频id
    private String video_title; //科目视频标题
    private String video_image; //'封面图路径',
    private Integer play_num; //'视频播放量',

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

    public String getVideo_image() {
        return video_image;
    }

    public void setVideo_image(String video_image) {
        this.video_image = video_image;
    }

    public Integer getPlay_num() {
        return play_num;
    }

    public void setPlay_num(Integer play_num) {
        this.play_num = play_num;
    }

    @Override
    public String toString() {
        return "VideoRecommendVO{" +
                "video_id=" + video_id +
                ", video_title='" + video_title + '\'' +
                ", video_image='" + video_image + '\'' +
                ", play_num=" + play_num +
                '}';
    }
}
