package com.gsg.gamersync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "network_status")
    private Boolean networkStatus;
    private Double rating;
    private String name;
    private String surname;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer age;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Game> games;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> friends;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Group> groups;
}
