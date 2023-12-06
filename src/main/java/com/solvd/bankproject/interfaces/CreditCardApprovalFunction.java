package com.solvd.bankproject.interfaces;

public interface CreditCardApprovalFunction<T> {
    boolean approveCredit(T creditScore);
}
