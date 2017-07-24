package com.itlab2017.mappedjson;

public enum Status {
    ERROR("error"),
    OK("ok");

    private String displayText;

    Status(String displayText) {
        this.displayText = displayText;
    }
}
