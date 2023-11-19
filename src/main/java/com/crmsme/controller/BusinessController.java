package com.crmsme.controller;

import com.crmsme.constant.Constant;
import com.crmsme.dto.BusinessRequestDto;
import com.crmsme.dto.Response;
import com.crmsme.enums.ResponseStatus;
import com.crmsme.services.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(Constant.BASE_URL)
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @PostMapping(Constant.CREATE_BUSINESS)
    public Response createBusiness( @RequestBody BusinessRequestDto businessRequestDto ){

        log.info("Create Business Controller Start");
        if(businessService.createBusinessDetails(businessRequestDto))
        {
            return Response.builder()
                    .data(businessRequestDto)
                    .message(Constant.SUCCESS)
                    .status(ResponseStatus.SUCCESS)
                    .build();
        }

        return Response.builder()
                .message(Constant.FAILED)
                .status(ResponseStatus.FAIL)
                .build();
    }
}
