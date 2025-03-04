package com.example.test.mapper;

import com.example.test.entity.Meter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MeterMapper {
    @Insert("insert into meter value(#{workshop},#{type},#{time},#{unit},#{value})")
    public void insertMeterData(String workshop,int type,long time,String unit,float value);

    @Select("select * from meter where workshop=#{workshop} order by time desc limit 0,1")
    public Meter getNewDataByWorkshop(String workshop);
}
