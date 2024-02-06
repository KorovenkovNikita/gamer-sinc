package com.gsg.gamersync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupDtoIn {
    private String title;
    private Long gameId;
}
