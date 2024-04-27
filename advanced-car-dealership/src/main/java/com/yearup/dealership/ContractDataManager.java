package com.yearup.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;

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
}
