package com.booleanuk.core.models;

import java.util.ArrayList;

public class Bagel extends Product {
    public ArrayList<Filling> Fillings;

    public Bagel(String SKU, String Name, String Variant, double Price) {
        super(SKU, Name, Variant, Price);
        Fillings = new ArrayList<>();
    }

    @Override
    public double getPrice() {
        double totalPrice = super.getPrice();

        for (Filling filling : Fillings) {
            totalPrice += filling.getPrice();
        }

        return totalPrice;
    }
}
