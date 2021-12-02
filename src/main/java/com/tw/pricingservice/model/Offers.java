package com.tw.pricingservice.model;

import java.util.Date;

public class Offers {
    private String item;
    private Date validFrom;
    private Date validTill;
    private String offer;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public Offers(String item, Date validFrom, Date validTill, String offer) {
        this.item = item;
        this.validFrom = validFrom;
        this.validTill = validTill;
        this.offer = offer;
    }

    public Offers() {
    }

    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        if (obj instanceof Offers) {
            Offers offers = (Offers) obj;
            if (this.offer.equals(offers.offer) &&
                    this.validFrom.compareTo(offers.validFrom) == 0 &&
                    this.validTill.compareTo(offers.validTill) == 0 &&
                    this.item.equals(offers.item)) {
                return true;
            }
        }
        return false;
    }
}
