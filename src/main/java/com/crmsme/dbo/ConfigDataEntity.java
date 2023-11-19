package com.crmsme.dbo;


import com.crmsme.dto.BusinessResponseDto;
import com.crmsme.dto.ConfigDataResponseDto;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ConfigDataEntity {

    private Long id;
    private String category;
    private String name;
    private String value;
    private String label;
    private LocalDateTime createdDateTime;


    public ConfigDataResponseDto createBusinessResponse() {

       return  ConfigDataResponseDto.builder()
                .category(category)
                .name(name)
                .value(value)
                .label(label)
                .id(id)
                .build();

    }
}
