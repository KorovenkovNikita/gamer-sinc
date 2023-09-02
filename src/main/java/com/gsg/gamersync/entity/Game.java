package com.gsg.gamersync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    private List<String> genres;
    private Double rating;
    @ElementCollection
    private Map<User, String> comments;
}
