package com.crmsme.controller;

import com.crmsme.constant.Constant;
import com.crmsme.dto.BusinessRequestDto;
import com.crmsme.dto.Response;
import com.crmsme.enums.ResponseStatus;
import com.crmsme.services.BusinessService;
import com.crmsme.services.ConfigDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(Constant.BASE_URL)
public class ConfigDataController {
    @Autowired
    ConfigDataService configDataService;

    @GetMapping(Constant.RETRIEVE_LOV)
    public Response retrieveLOVs( ){

        log.info(" Config Data Controller Start");

        return Response.builder()
                .data(configDataService.getConfigDataAsListOfValues())
                .message(Constant.SUCCESS)
                .status(ResponseStatus.SUCCESS)
                .build();
    }
}
