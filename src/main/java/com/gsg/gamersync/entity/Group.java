package com.gsg.gamersync.entity;

import com.gsg.gamersync.dto.GroupDtoIn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "`group`")
@NoArgsConstructor
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

    public Group(GroupDtoIn groupDtoIn) {
        this.title = groupDtoIn.getTitle();
    }
}
