package com.example.test.service;


import com.example.test.entity.Camera;

import java.util.List;

public interface CameraService {
    public void add(Camera params);

    public void update(Camera params);

    public List<Camera> select(Camera params);

    public void delete(List<Integer> params);
}
