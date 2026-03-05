package com.davidcrumps.StardewValleyProfitSimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidcrumps.StardewValleyProfitSimulator.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}
