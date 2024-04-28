package com.yearup.dealership;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the user interface for interacting with the dealership
 * inventory.
 */
public class UserInterface {
    // Make a variable for to hold the new Instantiation of the object
    private Dealership dealership;

    // Calling this constructor starts the program my reading the CSV file and
    // making a new Dealership
    UserInterface() {
        init();
    }

    /**
     * Instantiation of a new file reading is called with the values of the CSV
     * applied to the class Dealership attribute
     */
    private void init() {
        // Call the method within the File Manager to get data from CSV
        DealershipFileManager fileManager = new DealershipFileManager();
        // Pass the values of the Dealership to the attribute at the top of the class
        this.dealership = fileManager.getDealership();
    }

    /**
     * Method hold the User Display screen for them to navigate the Dealership and
     * its inventory
     */
    public void display() {
        Scanner scanner = new Scanner(System.in);
        // Create a boolean flag to check if user clicked the correct choice given
        boolean exit = false;

        // If not true, continue
        while (!exit) {
            // Display menu
            System.out.println("==== Dealership Menu ====");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicles by year");
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage");
            System.out.println("6. Get vehicles by vehicle type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("10. Sell or Lease a vehicle");
            System.out.println("11. Admin Portal");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Read user command
            String choice = scanner.nextLine();

            // Process user command
            // This will keep the program running unless the user types 0
            switch (choice) {
                case "1":
                    processGetByPriceRequest(scanner);
                    break;
                case "2":
                    processGetByMakeModelRequest(scanner);
                    break;
                case "3":
                    processGetByYearRequest(scanner);
                    break;
                case "4":
                    processGetByColorRequest(scanner);
                    break;
                case "5":
                    processGetByMileageRequest(scanner);
                    break;
                case "6":
                    processGetByVehicleTypeRequest(scanner);
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest(scanner);
                    break;
                case "9":
                    processRemoveVehicleRequest(scanner);
                    break;
                case "10":
                  processRecordOfSaleOrLease(scanner);
                    break;
                case "11":
                    adminDisplay(scanner);
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.print("\nInvalid choice. Please try again.\n");
                    break;
            }
        }

        // Close the scanner properly
        scanner.close();
    }

    /**
     * Allows the user to search for vehicles within a specified price range.
     *
     * @param scanner The scanner object used for user input.
     */
    private void processGetByPriceRequest(Scanner scanner) {
        // Prompt the user to enter the minimum and maximum price
        System.out.println("\nPlease enter the price range you're interested in");
        // Pass the question and scanner into the method to validate the correct input
        // data Type
        double minPrice = validateDoubleInput(scanner, "Please enter the minimum price: ");
        double maxPrice = validateDoubleInput(scanner, "Please enter the maximum price: ");
        scanner.nextLine(); // Consume newline buffer
        // Pass the value the user submitted to the method of the dealership to do the
        // checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByPrice(minPrice, maxPrice);

        // If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Price ====");
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(searchResults);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available within the specified price range ===\n");
        }
    }

