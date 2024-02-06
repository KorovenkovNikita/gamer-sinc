package com.gsg.gamersync.entity;

import com.gsg.gamersync.dto.UserDtoIn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

    public User(UserDtoIn userDtoIn) {
        this.username = userDtoIn.getUsername();
        this.role = userDtoIn.getRole();
        this.networkStatus = userDtoIn.getNetworkStatus();
        this.rating = userDtoIn.getRating();
        this.name = userDtoIn.getName();
        this.surname = userDtoIn.getSurname();
        this.gender = userDtoIn.getGender();
        this.age = userDtoIn.getAge();
    }
}
