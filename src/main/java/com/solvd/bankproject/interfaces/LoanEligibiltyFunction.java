package com.solvd.bankproject.interfaces;

public interface LoanEligibiltyFunction<T> {
    boolean checkLoanEligibility(T income, T creditScore);
}
