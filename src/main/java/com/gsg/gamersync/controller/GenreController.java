package com.gsg.gamersync.controller;

import com.gsg.gamersync.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GenreController {
    private final GenreService genreService;
}
