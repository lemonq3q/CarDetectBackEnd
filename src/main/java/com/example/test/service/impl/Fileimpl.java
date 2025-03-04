package com.example.test.service.impl;


import com.example.test.entity.Region;
import com.example.test.mapper.RegionMapper;
import com.example.test.mapper.UserMapper;
import com.example.test.service.FileService;
import com.example.test.util.FileUtil;
import com.example.test.util.GlobalParam;
import com.example.test.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class Fileimpl implements FileService {
    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseMessage headshotUpload(MultipartFile file, int x, int y, int width, int height, int userid) {
        //获取图片格式，默认为png
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        String fileFormat = "jpg";
        if(originalFilename != null){
            int i = originalFilename.lastIndexOf('.');
            if(i>0){
                fileFormat = originalFilename.substring(i+1);
            }
        }
        String savePicName = UUID.randomUUID().toString() + "." + fileFormat;
        String savePath = GlobalParam.linuxPicSavePath + savePicName;
        //保存图片
        try {
            file.transferTo(new File(savePath));

        } catch (IOException e) {
            System.out.println(e);
            return ResponseMessage.error("failed",null);
        }
        //调整图片样式
        if(FileUtil.cropImage(savePath,fileFormat,x,y,width,height)){
            userMapper.updateHeadshot(savePicName,userid);
            return ResponseMessage.success("success",savePicName);
        }
        else{
            return ResponseMessage.error("failed",null);
        }
    }

    @Override
    public ResponseMessage mapUpload(MultipartFile file, String workshop) {
        String mapName = UUID.randomUUID()+".txt";
        String savePath = GlobalParam.linuxMapSavePath+mapName;
        try{
            //读入文件流，解析为数组
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            List<Integer> oneDimMap = new ArrayList<>();
            String line;
            //转化为整数数组
            while((line = br.readLine()) != null){
                String[] parts = line.split("\\s+");
                for(String part : parts){
                    if(!part.isEmpty()){
                        oneDimMap.add(Integer.parseInt(part));
                    }
                }
            }
            //转换为二维数组
            Region region = regionMapper.getRegionByWorkshop(workshop);
            int[][] twoDimMap = new int[region.getHeight()][region.getWidth()];
            for(int i=0;i<region.getHeight();i++){
                for(int j=0;j<region.getWidth();j++){
                    twoDimMap[i][j] = oneDimMap.get((region.getHeight()-1-i)*region.getWidth()+j);
                }
            }
            int topCropLen = 0 ,leftCropLen = 0,rightCropLen = 0,bottomCropLen = 0;
            boolean cropFlag;
            //上部裁剪区域
            for(int i=0;i<twoDimMap.length;i++){
                cropFlag = true;
                for(int j=0;j<twoDimMap[0].length;j++){
                    if(twoDimMap[i][j]!=-1){
                        cropFlag = false;
                        break;
                    }
                }
                if(cropFlag) topCropLen++;
                else break;
            }
            //下部裁剪区域
            for(int i=twoDimMap.length-1;i>=0;i--){
                cropFlag = true;
                for(int j=0;j<twoDimMap[0].length;j++){
                    if(twoDimMap[i][j]!=-1){
                        cropFlag = false;
                        break;
                    }
                }
                if(cropFlag) bottomCropLen++;
                else break;
            }
            //左部裁剪区域
            for(int i=0;i<twoDimMap[0].length;i++){
                cropFlag = true;
                for(int j=0;j<twoDimMap.length;j++){
                    if(twoDimMap[j][i]!=-1){
                        cropFlag = false;
                        break;
                    }
                }
                if(cropFlag) leftCropLen++;
                else break;
            }
            //左部裁剪区域
            for(int i=twoDimMap[0].length-1;i>=0;i--){
                cropFlag = true;
                for(int j=0;j<twoDimMap.length;j++){
                    if(twoDimMap[j][i]!=-1){
                        cropFlag = false;
                        break;
                    }
                }
                if(cropFlag) rightCropLen++;
                else break;
            }
            //设置地图信息
            float cropOriginX = region.getOriginX()/region.getResolution()+leftCropLen;
            float cropOriginY = region.getOriginY()/region.getResolution()+bottomCropLen;
            int cropWidth = region.getWidth()-leftCropLen-rightCropLen;
            int cropHeight = region.getHeight()-topCropLen-bottomCropLen;
            //设置新地图
            int[][] cropTwoDimMap = new int[cropHeight][cropWidth];
            int[] cropOneDimMap = new int[cropHeight*cropWidth];
            for(int i=0;i<cropHeight;i++){
                for(int j=0;j<cropWidth;j++){
                    cropTwoDimMap[i][j] = twoDimMap[i+topCropLen][j+leftCropLen];
                    cropOneDimMap[i*cropWidth+j] = twoDimMap[i+topCropLen][j+leftCropLen];
                }
            }
            PrintWriter writer = new PrintWriter(new File(savePath));
            for(int point : cropOneDimMap){
                writer.print(point + " ");
            }
            writer.close();
            //更新地图信息
            region.setOriginX(cropOriginX);
            region.setOriginY(cropOriginY);
            region.setHeight(cropHeight);
            region.setWidth(cropWidth);
            region.setMapPath(mapName);
            regionMapper.updateRegion(region);
        }catch (Exception e){
            System.out.println(e);
            return ResponseMessage.error("failed",e);
        }
        return ResponseMessage.success("success",null);
    }

}