    /**
     * Processes a request to retrieve vehicles by make and model using user input
     * from a scanner.
     *
     * @param scanner The scanner object used for user input.
     */
    private void processGetByMakeModelRequest(Scanner scanner) {
        // Pass the question and scanner into the method to validate the correct input
        // data Type
        // Convert the make name to lowercase for easier checking
        System.out.print("Please specify the make: ");
        String makeName = validateStringInput(scanner, "Please enter the make name: ").toLowerCase();

        System.out.print("Please specify the model: ");
        String modelName = validateStringInput(scanner, "Please enter the model name: ").toLowerCase();

        // Pass the value the user submitted to the method of the dealership to do the
        // checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByMake(makeName, modelName);

        // If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            System.out.println("\n==== Vehicle Results By Make And Model ====");
            displayVehicles(searchResults);
        } else {
            // if no values are found inform user
            System.out.println(
                    "\n=== Sorry, there are no vehicles available matching the specified make and model name ===\n");
        }
    }

    /**
     * Processes a request to retrieve vehicles by year using user input from a
     * scanner.
     *
     * @param scanner The scanner object used for user input.
     */
    private void processGetByYearRequest(Scanner scanner) {
        // Prompt the user to specify the year
        // Pass the question and scanner into the method to validate the correct input
        // data Type
        System.out.print("Please specify the year you are looking for: ");
        int yearChoice = validateIntInput(scanner, "Please enter the year: ");
        scanner.nextLine(); // Consume newline buffer
        // Pass the value the user submitted to the method of the dealership to do the
        // checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByYear(yearChoice);

        // If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Year ====");
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(searchResults);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available for the specified year ====\n");
        }
    }

    /**
     * Processes a request to retrieve vehicles by color using user input from a
     * scanner.
     *
     * @param scanner The scanner object used for user input.
     */
    private void processGetByColorRequest(Scanner scanner) {
        // Prompt the user to specify the color of the car
        // Pass the question and scanner into the method to validate the correct input
        // data Type
        System.out.print("Please specify the color of the car you are looking for: ");
        // When it returns make it lowerCase for the easier checking below
        String colorChoice = validateStringInput(scanner, "Please enter the car color: ").toLowerCase();
        // Pass the value the user submitted to the method of the dealership to do the
        // checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByColor(colorChoice);

        // If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Color ====");
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(searchResults);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available in the specified color ====\n");
        }
    }

    /**
     * Processes a request to retrieve vehicles by mileage using user input from a
     * scanner.
     *
     * @param scanner The scanner object used for user input.
     */
    private void processGetByMileageRequest(Scanner scanner) {
        // Pass the question and scanner into the method to validate the correct input
        // data Type
        System.out.print("Please specify the desired mileage for a vehicle: ");
        int mileageChoice = validateIntInput(scanner, "Please enter the desired mileage: ");
        scanner.nextLine(); // Consume newline buffer
        // Pass the value the user submitted to the method of the dealership to do the
        // checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByMileage(mileageChoice);

        // If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Mileage ====");
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(searchResults);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available with the specified mileage ===\n");
        }
    }

    /**
     * Processes a request to retrieve vehicles by vehicle type using user input
     * from a scanner.
     *
     * @param scanner The scanner object used for user input.
     */
    private void processGetByVehicleTypeRequest(Scanner scanner) {
        // Pass the question and scanner into the method to validate the correct input
        // data Type
        System.out.print("Please specify the type of vehicle you are looking for: ");
        // When it returns make it lowerCase for the easier checking below
        String typeChoice = validateStringInput(scanner, "Please enter the type of vehicle: ").toLowerCase();

        // Pass the value the user submitted to the method of the dealership to do the
        // checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByType(typeChoice);

        // If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Type ====");
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(searchResults);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available for the specified type ===\n");
        }
    }

    /**
     * Processes a request to retrieve all vehicles available in the dealership.
     * Retrieves all vehicles from the dealership and displays them.
     */
    private void processGetAllVehiclesRequest() {
        // Call the dealership method to get all the Vehicles in the ArrayList
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        // Pass the ArrayList to the helper method
        displayVehicles(vehicles);
    }

    private void processRecordOfSaleOrLease(Scanner scanner){
        System.out.println("\nPlease choose an option: Sell or Lease a vehicle");
        System.out.println("1. Sell");
        System.out.println("2. Lease");
        System.out.println("Else. Go Home");
        // Ask user what option they want.
        System.out.print("Enter your choice: ");
        String option = scanner.nextLine().trim();
        switch(option){
            case "1": sellVehicle(scanner);break;
            case "2": leaseVehicle(scanner);break;
            default:
                System.out.println("\n\nReturning back home....\n\n");
                display();break;
        }
    }

    private void sellVehicle(Scanner scanner) {
        //Make a new object to get the save contract method
        ContractDataManager contractDataManager = new ContractDataManager();
        boolean foundVehicle = false;
        Vehicle vehicleSold = null;
        while (!foundVehicle) {
            int searchedVin = validateIntInput(scanner, "Please provide the (VIN) for the vehicle you are selling: ");
            scanner.nextLine(); // Consume newline character
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                if (vehicle.getVin() == searchedVin) {
                    vehicleSold = vehicle;
                    foundVehicle = true;
                    break;
                }
            }

            if (!foundVehicle) {
                System.out.println("\nVehicle with VIN " + searchedVin + " not found!\n        Please try again.\n");
            }

            if(foundVehicle){
                System.out.print("Enter customer full name: ");
                String customerName = scanner.nextLine().trim();
                System.out.print("Enter customer email: ");
                String customerEmail = scanner.nextLine().trim();
                System.out.print("Would they like to finance car? (Yes/No): ");
                String customerFinace = scanner.nextLine().trim();
                boolean financeOption = (customerFinace.equalsIgnoreCase("Yes") ? true : false);
                //Ask for add ons
                double vehiclePriceWithAddOns = vehicleSold.getPrice() + displayAddOnsMenu(scanner);
                vehicleSold.setPrice(vehiclePriceWithAddOns);
                SalesContract newSaleContract = new SalesContract(contractDateStamp(), customerName, customerEmail, vehicleSold, financeOption);

                contractDataManager.saveContract(newSaleContract);
                dealership.removeVehicle(vehicleSold);
                DealershipFileManager fileManager = new DealershipFileManager();
                fileManager.saveDealership(dealership);
            }
        }
        System.out.println("\n    *** CONGRATULATIONS ***");
        System.out.println("==== Vehicle Successfully Sold! ====");
        System.out.println("Details of the sold vehicle:");
        System.out.println(vehicleSold);
    }


    private double displayAddOnsMenu(Scanner scanner) {
        System.out.println("Welcome to the Car Add-Ons Menu");
        System.out.println("1. GPS Navigation System ($200)");
        System.out.println("2. Remote Start System ($150)");
        System.out.println("3. Blind Spot Detection System ($100)");
        System.out.println("4. Dash Camera ($50)");
        System.out.println("5. Wi-Fi Hotspot ($100)");
        System.out.println("6. Parking Assist System ($150)");
        System.out.println("0. Exit");

        // Initialize an array to keep track of add-on selections
        boolean[] addOnSelected = new boolean[7];

        double totalAddOnPrice = 0;

        while (true) {
            System.out.print("Enter the number of the add-on you'd like to include (0 to exit): ");
            int addOnSelection = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (addOnSelection == 0) {
                return totalAddOnPrice; // Return the total add-on price
            }

            // Check if the add-on has already been selected
            if (addOnSelected[addOnSelection]) {
                System.out.println("This add-on has already been selected. Please choose a different one.");
                continue;
            }

            // Update the add-on selection status
            addOnSelected[addOnSelection] = true;

            // Update total add-on price based on selection
            switch (addOnSelection) {
                case 1:
                    totalAddOnPrice += 200;
                    break;
                case 2:
                    totalAddOnPrice += 150;
                    break;
                case 3:
                    totalAddOnPrice += 100;
                    break;
                case 4:
                    totalAddOnPrice += 50;
                    break;
                case 5:
                    totalAddOnPrice += 100;
                    break;
                case 6:
                    totalAddOnPrice += 150;
                    break;
                default:
                    System.out.println("Invalid add-on selection. Please try again.");
            }
        }
    }

    private void leaseVehicle(Scanner scanner){
        //Make a new object to get the save contract method
        ContractDataManager contractDataManager = new ContractDataManager();
        boolean foundVehicle = false;
        Vehicle vehicleLeased = null;
        while (!foundVehicle) {
            int searchedVin = validateIntInput(scanner, "Please provide the (VIN) for the vehicle to lease: ");
            scanner.nextLine(); // Consume newline character
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                if (vehicle.getVin() == searchedVin) {
                    vehicleLeased = vehicle;
                    foundVehicle = true;
                    break;
                }
            }

            if (!foundVehicle) {
                System.out.println("\nVehicle with VIN " + searchedVin + " not found!\n        Please try again.\n");
            }

            if(foundVehicle){
                System.out.print("Enter customer full name: ");
                String customerName = scanner.nextLine().trim();
                System.out.print("Enter customer email: ");
                String customerEmail = scanner.nextLine().trim();

                LeaseContract newSaleContract = new LeaseContract(contractDateStamp(), customerName, customerEmail, vehicleLeased);

                contractDataManager.saveContract(newSaleContract);
                dealership.removeVehicle(vehicleLeased);
                DealershipFileManager fileManager = new DealershipFileManager();
                fileManager.saveDealership(dealership);
            }
        }
        System.out.println("\n    *** CONGRATULATIONS ***");
        System.out.println("==== Vehicle Successfully Leased! ====");
        System.out.println("Details of the leased vehicle:");
        System.out.println(vehicleLeased);

    }


    private String contractDateStamp(){
        LocalDate currentDate = LocalDate.now();
        // Format the date as YYYYMMDD
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }


    /**
     * Processes a request to add a new vehicle to the dealership's inventory using
     * user input from the scanner.
     * Prompts the user to enter vehicle details such as VIN, year, make, model,
     * vehicle type, color, odometer reading, and price.
     * Validates the input data types using helper methods.
     * Create a new Vehicle object with the entered details.
     * Add the new Vehicle to the dealership's inventory.
     * Save the updated inventory to a file using DealershipFileManager.
     * Displays a confirmation message with the details of the newly added vehicle.
     *
     * @param scanner Scanner object used for user input
     */
    private void processAddVehicleRequest(Scanner scanner) {
        // Pass the question and scanner into the method to validate the correct input
        // data Type
        int vin = validateIntInput(scanner, "Please enter the VIN # of the vehicle: ");
        int year = validateIntInput(scanner, "Please enter the year of the vehicle: ");
        scanner.nextLine(); // Consume newline character
        String make = validateStringInput(scanner, "Please enter the make of the vehicle: ");
        String model = validateStringInput(scanner, "Please enter the model of the vehicle: ");
        String vehicleType = validateStringInput(scanner, "Please enter the type of the vehicle (e.g., sedan, SUV): ");
        String color = validateStringInput(scanner, "Please enter the color of the vehicle: ");
        int odometer = validateIntInput(scanner, "Please enter the current mileage of the vehicle: ");
        double price = validateDoubleInput(scanner, "Please enter the price of the vehicle for sale: ");
        scanner.nextLine(); // Consume newline character

        // Pass all the variable to make a new Vehicle using its constructor
        Vehicle newVehicleMade = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        // Call the method within the dealership that handles adding a new Vehicle to
        // the ArrayList
        dealership.addVehicle(newVehicleMade);
        // Save the updated dealership after adding the new vehicle
        DealershipFileManager fileManager = new DealershipFileManager();
        // Call the method that adds writes the current ArrayList everytime a new
        // Vehicle is added to the CSV
        fileManager.saveDealership(dealership);
        // Show the new Vehicle they added
        System.out.println("==== New Vehicle Added ====");
        System.out.println(newVehicleMade);
    }

    /**
     * Processes a request to remove a vehicle from the dealership's inventory by
     * its VIN.
     * Retrieves the list of vehicles from the dealership's inventory.
     * Prompts the user to enter the VIN of the vehicle to remove.
     * Validates the input data type using a helper method.
     * Searches for the vehicle with the specified VIN in the inventory.
     * If found, remove the vehicle from the inventory using the dealership's helper
     * method.
     * Save the updated inventory to a file using DealershipFileManager.
     * Displays a confirmation message with the details of the removed vehicle.
     *
     * @param scanner Scanner object used for user input
     */
    private void processRemoveVehicleRequest(Scanner scanner) {
        // Call the helper method that gets all the vehicles from the ArrayList
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        // Pass the question and scanner into the method to validate the correct input
        // data Type
        int vinChoice = validateIntInput(scanner, "Please enter the VIN of the vehicle to remove: ");
        scanner.nextLine(); // Consume newline character
        boolean found = false; // use a boolean flag to check if the VIN exist
        Vehicle temporaryVehicle = null; // Set Vehicle to null in case no VIN is found
        for (Vehicle vehicle : inventory) {
            // Loop through the Arraylist to find the Vin
            if (vehicle.getVin() == vinChoice) {
                // If found, remove the Vehicle using the dealerships helper method
                temporaryVehicle = vehicle;
                dealership.removeVehicle(vehicle);
                // Update the boolean flag to true
                found = true;
                // Break out the loop when found
                break;
            }
        }
        // Use the boolean flag if no vehicle is found with that VIN
        if (!found) {
            System.out.println("\n==== Sorry, there are no vehicles available with the specified VIN ===\n");
        } else {
            // If Vin is found, it will remove it
            // Display the user the Vehicle you removed
            System.out.println("\n==== Vehicle Removed ====");
            System.out.println(temporaryVehicle);
            // Save the updated dealership after removing the vehicle
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);
        }
    }

    private void adminDisplay(Scanner scanner){
        System.out.println("\nWelcome to the Contract Administration System!\nPlease log in to proceed.");
        System.out.print("Enter your admin username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter your admin password: ");
        String password = scanner.nextLine().trim();
        if(!password.equalsIgnoreCase("ABC123")){
            System.out.println("\nIncorrect password. Access denied.");
            System.out.println("Returning back home...\n");
        }else{
            System.out.println("\nWelcome back, " + username + "!");
            System.out.println("Loading the Contract Administration System...\n");

            AdminUserInterface admin = new AdminUserInterface(new ContractDataManager());
            admin.display();
            String choice = scanner.nextLine().trim();
            // Display the chosen contracts
            switch (choice) {
                case "1":
                    admin.viewAllContracts();
                    break;
                case "2":
                    admin.viewSaleContracts();
                    break;
                case "3":
                    admin.viewLeaseContracts();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    System.out.println("Returning to the main menu...\n");
            }
        }
    }




    /**
     * Displays the details of all vehicles in the inventory.
     * Iterates through the list of vehicles passed as a parameter.
     * Print the details of each vehicle to the console.
     *
     * @param vehicles ArrayList of vehicles to be displayed
     */
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println("\n==== All Vehicle's In Inventory ====");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    /**
     * Validates user input to ensure it is an integer.
     * Prompts the user with the given message until a valid integer is entered.
     *
     * @param scanner The Scanner object used to read user input
     * @param prompt  The message prompting the user to enter an integer
     * @return The valid integer entered by the user
     */
    private int validateIntInput(Scanner scanner, String prompt) {
        // Set a starter value to use for returning
        int input;
        // Use a while loop to keep prompting till it breaks out the loop
        while (true) {
            // Print out the question for user to respond to
            System.out.print(prompt);
            // If the scanner notices its asking for an Int, and it feeds it, then apply it
            // to the variable
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                // Break out the loop when it matches
                break;
            } else {
                // If user types something else then Int it will alert the user
                System.out.println("\n==== Sorry, that input is invalid. Please enter a valid numeric value ===\n");
                scanner.next(); // Consume invalid input
            }
        }
        // return the user input
        return input;
    }

    /**
     * Validates user input to ensure it is a non-empty string.
     * Prompts the user with the given message until a valid non-empty string is
     * entered.
     *
     * @param scanner The Scanner object used to read user input
     * @param prompt  The message prompting the user to enter a string
     * @return The valid non-empty string entered by the user
     */
    private String validateStringInput(Scanner scanner, String prompt) {
        // Set a starter value to use for returning
        String input;
        // Use a while loop to keep prompting till it breaks out the loop
        while (true) {
            // Print out the question for user to respond to
            System.out.print(prompt);
            // If the scanner notices its asking for a String, and it feeds it, then apply
            // it to the variable
            if (scanner.hasNextLine()) {
                // Break out the loop when it matches
                input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    break;
                }
            }
            // If user types something else then Int it will alert the user
            System.out.println("\n==== Sorry, that input is invalid. Please enter a valid non-empty string ===\n");
        }
        // return the user input
        return input;
    }

    /**
     * Validates user input to ensure it is a valid double value.
     * Prompts the user with the given message until a valid double value is
     * entered.
     *
     * @param scanner The Scanner object used to read user input
     * @param prompt  The message prompting the user to enter a double value
     * @return The valid double value entered by the user
     */
    private double validateDoubleInput(Scanner scanner, String prompt) {
        // Set a starter value to use for returning
        double input;
        // Use a while loop to keep prompting till it breaks out the loop
        while (true) {
            // Print out the question for user to respond to
            System.out.print(prompt);
            // If the scanner notices its asking for a Double, and it feeds it, then apply
            // it to the variable
            if (scanner.hasNextDouble()) {
                // Break out the loop when it matches
                input = scanner.nextDouble();
                break;
            } else {
                // If user types something else then Int it will alert the user
                System.out.println("\n==== Sorry, that input is invalid. Please enter a valid numeric value ===\n");
                scanner.next(); // Consume invalid input
            }
        }
        // return the user input
        return input;
    }

}
