package com.biyouche.domain.apply;

import java.io.Serializable;

/**
 * 驾校场地实体类
 */
public class Place implements Serializable {
    private static final long serialVersionUID = 1L;

    //场地id
    private Integer id;
    //场地名称
    private String placeName;
    //场地可练习类型
    private String practiceType;
    //驾校id
    private Integer schoolId;
    //场地地址
    private String address;
    //场地照
    private String image;
    //删除状态
    private Integer delStatus;
    //场地创建时间
    private Integer createTime;
    //更新时间
    private Integer updateTime;
    //操作人id
    private Integer adminId;

    /*纬度**/
    private Double lat;

    /*经度**/
    private Double lng;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(String practiceType) {
        this.practiceType = practiceType;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                ", practiceType='" + practiceType + '\'' +
                ", schoolId=" + schoolId +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", delStatus=" + delStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", adminId=" + adminId +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
