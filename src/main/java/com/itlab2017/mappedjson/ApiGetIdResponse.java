package com.itlab2017.mappedjson;

public class ApiGetIdResponse extends ApiResponse {

    private Integer id;
    private Integer[] sensorIds;

    public ApiGetIdResponse(Status status, Integer id, Integer[] sensorIds) {
        super(status);
        this.sensorIds = sensorIds;
        this.id = id;
    }

    public Integer[] getSensorIds() {
        return sensorIds;
    }

    public void setSensorIds(Integer[] sensorIds) {
        this.sensorIds = sensorIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
