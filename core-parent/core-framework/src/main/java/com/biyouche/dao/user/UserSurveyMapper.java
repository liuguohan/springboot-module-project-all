package com.biyouche.dao.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.biyouche.domain.user.UserSurvey;

/**
 * 用户调研接口
 * @author hucong
 *
 */
public interface UserSurveyMapper {

	@Insert("insert into user_survey(user_id,sex,apply_status,driver_purpose,ddriver_type,create_time)"
			+ "values(#{userId},#{sex},#{applyStatus},#{driverPurpose},#{ddriverType},UNIX_TIMESTAMP())")
	@Options(useGeneratedKeys=true, keyProperty="surveyId", keyColumn="survey_id") 
	int insert(UserSurvey survey);
}
