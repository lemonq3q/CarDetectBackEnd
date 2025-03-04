package com.example.test.mapper;

import com.example.test.entity.NowHumidity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NowHumidityMapper {

    @Select("select * from nowHumidity where workshop=#{workshop}")
    public NowHumidity getNowHumidity(String workshop);

    @Select("select count(*) from nowHumidity where workshop=#{workshop}")
    public int getHumidityNum(String workshop);

    @Update("update nowHumidity set humidity=#{humidity},time=#{time} where workshop=#{workshop}")
    public int updateHumidity(String workshop,float humidity,long time);

    @Insert("insert into nowHumidity values(#{workshop},#{time},#{humidity})")
    public int insertHumidity(String workshop,long time,float humidity);
}
