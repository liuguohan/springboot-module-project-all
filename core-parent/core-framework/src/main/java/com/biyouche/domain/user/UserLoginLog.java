package com.biyouche.domain.user;

import java.io.Serializable;

/**
 * 登录日志
 */
public class UserLoginLog implements Serializable {
    private static final long serialVersionUID = 1L;

    //日志id
    private Integer logId;
    //登录用户id
    private Integer userId;
    //登录手机号
    private String userMobile;
    //设备类型
    private Integer deviceType;
    //登陆时间
    private Integer loginTime;
    //登录ip
    private String loginIp;
    //登录地区编码
    private String loginAreaCode;
    //经度
    private String longitude;
    //纬度
    private String latitude;
    //设备Id
    private  String deviceId;
    //操作系统
    private String deviceOs;
    //设备名称
    private String deviceName;
    //客户端版本号
    private String clientVersion;
    //设备详情
    private  String deviceDetail;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Integer loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginAreaCode() {
        return loginAreaCode;
    }

    public void setLoginAreaCode(String loginAreaCode) {
        this.loginAreaCode = loginAreaCode;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getDeviceDetail() {
        return deviceDetail;
    }

    public void setDeviceDetail(String deviceDetail) {
        this.deviceDetail = deviceDetail;
    }

    @Override
    public String toString() {
        return "UserLoginLog{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", userMobile='" + userMobile + '\'' +
                ", deviceType=" + deviceType +
                ", loginTime=" + loginTime +
                ", loginIp='" + loginIp + '\'' +
                ", loginAreaCode='" + loginAreaCode + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceOs='" + deviceOs + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", clientVersion='" + clientVersion + '\'' +
                ", deviceDetail='" + deviceDetail + '\'' +
                '}';
    }
}
