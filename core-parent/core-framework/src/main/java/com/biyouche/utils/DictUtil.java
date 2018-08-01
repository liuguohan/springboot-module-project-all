package com.biyouche.utils;

import java.util.LinkedList;
import java.util.List;

import com.biyouche.dao.dict.DictMapper;
import com.biyouche.domain.dict.model.Dict;
import com.biyouche.redis.enums.RedisKeyEnum;
import com.biyouche.redis.utils.RedisTempleteUtils;
import com.biyouche.springboot.SpringContext;

/**
 * 数据字典工具类
 * @author lgh
 *
 */
public class DictUtil {

	@SuppressWarnings("unchecked")
	public static List<Dict> getAll() {
		
		return (List<Dict>)RedisTempleteUtils.getObj(RedisKeyEnum.DICT.KEY);
	}
	
	public static List<Dict> getDict(String dictType) {
		
		List<Dict> subDictList = new LinkedList<Dict>();
		boolean reset = false;
		
		
		List<Dict> dictCacheList = getAll();
		List<Dict> newDictList = null;
		for(Dict dict : dictCacheList) {
			if( dict.getDictType().equals(dictType) ) {
				subDictList.add(dict);
			}
		}
		
		if( subDictList.size() == 0 ) {
			DictMapper dictMapper = SpringContext.getBean(DictMapper.class);
			newDictList = dictMapper.dictList();
			for(Dict newDict : newDictList) {
				if( newDict.getDictType().equals(dictType) ) {
					reset = true;
					subDictList.add(newDict);
				}
			}
		}
		
		if(reset) {
			RedisTempleteUtils.set(RedisKeyEnum.DICT.KEY, newDictList, 0);
		}
		
		return subDictList;
	}
	
	
}
