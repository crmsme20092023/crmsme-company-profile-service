package com.crmsme.dto;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ConfigDataResponseDto {


    private Long id;
    private String category;
    private String name;
    private String value;
    private String label;


}
