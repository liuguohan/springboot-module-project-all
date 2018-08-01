package com.biyouche.dao.apply;

import com.biyouche.domain.apply.Place;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PlaceMapper {

    @Select("SELECT id,place_name,practice_type,school_id,address,image,lat,lng FROM school_place WHERE school_id = #{schoolId} AND del_status = 0")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "placeName",column = "place_name"),
            @Result(property = "practiceType",column = "practice_type"),
            @Result(property = "schoolId",column = "school_id"),
            @Result(property = "image",column = "image"),
            @Result(property = "lat",column = "lat"),
            @Result(property = "lng",column = "lng")
    })
    List<Place> selectBySchool(Integer schoolId);
}
