package com.crmsme.dto;


import com.crmsme.dbo.BusinessAddressEntity;
import com.crmsme.dbo.BusinessEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessAddress {

    private Long id;
    private String address;
    private String country;
    private String state;
    private String city;
    private String pinCode;

    @JsonIgnore
    public BusinessAddressEntity createBusinessAddressEntity(){
        return BusinessAddressEntity.builder()
                .id(id)
                .address(address)
                .pinCode(pinCode)
                .build();
    }

}
