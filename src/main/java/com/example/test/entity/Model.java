package com.example.test.entity;

public class Model {
    private int id;
    private String modelName;
    private String modelPath;//模型文件的路径
    private String modelDesc;//模型描述
    private int custom;//是否是自定义的模型标签
    private long time;//最后一次更新的时间
    private int state;//状态：模型是否可用
    private int rounds;//模型训练的轮数
    private float accuracy;//模型的精度
    private int level;

    public Model(int id, String modelName, String modelPath, String modelDesc, int custom, long time, int state, int rounds, float accuracy, int level) {
        this.id = id;
        this.modelName = modelName;
        this.modelPath = modelPath;
        this.modelDesc = modelDesc;
        this.custom = custom;
        this.time = time;
        this.state = state;
        this.rounds = rounds;
        this.accuracy = accuracy;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", modelPath='" + modelPath + '\'' +
                ", modelDesc='" + modelDesc + '\'' +
                ", custom=" + custom +
                ", time=" + time +
                ", state=" + state +
                ", rounds=" + rounds +
                ", accuracy=" + accuracy +
                ", level=" + level +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    public String getModelDesc() {
        return modelDesc;
    }

    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc;
    }

    public int getCustom() {
        return custom;
    }

    public void setCustom(int custom) {
        this.custom = custom;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
