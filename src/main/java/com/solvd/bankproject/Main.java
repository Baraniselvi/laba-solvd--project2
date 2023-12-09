package com.solvd.bankproject;

import com.solvd.bankproject.accounts.Account;
import com.solvd.bankproject.accounts.CheckingAccount;
import com.solvd.bankproject.accounts.SavingsAccount;
import com.solvd.bankproject.bank.BankName;
import com.solvd.bankproject.bank.BankOperations;
import com.solvd.bankproject.enums.CardType;
import com.solvd.bankproject.enums.Currency;
import com.solvd.bankproject.enums.LoanStatus;
import com.solvd.bankproject.enums.TransactionStatus;
import com.solvd.bankproject.exceptions.AccountNotFoundException;
import com.solvd.bankproject.exceptions.InsufficientFundException;
import com.solvd.bankproject.exceptions.InvalidAmountException;
import com.solvd.bankproject.exceptions.NegativeAmountException;
import com.solvd.bankproject.interfaces.CreditCardApprovalFunction;
import com.solvd.bankproject.interfaces.LoanEligibiltyFunction;
import com.solvd.bankproject.interfaces.TransactionApprovalFunction;
import com.solvd.bankproject.loan.PersonalLoan;
import com.solvd.bankproject.person.Customer;
import com.solvd.bankproject.person.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDate;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {


        logger.info("**********Bank Project************ ");

        System.out.println();
        BankName bankNames1 = new BankName("Chase");

        bankNames1.WelcomeMessage();


        System.out.println();
        List<Customer> customers = new ArrayList<Customer>();
        Customer customer1 = new Customer("sam", "  victor", new ArrayList<Account>(), new ArrayList<Transaction>());
        customers.add(customer1);

        customer1.getFullNAME();
        customer1.getAccounts();
        customer1.getTransactions();
        logger.info("Customer info :" + customer1.getFullNAME() + customer1.getAccounts() + customer1.getTransactions());


        System.out.println();
        Account account = new Account("34444", 4555555, 444444);
        account.setAccountID("34444");

        logger.info(" Validate AccoountID :");
        account.accountIDValidation();


        System.out.println();
        List<Employee> employee = new ArrayList<Employee>();
        Employee employee1 = new Employee("John", " Mathew ", new Location("Neenah", "USA", "34444444443"), "Process Executive", 567777);
        employee.add(employee1);
        employee1.setLocation(new Location("Neenah", "USA", "34444444443"));
        logger.info("Employee Fullname :" + employee1.getFullNAME());
        logger.info("Employee Position : " + employee1.getPosition());
        System.out.println("  Employee email: " + employee1.generateEmailAddress("John", "Mathew"));


        ArrayList<Location> locations = new ArrayList<Location>();
        Location location = new Location(" Mckinney ", " Texas ", " 345559999 ");
        System.out.println("Bank Location info :" + location.getLocationInfo() + location.getPhonenumber());


        Transaction transaction = new Transaction(233344);
        transaction.checkbalance();
        System.out.println("Balance" + transaction.getBalance());


        CheckingAccount checkingAccount = new CheckingAccount("12333", 34444, 500);
        checkingAccount.getOverdraftlimit();

        try {
            SavingsAccount savingsAccount1 = new SavingsAccount("133444", 50000, 400);
            savingsAccount1.withdraw(800000);
            {
                throw new InsufficientFundException("Insufficient fund");
            }


        } catch (InsufficientFundException e) {
            logger.warn("Error : " + e.getMessage());
        }

        try {
            SavingsAccount savingsAccount2 = new SavingsAccount("133444", 50000, 400);
            savingsAccount2.deposit(-200);
            {
                throw new NegativeAmountException("Negative Amount");
            }


        } catch (NegativeAmountException e) {
            logger.warn("Error :" + e.getMessage());
        }
        try {
            SavingsAccount savingsAccount3 = new SavingsAccount("-10032", 50000, 400);
            savingsAccount3.getAccountID();
            {
                throw new AccountNotFoundException("Invalid account number");
            }

        } catch (AccountNotFoundException e) {
            logger.warn("Error :" + e.getMessage());
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

        logger.info("Currency Accepted :" + Currency.EUR);
        logger.info("Currency Accepted :" + Currency.USD);
        logger.info("Currency Accepted :" + Currency.INR);


        BankOperations.depositOperation.accept(3000.6);
        BankOperations.generateTransactionID.get();
        logger.info("Transaction status :" + TransactionStatus.COMPLETED + LocalDate.now() + LocalTime.now());

        BankOperations.calucalateInterest.apply(5.7);
        BankOperations.withDrawalOperation.accept(500.0);
        BankOperations.generateTransactionID.get();
        BankOperations.getCurrentBalance.get();
        logger.info("Transaction status :" + TransactionStatus.PENDING + LocalDate.now() + LocalTime.now());


        CreditCardApprovalFunction<Double> CreditApproval = creditScore ->
                creditScore >= 700;

        double customerCreditsCORE = 750;
        System.out.println("Credit Approval :" + CreditApproval.approveCredit(customerCreditsCORE));


        LoanEligibiltyFunction<Double> loanEligibilty = (income, CreditScore) ->
                income > 50000 && CreditScore >= 650;

        double customerIncome = 60000;
        double customerCreditScore = 200;
        System.out.println("Loan Eligibility :" + loanEligibilty.checkLoanEligibility(customerIncome, customerCreditScore));
        System.out.println(LoanStatus.REJECTED.loanStatusInfo());


        TransactionApprovalFunction<Double> transactionApproval = amount -> amount <= 10000;
        double transactionAmount = 300000;
        System.out.println("Transaction Card Type :" + CardType.CREDIT);
        System.out.println("Transaction Approval :" + transactionApproval.approveTransaction(transactionAmount));


        List<Account> accountList = new ArrayList<>();
        List<Account> highBalanceCustomer = (List<Account>) accountList.stream().filter(account1 -> account1.getBalance() > 1000).collect(Collectors.toList());
        accountList.forEach(account1 -> System.out.println("Account Balance greater than 100" + account1.getAccountID()));

        List<Double> uniqueBalance = accountList.stream().map(Account::getBalance).distinct().collect(Collectors.toList());
        System.out.println(uniqueBalance);
        accountList.forEach(account1 -> System.out.println("Account details " + account1.getBalance()));

        boolean accountBalanceover100000 = accountList.stream().anyMatch(account1 -> account1.getBalance() > 100000);
        System.out.println(accountBalanceover100000);
        accountList.forEach(account1 -> System.out.println("Customer with balance over 100000" + account1.getBalance()));

        double numberofAccounts = accountList.stream().count();
        System.out.println(numberofAccounts);
        accountList.forEach(account1 -> System.out.println("Number of accounts"+ account1.getAccountID()));



        String filepath = "src/main/resources/addaccount.txt";
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter Customer Name");
        String customerName = scanner.nextLine();
        logger.info("Enter account number");
        String accountID = scanner.nextLine();
        System.out.println("Enter initial balance");
        double initialBalance = scanner.nextDouble();

        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.write(customerName + ", " + initialBalance + "\n");
            logger.info("Account added succesfully");
        } catch (IOException e) {
            System.out.println("Error in adding account to the file");
            e.printStackTrace();
        }
        ;


    }


}























