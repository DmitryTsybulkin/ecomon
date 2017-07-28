package com.itlab2017.mappedJSON;

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
