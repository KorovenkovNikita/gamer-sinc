package com.gsg.gamersync.repository;

import com.gsg.gamersync.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = """
        select distinct user from User user
               left join fetch user.games
               """)
    List<User> findAllWithGames();
    @Query(value = """
         select distinct user from User user
                left join fetch user.friends
        """)
    List<User> findAllWithFriends();
    @Query(value = """
        select distinct user from User user
               left join fetch user.groups
               """)
    List<User> findAllWithGroups();
}
