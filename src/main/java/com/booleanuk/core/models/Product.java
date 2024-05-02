package com.booleanuk.core.models;

public abstract class Product {
    public String SKU;
    public String Name;
    public String Variant;
    protected double Price;

    public Product(String SKU, String Name, String Variant, double Price) {
        this.SKU = SKU;
        this.Name = Name;
        this.Variant = Variant;
        this.Price = Price;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
}
