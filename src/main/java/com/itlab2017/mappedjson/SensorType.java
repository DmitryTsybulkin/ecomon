package com.itlab2017.mappedjson;

public enum SensorType {
    TEMPERATURE {
        public String toString() {
            return "Датчик температуры";
        }
    },

    NOUSE {
        public String toString() {
            return "Датчик шума";
        }
    }
}
