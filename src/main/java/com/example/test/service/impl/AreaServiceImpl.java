package com.example.test.service.impl;

import com.example.test.entity.Area;
import com.example.test.entity.AreaDetectType;
import com.example.test.mapper.AreaDetectTypeMapper;
import com.example.test.mapper.AreaMapper;
import com.example.test.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private AreaDetectTypeMapper areaDetectTypeMapper;

    @Override
    public void add(Area params) {
        List<AreaDetectType> areaDetectTypes = params.getDetectTypes();
        areaMapper.add(params);
        if(areaDetectTypes != null && areaDetectTypes.size()!=0){
            for(int i=0;i<areaDetectTypes.size();i++){
                areaDetectTypes.get(i).setAreaId(params.getId());
                areaDetectTypeMapper.add(areaDetectTypes.get(i));
            }
        }
    }

    @Override
    public void update(Area params) {
        areaMapper.update(params);
        List<AreaDetectType> detectTypes = params.getDetectTypes();
        if( detectTypes != null && detectTypes.size() > 0){
            Integer id = params.getId();
            AreaDetectType detectTypeParam = new AreaDetectType(null,id,null);
            areaDetectTypeMapper.delete(detectTypeParam);
            areaDetectTypeMapper.add(detectTypes);
        }
    }

    @Override
    public List<Area> select(Area params) {
        List<Area> res = areaMapper.select(params);
        for(int i=0;i<res.size();i++){
            AreaDetectType detectTypeParam = new AreaDetectType(null,res.get(i).getId(),null);
            List<AreaDetectType> detectTypes = areaDetectTypeMapper.select(detectTypeParam);
            res.get(i).setDetectTypes(detectTypes);
        }
        return res;
    }

    @Override
    public void delete(List<Integer> params) {
        if(params.size()>0){
            areaMapper.delete(params);
            for(int param : params){
                AreaDetectType detectTypeParam = new AreaDetectType(null, param,null);
                areaDetectTypeMapper.delete(detectTypeParam);
            }
        }
    }


}
