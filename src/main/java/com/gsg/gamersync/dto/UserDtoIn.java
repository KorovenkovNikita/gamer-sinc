package com.gsg.gamersync.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDtoIn {

    private String username;
    private String role;
    private Boolean networkStatus;
    private Double rating;
    private String name;
    private String surname;
    private String gender;
    private Integer age;
}
