package com.itlab2017.mappedJSON;

/**
 * Created by Lenovo on 12.07.2017.
 */
public class ApiGetId extends ApiRequest {

    String name;

    String location;

    String requestHash;

    SensorType[] sensorTypes;

    public SensorType[] getSensorTypes() {
        return sensorTypes;
    }
    public void setSensorTypes(SensorType[] sensorTypes) {
        this.sensorTypes = sensorTypes;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getRequestHash() {
        return requestHash;
    }
    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }
}
