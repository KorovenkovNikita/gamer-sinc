package com.gsg.gamersync.dto;

import com.gsg.gamersync.entity.Game;
import com.gsg.gamersync.entity.Group;
import com.gsg.gamersync.entity.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ConverterDto {

    private final ModelMapper modelMapper;

    public List<UserDto> convertUsers(List<User> users) {
        return users.stream().map(this::convertUser).toList();
    }

    public UserDto convertUser(User user) {
        UserDto userDto = simpleConvert(user, UserDto.class);
        userDto.setGroupIds(user.getGroups().stream().map(Group::getId).toList());
        userDto.setFriendIds(user.getFriends().stream().map(User::getId).collect(Collectors.toSet()));
        userDto.setGameIds(user.getGames().stream().map(Game::getId).toList());
        return userDto;
    }
    public List<GroupDto> convertGroups(List<Group> groups) {
        return groups.stream().map(this::convertGroup).toList();
    }
    public GroupDto convertGroup(Group group) {
        GroupDto groupDto = simpleConvert(group, GroupDto.class);
        groupDto.setGameId(group.getGame().getId());
        return groupDto;
    }
    public <T> T simpleConvert(Object obj, Class<T> clazz) {
        return modelMapper.map(obj, clazz);
    }

    public <T> List<T> simpleConvert(List<?> entitiesList, Class<T> clazz) {
        return entitiesList.stream().map(x -> simpleConvert(x, clazz)).collect(Collectors.toList());
    }
}