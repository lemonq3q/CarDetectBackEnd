package com.example.test.mapper;

import com.example.test.entity.Workshop_deviceId;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Workshop_deviceIdMapper {
    @Select("select * from workshop_deviceId where deviceId=#{deviceId}")
    public Workshop_deviceId getWorkshop_deviceIdByDeviceId(String deviceId);

    @Select("select * from workshop_deviceId")
    public List<Workshop_deviceId> getWorkshop();
}
