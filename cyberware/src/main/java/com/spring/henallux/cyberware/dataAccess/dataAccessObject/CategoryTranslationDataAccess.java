package com.spring.henallux.cyberware.dataAccess.dataAccessObject;

import com.spring.henallux.cyberware.dataAccess.entity.CategoryTranslationEntity;
import com.spring.henallux.cyberware.dataAccess.repository.CategoryTranslationRepository;
import com.spring.henallux.cyberware.dataAccess.utility.ModelEntityConverter;
import com.spring.henallux.cyberware.model.main.CategoryTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@Transactional
public class CategoryTranslationDataAccess implements CategoryTranslationDAO {
    private CategoryTranslationRepository categoryTranslationRepository;
    private ModelEntityConverter converter;

    @Autowired
    public CategoryTranslationDataAccess(CategoryTranslationRepository categoryTranslationRepository, ModelEntityConverter converter) {
        this.categoryTranslationRepository = categoryTranslationRepository;
        this.converter = converter;
    }

    public HashMap<Integer, CategoryTranslation> getAllCategoryTranslationsByLanguageName(String languageName) {
        HashMap<Integer, CategoryTranslation> categoryTranslations = new HashMap<>();
        for (CategoryTranslationEntity categoryTranslationEntity: categoryTranslationRepository.findAllByLanguageName(languageName)) {
            CategoryTranslation categoryTranslation = converter.categoryTranslationEntityToCategoryTranslationModel(categoryTranslationEntity);
            categoryTranslations.put(categoryTranslation.getCategory().getIdentifier(), categoryTranslation);
        }
        return categoryTranslations;
    }

    public CategoryTranslation getCategoryTranslationByCategoryIdentifier(Integer categoryIdentifier, String languageName) {
        CategoryTranslationEntity categoryTranslationEntity = categoryTranslationRepository.findByCategoryIdentifierAndLanguageName(categoryIdentifier, languageName);
        return converter.categoryTranslationEntityToCategoryTranslationModel(categoryTranslationEntity);
    }
}