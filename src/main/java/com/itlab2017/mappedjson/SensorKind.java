package com.itlab2017.mappedjson;

public enum SensorKind {

    TEMPERATURE("°C", "Датчик температуры"),
    HUMIDITY("%", "Датчик влажности"),
    DUST("Степень загрязнённости", "Датчик пыли"),
    MQ2("Концентрация", "Датчик углекисклого газа");

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