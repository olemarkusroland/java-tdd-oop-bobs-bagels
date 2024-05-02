package com.booleanuk.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.booleanuk.core.models.Basket;

public class DiscountTests {
    @Test
    public void Onion() {
        Basket basket = new Basket();

        // Add 6 Onion Bagels (BGLO)
        for (int i = 0; i < 6; i++) {
            basket.addProduct("BGLO");
        }

        // Expected price with discount
        double expectedPrice = 2.49;

        // Check the total price
        Assertions.assertEquals(expectedPrice, basket.Price(), 0.01, "Price should reflect 6 Bagels for 2.49 discount.");
    }

    @Test
    public void Plain() {
        Basket basket = new Basket();

        // Add 12 Plain Bagels (BGLP)
        for (int i = 0; i < 12; i++) {
            basket.addProduct("BGLP");
        }

        // Expected price with discount
        double expectedPrice = 3.99;

        // Check the total price
        Assertions.assertEquals(expectedPrice, basket.Price(), 0.01, "Price should reflect 12 Bagels for 3.99 discount.");
    }

    @Test
    public void CoffeeAndBagel() {
        Basket basket = new Basket();

        // Add 1 Black Coffee (COFB) and 1 Bagel (BGLO)
        basket.addProduct("COFB");
        basket.addProduct("BGLO");

        // Expected price with discount
        double expectedPrice = 1.25;

        // Check the total price
        Assertions.assertEquals(expectedPrice, basket.Price(), 0.01, "Price should reflect Coffee & Bagel for 1.25 discount.");
    }
}
