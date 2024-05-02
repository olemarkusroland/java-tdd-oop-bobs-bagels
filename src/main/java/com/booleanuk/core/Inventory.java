package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Coffee;
import com.booleanuk.core.models.Filling;
import com.booleanuk.core.models.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> Items;

    public Inventory() {
        Items = new HashMap<>();
        initializeProducts();
    }

    private void initializeProducts() {
        Items.put("BGLO", new Bagel("BGLO", "Bagel", "Onion", 0.49));
        Items.put("BGLP", new Bagel("BGLP", "Bagel", "Plain", 0.39));
        Items.put("BGLE", new Bagel("BGLE", "Bagel", "Everything", 0.49));
        Items.put("BGLS", new Bagel("BGLS", "Bagel", "Sesame", 0.49));
        Items.put("COFB", new Coffee("COFB", "Coffee", "Black", 0.99));
        Items.put("COFW", new Coffee("COFW", "Coffee", "White", 1.19));
        Items.put("COFC", new Coffee("COFC", "Coffee", "Capuccino", 1.29));
        Items.put("COFL", new Coffee("COFL", "Coffee", "Latte", 1.29));
        Items.put("FILB", new Filling("FILB", "Filling", "Bacon", 0.12));
        Items.put("FILE", new Filling("FILE", "Filling", "Egg", 0.12));
        Items.put("FILC", new Filling("FILC", "Filling", "Cheese", 0.12));
        Items.put("FILX", new Filling("FILX", "Filling", "Cream Cheese", 0.12));
        Items.put("FILS", new Filling("FILS", "Filling", "Smoked Salmon", 0.12));
        Items.put("FILH", new Filling("FILH", "Filling", "Ham", 0.12));
    }

    public Product get(String SKU) {
        return Items.get(SKU);
    }

    public Collection<Product> get() {
        return Items.values();
    }
}
