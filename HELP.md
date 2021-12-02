#How to add new Strategies?
1. Create a strategy class which implements PricingStrategy Interface and place it under package com.tw.pricingservice.strategy.impl

2. Register your offername in StrategyEnum along with creation of instance to the new strategy
   ex:  
   else if (StrategyEnum.BUY_ONE_GET_ONE.name().equalsIgnoreCase(e)){
   pricingStrategy = new BuyOneGetOne();
   }

#How to run
### Run spring boot application and use links below
* [Add item http://localhost:8080/add/{item}/{price}](http://localhost:8080/add/pen/1)
  
  As a standard quantity is taken as 1 pound by default for adding item.
  

* [Add offer to the item http://localhost:8080/{item}/{validFrom yyyy-MM-dd}/{validTill yyyy-MM-dd}/{offer - BUY_ONE_GET_ONE}](http://localhost:8080/pen/2021-11-01/2021-12-30/BUY_ONE_GET_ONE)
  

* [Get item price http://localhost:8080/{item}/{quantity}](http://localhost:8080/pen/1)
  Customer can purchase even 4 ounce by prividing quantiy to buy as 0.25



