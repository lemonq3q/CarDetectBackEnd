package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    private Integer id;

    private Integer typeId;

    private String typeName;

    private String carId;

    private Long recordTime;

    private String video;

    private Integer areaId;

    private String areaName;

    private String areaAddress;

    private Integer cameraId;
}
