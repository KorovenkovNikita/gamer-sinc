package com.gsg.gamersync.repository;

import com.gsg.gamersync.entity.Group;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query(value = """
        select distinct group from Group group
               left join fetch group.game
               """)
    List<Group> findAllWithGames();
}
