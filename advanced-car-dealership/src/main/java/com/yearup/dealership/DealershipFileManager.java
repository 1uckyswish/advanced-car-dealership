package com.yearup.dealership;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DealershipFileManager {

    /**
     * Reads inventory data from a CSV file and populates the Dealership object.
     *
     * @return The populated Dealership object.
     */
    public Dealership getDealership() {
        Dealership dealership = null; // Initialize to null in case of an exception
        try {
            // Instantiate a reader with the CSV we read from
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
            // Read and Split the first line of the CSV by the pipeline
            String[] headers = reader.readLine().split(Pattern.quote("|"));
            // Assign the values from the headers to make a new Dealership by its values
            dealership = new Dealership(headers[0], headers[1], headers[2]);
            // Make a new ArrayList. This will be used to populate Dealership inventory
            ArrayList<Vehicle> inventory = new ArrayList<>();
            // Assign the reader to a string to read each line
            String line;
            while ((line = reader.readLine()) != null) {
                // Reading each line split the CSV values by the pipeline
                String[] carDetails = line.split(Pattern.quote("|"));
                // Instantiate a new Vehicle object to populate its field
                // Call a method that returns the New Object by its values of the Array
                Vehicle vehicle = makeVehicleClass(carDetails);
                // After the new car is created from the CSV values append it to the ArrayList
                inventory.add(vehicle);
            }
            // Using the above ArrayList. Populate the Dealership inventory array with all
            // the new cars
            for (Vehicle car : inventory) {
                dealership.addVehicle(car);
            }
            // Close reader
            reader.close();
        } catch (Exception e) {
            // print Exception message
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        // When method is called return the new Dealership Object
        return dealership;
    }

    /**
     * Utility method to create a new Vehicle object from an array of string values.
     *
     * @param carDetails An array containing details of the vehicle.
     * @return A new Vehicle object initialized with the provided details.
     */
    public Vehicle makeVehicleClass(String[] carDetails) {
        // Break up the index values of the array to a variable
        int vin = Integer.parseInt(carDetails[0]);
        int year = Integer.parseInt(carDetails[1]);
        String make = carDetails[2];
        String model = carDetails[3];
        String vehicleType = carDetails[4];
        String color = carDetails[5];
        int odometer = Integer.parseInt(carDetails[6]);
        double price = Double.parseDouble(carDetails[7]);
        // Return the new Vehicle with the names of the variables
        return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
    }

    /**
     * Saves the inventory of a Dealership to a CSV file.
     *
     * @param dealership The Dealership object whose inventory is to be saved.
     */
    public void saveDealership(Dealership dealership) {
        try {
            // Create a reference ArrayList that gets all the current Vehicles from the
            // dealership
            ArrayList<Vehicle> inventory = dealership.getAllVehicles();
            // Instantiate a writer with the CSV we write to
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv", false)); // Create a new file
            // Write headers manually
            writer.write(dealership.getName() + "|" + dealership.getPhone() + "|" + dealership.getAddress() + "\n");
            // Write vehicle details using its getters
            for (Vehicle vehicle : inventory) {
                writer.write(
                        vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdometer() + "|" +
                                vehicle.getPrice() + "\n");
            }
            // Close writer
            writer.close();
        } catch (Exception e) {
            // Print error message and stack trace if an exception occurs
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
