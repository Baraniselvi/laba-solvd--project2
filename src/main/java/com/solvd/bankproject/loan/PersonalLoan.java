package com.solvd.bankproject.loan;

import com.solvd.bankproject.Location;
import com.solvd.bankproject.bank.Bank;
import com.solvd.bankproject.bank.BankName;
import com.solvd.bankproject.person.Customer;
import com.solvd.bankproject.person.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PersonalLoan extends Bank {
    private double balance;

    private double interestrate;

    public PersonalLoan(ArrayList<BankName> bankname, List<Customer> customer, ArrayList<Location> location, List<Employee> employee) {
        super(bankname, customer, location, employee);
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
    }

    public double calculateInterest() {
        double interest = balance * interestrate;
        System.out.println("Interest calculated: " + interest);
        return interest;
    }
}



