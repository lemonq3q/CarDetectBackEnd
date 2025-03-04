package com.example.test.service.impl;

import com.example.test.entity.Device;
import com.example.test.mapper.DeviceMapper;
import com.example.test.mapper.DeviceModelMapper;
import com.example.test.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Deviceimpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceModelMapper deviceModelMapper;

    @Override
    //根据发来的信息，返回对应的信息
    public List<Device> getDevice(String workshop, String type, String device_id) {
        if(workshop==null){
            if(type==null && device_id!=null){
                return deviceMapper.getDeviceByDevice_id(device_id);
            }
            else if(type!=null && device_id==null){
                return deviceMapper.getDeviceByType(type);
            }
            return deviceMapper.getAllDevice();
        }
        if(type==null && device_id!=null){
            return deviceMapper.getDeviceByDevice_idAndWorkshop(device_id,workshop);
        }
        else if(type!=null && device_id==null){
            return deviceMapper.getDeviceByTypeAndWorkshop(type,workshop);
        }
        return deviceMapper.getDeviceByWorkshop(workshop);
    }

    @Override
    //增加设备描述
    public String addDeviceDescription(String device_id, String description) {
        try {
            deviceMapper.updateDeviceDescription(device_id, description);
            return "succeed";
        }catch (Exception e){
            return "failed";
        }
    }

    @Override
    //添加新设备
    public String addDevice(Device device) {
        try {
            int num = deviceMapper.findDevice(device.getDevice_id());
            if (num < 1) {
                deviceMapper.addDevice(device.getDevice_id(), device.getWorkshop(), device.getType(), device.getLastTime(), device.getDescription());
                return "succeed";
            } else {
                return "failed";
            }
        }catch (Exception e){
            return "failed";
        }
    }

    @Override
    //更新设备信息
    public String updateDevice(Device device, String oldDevice_id) {
        try {
            int num = deviceMapper.repeatDetect(device.getDevice_id(),oldDevice_id);
            if(num<1){
                deviceMapper.updateDevice(device.getDevice_id(),oldDevice_id,device.getWorkshop(), device.getType(), device.getDescription());
                deviceModelMapper.updateDeviceModel(oldDevice_id,device.getDevice_id());
                return "succeed";
            }
            else{
                return "failed";
            }
        }catch (Exception e){
            return "failed";
        }
    }

    @Override
    //删除设备
    public String deleteDevice(String device_id) {
        try {
            deviceMapper.deleteDevice(device_id);
            return "succeed";
        }catch (Exception e){
            return "failed";
        }
    }
}
