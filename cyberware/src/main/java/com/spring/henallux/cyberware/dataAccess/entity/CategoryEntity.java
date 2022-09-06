package com.spring.henallux.cyberware.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier", updatable = false, nullable = false)
    private Integer identifier;
    @Column(name = "description")
    private String description;
    @Column(name = "image_name")
    private String imageName;

    public CategoryEntity() {}

    public CategoryEntity(Integer identifier, String description, String imageName) {
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
}