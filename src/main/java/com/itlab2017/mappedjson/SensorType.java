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
        public String toString() {
            return "Датчик пропана и метана";
        }
    },
    MQ9 {
        public String toString() {
            return "Датчик угарного газа";
        }
    },
    MQ131 {
        public String toString() {
            return "Датчик озона";
        }
    };
}
