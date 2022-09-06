package com.spring.henallux.cyberware.dataAccess.dataAccessObject;

import com.spring.henallux.cyberware.dataAccess.entity.PurchaseEntity;
import com.spring.henallux.cyberware.dataAccess.repository.PurchaseRepository;
import com.spring.henallux.cyberware.dataAccess.utility.ModelEntityConverter;
import com.spring.henallux.cyberware.model.main.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseDataAccess implements PurchaseDAO {
    private PurchaseRepository purchaseRepository;
    private ModelEntityConverter converter;

    @Autowired
    public PurchaseDataAccess(PurchaseRepository purchaseRepository, ModelEntityConverter converter) {
        this.purchaseRepository = purchaseRepository;
        this.converter = converter;
    }

    public Purchase savePurchase(Purchase purchase) {
        PurchaseEntity purchaseEntity = converter.purchaseModelToPurchaseEntity(purchase);
        purchaseEntity = purchaseRepository.save(purchaseEntity);
        return converter.purchaseEntityToPurchaseModel(purchaseEntity);
    }
}