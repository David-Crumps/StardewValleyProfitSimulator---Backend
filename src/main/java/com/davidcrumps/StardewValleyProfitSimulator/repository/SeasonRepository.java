package com.davidcrumps.StardewValleyProfitSimulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.davidcrumps.StardewValleyProfitSimulator.model.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    @EntityGraph(attributePaths = {"crops"})
    @Query("SELECT p from Season p")
    List<Season> findAllWithCrops();

}
