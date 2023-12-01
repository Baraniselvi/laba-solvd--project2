package com.solvd.bankproject;

public interface TransactionApprovalFunction<T> {
    boolean approveTransaction(T transactionAmount);
}
