package com.tw.pricingservice.model;

import java.math.BigDecimal;

public class PricingResponse {
    private String offerApplied="No offers";
    private BigDecimal totalQuantity;
    private String item;
    private BigDecimal totalPrice;

    public String getOfferApplied() {
        return offerApplied;
    }

    public void setOfferApplied(String offerApplied) {
        this.offerApplied = offerApplied;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(BigDecimal totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PricingResponse(String item) {
        this.item = item;
    }

    public PricingResponse() {
    }
}
