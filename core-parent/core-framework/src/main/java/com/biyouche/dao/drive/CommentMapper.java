package com.biyouche.dao.drive;

import com.biyouche.domain.drive.SubjectComment;
import com.biyouche.domain.drive.VideoComment;
import com.biyouche.domain.drive.vo.CommentVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 评论相关
 * created by pht on 2018/7/26 0026
 */
public interface CommentMapper {

    /**
     * 视频评论列表
     * @param video_id
     * @return
     */
    @Select("SELECT dv.comment_id,dv.user_id,dv.content,dv.create_time,dv.praise_num,u.nick_name,u.avatar_url " +
            "FROM drive_video_comment dv LEFT JOIN user u ON dv.user_id = u.user_id WHERE dv.video_id = #{videoId} AND dv.status = 0")
    List<CommentVo> selectListByVideoId(@Param("videoId") Integer video_id);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Insert("INSERT INTO drive_video_comment (user_id,video_id,content,create_time) " +
            "VALUES (#{c.user_id},#{c.video_id},#{c.content},#{c.create_time})")
    int insertComment(@Param("c") VideoComment comment);

    /**
     * 更新点赞数
     * @param comment_id
     */
    @Update("UPDATE drive_video_comment SET praise_num = praise_num + 1 WHERE comment_id = #{commentId}")
    void updatePraiseNum(@Param("commentId") Integer comment_id);

    /**
     * 考试项目评论列表
     * @param subject_id
     * @return
     */
    @Select("SELECT dv.comment_id,dv.user_id,dv.content,dv.create_time,dv.praise_num,u.nick_name,u.avatar_url " +
            "FROM drive_subject_comment dv LEFT JOIN user u ON dv.user_id = u.user_id WHERE dv.subject_id = #{subject_id} AND dv.status = 0")
    List<CommentVo> selectListBySubjectId(Integer subject_id);

    /**
     * 考试评论
     * @param comment
     * @return
     */
    @Insert("INSERT INTO drive_subject_comment (user_id,subject_id,content,create_time) " +
            "VALUES (#{c.user_id},#{c.subject_id},#{c.content},#{c.create_time})")
    int insertSubjectComment(@Param("c") SubjectComment comment);

    /**
     * 考试项目评论点赞
     * @param comment_id
     */
    @Update("UPDATE drive_subject_comment SET praise_num = praise_num + 1 WHERE comment_id = #{commentId}")
    void updateSubjectPraiseNum(Integer comment_id);
}
