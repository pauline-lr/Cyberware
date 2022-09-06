package com.spring.henallux.cyberware.dataAccess.utility;

import com.spring.henallux.cyberware.dataAccess.entity.*;
import com.spring.henallux.cyberware.model.main.*;
import org.springframework.stereotype.Component;

@Component
public class ModelEntityConverter {
    public CategoryEntity categoryModelToCategoryEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setIdentifier(category.getIdentifier());
        categoryEntity.setDescription(category.getDescription());
        categoryEntity.setImageName(category.getImageName());
        return categoryEntity;
    }
    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setIdentifier(categoryEntity.getIdentifier());
        category.setDescription(categoryEntity.getDescription());
        category.setImageName(categoryEntity.getImageName());
        return category;
    }

    public CategoryTranslationEntity categoryTranslationModelToCategoryTranslationEntity(CategoryTranslation categoryTranslation) {
        CategoryTranslationEntity categoryTranslationEntity = new CategoryTranslationEntity();
        categoryTranslationEntity.setIdentifier(categoryTranslation.getIdentifier());
        categoryTranslationEntity.setName(categoryTranslation.getName());
        categoryTranslationEntity.setCategory(categoryModelToCategoryEntity(categoryTranslation.getCategory()));
        categoryTranslationEntity.setLanguage(languageModelToLanguageEntity(categoryTranslation.getLanguage()));
        return categoryTranslationEntity;
    }
    public CategoryTranslation categoryTranslationEntityToCategoryTranslationModel(CategoryTranslationEntity categoryTranslationEntity) {
        CategoryTranslation categoryTranslation = new CategoryTranslation();
        categoryTranslation.setIdentifier(categoryTranslationEntity.getIdentifier());
        categoryTranslation.setName(categoryTranslationEntity.getName());
        categoryTranslation.setCategory(categoryEntityToCategoryModel(categoryTranslationEntity.getCategory()));
        categoryTranslation.setLanguage(languageEntityToLanguageModel(categoryTranslationEntity.getLanguage()));
        return categoryTranslation;
    }

    public CustomerEntity customerModelToCustomerEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setIdentifier(customer.getIdentifier());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setUsername(customer.getUsername());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setAuthorities(AuthorityConverter.authorityCollectionToAuthorityString(customer.getAuthorities()));
        customerEntity.setAccountNonExpired(customer.isAccountNonExpired());
        customerEntity.setAccountNonLocked(customer.isAccountNonLocked());
        customerEntity.setCredentialsNonExpired(customer.isCredentialsNonExpired());
        customerEntity.setEnabled(customer.isEnabled());
        return customerEntity;
    }
    public Customer customerEntityToCustomerModel(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setIdentifier(customerEntity.getIdentifier());
        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setUsername(customerEntity.getUsername());
        customer.setPhoneNumber(customerEntity.getPhoneNumber());
        customer.setAddress(customerEntity.getAddress());
        customer.setPassword(customerEntity.getPassword());
        customer.setAuthorities(customerEntity.getAuthorities());
        customer.setAccountNonExpired(customerEntity.getAccountNonExpired());
        customer.setAccountNonLocked(customerEntity.getAccountNonLocked());
        customer.setCredentialsNonExpired(customerEntity.getCredentialsNonExpired());
        customer.setEnabled(customerEntity.getEnabled());
        return customer;
    }

    public ItemEntity itemModelToItemEntity(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setIdentifier(item.getIdentifier());
        itemEntity.setName(item.getName());
        itemEntity.setPrice(item.getPrice());
        itemEntity.setDescription(item.getDescription());
        itemEntity.setCategory(categoryModelToCategoryEntity(item.getCategory()));
        itemEntity.setImageName(item.getImageName());
        return itemEntity;
    }
    public Item itemEntityToItemModel(ItemEntity itemEntity) {
        Item item = new Item();
        item.setIdentifier(itemEntity.getIdentifier());
        item.setName(itemEntity.getName());
        item.setPrice(itemEntity.getPrice());
        item.setDescription(itemEntity.getDescription());
        item.setCategory(categoryEntityToCategoryModel(itemEntity.getCategory()));
        item.setImageName(itemEntity.getImageName());
        return item;
    }

    public LanguageEntity languageModelToLanguageEntity(Language language) {
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setIdentifier(language.getIdentifier());
        languageEntity.setName(language.getName());
        languageEntity.setImageName(language.getImageName());
        return languageEntity;
    }
    public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        Language language = new Language();
        language.setIdentifier(languageEntity.getIdentifier());
        language.setName(languageEntity.getName());
        language.setImageName(languageEntity.getImageName());
        return language;
    }

    public PurchaseEntity purchaseModelToPurchaseEntity(Purchase purchase) {
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setIdentifier(purchase.getIdentifier());
        purchaseEntity.setPaid(purchase.getPaid());
        purchaseEntity.setDate(purchase.getDate());
        purchaseEntity.setCustomer(customerModelToCustomerEntity(purchase.getCustomer()));
        return purchaseEntity;
    }
    public Purchase purchaseEntityToPurchaseModel(PurchaseEntity purchaseEntity) {
        Purchase purchase = new Purchase();
        purchase.setIdentifier(purchaseEntity.getIdentifier());
        purchase.setPaid(purchaseEntity.getPaid());
        purchase.setDate(purchaseEntity.getDate());
        purchase.setCustomer(customerEntityToCustomerModel(purchaseEntity.getCustomer()));
        return purchase;
    }

    public PurchaseLineEntity purchaseLineModelToPurchaseLineEntity(PurchaseLine purchaseLine) {
        PurchaseLineEntity purchaseLineEntity = new PurchaseLineEntity();
        purchaseLineEntity.setIdentifier(purchaseLine.getIdentifier());
        purchaseLineEntity.setItemPrice(purchaseLine.getItemPrice());
        purchaseLineEntity.setRequestedQuantity(purchaseLine.getRequestedQuantity());
        purchaseLineEntity.setItem(itemModelToItemEntity(purchaseLine.getItem()));
        purchaseLineEntity.setPurchase(purchaseModelToPurchaseEntity(purchaseLine.getPurchase()));
        return purchaseLineEntity;
    }
    public PurchaseLine purchaseLineEntityToPurchaseLineModel(PurchaseLineEntity purchaseLineEntity) {
        PurchaseLine purchaseLine = new PurchaseLine();
        purchaseLine.setIdentifier(purchaseLineEntity.getIdentifier());
        purchaseLine.setItemPrice(purchaseLineEntity.getItemPrice());
        purchaseLine.setRequestedQuantity(purchaseLineEntity.getRequestedQuantity());
        purchaseLine.setItem(itemEntityToItemModel(purchaseLineEntity.getItem()));
        purchaseLine.setPurchase(purchaseEntityToPurchaseModel(purchaseLineEntity.getPurchase()));
        return purchaseLine;
    }
}