package com.solvd.bankproject.enums;

public enum TransactionStatus {
    PENDING("Pending", false),
    COMPLETED("Completed", true),
    FAILED("Failed", false);

    private String statusDescription;
    private boolean successfulTransaction;

    TransactionStatus(String statusDescription, boolean successfulTransaction) {
        this.statusDescription = statusDescription;
        this.successfulTransaction = successfulTransaction;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public boolean isSuccessfulTransaction() {
        return successfulTransaction;
    }

    public String transactionStatusInfo() {
        if (isSuccessfulTransaction()) {
            return "Transaction is " + statusDescription;
        } else {
            return "Transaction " + statusDescription;
        }
    }
}
