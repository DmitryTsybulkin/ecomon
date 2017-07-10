package com.itlab2017.domain;

import java.sql.Timestamp;

public class Message {

    private String data;

    private Timestamp time;

 public Message(String data, Timestamp time){
    this.data = data;
    this.time = time;
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
}
