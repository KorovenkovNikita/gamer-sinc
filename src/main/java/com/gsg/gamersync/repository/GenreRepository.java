package com.gsg.gamersync.repository;

import com.gsg.gamersync.entity.Genre;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @NonNull List<Genre> findAll();
}
