package com.example.test.mapper;

import com.example.test.entity.Employee;
import com.example.test.entity.Employee_attendance;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee")
    public List<Employee> getAllEmployee();

    @Insert("insert into employee(name,cardId,managerId,seniority,sex,position,headshot,phone) values(#{name}," +
            "#{cardId},#{managerId},#{seniority},#{sex},#{position},#{headshot},#{phone})")
    public int addEmployee(String name,String cardId,int managerId,int seniority,int sex,String position,String headshot,String phone);

    @Update("update employee set name=#{name},cardId=#{cardId},managerId=#{managerId},seniority=#{seniority}," +
            "sex=#{sex},position=#{position},phone=#{phone},headshot=#{headshot} where id=#{id}")
    public int updateEmployee(int id,String name,String cardId,int managerId,int seniority,int sex,String position,String phone,String headshot);

    @Delete("delete from employee where id=#{id}")
    public int deleteEmployee(int id);

    @Select("select * from employee where managerId=#{managerId} order by id limit #{startNumber},#{endNumber}")
    public List<Employee> getEmployeeByManagerId(int managerId,int startNumber,int endNumber);

    //#{startNumber}：表示查询开始的偏移量，即跳过前面多少条记录。
    //#{endNumber}：表示要返回的记录数。（返回的记录数）
    @Select("select * from employee order by id limit #{startNumber},#{endNumber}")
    public List<Employee> getEmployeeByPage(int startNumber,int endNumber);

    @Select("select id,name,employee.cardId,managerId,seniority,sex,position,time,isAttendance,note,headshot,phone from employee " +
            "left join (select * from attendance where to_days(attendance.time)=to_days(#{time})) a on employee.cardId=a.cardId" +
            " order by id")
    public List<Employee_attendance> getEmployeeAttendanceByTime(Timestamp time);

    @Select("select id,name,employee.cardId,managerId,seniority,sex,position,time,isAttendance,note,headshot,phone from employee " +
            "left join (select * from attendance where to_days(attendance.time)=to_days(#{time})) a on employee.cardId=a.cardId" +
            " where id=#{id} or name=#{info} or phone=#{info} or a.cardId=#{info} order by id")
    public List<Employee_attendance> getEmployeeAttendanceByTimeAndInfo(Timestamp time,int id,String info);

    @Select("select cardId from employee where id=#{id}")
    public String getCardIdById(int id);

    @Select("select * from employee where name=#{name}")
    public List<Employee> getEmployeeByName(String name);

    @Select("select * from employee where cardId=#{cardId}")
    public List<Employee> getEmployeeByCardId(String cardId);

    @Select("select count(*) from employee where cardId=#{cardId} and id!=#{id}")
    public int findCard(int id,String cardId);

    @Select("select id from employee where cardId=#{cardId}")
    public int getId(String cardId);

    @Update("update employee set headshot=#{headshot} where id=#{id}")
    public int updateHeadshot(int id,String headshot);

    @Select("select * from employee where id=#{id} or name=#{info} or cardId=#{info} or phone=#{info}")
    public List<Employee> getEmployeeByInfo(int id,String info);

    @Select("select * from employee where id=#{id}")
    public Employee getEmployeeById(int id);
}

