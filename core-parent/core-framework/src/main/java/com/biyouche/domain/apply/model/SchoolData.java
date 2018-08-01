package com.biyouche.domain.apply.model;

import java.io.Serializable;

/**
 * 返回客户端数据
 * @author hucong
 *
 */
public class SchoolData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3639889868786886751L;
	
	/*驾校id**/
	private Integer id;
	
	/*驾校评分**/
	private Double score;
	
	/*地区编码**/
	private String areaCode;
	
	/*地区名字**/
	private String image;
	
	/*驾校照片**/
	private String areaCodeName;
	
	/*纬度**/
	private String lat;
	
	/*经度**/
	private String lng;
	
	/*离驾校距离**/
	private Double distance;
	
	/*推荐班级id**/
	private Integer recommendClassId;
	
	/*推荐班级费用**/
	private Double recommendClassFee;
	
	/*推荐班级名字**/
	private String recommendClassName;
	
	/*驾校名字**/
	private String name;
	
	/*推荐班级标签**/
	private String recommend_class_label;
	
	/*推荐班级减免活动**/
	private String recommend_class_active;
	        
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaCodeName() {
		return areaCodeName;
	}

	public void setAreaCodeName(String areaCodeName) {
		this.areaCodeName = areaCodeName;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Integer getRecommendClassId() {
		return recommendClassId;
	}

	public void setRecommendClassId(Integer recommendClassId) {
		this.recommendClassId = recommendClassId;
	}

	public Double getRecommendClassFee() {
		return recommendClassFee;
	}

	public void setRecommendClassFee(Double recommendClassFee) {
		this.recommendClassFee = recommendClassFee;
	}

	public String getRecommendClassName() {
		return recommendClassName;
	}

	public void setRecommendClassName(String recommendClassName) {
		this.recommendClassName = recommendClassName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecommend_class_label() {
		return recommend_class_label;
	}

	public void setRecommend_class_label(String recommend_class_label) {
		this.recommend_class_label = recommend_class_label;
	}

	public String getRecommend_class_active() {
		return recommend_class_active;
	}

	public void setRecommend_class_active(String recommend_class_active) {
		this.recommend_class_active = recommend_class_active;
	}
	
	
	
	

}
