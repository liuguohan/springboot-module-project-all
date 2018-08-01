package com.biyouche.domain.apply;

import java.io.Serializable;

/**
 * 推荐标签搜索点击表
 * @author lgh
 *
 */
public class SearchClick implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 6431946157190973139L;

	/**
	 * 推荐搜索ID
	 */
	private Integer searchId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 距离最近点击数
	 */
	private Integer distanceClick;
	
	/**
	 * 评分最高点击数
	 */
	private Integer scoreClick;
	
	/**
	 * 价格最低点击数
	 */
	private Integer priceClick;
	
	/**
	 * 推荐驾校点击数
	 */
	private Integer schoolClick;
	
	/**
	 * 学车保障点击数
	 */
	private Integer indemnityClick;
	
	/**
	 * 信用学车点击数
	 */
	private Integer creditClick;

	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDistanceClick() {
		return distanceClick;
	}

	public void setDistanceClick(Integer distanceClick) {
		this.distanceClick = distanceClick;
	}

	public Integer getScoreClick() {
		return scoreClick;
	}

	public void setScoreClick(Integer scoreClick) {
		this.scoreClick = scoreClick;
	}

	public Integer getPriceClick() {
		return priceClick;
	}

	public void setPriceClick(Integer priceClick) {
		this.priceClick = priceClick;
	}

	public Integer getSchoolClick() {
		return schoolClick;
	}

	public void setSchoolClick(Integer schoolClick) {
		this.schoolClick = schoolClick;
	}

	public Integer getIndemnityClick() {
		return indemnityClick;
	}

	public void setIndemnityClick(Integer indemnityClick) {
		this.indemnityClick = indemnityClick;
	}

	public Integer getCreditClick() {
		return creditClick;
	}

	public void setCreditClick(Integer creditClick) {
		this.creditClick = creditClick;
	}

	@Override
	public String toString() {
		return "SearchClick [searchId=" + searchId + ", userId=" + userId + ", distanceClick=" + distanceClick
				+ ", scoreClick=" + scoreClick + ", priceClick=" + priceClick + ", schoolClick=" + schoolClick
				+ ", indemnityClick=" + indemnityClick + ", creditClick=" + creditClick + "]";
	}
	
	
	
}
