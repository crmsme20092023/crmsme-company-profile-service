package com.crmsme.mapper;

import com.crmsme.dbo.BusinessEntity;
import com.crmsme.dbo.UserBusinessMappingEntity;
import com.crmsme.dbo.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("Insert into user_details(" +
            "email_id" +
            ",user_name " +
            ")" +
            " values( " +
            " #{emailId}" +
            ", #{userName}" +
            ")")
    @Options(useGeneratedKeys = true, keyColumn = "ID",keyProperty = "id")
    public  Long insertUserDetails(UserEntity userEntity);


    @Insert("Insert into business_user_role_mapping" +
            "(" +
            "business_id" +
            ",user_id" +
            ",role_id" +
            ")" +
            " values( " +
            " #{businessId}" +
            ", #{userId}" +
            ", #{roleId}" +
            ")")
    @Options(useGeneratedKeys = true, keyColumn = "ID",keyProperty = "id")
    public  Long insertUserBusinessMapping(UserBusinessMappingEntity userBusinessMappingEntity);


    @Select("Select id from user_details where email_id = #{emailId}")
//    @Options(useGeneratedKeys = true, keyColumn = "ID",keyProperty = "id")
    public  Long getIdByEmailId(String emailId);



}
