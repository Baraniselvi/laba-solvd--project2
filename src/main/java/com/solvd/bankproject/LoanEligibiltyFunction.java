package com.solvd.bankproject;

public interface LoanEligibiltyFunction<T> {
    boolean checkLoanEligibility(T income, T creditScore);
}
