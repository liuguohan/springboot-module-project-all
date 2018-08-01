package com.biyouche.dao.drive;

import com.biyouche.domain.drive.DriveVideo;
import com.biyouche.domain.drive.vo.DriveVideoVO;
import com.biyouche.domain.drive.vo.RecommendVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * created by pht on 2018/7/26 0026
 */
public interface VideoMapper {

    /**
     * 查询视频列表
     * @param subject_type
     * @param video_type
     * @return
     */
    @SelectProvider(method = "getVideoListSql", type = VideoList.class)
    List<DriveVideoVO> selectVideoList(Integer subject_type, Integer video_type);

    /**
     * 视频详情
     * @param video_id
     * @return
     */
    @Select("SELECT video_title,video_url,video_image,play_num,comment_num,create_time,video_content " +
            "FROM drive_video WHERE video_id = #{videoId} AND status = 0")
    DriveVideo selectById(@Param("videoId") Integer video_id);

    /**
     * 视频推荐列表
     * @param video_id
     * @return
     */
    @Select("SELECT video_id,video_title,video_image,play_num FROM drive_video WHERE video_id != #{videoId} ORDER BY RAND() limit 3")
    List<RecommendVO> selectRecommend(@Param("videoId") Integer video_id);

    /**
     * 更新评论数量
     * @param video_id
     */
    @Update("UPDATE drive_video SET comment_num = comment_num + 1 WHERE video_id = #{videoId}")
    void updateCommentNum(@Param("videoId") Integer video_id);

    /**
     * 考试项目详情的视频推荐
     * @return
     */
    @Select("SELECT video_id,video_title,video_image,play_num FROM drive_video ORDER BY RAND() limit 3")
    List<RecommendVO> getRecommend();

    class VideoList {
        public String getVideoListSql(Integer subject_type, Integer video_type) {
            String sql = "SELECT video_id,video_title,video_url,video_image,play_num,comment_num " +
                    "FROM drive_video WHERE subject_type = " + subject_type + " AND status = 0";
            //判断是否为精选视频列表,按照播放量排序
            if (video_type == 1){
                sql = sql + " ORDER BY play_num DESC";
            }
            if (video_type == 2){
                sql = sql + " ORDER BY play_num DESC limit 2";
            }
            return sql;
        }
    }
}
