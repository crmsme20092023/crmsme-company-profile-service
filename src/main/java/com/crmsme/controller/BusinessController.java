package com.crmsme.controller;

import com.crmsme.constant.CONSTANT_PROPERTIES;
import com.crmsme.constant.Constant;
import com.crmsme.dbo.UserBusinessMappingEntity;
import com.crmsme.dbo.UserEntity;
import com.crmsme.dto.BusinessRequestDto;
import com.crmsme.global.dto.Response;
import com.crmsme.global.enums.ResponseStatus;
import com.crmsme.services.BusinessService;
import com.crmsme.services.RoleService;
import com.crmsme.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Slf4j
@RestController
@RequestMapping(Constant.BASE_URL)
public class BusinessController {

    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    BusinessService businessService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @PostMapping(Constant.CREATE_BUSINESS)
    public Response createBusiness(@Validated  @RequestBody BusinessRequestDto businessRequestDto, @RequestHeader("user_name") String username){




            log.info("Create Business Controller Start");

//            if(username!=null) {
//                throw new GenericException("Username test");
//            }

            log.info("username Header Value: '{}' ", username);

            /** Create New Business : Insert into Business Details**/
            long businessId = businessService.createBusinessDetails(businessRequestDto);


            /***Insert Business Address ***/

            businessService.insertBusinessAddress(businessRequestDto.getBusinessAddress(), businessId);


            /**Create User if it's New **/
            Long userId = userService.getUserIdByEmailId(username);
            if (userId == null || userId < 1) {

                UserEntity userEntity = UserEntity.builder()
                        .emailId(username)
                        .userName(username)
                        .build();

                userId = userService.createUserDetails(userEntity);
            }


            /***Insert User and Business Mapping ***/
            Long roleId = roleService.getRoleIdByName(CONSTANT_PROPERTIES.ROLES.ADMIN);

            log.info("Role ID '{}' ", roleId);

            UserBusinessMappingEntity userBusinessMappingEntity = UserBusinessMappingEntity.builder()
                    .userId(userId)
                    .businessId(businessId)
                    .roleId(roleId)
                    .build();

            userService.insertUserBusinessMapping(userBusinessMappingEntity);


        ;


            /** Request URI by String uri (ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getRequestURI(); ***/

            return Response.builder()
                    .status(ResponseStatus.SUCCESS)
                    .data(businessRequestDto)
                    .timestamp(LocalDateTime.now())
                    .uriPath(httpServletRequest.getRequestURI())
                    .build();


    }
}
