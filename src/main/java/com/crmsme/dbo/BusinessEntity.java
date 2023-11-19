package com.crmsme.dbo;


import com.crmsme.dto.BusinessResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusinessEntity {

    private Long id;
    private String businessId;
    private String businessName;

    private Long businessCategoryId;

    private Long businessTypeId;

    private Long businessRegistrationTypeId;


    private String gstNumber;

    private Long currentBillingProcessId;


    private String panNumber;

    private String termsAndConditionsId;

    private Long signatureId;

    private LocalDateTime createdDateTime;


    @JsonIgnore
public BusinessResponseDto createBusinessResponse(){
    return BusinessResponseDto.builder()
            .id(id)
            .businessId(businessId)
            .businessName(businessName)
            .build();
}
}
