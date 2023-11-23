package com.crmsme.controller;

import com.crmsme.constant.CONSTANT_PROPERTIES;
import com.crmsme.constant.Constant;
import com.crmsme.dbo.UserBusinessMappingEntity;
import com.crmsme.dbo.UserEntity;
import com.crmsme.dto.BusinessRequestDto;
import com.crmsme.dto.Response;
import com.crmsme.enums.ResponseStatus;
import com.crmsme.services.BusinessService;
import com.crmsme.services.RoleService;
import com.crmsme.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(Constant.BASE_URL)
public class BusinessController {
    @Autowired
    BusinessService businessService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;


    @PostMapping(Constant.CREATE_BUSINESS)
    public Response createBusiness(@RequestBody BusinessRequestDto businessRequestDto, @RequestHeader("user_name") String username){

        log.info("Create Business Controller Start");

        log.info("username Header Value: '{}' " , username);

        Long businessId = businessService.createBusinessDetails(businessRequestDto);

            Long userId = userService.getUserIdByEmailId(username);
            if(userId ==null || userId<1){

                UserEntity userEntity = UserEntity.builder()
                        .emailId(username)
                        .userName(username)
                        .build();

                userId = userService.createUserDetails(userEntity);
            }

            Long roleId = roleService.getRoleIdByName(CONSTANT_PROPERTIES.ROLES.ADMIN);

            log.info("Role ID '{}' ",roleId);

            UserBusinessMappingEntity userBusinessMappingEntity = UserBusinessMappingEntity.builder()
                    .userId(userId)
                    .businessId(businessId)
                    .roleId(roleId)
                    .build();

            userService.insertUserBusinessMapping(userBusinessMappingEntity);

            return Response.builder()
                    .data(businessRequestDto)
                    .message(Constant.SUCCESS)
                    .status(ResponseStatus.SUCCESS)
                    .build();

    }
}
