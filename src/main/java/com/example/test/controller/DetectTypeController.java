package com.example.test.controller;

import com.example.test.entity.DetectType;
import com.example.test.service.DetectTypeService;
import com.example.test.util.PageUtil;
import com.example.test.util.ResponseMessage;
import com.example.test.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/detectType")
public class DetectTypeController {

    @Autowired
    private DetectTypeService detectTypeService;

    @GetMapping
    public TableData select(DetectType params){
        PageUtil.startPage();
        List<DetectType> res = detectTypeService.select(params);
        return TableData.getTableData(res);
    }

    @PutMapping
    public ResponseMessage add(DetectType detectType){
        detectTypeService.add(detectType);
        return ResponseMessage.success("添加成功",detectType);
    }

    @PostMapping
    public ResponseMessage update(DetectType params){
        detectTypeService.update(params);
        return ResponseMessage.success("更新成功",null);
    }

    @DeleteMapping
    public ResponseMessage delete(DetectType[] params){
        detectTypeService.delete(Arrays.asList(params));
        return ResponseMessage.success("删除成功", null);
    }

}
