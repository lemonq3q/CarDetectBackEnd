package com.example.test.controller;

import com.example.test.entity.Risk;
import com.example.test.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

//    /**
//     * 打开风险测试程序
//     * @param dev_id
//     * @return
//     */
//    @PostMapping("/videoData/DangerousVideoStream")
//    public String startNewDangerousVideo(String dev_id){
//        try {
//            String py = "/usr/app/yolov5/yolov5.py";
//            File workingDirectory = new File("/usr/app/yolov5");
//            List<String> commandList = new ArrayList<>();
//            commandList.add("python");
//            commandList.add(py);
//            commandList.add(dev_id);
//            ScriptExecutor scriptExecutor = new ScriptExecutor(commandList,workingDirectory);
//            scriptExecutor.run();
//        }catch (Exception e){
//            return "failed";
//        }
//        return "success";
//    }
//
//    /**
//     * 测试用打开人脸识别程序
//     * @param streamName
//     * @param dev_id
//     * @return
//     */
//    @PostMapping("/videoData/FaceVideoStream")
//    public String startNewFaceVideo(String streamName,String dev_id){
//        try {
//            String py = "/usr/app/face_detect/predict.py";
//            File workingDirectory = new File("/usr/app/face_detect");
//            List<String> commandList = new ArrayList<>();
//            commandList.add("python");
//            commandList.add(py);
//            commandList.add(streamName);
//            commandList.add(dev_id);
//            ScriptExecutor scriptExecutor = new ScriptExecutor(commandList, workingDirectory);
//            scriptExecutor.run();
//        }catch (Exception e){
//            return "failed";
//        }
//        return "succeed";
//    }

    /**
     * 存储并推送危险警告记录
     * @param risk
     * @return
     */
    @PostMapping("/addData/saveRisk")
    public String addRisk(@RequestBody Risk risk){
        return videoService.addRisk(risk);
    }

    /**
     * 更新工厂动态人数
     * @param dev_id
     * @param num
     * @return
     */
    @PostMapping("/upload/uploadWorkerNum")
    public String uploadWorkerNum(String dev_id,int num){
        return videoService.uploadWorkerNum(dev_id,num);
    }

    /**
     * 处理发过来的文件
     * @param file
     * @param id
     * @return
     */
    @PostMapping("/video/uploadFace")
    public String uploadDataSet(@RequestParam("file") MultipartFile file, int id){
        return videoService.uploadDataSet(file,id);
    }

//    public static void main(String[] args) {
//        try {
//            String py = "E:/CodeTest/Python/facenet-retinaface-pytorch-main/predict.py";
//            File workingDirectory = new File("E:/CodeTest/Python/facenet-retinaface-pytorch-main");
//            List<String> commandList = new ArrayList<>();
//            commandList.add("python");
//            commandList.add(py);
//            commandList.add("E:/CodeTest/Python/facenet-retinaface-pytorch-main/test.mp4");
//            commandList.add("1195831600");
//            ScriptExecutor scriptExecutor = new ScriptExecutor(commandList,workingDirectory);
//            scriptExecutor.run();
//        } catch (Exception e){
//            System.out.println("failed");
//        }
//    }

}
