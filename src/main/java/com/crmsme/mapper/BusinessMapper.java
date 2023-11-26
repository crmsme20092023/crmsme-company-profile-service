package com.crmsme.mapper;

import com.crmsme.dbo.BusinessAddressEntity;
import com.crmsme.dbo.BusinessEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BusinessMapper {



    @Select("select * from business_details bd "   +
            " where  bd.business_id  = #{businessId}")
   public List<BusinessEntity> retrieveBusinessDetails(String businessId);

    @Insert("Insert into business_details(" +
            "business_name" +
            ", " +
            "business_category_id, " +
            "business_type_id, " +
            "business_registration_type_id, " +
            "gst_number, " +
            "current_billing_process_id, " +
            "pan_number" +
            ",business_id" +
            ",business_email_id"+
            ",business_contact_number"+
            ")" +
            " values( " +
            " #{businessName}" +
            ", #{businessCategoryId}" +
            ", #{businessTypeId}" +
            ", #{businessRegistrationTypeId}" +
            ", #{gstNumber}" +
            ", #{currentBillingProcessId}" +
            ", #{panNumber}" +
            ", #{businessId}" +
            ", #{businessEmailId}" +
            ", #{businessContactNumber}" +
            ")")
    @Options(useGeneratedKeys = true, keyColumn = "ID",keyProperty = "id")
    public  Long insertBusinessDetails(BusinessEntity businessEntity);




    @Insert("Insert into business_details(" +
            "business_name" +
            ", " +
            "business_category_id, " +
            "business_type_id, " +
            "business_registration_type_id, " +
            "gst_number, " +
            "current_billing_process_id, " +
            "pan_number, " +
            "business_id" +
            ")" +
            " values( " +
            " #{businessName}" +
            ", #{businessCategoryId}" +
            ", #{businessTypeId}" +
            ", #{businessRegistrationTypeId}" +
            ", #{gstNumber}" +
            ", #{currentBillingProcessId}" +
            ", #{panNumber}" +
            ", #{businessId}" +
            ")")
    @Options(useGeneratedKeys = true, keyColumn = "ID",keyProperty = "id")
    public  Long insertBusinessAddressDetails(BusinessAddressEntity businessAddressEntity);



}
