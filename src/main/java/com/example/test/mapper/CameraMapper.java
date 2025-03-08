package com.example.test.mapper;


import com.example.test.entity.Camera;

import java.util.List;

public interface CameraMapper {

    public List<Camera> select(Camera params);

    public void add(Camera params);

    public void update(Camera params);

    public void delete(Camera params);
}
