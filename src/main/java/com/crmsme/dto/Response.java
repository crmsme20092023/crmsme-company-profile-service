package com.crmsme.dto;

import com.crmsme.enums.ResponseStatus;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T>{
    private T data;
    private ResponseStatus status;
    private String message;
    private String errorCode;
    private String errorDetails;
    private String uriPath;
}
