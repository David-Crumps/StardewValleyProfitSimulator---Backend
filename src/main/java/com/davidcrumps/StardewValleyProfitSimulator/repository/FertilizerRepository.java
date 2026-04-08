package com.davidcrumps.StardewValleyProfitSimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidcrumps.StardewValleyProfitSimulator.model.Fertilizer;


@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
