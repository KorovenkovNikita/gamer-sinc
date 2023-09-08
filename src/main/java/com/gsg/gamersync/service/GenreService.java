package com.gsg.gamersync.service;

import com.gsg.gamersync.entity.Genre;
import com.gsg.gamersync.entity.GenreTitle;
import com.gsg.gamersync.entity.view.GenreView;
import com.gsg.gamersync.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
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
}

