package com.biyouche.domain.user;

import java.io.Serializable;

public class LoginVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String accessid; //通行证编号
    private String client_version; //客户端版本
    private String device_detail; //设备详情
    private String device_id; //设备ID
    private String device_name; //设备名称
    private String device_os; //操作系统
    private String device_port; //设备类型
    private String latitude; //纬度
    private String longitude; //经度
    private String user_mobile;    //登录手机号
    private String user_password;
    private String reqIp; //登录ip

    public String getReqIp() {
        return reqIp;
    }

    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }

    public String getAccessid() {
        return accessid;
    }

    public void setAccessid(String accessid) {
        this.accessid = accessid;
    }

    public String getClient_version() {
        return client_version;
    }

    public void setClient_version(String client_version) {
        this.client_version = client_version;
    }

    public String getDevice_detail() {
        return device_detail;
    }

    public void setDevice_detail(String device_detail) {
        this.device_detail = device_detail;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_os() {
        return device_os;
    }

    public void setDevice_os(String device_os) {
        this.device_os = device_os;
    }

    public String getDevice_port() {
        return device_port;
    }

    public void setDevice_port(String device_port) {
        this.device_port = device_port;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "accessid='" + accessid + '\'' +
                ", client_version='" + client_version + '\'' +
                ", device_detail='" + device_detail + '\'' +
                ", device_id='" + device_id + '\'' +
                ", device_name='" + device_name + '\'' +
                ", device_os='" + device_os + '\'' +
                ", device_port='" + device_port + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", user_mobile='" + user_mobile + '\'' +
                ", user_password='" + user_password + '\'' +
                ", reqIp='" + reqIp + '\'' +
                '}';
    }
}
