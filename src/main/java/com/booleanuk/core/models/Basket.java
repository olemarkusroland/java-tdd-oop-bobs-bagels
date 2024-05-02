package com.booleanuk.core.models;

import com.booleanuk.core.Inventory;

import java.util.HashMap;

public class Basket {
    public HashMap<Integer, Product> products;
    public int capacity = 10;

    private int currentId;

    private final Inventory inventory = new Inventory();

    public Basket() {
        products = new HashMap<>();
        currentId = 1;
    }

    public double getPrice() {
        double totalPrice = 0;

        for (Product product : products.values()) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public void addProduct(String SKU) {
        Product item = inventory.get(SKU);

        if (products.size() >= capacity) {
            System.out.println("Sorry, you have reached the maximum capacity");
            return;
        }

        if (item != null) {
            // Map the product to the current ID and increment the ID counter
            products.put(currentId, item);
            currentId++; // Increment the ID for the next product
        } else {
            System.out.println("Product not found: " + SKU);
        }
    }

    public void addFillingProduct(int bagelID, String SKU) {
        Product item = inventory.get(SKU);

        if (item instanceof Filling filling) { // Check it's a Filling
            Product product = products.get(bagelID); // Get the bagel by its ID

            if (product instanceof Bagel bagel) { // Check it's a Bagel
                bagel.Fillings.add(filling); // Add the filling to the bagel
            } else {
                System.out.println("Product with ID " + bagelID + " is not a Bagel.");
            }
        } else {
            System.out.println("Filling not found or not a valid Filling.");
        }
    }

    public void removeFillingProduct(int bagelID, int fillingID) {
        Product product = products.get(bagelID);

        if (product instanceof Bagel bagel) {
            if (fillingID >= 0 && fillingID < bagel.Fillings.size()) {
                bagel.Fillings.remove(fillingID);
            } else {
                System.out.println("Filling ID " + fillingID + " is invalid.");
            }
        } else {
            System.out.println("Product with ID " + bagelID + " is not a Bagel.");
        }
    }
}
