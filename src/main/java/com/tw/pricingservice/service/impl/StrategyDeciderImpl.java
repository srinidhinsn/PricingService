package com.tw.pricingservice.service.impl;

import com.tw.pricingservice.constants.SaleCondition;
import com.tw.pricingservice.constants.StrategyEnum;
import com.tw.pricingservice.model.ItemQuantityPrice;
import com.tw.pricingservice.model.Offers;
import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.service.StrategyDecider;
import com.tw.pricingservice.strategy.PricingStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StrategyDeciderImpl implements StrategyDecider {
    SaleCondition testData = new SaleCondition();

    @Override
    public List<PricingStrategy> decidePricingStrategy(String item){
        Map<String, List<Offers>> testStrategies = testData.getItemStrategy();
        List<Offers> strategies = testStrategies.get(item);
        return StrategyEnum.getInstances(strategies);
    }

}
