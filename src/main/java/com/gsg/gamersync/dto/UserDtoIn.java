package com.gsg.gamersync.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gsg.gamersync.entity.Gender;
import com.gsg.gamersync.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDtoIn {

    private String username;
    private Role role;
    private Boolean networkStatus;
    private Double rating;
    private String name;
    private String surname;
    private Gender gender;
    private Integer age;
}
