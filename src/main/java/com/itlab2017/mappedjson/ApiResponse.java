package com.itlab2017.mappedjson;

/**
 * Created by Lenovo on 12.07.2017.
 */
public class ApiResponse {
    Status status;

    public ApiResponse(Status status){
        this.status = status;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
