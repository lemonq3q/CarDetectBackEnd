package com.example.test.mapper;

import com.example.test.entity.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RegionMapper {

    @Select("select * from region where workshop = #{workshop}")
    public Region getRegionByWorkshop(String workshop);

    @Update("update region set resolution = #{resolution},originX = #{originX},originY = #{originY},width = #{width}," +
            "height = #{height},mapPath = #{mapPath},updateTime=#{updateTime} where workshop = #{workshop}")
    public int updateRegion(Region region);


}
