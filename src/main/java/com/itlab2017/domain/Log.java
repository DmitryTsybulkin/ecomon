package com.itlab2017.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;


@Table(name = "log")
@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String value;
    @Column
    private Timestamp timestamp;
    @Column(name = "sensor_id")
    private Integer sensor_id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Sensor.class, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(insertable = false, updatable = false, name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Integer sensor_id) {
        this.sensor_id = sensor_id;
    }
}
