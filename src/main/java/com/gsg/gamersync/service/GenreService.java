package com.gsg.gamersync.service;

import com.gsg.gamersync.entity.GenreTitle;
import com.gsg.gamersync.entity.view.GenreView;
import com.gsg.gamersync.repository.GenreRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GenreService {
    private final GenreRepository genreRepository;

    @PostConstruct
    public void updateAllAvailableGenres() {
        genreRepository.findAllGenres().stream().filter(genreView ->
                !Arrays.stream(GenreTitle.values()).map(Enum::name).toList().contains(genreView.getTitle())).map(GenreView::getId).forEach(genreRepository::castDelete);
//        genreRepository.saveAll(Arrays.stream(GenreTitle.values())
//                .map(Genre::new)
//                .filter(genre -> genreRepository.findAll().stream().noneMatch(g -> g.getTitle().equals(genre.getTitle())))
//                .collect(Collectors.toList()));
    }
}

