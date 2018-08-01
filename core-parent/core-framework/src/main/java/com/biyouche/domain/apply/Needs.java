package com.biyouche.domain.apply;

import java.io.Serializable;

/**
 * 学车需求申请表实体类
 */
public class Needs implements Serializable {

    private static final long serialVersionUID = 1L;

    //id
    private Integer needsId;
    //申请的用户id 未登录时为0
    private Integer userId;
    //用户姓名
    private String realName;
    //用户手机号
    private String phone;
    //用户地址
    private String address;
    //用户所处经度
    private String longitude;
    //用户所处纬度
    private String latitude;
    //用户申请驾证类型
    private Integer licenceType;
    //用户选择要素
    private String factors;
    //后台添置的驾校id;默认为0
    private Integer schoolId;
    //是否报名成功(成功就是等待交钱的)
    private Integer applyStatus;
    //申请提交时间
    private Integer createTime;
    //推荐驾校时间
    private Integer handlerTime;
    //报名结果生成时间
    private Integer resultTime;

    public Integer getNeedsId() {
        return needsId;
    }

    public void setNeedsId(Integer needsId) {
        this.needsId = needsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(Integer licenceType) {
        this.licenceType = licenceType;
    }

    public String getFactors() {
        return factors;
    }

    public void setFactors(String factors) {
        this.factors = factors;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getHandlerTime() {
        return handlerTime;
    }

    public void setHandlerTime(Integer handlerTime) {
        this.handlerTime = handlerTime;
    }

    public Integer getResultTime() {
        return resultTime;
    }

    public void setResultTime(Integer resultTime) {
        this.resultTime = resultTime;
    }

    @Override
    public String toString() {
        return "Needs{" +
                "needsId=" + needsId +
                ", userId=" + userId +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", licenceType=" + licenceType +
                ", factors='" + factors + '\'' +
                ", schoolId=" + schoolId +
                ", applyStatus=" + applyStatus +
                ", createTime=" + createTime +
                ", handlerTime=" + handlerTime +
                ", resultTime=" + resultTime +
                '}';
    }
}
