//mapper文件用于操作数据库
package com.example.test.mapper;


import com.example.test.entity.Attendance;
import com.example.test.entity.Employee_attendance;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface AttendanceMapper{

    //使用了MyBatis框架的注解方式来映射SQL查询语句
    //#{}：是命名参数占位符
    //@Select是MyBatis的注释，用来声明一个查询语句

    //0：没到（无故）；  1：到了   2：请假（有故）

    //获得到场员工数目
    @Select("select count(*) from attendance where cardId=#{cardId} and to_days(time)=to_days(#{time}) and isAttendance!=2")
    //对应的Java方法，用于执行该语句并返回一个int结果
    public int getAttendanceByCardIdAndTime(String cardId, Timestamp time);

    //获得离开员工的信息
    @Select("select * from attendance where cardId=#{cardId} and to_days(time)=to_days(#{time}) and isAttendance=2")
    //返回Attendance类型的数据
    public Attendance getExitByCardIdAndTime(String cardId, Timestamp time);

    //插入一条记录
    @Insert("insert into attendance values(#{cardId},#{time},#{isAttendance},#{note})")
    //返回值为int
    public int insertAttendance(String cardId,Timestamp time,int isAttendance,String note);

    //获取员工的考勤信息
    @Select("select id,name,employee.cardId,managerId,seniority,sex,position,time,isAttendance,note " +
            "from employee,attendance " +
            "where employee.cardId=attendance.cardId " +
            "and employee.id=#{id} and time between #{startTime} and #{endTime} " +
            "order by time desc")//按时间的降序排序
    //List<Employee_attendance>
    public List<Employee_attendance> getAttendanceById(int id, Timestamp startTime, Timestamp endTime);

    //
    @Select("select * from attendance " +
            "where cardId in (" +
            "select cardId from employee " +
            "where id=#{id}) and time=#{time}")

    //Attendance
    public Attendance getAttendanceByIdAndTime(int id,Timestamp time);


    //修改表中数据
    @Update("update attendance set time=#{time} " +
            "where cardId=#{cardId} and to_days(time)=to_days(#{time}) and isAttendance=2")
    //
    public int UpdateExitTimeByCardIdAndTime(String cardId, Timestamp time);


}
