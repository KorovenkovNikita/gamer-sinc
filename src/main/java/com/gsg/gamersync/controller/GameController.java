package com.gsg.gamersync.controller;

import com.gsg.gamersync.dto.ConverterDto;
import com.gsg.gamersync.dto.GameDto;
import com.gsg.gamersync.dto.GameDtoIn;
import com.gsg.gamersync.service.GameService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GameController {

    private final ConverterDto converterDto;
    private final GameService gameService;

    @GetMapping
    public List<GameDto> getGames() {
        return converterDto.simpleConvert(gameService.getGames(), GameDto.class);
    }

    @GetMapping("/{id}")
    public GameDto getByGameId(@PathVariable Long id) {
        return converterDto.simpleConvert(gameService.getGameById(id), GameDto.class);
    }

    @PostMapping
    public GameDto createGame(@RequestBody GameDtoIn gameDtoIn) {
        return converterDto.simpleConvert(gameService.createGame(gameDtoIn), GameDto.class);
    }
}
