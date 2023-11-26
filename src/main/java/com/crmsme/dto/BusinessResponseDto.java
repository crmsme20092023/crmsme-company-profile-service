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

}
