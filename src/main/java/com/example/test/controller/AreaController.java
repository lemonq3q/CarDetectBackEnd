package com.example.test.controller;

import com.example.test.entity.Area;
import com.example.test.service.AreaService;
import com.example.test.util.PageUtil;
import com.example.test.util.ResponseMessage;
import com.example.test.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping
    public TableData select(Area area){
        PageUtil.startPage();
        List<Area> res = areaService.select(area);
        return TableData.getTableData(res);
    }

    @PutMapping
    public ResponseMessage add(@RequestBody Area area){
        areaService.add(area);
        return ResponseMessage.success("添加成功",null);
    }

    @PostMapping
    public ResponseMessage update(@RequestBody Area area){
        areaService.update(area);
        return ResponseMessage.success("更新成功", null);
    }

    @DeleteMapping
    public ResponseMessage delete(Area area){
        areaService.delete(area);
        return ResponseMessage.success("删除成功", null);
    }
}
