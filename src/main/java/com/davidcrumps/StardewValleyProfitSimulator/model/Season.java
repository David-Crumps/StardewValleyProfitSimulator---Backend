package com.davidcrumps.StardewValleyProfitSimulator.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Season {
    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "seasons")
    private Set<Crop> crops = new HashSet<>();
}
