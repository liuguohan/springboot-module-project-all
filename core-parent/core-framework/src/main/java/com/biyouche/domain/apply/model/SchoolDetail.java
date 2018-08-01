package com.biyouche.domain.apply.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 驾校实体类传参
 * @author hucong
 *
 */
public class SchoolDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -743980533122681287L;
	
	/*驾校id**/
	private Integer id;
	
	/*驾校评分**/
	private Double score;
	
	/*驾校排名**/
	private Integer ranking;
	
	/*通过率**/
	private Integer passRate;
	
	/*地址**/
	private String address;
	
	/*驾校标签**/
	private String label;
	
	/*照片**/
	private String image;
	
	/*名字**/
	private String name;
	
	/*纬度**/
	private String lat;
	
	/*经度**/
	private String lng;
	
	/*省编号**/
	private String provinceCode;
	
	/*市编号**/
	private String cityCode;
	
	/*区编号**/
	private String areaCode;
	
	/*推荐班级id**/
	private Integer recommendClassId;
	
	/*查询类型 [0 推荐驾校 1 距离最近 2 价格最低 3 评分最好]**/
	private Integer selectType;
	
	/*距离**/
	private Double distance;
	
	/*区名字**/
	private String areaCodeName;

	//驾校水平
	private Integer schoolLevel;



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

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Integer getPassRate() {
		return passRate;
	}

	public void setPassRate(Integer passRate) {
		this.passRate = passRate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getRecommendClassId() {
		return recommendClassId;
	}

	public void setRecommendClassId(Integer recommendClassId) {
		this.recommendClassId = recommendClassId;
	}

	public Integer getSelectType() {
		return selectType;
	}

	public void setSelectType(Integer selectType) {
		this.selectType = selectType;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getAreaCodeName() {
		return areaCodeName;
	}

	public void setAreaCodeName(String areaCodeName) {
		this.areaCodeName = areaCodeName;
	}

	public Integer getSchoolLevel() {
		return schoolLevel;
	}

	public void setSchoolLevel(Integer schoolLevel) {
		this.schoolLevel = schoolLevel;
	}

	@Override
	public String toString() {
		return "SchoolDetail{" +
				"id=" + id +
				", score=" + score +
				", ranking=" + ranking +
				", passRate=" + passRate +
				", address='" + address + '\'' +
				", label='" + label + '\'' +
				", image='" + image + '\'' +
				", name='" + name + '\'' +
				", lat='" + lat + '\'' +
				", lng='" + lng + '\'' +
				", provinceCode='" + provinceCode + '\'' +
				", cityCode='" + cityCode + '\'' +
				", areaCode='" + areaCode + '\'' +
				", recommendClassId=" + recommendClassId +
				", selectType=" + selectType +
				", distance=" + distance +
				", areaCodeName='" + areaCodeName + '\'' +
				", schoolLevel=" + schoolLevel +
				'}';
	}
}
