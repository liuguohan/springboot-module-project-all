package com.biyouche.domain.find.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.biyouche.utils.TimeUtils;

/**
 * 发现活动详情模块
 * @author lgh
 *
 */
public class FindActivityDetailModel implements Serializable {


	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1531018794482941390L;

	/**
	 * 发现活动ID
	 */
	private Integer activityId;
	
	/**
	 * 活动标题
	 */
	private String activityTitle;
	
	/**
	 * 封面图片地址
	 */
	private String activityCover;
	
	/**
	 * 限制人数
	 */
	private Integer limitNum;
	
	/**
	 * 参与人数
	 */
	private Integer peopleNum;
	
	/**
	 * 活动费用
	 */
	private BigDecimal activityFee;
	
	/**
	 * 活动地址
	 */
	private String activityAddress;
	
	/**
	 * 活动内容
	 */
	private String activityContent;
	
	/**
	 * 活动规则
	 */
	private String activityRule;
	
	/**
	 * 报名开始时间
	 */
	private Integer reportStartTime;
	
	/**
	 * 报名截止时间
	 */
	private Integer reportEndTime;
	
	/**
	 * 活动时间
	 */
	private Integer activityTime;
	
	/**
	 * 活动时间格式化
	 */
	private String activityTimeStr;
	
	/**
	 * 活动时间星期格式化
	 */
	private String activityTimeWeekStr;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getActivityCover() {
		return activityCover;
	}

	public void setActivityCover(String activityCover) {
		this.activityCover = activityCover;
	}

	public BigDecimal getActivityFee() {
		return activityFee;
	}

	public void setActivityFee(BigDecimal activityFee) {
		this.activityFee = activityFee;
	}

	public String getActivityAddress() {
		return activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	public Integer getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Integer activityTime) {
		this.activityTime = activityTime;
	}

	public String getActivityTimeStr() {
		return activityTimeStr;
	}

	public void setActivityTimeStr(String activityTimeStr) {
		this.activityTimeStr = activityTimeStr;
	}

	public String getActivityTimeWeekStr() {
		
		int week = TimeUtils.dayForWeek(activityTime);
		if( week == 1 ) {
			return "周一";
		}else if( week == 2 ) {
			return "周二";
		}else if( week == 3 ) {
			return "周三";
		}else if( week == 4 ) {
			return "周四";
		}else if( week == 5 ) {
			return "周五";
		}else if( week == 6 ) {
			return "周六";
		}else if( week == 7 ) {
			return "周日";
		}else {
			return "无";
		}
	}

	public void setActivityTimeWeekStr(String activityTimeWeekStr) {
		this.activityTimeWeekStr = activityTimeWeekStr;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public String getActivityRule() {
		return activityRule;
	}

	public void setActivityRule(String activityRule) {
		this.activityRule = activityRule;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public Integer getReportStartTime() {
		return reportStartTime;
	}

	public void setReportStartTime(Integer reportStartTime) {
		this.reportStartTime = reportStartTime;
	}

	public Integer getReportEndTime() {
		return reportEndTime;
	}

	public void setReportEndTime(Integer reportEndTime) {
		this.reportEndTime = reportEndTime;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	@Override
	public String toString() {
		return "FindActivityDetailModel [activityId=" + activityId + ", activityTitle=" + activityTitle
				+ ", activityCover=" + activityCover + ", limitNum=" + limitNum + ", peopleNum=" + peopleNum
				+ ", activityFee=" + activityFee + ", activityAddress=" + activityAddress + ", activityContent="
				+ activityContent + ", activityRule=" + activityRule + ", reportStartTime=" + reportStartTime
				+ ", reportEndTime=" + reportEndTime + ", activityTime=" + activityTime + ", activityTimeStr="
				+ activityTimeStr + ", activityTimeWeekStr=" + activityTimeWeekStr + "]";
	}
	
	
}
