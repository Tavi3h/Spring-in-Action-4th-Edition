package com.myapp;

public class ShoppingCartImpl implements ShoppingCart {

    @Override
    public void show() {
        System.out.println("Shop with " + this);
    }
    
}
