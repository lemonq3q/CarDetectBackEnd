package com.example.test.controller;

import com.example.test.entity.*;
import com.example.test.service.OneNetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class OneNetController {

    @Autowired
    private OneNetService oneNetService;

    /**
     * 考勤信息处理
     * @param data
     * @return
     */
    @PostMapping("/attendanceRecord")
    public String getAttendanceRecord(@RequestBody OnenetData data) {
       return oneNetService.getAttendanceRecord(data);
    }

    /**
     * 温度接口验证
     * @param msg
     * @param nonce
     * @param signature
     * @return
     */
    @GetMapping ("/uploadTemp")
    public String getTemperatureValidate(String msg,String nonce,String signature) {
        return oneNetService.getTemperatureValidate(msg,nonce,signature);
    }

    /**
     * 湿度接口验证
     * @param msg
     * @param nonce
     * @param signature
     * @return
     */
    @GetMapping ("/uploadHum")
    public String getHumidityValidate(String msg,String nonce,String signature) {
        return oneNetService.getHumidityValidate(msg,nonce,signature);
    }

    /**
     * 考勤接口验证
     * @param msg
     * @param nonce
     * @param signature
     * @return
     */
    @GetMapping ("/attendanceRecord")
    public String getAttendanceRecordValidate(String msg,String nonce,String signature) {
        return oneNetService.getAttendanceRecordValidate(msg,nonce,signature);
    }

    /**
     * 插入仪表读数信息
     * @param meter
     * @return
     */
    @PostMapping("/meter/addMeterData")
    public String addMeterData(@RequestBody Meter meter){
        return oneNetService.addMeterData(meter);
    }

    /**
     * 获取所有区域当前仪表盘数据
     * @return
     */
    @GetMapping("/meter/getNewDataByWorkshop")
    public List<Meter> getNewDataByWorkshop(){
        return oneNetService.getNewDataByWorkshop();
    }

    public float Fixed3(float num){
        return oneNetService.Fixed3(num);
    }

    /**
     * Onenet数据接收
     * @param oldOnenetMsg
     */
    public void AttendanceUpdate(OldOnenetMsg oldOnenetMsg) {
        oneNetService.AttendanceUpdate(oldOnenetMsg);
    }
}
