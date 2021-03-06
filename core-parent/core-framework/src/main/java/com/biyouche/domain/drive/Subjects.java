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
public class Subjects implements Serializable {

    private Integer subject_id;
    private String subject_name;
    private String subject_synopsis; //项目简介
    private String subject_image;
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


    public String getSubject_image() {
        return subject_image;
    }

    public void setSubject_image(String subject_image) {
        this.subject_image = subject_image;
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


    public String getSubject_synopsis() {
        return subject_synopsis;
    }

    public void setSubject_synopsis(String subject_synopsis) {
        this.subject_synopsis = subject_synopsis;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "subject_id=" + subject_id +
                ", subject_name='" + subject_name + '\'' +
                ", subject_synopsis='" + subject_synopsis + '\'' +
                ", subject_image='" + subject_image + '\'' +
                ", play_num=" + play_num +
                ", pass_rate='" + pass_rate + '\'' +
                '}';
    }
}
