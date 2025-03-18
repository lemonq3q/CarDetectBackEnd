package com.example.test.service.impl;

import com.example.test.entity.DetectType;
import com.example.test.mapper.DetectTypeMapper;
import com.example.test.service.DetectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetectTypeServiceImpl implements DetectTypeService {

    @Autowired
    private DetectTypeMapper detectTypeMapper;

    @Override
    public void add(DetectType params) {
        detectTypeMapper.add(params);
    }

    @Override
    public void update(DetectType params) {
        detectTypeMapper.update(params);
    }

    @Override
    public List<DetectType> select(DetectType params) {
        List<DetectType> res = detectTypeMapper.select(params);
        return res;
    }

    @Override
    public void delete(List<DetectType> params) {
        if(params.size()>0){
            detectTypeMapper.delete(params);
        }
    }
}
