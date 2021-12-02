package com.tw.pricingservice.constants;

import com.tw.pricingservice.model.ItemQuantityPrice;
import com.tw.pricingservice.model.Offers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is to setup initial data. In real time this would fetch data from DB or config
 */
public class SaleCondition {
    public static Map<String, ItemQuantityPrice> itemsMap = new HashMap<>();
    public static Map<String, List<Offers>> itemStrategy = new HashMap<>();
    public static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

    public SaleCondition() {
        try {
            setupItemMap();
            setupConditions();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  To simplify weight unit calculations -
     *  Quantity 1 is 16 ounce. Quantity 0.25 pounds is 4 ounce.
     */
    private void setupItemMap(){
        itemsMap.put("bean", new ItemQuantityPrice("bean",new BigDecimal(1),new BigDecimal(0.65)));
        itemsMap.put("pepsi", new ItemQuantityPrice("pepsi",new BigDecimal(1),new BigDecimal(0.5)));
        itemsMap.put("coke", new ItemQuantityPrice("coke",new BigDecimal(1),new BigDecimal(0.5)));
        itemsMap.put("tomato", new ItemQuantityPrice("tomato",new BigDecimal(1),new BigDecimal(0.4)));
        itemsMap.put("onion", new ItemQuantityPrice("onion",new BigDecimal(1),new BigDecimal(0.8)));
    }

    private void setupConditions() throws ParseException {
        List<Offers> beanOffers = new ArrayList<>();
        Offers beanOffer1 = new Offers("bean", fmt.parse ("2021-11-01"),
                fmt.parse("2021-12-30"), StrategyEnum.BUY_TWO_GET_ONE.name());
        beanOffers.add(beanOffer1);
        itemStrategy.put("bean", beanOffers);

        List<Offers> tomatoOffers = new ArrayList<>();
        Offers tomatoOffer1 = new Offers("tomato",  fmt.parse ("2021-11-01"),
                fmt.parse ("2021-12-30"), StrategyEnum.BUY_ONE_GET_ONE.name());
        Offers tomatoOffer2 = new Offers("tomato",  fmt.parse ("2021-11-01"),
                fmt.parse ("2021-11-30"), StrategyEnum.BUY_THREE_AT_DISCOUNT.name());
        tomatoOffers.add(tomatoOffer1);
        tomatoOffers.add(tomatoOffer2);
        itemStrategy.put("tomato", tomatoOffers);

        List<Offers> pepsiOffers = new ArrayList<>();
        Offers pepsiOffer1 = new Offers("pepsi", fmt.parse ("2021-11-01"),
                fmt.parse ("2021-12-30"), StrategyEnum.BUY_TWO_GET_ONE.name());
        pepsiOffers.add(pepsiOffer1);
        itemStrategy.put("pepsi", pepsiOffers);

        List<Offers> cokeOffers = new ArrayList<>();
        Offers cokeOffer1 = new Offers("coke", fmt.parse ("2021-11-01"),
                fmt.parse ("2021-12-30"), StrategyEnum.BUY_ONE_GET_ONE.name());
        cokeOffers.add(cokeOffer1);
        itemStrategy.put("coke", cokeOffers);
    }
}
