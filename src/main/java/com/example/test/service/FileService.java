package com.example.test.service;

import com.example.test.util.ResponseMessage;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    public ResponseMessage headshotUpload(@RequestParam("file") MultipartFile file, int x, int y, int width, int height,int userid);

    public ResponseMessage mapUpload(@RequestParam("file")MultipartFile file,String workshop);


}
