package com.biyouche.dao.apply;

import com.biyouche.domain.apply.NeedsCancel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface NeedsCancelMapper {

    @Insert("INSERT INTO user_needs_cancel(apply_id,needs_id,reason,remark,cancel_time,user_id,school_id) " +
            "VALUES (#{nc.applyId},#{nc.needsId},#{nc.reason},#{nc.remark},#{nc.cancelTime},#{nc.userId},#{nc.schoolId})")
    int addCancel(@Param("nc") NeedsCancel needsCancel);
}
