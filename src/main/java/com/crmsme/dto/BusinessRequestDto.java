package com.crmsme.dto;

import com.crmsme.dbo.BusinessEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    private String businessName;
    private String businessEmailId;
    private String businessContactNumber;
    private String panNumber;
    private String gstNumber;
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
