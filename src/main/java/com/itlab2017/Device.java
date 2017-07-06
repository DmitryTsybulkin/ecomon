package com.itlab2017;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Device {
    @JsonProperty
    protected int id ;
    @JsonProperty
    protected String name;
}
