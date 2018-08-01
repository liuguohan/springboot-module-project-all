package com.biyouche.dao.drive;

import com.biyouche.domain.apply.model.Banners;
import com.biyouche.domain.drive.vo.BannerVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * created by pht on 2018/7/27 0027
 */
public interface BannerMapper {
    @Select("SELECT banner_id,banner_url FROM subject_banner WHERE subject_type = #{subject_type} AND status = 0")
    BannerVO getBanner(Integer subject_type);

    @Select("SELECT banner_id,banner_url FROM ad_banner WHERE local = #{local} AND status = 0")
    List<Banners> getBannerByLocal(int local);
}
