package com.itlab2017.mappedjson;

public enum SensorType {
    TEMPERATURE {
        public String toString() {
            return "Датчик температуры";
        }
    },

    HUMIDITY {
        public String toString() {
            return "Датчик влажности";
        }
    },

    DUST {
        public String toString() { return "Датчик пыли"; }
    },

    MQ2 {
        public String toString() { return "Датчик углекислого газа"; }
    }
}
