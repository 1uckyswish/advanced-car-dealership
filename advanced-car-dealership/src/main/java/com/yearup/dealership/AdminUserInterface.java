package com.yearup.dealership;

import java.util.List;

public class AdminUserInterface {
    //Holds an Object of type ContractDataManager
    private ContractDataManager contractDataManager;

    //Constructor for making a new admin to get all the contracts within the CSV
    public AdminUserInterface(ContractDataManager contractDataManager){
        this.contractDataManager = contractDataManager;
    }

    /**
     * Displays all contracts stored in the contract list.
     */
    public void viewAllContracts() {
        System.out.println("\nViewing all contracts:");
        List<String> allContracts = contractDataManager.getAllContracts();
        for (String contract : allContracts) {
            System.out.println(contract);
        }
        System.out.println();
    }

    /**
     * Displays all sale contracts stored in the contract list.
     */
    public void viewSaleContracts() {
        System.out.println("\nViewing sale contracts:");
        List<String> saleContracts = contractDataManager.getSaleContracts();
        for (String contract : saleContracts) {
            System.out.println(contract);
        }
        System.out.println();
    }


    /**
     * Displays all lease contracts stored in the contract list.
     */
    public void viewLeaseContracts() {
        System.out.println("\nViewing lease contracts:");
        List<String> leaseContracts = contractDataManager.getLeaseContracts();
        for (String contract : leaseContracts) {
            System.out.println(contract);
        }
        System.out.println();
    }

    /**
     * Displays options for viewing contracts.
     */
    public void display(){
        System.out.println("What contracts do you want to view?");
        System.out.println("1. All contracts");
        System.out.println("2. Sale contracts");
        System.out.println("3. Lease contracts");
        System.out.print("Enter your choice: ");
    }


}