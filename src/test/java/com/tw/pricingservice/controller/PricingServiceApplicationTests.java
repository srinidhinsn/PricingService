package com.tw.pricingservice.controller;

import com.tw.pricingservice.constants.SaleCondition;
import com.tw.pricingservice.controller.PricingController;
import com.tw.pricingservice.model.PricingResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class PricingServiceApplicationTests {

    @Autowired
    PricingController pricingController;

    @Test
    void addItemFromControllerTest(){
        pricingController.addItem("carrot","1.2");
        Assert.assertTrue(true);
    }

    @Test
    void addOfferFromControllerTest(){
        pricingController.addOffers("carrot", "2021-11-01", "2021-12-30","BUY_TWO_GET_ONE");
        Assert.assertTrue(true);
    }

    @Test
    void getPricingFromControllerTest(){
        ModelAndView modelAndView = new ModelAndView();
        LoadData.loadCommonData();
        modelAndView = pricingController.getPricing("carrot","2", modelAndView);
        List<PricingResponse> responseList = (List<PricingResponse>) modelAndView.getModel().get("response");
        PricingResponse response = responseList.get(0);
        Assert.assertEquals(response.getTotalQuantity(), new BigDecimal(3));
    }
}
