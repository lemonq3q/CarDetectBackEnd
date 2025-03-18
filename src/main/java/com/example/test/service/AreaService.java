package com.example.test.service;

import com.example.test.entity.Area;
import com.example.test.entity.AreaDetectType;

import java.util.List;

public interface AreaService {
    public void add(Area params);

    public void update(Area params);

    public List<Area> select(Area params);

    public void delete(List<Area> params);



}
