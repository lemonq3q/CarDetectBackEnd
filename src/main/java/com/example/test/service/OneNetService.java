package com.example.test.service;

import com.example.test.entity.Meter;
import com.example.test.entity.OldOnenetMsg;
import com.example.test.entity.OnenetData;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OneNetService {

    public String getAttendanceRecord(@RequestBody OnenetData data);

    public String getTemperatureValidate(String msg,String nonce,String signature);

    public String getHumidityValidate(String msg,String nonce,String signature);

    public String getAttendanceRecordValidate(String msg,String nonce,String signature);

    public String addMeterData(@RequestBody Meter meter);

    public List<Meter> getNewDataByWorkshop();

    public float Fixed3(float num);

    public void AttendanceUpdate(OldOnenetMsg oldOnenetMsg);
}

