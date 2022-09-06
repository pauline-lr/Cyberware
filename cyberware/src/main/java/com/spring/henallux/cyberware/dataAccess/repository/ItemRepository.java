package com.spring.henallux.cyberware.dataAccess.repository;

import com.spring.henallux.cyberware.dataAccess.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    ArrayList<ItemEntity> findAllByOrderByName();
    ArrayList<ItemEntity> findAllByCategoryIdentifier(Integer category_identifier);
    ItemEntity findByIdentifier(Integer item_identifier);
}