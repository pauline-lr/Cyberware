package com.spring.henallux.cyberware.dataAccess.dataAccessObject;

import com.spring.henallux.cyberware.model.main.Purchase;

public interface PurchaseDAO {
    Purchase savePurchase(Purchase purchase);
}