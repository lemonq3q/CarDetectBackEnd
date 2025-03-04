package com.example.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.test.entity.Risk;
import com.example.test.entity.WebSocketMessage;
import com.example.test.mapper.DeviceMapper;
import com.example.test.mapper.RiskMapper;
import com.example.test.mapper.WorkerNumMapper;
import com.example.test.mapper.Workshop_deviceIdMapper;
import com.example.test.service.VideoService;
import com.example.test.WebSocket.LogEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Set;

@Service
public class Videoimpl implements VideoService {
    @Autowired
    private RiskMapper riskMapper;

    @Autowired
    private Workshop_deviceIdMapper workshopDeviceIdMapper;

    @Autowired
    private WorkerNumMapper workerNumMapper;

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public String addRisk(Risk risk) {
        //获取风险发生的厂房号     发过来的数据里存的是设备的id信息，根据设备ID获取厂房号
        String workshop = deviceMapper.getWorkshopByDevice_id(risk.getAddress());
        riskMapper.insertRisk(risk.getRiskName(),risk.getTime(),risk.getPicPath(),workshop,risk.getLevel());
        //要发送消息的对象

        //根据图像地址获取风险数据
        Risk sendMessage = riskMapper.getRiskByPicPath(risk.getPicPath());

        //创建WebSocke消息的实例     type为2？
        WebSocketMessage webSocketMessage = new WebSocketMessage(2,sendMessage);
        //获取所有在线用户的键
        Set<String> keys = LogEndpoint.onlineUsers.keySet();
        for (String key : keys) {
            try {
                LogEndpoint.onlineUsers.get(key).getBasicRemote().sendText(JSON.toJSONString(webSocketMessage)); //要转换为json
            }catch (Exception e){

            }
        }
        return "succeed";
    }

    @Override
    //实时更新各个厂房的工人数量
    public String uploadWorkerNum(String dev_id, int num) {
        try{
            String workshop = workshopDeviceIdMapper.getWorkshop_deviceIdByDeviceId(dev_id).getWorkshop();
            workerNumMapper.updateWorkerNum(workshop,num);
            return "succeed";
        }catch (Exception e) {
            return "failed";
        }
    }

    @Override
    public String uploadDataSet(MultipartFile file, int id) {
        String outDir = "/usr/app/yolov5/video_dataset/"+Integer.toString(id)+".mp4";
        try {
            File existingFile = new File(outDir);
            if (existingFile.exists()) {
                existingFile.delete();
            }
            file.transferTo(new File(outDir));
            return "succeed";
        } catch (Exception e) {
            return "failed";
        }
    }
}
