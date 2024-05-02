package com.booleanuk.core.models;

import com.booleanuk.core.DiscountManager;
import com.booleanuk.core.Inventory;

import java.util.HashMap;

public class Basket {
    public HashMap<Integer, Product> products = new HashMap<>();
    public int capacity = 30;

    private int currentId = 1;

    private final Inventory inventory = new Inventory();
    private final DiscountManager discountManger = new DiscountManager(this);

    public double Price() {
        discountManger.updateDiscounts();

        return products.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void addProduct(String SKU) {
        Product item = inventory.get(SKU);

        if (item == null) {
            System.out.println("SKU " + SKU + " not found");
        }

        if (products.size() >= capacity) {
            System.out.println("Sorry, you have reached the maximum capacity");
            return;
        }

        products.put(currentId, item);
        currentId++;
    }

    public void addDiscount(String sku, double price) {
        Product item = new Product("DISC", "Discount", sku, -price);
        products.put(currentId, item);
        currentId++;
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
