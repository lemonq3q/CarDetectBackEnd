package com.example.test.mapper;

import com.example.test.entity.Employee;
import com.example.test.entity.NowPosition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface NowPositionMapper {
    @Select("select * from nowPosition where cardId=#{cardId}")
    public NowPosition getNowPositionByCardId(String cardId);

    @Select("select * from nowPosition")
    public List<NowPosition> getNowPosition();

    @Update("update nowPosition set workshop=#{workshop},time=#{time} where cardId=#{cardId}")
    public int updateNowPosition(String cardId, String workshop, Timestamp time);

    @Insert("insert into nowPosition values(#{cardId},#{time},#{workshop})")
    public int insertNowPosition(String cardId,Timestamp time,String workshop);

    @Select("select * from employee where cardId in (select cardId from nowPosition where workshop=#{workshop})")
    public List<Employee> getWorkersByWorkshop(String workshop);
}
