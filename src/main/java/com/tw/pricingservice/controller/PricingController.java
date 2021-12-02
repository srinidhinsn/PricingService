package com.tw.pricingservice.controller;

import com.tw.pricingservice.constants.SaleCondition;
import com.tw.pricingservice.model.ItemQuantityPrice;
import com.tw.pricingservice.model.Offers;
import com.tw.pricingservice.model.PricingResponse;
import com.tw.pricingservice.service.StrategyDecider;
import com.tw.pricingservice.strategy.PricingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PricingController {

    @Autowired
    private StrategyDecider strategyDecider;

    private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(value = "/{item}/{quantity}")
    public ModelAndView getPricing(@PathVariable("item") String item,
                             @PathVariable("quantity") String quantity,
                             ModelAndView modelAndView){

        BigDecimal quantityOfItem = new BigDecimal(quantity);
        List<PricingResponse> response = new ArrayList<>();
        List<PricingStrategy> pricingStrategyList = strategyDecider.decidePricingStrategy(item);
        pricingStrategyList.forEach(pricingStrategy -> {
            response.add(pricingStrategy.getPricing(item, quantityOfItem, SaleCondition.itemsMap.get(item)));
        });

        response.forEach(responseItem -> {
            System.out.println("Item - "+responseItem.getItem());
            System.out.println("Offer applied - "+responseItem.getOfferApplied());
            System.out.println("Total Quantity - "+responseItem.getTotalQuantity());
            System.out.println("Total Price - "+responseItem.getTotalPrice().setScale(2, BigDecimal.ROUND_UP));
        });

        modelAndView.addObject("response",response);
        modelAndView.setViewName("/result");
        return modelAndView;
    }

    @RequestMapping(value = "/")
    public String getHome(ModelMap map, HttpServletRequest request){
        System.out.println("Success");
        map.addAttribute("price","quantity");
        request.setAttribute("price","quantity");
        return "/index";
    }

    @RequestMapping(value = "/{item}/{validFrom}/{validTill}/{offer}")
    public String addOffers(@PathVariable("item") String item,
                            @PathVariable("validFrom") String validFrom,
                            @PathVariable("validTill") String validTill,
                            @PathVariable("offer") String offer){
        try {
            Offers offer1 = new Offers(item, fmt.parse(validFrom),
                    fmt.parse(validTill), offer);
            if (SaleCondition.itemStrategy.containsKey(item)){
                List<Offers> offers = SaleCondition.itemStrategy.get(item);
                Boolean offerExists = false;
                for(Offers offerItem: offers){
                    if(offerItem.equals(offer1)){
                        offerExists = true;
                        break;
                    }
                }
                if (!offerExists){
                    offers.add(offer1);
                }
            } else {
                List<Offers> offers = new ArrayList<>();
                offers.add(offer1);
                SaleCondition.itemStrategy.put(item, offers);
            }
            System.out.println("offer added to item");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/result";
    }

    @RequestMapping(value = "/add/{item}/{price}")
    public String addItem(@PathVariable("item") String item,
                            @PathVariable("price") String price){
        SaleCondition.itemsMap.put(item, new ItemQuantityPrice(item, new BigDecimal(1),
                new BigDecimal(price)));
        System.out.println("Item added with price");
        return "/result";
    }
}
