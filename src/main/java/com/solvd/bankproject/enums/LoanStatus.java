package com.solvd.bankproject.enums;

public enum LoanStatus {
    APPROVED("Approved", true),
    PENDING("Pending approval", false),
    REJECTED("Rejected", false);

    private final String statusDescription;
    private final boolean activeStatus;


    LoanStatus(String statusDescription, boolean activeStatus) {
        this.statusDescription = statusDescription;
        this.activeStatus = activeStatus;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public String loanStatusInfo() {
        if (isActiveStatus()) {
            return " Loan is currently " + statusDescription;
        } else {
            return "Laon is " + statusDescription;

        }
    }
}


