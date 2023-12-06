package com.solvd.bankproject.enums;

public enum Currency {
    USD,
    INR,
    EUR;

    static {
        System.out.println("Currency accepted :");
        for (Currency currency : values()) {
            System.out.println(currency.name());
        }
    }
}
