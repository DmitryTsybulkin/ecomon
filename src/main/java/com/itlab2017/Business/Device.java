package com.itlab2017.Business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Table(appliesTo = "Device")
@Entity
public class Device {
    @JsonProperty
    @Id
    @GeneratedValue
    public int id ;
    @JsonProperty
    public String name;
}
