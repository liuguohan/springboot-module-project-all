package com.biyouche.domain.apply;

import java.io.Serializable;

/**
 * 学车需求取消表
 */
public class NeedsCancel implements Serializable {

    private static final long serialVersionUID = 1L;

    //取消id
    private Integer cancelId;
    //需求id
    private Integer needsId;
    //申请id
    private Integer applyId;
    //原因id
    private String reason;
    //详细原因
    private String remark;
    //取消时间
    private Integer cancelTime;
    //用户id
    private Integer userId;
    //驾校id
    private Integer schoolId;

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getCancelId() {
        return cancelId;
    }

    public void setCancelId(Integer cancelId) {
        this.cancelId = cancelId;
    }

    public Integer getNeedsId() {
        return needsId;
    }

    public void setNeedsId(Integer needsId) {
        this.needsId = needsId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Integer cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "NeedsCancel{" +
                "cancelId=" + cancelId +
                ", needsId=" + needsId +
                ", applyId=" + applyId +
                ", reason='" + reason + '\'' +
                ", remark='" + remark + '\'' +
                ", cancelTime=" + cancelTime +
                ", userId=" + userId +
                ", schoolId=" + schoolId +
                '}';
    }
}
