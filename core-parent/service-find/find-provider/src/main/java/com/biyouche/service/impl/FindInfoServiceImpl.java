package com.biyouche.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.constants.FindConstant;
import com.biyouche.dao.find.FindInfoMapper;
import com.biyouche.domain.find.model.FindInfoCoverModel;
import com.biyouche.domain.find.model.FindInfoDetailModel;
import com.biyouche.exception.BussinessException;
import com.biyouche.redis.annotations.Cacheable;
import com.biyouche.redis.enums.ExpireTime;
import com.biyouche.redis.prefix.RedisKeyPrefix;
import com.biyouche.service.FindInfoService;
import com.biyouche.utils.TimeUtils;
import com.biyouche.utils.ValidatorUtils;

/**
 * 发现资讯模块业务实现
 * @author lgh
 *
 */
@Service("findInfoService")
public class FindInfoServiceImpl implements FindInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindInfoServiceImpl.class);
    
    @Autowired
    private FindInfoMapper findInfoMapper;

	@Override
	@Cacheable(key = RedisKeyPrefix.SUBMODULE_ARTICLE_LIST + "#findId", expire = ExpireTime.FIVE_MIN)
	public Map<String, Object> submoduleArticleList(Integer findId) {

		LOGGER.info("发现资讯子模块文章列表查询库信息 ......");
		
		List<FindInfoCoverModel> findInfoCoverList = findInfoMapper.submoduleArticleList(findId, FindConstant.DELSTATUS_VALID);
		
		if(ValidatorUtils.isNotEmpty(findInfoCoverList)) {
		
			//设置创建时间格式
			for(FindInfoCoverModel model : findInfoCoverList) {
				Integer createTime = model.getCreateTime();
				String createTimeStr = TimeUtils.timeStampToDateStr(createTime, TimeUtils.yyyyMMddHHmm);
				model.setCreateTimeStr(createTimeStr);
			}
		}
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("findInfoCoverList", findInfoCoverList);
		
		return result;
	}

	@Override
	@Cacheable(key = RedisKeyPrefix.SUBMODULE_ARTICLE_DETAIL + "#infoId", expire = ExpireTime.FIVE_MIN)
	public Map<String, Object> submoduleArticleDetail(Integer infoId) throws BussinessException {
		
		LOGGER.info("发现资讯子模块文章详情查询库信息 ......");
		
		FindInfoDetailModel findInfoDetail = findInfoMapper.submoduleArticleDetail(infoId, FindConstant.DELSTATUS_VALID);
		
		if( findInfoDetail == null ) {
			throw new BussinessException(230002);
		}
		
		//设置创建时间格式
		String createTimeStr = TimeUtils.timeStampToDateStr(findInfoDetail.getCreateTime(), TimeUtils.yyyyMMddHHmm);
		findInfoDetail.setCreateTimeStr(createTimeStr);
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("infoId", infoId);
		result.put("infoTitle", findInfoDetail.getInfoTitle());
		result.put("infoContent", findInfoDetail.getInfoContent());
		result.put("createTimeStr", findInfoDetail.getCreateTimeStr());
		
		return result;
	}

   
}
