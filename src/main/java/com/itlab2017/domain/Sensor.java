package com.itlab2017.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Table(name = "sensor")
@Entity
public class Sensor {
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sensor", targetEntity = Log.class, cascade = CascadeType.ALL)
    protected Set<Log> logs;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SensorType.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "sensorTypeId", referencedColumnName = "id")
    @JsonBackReference
    private SensorType sensorType;
    @Column(name = "station_id")
    private Integer station_id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Station.class, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(insertable = false, updatable = false, name = "station_id", referencedColumnName = "id")
    private Station station;

    public Set<Log> getLogs() {
        return logs;
    }

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }
}
