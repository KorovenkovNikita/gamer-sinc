package com.gsg.gamersync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupDto {
    private Long id;
    private String title;
    private Long gameId;
}
