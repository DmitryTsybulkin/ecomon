package com.itlab2017.mappedJSON;

public enum Status {
    ERROR {
        public String toString() {
            return "error";
        }
    },

    OK {
        public String toString() {
            return "ok";
        }
    }
}
