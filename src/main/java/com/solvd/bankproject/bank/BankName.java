package com.solvd.bankproject.bank;

public class BankName {
    private String
            bankName;

    public BankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public final void WelcomeMessage() {
        System.out.println("Welcome to Chase bank");
    }
}
