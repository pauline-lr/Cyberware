package com.spring.henallux.cyberware.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "purchase_line")
public class PurchaseLineEntity {
    @Id
    @Column(name = "identifier")
    private Integer identifier;
    @Column(name = "item_price")
    private Double itemPrice;
    @Column(name = "requested_quantity")
    private Integer requestedQuantity;
    @ManyToOne
    @JoinColumn(name = "item", referencedColumnName = "identifier")
    private ItemEntity item;
    @ManyToOne
    @JoinColumn(name = "purchase", referencedColumnName = "identifier")
    private PurchaseEntity purchase;

    public PurchaseLineEntity() {}

    public PurchaseLineEntity(Integer identifier, Double itemPrice, Integer requestedQuantity, ItemEntity item, PurchaseEntity purchase) {
        setIdentifier(identifier);
        setItemPrice(itemPrice);
        setRequestedQuantity(requestedQuantity);
        setItem(item);
        setPurchase(purchase);
    }

    public Integer getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public Double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getRequestedQuantity() {
        return requestedQuantity;
    }
    public void setRequestedQuantity(Integer requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public ItemEntity getItem() {
        return item;
    }
    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public PurchaseEntity getPurchase() {
        return purchase;
    }
    public void setPurchase(PurchaseEntity purchase) {
        this.purchase = purchase;
    }
}