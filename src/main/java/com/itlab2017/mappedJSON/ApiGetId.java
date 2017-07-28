package com.itlab2017.mappedJSON;


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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequestHash() {
        return requestHash;
    }
    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }
}
