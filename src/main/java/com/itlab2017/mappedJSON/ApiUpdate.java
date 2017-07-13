package com.itlab2017.mappedJSON;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 12.07.2017.
 */
public class ApiUpdate extends ApiRequest {

    Integer id;

    @JsonDeserialize(using = ArrayMapDeserializer.class)
    Map<Integer,String> sensorsData ;

    public Map<Integer, String> getSensorsData() {
        return sensorsData;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setSensorsData(Map<Integer, String> sensorsData) {
        this.sensorsData = sensorsData;
    }
}

