package com.itlab2017.mappedJSON;

/**
 * Created by Lenovo on 12.07.2017.
 */
public class ApiGetIdResponse extends ApiResponse {

    Integer id;
    Integer[] sensorIds;

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
    public ApiGetIdResponse(Status status, Integer id, Integer[] sensorIds) {
        super(status);
        this.sensorIds = sensorIds;
        this.id = id;
    }


}
