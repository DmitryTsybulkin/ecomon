package com.itlab2017.mappedjson;

public class ApiGetId extends ApiRequest {

    private String name;

    private String location;

    private String requestHash;

    private SensorKind[] sensorKinds;

    public SensorKind[] getSensorKinds() {
        return sensorKinds;
    }

    public void setSensorKinds(SensorKind[] sensorKinds) {
        this.sensorKinds = sensorKinds;
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
