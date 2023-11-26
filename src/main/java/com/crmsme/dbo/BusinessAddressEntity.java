package com.crmsme.dbo;


import com.crmsme.dto.BusinessAddress;
import com.crmsme.dto.BusinessResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessAddressEntity {

    private Long id;
    private String address;
    private Long countryId;
    private Long stateId;
    private Long cityId;
    private String pinCode;



    public BusinessAddress createBusinessAddress(){
        return BusinessAddress.builder()
                .id(id)
                .address(address)
                .pinCode(pinCode)
                .build();
    }


}
