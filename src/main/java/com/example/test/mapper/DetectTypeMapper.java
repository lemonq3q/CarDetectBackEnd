package com.example.test.mapper;

import com.example.test.entity.DetectType;

import java.util.List;

public interface DetectTypeMapper {
    public List<DetectType> select(DetectType params);

    public void add(DetectType params);

    public void update(DetectType params);

    public void delete(DetectType params);
}
