package com.solvd.bankproject.bank;

import com.solvd.bankproject.Location;
import com.solvd.bankproject.person.Customer;
import com.solvd.bankproject.person.Employee;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private ArrayList<BankName> bankname;
    ;
    private List<Customer> customer;

    private ArrayList<Location> location;

    private List<Employee> employee;


    public Bank(ArrayList<BankName> bankname, List<Customer> customer, ArrayList<Location> location, List<Employee> employee) {
        this.bankname = bankname;
        this.customer = customer;
        this.location = location;
        this.employee = employee;
    }

    public ArrayList<BankName> getBankname() {
        return bankname;
    }

    public void setBankname(ArrayList<BankName> bankname) {
        this.bankname = bankname;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public ArrayList<Location> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<Location> location) {
        this.location = location;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}

