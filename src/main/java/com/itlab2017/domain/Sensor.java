package com.itlab2017.domain;

import org.hibernate.annotations.Cascade;

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
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Device.class, cascade = CascadeType.ALL)
    @JoinColumn(name="deviceId", referencedColumnName = "id")
    private Device device;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sensor", targetEntity = Record.class,cascade = CascadeType.ALL)
    private Set<Record> records ;

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
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

}
