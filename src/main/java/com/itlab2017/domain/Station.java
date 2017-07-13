package com.itlab2017.domain;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.*;

@Table(name = "station")
@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "station", targetEntity = Sensor.class,cascade = CascadeType.ALL)
    private Set<Sensor> sensors ;
    private String name;
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Sensor> getSensors() {
        return sensors;
    }
    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }
}