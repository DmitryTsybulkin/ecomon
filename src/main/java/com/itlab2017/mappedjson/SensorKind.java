package com.itlab2017.mappedjson;

public enum SensorKind {

    TEMPERATURE("Датчик температуры", "Температура"),
    HUMIDITY("Датчик влажнсти", "Влажность"),
    DUST("Датчик пыли", "Степень загрязнённости"),
    MQ2("Датчик углекислого газа", "Концентрация");

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