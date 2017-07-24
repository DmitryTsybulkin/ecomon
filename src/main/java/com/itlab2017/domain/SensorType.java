package com.itlab2017.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itlab2017.mappedJSON.SensorKind;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Lenovo on 07.07.2017.
 */
@Table(name = "sensorType")
@Entity
public class SensorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private SensorKind sensorKind;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sensorType", targetEntity = Sensor.class,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Sensor> sensors ;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Set<Sensor> getSensors() {
        return sensors;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSensorKind(SensorKind sensorKind) {
        this.sensorKind = sensorKind;
    }
    public SensorKind getSensorKind() {
        return sensorKind;
    }
}
