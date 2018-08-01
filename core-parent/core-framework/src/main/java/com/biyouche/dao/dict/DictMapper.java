package com.biyouche.dao.dict;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.biyouche.domain.dict.model.Dict;
import com.biyouche.mybatis.dict.DictSqlProvider;

/**
 * 数据字典
 * @author lgh
 *
 */
@Mapper
public interface DictMapper {

	/**
	 * 获取数据字典启用的数据
	 * @return
	 */
	@SelectProvider(type = DictSqlProvider.class, method = "dictList")
	@Results({
		@Result(property = "dictId", column = "dict_id" ),
		@Result(property = "dictType", column = "dict_type"),
		@Result(property = "dictName", column = "dict_name"),
		@Result(property = "itemId", column = "item_id"),
		@Result(property = "itemName", column = "item_name"),
		@Result(property = "itemValue", column = "item_value"),
		@Result(property = "sort", column = "sort")
	})
    List<Dict> dictList();
	
}
