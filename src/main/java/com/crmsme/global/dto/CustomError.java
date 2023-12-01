package com.crmsme.global.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomError {

    int code;
    String description;
    String message;
    String type;
    LocalDateTime timestamp;

}
