package com.crmsme.services.impl;

import com.crmsme.dbo.UserBusinessMappingEntity;
import com.crmsme.dbo.UserEntity;
import com.crmsme.mapper.RoleMapper;
import com.crmsme.mapper.UserMapper;
import com.crmsme.services.RoleService;
import com.crmsme.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    RoleMapper roleMapper;


    @Override
    public Long getRoleIdByName(String roleName) {

        return roleMapper.getRoleIdByName(roleName);
    }

    @Override
    public String getRoleNameById(Long id) {
        return null;
    }
}
