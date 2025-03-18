package com.example.test.controller;

import com.example.test.entity.Camera;
import com.example.test.service.CameraService;
import com.example.test.util.PageUtil;
import com.example.test.util.ResponseMessage;
import com.example.test.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/camera")
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @GetMapping
    public TableData select(Camera params){
        PageUtil.startPage();
        List<Camera> res = cameraService.select(params);
        return TableData.getTableData(res);
    }

    @PutMapping
    public ResponseMessage add(@RequestBody Camera camera){
        cameraService.add(camera);
        return ResponseMessage.success("添加成功",camera);
    }

    @PostMapping ResponseMessage update(@RequestBody Camera params){
        cameraService.update(params);
        return ResponseMessage.success("修改成功",null);
    }

    @DeleteMapping ResponseMessage delete(@RequestParam int[] ids){
        cameraService.delete(Arrays.stream(ids)
                .boxed()
                .collect(Collectors.toList()));
        return ResponseMessage.success("删除成功",null);
    }

}
