package com.booleanuk.core;

import com.booleanuk.core.models.Discount;

import java.util.ArrayList;

public class DiscountCatalog {
    public static ArrayList<Discount> discounts() {
        ArrayList<Discount> discounts = new ArrayList<>();

        // Add discounts to the list
        discounts.add(new Discount("BGLO", 6, 2.49));
        discounts.add(new Discount("BGLP", 12, 3.99));
        discounts.add(new Discount("BGLE", 6, 2.49));

        return discounts;
    }
}

