package com.spring.henallux.cyberware.model.main;

import javax.validation.constraints.*;

public class Category {
    private Integer identifier;
    @Size(max = 400)
    private String description;
    @NotNull
    @Size(min = 1, max = 30)
    private String imageName;

    public Category() {}

    public Category(Integer identifier, String description, String imageName) {
        setIdentifier(identifier);
        setDescription(description);
        setImageName(imageName);
    }

    public Integer getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Category that = (Category) object;
        return (this.identifier.equals(that.identifier)) && (this.description.equals(that.description)) &&
                (this.imageName.equals(that.imageName));
    }
}