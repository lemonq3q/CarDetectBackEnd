package com.example.test.controller;

import com.example.test.service.FileService;
import com.example.test.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 上传用户裁剪头像
     * @param file
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     */
    @PostMapping("/file/headshot")
    public ResponseMessage headshotUpload(@RequestParam("file")MultipartFile file,int x,int y,int width,int height,int userid){
        return fileService.headshotUpload(file,x,y,width,height,userid);
    }

    /**
     * 上传地图信息
     * @param file
     * @param workshop
     * @return
     */
    @PostMapping("/file/map")
    public ResponseMessage mapUpload(@RequestParam("file")MultipartFile file,String workshop) {
        return fileService.mapUpload(file, workshop);
    }
}

