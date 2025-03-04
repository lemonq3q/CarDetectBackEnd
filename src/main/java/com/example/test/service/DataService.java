package com.example.test.service;

import com.example.test.entity.*;

import java.util.List;
import java.util.Map;


public interface DataService {

    //获取当前温度
    public NowTemperature getNowTemperature(String workshop);

    //获取一段时间内的温度 between...and...
    public List<NowTemperature> getTemperatureByTime(String workshop, long startTime, long endTime);

    //当前湿度
    public NowHumidity getNowHumidity(String workshop);

    //一段时间内的湿度
    public List<NowHumidity> getHumidityByTime(String workshop,long startTime,long endTime);

    //分页获取温度数据 limit..
    public List<NowTemperature> getTemperatureByPage(String workshop,int startNumber,int endNumber);

    //分页获取湿度数据
    public List<NowHumidity> getHumidityByPage(String workshop,int startNumber,int endNumber);

    //获取当前员工位置信息
    public List<NowPosition> getWorkersIdAndLocation();

    //根据厂房号查询员工数据
    public List<Employee> getWorkersByWorkshop(String workshop);

    //根据厂房号获取在线员工数量
    public int getWorkerNumByWorkshop(String workshop);

    //获取各个厂房员工数目的数组
    public List<WorkerNum> getAllWorkerNumB();

    //分页获取风险记录
    public List<Risk> getRiskRecord(int startNumber,int endNumber);

    //根据厂房号获取风险记录
    public List<Risk> getRiskRecordByWorkshop(String workshop,int startNumber,int endNumber);

    //根据风险id查询风险信息
    public Risk getRiskById(int id);

    //根据车间号和风险等级获取风险数据
    public List<Risk> getRiskByWorkshopAndLevel(String workshop,int level);

    //修改风险描述
    public String addRiskDescription(int id,String description);

    //删除风险记录
    public String deleteRisk(int id);


    public List<Workshop_deviceId> getWorkshop();

    //时间和等级获取风险数据
    public int getRiskNumByLevel(long startTime,long endTime,int level);

    //返回整个风险记录数量-以等级划分
    public Map<String,Integer> getRiskNum();

    //时间和风险名称获取风险数据
    public int getRiskNumByRiskName(long startTime,long endTime,String riskName);

    //厂房的产品信息
    public List<Product> getAllProduct();
}
