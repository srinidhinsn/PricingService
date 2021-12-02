package com.tw.pricingservice.strategies;

import com.tw.pricingservice.constants.SaleCondition;
import com.tw.pricingservice.controller.LoadData;
import com.tw.pricingservice.controller.PricingController;
import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.strategy.PricingStrategy;
import com.tw.pricingservice.strategy.impl.BuyOneGetOne;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class BuyOneGetOneTest {

    BuyOneGetOne buyOneGetOne = new BuyOneGetOne();

    @Test
    void getPricingTest(){
        LoadData.loadCommonDataForOffer("BUY_ONE_GET_ONE");
        PricingResponse response = buyOneGetOne.getPricing("carrot", new BigDecimal(1),
                SaleCondition.itemsMap.get("carrot"));
        Assert.assertEquals(new BigDecimal(2).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalQuantity().setScale(2,  BigDecimal.ROUND_UP));
        Assert.assertEquals(new BigDecimal(1.2).setScale(2, BigDecimal.ROUND_UP),
                response.getTotalPrice().setScale(2,  BigDecimal.ROUND_UP));
    }


}
