package com.spring.henallux.cyberware.dataAccess.dataAccessObject;

import com.spring.henallux.cyberware.model.main.CategoryTranslation;

import java.util.HashMap;

public interface CategoryTranslationDAO {
    CategoryTranslation getCategoryTranslationByCategoryIdentifier(Integer categoryIdentifier, String languageName);
    HashMap<Integer, CategoryTranslation> getAllCategoryTranslationsByLanguageName(String languageName);
}