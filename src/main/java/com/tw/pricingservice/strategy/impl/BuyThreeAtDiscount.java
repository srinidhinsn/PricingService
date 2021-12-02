package com.tw.pricingservice.strategy.impl;

import com.tw.pricingservice.model.ItemQuantityPrice;
import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.strategy.PricingStrategy;

import java.math.BigDecimal;

public class BuyThreeAtDiscount implements PricingStrategy {

    private final BigDecimal DISCOUNT_PERCENTAGE = new BigDecimal(10);
    private int offerOnQuantity = 3;
    public PricingResponse getPricing(String item, BigDecimal quantity, ItemQuantityPrice itemDetails){
        PricingResponse response = new PricingResponse(item);
        int intQuantity = quantity.intValue();
        if (intQuantity >= offerOnQuantity){
            Integer eligableQuantity = (intQuantity / offerOnQuantity)*offerOnQuantity ;
            BigDecimal discount = itemDetails.getPrice().multiply(new BigDecimal(eligableQuantity)).multiply(DISCOUNT_PERCENTAGE.divide(new BigDecimal(100)));
            response.setTotalQuantity(quantity);
            response.setTotalPrice(quantity.multiply(itemDetails.getPrice()).subtract(discount));
            response.setOfferApplied("Buy three at 10% off");
        } else {
            response.setTotalQuantity(quantity);
            response.setTotalPrice(quantity.multiply(itemDetails.getPrice()));
        }
        return response;
    }
}
