package com.yearup.dealership;

public class SalesContract extends Contract {
    // Additional fields for SalesContract
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financeOption;

    // Constructor
    public SalesContract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold,
                         boolean financeOption) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = vehicleSold.getPrice() * 0.05; // Sales Tax Amount (5%)
        this.recordingFee = 100; // Recording Fee ($100)
        this.processingFee = (vehicleSold.getPrice() < 10000) ? 295 : 495; // Processing fee
        this.financeOption = financeOption;
    }

    // Getters for additional fields
    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    // Overrides for getTotalPrice() and getMonthlyPayment()
    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (financeOption) {
            double totalPrice = getTotalPrice();
            double interestRate = (totalPrice >= 10000) ? 0.0425 : 0.0525;
            int loanTerm = (totalPrice >= 10000) ? 48 : 24;
            // P = (T × r) / (1 - (1 + r)^-n)
            return (totalPrice * interestRate) / (1 - Math.pow(1 + interestRate, -loanTerm));
        } else {
            return 0;
        }
    }
}
