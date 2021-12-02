package com.tw.pricingservice.strategies;

import com.tw.pricingservice.constants.SaleCondition;
import com.tw.pricingservice.controller.LoadData;
import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.strategy.impl.BuyThreeAtDiscount;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class BuyThreeAtDiscountTest {
    BuyThreeAtDiscount buyThreeAtDiscount = new BuyThreeAtDiscount();

    @Test
    void getPricingForOneItemTest(){
        LoadData.loadCommonDataForOffer("BUY_THREE_AT_DISCOUNT");
        PricingResponse response = buyThreeAtDiscount.getPricing("carrot", new BigDecimal(1),
                SaleCondition.itemsMap.get("carrot"));
        Assert.assertEquals(new BigDecimal(1).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalQuantity().setScale(2,  BigDecimal.ROUND_UP));
        Assert.assertEquals(new BigDecimal(1.2).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalPrice().setScale(2,  BigDecimal.ROUND_UP));
    }

    @Test
    void getPricingForTwoItemTest(){
        LoadData.loadCommonDataForOffer("BUY_THREE_AT_DISCOUNT");
        PricingResponse response = buyThreeAtDiscount.getPricing("carrot", new BigDecimal(2),
                SaleCondition.itemsMap.get("carrot"));
        Assert.assertEquals(new BigDecimal(2).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalQuantity().setScale(2,  BigDecimal.ROUND_UP));
        Assert.assertEquals(new BigDecimal(2.4).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalPrice().setScale(2,  BigDecimal.ROUND_UP));
    }

    @Test
    void getPricingForThreeItemTest(){
        LoadData.loadCommonDataForOffer("BUY_THREE_AT_DISCOUNT");
        PricingResponse response = buyThreeAtDiscount.getPricing("carrot", new BigDecimal(3),
                SaleCondition.itemsMap.get("carrot"));
        Assert.assertEquals(new BigDecimal(3).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalQuantity().setScale(2,  BigDecimal.ROUND_UP));
        Assert.assertEquals(new BigDecimal(3.239).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalPrice().setScale(2,  BigDecimal.ROUND_UP));
    }
}
