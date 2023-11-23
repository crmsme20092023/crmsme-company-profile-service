package com.crmsme.services;

import com.crmsme.dto.BusinessRequestDto;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleService {

    public Long getRoleIdByName(String roleName);
    public String getRoleNameById(Long id);

}
