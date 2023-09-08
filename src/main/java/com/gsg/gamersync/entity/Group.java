package com.gsg.gamersync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;
}
