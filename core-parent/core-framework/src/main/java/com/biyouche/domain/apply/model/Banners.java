package com.biyouche.domain.apply.model;

/**
 * created by pht on 2018/7/30 0030
 */

import java.io.Serializable;

/**
 * @program core-parent
 * @date 2018/7/30 0030
 * @author pht
 */
public class Banners implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer banner_id;
    private String banner_url;

    public Integer getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(Integer banner_id) {
        this.banner_id = banner_id;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    @Override
    public String toString() {
        return "BannerVO{" +
                "banner_id=" + banner_id +
                ", banner_url='" + banner_url + '\'' +
                '}';
    }

}
