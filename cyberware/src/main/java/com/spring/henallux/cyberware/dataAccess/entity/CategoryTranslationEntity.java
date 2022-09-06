package com.spring.henallux.cyberware.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "category_translation")
public class CategoryTranslationEntity {
    @Id
    @Column(name = "identifier")
    private Integer identifier;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "identifier")
    private CategoryEntity category;
    @ManyToOne
    @JoinColumn(name = "language", referencedColumnName = "identifier")
    private LanguageEntity language;

    public CategoryTranslationEntity() {}

    public CategoryTranslationEntity(Integer identifier, String name, CategoryEntity category, LanguageEntity language) {
        setIdentifier(identifier);
        setName(name);
        setCategory(category);
        setLanguage(language);
    }

    public Integer getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategory() {
        return category;
    }
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public LanguageEntity getLanguage() {
        return language;
    }
    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}