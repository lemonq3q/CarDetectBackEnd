package com.example.test.mapper;

import com.example.test.entity.NowTemperature;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NowTemperatureMapper {

    @Select("select * from nowTemperature where workshop=#{workshop}")
    public NowTemperature getNowTemperature(String workshop);

    @Update("update nowTemperature set temperature=#{temperature},time=#{time} where workshop=#{workshop}")
    public int updateTemperature(String workshop,float temperature,long time);

    @Select("select count(*) from temperatures where workshop=#{workshop}")
    public int getTemperatureNum(String workshop);

    @Insert("insert into nowTemperature values(#{workshop},#{time},#{temperature})")
    public void insertTemperature(String workshop,float temperature,long time);
}
