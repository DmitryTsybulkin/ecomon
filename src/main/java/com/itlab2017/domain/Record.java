package com.itlab2017.domain;

import com.sun.xml.internal.ws.developer.Serialization;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Lenovo on 07.07.2017.
 */
@Table(name = "record")
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String value;
    private Timestamp timestamp;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Sensor.class, cascade = CascadeType.ALL)
    @JoinColumn(name="sensorId", referencedColumnName = "id")
    private Sensor sensor;

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
