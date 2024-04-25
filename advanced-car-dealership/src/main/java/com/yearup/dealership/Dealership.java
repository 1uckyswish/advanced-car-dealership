package com.yearup.dealership;

import java.util.ArrayList;

public class Dealership {
    private String name;// e.g. - Hippo City used cards
    private String address;// e.g. - 11 old benny dr
    private String phone; // e.g. - (803)-487-9900 ex
    private ArrayList<Vehicle> inventory;

    /**
     * Initializes a Dealership object with specified attributes.
     *
     * @param name    The name of the dealership.
     * @param phone   The phone number of the dealership.
     * @param address The address of the dealership.
     */
    public Dealership(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.inventory = new ArrayList<>();
        // every time you create a new Dealership object using this constructor,
        // a new, empty ArrayList will be created and associated with that specific
        // Dealership object.
        // ensuring that each Dealership object has its own inventory list ready to be
        // populated with vehicle data.
    }

    /**
     * Retrieves the name of the dealership.
     *
     * @return The name of the dealership.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the dealership.
     *
     * @param name The new name of the dealership.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the address of the dealership.
     *
     * @return The address of the dealership.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the dealership.
     *
     * @param address The new address of the dealership.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the phone number of the dealership.
     *
     * @return The phone number of the dealership.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the dealership.
     *
     * @param phone The new phone number of the dealership.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Methods for dealership

    /**
     * Retrieves vehicles within a specified price range from the dealership's
     * inventory.
     *
     * @param minPrice The minimum price of vehicles to search for.
     * @param maxPrice The maximum price of vehicles to search for.
     * @return An ArrayList containing vehicles within the specified price range.
     */
    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        // Create a new ArrayList to store search results
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        // Iterate through the inventory to find vehicles within the price range
        for (Vehicle vehicle : inventory) {
            // If the vehicle's price falls within the specified range, add it to the search
            // results
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                searchResults.add(vehicle);
            }
        }
        // Return the list of vehicles within the specified price range
        return searchResults;
    }

    /**
     * Retrieves vehicles with a specified make and model from the dealership's
     * inventory.
     *
     * @param makeName  The make of vehicles to search for.
     * @param modelName The model of vehicles to search for.
     * @return An ArrayList containing vehicles with the specified make and model.
     */
    public ArrayList<Vehicle> getVehiclesByMake(String makeName, String modelName) {
        // Create a new ArrayList to store search results
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        // Iterate through the inventory to find vehicles with the specified make and
        // model
        for (Vehicle vehicle : inventory) {
            // If the vehicle's make and model match the specified values
            // (case-insensitive), add it to the search results
            if (vehicle.getMake().toLowerCase().contains(makeName) || vehicle.getModel().toLowerCase().contains(modelName)) {
                searchResults.add(vehicle);
            }
        }
        // Return the list of vehicles with the specified make and model
        return searchResults;
    }

    /**
     * Retrieves vehicles with a specified manufacturing year from the dealership's
     * inventory.
     *
     * @param yearChoice The year of vehicles to search for.
     * @return An ArrayList containing vehicles manufactured in the specified year.
     */
    public ArrayList<Vehicle> getVehiclesByYear(int yearChoice) {
        // Create a new ArrayList to store search results
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        // Iterate through the inventory to find vehicles with the specified
        // manufacturing year
        for (Vehicle vehicle : inventory) {
            // If the vehicle's manufacturing year matches the specified value, add it to
            // the search results
            if (vehicle.getYear() == yearChoice) {
                searchResults.add(vehicle);
            }
        }
        // Return the list of vehicles with the specified manufacturing year
        return searchResults;
    }

    /**
     * Retrieves vehicles with a specified color from the dealership's inventory.
     *
     * @param colorChoice The color of vehicles to search for.
     * @return An ArrayList containing vehicles of the specified color.
     */
    public ArrayList<Vehicle> getVehiclesByColor(String colorChoice) {
        // Create a new ArrayList to store search results
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        // Iterate through the inventory to find vehicles with the specified color
        for (Vehicle vehicle : inventory) {
            // If the vehicle's color matches the specified value (case-insensitive), add it
            // to the search results
            if (vehicle.getColor().toLowerCase().contains(colorChoice)) {
                searchResults.add(vehicle);
            }
        }
        // Return the list of vehicles with the specified color
        return searchResults;
    }

    /**
     * Retrieves vehicles with a specified odometer reading from the dealership's
     * inventory.
     *
     * @param mileageChoice The odometer reading of vehicles to search for.
     * @return An ArrayList containing vehicles with the specified odometer reading.
     */
    public ArrayList<Vehicle> getVehiclesByMileage(int mileageChoice) {
        // Create a new ArrayList to store search results
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        // Iterate through the inventory to find vehicles with the specified odometer
        // reading
        for (Vehicle vehicle : inventory) {
            // If the vehicle's odometer reading matches the specified value, add it to the
            // search results
            if (vehicle.getOdometer() == mileageChoice) {
                searchResults.add(vehicle);
            }
        }
        // Return the list of vehicles with the specified odometer reading
        return searchResults;
    }

    /**
     * Retrieves vehicles of a specified type from the dealership's inventory.
     *
     * @param typeChoice The type of vehicles to search for.
     * @return An ArrayList containing vehicles of the specified type.
     */
    public ArrayList<Vehicle> getVehiclesByType(String typeChoice) {
        // Create a new ArrayList to store search results
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        // Iterate through the inventory to find vehicles of the specified type
        for (Vehicle vehicle : inventory) {
            // If the vehicle's type matches the specified value (case-insensitive), add it
            // to the search results
            if (vehicle.getVehicleType().toLowerCase().contains(typeChoice)) {
                searchResults.add(vehicle);
            }
        }
        // Return the list of vehicles of the specified type
        return searchResults;
    }

    /**
     * Retrieves all vehicles stored in the dealership's inventory.
     *
     * @return An ArrayList containing all vehicles in the dealership's inventory.
     */
    public ArrayList<Vehicle> getAllVehicles() {
        // Return the ArrayList containing all vehicles in the dealership's inventory
        return inventory;
    }

    /**
     * Adds a vehicle to the dealership's inventory.
     *
     * @param vehicle The vehicle to be added.
     */
    public void addVehicle(Vehicle vehicle) {
        // Add the vehicle to the dealership's inventory
        this.inventory.add(vehicle);
    }

    /**
     * Removes a vehicle from the dealership's inventory.
     *
     * @param vehicle The vehicle to be removed.
     */
    public void removeVehicle(Vehicle vehicle) {
        // Remove the vehicle from the dealership's inventory
        this.inventory.remove(vehicle);
    }

    /**
     * Provides a string representation of the Dealership object.
     *
     * @return A string representation containing the dealership's name, address,
     *         phone number, and inventory.
     */
    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
