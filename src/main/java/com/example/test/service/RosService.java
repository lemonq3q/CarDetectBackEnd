package com.example.test.service;

import com.example.test.entity.InspectPoint;
import com.example.test.entity.Region;
import com.example.test.util.ResponseMessage;
import org.springframework.web.bind.annotation.RequestBody;

public interface RosService {

    public ResponseMessage updateRegion(@RequestBody Region region);

    public ResponseMessage getRegion(String workshop);

    public ResponseMessage getInspectPoints(String workshop);

    public ResponseMessage updateInspectPoints(@RequestBody InspectPoint[] inspectPoints);
}
