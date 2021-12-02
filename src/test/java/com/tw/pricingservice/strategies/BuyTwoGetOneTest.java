package com.tw.pricingservice.strategies;

import com.tw.pricingservice.constants.SaleCondition;
import com.tw.pricingservice.controller.LoadData;
import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.strategy.impl.BuyTwoGetOne;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class BuyTwoGetOneTest {

    BuyTwoGetOne buyTwoGetOne = new BuyTwoGetOne();

    @Test
    void getPricingForOneItemTest(){
        LoadData.loadCommonDataForOffer("BUY_TWO_GET_ONE");
        PricingResponse response = buyTwoGetOne.getPricing("carrot", new BigDecimal(1),
                SaleCondition.itemsMap.get("carrot"));
        Assert.assertEquals(new BigDecimal(1).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalQuantity().setScale(2,  BigDecimal.ROUND_UP));
        Assert.assertEquals(new BigDecimal(1.2).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalPrice().setScale(2,  BigDecimal.ROUND_UP));
    }

    @Test
    void getPricingForTwoItemTest(){
        LoadData.loadCommonDataForOffer("BUY_TWO_GET_ONE");
        PricingResponse response = buyTwoGetOne.getPricing("carrot", new BigDecimal(2),
                SaleCondition.itemsMap.get("carrot"));
        Assert.assertEquals(new BigDecimal(3).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalQuantity().setScale(2,  BigDecimal.ROUND_UP));
        Assert.assertEquals(new BigDecimal(2.4).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalPrice().setScale(2,  BigDecimal.ROUND_UP));
    }


}
