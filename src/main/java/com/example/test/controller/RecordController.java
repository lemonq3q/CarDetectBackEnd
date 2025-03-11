package com.example.test.controller;

import com.example.test.entity.Record;
import com.example.test.service.RecordService;
import com.example.test.util.PageUtil;
import com.example.test.util.ResponseMessage;
import com.example.test.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping
    public TableData select(Record params){
        PageUtil.startPage();
        List<Record> res = recordService.select(params);
        return TableData.getTableData(res);
    }

    @PutMapping
    public ResponseMessage add(Record record){
        recordService.add(record);
        return ResponseMessage.success("添加成功",record);
    }

    @PostMapping
    public ResponseMessage update(Record params){
        recordService.update(params);
        return ResponseMessage.success("更新成功",null);
    }

    @DeleteMapping
    public ResponseMessage delete(Record params){
        recordService.delete(params);
        return ResponseMessage.success("删除成功", null);
    }
}
