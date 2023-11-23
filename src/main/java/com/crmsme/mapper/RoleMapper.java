package com.crmsme.mapper;

import com.crmsme.dbo.UserBusinessMappingEntity;
import com.crmsme.dbo.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {

    @Select("Select id from role where role_name = #{roleName}")
    @Options(useGeneratedKeys = true, keyColumn = "ID",keyProperty = "id")
    public  Long getRoleIdByName(String roleName);

    @Select("Select role_name from role where id = #{id}")
//    @Options(useGeneratedKeys = true, keyColumn = "ID",keyProperty = "id")
    public  Long getRoleNameById(Long id );




}
