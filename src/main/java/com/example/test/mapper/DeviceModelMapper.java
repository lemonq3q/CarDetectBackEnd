package com.example.test.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DeviceModelMapper {

    @Delete("delete from deviceModel where device_id=#{device_id}")
    public void deleteDeviceModel(String device_id);

    @Insert("insert into deviceModel values(#{device_id},#{model_id})")
    public void addDeviceModel(String device_id,int model_id);

    @Update("update deviceModel set device_id=#{newDevice_id} where device_id=#{oldDevice_id}")
    public void updateDeviceModel(String oldDevice_id,String newDevice_id);

    @Delete("delete from deviceModel where model_id=#{id}")
    public void deleteModelBindById(int id);
}
