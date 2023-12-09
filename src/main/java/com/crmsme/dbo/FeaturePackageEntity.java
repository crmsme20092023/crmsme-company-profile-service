package com.crmsme.dbo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeaturePackageEntity {

    private Long id;
    private String featureName;
    private String featureDescription;
    private Long pricePerMonth;
    private String status;
    private LocalDateTime dateTime;



}
