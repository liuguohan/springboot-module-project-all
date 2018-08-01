package com.biyouche.domain.apply;

import java.io.Serializable;

/**
 * 驾校咨询申请实体类
 */
public class Apply implements Serializable {

    private static final long serialVersionUID = 1L;

    //申请id
    private Integer applyId;
    //申请的用户id 未登录时为0
    private Integer userId;
    //用户姓名
    private String realName;
    //用户手机号
    private String phone;
    //后台添置的驾校id;默认为0
    private Integer schoolId;
    //是否报名成功(成功就是等待交钱的)
    private Integer applyStatus;
    //申请提交时间
    private Integer applyTime;
    //报名结果生成时间
    private Integer resultTime;

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
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

    public Integer getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Integer applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getResultTime() {
        return resultTime;
    }

    public void setResultTime(Integer resultTime) {
        this.resultTime = resultTime;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyId=" + applyId +
                ", userId=" + userId +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", schoolId=" + schoolId +
                ", applyStatus=" + applyStatus +
                ", applyTime=" + applyTime +
                ", resultTime=" + resultTime +
                '}';
    }
}
