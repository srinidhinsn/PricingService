package com.tw.pricingservice.model;

import java.math.BigDecimal;

public class ItemQuantityPrice {
    private String item;
    private BigDecimal quantity;
    private BigDecimal price;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ItemQuantityPrice(String item, BigDecimal quantity, BigDecimal price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }
}
