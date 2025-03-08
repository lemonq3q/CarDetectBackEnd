package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    private Integer id;

    private String areaName;

    private String address;

    private String pic;

    private String description;

    private List<AreaDetectType> detectTypes;
}
