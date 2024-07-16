package com.tommy_hoang_p0.Inventory;

public class VehicleDetails {
    private String make;
    private String model;
    private String year;
    private String color;
    private String trim;

    // Constructor
    public VehicleDetails(String make, String model, String year, String color, String trim) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.trim = trim;
    }

    // Getters and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    // toString method
    @Override
    public String toString() {
        return " {" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", trim='" + trim + '\'' +
                "} ";
    }
}

