package com.example.test.mapper;

import com.example.test.entity.InspectPoint;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InspectPointMapper {

    @Select("select * from inspect_points where workshop = #{workshop} order by seq ")
    public List<InspectPoint> getPointByWorkshop(String workshop);

    @Delete("delete from inspect_points where workshop = #{workshop}")
    public int deletePoint(String workshop);

    @Insert("insert into inspect_points values(#{workshop},#{seq},#{point})")
    public int addPoint(String workshop,int seq,String point);
}
