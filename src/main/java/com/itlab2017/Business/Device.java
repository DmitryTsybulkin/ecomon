package com.itlab2017.Business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Device {
    @JsonProperty
    public int id ;
    @JsonProperty
    public String name;
}
