package com.spring.henallux.cyberware.model.other;

import java.util.Locale;

public class Display {
    public static String priceDisplayFormat(Double price) {
        return String.format(Locale.US, "%,.2f", price) + " $";
    }
}
