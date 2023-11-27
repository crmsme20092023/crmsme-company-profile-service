package com.crmsme.global;


import com.crmsme.dto.Response;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleInvalidArgument(MethodArgumentNotValidException exception, HttpServletRequest request) {
        Map<String, String> map =  new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        List<String> valuesList = new ArrayList<>(map.values());


        return Response.builder()
                .status(com.crmsme.enums.ResponseStatus.ERROR)
                .error(ValidationError.builder()
                        .code(400)
                        .description(HttpStatus.BAD_REQUEST.toString().substring(4))
                        .message(valuesList.toString())
                        .build())
                .uriPath(request.getRequestURI())
                .build();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public Response handleRuntimeException(RuntimeException exception, HttpServletRequest request) {
        // Custom logic to handle runtime exceptions
        String errorMessage = "An unexpected error occurred: " + exception.getMessage();

        return Response.builder()
                .status(com.crmsme.enums.ResponseStatus.ERROR)
                .error(ValidationError.builder()
                        .code(500)
                        .description(HttpStatus.INTERNAL_SERVER_ERROR.toString().substring(4))
                        .message(errorMessage)
                        .build())
                .uriPath(request.getRequestURI())
                .build();
    }



//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
//        Map<String, String> map =  new HashMap<>();
//        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
//            map.put(fieldError.getField(), fieldError.getDefaultMessage());
//        });
//
//        return map;
//
//    }

}
