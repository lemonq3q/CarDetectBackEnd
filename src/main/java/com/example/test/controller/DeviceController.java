package com.example.test.controller;

import com.example.test.entity.Device;
import com.example.test.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    /**
     * 根据对应信息返回相应的设备信息
     * @param workshop
     * @param type
     * @param device_id
     * @return
     */
    @GetMapping("/device/getDevice")
    public List<Device> getDevice(String workshop,String type,String device_id){
        return deviceService.getDevice(workshop,type,device_id);
    }

    /**
     * 修改设备描述
     * @param device_id
     * @param description
     * @return
     */
    @PostMapping("/device/updateDescription")
    public String addDeviceDescription(String device_id,String description){
        return deviceService.addDeviceDescription(device_id,description);
    }

    /**
     * 添加新设备
     * @param device
     * @return
     */
    @PostMapping("/device/addDevice")
    public String addDevice(@RequestBody Device device){
       return deviceService.addDevice(device);
    }

    /**
     * 更新设备信息
     * @param device
     * @return
     */
    @PostMapping("/device/updateDevice")
    public String updateDevice(@RequestBody Device device,String oldDevice_id){
       return deviceService.updateDevice(device,oldDevice_id);
    }

    /**
     * 删除设备
     * @param device_id
     * @return
     */
    @DeleteMapping("/device/deleteDevice")
    public String deleteDevice(String device_id){
        return deviceService.deleteDevice(device_id);
    }

}
