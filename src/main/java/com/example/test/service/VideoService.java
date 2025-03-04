package com.example.test.service;

import com.example.test.entity.Risk;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {

    public String addRisk(@RequestBody Risk risk);

    public String uploadWorkerNum(String dev_id,int num);

    public String uploadDataSet(@RequestParam("file") MultipartFile file, int id);

}
