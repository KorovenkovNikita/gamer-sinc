package com.gsg.gamersync.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private GenreTitle title;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
    private Set<Game> games;

    public Genre(GenreTitle title) {
        this.title = title;
    }

}
