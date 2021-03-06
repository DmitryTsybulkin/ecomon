package com.itlab2017.business;

import java.sql.Timestamp;

public class GraphMessageResponse {
    private Integer sensorId;
    private String data;
    private Timestamp time;

    public GraphMessageResponse(String data, Timestamp time, Integer sensorId) {
        this.data = data;
        this.time = time;
        this.sensorId = sensorId;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getData() {
        return data;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getSensorId() {
        return sensorId;
    }
}
