package com.gsg.gamersync.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class GamerSyncException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String errorMessage;
}
