package com.crmsme.controller;

import com.crmsme.constant.Constant;
import com.crmsme.global.dto.Response;
import com.crmsme.global.enums.ResponseStatus;
import com.crmsme.services.ConfigDataService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Slf4j
@RestController
@RequestMapping(Constant.BASE_URL)
public class ConfigDataController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    ConfigDataService configDataService;

    @GetMapping(Constant.RETRIEVE_LOV)
    public Response retrieveLOVs( ){

        log.info(" Config Data Controller Start");

        return Response.builder()
                .status(ResponseStatus.SUCCESS)
                .data(configDataService.getConfigDataAsListOfValues())
                .timestamp(LocalDateTime.now())
                .uriPath(httpServletRequest.getRequestURI())
                .build();
    }
}
