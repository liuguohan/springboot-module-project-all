package com.biyouche.domain.drive.vo;

/**
 * created by pht on 2018/7/27 0027
 */

import java.io.Serializable;

/**
 * @program core-parent
 * @date 2018/7/27 0027
 * @author pht
 */
public class SubjectVO implements Serializable {

  private Integer subject_id;
  private String subject_name;
  private String subject_content;
  private String subject_image;
  private String video_url;
  private Integer play_num;
  private String pass_rate;


  public Integer getSubject_id() {
    return subject_id;
  }

  public void setSubject_id(Integer subject_id) {
    this.subject_id = subject_id;
  }

  public String getSubject_name() {
    return subject_name;
  }

  public void setSubject_name(String subject_name) {
    this.subject_name = subject_name;
  }

  public String getSubject_content() {
    return subject_content;
  }

  public void setSubject_content(String subject_content) {
    this.subject_content = subject_content;
  }

  public String getSubject_image() {
    return subject_image;
  }

  public void setSubject_image(String subject_image) {
    this.subject_image = subject_image;
  }

  public String getVideo_url() {
    return video_url;
  }

  public void setVideo_url(String video_url) {
    this.video_url = video_url;
  }

  public Integer getPlay_num() {
    return play_num;
  }

  public void setPlay_num(Integer play_num) {
    this.play_num = play_num;
  }

  public String getPass_rate() {
    return pass_rate;
  }

  public void setPass_rate(String pass_rate) {
    this.pass_rate = pass_rate;
  }


  @Override
  public String toString() {
    return "SubjectVO{" +
            "subject_id=" + subject_id +
            ", subject_name='" + subject_name + '\'' +
            ", subject_content='" + subject_content + '\'' +
            ", subject_image='" + subject_image + '\'' +
            ", video_url='" + video_url + '\'' +
            ", play_num=" + play_num +
            ", pass_rate='" + pass_rate + '\'' +
            '}';
  }
}
