package com.example.test.entity;

public class Region {
    private String workshop;
    private String mapPath;
    private Float resolution;
    private Integer width;
    private Integer height;
    private Float originX;
    private Float originY;
    private String videoId;
    private Long updateTime;

    public Region(String workshop, String mapPath, Float resolution, Integer width, Integer height, Float originX, Float originY, String videoId, Long updateTime) {
        this.workshop = workshop;
        this.mapPath = mapPath;
        this.resolution = resolution;
        this.width = width;
        this.height = height;
        this.originX = originX;
        this.originY = originY;
        this.videoId = videoId;
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return "Region{" +
                "workshop='" + workshop + '\'' +
                ", mapPath='" + mapPath + '\'' +
                ", resolution=" + resolution +
                ", width=" + width +
                ", height=" + height +
                ", originX=" + originX +
                ", originY=" + originY +
                ", videoId='" + videoId + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getMapPath() {
        return mapPath;
    }

    public void setMapPath(String mapPath) {
        this.mapPath = mapPath;
    }

    public Float getResolution() {
        return resolution;
    }

    public void setResolution(Float resolution) {
        this.resolution = resolution;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getOriginX() {
        return originX;
    }

    public void setOriginX(Float originX) {
        this.originX = originX;
    }

    public Float getOriginY() {
        return originY;
    }

    public void setOriginY(Float originY) {
        this.originY = originY;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}

