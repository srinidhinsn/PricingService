package com.tw.pricingservice.service;

import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.strategy.PricingStrategy;

import java.math.BigDecimal;
import java.util.List;

public interface StrategyDecider {
    List<PricingStrategy> decidePricingStrategy(String item);
}
