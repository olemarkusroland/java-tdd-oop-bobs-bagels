package com.booleanuk.core;

import com.booleanuk.core.models.Basket;
import com.booleanuk.core.models.Discount;
import com.booleanuk.core.models.Product;

import java.util.ArrayList;

public class DiscountManager {
    private final Basket _basket;
    private final ArrayList<Discount> _discounts;

    public DiscountManager(Basket basket) {
        _basket = basket;
        _discounts = DiscountCatalog.discounts();
    }

    public void updateDiscounts() {
        // Remove existing discounts
        _basket.products.values().removeIf(product -> "DISC".equals(product.SKU));

        // Add new discounts
        for (Discount discount : _discounts) {
            addDiscount(discount);
        }
    }

    private void addDiscount(Discount discount) {
        long numApplicants = _basket.products.values().stream()
                .filter(p -> discount.SKU.equals(p.SKU))
                .count();

        long numDiscounts = numApplicants / discount.Quantity;
        if (numDiscounts < 1)
            return;

        Double productPrice = _basket.products.values().stream()
                .filter(p -> discount.SKU.equals(p.SKU))
                .findFirst()
                .map(Product::getPrice)
                .orElse(0.0);

        double discountSize = numDiscounts * (productPrice * discount.Quantity - discount.Price);

        _basket.addDiscount(discount.SKU, discountSize);
    }
}
