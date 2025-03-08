package com.example.test.mapper;

import com.example.test.entity.AreaDetectType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaDetectTypeMapper {

    public List<AreaDetectType> select(AreaDetectType params);

    public void add(List<AreaDetectType> params);

    public void delete(AreaDetectType params);

}
