package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camera {

    private Integer id;

    private String deviceId;

    private Integer status;

    private Integer areaId;

    private String areaName;

    private String signalLine;

    private String direction;

    private Integer widthResolution;

    private Integer heightResolution;

    private String description;

    private Long lastTime;
}
