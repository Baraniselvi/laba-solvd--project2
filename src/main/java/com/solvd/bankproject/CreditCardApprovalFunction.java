package com.solvd.bankproject;

public interface CreditCardApprovalFunction<T> {
    boolean approveCredit(T creditScore);
}
