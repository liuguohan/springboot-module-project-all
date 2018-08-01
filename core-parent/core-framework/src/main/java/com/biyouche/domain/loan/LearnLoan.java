package com.biyouche.domain.loan;

import java.io.Serializable;

/**
 * 学车贷报名实体类
 */
public class LearnLoan implements Serializable {

    private static final long serialVersionUID = 1L;

    //开卡申请id
    private Integer loanId;
    //用户id
    private Integer userId;
    //驾校名称
    private Integer schoolName;
    //用户手机号
    private String phone;
    //用户姓名
    private String userName;
    //用户身份证号码
    private String cardNo;
    //用户购车卡号
    private String bankNo;
    //用户地址
    private String address;
    //驾照类型
    private String licenceType;
    //创建时间
    private Integer createTime;
    //审核更新时间
    private Integer updateTime;
    //审核状态
    private int status;
    //支付状态
    private int payStatus;
    //支付时间
    private Integer payTime;
    //支付类型
    private int payType;
    //支付金额
    private Double payAmount;
    //操作人id
    private Integer adminId;
    //审核教练id
    private Integer coachId;

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(Integer schoolName) {
        this.schoolName = schoolName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    @Override
    public String toString() {
        return "LearnLoan{" +
                "loanId=" + loanId +
                ", userId=" + userId +
                ", schoolName=" + schoolName +
                ", phone='" + phone + '\'' +
                ", userName='" + userName + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", address='" + address + '\'' +
                ", licenceType='" + licenceType + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", payStatus=" + payStatus +
                ", payTime=" + payTime +
                ", payType=" + payType +
                ", payAmount=" + payAmount +
                ", adminId=" + adminId +
                ", coachId=" + coachId +
                '}';
    }
}
