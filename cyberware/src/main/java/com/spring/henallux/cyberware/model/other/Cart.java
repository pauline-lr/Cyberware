package com.spring.henallux.cyberware.model.other;

import com.spring.henallux.cyberware.model.main.Item;
import com.spring.henallux.cyberware.model.main.PurchaseLine;

import java.util.HashMap;

public class Cart {
    private HashMap<Integer, PurchaseLine> cart = new HashMap<>();

    public Cart() {}

    public HashMap<Integer, PurchaseLine> getCart() {
        return cart;
    }

    public void setCart(HashMap<Integer, PurchaseLine> cart) {
        this.cart = cart;
    }

    public void addCartLine(Item item, Integer quantity) {
        PurchaseLine purchaseLine;
        Integer itemIdentifier = item.getIdentifier();
        PurchaseLine cartLine = cart.get(itemIdentifier);
        if (cartLine == null) {
            Item itemToAdd = new Item(item.getIdentifier(), item.getName(), item.getPrice(),
                    item.getDescription(), item.getImageName(), item.getCategory());
            purchaseLine = new PurchaseLine(item.getPrice(), quantity, itemToAdd);
            cart.put(itemIdentifier, purchaseLine);
        } else {
            purchaseLine = cartLine;
            int finalQuantity = purchaseLine.getRequestedQuantity() + quantity;
            purchaseLine.setRequestedQuantity(Math.min(finalQuantity, 100));
            cart.replace(itemIdentifier, purchaseLine);
        }
        discountManager();
    }

    public void deleteCartLine(Integer itemIdentifier) {
        cart.remove(itemIdentifier);
        discountManager();
    }

    public void addOneToItemQuantity(Integer itemIdentifier) {
        PurchaseLine cartLine = cart.get(itemIdentifier);
        Integer quantity = cartLine.getRequestedQuantity();
        if (quantity < 100) {
            cartLine.setRequestedQuantity(quantity + 1);
            cart.replace(itemIdentifier, cartLine);
        }
        discountManager();
    }

    public void removeOneToItemQuantity(Integer itemIdentifier) {
        PurchaseLine cartLine = cart.get(itemIdentifier);
        Integer quantity = cartLine.getRequestedQuantity();
        if (quantity < 2) {
            this.deleteCartLine(itemIdentifier);
        } else {
            cartLine.setRequestedQuantity(quantity - 1);
            cart.replace(itemIdentifier, cartLine);
        }
        discountManager();
    }

    public Boolean isDiscounted() {
        return this.getInitialTotalPrice() >= Constant.AMOUNT_REQUIRED_DISCOUNT;
    }

    private Double setDiscount(Double itemPrice) {
        return itemPrice * Constant.DISCOUNT_RATIO;
    }

    private void discountManager() {
        if (isDiscounted()) {
            for (Integer cartLineKey : cart.keySet()) {
                PurchaseLine cartLine = cart.get(cartLineKey);
                if (cartLine.getItemPrice().doubleValue() == cartLine.getItem().getPrice().doubleValue()) {
                    cartLine.setItemPrice(setDiscount(cartLine.getItem().getPrice()));
                    cart.replace(cartLineKey, cartLine);
                }
            }
        } else {
            for (Integer cartLineKey : cart.keySet()) {
                PurchaseLine cartLine = cart.get(cartLineKey);
                if (cartLine.getItemPrice().doubleValue() != cartLine.getItem().getPrice().doubleValue()) {
                    cartLine.setItemPrice(cartLine.getItem().getPrice());
                    cart.replace(cartLineKey, cartLine);
                }
            }
        }
    }

    public Double getInitialTotalPrice() {
        double total = 0;
        for (PurchaseLine cartLine : cart.values()) {
            total += cartLine.getRequestedQuantity() * cartLine.getItem().getPrice();
        }
        return total;
    }

    public String getInitialTotalPriceDisplayFormat() {
        return Display.priceDisplayFormat(this.getInitialTotalPrice());
    }

    public Double getFinalTotalPrice() {
        double total = 0;
        for (PurchaseLine cartLine : cart.values()) {
            total += cartLine.getRequestedQuantity() * cartLine.getItemPrice();
        }
        return total;
    }

    public String getFinalTotalPriceDisplayFormat() {
        return Display.priceDisplayFormat(this.getFinalTotalPrice());
    }

    public Double getAmountSaved() {
        return getInitialTotalPrice() - getFinalTotalPrice();
    }

    public String getAmountSavedDisplayFormat() {
        return Display.priceDisplayFormat(this.getAmountSaved());
    }
}