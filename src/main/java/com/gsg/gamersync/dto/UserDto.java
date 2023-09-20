package com.gsg.gamersync.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gsg.gamersync.entity.Gender;
import com.gsg.gamersync.entity.Role;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String username;
    private Role role;
    private Boolean networkStatus;
    private Double rating;
    private String name;
    private String surname;
    private Gender gender;
    private Integer age;
    private List<Long> gameIds;
    private Set<Long> friendIds;
    private List<Long> groupIds;
}
