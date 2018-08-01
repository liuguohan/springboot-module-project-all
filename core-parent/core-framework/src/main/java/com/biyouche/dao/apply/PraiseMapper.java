package com.biyouche.dao.apply;

import com.biyouche.domain.apply.Praise;
import com.biyouche.domain.apply.model.EvaluationVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

import com.biyouche.domain.apply.Evaluation;

public interface PraiseMapper {


	@Insert("insert into school_evaluation(school_id,user_id,level,evaluation_content,evaluation_time,teaching_service,environmental,driver_speed)"
			+ "values(#{schoolId},#{userId},#{level},#{evaluationContent},UNIX_TIMESTAMP(),#{teachingService},#{environmental},#{driverSpeed})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	int insertEvaluation(Evaluation evaluation);

    /**
     * 查询驾校的所有评价
     *
     * @param schoolId
     * @return
     */
    @Select("SELECT se.id,se.school_id,se.user_id,se.evaluation_content,se.evaluation_image," +
            "se.evaluation_time,se.level,se.praise_num,u.nick_name,u.avatar_url " +
            "FROM school_evaluation se LEFT JOIN user u ON se.user_id = u.user_id " +
            "WHERE se.school_id = #{schoolId} AND se.del_status = 0")
//    @Results({
//            @Result(property = "user_id", column = "se.user_id"),
//            @Result(property = "evaluationContent", column = "se.evaluation_content"),
//            @Result(property = "evaluationTime", column = "se.evaluation_time"),
//            @Result(property = "schoolId", column = "se.school_id"),
//            @Result(property = "praiseNum", column = "se.praise_num"),
//            @Result(property = "userName",column = "u.nick_name"),
//            @Result(property = "avatarUrl",column = "u.avatar_url")
//    })
    List<EvaluationVO> selectBySchoolId(Integer schoolId);

    /**
     * 查询点赞ids
     *
     * @param userId
     * @param evIds
     * @return
     */
    @SelectProvider(type = PraiseDaoProvider.class, method = "findPraiseByIds")
    List<Integer> selectPraiseByIds(Integer userId, List<Integer> evIds);

    /**
     * 查询该用户该评论是否点赞过
     * @param userId
     * @param id
     * @return
     */
    @Select("SELECT COUNT(0) FROM school_praise WHERE user_id = #{userId} AND evaluation_id = #{evaluationId}")
    int selectSaluteById(@Param("userId") Integer userId, @Param("evaluationId") Integer id);

    /**
     * 添加点赞记录
     * @param praise
     * @return
     */
    @Insert("INSERT INTO school_praise (user_id,evaluation_id,create_time) " +
            "VALUES (#{praise.userId},#{praise.evaluationId},#{praise.createTime})")
    int insertIntoSalute(@Param("praise") Praise praise);

    /**
     * 更新评论点赞个数
     * @param id
     */
    @Update("UPDATE school_evaluation SET praise_num = praise_num + 1 WHERE id = #{id}")
    void updatePraiseNum(Integer id);

    /**
     * 动态sql拼接
     */
    class PraiseDaoProvider {
        public String findPraiseByIds(Integer userId, List<Integer> evIds) {
            String sql = "SELECT evaluation_id FROM school_praise where user_id = " + userId + " AND evaluation_id IN";
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i = 0; i < evIds.size(); i++) {
                sb.append(evIds.get(i));
                if (i < evIds.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            return sql + sb.toString();
        }
    }
}
