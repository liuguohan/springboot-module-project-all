package com.biyouche.dao.drive;

import com.biyouche.domain.drive.Subjects;
import com.biyouche.domain.drive.vo.SubjectVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * created by pht on 2018/7/27 0027
 */
public interface SubjectMapper {


    /**
     * 项目详情
     * @param subject_id
     * @return
     */
    @Select("SELECT subject_id,subject_name,subject_content,subject_image,video_url,play_num,pass_rate " +
            "FROM drive_subject WHERE subject_id = #{subject_id}")
    SubjectVO selectDetailById(Integer subject_id);

    @Select("SELECT subject_id,subject_name,subject_synopsis,subject_image,play_num,pass_rate " +
            "FROM drive_subject WHERE subject_type = #{subject_type} AND status = 0")
    List<Subjects> selectListByType(Integer subject_type);
}
