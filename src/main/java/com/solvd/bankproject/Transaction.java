package com.solvd.bankproject;

import com.solvd.bankproject.bank.BankOperations;

public class Transaction {
    private double balance;

    public Transaction(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    void checkbalance() {
        System.out.println("Current Balance " + getBalance());
    }
}
