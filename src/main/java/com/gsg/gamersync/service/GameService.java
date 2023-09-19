package com.gsg.gamersync.service;

import com.gsg.gamersync.dto.GameDtoIn;
import com.gsg.gamersync.entity.Game;
import com.gsg.gamersync.exeption.GamerSyncException;
import com.gsg.gamersync.repository.GameRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class GameService {

    private final GameRepository gameRepository;
    private final GroupService groupService;
    private final GenreService genreService;
    private final UserService userService;

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id)
            .orElseThrow(() -> new GamerSyncException(HttpStatus.NOT_FOUND, "Cannot find game with id = " + id));
    }

    public Game createGame(GameDtoIn gameDtoIn) {
        return gameRepository.save(new Game(gameDtoIn, gameDtoIn.getGroupIds().stream().map(groupService::getGroupById).toList(),
            gameDtoIn.getGenreIds().stream().map(genreService::getGenreById).collect(Collectors.toSet()),
            gameDtoIn.getUserIds().stream().map(userService::getUserById).toList()));
    }
}
