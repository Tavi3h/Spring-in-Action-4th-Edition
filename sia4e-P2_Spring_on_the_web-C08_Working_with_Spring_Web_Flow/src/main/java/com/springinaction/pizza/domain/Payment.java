package com.springinaction.pizza.domain;

import java.io.Serializable;

public abstract class Payment implements Serializable {

    private static final long serialVersionUID = 8615027806425126059L;
    
    private float amount;

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}
