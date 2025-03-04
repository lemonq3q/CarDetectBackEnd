package com.example.test.service;

import com.example.test.entity.Device;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DeviceService {

    //判断发过来的是厂房号还是设备类型还是设备id，来获取对应的设备列表
    public List<Device> getDevice(String workshop, String type, String device_id);

    //增加设备描述
    public String addDeviceDescription(String device_id,String description);

    //增加新设备
    public String addDevice(@RequestBody Device device);

    //更新设备信息
    public String updateDevice(@RequestBody Device device,String oldDevice_id);

    //根据设备号删除设备信息
    public String deleteDevice(String device_id);


}
