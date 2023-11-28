package com.solvd.bankproject.exceptions;

public class InsufficientFundException extends Exception{
    public InsufficientFundException(String message) {
        super(message);
    }
}
