package com.itlab2017.mappedJSON;

/**
 * Created by Lenovo on 12.07.2017.
 */
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
