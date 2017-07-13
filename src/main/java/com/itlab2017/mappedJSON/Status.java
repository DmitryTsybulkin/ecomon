package com.itlab2017.mappedJSON;

/**
 * Created by Lenovo on 12.07.2017.
 */
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
