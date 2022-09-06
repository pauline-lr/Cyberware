package com.spring.henallux.cyberware.controller;

import com.spring.henallux.cyberware.dataAccess.dataAccessObject.CategoryTranslationDAO;
import com.spring.henallux.cyberware.model.main.CategoryTranslation;
import com.spring.henallux.cyberware.model.main.Item;
import com.spring.henallux.cyberware.model.other.Cart;
import com.spring.henallux.cyberware.model.other.Constant;
import com.spring.henallux.cyberware.model.form.ItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/item")
@SessionAttributes({Constant.SESSION_CART, Constant.SESSION_ITEM, Constant.SESSION_CATEGORY_TRANSLATION})
public class ItemController {
    private CategoryTranslationDAO categoryTranslationDAO;

    @Autowired
    public ItemController(CategoryTranslationDAO categoryTranslationDAO) {
        this.categoryTranslationDAO = categoryTranslationDAO;
    }

    @ModelAttribute(Constant.SESSION_CART)
    public Cart cart() {
        return new Cart();
    }

    @ModelAttribute(Constant.SESSION_ITEM)
    public Item item() {
        return new Item();
    }

    @ModelAttribute(Constant.SESSION_CATEGORY_TRANSLATION)
    public CategoryTranslation categoryTranslation() {
        return new CategoryTranslation();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getItemPage(@ModelAttribute(value = Constant.SESSION_CATEGORY_TRANSLATION) CategoryTranslation sessionCategoryTranslation,
                              @ModelAttribute(value = Constant.SESSION_ITEM) Item sessionItem, Model model) {
        int categoryIdentifier = sessionItem.getCategory().getIdentifier();
        String languageName = LocaleContextHolder.getLocale().getDisplayLanguage();
        sessionCategoryTranslation.setCategoryTranslation(categoryTranslationDAO.getCategoryTranslationByCategoryIdentifier(categoryIdentifier, languageName));
        model.addAttribute(Constant.ITEM_FORM, new ItemForm());
        return "integrated:item";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postItemForm(@ModelAttribute(value = Constant.SESSION_ITEM) Item sessionItem,
                               @ModelAttribute(value = Constant.SESSION_CART) Cart sessionCart,
                               @Valid @ModelAttribute(value = Constant.ITEM_FORM) ItemForm itemForm,
                               final BindingResult errors) {
        if (!errors.hasErrors()) {
            sessionCart.addCartLine(sessionItem, itemForm.getQuantity());
            return "redirect:/cart";
        }
        return "integrated:item";
    }
}