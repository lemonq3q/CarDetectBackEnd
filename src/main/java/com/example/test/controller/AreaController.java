package com.example.test.controller;

import com.example.test.entity.Area;
import com.example.test.service.AreaService;
import com.example.test.service.InformationService;
import com.example.test.util.PageUtil;
import com.example.test.util.ResponseMessage;
import com.example.test.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @Value("${upload.path}")
    private String imagePath;

    @GetMapping
    public TableData select(Area area){
        PageUtil.startPage();
        List<Area> res = areaService.select(area);
        return TableData.getTableData(res);
    }

    @PutMapping
    public ResponseMessage add(@RequestBody Area area){
        areaService.add(area);
        return ResponseMessage.success("添加成功",area);
    }

    @PostMapping
    public ResponseMessage update(@RequestBody Area area){
        areaService.update(area);
        return ResponseMessage.success("更新成功", null);
    }

    @DeleteMapping
    public ResponseMessage delete(@RequestParam int[] ids){
        areaService.delete(Arrays.stream(ids)
                .boxed()
                .collect(Collectors.toList()));
        return ResponseMessage.success("删除成功", null);
    }

    /**
     * 上传照片
     * @param file
     * @param filename
     * @return
     */
    @PostMapping("/pic")
    public ResponseMessage uploadNormalImage(@RequestParam("file") MultipartFile file, String filename){
        String savePath = imagePath + filename;
        try {
            file.transferTo(new File(savePath));
        } catch (IOException e) {
            ResponseMessage.error("上传失败", null);
            throw new RuntimeException(e);
        }
        return ResponseMessage.success("上传成功",null);
    }
}
