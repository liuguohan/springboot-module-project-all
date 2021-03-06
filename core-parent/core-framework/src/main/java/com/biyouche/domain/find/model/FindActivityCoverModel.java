package com.biyouche.domain.find.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.biyouche.utils.TimeUtils;

/**
 * 发现活动封面模块
 * @author lgh
 *
 */
public class FindActivityCoverModel implements Serializable {


	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1178780366689541147L;

	/**
	 * 发现活动ID
	 */
	private Integer activityId;
	
	/**
	 * 发现ID
	 */
	private Integer findId;
	
	/**
	 * 活动标题
	 */
	private String activityTitle;
	
	/**
	 * 封面图片地址
	 */
	private String activityCover;
	
	/**
	 * 参与人数
	 */
	private Integer peopleNum;
	
	/**
	 * 限制人数
	 */
	private Integer limitNum;
	
	/**
	 * 活动费用
	 */
	private BigDecimal activityFee;
	
	/**
	 * 活动地址
	 */
	private String activityAddress;
	
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

	public Integer getFindId() {
		return findId;
	}

	public void setFindId(Integer findId) {
		this.findId = findId;
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

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
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

	@Override
	public String toString() {
		return "FindActivityCoverModel [activityId=" + activityId + ", findId=" + findId + ", activityTitle="
				+ activityTitle + ", activityCover=" + activityCover + ", peopleNum=" + peopleNum + ", limitNum="
				+ limitNum + ", activityFee=" + activityFee + ", activityAddress=" + activityAddress + ", activityTime="
				+ activityTime + ", activityTimeStr=" + activityTimeStr + ", activityTimeWeekStr=" + activityTimeWeekStr
				+ "]";
	}


	
	
}
