package com.booleanuk.core;

import com.booleanuk.core.models.Basket;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();

        for (int i = 0; i < 12; i++) {
            basket.addProduct("BGLP");
        }

        double totalPrice = basket.Price();
        System.out.println(totalPrice);
    }
}
