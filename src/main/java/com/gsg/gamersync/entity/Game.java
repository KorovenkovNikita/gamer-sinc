package com.gsg.gamersync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private Double rating = 0.0;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    private List<Group> groups;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Genre> genres;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;
}
