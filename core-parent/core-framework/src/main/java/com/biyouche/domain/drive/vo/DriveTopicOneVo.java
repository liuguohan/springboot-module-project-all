package com.biyouche.domain.drive.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 科目一考题参数
 * @author hc
 *
 */
public class DriveTopicOneVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5639808859536668299L;
	
	/**
	 * 题编号
	 */
	private Integer id;
	
	/**
	 * 题目类型[0:单选题 1:多选题 2:判断题]
	 */
	private Integer title_type;
	
	/**
	 * 问题内容
	 */
	private String question;
	
	/**
	 * 答案选项
	 */
	private String answer_select;
	
	/**
	 * 答案
	 */
	private String answer;
	
	/**
	 * 考题详解内容
	 */
	private String examination_paper;
	
	/**
	 * 题目图片
	 */
	private String image;
	
	/**
	 * 考题详解图片
	 */
	private String examination_image;
	
	/**
	 * 详解视频链接
	 */
	private String examination_url;
	
	/**
	 * 专题所属类型
	 */
	private String special_title;
	
	private List selectArr;
	
	private List answerArr;
	
	private List answerArrIndex;
	
	private String image_gif;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTitle_type() {
		return title_type;
	}

	public void setTitle_type(Integer title_type) {
		this.title_type = title_type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer_select() {
		return answer_select;
	}

	public void setAnswer_select(String answer_select) {
		this.answer_select = answer_select;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getExamination_paper() {
		return examination_paper;
	}

	public void setExamination_paper(String examination_paper) {
		this.examination_paper = examination_paper;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getExamination_image() {
		return examination_image;
	}

	public void setExamination_image(String examination_image) {
		this.examination_image = examination_image;
	}

	public String getExamination_url() {
		return examination_url;
	}

	public void setExamination_url(String examination_url) {
		this.examination_url = examination_url;
	}

	public String getSpecial_title() {
		return special_title;
	}

	public void setSpecial_title(String special_title) {
		this.special_title = special_title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List getSelectArr() {
		return selectArr;
	}

	public void setSelectArr(List selectArr) {
		this.selectArr = selectArr;
	}

	public List getAnswerArr() {
		return answerArr;
	}

	public void setAnswerArr(List answerArr) {
		this.answerArr = answerArr;
	}

	public List getAnswerArrIndex() {
		return answerArrIndex;
	}

	public void setAnswerArrIndex(List answerArrIndex) {
		this.answerArrIndex = answerArrIndex;
	}

	public String getImage_gif() {
		return image_gif;
	}

	public void setImage_gif(String image_gif) {
		this.image_gif = image_gif;
	}

	
	
	

}
