package com.yearup.dealership;

import java.text.DecimalFormat;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType; // Car, Truck, Van, etc..
    private String color;
    private int odometer;
    private double price;

    /**
     * This will make a single vehicle and its attributes for it
     *
     * @param vin
     * @param year
     * @param make
     * @param model
     * @param vehicleType
     * @param color
     * @param odometer
     * @param price
     */
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer,
                   double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    /**
     * //Create its getters and setters for attributes
     *
     */
    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Formatted way to display the attributes in a well-structured way for user to read
     *
     * @return String
     */
    @Override
    public String toString() {
        String padding = " ";
        String line = "═════════════════════════════════════════";

        // Format the price with two decimal places and commas for a thousand separators
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        String formattedPrice = formatter.format(price);

        // Format the odometer reading with commas
        DecimalFormat odometerFormatter = new DecimalFormat("#,###");
        String formattedOdometer = odometerFormatter.format(odometer);

        StringBuilder formattedString = new StringBuilder();
        formattedString.append("╔").append(line).append("╗\n");
        formattedString.append("║").append(padding).append("VIN: ").append(vin).append("\n");
        formattedString.append("║").append(padding).append("Year: ").append(year).append("\n");
        formattedString.append("║").append(padding).append("Make: ").append(make).append("\n");
        formattedString.append("║").append(padding).append("Model: ").append(model).append("\n");
        formattedString.append("║").append(padding).append("Vehicle Type: ").append(vehicleType).append("\n");
        formattedString.append("║").append(padding).append("Color: ").append(color).append("\n");
        formattedString.append("║").append(padding).append("Odometer: ").append(formattedOdometer).append(" miles\n");
        formattedString.append("║").append(padding).append("Price: $").append(formattedPrice).append("\n");
        formattedString.append("╚").append(line).append("╝");

        return formattedString.toString();
    }

}
