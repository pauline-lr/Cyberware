package com.spring.henallux.cyberware.model.other;

public class Constant {
    public static final String SESSION_CART = "sessionCart";
    public static final String SESSION_ITEM = "sessionItem";
    public static final String SESSION_CATEGORY_TRANSLATION = "sessionCategoryTranslation";
    public static final String CUSTOMER = "customer";
    public static final String ITEM = "item";
    public static final String ITEMS = "items";
    public static final String CATEGORY = "category";
    public static final String CATEGORIES = "categories";
    public static final String CATEGORY_TRANSLATIONS = "categoryTranslations";
    public static final String ITEM_FORM = "itemForm";
    public static final String DISCOUNT = "discount";
    public static final Integer AMOUNT_REQUIRED_DISCOUNT = 100000;
    public static final Integer DISCOUNT_POURCENTAGE = 10;
    public static final Double DISCOUNT_RATIO = 1 - (DISCOUNT_POURCENTAGE / 100.0);
}
