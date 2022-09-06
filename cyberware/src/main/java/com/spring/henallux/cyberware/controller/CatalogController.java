package com.spring.henallux.cyberware.controller;

import com.spring.henallux.cyberware.dataAccess.dataAccessObject.CategoryTranslationDAO;
import com.spring.henallux.cyberware.dataAccess.dataAccessObject.ItemDAO;
import com.spring.henallux.cyberware.model.main.Item;
import com.spring.henallux.cyberware.model.other.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/catalog")
@SessionAttributes({Constant.SESSION_ITEM})
public class CatalogController {
    private ItemDAO itemDAO;
    private CategoryTranslationDAO categoryTranslationDAO;
    private String languageName;

    @Autowired
    public CatalogController(ItemDAO itemDAO, CategoryTranslationDAO categoryTranslationDAO) {
        this.itemDAO = itemDAO;
        this.categoryTranslationDAO = categoryTranslationDAO;
    }

    @ModelAttribute(Constant.SESSION_ITEM)
    public Item item() {
        return new Item();
    }

    @RequestMapping(method = RequestMethod.GET)
    /* model size = 4
     sessionItem
     item : nb items recherchés (soit tous dans la db soit ceux de la category)
     category : null si pas d'id dans l'url
     categoryTranslations (tab de 10)
    */
    public String getCatalogPage(Model model) {
        languageName = LocaleContextHolder.getLocale().getDisplayLanguage();
        model.addAttribute(Constant.ITEMS, itemDAO.getAllItems());
        model.addAttribute(Constant.CATEGORY, null);
        model.addAttribute(Constant.CATEGORY_TRANSLATIONS, categoryTranslationDAO.getAllCategoryTranslationsByLanguageName(languageName));
        return "integrated:catalog";
    }

    // Quand click sur item du catalogue
    @RequestMapping(value = "/{categoryIdentifier}", method = RequestMethod.GET)
    public String getCatalogByCategoryPage(@PathVariable int categoryIdentifier, Model model) {
        languageName = LocaleContextHolder.getLocale().getDisplayLanguage();
        model.addAttribute(Constant.ITEMS, itemDAO.getAllItemsByCategoryIdentifier(categoryIdentifier));
        model.addAttribute(Constant.CATEGORY, categoryTranslationDAO.getCategoryTranslationByCategoryIdentifier(categoryIdentifier, languageName));
        return "integrated:catalog";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String postCatalogForm(@ModelAttribute(value = Constant.SESSION_ITEM) Item sessionItem) {
        sessionItem.setItem(itemDAO.getItemByIdentifier(sessionItem.getIdentifier()));
        return "redirect:/item";
    }
}
