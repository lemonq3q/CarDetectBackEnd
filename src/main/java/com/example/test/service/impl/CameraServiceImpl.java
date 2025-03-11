package com.example.test.service.impl;

import com.example.test.entity.Camera;
import com.example.test.mapper.CameraMapper;
import com.example.test.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    private CameraMapper cameraMapper;

    @Override
    public void add(Camera params) {
        cameraMapper.add(params);
    }

    @Override
    public void update(Camera params) {
        cameraMapper.update(params);
    }

    @Override
    public List<Camera> select(Camera params) {
        List<Camera> res = cameraMapper.select(params);
        return res;
    }

    @Override
    public void delete(Camera params) {
        cameraMapper.delete(params);
    }
}
