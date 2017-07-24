package com.itlab2017.mappedjson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

public class ApiUpdate extends ApiRequest {

    @JsonDeserialize(using = ArrayMapDeserializer.class)
    Map<Integer, String> sensorsData;
    private Integer id;

    public Map<Integer, String> getSensorsData() {
        return sensorsData;
    }

    public void setSensorsData(Map<Integer, String> sensorsData) {
        this.sensorsData = sensorsData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

