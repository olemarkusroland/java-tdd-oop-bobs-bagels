package com.booleanuk.core.models;

public class Discount {
    public String SKU;
    public int Quantity;
    public double Price;

    public Discount(String sku, int quantity, double price) {
        SKU = sku;
        Quantity = quantity;
        Price = price;
    }
}
