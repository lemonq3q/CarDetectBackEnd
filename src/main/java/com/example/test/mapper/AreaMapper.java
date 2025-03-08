package com.example.test.mapper;

import com.example.test.entity.Area;

import java.util.List;

public interface AreaMapper {

    public List<Area> select(Area params);

    public void add(Area params);

    public void update(Area params);

    public void delete(Area params);
}
