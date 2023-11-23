package com.crmsme.dbo;


import com.crmsme.dto.BusinessResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UserEntity {

    private Long id;
    private String emailId;

    private String userName;

    private LocalDateTime createdDateTime;


}
