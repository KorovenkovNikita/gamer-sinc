package com.gsg.gamersync.controller;

import com.gsg.gamersync.dto.ConverterDto;
import com.gsg.gamersync.dto.UserDto;
import com.gsg.gamersync.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

    private final ConverterDto converterDto;
    private final UserService userService;


    @GetMapping
    public List<UserDto> getUsers() {
        return converterDto.convertUsers(userService.getUsers());
    }

    @GetMapping("/{id}")
    public UserDto getByUserId(@PathVariable Long id) {
        return converterDto.simpleConvert(userService.getUserById(id), UserDto.class);
    }
}
