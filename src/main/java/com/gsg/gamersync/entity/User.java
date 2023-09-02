package com.gsg.gamersync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Boolean networkStatus;
    private Double rating;
    private String name;
    private String surname;
    private String gender;
    private Integer age;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Game> games;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    private List<User> friends;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    private List<Group> groups;
}
