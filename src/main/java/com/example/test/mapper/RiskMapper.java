package com.example.test.mapper;

import com.example.test.entity.Risk;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface RiskMapper {

    @Insert("insert into risk(riskName,time,picPath,address,level) values(#{riskName},#{time},#{picPath},#{address},#{level})")
    public int insertRisk(String riskName, long time,String picPath,String address,int level);
//    @Results({
//            @Result(column = "id",property = "id"),
//            @Result(column = "time",property = "time"),
//            @Result(column = "picPath",property = "picPath",jdbcType = JdbcType.VARCHAR),
//            @Result(column = "address",property = "address"),
//            @Result(column = "riskName",property = "riskName"),
//    })
    @Select("select * from risk order by id desc limit #{startNumber},#{endNumber}")
    public List<Risk> getRiskByPage(int startNumber,int endNumber);

    @Select("select * from risk where picPath = #{picPath}")
    public Risk getRiskByPicPath(String picPath);

    @Select("select * from risk where address=#{workshop} order by id desc limit #{startNumber},#{endNumber}")
    public List<Risk> getRiskByWorkshop(String workshop,int startNumber,int endNumber);

    @Select("select * from risk where id=#{id}")
    public Risk getRiskById(int id);

    //返回的int为行数
    @Update("update risk set description=#{description} where id=#{id}")
    public int addRiskDescription(int id,String description);

    //返回的int为受到影响的行数
    @Delete("delete from risk where id=#{id}")
    public int deleteRisk(int id);

    @Select("select * from risk where address=#{workshop} and level>=#{level} order by id desc")
    public List<Risk> getRiskByWorkshopAndLevel(String workshop,int level);

    //返回查询到的数量
    @Select("select count(*) from risk where time between #{startTime} and #{endTime} and level=#{level}")
    public int getRiskNumByLevel(long startTime,long endTime, int level);

    @Select("select count(*) from risk where time between #{startTime} and #{endTime} and riskName=#{riskName}")
    public int getRiskNumByRiskName(long startTime,long endTime,String riskName);

}
