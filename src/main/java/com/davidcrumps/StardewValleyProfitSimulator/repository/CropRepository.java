package com.davidcrumps.StardewValleyProfitSimulator.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.davidcrumps.StardewValleyProfitSimulator.model.Crop;



@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

    @EntityGraph(attributePaths = {"seasons"})
    @Query("SELECT p from Crop p")
    List<Crop> findAllWithSeason();

    @EntityGraph(attributePaths = {"seasons"})
    @Query("SELECT p from Crop p WHERE p.id = :id")
    Optional<Crop> findByIdWithEagerSeason(@Param("id") Long id);
}
