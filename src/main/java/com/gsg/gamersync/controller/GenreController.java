package com.gsg.gamersync.controller;

import com.gsg.gamersync.dto.ConverterDto;
import com.gsg.gamersync.dto.GenreDto;
import com.gsg.gamersync.service.GenreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GenreController {

    private final ConverterDto converterDto;
    private final GenreService genreService;


    @GetMapping
    public List<GenreDto> getGenres() {
        return converterDto.simpleConvert(genreService.getGenres(), GenreDto.class);
    }

    @GetMapping("/{id}")
    public GenreDto getByGenreId(@PathVariable Long id) {
        return converterDto.simpleConvert(genreService.getGenreById(id), GenreDto.class);
    }
}
