package com.itlab2017.mappedJSON;

/**
 * Created by Lenovo on 12.07.2017.
 */
public enum SensorKind {
    TEMPERATURE {
        public String toString() {
            return "Датчик температуры";
        }
        public String toValueType() {
            return "Температура";
        }
    },
    NOISE {
        public String toString() {
            return "Датчик шума";
        }
        public String toValueType() {
            return "Интенсивность шума";
        }
    },
    LIGHT {
        public String toString() {
            return "Датчик света";
        }

        public String toValueType() {
            return "Интенсивность света";
        }
    }
}
