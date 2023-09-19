package com.gsg.gamersync.service;

import com.gsg.gamersync.entity.User;
import com.gsg.gamersync.exeption.GamerSyncException;
import com.gsg.gamersync.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        List<User> users = userRepository.findAllWithGames();
        for (User user : users) {
            for (User userF: userRepository.findAllWithFriends()) {
                if(user.getId().equals(userF.getId())){
                    user.setFriends(userF.getFriends());
                }
            }
            for (User userG: userRepository.findAllWithGroups()) {
                if(user.getId().equals(userG.getId())){
                    user.setGroups(userG.getGroups());
                }
            }
        }
        return users;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new GamerSyncException(HttpStatus.NOT_FOUND, "Cannot find user with id = " + id));
    }
}
