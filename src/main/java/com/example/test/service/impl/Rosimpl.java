package com.example.test.service.impl;


import com.example.test.entity.InspectPoint;
import com.example.test.entity.Region;
import com.example.test.mapper.InspectPointMapper;
import com.example.test.mapper.RegionMapper;
import com.example.test.service.RosService;
import com.example.test.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rosimpl implements RosService {

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private InspectPointMapper inspectPointMapper;

    @Override
    public ResponseMessage updateRegion(Region region) {
        region.setUpdateTime(System.currentTimeMillis());
        regionMapper.updateRegion(region);
        return ResponseMessage.success("success",null);
    }

    @Override
    public ResponseMessage getRegion(String workshop) {
        Region region = regionMapper.getRegionByWorkshop(workshop);
        return ResponseMessage.success(null,region);
    }

    @Override
    public ResponseMessage getInspectPoints(String workshop) {
        List<InspectPoint> inspectPoints = inspectPointMapper.getPointByWorkshop(workshop);
        System.out.println(inspectPoints.size());
        return ResponseMessage.success(null,inspectPoints);
    }

    @Override
    public ResponseMessage updateInspectPoints(InspectPoint[] inspectPoints) {
        String workshop = inspectPoints[0].getWorkshop();
        if(workshop!=null){
            inspectPointMapper.deletePoint(workshop);
        }
        for(InspectPoint inspectPoint:inspectPoints){
            inspectPointMapper.addPoint(inspectPoint.getWorkshop(),inspectPoint.getSeq(),inspectPoint.getPoint());
        }
        return ResponseMessage.success("success",null);
    }
}
