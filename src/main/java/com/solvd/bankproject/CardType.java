package com.solvd.bankproject;

public enum CardType {

    DEBIT("Debit card", true, 5000.0),
    CREDIT("Credit card", true, 50000.0);

    private String displayName;
    private boolean hasCredit;
    private double CreditLimit;

    CardType(String displayName, boolean hasCredit, double creditLimit) {
        this.displayName = displayName;
        this.hasCredit = hasCredit;
        CreditLimit = creditLimit;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isHasCredit() {
        return hasCredit;
    }

    public double getCreditLimit() {
        return CreditLimit;
    }

    public String availableCreditInof() {
        if (hasCredit) {
            return "Credit Limit :" + getCreditLimit();
        } else {
            return "No Credit Limit";
        }

    }
}
