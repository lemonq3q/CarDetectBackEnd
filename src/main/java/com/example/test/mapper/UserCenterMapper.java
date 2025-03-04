package com.example.test.mapper;

import com.example.test.entity.UserCenter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface UserCenterMapper {
    @Select("select userid,username,password,headshot,phone,factory,name,sex,useraddress,managerid,employee,device,model,risk,inspect " +
            "from user,power where userid=id and userid=#{userid} ")
    public UserCenter getUserByUserId(Integer userid);

    @Insert("insert into user(username,password,phone,factory,name,sex,useraddress,managerid) " +
            "values(#{username},#{password},#{phone},#{factory},#{name},#{sex},#{useraddress},#{managerid})")
    public void insertUserMsg(String username,String password,String phone,String factory,String name,int sex,String useraddress,int managerid);

    @Select("select userid from user where phone=#{phone}")
    public int getUserIdByPhone(String phone);

    @Insert("insert into power values(#{id},#{employee},#{device},#{model},#{risk},#{inspect})")
    public void insertpower(int id,int employee,int device,int model,int risk,int inspect);

    @Update("update user set username=#{username},phone=#{phone},useraddress=#{useraddress} " +
            "where userid=#{userid}")
    public void updateUserMsg(int userid,String username,String phone,String useraddress);

    @Select("select phone from user where userid=#{userid}")
    public String getphonebyuserid(String phone,int userid);

    @Update("update user set password=#{password} where userid=#{userid} ")
    public void updatepasswordbyphone(int userid,String password);

    @Select("select userid,username,password,headshot,phone,factory,name,sex,useraddress,managerid,employee,device,model,risk,inspect " +
            "from user,power where userid=id and managerid=#{managerid}")
    public List<UserCenter> getadmbymanagerId(int managerid);

}
