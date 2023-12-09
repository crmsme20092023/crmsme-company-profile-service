package com.crmsme.services.impl;

import com.crmsme.constant.CONSTANT_PROPERTIES;
import com.crmsme.dbo.BusinessEntity;
import com.crmsme.dbo.UserBusinessMappingEntity;
import com.crmsme.dbo.UserEntity;
import com.crmsme.dbo.UserFeaturePackageMappingEntity;
import com.crmsme.dto.BusinessRequestDto;
import com.crmsme.mapper.BusinessMapper;
import com.crmsme.mapper.ConfigDataMapper;
import com.crmsme.mapper.UserMapper;
import com.crmsme.services.BusinessService;
import com.crmsme.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Autowired
    ConfigDataMapper configDataMapper;

    @Override
    public Long createUserDetails(UserEntity userEntity) {

           userMapper.insertUserDetails(userEntity);
        log.info("User ID = '{}' ",userEntity.getId());

        return userEntity.getId();
    }

    @Override
    public boolean insertUserBusinessMapping(UserBusinessMappingEntity userBusinessMappingEntity) {

        userMapper.insertUserBusinessMapping(userBusinessMappingEntity);
        log.info("User Business Mapping ID = '{}' ",userBusinessMappingEntity.getId());

        return true;
    }

    @Override
    public Long getUserIdByEmailId(String emailId) {

        return userMapper.getIdByEmailId(emailId);
    }

    @Override
    public boolean insertFeaturePackageUserMapping(UserFeaturePackageMappingEntity userFeaturePackageMappingEntity) {

        userFeaturePackageMappingEntity.setFeaturePackageId(configDataMapper.getFeatureAndPackageByLabel(CONSTANT_PROPERTIES.FEATURE_PACKAGE.FREE_TRIAL).getId());
        userMapper.insertUserFeaturePackageMapping(userFeaturePackageMappingEntity);
        log.info("User User Feature Package Mapping ID = '{}' ",userFeaturePackageMappingEntity.getId());

        return true;
    }
}
