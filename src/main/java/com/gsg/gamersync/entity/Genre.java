package com.gsg.gamersync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private GenreTitle title;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
    private Set<Game> games;
}
