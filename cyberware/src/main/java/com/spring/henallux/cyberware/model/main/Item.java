package com.spring.henallux.cyberware.model.main;

import com.spring.henallux.cyberware.model.other.Display;

import javax.validation.constraints.*;

public class Item {
    private Integer identifier;
    @NotNull
    @Size(min = 1, max = 30)
    private String name;
    @NotNull
    @Min(value = 0)
    private Double price;
    @Size(max = 400)
    private String description;
    @NotNull
    @Size(min = 1, max = 30)
    private String imageName;
    @NotNull
    private Category category;

    public Item() {}

    public Item(Integer identifier, String name, Double price, String description, String imageName, Category category) {
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

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public void setItem(Item item) {
        setIdentifier(item.getIdentifier());
        setName(item.getName());
        setPrice(item.getPrice());
        setDescription(item.getDescription());
        setImageName(item.getImageName());
        setCategory(item.getCategory());
    }

    public String getPriceDisplayFormat() {
        return Display.priceDisplayFormat(price);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Item that = (Item) object;
        return (this.identifier.equals(that.identifier)) && (this.name.equals(that.name)) &&
                (this.price.equals(that.price)) && (this.imageName.equals(that.imageName)) &&
                (this.category.equals(that.category));
    }
}