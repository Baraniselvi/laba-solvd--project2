package com.solvd.bankproject.bank;

import javax.xml.transform.Source;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface BankOperations {

    Consumer<Double> depositOperation = amount -> {
        System.out.println("Deposit :" + amount);
    };
    Consumer<Double> withDrawalOperation = amount -> {
        System.out.println("Withdrawal :" + amount);
    };
    Predicate<Double> sufficientBalance = balance -> balance >= 100.0;

    Predicate<Double> lowBalance = balance -> balance <= 100.0;
    Supplier<Double> getCurrentBalance = () -> 5000.0;

    public default Predicate<Double> getLowBalance() {
        return lowBalance;
    }

    Supplier<String> generateTransactionID = () -> "TRN" + System.currentTimeMillis();

    Function<Double, Double> calucalateInterest = balance -> balance * 0.06;

    double initialBalance = getCurrentBalance.get();


    public default Consumer<Double> getDepositOperation() {
        return depositOperation;

    }

    public default Consumer<Double> getWithDrawalOperation() {
        return withDrawalOperation;
    }
}
