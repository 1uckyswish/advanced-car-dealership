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
            BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.csv", true));
            DecimalFormat df = new DecimalFormat("0.00"); // Pattern for two decimal places

            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                writer.write("\nSALE|" + salesContract.getContractDate() + "|" +
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
                        df.format(salesContract.getMonthlyPayment()) + "\n");
                writer.flush();
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                writer.write("\nLEASE|" + leaseContract.getContractDate() + "|" +
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

    public List<String> getAllContracts(){
        List<String> contracts = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("contracts.csv"));
            String line;
            while((line = reader.readLine()) != null){
                contracts.add(line);
            }
            reader.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return contracts;
    }

    public List<String> getSaleContracts(){
        List<String> contracts = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("contracts.csv"));
            String line;
            while((line = reader.readLine()) != null){
                String[] fields = line.split(Pattern.quote("|"));
                if(fields[0].equalsIgnoreCase("SALE")){
                    contracts.add(line);
                }
            }
            reader.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return contracts;
    }

    public List<String> getLeaseContracts(){
        List<String> contracts = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("contracts.csv"));
            String line;
            while((line = reader.readLine()) != null){
                String[] fields = line.split(Pattern.quote("|"));
                if(fields[0].equalsIgnoreCase("LEASE")){
                    contracts.add(line);
                }
            }
            reader.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return contracts;
    }
}
