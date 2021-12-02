package com.tw.pricingservice.constants;

import com.tw.pricingservice.model.Offers;
import com.tw.pricingservice.strategy.PricingStrategy;
import com.tw.pricingservice.strategy.impl.BuyOneGetOne;
import com.tw.pricingservice.strategy.impl.BuyThreeAtDiscount;
import com.tw.pricingservice.strategy.impl.BuyTwoGetOne;
import com.tw.pricingservice.strategy.impl.DefaultPrice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public enum StrategyEnum {
    BUY_TWO_GET_ONE, DEFAULT_PRICE, BUY_THREE_AT_DISCOUNT, BUY_ONE_GET_ONE;

    public static PricingStrategy getInstance(String e){
        PricingStrategy pricingStrategy = null;
        if (StrategyEnum.BUY_TWO_GET_ONE.name().equals(e)){
            pricingStrategy = new BuyTwoGetOne();
        } else if (StrategyEnum.BUY_THREE_AT_DISCOUNT.name().equals(e)){
            pricingStrategy = new BuyThreeAtDiscount();
        } else if (StrategyEnum.BUY_ONE_GET_ONE.name().equals(e)){
            pricingStrategy = new BuyOneGetOne();
        } else {
            pricingStrategy = new DefaultPrice();
        }
        return pricingStrategy;
    }

    public static List<PricingStrategy> getInstances(List<Offers> strategyNames){
        List<PricingStrategy> pricingStrategies = new ArrayList<>();
        if (null!= strategyNames && !strategyNames.isEmpty()){
            strategyNames.forEach(strategy -> {
                if (new Date().after(strategy.getValidFrom())
                    && new Date().before(strategy.getValidTill())) {
                    pricingStrategies.add(getInstance(strategy.getOffer()));
                }
            });
        }else {
            pricingStrategies.add(getInstance(""));
        }
        return pricingStrategies;
    }
}
