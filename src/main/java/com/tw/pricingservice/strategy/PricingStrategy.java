package com.tw.pricingservice.strategy;

import com.tw.pricingservice.model.ItemQuantityPrice;
import com.tw.pricingservice.model.PricingResponse;

import java.math.BigDecimal;

public interface PricingStrategy {
    PricingResponse getPricing(String item, BigDecimal quantity, ItemQuantityPrice itemDetails);

}
