package com.itlab2017.mappedjson;

public class ApiResponse {
    private Status status;

    public ApiResponse(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
