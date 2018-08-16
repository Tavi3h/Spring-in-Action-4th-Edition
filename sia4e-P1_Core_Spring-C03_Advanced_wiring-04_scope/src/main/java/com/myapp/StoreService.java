package com.myapp;

public class StoreService {

    private ShoppingCart shoppingCart;

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public String toString() {
        return "StoreService " + super.toString() + " with " + shoppingCart.toString();
    }

}
