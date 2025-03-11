package com.example.test.service.impl;

import com.example.test.mapper.RecordMapper;
import com.example.test.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.entity.Record;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public void add(Record params) {
        recordMapper.add(params);
    }

    @Override
    public void update(Record params) {
        recordMapper.update(params);
    }

    @Override
    public List<Record> select(Record params) {
        List<Record> res = recordMapper.select(params);
        return res;
    }

    @Override
    public void delete(Record params) {
        recordMapper.delete(params);
    }
}
