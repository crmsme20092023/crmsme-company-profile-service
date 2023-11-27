package com.crmsme.dto;

import com.crmsme.dbo.BusinessEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRequestDto {


    private String businessId;
    private String businessType;
    private String businessCategory;
    private String businessRegistrationType;

    @NotEmpty(message = "Business Name is empty")
    private String businessName;

    private String businessEmailId;

    @NotEmpty(message = "Business contact number can not be empty")
    @Length(min = 9,max = 14,message = "Invalid Contact number : length should be 9-14")
    private String businessContactNumber;
    private String panNumber;
    private String gstNumber;

    @NotEmpty(message = "Current billing process can not be empty")
    private String currentBillingProcess;
    private BusinessAddress businessAddress;

    @JsonIgnore
    public BusinessEntity createBusinessEntity() {

      return   BusinessEntity.builder()
                .businessName(businessName)
                .gstNumber(gstNumber)
                .panNumber(panNumber)
                .businessContactNumber(businessContactNumber)
                .businessEmailId(businessEmailId)
                .createdDateTime(LocalDateTime.now())
                .build();


    }
}
