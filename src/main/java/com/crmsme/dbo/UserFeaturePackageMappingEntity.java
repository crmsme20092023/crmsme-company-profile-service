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
public class UserFeaturePackageMappingEntity {

    private Long id;
    private Long featurePackageId;
    private Long userId;

    private LocalDateTime dateTime;



}
