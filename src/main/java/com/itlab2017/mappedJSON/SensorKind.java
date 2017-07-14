package com.itlab2017.mappedJSON;

/**
 * Created by Lenovo on 12.07.2017.
 */
public enum SensorKind {
    TEMPERATURE {
        public String toString() {
            return "Датчик температуры";
        }
    },
    NOISE {
        public String toString() {
            return "Датчик шума";
        }
    },
    LIGHT {
        public String toString() {
            return "Датчик света";
        }
    }
}
