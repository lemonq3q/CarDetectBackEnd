package com.example.test.mapper;


import com.example.test.entity.Device;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeviceMapper {

    @Select("select * from device")
    public List<Device> getAllDevice();

    @Select("select * from device where workshop=#{workshop}")
    public List<Device> getDeviceByWorkshop(String workshop);

    @Select("select * from device where device_id=#{device_id}")
    public List<Device> getDeviceByDevice_id(String device_id);

    @Select("select * from device where type=#{type}")
    public List<Device> getDeviceByType(String type);

    @Select("select * from device where device_id=#{device_id} and workshop=#{workshop}")
    public List<Device> getDeviceByDevice_idAndWorkshop(String device_id, String workshop);

    @Select("select * from device where type=#{type} and workshop=#{workshop}")
    public List<Device> getDeviceByTypeAndWorkshop(String type, String workshop);

    @Delete("delete from device where device_id=#{device_id}")
    public void deleteDevice(String device_id);

    @Update("update device set description=#{description} where device_id=#{device_id}")
    public void updateDeviceDescription(String device_id, String description);

    @Insert("insert into device values(#{device_id},#{workshop},#{type},0,#{lastTime},#{description})")
    public void addDevice(String device_id, String workshop, String type, long lastTime, String description);

    @Update("update device set device_id=#{newDevice_id},workshop=#{workshop},type=#{type},description=#{description} where device_id=#{oldDevice_id}")
    public void updateDevice(String newDevice_id,String oldDevice_id, String workshop, String type, String description);

    @Select("select count(*) from device where device_id=#{device_id}")
    public int findDevice(String device_id);

    @Select("select count(*) from device where device_id=#{newDevice_id} and device_id!=#{oldDevice_id}")
    public int repeatDetect(String newDevice_id,String oldDevice_id);

    @Select("select workshop from device where device_id=#{device_id}")
    public String getWorkshopByDevice_id(String device_id);
}
