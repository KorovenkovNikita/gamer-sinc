package com.gsg.gamersync.controller;

import com.gsg.gamersync.dto.ConverterDto;
import com.gsg.gamersync.dto.GroupDto;
import com.gsg.gamersync.dto.GroupDtoIn;
import com.gsg.gamersync.service.GroupService;
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
@RequestMapping("/api/groups")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GroupController {

    private final ConverterDto converterDto;
    private final GroupService groupService;

    @GetMapping
    public List<GroupDto> getGroups() {
        return converterDto.convertGroups(groupService.getGroups());
    }

    @GetMapping("/{id}")
    public GroupDto getByGroupId(@PathVariable Long id) {
        return converterDto.simpleConvert(groupService.getGroupById(id), GroupDto.class);
    }

    @PostMapping
    public GroupDto createGroup(@RequestBody GroupDtoIn groupDtoIn) {
        return converterDto.simpleConvert(groupService.createGroup(groupDtoIn), GroupDto.class);
    }
}
