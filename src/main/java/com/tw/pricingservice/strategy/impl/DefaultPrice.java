package com.tw.pricingservice.strategy.impl;

import com.tw.pricingservice.model.ItemQuantityPrice;
import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.strategy.PricingStrategy;

import java.math.BigDecimal;

public class DefaultPrice implements PricingStrategy {
    public PricingResponse getPricing(String item, BigDecimal quantity, ItemQuantityPrice itemDetails){
        PricingResponse response = new PricingResponse(item);
        response.setOfferApplied("No offers applied");
        response.setItem(item);
        response.setTotalQuantity(quantity);
        response.setTotalPrice(quantity.multiply(itemDetails.getPrice()));
        return response;
    }
}
