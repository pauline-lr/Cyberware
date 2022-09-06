package com.spring.henallux.cyberware.dataAccess.repository;

import com.spring.henallux.cyberware.dataAccess.entity.PurchaseLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseLineRepository extends JpaRepository<PurchaseLineEntity, Integer> {}