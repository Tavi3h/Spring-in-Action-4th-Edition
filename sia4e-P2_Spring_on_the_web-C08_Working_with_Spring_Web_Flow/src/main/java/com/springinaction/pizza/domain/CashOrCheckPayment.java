package com.springinaction.pizza.domain;

public class CashOrCheckPayment extends Payment {
    private static final long serialVersionUID = -4183647451182954162L;

    public CashOrCheckPayment() {
    }

    public String toString() {
        return "CASH or CHECK:  $" + getAmount();
    }
}
