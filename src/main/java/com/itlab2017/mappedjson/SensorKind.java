package com.itlab2017.mappedjson;

public enum SensorKind {
    TEMPERATURE("Датчик температуры", "Температура"),
    NOISE("Датчик шума", "Интенсивность шума"),
    LIGHT("Датчик света", "Интенсивность света");

    private final String name;
    private final String valueName;

    SensorKind(String name, String valueName) {
        this.name = name;
        this.valueName = valueName;
    }
}