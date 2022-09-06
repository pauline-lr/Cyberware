package com.spring.henallux.cyberware.dataAccess.repository;

import com.spring.henallux.cyberware.dataAccess.entity.CategoryTranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CategoryTranslationRepository extends JpaRepository<CategoryTranslationEntity, Integer> {
    ArrayList<CategoryTranslationEntity> findAllByLanguageName(String language_name);
    CategoryTranslationEntity findByCategoryIdentifierAndLanguageName(Integer category_identifier, String language_name);
}