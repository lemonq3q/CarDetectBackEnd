package com.example.test.controller;

import com.example.test.entity.Model;
import com.example.test.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    /**
     * 获取所有的model信息
     * @return
     */
    @GetMapping("/model/getAll")
    public List<Model> getAll(){
        return modelService.getAll();
    }

    /**
     * 根据设备获取模型信息
     * @param device_id
     * @return
     */
    @GetMapping("/model/getModelByDevice")
    public List<Model> getModelByDevice(String device_id){
        return modelService.getModelByDevice(device_id);
    }

    /**
     * 添加或修改绑定的模型
     * @param device_id
     * @param modelArray
     * @return
     */
    @PostMapping("/model/addDeviceModel")
    public String addDeviceModel(String device_id, @RequestBody int[] modelArray){
        return modelService.addDeviceModel(device_id, modelArray);
    }

    /**
     * 删除模型
     * @param id
     * @return
     */
    @DeleteMapping("/model/deleteModel")
    public String deleteModel(int id){
        return modelService.deleteModel(id);
    }

    /**
     * 更新模型基本信息
     * @param modelName
     * @param modelDesc
     * @param id
     * @return
     */
    @PostMapping("/model/updateBaseInfo")
    public String updateBaseInfo(String modelName,String modelDesc,int level,int id){
        return modelService.updateBaseInfo(modelName,modelDesc,level,id);
    }

    /**
     * 添加模型基本信息
     * @param modelName
     * @param modelDesc
     * @return
     */
    @PostMapping("/model/addBaseInfo")
    public String addBaseInfo(String modelName,String modelDesc,int level){
        return modelService.addBaseInfo(modelName,modelDesc,level);
    }

    /**
     * 训练完毕后发送信息
     * @param id
     * @param rounds
     * @param accuracy
     * @param modelPath
     * @return
     */
    @PostMapping("/model/trainInfo")
    public String uploadTrainInfo(int id,int rounds,float accuracy,String modelPath){
        return modelService.uploadTrainInfo(id,rounds,accuracy,modelPath);
    }

    /**
     * 测试训练
     * @return
     */
    @PostMapping("/model/test")
    public String uploadModel(){
       return modelService.uploadModel();
    }
    /**
     * 处理发过来的文件
     * @param file
     * @param id
     * @return
     */
    @PostMapping("/model/uploadDataSet")
    public String uploadDataSet(@RequestParam("file") MultipartFile file,int id,int rounds){
        return modelService.uploadDataSet(file,id,rounds);
    }

    /**
     * 上传照片
     * @param file
     * @param filename
     * @return
     */
    @PostMapping("/model/uploadTestPic")
    public String uploadTestImage(@RequestParam("file")MultipartFile file,String filename) {
        return modelService.uploadTestImage(file,filename);
    }

}
