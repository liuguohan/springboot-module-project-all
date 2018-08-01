package com.biyouche.dao.drive;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biyouche.domain.drive.DriveTitleComment;
import com.biyouche.domain.drive.vo.TitleCommentVo;

/**
 * 科一 科四题目评论
 * @author hc
 *
 */
public interface TitleCommentMapper {

	
	
	/**
	 * 题目评论列表
	 * @return
	 */
	@Select("select id,user_id,comment,praise_num from drive_title_comment where del_status = 0 and subject_type = #{subject_type} and title_no = #{title_no}")
	List<TitleCommentVo> titleCommentList(@Param("subject_type")Integer subject_type,@Param("title_no") String title_no);
	
	/**
	 * 点赞
	 * @return
	 */
	@Update("update drive_title_comment set praise_num = praise_num+1 where del_status = 0 and id = #{id}")
	int praise(Integer id);
	
	
	/**
	 * 评价
	 * @return
	 */
	@Insert("insert into drive_title_comment(user_id,title_no,subject_type,comment,create_time)"
			+ "values(#{userId},#{titleNo},#{subjectType},#{comment},UNIX_TIMESTAMP())")
	int addComment(DriveTitleComment comment);
}
