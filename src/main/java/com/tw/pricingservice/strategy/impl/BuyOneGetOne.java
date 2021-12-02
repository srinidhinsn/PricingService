package com.tw.pricingservice.strategy.impl;

import com.tw.pricingservice.model.ItemQuantityPrice;
import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.strategy.PricingStrategy;

import java.math.BigDecimal;

public class BuyOneGetOne implements PricingStrategy {
    public PricingResponse getPricing(String item, BigDecimal quantity, ItemQuantityPrice itemDetails){
        PricingResponse response = new PricingResponse();
        response.setItem(item);
        response.setTotalQuantity(quantity.multiply(new BigDecimal(2)));
        response.setTotalPrice(itemDetails.getPrice().multiply(quantity));
        response.setOfferApplied("Buy one get one offer applied");
        return response;
    }
}
