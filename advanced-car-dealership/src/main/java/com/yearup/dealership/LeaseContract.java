package com.yearup.dealership;

public class LeaseContract extends Contract {
    // Additional fields for LeaseContract
    private double expectedEndingValue;
    private double leaseFee;

    // Constructor
    public LeaseContract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * 0.5; // Expected Ending Value (50% of the original price)
        this.leaseFee = vehicleSold.getPrice() * 0.07; // Lease Fee (7% of the original price)
    }

    // Getters for additional fields
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    // Overrides for getTotalPrice() and getMonthlyPayment()
    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        double interestRate = 0.04; // 4.0%
        int loanTerm = 36; // 36 months
        //P = (T × r) / (1 - (1 + r)^-n)
        return (totalPrice * interestRate) / (1 - Math.pow(1 + interestRate, -loanTerm));
    }
}