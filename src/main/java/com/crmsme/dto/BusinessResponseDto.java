package com.crmsme.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessResponseDto {

    private Long id;
    private String businessId;
    private String businessName;


    private String businessCategoryId;

    private String businessTypeId;

    private String businessRegistrationTypeId;

    private String gstNumber;

    private String currentBillingProcessId;

    private String panNumber;

    private String termsAndConditionsId;

    private String signatureId;

    private LocalDateTime createdDateTime;


}
