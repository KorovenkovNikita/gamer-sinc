package com.gsg.gamersync.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDtoIn {

    private String title;
    private Double rating;
    private List<Long> groupIds;
    private Set<Long> genreIds;
    private List<Long> userIds;
}
