package com.example.test.service;

import com.example.test.entity.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ModelService {

    public List<Model> getAll();

    public List<Model> getModelByDevice(String device_id);

    public String addDeviceModel(String device_id, @RequestBody int[] modelArray);

    public String deleteModel(int id);

    public String updateBaseInfo(String modelName,String modelDesc,int level,int id);

    public String addBaseInfo(String modelName,String modelDesc,int level);

    public String uploadTrainInfo(int id,int rounds,float accuracy,String modelPath);

    public String uploadModel();

    public String uploadDataSet(@RequestParam("file") MultipartFile file, int id, int rounds);

    public String uploadTestImage(@RequestParam("file")MultipartFile file,String filename);


}
