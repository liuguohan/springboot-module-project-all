package com.biyouche.domain.find.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.biyouche.domain.find.FindCommunityTheme;
import com.biyouche.exception.BussinessException;

/**
 * 社区话题模块
 * @author lgh
 *
 */
public class FindCommunityThemeModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 4619803619647831289L;

	/**
	 * 社区话题ID
	 */
	private Integer themeId;
	
	/**
	 * 用户昵称
	 */
	private String nickName;
	
	/**
	 * 用户头像
	 */
	private String avatarUrl;
	
	/**
	 * 话题类型 0 普通 1 精选
	 */
	private Integer themeType;
	
	/**
	 * 话题标题
	 */
	private String themeTitle;
	
	/**
	 * 话题内容
	 */
	private String themeContent;
	
	/**
	 * 标签数组
	 */
	private String themeLabel;
	
	/**
	 * 回答数
	 */
	private Integer replyNum;
	
	/**
	 * FindCommunityThemeModel属性赋值到FindCommunityTheme
	 * @param model
	 */
	public static FindCommunityTheme getInstance(FindCommunityThemeModel model) {
		
		FindCommunityTheme theme = new FindCommunityTheme();
		try {
			BeanUtils.copyProperties(theme, model);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new BussinessException();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new BussinessException();
		}
		return theme;
	}

	public Integer getThemeId() {
		return themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Integer getThemeType() {
		return themeType;
	}

	public void setThemeType(Integer themeType) {
		this.themeType = themeType;
	}

	public String getThemeContent() {
		return themeContent;
	}

	public void setThemeContent(String themeContent) {
		this.themeContent = themeContent;
	}

	public String getThemeTitle() {
		return themeTitle;
	}

	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}

	public String getThemeLabel() {
		return themeLabel;
	}

	public void setThemeLabel(String themeLabel) {
		this.themeLabel = themeLabel;
	}

	public Integer getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}

	@Override
	public String toString() {
		return "FindCommunityThemeModel [themeId=" + themeId + ", nickName=" + nickName + ", avatarUrl=" + avatarUrl
				+ ", themeType=" + themeType + ", themeTitle=" + themeTitle + ", themeContent=" + themeContent
				+ ", themeLabel=" + themeLabel + ", replyNum=" + replyNum + "]";
	}
	
	
	
}
