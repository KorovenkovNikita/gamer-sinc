package com.gsg.gamersync.service;

import com.gsg.gamersync.entity.Genre;
import com.gsg.gamersync.entity.GenreTitle;
import com.gsg.gamersync.entity.view.GenreView;
import com.gsg.gamersync.exeption.GamerSyncException;
import com.gsg.gamersync.repository.GenreRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class GenreService {

    private final GenreRepository genreRepository;

    @Transactional
    @EventListener(ContextRefreshedEvent.class)
    public void updateAllAvailableGenres() {
        genreRepository.deleteByIds(genreRepository.findAllGenres().stream().filter(genreView ->
            !Arrays.stream(GenreTitle.values()).map(Enum::name).toList().contains(genreView.getTitle())).map(GenreView::getId).toList());
        genreRepository.saveAll(Arrays.stream(GenreTitle.values())
            .map(Genre::new)
            .filter(genre -> genreRepository.findAll().stream().noneMatch(g -> g.getTitle().equals(genre.getTitle())))
            .collect(Collectors.toList()));
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElseThrow(() -> new GamerSyncException(HttpStatus.NOT_FOUND, "Cannot find genre with id = " + id));
    }
}

