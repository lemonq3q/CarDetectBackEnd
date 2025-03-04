package com.example.test.mapper;

import com.example.test.entity.Model;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ModelMapper {
    @Select("select * from model")
    public List<Model> getAllModel();

    @Select("select * from model where id in (select model_id from deviceModel where device_id=#{device_id})")
    public List<Model> getModelByDevice(String device_id);

    @Update("update model set modelName=#{modelName},modelDesc=#{modelDesc},level=#{level} where id=#{id}")
    public void uploadModelBaseInfo(String modelName,String modelDesc,int level,int id);

    @Update("update model set rounds=rounds+#{rounds},time=#{time},state=1,accuracy=#{accuracy},modelPath=#{modelPath} where id=#{id}")
    public void uploadModelTrainInfo(int rounds,long time,float accuracy,int id,String modelPath);

    @Update("update model set state=0 where id=#{id}")
    public void uploadModelState(int id);

    @Delete("delete from model where id=#{id}")
    public void deleteModel(int id);

    @Select("select * from model where id=#{id}")
    public Model getModelById(int id);

    @Insert("insert into model(modelName,modelDesc,custom,time,state,rounds,accuracy,level)" +
            " values(#{modelName},#{modelDesc},1,#{time},0,0,0,#{level})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void addModel(Model model);
}
