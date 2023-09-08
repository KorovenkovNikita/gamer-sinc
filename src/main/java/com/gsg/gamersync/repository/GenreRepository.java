package com.gsg.gamersync.repository;

import com.gsg.gamersync.entity.Genre;
import com.gsg.gamersync.entity.view.GenreView;
import java.util.List;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @NonNull List<Genre> findAll();

    @Query(value = "select id, title from genre", nativeQuery = true)
    List<GenreView> findAllGenres();

    @Modifying
    @Query(value = "delete from genre where id in :ids", nativeQuery = true)
    void deleteByIds(@Param("ids") List<Long> ids);
}

