package com.itlab2017.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.postgresql.geometric.PGpoint;

import javax.persistence.*;
import java.util.Set;

@Table(name = "station")
@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "station", targetEntity = Sensor.class, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Sensor> sensors;
    @Column
    private String name;
    @Column
    private String apiKey;

    @Column
    private PGpoint location;

    public PGpoint getLocation() {
        return location;
    }

    public void setLocation(PGpoint location) {
        this.location = location;
    }

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
