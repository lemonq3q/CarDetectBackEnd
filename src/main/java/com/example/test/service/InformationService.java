package com.example.test.service;

import com.example.test.entity.Employee;
import com.example.test.entity.Employee_attendance;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface InformationService {

    public String addEmployee(@RequestBody Employee employee);

    public String updateEmployee(@RequestBody Employee employee);

    public String deleteEmployee(int id);

    public List<Employee> getEmployeeByManager(int managerId, int startNumber, int endNumber);

    public Employee getEmployeeById(int id);

    public List<Employee> getEmployeeByName(String name);

    public List<Employee> getEmployeeByCardId(String cardId);

    public List<Employee> getEmployeeByPage(int startNumber,int endNumber);

    public List<Employee> getAllEmployee();

    public List<Employee> getEmployeeByInfo(String info);

    public List<Employee_attendance> getAttendanceByTime(long time, int startId, int endId);

    public List<Employee_attendance> getAttendanceByTimeAndInfo(long time,String info);

    public Map<String,Integer> getAttendanceNum(long time);

    public List<Employee_attendance> getAttendanceById(int id,long startTime,long endTime);

    public Integer getAttendanceByIdAndTime(int id,long time);

    public String uploadImage(@RequestParam("file") MultipartFile file, String filename);

    public String uploadNormalImage(@RequestParam("file")MultipartFile file,String filename);


}
