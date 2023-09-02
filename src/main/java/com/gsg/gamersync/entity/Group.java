package com.gsg.gamersync.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Group {
    @Id
    private Long id;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groupId")
    private List<User> users;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupId")
    private List<User> onlineUsers;
}
