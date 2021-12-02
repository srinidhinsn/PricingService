package com.tw.pricingservice.strategies;

import com.tw.pricingservice.constants.SaleCondition;
import com.tw.pricingservice.controller.LoadData;
import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.strategy.impl.DefaultPrice;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class DefaultPriceTest {

    DefaultPrice defaultPrice = new DefaultPrice();

    @Test
    void getDefaultPricing(){
        LoadData.loadCommonDataForOffer("DEFAULT_PRICE");
        PricingResponse response = defaultPrice.getPricing("carrot", new BigDecimal(5),
                SaleCondition.itemsMap.get("carrot"));
        Assert.assertEquals(new BigDecimal(5).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalQuantity().setScale(2,  BigDecimal.ROUND_UP));
        Assert.assertEquals(new BigDecimal(6).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalPrice().setScale(2,  BigDecimal.ROUND_UP));
    }
}
