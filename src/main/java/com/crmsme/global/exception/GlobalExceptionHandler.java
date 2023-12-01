package com.crmsme.global.exception;

import com.crmsme.global.dto.CustomError;
import com.crmsme.global.dto.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
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
                .status(com.crmsme.global.enums.ResponseStatus.ERROR)
                .error(CustomError.builder()
                        .code(ExceptionConstant.ExceptionCode._400)
                        .description(HttpStatus.BAD_REQUEST.toString().substring(4))
                        .message(valuesList.toString())
                        .type(ExceptionConstant.ExceptionTypes.FIELD_VALIDATION)
                        .build())
                .uriPath(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public Response handleRuntimeException(RuntimeException exception, HttpServletRequest request) {
        // Custom logic to handle runtime exceptions
        String errorMessage =  exception.getMessage();

        return Response.builder()
                .status(com.crmsme.global.enums.ResponseStatus.ERROR)
                .error(CustomError.builder()
                        .code(ExceptionConstant.ExceptionCode._500)
                        .description(HttpStatus.INTERNAL_SERVER_ERROR.toString().substring(4))
                        .message(errorMessage)
                        .type(ExceptionConstant.ExceptionTypes.SYSTEM_ERROR)
                        .build())
                .uriPath(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }


//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(AccessDeniedException.class) // or use your custom unauthorized exception class
//    public Response handleUnauthorizedException(AccessDeniedException exception, HttpServletRequest request) {
//        // Custom logic to handle unauthorized exceptions
//        String errorMessage = "Unauthorized access: " + exception.getMessage();
//
//        return Response.builder()
//                .status(com.crmsme.enums.ResponseStatus.ERROR)
//                .error(CustomError.builder()
//                        .code(ExceptionConstant.ExceptionCode._401)  // 401 for unauthorized
//                        .description(HttpStatus.UNAUTHORIZED.toString().substring(4))
//                        .message(errorMessage)
//                        .type(ExceptionConstant.ExceptionTypes.UNAUTHORIZED)
//                        .build())
//                .uriPath(request.getRequestURI())
//                .build();
//    }



}
