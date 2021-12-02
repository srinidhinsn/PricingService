package com.tw.pricingservice.strategy.impl;

import com.tw.pricingservice.model.ItemQuantityPrice;
import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.strategy.PricingStrategy;

import java.math.BigDecimal;

public class BuyTwoGetOne implements PricingStrategy {
    private int offerOnQuantity = 2;
    public PricingResponse getPricing(String item, BigDecimal quantity, ItemQuantityPrice itemDetails){
        PricingResponse response = new PricingResponse(item);
        int intQuantity = quantity.intValue();
        if (intQuantity >= offerOnQuantity){
            Integer eligableQuantity = intQuantity / offerOnQuantity ;
            response.setTotalPrice(quantity.multiply(itemDetails.getPrice()));
            response.setTotalQuantity(quantity.add(new BigDecimal(eligableQuantity)));
            response.setOfferApplied("Buy two get one free");
        } else {
            response.setTotalQuantity(quantity);
            response.setTotalPrice(quantity.multiply(itemDetails.getPrice()));
        }
        return response;
    }
}
