package com.example.test.service.impl;

import com.example.test.entity.Model;
import com.example.test.mapper.DeviceModelMapper;
import com.example.test.mapper.ModelMapper;
import com.example.test.service.ModelService;
import com.example.test.util.FileUtil;
import com.example.test.util.ScriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class Modelimpl implements ModelService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DeviceModelMapper deviceModelMapper;

    @Value("${upload.path}")
    private String imagePath;

    @Override
    //获取所有模型信息
    public List<Model> getAll() {
        return modelMapper.getAllModel();
    }

    @Override
    //根据设备号获取
    public List<Model> getModelByDevice(String device_id) {
        if(device_id == null) return null;
        return modelMapper.getModelByDevice(device_id);
    }

    @Override
    //修改信息
    //设备和模型之间是多对多的关系
    public String addDeviceModel(String device_id, int[] modelArray) {
        try {
            deviceModelMapper.deleteDeviceModel(device_id);
            for (int i = 0; i < modelArray.length; i++) {
                deviceModelMapper.addDeviceModel(device_id, modelArray[i]);
            }
            return "succeed";
        } catch (Exception e){
            return "failed";
        }
    }

    @Override
    //删除模型
    public String deleteModel(int id) {
        if(id <= 0) return "failed";
        try {
            Model model = modelMapper.getModelById(id);
            String path = "xxx" + model.getModelPath();
            FileUtil.deleteFile(path);
            deviceModelMapper.deleteModelBindById(id);
            modelMapper.deleteModel(id);
            return "succeed";
        } catch (Exception e){
            return "failed";
        }
    }

    @Override
    //更新模型信息
    public String updateBaseInfo(String modelName, String modelDesc, int level, int id) {
        try {
            modelMapper.uploadModelBaseInfo(modelName,modelDesc,level,id);
            return "succeed";
        } catch (Exception e){
            return "failed";
        }
    }

    @Override
    //添加模型信息
    public String addBaseInfo(String modelName, String modelDesc, int level) {
        try{
            Model model = new Model(0,modelName,null,modelDesc,1,System.currentTimeMillis(),0,0,0,level);
            modelMapper.addModel(model);
            return Integer.toString(model.getId());
        }catch (Exception e){
            System.out.println(e);
            return "failed";
        }
    }

    @Override
    //训练完成后发送信息
    public String uploadTrainInfo(int id, int rounds, float accuracy, String modelPath) {
        try {
            modelMapper.uploadModelTrainInfo(rounds,System.currentTimeMillis(),accuracy,id,modelPath);
            return "succeed";
        } catch (Exception e){
            return "failed";
        }
    }

    @Override
    //测试训练
    //执行一个外部Python脚本customTrain.py来训练模型
    public String uploadModel() {
        String command= "python customTrain.py --id 28 --names 28 --datasetName 28 --epochs 1";
        try {
            Process p = Runtime.getRuntime().exec(command,null,new File("D:/BaiduNetdiskDownload/code/yolov5"));
            ScriptExecutor.readProcessOutput(p);
            int exitCode = p.waitFor();
            System.out.println("External process completed with exit code: " + exitCode);
            return "1";
        }catch (Exception e) {
            return "2";
        }
    }

    @Override
    //处理发过来的文件
    //                            上传文件的接口
    public String uploadDataSet(MultipartFile file, int id, int rounds) {
        modelMapper.uploadModelState(id);
        //定义解压文件的目标目录
        String outDir = "/usr/app/yolov5/"+Integer.toString(id);
        //解压文件到目标目录下               接口  解压目录 命名
        boolean success = FileUtil.unZip(file,outDir,Integer.toString(id)+"_zip");
        if(success){
            return "succeed";
        }else {
            return "failed";
        }
    }

    @Override
    //上传照片
    //将上传的文件保存到服务器的文件系统中
    public String uploadTestImage(MultipartFile file, String filename) {
        try {
            //保存文件的完整路径
            String filePath = imagePath + filename;
            //创建File对象
            File existingFile = new File(filePath);
            //检查这个对象是否存在
            if (existingFile.exists()) {
                //存在的话就删除已经存在于这个路径下的文件
                existingFile.delete();
            }
            //将上传的文件数据保存到指定的路径
            file.transferTo(new File(filePath));
            return "succeed";
        } catch (Exception e) {
            return "failed";
        }
    }

}
