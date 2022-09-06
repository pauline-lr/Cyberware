package com.spring.henallux.cyberware.model.main;

import com.spring.henallux.cyberware.model.other.Display;

import javax.validation.constraints.*;

public class PurchaseLine {
    private Integer identifier;
    @NotNull
    @Min(value = 0)
    private Double itemPrice;
    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer requestedQuantity;
    @NotNull
    private Item item;
    @NotNull
    private Purchase purchase;

    public PurchaseLine() {}

    public PurchaseLine(Double itemPrice, Integer requestedQuantity, Item item) {
        setItemPrice(itemPrice);
        setRequestedQuantity(requestedQuantity);
        setItem(item);
    }

    public Integer getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public Double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getRequestedQuantity() {
        return requestedQuantity;
    }
    public void setRequestedQuantity(Integer requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }

    public Purchase getPurchase() {
        return purchase;
    }
    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public String getItemPriceDisplayFormat() {
        return Display.priceDisplayFormat(itemPrice);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        PurchaseLine that = (PurchaseLine) object;
        return (this.identifier.equals(that.identifier)) && (this.itemPrice.equals(that.itemPrice)) &&
                (this.requestedQuantity.equals(that.requestedQuantity)) && (this.item.equals(that.item)) &&
                (this.purchase.equals(that.purchase));
    }
}