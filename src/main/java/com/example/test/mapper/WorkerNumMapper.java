package com.example.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface WorkerNumMapper {
    @Select("select num from workerNum where workshop=#{workshop}")
    public int getWorkerNumByWorkshop(String workshop);

    @Update("update workerNum set num=#{num} where workshop=#{workshop}")
    public void updateWorkerNum(String workshop,int num);
}
