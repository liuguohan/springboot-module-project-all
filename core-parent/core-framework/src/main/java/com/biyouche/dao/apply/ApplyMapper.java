package com.biyouche.dao.apply;

import com.biyouche.domain.apply.Apply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {

    /**
     * 删除申请数据
     * @param applyId
     */
    @Delete("DELETE FROM user_apply_info WHERE apply_id = #{applyId}")
    void deleteById(Integer applyId);

    /**
     * 添加申请数据
     * @param apply
     * @return
     */
    @Insert("INSERT INTO user_apply_info (user_id,phone,real_name,school_id,apply_time) " +
            "VALUES (#{apply.userId},#{apply.phone},#{apply.realName},#{apply.schoolId},#{apply.applyTime})")
    @Options(useGeneratedKeys = true,keyProperty = "apply.applyId",keyColumn = "apply_id")
    Integer addApply(@Param("apply") Apply apply);


}
