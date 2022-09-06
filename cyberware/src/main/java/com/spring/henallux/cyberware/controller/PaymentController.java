package com.spring.henallux.cyberware.controller;

import com.spring.henallux.cyberware.dataAccess.dataAccessObject.PurchaseDAO;
import com.spring.henallux.cyberware.dataAccess.dataAccessObject.PurchaseLineDAO;
import com.spring.henallux.cyberware.model.main.Customer;
import com.spring.henallux.cyberware.model.main.Purchase;
import com.spring.henallux.cyberware.model.main.PurchaseLine;
import com.spring.henallux.cyberware.model.other.Cart;
import com.spring.henallux.cyberware.model.other.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({Constant.SESSION_CART})
@RequestMapping(value = "/payment")
public class PaymentController {
    private PurchaseDAO purchaseDAO;
    private PurchaseLineDAO purchaseLineDAO;

    @Autowired
    public PaymentController(PurchaseDAO purchaseDAO, PurchaseLineDAO purchaseLineDAO) {
        this.purchaseDAO = purchaseDAO;
        this.purchaseLineDAO = purchaseLineDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getPaymentPage(Authentication authentication,
                                 @ModelAttribute(value = Constant.SESSION_CART) Cart sessionCart) {
        Customer customer = (Customer) authentication.getPrincipal();
        Purchase purchase = purchaseDAO.savePurchase(new Purchase(customer));
        for (PurchaseLine cartLine : sessionCart.getCart().values()) {
            String itemIdentifier = cartLine.getItem().getIdentifier().toString();
            String purchaseIdentifier = purchase.getIdentifier().toString();
            cartLine.setIdentifier(Integer.parseInt(itemIdentifier + purchaseIdentifier));
            cartLine.setPurchase(purchase);
            purchaseLineDAO.savePurchaseLine(cartLine);
        }
        return "integrated:payment";
    }

    @RequestMapping(value = "/successful", method = RequestMethod.GET)
    public String getSuccessfulPaymentPage() {
        return "integrated:successfulPayment";
    }

    @RequestMapping(value = "/cancelled", method = RequestMethod.GET)
    public String getCancelledPaymentPage() {
        return "integrated:cancelledPayment";
    }
}
