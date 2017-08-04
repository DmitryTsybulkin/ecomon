package com.itlab2017.mappedjson;

public enum SensorKind {

    TEMPERATURE("Датчик температуры", "Температура"),
    HUMIDITY("Датчик влажности","Степень влажности"),
    DUST("Датчик пыли", "Концентрация"),
    MQ2("Датчик пропана и метана", "Концентрация"),
    MQ9("Датчик угарного газа", "Концентрация"),
    MQ131("Датчик озона", "Концентрация");

    private final String name;
    private final String valueName;

    SensorKind(String name, String valueName) {
        this.name = name;
        this.valueName = valueName;
    }

    public String getName() {
        return name;
    }

    public String getValueName() {
        return name;
    }
}