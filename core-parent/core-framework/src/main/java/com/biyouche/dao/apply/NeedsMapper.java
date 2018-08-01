package com.biyouche.dao.apply;

import com.biyouche.domain.apply.Needs;
import org.apache.ibatis.annotations.*;

/**
 * 学车需求
 */
public interface NeedsMapper {

    /**
     * 新增学车需求
     *
     * @param needs
     * @return
     */
    @Insert("INSERT INTO user_learn_needs (user_id,real_name,phone,address,longitude,latitude,licence_type,factors,create_time) " +
            "VALUES(#{needs.userId},#{needs.realName},#{needs.phone},#{needs.address},#{needs.longitude},#{needs.latitude},#{needs.licenceType},#{needs.factors},#{needs.createTime}) ")
    @Options(useGeneratedKeys = true, keyProperty = "needs.needsId", keyColumn = "needs_id")
    void addNeeds(@Param("needs") Needs needs);

    /**
     * 报名成功的用户
     *
     * @param status
     * @return
     */
    @Select("SELECT COUNT(0) FROM learn_order WHERE pay_status = #{status}")
    Integer selectSuccessNum(int status);

    @Select("SELECT school_id FROM user_learn_needs WHERE user_id = #{userId} AND needs_id = #{needsId}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "needsId", column = "needs_id"),
            @Result(property = "schoolId", column = "school_id")
    })
    Needs selectByUserIdAndNeedsId(@Param("userId") int userId, @Param("needsId") Integer needsId);

    @Delete("DELETE FROM user_learn_needs WHERE needs_id = #{needsId} ")
    void deleteById(@Param("needsId") Integer needsId);
}
