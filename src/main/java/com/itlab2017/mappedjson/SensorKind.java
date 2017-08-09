package com.itlab2017.mappedjson;

public enum SensorKind {

    TEMPERATURE("°С", "Температура"),
    HUMIDITY("%","Степень влажности"),
    DUST("Концентрация", "Концентрация"),
    MQ2("Концентрация", "Концентрация"),
    MQ9("Концентрация", "Концентрация"),
    MQ131("Концентрация", "Концентрация");

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