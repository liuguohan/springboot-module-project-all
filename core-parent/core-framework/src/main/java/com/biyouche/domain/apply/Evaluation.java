package com.biyouche.domain.apply;

import java.io.Serializable;

/**
 * 驾校评价实体类
 */
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Integer ZERO = 0;

    //评价id
    private Integer id;

    //驾校id
    private Integer  schoolId;
    //用户id
    private Integer userId;
    //评价等级
    private Integer level;
    //评价内容
    private String evaluationContent;
    //评价图片
    private String evaluationImage;
    //删除状态
    private Integer delStatus;
    //评价时间
    private Integer evaluationTime;
    //创建时间
    private Integer createTime;
    //追加评价时间
    private Integer updateTime;
    //教学服务
    private Integer teachingService;
    //环境设施
    private Integer environmental;
    //学车速度
    private Integer driverSpeed;
    //点赞个数
    private Integer praiseNum;
    //当前用户是否点赞(0:未点赞,已点赞)
    private Integer ifPraise = ZERO;

    public Integer getIfPraise() {
        return ifPraise;
    }

    public void setIfPraise(Integer ifPraise) {
        this.ifPraise = ifPraise;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public String getEvaluationImage() {
        return evaluationImage;
    }

    public void setEvaluationImage(String evaluationImage) {
        this.evaluationImage = evaluationImage;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public Integer getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Integer evaluationTime) {
        this.evaluationTime = evaluationTime;
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

    public Integer getTeachingService() {
        return teachingService;
    }

    public void setTeachingService(Integer teachingService) {
        this.teachingService = teachingService;
    }

    public Integer getEnvironmental() {
        return environmental;
    }

    public void setEnvironmental(Integer environmental) {
        this.environmental = environmental;
    }

    public Integer getDriverSpeed() {
        return driverSpeed;
    }

    public void setDriverSpeed(Integer driverSpeed) {
        this.driverSpeed = driverSpeed;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }


    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", schoolId=" + schoolId +
                ", userId=" + userId +
                ", level=" + level +
                ", evaluationContent='" + evaluationContent + '\'' +
                ", evaluationImage='" + evaluationImage + '\'' +
                ", delStatus=" + delStatus +
                ", evaluationTime=" + evaluationTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", teachingService=" + teachingService +
                ", environmental=" + environmental +
                ", driverSpeed=" + driverSpeed +
                ", praiseNum=" + praiseNum +
                ", ifPraise=" + ifPraise +
                '}';
    }
}
