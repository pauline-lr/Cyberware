package com.spring.henallux.cyberware.model.form;

import javax.validation.constraints.*;

public class ItemForm {
    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer quantity;

    public ItemForm() {}

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
