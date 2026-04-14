package com.santana.java.back.end.shopping_api.model;

import jakarta.persistence.Embeddable;


@Embeddable
public class Item {
    private String productIdentifier;
    private float price;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public float getPrice() {
        return price;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
