package com.biyouche.domain.dict.model;

import java.io.Serializable;

/**
 * 数据字典
 * @author lgh
 *
 */
public class Dict implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -3211189658229199868L;

	/**
	 * 字典类型ID
	 */
	private Integer dictId;
	
	/**
	 * 字典类型
	 */
	private String dictType;
	
	/**
	 * 字典名称
	 */
	private String dictName;
	
	/**
	 * 字典类型条目ID
	 */
	private Integer itemId;
	
	/**
	 * 字典内容
	 */
	private String itemName;
	
	/**
	 * 字典值
	 */
	private String itemValue;
	
	/**
	 * 排序序号
	 */
	private Integer sort;

	public Dict() {
		super();
	}

	public Integer getDictId() {
		return dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "Dict [dictId=" + dictId + ", dictType=" + dictType + ", dictName=" + dictName + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", itemValue=" + itemValue + ", sort=" + sort + "]";
	}
	
}
