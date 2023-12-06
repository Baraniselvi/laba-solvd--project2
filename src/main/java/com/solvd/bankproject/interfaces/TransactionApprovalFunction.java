package com.solvd.bankproject.interfaces;

public interface TransactionApprovalFunction<T> {
    boolean approveTransaction(T transactionAmount);
}
