package com.spring.henallux.cyberware.dataAccess.dataAccessObject;

import com.spring.henallux.cyberware.dataAccess.entity.ItemEntity;
import com.spring.henallux.cyberware.dataAccess.repository.ItemRepository;
import com.spring.henallux.cyberware.dataAccess.utility.ModelEntityConverter;
import com.spring.henallux.cyberware.model.main.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class ItemDataAccess implements ItemDAO {
    private ItemRepository itemRepository;
    private ModelEntityConverter converter;

    @Autowired
    public ItemDataAccess(ItemRepository itemRepository, ModelEntityConverter converter) {
        this.itemRepository = itemRepository;
        this.converter = converter;
    }

    public ArrayList<Item> getAllItems() {
        ArrayList<Item> items = new ArrayList<>();
        for (ItemEntity itemEntity : itemRepository.findAllByOrderByName()) {
            items.add(converter.itemEntityToItemModel(itemEntity));
        }
        return items;
    }

    public ArrayList<Item> getAllItemsByCategoryIdentifier(Integer categoryIdentifier) {
        ArrayList<Item> itemsByCategory = new ArrayList<>();
        for (ItemEntity itemEntity : itemRepository.findAllByCategoryIdentifier(categoryIdentifier)) {
            itemsByCategory.add(converter.itemEntityToItemModel(itemEntity));
        }
        return itemsByCategory;
    }

    public Item getItemByIdentifier(Integer itemIdentifier) {
        ItemEntity itemEntity = itemRepository.findByIdentifier(itemIdentifier);
        return converter.itemEntityToItemModel(itemEntity);
    }
}