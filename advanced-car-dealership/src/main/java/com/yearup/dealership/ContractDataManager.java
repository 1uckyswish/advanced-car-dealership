package com.yearup.dealership;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ContractDataManager {

    public static void saveContract(Contract contract) {
        try {
            // Instantiate a reader with the CSV we read from
            BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.csv", true));
            DecimalFormat df = new DecimalFormat("0.00"); // Pattern for two decimal places
            //Check if the contract passed is of Sales
            if (contract instanceof SalesContract) {
                //Downcast the object to get all methods from SalesContract
                SalesContract salesContract = (SalesContract) contract;
                //Write to CSV to hold all data from the contract
                writer.write("SALE|" + salesContract.getContractDate() + "|" +
                        salesContract.getCustomerName() + "|" +
                        salesContract.getCustomerEmail() + "|" +
                        salesContract.getVehicleSold().getVin() + "|" +
                        salesContract.getVehicleSold().getYear() + "|" +
                        salesContract.getVehicleSold().getMake() + "|" +
                        salesContract.getVehicleSold().getModel() + "|" +
                        salesContract.getVehicleSold().getVehicleType() + "|" +
                        salesContract.getVehicleSold().getColor() + "|" +
                        salesContract.getVehicleSold().getOdometer() + "|" +
                        df.format(salesContract.getVehicleSold().getPrice()) + "|" +
                        df.format(salesContract.getTotalPrice()) + "|" +
                        df.format(salesContract.getSalesTaxAmount()) + "|" +
                        df.format(salesContract.getRecordingFee()) + "|" +
                        df.format(salesContract.getProcessingFee()) + "|" +
                        (salesContract.isFinanceOption() ? "YES" : "NO") + "|" +
                        df.format(salesContract.getMonthlyPayment()));
                writer.newLine();
                writer.flush();
                //Check if the contract passed is of lease
            } else if (contract instanceof LeaseContract) {
                //Downcast the object to get all methods from LeaseContract
                LeaseContract leaseContract = (LeaseContract) contract;
                //Write to CSV to hold all data from the contract
                writer.write("LEASE|" + leaseContract.getContractDate() + "|" +
                        leaseContract.getCustomerName() + "|" +
                        leaseContract.getCustomerEmail() + "|" +
                        leaseContract.getVehicleSold().getVin() + "|" +
                        leaseContract.getVehicleSold().getYear() + "|" +
                        leaseContract.getVehicleSold().getMake() + "|" +
                        leaseContract.getVehicleSold().getModel() + "|" +
                        leaseContract.getVehicleSold().getVehicleType() + "|" +
                        leaseContract.getVehicleSold().getColor() + "|" +
                        leaseContract.getVehicleSold().getOdometer() + "|" +
                        df.format(leaseContract.getVehicleSold().getPrice()) + "|" +
                        df.format(leaseContract.getTotalPrice()) + "|" +
                        df.format(leaseContract.getExpectedEndingValue()) + "|" +
                        df.format(leaseContract.getLeaseFee()) + "|" +
                        df.format(leaseContract.getMonthlyPayment()));
                writer.flush();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for any exception
        }
    }

    /**
     * Retrieves all contracts from the contracts file and returns them as a list of strings.
     * @return A list containing all contracts.
     */
    public List<String> getAllContracts() {
        List<String> contracts = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("contracts.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                contracts.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return contracts;
    }

    /**
     * Retrieves all sale contracts from the contracts file and returns them as a list of strings.
     * @return A list containing all sale contracts.
     */
    public List<String> getSaleContracts() {
        List<String> contracts = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("contracts.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(Pattern.quote("|"));
                if (fields[0].equalsIgnoreCase("SALE")) {
                    contracts.add(line);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return contracts;
    }

    /**
     * Retrieves all lease contracts from the contracts file and returns them as a list of strings.
     * @return A list containing all lease contracts.
     */
    public List<String> getLeaseContracts() {
        List<String> contracts = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("contracts.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(Pattern.quote("|"));
                if (fields[0].equalsIgnoreCase("LEASE")) {
                    contracts.add(line);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return contracts;
    }

}
