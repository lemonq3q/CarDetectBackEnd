package com.example.test.controller;

import com.example.test.entity.Employee;
import com.example.test.entity.Employee_attendance;
import com.example.test.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
public class InformationController {

    @Autowired
    private InformationService informationService;

    /**
     * 添加员工信息
     * @param employee
     * @return
     */
    @PostMapping("/updateData/addEmployee")
    public String addEmployee(@RequestBody Employee employee){
        return informationService.addEmployee(employee);
    }

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @PostMapping("/updateData/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        return informationService.updateEmployee(employee);
    }

    /**
     * 删除员工信息
     * @param id
     * @return
     */
    @DeleteMapping("/updateData/deleteEmployee")
    public String deleteEmployee(int id){
        return informationService.deleteEmployee(id);
    }

    /**
     * 获取对应领导手下的员工信息
     * @param managerId
     * @return
     */
    @GetMapping("/getData/getEmployeeByManager")
    public List<Employee> getEmployeeByManager(int managerId,int startNumber,int endNumber){
        return informationService.getEmployeeByManager(managerId,startNumber,endNumber);
    }

    /**
     * 根据id获取员工信息
     * @param id
     * @return
     */
    @GetMapping("/getData/getEmployeeById")
    public Employee getEmployeeById(int id){
        return informationService.getEmployeeById(id);
    }

    /**
     * 根据姓名获取员工信息
     * @param name
     * @return
     */
    @GetMapping("/getData/getEmployeeByName")
    public List<Employee> getEmployeeByName(String name){
        return informationService.getEmployeeByName(name);
    }

    /**
     * 根据卡号获取员工信息
     * @param cardId
     * @return
     */
    @GetMapping("/getData/getEmployeeByCardId")
    public List<Employee> getEmployeeByCardId(String cardId){
        return informationService.getEmployeeByCardId(cardId);
    }

    /**
     * 按照员工id排序，获取指定数量的员工信息，达到分页目的
     * @param startNumber
     * @param endNumber
     * @return
     */
    @GetMapping("/getData/getEmployeeByPage")
    public List<Employee> getEmployeeByPage(int startNumber,int endNumber){
        return informationService.getEmployeeByPage(startNumber,endNumber);
    }

    /**
     * 获取全部人员，不分页
     * @return
     */
    @GetMapping("/getData/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return informationService.getAllEmployee();
    }

    /**
     * 根据关键信息获取员工信息
     * @param info
     * @return
     */

    //获取一个String类型的变量info
    //在用多种信息进行查询时，因为员工的关键信息中只有ID是int，所以需要先转一次int
    //将int的类型和String类型的数据同时传入mapper函数，用or实现多种信息查询表单
    @GetMapping("/getData/getEmployeeByInfo")
    public List<Employee> getEmployeeByInfo(String info){
        return informationService.getEmployeeByInfo(info);
    }

    /**
     * 获取某一天的所有人的考勤信息,startId和endId是用来分页的
     * @param time
     * @return
     */
    @GetMapping("/getData/getAttendanceByTime")
    public List<Employee_attendance> getAttendanceByTime(long time,int startId,int endId){
        return informationService.getAttendanceByTime(time,startId,endId);
    }

    /**
     * 根据工人关键信息与时间获取考勤记录
     * @param time
     * @param info
     * @return
     */
    @GetMapping("/getData/getAttendanceByTimeAndInfo")
    public List<Employee_attendance> getAttendanceByTimeAndInfo(long time,String info){
        return informationService.getAttendanceByTimeAndInfo(time,info);
    }

    /**
     * 获取某一天所有人的已签到人数和未签到人数
     * @param time
     * @return
     */
    @GetMapping("/getData/getAttendanceNum")
    public Map<String,Integer> getAttendanceNum(long time){
        return informationService.getAttendanceNum(time);
    }

    /**
     * 获取某人的历史考勤记录，startTime和endTime是用来分页的
     * @param id
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/getData/getAttendanceById")
    public List<Employee_attendance> getAttendanceById(int id,long startTime,long endTime){
       return informationService.getAttendanceById(id,startTime,endTime);
    }

    /**
     * 查询某人某一天是否签到，返回1代表签到了，返回0代表没签到
     * @param id
     * @param time
     * @return
     */
    @GetMapping("/getData/getAttendanceByIdAndTime")
    public Integer getAttendanceByIdAndTime(int id,long time){
        return informationService.getAttendanceByIdAndTime(id,time);
    }

    /**
     * 上传员工图片并裁剪为正方形
     * @param file
     * @param filename
     * @return
     */
    @PostMapping("/addData/uploadImage")
    public String uploadImage(@RequestParam("file")MultipartFile file,String filename){
       return informationService.uploadImage(file,filename);
    }

    /**
     * 上传照片
     * @param file
     * @param filename
     * @return
     */
    @PostMapping("/addData/uploadNormalImage")
    public String uploadNormalImage(@RequestParam("file")MultipartFile file,String filename){
        return informationService.uploadNormalImage(file,filename);
    }

    public static void main(String[] args) {
//        long startTime = 1712419201;
//        long endTime = 1712505601;
//
//        Timestamp startDate = new Timestamp(startTime);
//        Timestamp endDate = new Timestamp(endTime);
//        List<Employee_attendance> attendanceList = attendanceMapper.getAttendanceById(64,startDate,endDate);
//        System.out.println(attendanceList.toString());
    }
}
