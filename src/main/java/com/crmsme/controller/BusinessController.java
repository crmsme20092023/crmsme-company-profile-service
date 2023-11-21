package com.crmsme.controller;

import com.crmsme.constant.Constant;
import com.crmsme.dto.BusinessRequestDto;
import com.crmsme.dto.Response;
import com.crmsme.enums.ResponseStatus;
import com.crmsme.global.HeaderService;
import com.crmsme.services.BusinessService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(Constant.BASE_URL)
public class BusinessController {
    @Autowired
    BusinessService businessService;


//    private final HeaderService headerService;
//
//    @Autowired
//    public BusinessController(HeaderService headerService) {
//        this.headerService = headerService;
//    }



    @PostMapping(Constant.CREATE_BUSINESS)
    public Response createBusiness(@RequestBody BusinessRequestDto businessRequestDto, @RequestHeader("user_name") String username){

        log.info("Create Business Controller Start");

        log.info("Specific Header Value: '{}' " , username);
//        log.info("Specific Header Value: '{}' " , headerService.getUsername());


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
