package com.tw.pricingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class LoadData {

    static PricingController pricingController = new PricingController();

    public static void loadCommonData(){
        pricingController.addItem("carrot","1.2");
        pricingController.addOffers("carrot", "2021-11-01", "2021-12-30","BUY_TWO_GET_ONE");
    }

    public static void loadCommonDataForOffer(String offer){
        pricingController.addItem("carrot","1.2");
        pricingController.addOffers("carrot", "2021-11-01", "2021-12-30",offer);
    }
}
