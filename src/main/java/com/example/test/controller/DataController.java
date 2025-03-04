package com.example.test.controller;

import com.example.test.entity.*;
import com.example.test.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;//可重复的有序集合
import java.util.Map;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;


    /**
     * 获取即时温度
     * @param workshop
     * @return
     */
    @GetMapping("/getData/getNowTemperature")
    public NowTemperature getNowTemperature(String workshop){
        return dataService.getNowTemperature(workshop);
    }

    /**
     * 获取某时间段内温度
     * @param workshop
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/getData/getTemperatureByTime")
    public List<NowTemperature> getTemperatureByTime(String workshop,long startTime,long endTime){
        return dataService.getTemperatureByTime(workshop,startTime,endTime);
    }

    /**
     * 获取当前湿度
     * @param workshop
     * @return
     */
    @GetMapping("/getData/getNowHumidity")
    public NowHumidity getNowHumidity(String workshop){
        return dataService.getNowHumidity(workshop);
    }

    /**
     * 获取某时间段内湿度
     * @param workshop
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/getData/getHumidityByTime")
    public List<NowHumidity> getHumidityByTime(String workshop,long startTime,long endTime){
        return dataService.getHumidityByTime(workshop,startTime,endTime);
    }

    /**
     * 分页获取最近的温度
     * @param workshop
     * @param startNumber
     * @param endNumber
     * @return
     */
    @GetMapping("/getData/getTemperatureByPage")
    public List<NowTemperature> getTemperatureByPage(String workshop,int startNumber,int endNumber){
        return dataService.getTemperatureByPage(workshop,startNumber,endNumber);
    }

    /**
     * 分页获取最近湿度
     * @param workshop
     * @param startNumber
     * @param endNumber
     * @return
     */
    @GetMapping("/getData/getHumidityByPage")
    public List<NowHumidity> getHumidityByPage(String workshop,int startNumber,int endNumber){
        return dataService.getHumidityByPage(workshop,startNumber,endNumber);
    }

    /**
     * 获取所有的人员的当前位置
     * @return
     */
    @GetMapping("/getData/getWorkersIdAndLocation")
    public List<NowPosition> getWorkersIdAndLocation(){
        return dataService.getWorkersIdAndLocation();
    }

    /**
     * 获取某工厂内打卡员工
     * @param workshop
     * @return
     */
    @GetMapping("/getData/getWorkersByWorkshop")
    public List<Employee> getWorkersByWorkshop(String workshop){
        return dataService.getWorkersByWorkshop(workshop);
    }

    /**
     * 获取某工厂内的动态考勤数量
     * @return
     */
    @GetMapping("/getData/getWorkerNumByWorkshop")
    public int getWorkerNumByWorkshop(String workshop){
        return dataService.getWorkerNumByWorkshop(workshop);
    }

    /**
     * 获取某工厂内的动态考勤数量
     * @return
     */
    @GetMapping("/getData/getWorkerAllNum")
    public List<WorkerNum> getAllWorkerNumB(){
        return dataService.getAllWorkerNumB();
    }

    /**
     * 获取风险记录
     * @param startNumber
     * @param endNumber
     * @return
     */
    @GetMapping("/getData/getRiskRecord")
    public List<Risk> getRiskRecord(int startNumber,int endNumber){
        return dataService.getRiskRecord(startNumber,endNumber);
    }

    /**
     * 通过车间号获得风险记录
     * @param workshop
     * @param startNumber
     * @param endNumber
     * @return
     */
    @GetMapping("/getData/getRiskRecordByWorkshop")
    public List<Risk> getRiskRecordByWorkshop(String workshop,int startNumber,int endNumber){
        return dataService.getRiskRecordByWorkshop(workshop,startNumber,endNumber);
    }

    /**
     * 通过id获取风险记录
     * @param id
     * @return
     */
    @GetMapping("/getData/getRiskById")
    public Risk getRiskById(int id){
        return dataService.getRiskById(id);
    }

    /**
     * 通过车间号和风险等级获取风险记录
     * @param workshop
     * @param level
     * @return
     */
    @GetMapping("/getRiskByWorkshopAndLevel")
    public List<Risk> getRiskByWorkshopAndLevel(String workshop,int level){
        return dataService.getRiskByWorkshopAndLevel(workshop,level);
    }

    /**
     * 添加风险描述
     * @param id
     * @param description
     * @return
     */
    @PostMapping("/addData/addRiskDescription")
    public String addRiskDescription(int id,String description){
        return dataService.addRiskDescription(id,description);
    }

    /**
     * 删除风险
     * @param id
     * @return
     */
    @DeleteMapping("/addData/deleteRisk")
    public String deleteRisk(int id){
        return dataService.deleteRisk(id);
    }

    /**
     * 获取全部的工厂信息
     * @return
     */
    @GetMapping("/getData/getWorkshop")
    public List<Workshop_deviceId> getWorkshop(){
        return dataService.getWorkshop();
    }

    /**
     * 获取在某段时间内发生对应等级的风险数量
     * @param startTime
     * @param endTime
     * @param level
     * @return
     */
    @GetMapping("/getData/getRiskNumByLevel")
    public int getRiskNumByLevel(long startTime,long endTime,int level){
        return dataService.getRiskNumByLevel(startTime,endTime,level);
    }

    /**
     * 获取历史风险数量记录
     * @return
     */
    @GetMapping("/getData/getRiskNum")
    public Map<String,Integer> getRiskNum(){
        return dataService.getRiskNum();
    }

    /**
     * 获取某时间段内对应风险类型的发生次数
     * @param startTime
     * @param endTime
     * @param riskName
     * @return
     */
    @GetMapping("/getData/getRiskNumByRiskName")
    public int getRiskNumByRiskName(long startTime,long endTime,String riskName){
        return dataService.getRiskNumByRiskName(startTime,endTime,riskName);
    }

    /**
     * 获取所有产品信息
     * @return
     */
    @GetMapping("/getData/getAllProduct")
    public List<Product> getAllProduct() {
        return dataService.getAllProduct();
    }

}
