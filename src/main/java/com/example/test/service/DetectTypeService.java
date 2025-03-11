package com.example.test.service;

import com.example.test.entity.DetectType;

import java.util.List;

public interface DetectTypeService {
    public void add(DetectType params);

    public void update(DetectType params);

    public List<DetectType> select(DetectType params);

    public void delete(DetectType params);
}
