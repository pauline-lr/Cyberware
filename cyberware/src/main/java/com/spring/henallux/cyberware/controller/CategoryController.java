package com.spring.henallux.cyberware.controller;

import com.spring.henallux.cyberware.dataAccess.dataAccessObject.CategoryTranslationDAO;
import com.spring.henallux.cyberware.model.other.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    private CategoryTranslationDAO categoryTranslationDAO;

    @Autowired
    public CategoryController(CategoryTranslationDAO categoryTranslationDAO) {
        this.categoryTranslationDAO = categoryTranslationDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    // model = HashMap<Integer, CategoryTranslation>
    // key = categories[10] : 0 à 9
    // value : categoryTranslation
    public String getCategoryPage(Model model) {
        String languageName = LocaleContextHolder.getLocale().getDisplayLanguage();
        model.addAttribute(Constant.CATEGORIES, categoryTranslationDAO.getAllCategoryTranslationsByLanguageName(languageName).values());
        return "integrated:category";
    }
}
