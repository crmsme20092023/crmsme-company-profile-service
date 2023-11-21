package com.crmsme.dto;

import com.crmsme.dbo.BusinessEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRequestDto {


    private String businessId;
    private String businessName;
    private String businessCategory;
    private String businessType;
    private String businessRegistrationType;
    private String gstNumber;
    private String currentBillingProcess;
    private String panNumber;
    private String signature;


    public BusinessEntity createBusinessEntity() {

      return   BusinessEntity.builder()
                .businessName(businessName)
                .gstNumber(gstNumber)
                .panNumber(panNumber)
                .createdDateTime(LocalDateTime.now())
                .build();


    }
}
