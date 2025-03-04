package com.example.test.mapper;

import com.example.test.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select count(*) from user where username=#{username} and password=#{password}")
    public int selectUser(String username,String password);

    @Select("select count(*) from user where phone=#{phone}")
    public int findUserByPhone(String phone);

    @Insert("insert into user(username,password,phone,activationCode,headshot,factory,name,sex) " +
            "values(#{username},#{password},#{phone},#{activationCode},#{headshot},#{factory},#{name},#{sex})")
    public int addUser(String username,String password,String phone,String activationCode,String headshot,String factory,String name,int sex);

    @Update("update user set password=#{password} where username=#{username}")
    public int updatePassword(String username,String password);

    @Update("update user set phone=#{phone} where username=#{username}")
    public int updatePhone(String username,String phone);

    @Select("select * from user where phone=#{phone}")
    public User getUserByPhone(String phone);

    @Select("select * from user where username=#{username}")
    public User getUserByUsername(String username);

    @Select("select count(*) from user where activationCode=#{activationCode}")
    public int findActivationCode(String activationCode);

    @Select("select count(*) from user where username=#{username}")
    public int findUsername(String username);

    @Update("update user set username=#{username} where phone=#{phone}")
    public int updateUsername(String phone,String username);

    @Update("update user set username=#{username},headshot=#{headshot}," +
            "factory=#{factory},name=#{name},sex=#{sex} where userid=#{userid}")
    public void updateUser(String username,String headshot,String factory,String name,int sex,int userid);

    @Select("select count(*) from user where phone=#{phone} or username=#{username} and userid!=#{userid}")
    public int findRepeat(String phone,String username,int userid);

    @Select("select * from user where userid=#{userid}")
    public User getUserById(int userid);

    @Update("update user set headshot = #{headshot} where userid = #{userid}")
    public int updateHeadshot(String headshot,int userid);

}
