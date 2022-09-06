package com.spring.henallux.cyberware.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier", updatable = false, nullable = false)
    private Integer identifier;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "description")
    private String description;
    @Column(name = "image_name")
    private String imageName;
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "identifier")
    private CategoryEntity category;

    public ItemEntity() {}

    public ItemEntity(Integer identifier, String name, Double price, String description, String imageName, CategoryEntity category) {
        setIdentifier(identifier);
        setName(name);
        setPrice(price);
        setDescription(description);
        setImageName(imageName);
        setCategory(category);
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

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
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

    public CategoryEntity getCategory() {
        return category;
    }
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}