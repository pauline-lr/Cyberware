package com.spring.henallux.cyberware.model.main;

import javax.validation.constraints.*;

public class CategoryTranslation {
    private Integer identifier;
    @NotNull
    @Size(min = 1, max = 30)
    private String name;
    @NotNull
    private Category category;
    @NotNull
    private Language language;

    public CategoryTranslation() {}

    public CategoryTranslation(Integer identifier, String name, Category category, Language language) {
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

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }
    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setCategoryTranslation(CategoryTranslation categoryTranslation) {
        setIdentifier(categoryTranslation.getIdentifier());
        setName(categoryTranslation.getName());
        setLanguage(categoryTranslation.getLanguage());
        setCategory(categoryTranslation.getCategory());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        CategoryTranslation that = (CategoryTranslation) object;
        return (this.identifier.equals(that.identifier)) && (this.name.equals(that.name)) &&
                (this.category.equals(that.category)) && (this.language.equals(that.language));
    }
}