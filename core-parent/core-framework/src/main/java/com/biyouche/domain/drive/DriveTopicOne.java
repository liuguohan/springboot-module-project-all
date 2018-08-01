package com.biyouche.domain.drive;

import java.io.Serializable;

/**
 * 科目一驾考题
 * @author HC
 *
 */
public class DriveTopicOne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2834110271422391914L;
	
	/**
	 * 题编号
	 */
	private Integer id;
	
	/**
	 * 题目类型[0:单选题 1:多选题 2:判断题]
	 */
	private Integer titleType;
	
	/**
	 * 问题内容
	 */
	private String question;
	
	/**
	 * 答案选项
	 */
	private String answerSelect;
	
	/**
	 * 答案
	 */
	private String answer;
	
	/**
	 * 考题详解内容
	 */
	private String examinationPaper;
	
	/**
	 * 题目图片
	 */
	private String image;
	
	/**
	 * 考题详解图片
	 */
	private String examinationImage;
	
	/**
	 * 详解视频链接
	 */
	private String examinationUrl;
	
	/**
	 * 专题所属类型
	 */
	private String specialTitle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTitleType() {
		return titleType;
	}

	public void setTitleType(Integer titleType) {
		this.titleType = titleType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerSelect() {
		return answerSelect;
	}

	public void setAnswerSelect(String answerSelect) {
		this.answerSelect = answerSelect;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getExaminationPaper() {
		return examinationPaper;
	}

	public void setExaminationPaper(String examinationPaper) {
		this.examinationPaper = examinationPaper;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getExaminationImage() {
		return examinationImage;
	}

	public void setExaminationImage(String examinationImage) {
		this.examinationImage = examinationImage;
	}

	public String getExaminationUrl() {
		return examinationUrl;
	}

	public void setExaminationUrl(String examinationUrl) {
		this.examinationUrl = examinationUrl;
	}

	public String getSpecialTitle() {
		return specialTitle;
	}

	public void setSpecialTitle(String specialTitle) {
		this.specialTitle = specialTitle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
