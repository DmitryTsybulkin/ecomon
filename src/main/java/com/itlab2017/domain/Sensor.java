package com.itlab2017.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Lenovo on 07.07.2017.
 */
@Table(name = "sensor")
@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SensorType.class, cascade = CascadeType.ALL)
    @JoinColumn(name="sensorTypeId", referencedColumnName = "id")
    private SensorType sensorType;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Station.class, cascade = CascadeType.ALL)
    @JoinColumn(name="stationId", referencedColumnName = "id")
    private Station station;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sensor", targetEntity = Log.class,cascade = CascadeType.ALL)
    private Set<Log> logs;

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }

    public Set<Log> getLogs() {
        return logs;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }
}
