package com.java.jsf;

import java.io.Serializable;

public class Temperature implements Serializable {

	private static final long serialVersionUID = 1L;
	private String unit;
    private int value;

    public Temperature(String unit, int value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public String toString() {
        switch (unit) {
            case "C":
            case "c":
                return value + " Celcius";
            case "F":
            case "f":
                return value + " Fahrenheit";
            default:
                return "Invalid Temperature";
        }
    }

}
