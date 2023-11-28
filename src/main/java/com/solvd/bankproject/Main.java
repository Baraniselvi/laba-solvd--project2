package com.solvd.bankproject;

import com.solvd.bankproject.accounts.Account;
import com.solvd.bankproject.accounts.CheckingAccount;
import com.solvd.bankproject.accounts.SavingsAccount;
import com.solvd.bankproject.bank.Bank;
import com.solvd.bankproject.bank.BankName;
import com.solvd.bankproject.exceptions.AccountNotFoundException;
import com.solvd.bankproject.exceptions.InsufficientFundException;
import com.solvd.bankproject.exceptions.InvalidAmountException;
import com.solvd.bankproject.exceptions.NegativeAmountException;
import com.solvd.bankproject.loan.PersonalLoan;
import com.solvd.bankproject.person.Customer;
import com.solvd.bankproject.person.Employee;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {




        logger.info("Bank Project");

        Account account = new Account("34444", 4555555, 444444);
        account.getAccountID();
        account.getBalance();
        account.accountIDValidation();

        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer1 = new Customer("sam", "  victor", new ArrayList<>(), new ArrayList<>());
        customer1.getAccounts();
        customer1.getTransactions();
        customer1.getFullNAME();
        System.out.println("Customer info :" + customer1.getFullNAME() + customer1.getAccounts() + customer1.getTransactions());


        ArrayList<BankName> bankNames = new ArrayList<BankName>();
        BankName bankName1 = new BankName("Chase Bank");
        bankNames.add(bankName1);


        ArrayList<Employee> employee = new ArrayList<Employee>();
        Employee employee1 = new Employee("John", " Mathew ", new Location("Neenah", "USA", "34444444443"), "Process Executive", 567777);
        employee.add(employee1);
        employee1.setLocation(new Location("Neenah", "USA", "34444444443"));
        System.out.println("Employee Fullname :" + employee1.getFullNAME());
        System.out.println("Employee Position : " + employee1.getPosition());
        System.out.println(employee1.generateEmailAddress("Hailey", "Natahn"));


        ArrayList<Location> locations = new ArrayList<Location>();
        Location location = new Location("Chennai", " India ", " 345559999 ");
        System.out.println("Bank Location info :" + location.getLocationInfo() + location.getPhonenumber());


        Transaction transaction = new Transaction(233344);
        transaction.checkbalance();
        System.out.println("Balance" + transaction.getBalance());


        CheckingAccount checkingAccount = new CheckingAccount("12333", 34444, 500);
        checkingAccount.getOverdraftlimit();


        PersonalLoan personalLoan = new PersonalLoan("Chase", 7980, 1.7);
        personalLoan.calculateInterest();


        try {
            SavingsAccount savingsAccount1 = new SavingsAccount("133444", 50000, 400);
            savingsAccount1.withdraw(800000);
            {
                throw new InsufficientFundException("Insufficient fund");
            }


        } catch (InsufficientFundException e) {
            logger.warn("Error " + e.getMessage());
        }

        try {
            SavingsAccount savingsAccount2 = new SavingsAccount("133444", 50000, 400);
            savingsAccount2.deposit(-200);
            {
                throw new NegativeAmountException("Negative Amount");
            }


        } catch (NegativeAmountException e) {
            logger.warn("Error " + e.getMessage());
        }
        try {
            SavingsAccount savingsAccount3 = new SavingsAccount("-10032", 50000, 400);
            savingsAccount3.getAccountID();
            {
                throw new AccountNotFoundException("Invalid account number");
            }

        } catch (AccountNotFoundException e) {
            logger.warn("Error " + e.getMessage());
        }
        try {
            SavingsAccount savingsAccount4 = new SavingsAccount("-10032", 50000, 400);
            savingsAccount4.withdraw(0);
            {
                throw new InvalidAmountException("Invalid Amount");
            }

        } catch (InvalidAmountException e) {
            logger.warn("Error " + e.getMessage());
        }


    }
}







