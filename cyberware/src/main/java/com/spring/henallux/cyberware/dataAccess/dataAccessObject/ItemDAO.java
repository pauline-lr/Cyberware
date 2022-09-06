package com.spring.henallux.cyberware.dataAccess.dataAccessObject;

import com.spring.henallux.cyberware.model.main.Item;

import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<Item> getAllItems();
    ArrayList<Item> getAllItemsByCategoryIdentifier(Integer categoryIdentifier);
    Item getItemByIdentifier(Integer itemIdentifier);
}