package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Basket;
import com.booleanuk.core.models.Filling;
import com.booleanuk.core.models.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class BasketTest {
    Basket basket = new Basket();

    @Test
    public void AddBagels() {
        // Add products to the basket
        basket.addProduct("BGLO");
        basket.addProduct("BGLP");

        // Check that products are in the basket
        Assertions.assertFalse(basket.products.isEmpty(), "Basket should not be empty.");
        Assertions.assertEquals(2, basket.products.size(), "Basket should contain 2 products.");

        // Check the existence of specific products
        Optional<Product> firstProduct = Optional.ofNullable(basket.products.get(1)); // Access by ID

        Assertions.assertTrue(firstProduct.isPresent(), "First product should be present.");
        Assertions.assertEquals("BGLO", firstProduct.get().SKU, "First product should be a Bagel with SKU BGLO.");

        // Check the total price
        Assertions.assertEquals(0.88, basket.Price(), 0.01, "Basket price should match the sum of product prices.");
    }

    @Test
    public void AddFilling() {
        // Add a bagel to the basket
        basket.addProduct("BGLO");

        // Get the bagel from the basket
        Optional<Product> bagelProduct = Optional.ofNullable(basket.products.get(1));

        Assertions.assertTrue(bagelProduct.isPresent(), "Bagel should be present in the basket.");
        Assertions.assertInstanceOf(Bagel.class, bagelProduct.get(), "Product should be a Bagel.");

        Bagel bagel = (Bagel) bagelProduct.get();

        // Add a filling to the bagel
        basket.addFillingProduct(1, "FILB"); // Add a filling with SKU "FILB" (Bacon)

        // Check if the bagel has the filling
        Assertions.assertFalse(bagel.Fillings.isEmpty(), "Bagel should have at least one filling.");
        Assertions.assertEquals(1, bagel.Fillings.size(), "Bagel should contain 1 filling.");

        Filling filling = bagel.Fillings.get(0);
        Assertions.assertEquals("FILB", filling.SKU, "The filling should have SKU FILB.");
    }

    @Test
    public void RemoveFilling() {
        // Add a bagel to the basket
        basket.addProduct("BGLO");

        // Retrieve the bagel from the basket
        Optional<Product> bagelProduct = Optional.ofNullable(basket.products.get(1));

        Assertions.assertTrue(bagelProduct.isPresent(), "Bagel should be present in the basket.");
        Assertions.assertInstanceOf(Bagel.class, bagelProduct.get(), "Product should be a Bagel.");

        Bagel bagel = (Bagel) bagelProduct.get();

        // Add a filling to the bagel
        basket.addFillingProduct(1, "FILB"); // Add a filling with SKU "FILB" (Bacon)
        Assertions.assertEquals(1, bagel.Fillings.size(), "Bagel should contain 1 filling.");

        // Remove the filling from the bagel
        basket.removeFillingProduct(1, 0); // Remove the first filling

        // Check if the filling was removed
        Assertions.assertTrue(bagel.Fillings.isEmpty(), "Bagel should have no fillings.");
    }

    @Test
    public void Capacity() {
        // Create a new basket with a capacity of 10
        Basket basket = new Basket();

        // Add 10 products to the basket
        for (int i = 0; i < 10; i++) {
            basket.addProduct("BGLO"); // Adding a bagel to the basket
        }

        // Check that the basket contains 10 products
        Assertions.assertEquals(10, basket.products.size(), "Basket should contain 10 products.");

        // Try to add one more product
        basket.addProduct("BGLP"); // Attempt to add an additional product

        // Check that the basket still contains 10 products
        Assertions.assertEquals(10, basket.products.size(), "Basket should still contain 10 products, respecting its capacity.");
    }
}
