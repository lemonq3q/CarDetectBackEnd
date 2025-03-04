package com.example.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.test.controller.OneNetController;
import com.example.test.entity.*;
import com.example.test.mapper.*;
import com.example.test.service.OneNetService;
import com.example.test.WebSocket.LogEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OneNetimpl implements OneNetService {
    @Autowired
    private NowTemperatureMapper nowTemperatureMapper;

    @Autowired
    private TemperaturesMapper temperaturesMapper;

    @Autowired
    private HumiditysMapper humiditysMapper;

    @Autowired
    private NowHumidityMapper nowHumidityMapper;

    @Autowired
    private MeterMapper meterMapper;

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Autowired
    private NowPositionMapper nowPositionMapper;

    @Autowired
    private Workshop_deviceIdMapper workshopDeviceIdMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    private static final Logger log = LoggerFactory.getLogger(OneNetController.class);

    @Override
    public String getAttendanceRecord(OnenetData data) {
        int num = 0;
        OldOnenetMsg oldOnenetMsg = data.getMsg();
        if(oldOnenetMsg.getType()==1){
            if(oldOnenetMsg.getDs_id().equals("id")){
                AttendanceUpdate(oldOnenetMsg);
            } else if(oldOnenetMsg.getDs_id().equals("fingerid")){
                log.info(data.toString());
                String cardId = employeeMapper.getCardIdById(Integer.parseInt(oldOnenetMsg.getValue()));
                oldOnenetMsg.setValue(cardId);
                log.info(oldOnenetMsg.toString());
                AttendanceUpdate(oldOnenetMsg);
            } else if(oldOnenetMsg.getDs_id().equals("Humi")){
                //更新湿度
                String workshop = deviceMapper.getWorkshopByDevice_id(Integer.toString(oldOnenetMsg.getDev_id()));
                if(nowHumidityMapper.getHumidityNum(workshop)<1){
                    nowHumidityMapper.insertHumidity(workshop,oldOnenetMsg.getAt(),Float.parseFloat(oldOnenetMsg.getValue()));
                }else {
                    nowHumidityMapper.updateHumidity(workshop,Float.parseFloat(oldOnenetMsg.getValue()),oldOnenetMsg.getAt());
                }
                if(oldOnenetMsg.getAt()-humiditysMapper.getHumiLastTime(workshop)>2*1000){
                    humiditysMapper.insertHumidity(workshop,Float.parseFloat(oldOnenetMsg.getValue()),oldOnenetMsg.getAt());
                }
            } else if(oldOnenetMsg.getDs_id().equals("Temp")){
                //更新温度
                String workshop = deviceMapper.getWorkshopByDevice_id(Integer.toString(oldOnenetMsg.getDev_id()));
                if(nowTemperatureMapper.getTemperatureNum(workshop)<1){
                    nowTemperatureMapper.insertTemperature(workshop,Float.parseFloat(oldOnenetMsg.getValue()),oldOnenetMsg.getAt());
                }else {
                    nowTemperatureMapper.updateTemperature(workshop,Float.parseFloat(oldOnenetMsg.getValue()),oldOnenetMsg.getAt());
                }
                if(oldOnenetMsg.getAt()-temperaturesMapper.getTemperatureLastTime(workshop)>2*1000){
                    temperaturesMapper.insertTemperature(workshop,Float.parseFloat(oldOnenetMsg.getValue()),oldOnenetMsg.getAt());
                }
            }
        }
        return "over";
    }

    @Override
    public String getTemperatureValidate(String msg, String nonce, String signature) {
        return msg;
    }

    @Override
    public String getHumidityValidate(String msg, String nonce, String signature) {
        return msg;
    }

    @Override
    public String getAttendanceRecordValidate(String msg, String nonce, String signature) {
        return msg;
    }

    @Override
    public String addMeterData(Meter meter) {
        try{
            long time = System.currentTimeMillis();
            String workshop = deviceMapper.getWorkshopByDevice_id(meter.getWorkshop());
            meterMapper.insertMeterData(workshop,meter.getType(),time,meter.getUnit(),meter.getValue());
            return "succeed";
        }catch (Exception e){
            return "failed";
        }
    }

    @Override
    public List<Meter> getNewDataByWorkshop() {
        List<Meter> dataList = new ArrayList<>();
        Meter meter;
        meter = meterMapper.getNewDataByWorkshop("1");
        meter.setValue(Fixed3(meter.getValue()));
        dataList.add(meter);
        meter = meterMapper.getNewDataByWorkshop("2");
        meter.setValue(Fixed3(meter.getValue()));
        dataList.add(meter);
        meter = meterMapper.getNewDataByWorkshop("3");
        meter.setValue(Fixed3(meter.getValue()));
        dataList.add(meter);
        meter = meterMapper.getNewDataByWorkshop("4");
        meter.setValue(Fixed3(meter.getValue()));
        dataList.add(meter);
        return dataList;
    }

    @Override
    public float Fixed3(float num) {
        int x = (int)num;
        num = num - x;
        float result = 0;
        while(result + 0.125 < num){
            result += 0.125;
        }
        return result+x;
    }

    @Override
    public void AttendanceUpdate(OldOnenetMsg oldOnenetMsg) {
        //判断是否给前端推送位置信息
        boolean isSend = true;
        Timestamp timestamp = new Timestamp(oldOnenetMsg.getAt());
        int attendanceNums = attendanceMapper.getAttendanceByCardIdAndTime(oldOnenetMsg.getValue(),timestamp);
        if(attendanceNums==0){
            attendanceMapper.insertAttendance(oldOnenetMsg.getValue(),timestamp,1,null);
        }
        NowPosition nowPosition = nowPositionMapper.getNowPositionByCardId(oldOnenetMsg.getValue());

        /**
         * 生成要发给前端的信息体
         * 获取设备id对应的厂房号
         */
        String workshop = deviceMapper.getWorkshopByDevice_id(Integer.toString(oldOnenetMsg.getDev_id()));
        NowPosition sendMessage = new NowPosition(oldOnenetMsg.getValue(),timestamp, workshop);

        if(nowPosition==null){
            nowPositionMapper.insertNowPosition(oldOnenetMsg.getValue(),timestamp, workshop);
        }
        else{
            if(nowPosition.getWorkshop().equals(workshop) && timestamp.getTime()-nowPosition.getTimestamp().getTime()>10000){
                nowPosition.setWorkshop("0");
                nowPositionMapper.updateNowPosition(oldOnenetMsg.getValue(),nowPosition.getWorkshop(),timestamp);

                //设置前端的消息
                sendMessage.setWorkshop("0");

                Attendance attendance = attendanceMapper.getExitByCardIdAndTime(oldOnenetMsg.getValue(),timestamp);
                if(attendance==null){
                    attendanceMapper.insertAttendance(oldOnenetMsg.getValue(),timestamp,2,null);
                }
                else{
                    attendanceMapper.UpdateExitTimeByCardIdAndTime(oldOnenetMsg.getValue(),timestamp);
                }

            }
            else if(timestamp.getTime()-nowPosition.getTimestamp().getTime()>10000) {
                nowPositionMapper.updateNowPosition(oldOnenetMsg.getValue(),workshop,timestamp);
            }
            else{
                isSend = false;
            }
        }

        if(isSend){
            WebSocketMessage webSocketMessage = new WebSocketMessage(1,sendMessage);

            //发送信息的代码块
            Set<String> keys = LogEndpoint.onlineUsers.keySet();
            for (String key : keys) {
                try {
                    LogEndpoint.onlineUsers.get(key).getBasicRemote().sendText(JSON.toJSONString(webSocketMessage)); //转换为json
                }catch (Exception e){

                }
            }
        }
    }
}

