package com.gsg.gamersync.entity;

import com.gsg.gamersync.dto.GameDtoIn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

    public Game(GameDtoIn gameDtoIn) {
        this.title = gameDtoIn.getTitle();
        this.rating = gameDtoIn.getRating();
    }
}
