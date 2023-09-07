package com.gsg.gamersync.repository;

import com.gsg.gamersync.entity.Genre;
import com.gsg.gamersync.entity.view.GenreView;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @NonNull List<Genre> findAll();

    @Query(value = "select id, title from genre", nativeQuery = true)
    List<GenreView> findAllGenres();

    @Modifying
    @Query(value = "delete from genre where id = :myId", nativeQuery = true)
    void castDelete(@Param("myId") Long id);

}

