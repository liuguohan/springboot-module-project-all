package com.biyouche.mybatis.dict;

/**
 * 数据字典自定义sql
 * @author lgh
 *
 */
public class DictSqlProvider {

	/**
	 * 获取数据字典启用的数据
	 * @return
	 */
	public String dictList() {
		
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT type.dict_id, type.dict_type, type.dict_name, item.item_id, item.item_name, item.item_value, item.sort ");
		sql.append(" FROM dict_item item INNER JOIN dict_type type ON item.dict_id = type.dict_id WHERE item.`status` = 0 ");
		
        return sql.toString();
    }
	
}
