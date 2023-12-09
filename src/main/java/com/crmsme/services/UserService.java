package com.crmsme.services;

import com.crmsme.dbo.UserBusinessMappingEntity;
import com.crmsme.dbo.UserEntity;
import com.crmsme.dbo.UserFeaturePackageMappingEntity;
import com.crmsme.dto.BusinessRequestDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    public Long createUserDetails(UserEntity userEntity);

    public Long getUserIdByEmailId(String emailId);
    public boolean insertUserBusinessMapping( UserBusinessMappingEntity userBusinessMappingEntity);

    public boolean insertFeaturePackageUserMapping( UserFeaturePackageMappingEntity userFeaturePackageMappingEntity);


}
